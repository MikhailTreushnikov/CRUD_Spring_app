package com.example.demo.converter;

import com.example.demo.dto.EngineDto;
import com.example.demo.entity.Engine;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EngineToEngineDto implements Converter<Engine, EngineDto> {

		@Override
		public EngineDto convert(Engine engine) {
				EngineDto engineDto = new EngineDto();
				engineDto.setId(engine.getId());
				engineDto.setType(engine.getType());
				engineDto.setPower(engine.getPower());
				return engineDto;
		}
}
