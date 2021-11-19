package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Long> {
}
