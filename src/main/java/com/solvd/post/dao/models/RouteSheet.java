package com.solvd.post.dao.models;

public class RouteSheet {

	private long id;
	private CargoList cargoList;
	private Car car;
	private Stuff stuff;

	public RouteSheet() {
	}

	public RouteSheet(long id, CargoList cargoList, long carId, long stuffId, Stuff stuff) {
		this.id = id;
		this.cargoList = cargoList;
		this.stuff = stuff;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CargoList getCargoList() {
		return cargoList;
	}

	public void setCargoList(CargoList cargoList) {
		this.cargoList = cargoList;
	}

	public Stuff getStuff() {
		return stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
