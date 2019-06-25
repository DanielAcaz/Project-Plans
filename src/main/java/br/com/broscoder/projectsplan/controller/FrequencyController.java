package br.com.broscoder.projectsplan.controller;

import br.com.broscoder.projectsplan.model.Frequency;
import br.com.broscoder.projectsplan.model.FrequencyRepository;
import br.com.broscoder.projectsplan.model.Project;
import br.com.broscoder.projectsplan.model.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("frequency")
public class FrequencyController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    FrequencyRepository repository;

    @PostMapping("/{projectId}/")
    public ResponseEntity<?> createFrequency(@PathVariable(value="projectId") String id, @RequestBody Frequency frequency) {
        Project project = projectRepository.getOne(Long.valueOf(id));
        frequency.setProject(project);
        Frequency frequencyCreated = repository.save(frequency);
        return new ResponseEntity<>(frequencyCreated, HttpStatus.CREATED);
    }
}
