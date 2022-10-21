package dev.asdelk.unidatasync.service;

import dev.asdelk.unidatasync.models.Application;
import dev.asdelk.unidatasync.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

private final ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    public List<Application> getAll(){
        return this.repository.findAll();
    }

    public Optional<Application> get(long id){
        return this.repository.findById(id);
    }

    public Application create(Application application){
        return this.repository.save(application);
    }
}
