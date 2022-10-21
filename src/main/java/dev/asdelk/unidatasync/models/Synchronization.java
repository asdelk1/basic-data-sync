package dev.asdelk.unidatasync.models;

import dev.asdelk.unidatasync.models.mappings.EntityMapping;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Synchronization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Application sourceApplication;
    @OneToOne
    private Application targetApplication;
    @OneToMany
    private List<EntityMapping> mappedEntities;
}
