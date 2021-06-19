package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(
		name = "engine",
		uniqueConstraints =
		@UniqueConstraint(columnNames = "type")
)
public class Engine extends EntityBase {

		@Column(name = "type")
		private String type;

		@Column(name = "value")
		private Double volume;

		@Column(name = "power")
		private String power;

		@OneToMany(
				mappedBy = "engine",
				cascade = CascadeType.ALL,
				orphanRemoval = true,
				fetch = FetchType.LAZY
		)
		@BatchSize(size = 100)
		private List<Car> cars = new ArrayList<>();


		public String getType() {
				return type;
		}

		public void setType(String type) {
				this.type = type;
		}

		public Double getVolume() {
				return volume;
		}

		public void setVolume(Double value) {
				this.volume = value;
		}

		public String getPower() {
				return power;
		}

		public void setPower(String power) {
				this.power = power;
		}

		public List<Car> getCars() {
				return cars;
		}

		public void setCars(List<Car> cars) {
				this.cars = cars;
		}

		@Override
		public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
				Engine engine = (Engine) o;
				return Objects.equals(type, engine.type) && Objects.equals(volume, engine.volume) && Objects
						.equals(power, engine.power) && Objects.equals(cars, engine.cars);
		}

		@Override
		public int hashCode() {
				return Objects.hash(type, volume, power, cars);
		}
}
