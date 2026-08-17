package org.timesheet.Service.Impl;

import org.timesheet.dto.CompanyDto;
import org.timesheet.Repository.CompanyRepository;
import org.timesheet.Service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyDto> getCompanyNames() {

        List<String> companyNames = companyRepository.findAllCompanyNames();

        return companyNames.stream()
                .map(companyName -> {
                    CompanyDto dto = new CompanyDto();
                    dto.setCompanyName(companyName);
                    return dto;
                })
                .toList();
    }
}