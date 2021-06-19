package com.example.demo.service;

import com.example.demo.dto.CarDto;
import java.util.List;

public interface CarService {

		CarDto createCar(CarDto carDto);

		void deleteUser(Long id);

		List<CarDto> getAll();

		CarDto updateCar(CarDto carDto);

		CarDto getById(Long id);
}
