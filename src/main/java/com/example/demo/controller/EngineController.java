package com.example.demo.controller;

import com.example.demo.dto.EngineDto;
import com.example.demo.service.EngineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/engines")
public class EngineController {

		private final EngineService engineService;

		@Autowired
		public EngineController(EngineService engineService) {
				this.engineService = engineService;
		}

		@GetMapping("/{engineId}")
		public EngineDto getById(@PathVariable Long engineId) {
				return engineService.getById(engineId);
		}

		@GetMapping("/all")
		public List<EngineDto> getAll() {
				return engineService.getAll();
		}

		@PostMapping
		public EngineDto createCar(@RequestBody EngineDto engineDto) {
				return engineService.createEngine(engineDto);
		}

		@PutMapping("/update")
		public EngineDto updateCar(@RequestBody EngineDto engineDto) {
				return engineService.updateEngine(engineDto);
		}

		@DeleteMapping("/delete/{engineId}")
		public void deleteEngine(@PathVariable Long engineId) {
				engineService.deleteEngine(engineId);
		}
}
