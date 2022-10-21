package dev.asdelk.unidatasync.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity()
public class ApplicationEntity {

    @Id
    private String Name;
    @OneToMany
    private List<EntityField> fields;
    @OneToOne
    private CrudPath crudPath;
}
