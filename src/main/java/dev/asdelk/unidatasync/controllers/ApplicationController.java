package dev.asdelk.unidatasync.controllers;

import dev.asdelk.unidatasync.dtos.ApplicationDTO;
import dev.asdelk.unidatasync.models.Application;
import dev.asdelk.unidatasync.service.ApplicationService;
import dev.asdelk.unidatasync.utils.ModelMapperUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/business-applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ModelMapperUtils mapperUtils;


    public ApplicationController(ApplicationService applicationService, ModelMapperUtils mapperUtils) {
        this.applicationService = applicationService;
        this.mapperUtils = mapperUtils;
    }

    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> list = this.applicationService.getAll();
        List<ApplicationDTO> dtoList = mapperUtils.mapList(list, ApplicationDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> get(@PathVariable long id) {
        Optional<Application> applicationOptional = this.applicationService.get(id);
        return applicationOptional.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(this.mapperUtils.map(applicationOptional.get(), ApplicationDTO.class));
    }

    @PostMapping()
    public ResponseEntity<ApplicationDTO> create(@RequestBody ApplicationDTO dto) {
        Application application = this.mapperUtils.map(dto, Application.class);
        Application createdApplication = this.applicationService.create(application);

        return new ResponseEntity<ApplicationDTO>(this.mapperUtils.map(createdApplication, ApplicationDTO.class), HttpStatus.CREATED);
    }

}
