package com.example.demo.repository;

import com.example.demo.entity.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

		List<Car> findAllByEngine_Id(Long engine_id);
}
