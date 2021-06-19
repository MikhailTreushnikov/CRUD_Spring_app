package com.example.demo.entity;

public enum CarBody {
		HATCHBACK("hatchback"),
		STATION_WAGON("station wagon"),
		PICKUP_TRUCK("pickup truck"),
		MINIVAN("minivan"),
		SEDAN("sedan"),
		COUPE("coupe"),
		SPORT_UTILITY_VEHICLE("sport-utility vehicle");

		private final String carBody;

		CarBody(String carBody) {
				this.carBody = carBody;
		}

		public String getCarBody() {
				return carBody;
		}
}
