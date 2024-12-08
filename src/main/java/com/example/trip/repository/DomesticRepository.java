package com.example.trip.repository;

import com.example.trip.subDto.Domestic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomesticRepository extends JpaRepository<Domestic, Long> {
}
