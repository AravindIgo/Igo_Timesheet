package org.timesheet.Repository;

import org.timesheet.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = """
            SELECT Companyname
            FROM OTR_Company
            ORDER BY Companyname ASC
            """, nativeQuery = true)
    List<String> findAllCompanyNames();
}