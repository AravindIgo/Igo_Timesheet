package org.timesheet.Service.Impl;

import org.timesheet.Repository.ProjectRepository;
import org.timesheet.Service.ProjectService;
import org.timesheet.dto.ProjectDto;
import org.timesheet.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> getProjects(
            Long employeeId,
            Long clientId) {

        List<Object[]> results =
                projectRepository.getProjectsByEmployeeAndClient(
                        employeeId,
                        clientId
                );

        List<ProjectDto> projectList = new ArrayList<>();

        for (Object[] row : results) {

            ProjectDto dto = new ProjectDto();

            dto.setProjectId(
                    Long.parseLong(String.valueOf(row[0]))
            );

            dto.setProjectName(
                    String.valueOf(row[1])
            );

            projectList.add(dto);
        }

        return projectList;
    }
    @Override
    public List<TaskDto> getTasks(
            Long employeeId,
            Long projectId) {

        List<Object[]> results =
                projectRepository.getTasksByEmployeeAndProject(
                        employeeId,
                        projectId
                );

        List<TaskDto> taskList = new ArrayList<>();

        for (Object[] row : results) {

            TaskDto dto = new TaskDto();

            dto.setTaskListId(((Number) row[0]).longValue());
            dto.setTaskName((String) row[1]);

            taskList.add(dto);
        }

        return taskList;
    }
}