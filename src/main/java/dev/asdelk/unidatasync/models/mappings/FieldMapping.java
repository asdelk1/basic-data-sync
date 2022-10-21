package dev.asdelk.unidatasync.models.mappings;

import dev.asdelk.unidatasync.models.EntityField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class FieldMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private EntityField sourceEntity;
    @OneToOne
    private EntityField targetEntity;
}
