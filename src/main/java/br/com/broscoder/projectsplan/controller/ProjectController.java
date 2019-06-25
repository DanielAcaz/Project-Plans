package br.com.broscoder.projectsplan.controller;

import br.com.broscoder.projectsplan.model.Project;
import br.com.broscoder.projectsplan.model.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    ProjectRepository repository;

    @GetMapping("ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createFrequency(@RequestBody Project project) {
        Project projectCreated = repository.save(project);
        return new ResponseEntity<>(projectCreated, HttpStatus.CREATED);
    }


}
