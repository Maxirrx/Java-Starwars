
package org.ort.starwars.fleet.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.ort.starwars.fleet.models.enums.StarshipType;

@Data
@Entity
@Builder
public class Starship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private StarshipType category;

    @Column
    private int length;

    @Column
    private int crew;

    @Column
    private int passengers;

    @Column
    private String pilot;

    public String getKey() {
        return pilot.isBlank() ? name : name + " " + pilot;
    }

    public double getSpeed() {
        double l = this.length;
        return l > 0 ? 10000.0 / l : 0;
    }

    public double getCost() {
        double l = this.length;
        return l * l;
    }
}
