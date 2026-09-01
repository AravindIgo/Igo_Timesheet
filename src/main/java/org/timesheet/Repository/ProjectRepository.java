package org.timesheet.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getProjectsByEmployeeAndClient(
            Long employeeId,
            Long clientId) {

        String sql = """
                SELECT DISTINCT
                    PTM.ProjectID AS PID,
                    (PM.ProjectID + '-' + PM.Project_Desc) AS ProjectID
                FROM Project_Task_Master_Res_Tsk PTMRT
                INNER JOIN Project_Task_Master PTM
                    ON PTMRT.Project_Task_ID = PTM.Project_Task_ID
                INNER JOIN ProjectMaster PM
                    ON PTM.ProjectID = PM.ProjectMasterID
                INNER JOIN TaskLinkName_Master TLM
                    ON TLM.TaskNameID = PTMRT.TaskListID
                WHERE PTMRT.EmployeeID = :employeeId
                  AND PM.ClientID = :clientId
                  AND PM.Status = 'In Progress'
                """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("employeeId", employeeId)
                .setParameter("clientId", clientId)
                .getResultList();
    }

    public List<Object[]> getTasksByEmployeeAndProject(
            Long employeeId,
            Long projectId) {

        String sql = """
                SELECT
                    OneTable.TaskListID,
                    ThreeTable.TaskName
                FROM Project_Task_Master_Res_Tsk OneTable
                INNER JOIN Project_Task_Master TwoTable
                    ON TwoTable.Project_Task_ID = OneTable.Project_Task_ID
                INNER JOIN TaskName ThreeTable
                    ON ThreeTable.TaskNameID = OneTable.TaskListID
                WHERE OneTable.EmployeeID = :employeeId
                  AND TwoTable.ProjectID = :projectId
                """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("employeeId", employeeId)
                .setParameter("projectId", projectId)
                .getResultList();
    }
}