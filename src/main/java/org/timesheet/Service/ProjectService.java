package org.timesheet.Service;

import org.timesheet.dto.ProjectDto;
import org.timesheet.dto.TaskDto;

import java.util.List;

public interface ProjectService {

    List<ProjectDto> getProjects(Long employeeId, Long clientId);

    List<TaskDto> getTasks(Long employeeId, Long projectId);
}