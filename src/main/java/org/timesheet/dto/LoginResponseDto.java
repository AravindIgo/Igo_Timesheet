package org.timesheet.dto;

public class LoginResponseDto {

    private boolean success;
    private String message;
    private Long userId;
    private String username;

    public LoginResponseDto() {
    }

    public LoginResponseDto(boolean success, String message,
                            Long userId, String username) {
        this.success = success;
        this.message = message;
        this.userId = userId;
        this.username = username;
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
}