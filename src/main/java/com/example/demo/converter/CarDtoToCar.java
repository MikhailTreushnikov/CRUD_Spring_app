package com.example.demo.converter;

import com.example.demo.dto.CarDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.CarBody;
import com.example.demo.exceptions.DoesntExistException;
import com.example.demo.repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarDtoToCar implements Converter<CarDto, Car> {

		private final EngineRepository engineRepository;

		@Autowired
		public CarDtoToCar(EngineRepository engineRepository) {
				this.engineRepository = engineRepository;
		}

		@Override
		public Car convert(CarDto carDto) {
				Car car = new Car();
				car.setId(carDto.getId());
				car.setModel(carDto.getModel());
				car.setCarBody(CarBody.valueOf(carDto.getCarBody()));
				car.setPrice(carDto.getPrice());
				if (carDto.getEngine().getId()!= null){
						car.setEngine(engineRepository
								.findById(carDto.getEngine().getId()).orElse(
										engineRepository.findByType(carDto.getEngine().getType())
												.orElseThrow(() -> new DoesntExistException("engine with id doesn't exist")))
						);
				}
				else{
						car.setEngine(
										engineRepository.findByType(carDto.getEngine().getType())
												.orElseThrow(() -> new DoesntExistException("engine with id doesn't exist")));
				}
				return car;
		}
}
