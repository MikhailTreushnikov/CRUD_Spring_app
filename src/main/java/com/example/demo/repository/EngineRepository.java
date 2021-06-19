package com.example.demo.repository;

import com.example.demo.entity.Engine;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {

		Optional<Engine> findByType(String type);

}
