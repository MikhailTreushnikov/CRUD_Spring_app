package com.example.demo.service.Impl;

import com.example.demo.dto.CarDto;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import com.example.demo.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService {

		private final ConversionService conversionService;
		private final CarRepository carRepository;
		private final EngineRepository engineRepository;

		@Autowired
		public CarServiceImpl(
				@Qualifier("mvcConversionService") ConversionService conversionService,
				CarRepository carRepository,
				EngineRepository engineRepository) {
				this.conversionService = conversionService;
				this.carRepository = carRepository;
				this.engineRepository = engineRepository;
		}

		@Override
		@Transactional
		public CarDto createCar(CarDto carDto) {
				Car car = conversionService.convert(carDto, Car.class);
        if (car != null) {
            carRepository.save(car);
        }
				return conversionService.convert(car, CarDto.class);
		}

		@Override
		@Transactional
		public void deleteUser(Long id) {
				carRepository.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public List<CarDto> getAll() {
				List<Car> cars = carRepository.findAll();
				return cars.stream()
						.map(user -> conversionService.convert(user, CarDto.class))
						.collect(Collectors.toList());
		}

		@Override
		@Transactional(readOnly = true)
		public CarDto getById(Long id) {
				Car car = carRepository.findById(id).orElse(null);
				return conversionService.convert(car, CarDto.class);
		}

		@Override
		@Transactional
		public CarDto updateCar(CarDto carDto) {
				Car car = carRepository.findById(carDto.getId()).orElse(null);
				return conversionService.convert(car, CarDto.class);
		}
}
