package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

		private final CarService carService;

		@Autowired
		public CarController(CarService carService) {
				this.carService = carService;
		}

		@GetMapping("/{carId}")
		public CarDto getById(@PathVariable Long carId) {
				return carService.getById(carId);
		}

		@GetMapping("/all")
		public List<CarDto> getAll() {
				return carService.getAll();
		}

		@PostMapping
		public CarDto createCar(@RequestBody CarDto carDto) {
				return carService.createCar(carDto);
		}

		@PutMapping("/update")
		public CarDto updateCar(@RequestBody CarDto carDto) {
				return carService.updateCar(carDto);
		}

		@DeleteMapping("/delete/{carId}")
		public void deleteCar(@PathVariable Long carId) {
				carService.deleteUser(carId);
		}
}
