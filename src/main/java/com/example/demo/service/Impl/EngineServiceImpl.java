package com.example.demo.service.Impl;

import com.example.demo.dto.EngineDto;
import com.example.demo.entity.Engine;
import com.example.demo.exceptions.DoesntExistException;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EngineRepository;
import com.example.demo.service.EngineService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EngineServiceImpl implements EngineService {

		private final ConversionService conversionService;
		private final CarRepository carRepository;
		private final EngineRepository engineRepository;

		@Autowired
		public EngineServiceImpl(ConversionService conversionService,
				CarRepository carRepository, EngineRepository engineRepository) {
				this.conversionService = conversionService;
				this.carRepository = carRepository;
				this.engineRepository = engineRepository;
		}

		@Override
		@Transactional
		public EngineDto createEngine(EngineDto engineDto) {
				Engine engine = conversionService.convert(engineDto, Engine.class);
				if (engine != null) {
						engineRepository.save(engine);
				}
				return conversionService.convert(engine, EngineDto.class);
		}

		@Override
		@Transactional
		public void deleteEngine(Long id) {
				engineRepository.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public List<EngineDto> getAll() {
				List<Engine> engines = engineRepository.findAll();
				return engines.stream()
						.map(engine -> conversionService.convert(engine, EngineDto.class))
						.collect(Collectors.toList());
		}

		@Override
		@Transactional
		public EngineDto updateEngine(EngineDto engineDto) {
				Engine engine = engineRepository
						.findById(engineDto.getId()).orElseThrow(() -> new DoesntExistException(
								"engine with id" + engineDto.getId() + "doesn't exist"));
				engine.setId(engineDto.getId());
				engine.setPower(engineDto.getPower());
				engine.setType(engineDto.getType());
				return conversionService.convert(engine, EngineDto.class);
		}

		@Override
		@Transactional(readOnly = true)
		public EngineDto getById(Long id) {
				Engine engine = engineRepository.findById(id).orElse(null);
				return conversionService.convert(engine, EngineDto.class);
		}
}
