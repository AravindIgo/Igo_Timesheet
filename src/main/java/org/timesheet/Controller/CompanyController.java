package org.timesheet.Controller;
import org.timesheet.dto.CompanyDto;
import org.timesheet.Service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/names")
    public ResponseEntity<List<CompanyDto>> getCompanyNames() {

        return ResponseEntity.ok(companyService.getCompanyNames());
    }
}
