package com.example.apiproject.controller;

import com.example.apiproject.model.Project;
import com.example.apiproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    // Add your code here

    /// Get all projects
    /// GET /api/projects
    /// Returns a list of all projects
    @GetMapping
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    /// Create a project
    /// POST /api/projects
    /// Creates a new project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        project.setCreatedAt(java.time.Instant.now());
        project.setUpdatedAt(java.time.Instant.now());
        return projectRepository.save(project);
    }

    /// Get a project
    /// GET /api/projects/{id}
    /// Returns a project by id
    @GetMapping("/{id}")
    public Project getProject(@PathVariable Integer id) {
        return projectRepository.findById(id).orElse(null);
    }

    /// Update a project
    /// PUT /api/projects/{id}
    /// Updates a project by id
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Integer id, @RequestBody Project project) {
        Project existingProject = projectRepository.findById(id).orElse(null);
        if (existingProject == null) {
            return null;
        }
        existingProject.setName(project.getName());
        existingProject.setDescription(project.getDescription());
        existingProject.setStartDate(project.getStartDate());
        existingProject.setEndDate(project.getEndDate());
        existingProject.setStatus(project.getStatus());
        existingProject.setCreatedBy(project.getCreatedBy());
        existingProject.setUpdatedAt(java.time.Instant.now());
        return projectRepository.save(existingProject);
    }

    /// Delete a project
    /// DELETE /api/projects/{id}
    /// Deletes a project by id
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectRepository.deleteById(id);
    }
}
