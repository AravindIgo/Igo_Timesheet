package org.timesheet.Service.Impl;

import org.timesheet.dto.LoginRequestDto;
import org.timesheet.dto.LoginResponseDto;
import org.timesheet.Model.Login;
import org.timesheet.Repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.timesheet.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto request) {

        Login login = loginRepository
                .findByUsername(request.getUsername())
                .orElse(null);

        if (login == null) {
            return new LoginResponseDto(
                    false,
                    "Invalid username or password",
                    null,
                    null
            );
        }

        if (!login.getPassword().equals(request.getPassword())) {
            return new LoginResponseDto(
                    false,
                    "Invalid username or password",
                    null,
                    null
            );
        }

        return new LoginResponseDto(
                true,
                "Login successful",
                login.getId(),
                login.getUsername()
        );
    }
}
