package com.example.demo.converter;

import com.example.demo.dto.EngineDto;
import com.example.demo.entity.Engine;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EngineDtoToEngine implements Converter<EngineDto, Engine> {

		private final CarRepository carRepository;

		@Autowired
		public EngineDtoToEngine(CarRepository carRepository) {
				this.carRepository = carRepository;
		}

		@Override
		public Engine convert(EngineDto engineDto) {
				Engine engine = new Engine();
				engine.setId(engineDto.getId());
				engine.setPower(engineDto.getPower());
				engine.setType(engineDto.getType());
				engine.setCars(carRepository.findAllByEngine_Id(engineDto.getId()));
				engine.setVolume(engineDto.getVolume());
				return engine;
		}
}
