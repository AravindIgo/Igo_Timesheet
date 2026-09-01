package org.timesheet.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> findClientsByEmployeeAndCompany(
            String employeeId,
            Long companyId) {

        String sql = """
                SELECT CU.CustomerID, CU.CustomerName
                FROM Customer CU
                INNER JOIN OTR_Company CO
                    ON CU.CompanyID = CO.CompanyID
                INNER JOIN CustomerEmployee CE
                    ON CU.CustomerID = CE.CustomerID
                WHERE CE.EmployeeID = :employeeId
                  AND CE.CompanyID = :companyId
                ORDER BY CU.CustomerName ASC
                """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("employeeId", employeeId)
                .setParameter("companyId", companyId)
                .getResultList();
    }
}