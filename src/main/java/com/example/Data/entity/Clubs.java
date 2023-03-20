package com.example.Data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clubs")
public class Clubs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    private NationalTeams nationalTeams;
    @Column
    private String FC;
    @Column
    private String league;
    @Column
    private Integer SPI;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clubs")
    private List<NationalTeams> nationalTeamsList = new ArrayList<>();

}
