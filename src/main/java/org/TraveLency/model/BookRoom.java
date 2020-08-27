package org.TraveLency.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BookRoom")
public class BookRoom {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fromDate")
    private String fromDate;

    @Column(name = "toDate")
    private String toDate;

    @Column(name = "numberBookedRooms")
    private Long numberBookedRooms;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
}
