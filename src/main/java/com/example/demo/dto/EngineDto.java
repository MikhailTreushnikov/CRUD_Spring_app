package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EngineDto {

		@JsonProperty
		private Long id;

		@JsonProperty
		private String type;

		@JsonProperty
		private String power;

		@JsonProperty
		private Double volume;

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public String getType() {
				return type;
		}

		public void setType(String type) {
				this.type = type;
		}

		public String getPower() {
				return power;
		}

		public Double getVolume() {
				return volume;
		}

		public void setVolume(Double volume) {
				this.volume = volume;
		}

		public void setPower(String power) {
				this.power = power;
		}
}
