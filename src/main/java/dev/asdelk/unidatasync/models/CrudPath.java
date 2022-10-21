package dev.asdelk.unidatasync.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class CrudPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String read;
    private String create;
    private String update;
    private String delete;
}
