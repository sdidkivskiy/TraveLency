package org.TraveLency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "availableRooms")
    private Long availableRooms;

    @ManyToOne
    @JoinColumn(nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Country country;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<BookRoom> bookRooms;

}
