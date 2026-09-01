package org.timesheet.Controller;

import org.timesheet.dto.ClientDto;
import org.timesheet.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients(
            @RequestParam Long userId,
            @RequestParam Long companyId) {

        return ResponseEntity.ok(
                clientService.getClients(userId, companyId)
        );
    }
}