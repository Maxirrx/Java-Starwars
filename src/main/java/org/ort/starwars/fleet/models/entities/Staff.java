
package org.ort.starwars.fleet.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.ort.starwars.fleet.models.enums.Breed;

@Data
@Builder
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private final Breed breed;

    @Column
    private int recruits;
}
