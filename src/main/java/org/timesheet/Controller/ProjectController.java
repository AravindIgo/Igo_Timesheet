package org.timesheet.Controller;

import org.timesheet.Service.ProjectService;
import org.timesheet.dto.ProjectDto;
import org.timesheet.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getProjects(
            @RequestParam Long employeeId,
            @RequestParam Long clientId) {

        return ResponseEntity.ok(
                projectService.getProjects(employeeId, clientId)
        );
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getTasks(
            @RequestParam Long employeeId,
            @RequestParam Long projectId) {

        return ResponseEntity.ok(
                projectService.getTasks(employeeId, projectId)
        );
    }
}