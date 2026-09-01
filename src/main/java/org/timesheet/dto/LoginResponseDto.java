package org.timesheet.dto;

public class LoginResponseDto {

    private boolean success;
    private String message;
    private Long userId;
    private String username;
    private Long companyId;

    public LoginResponseDto() {
    }

    // Existing constructor - keeps your old login code working
    public LoginResponseDto(boolean success,
                            String message,
                            Long userId,
                            String username) {
        this.success = success;
        this.message = message;
        this.userId = userId;
        this.username = username;
    }

    // New constructor with companyId
    public LoginResponseDto(boolean success,
                            String message,
                            Long userId,
                            String username,
                            Long companyId) {
        this.success = success;
        this.message = message;
        this.userId = userId;
        this.username = username;
        this.companyId = companyId;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Long getCompanyId() {
        return companyId;
    }
}