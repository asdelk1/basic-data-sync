package dev.asdelk.unidatasync.models.mappings;

import dev.asdelk.unidatasync.models.Application;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ApplicationMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Application source;
    @OneToOne
    private Application target;
    @OneToMany(mappedBy = "applicationMapping")
    private List<EntityMapping> entityMappings;
}
