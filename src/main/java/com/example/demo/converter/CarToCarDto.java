package com.example.demo.converter;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.EngineDto;
import com.example.demo.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarToCarDto implements Converter<Car, CarDto> {

		private final ConversionService conversionService;

		@Autowired
		public CarToCarDto(ConversionService conversionService) {
				this.conversionService = conversionService;
		}

		@Override
		public CarDto convert(Car car) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setModel(car.getModel());
				carDto.setCarBody(car.getCarBody().name());
				carDto.setEngine(conversionService.convert(car.getEngine(), EngineDto.class));
				carDto.setPrice(car.getPrice());
				return carDto;
		}
}
