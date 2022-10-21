package dev.asdelk.unidatasync.models.mappings;

import dev.asdelk.unidatasync.models.Application;
import dev.asdelk.unidatasync.models.ApplicationEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class EntityMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Application sourceApplication;
    @OneToOne
    private Application targetApplication;
    @OneToOne
    private ApplicationEntity sourceEntity;
    @OneToOne
    private ApplicationEntity targetEntity;
    @OneToMany
    private List<FieldMapping> fieldMapping;
    @ManyToOne
    private ApplicationMapping applicationMapping;

}
