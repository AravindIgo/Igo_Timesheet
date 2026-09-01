package org.timesheet.dto;

public class TaskDto {

    private Long taskListId;
    private String taskName;

    public TaskDto() {
    }

    public TaskDto(Long taskListId, String taskName) {
        this.taskListId = taskListId;
        this.taskName = taskName;
    }

    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}