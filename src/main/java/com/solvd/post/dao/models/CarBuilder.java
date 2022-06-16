package com.solvd.post.dao.models;

public class CarBuilder {
	private long id;
	private String model;
	private int year;
	private int capasity;

	public CarBuilder() {
	}

	public CarBuilder(Builder builder) {
		this.id = builder.id;
		this.model = builder.model;
		this.year = builder.year;
		this.capasity = builder.capasity;
	}

	public int getCapasity() {
		return capasity;
	}

	public int getYear() {
		return year;
	}

	public String getModel() {
		return model;
	}

	public long getId() {
		return id;
	}

	static class Builder {
		private long id;
		private String model;
		private int year;
		private int capasity;

		public Builder(String model) {
			this.model = model;
		}

		public Builder setYear(int year) {
			this.year = year;
			return this;

		}

		public Builder setCapasity(int capasity) {
			this.capasity = capasity;
			return this;

		}
       public CarBuilder build() {
    	   return new CarBuilder(this);
       }
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", year=" + year + ", capasity=" + capasity + "]";
	}

}
