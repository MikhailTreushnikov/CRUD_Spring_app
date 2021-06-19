package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDto {

		@JsonProperty
		private Long id;

		@JsonProperty
		private String model;

		@JsonProperty
		private BigDecimal price;

		@JsonProperty
		private EngineDto engine;

		@JsonProperty
		private String carBody;

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public String getModel() {
				return model;
		}

		public void setModel(String model) {
				this.model = model;
		}

		public BigDecimal getPrice() {
				return price;
		}

		public void setPrice(BigDecimal price) {
				this.price = price;
		}

		public EngineDto getEngine() {
				return engine;
		}

		public void setEngine(EngineDto engine) {
				this.engine = engine;
		}

		public String getCarBody() {
				return carBody;
		}

		@Override
		public boolean equals(Object o) {
				if (this == o) {
						return true;
				}
				if (o == null || getClass() != o.getClass()) {
						return false;
				}
				CarDto carDto = (CarDto) o;
				return Objects.equals(id, carDto.id) && Objects.equals(model, carDto.model) && Objects
						.equals(price, carDto.price) && Objects.equals(engine, carDto.engine) && Objects
						.equals(carBody, carDto.carBody);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, model, price, engine, carBody);
		}

		public void setCarBody(String carBody) {
				this.carBody = carBody;
		}
}
