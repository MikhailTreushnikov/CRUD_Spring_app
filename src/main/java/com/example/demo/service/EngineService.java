package com.example.demo.service;

import com.example.demo.dto.EngineDto;
import java.util.List;

public interface EngineService {

		EngineDto createEngine(EngineDto engineDto);

		void deleteEngine(Long id);

		List<EngineDto> getAll();

		EngineDto updateEngine(EngineDto engineDto);

		EngineDto getById(Long id);


}
