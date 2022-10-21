package dev.asdelk.unidatasync.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class SynchronizationJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime runOn;
    @OneToOne
    private Synchronization synchronization;
    @ElementCollection
    private Set<String> errors;
    @ElementCollection
    private Set<String> warning;
}
