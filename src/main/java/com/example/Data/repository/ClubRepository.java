package com.example.Data.repository;

import com.example.Data.entity.Clubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Clubs, Long> {

}
