package org.timesheet.Service;

import org.timesheet.dto.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getClients(Long userId, Long companyId);
}