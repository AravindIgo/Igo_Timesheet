package org.timesheet.Service;

import org.timesheet.dto.LoginRequestDto;
import org.timesheet.dto.LoginResponseDto;

public interface LoginService {

    LoginResponseDto login(LoginRequestDto request);
}