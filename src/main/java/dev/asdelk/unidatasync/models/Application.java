package dev.asdelk.unidatasync.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String baseURL;
    @OneToMany
    private List<ApplicationEntity> entities;
}
