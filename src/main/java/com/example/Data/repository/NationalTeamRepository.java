package com.example.Data.repository;


import com.example.Data.entity.NationalTeams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalTeamRepository extends JpaRepository<NationalTeams, Long> {

}
