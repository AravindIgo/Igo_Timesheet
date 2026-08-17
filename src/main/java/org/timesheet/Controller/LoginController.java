package org.timesheet.Controller;

import org.timesheet.dto.LoginRequestDto;
import org.timesheet.dto.LoginResponseDto;
import org.timesheet.Service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto request) {

        LoginResponseDto response = loginService.login(request);

        if (!response.isSuccess()) {
            return ResponseEntity.status(401).body(response);
        }

        return ResponseEntity.ok(response);
    }
}
