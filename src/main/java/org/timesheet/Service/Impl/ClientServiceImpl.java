package org.timesheet.Service.Impl;

import org.timesheet.dto.ClientDto;
import org.timesheet.Repository.ClientRepository;
import org.timesheet.Service.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDto> getClients(Long userId, Long companyId) {

        List<Object[]> results =
                clientRepository.findClientsByEmployeeAndCompany(
                        String.valueOf(userId),
                        companyId
                );

        List<ClientDto> clientList = new ArrayList<>();

        for (Object[] row : results) {

            ClientDto dto = new ClientDto();

            dto.setCustomerId(((Number) row[0]).longValue());
            dto.setCustomerName((String) row[1]);

            clientList.add(dto);
        }

        return clientList;
    }
}