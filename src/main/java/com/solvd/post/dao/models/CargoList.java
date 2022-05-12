package com.solvd.post.dao.models;

import java.util.List;

public class CargoList {

	private long id;
	private long packages_id;
	private List<PackageBox> packages;

	public CargoList() {}
	
	public CargoList(long id, long packages_id, List<PackageBox> packages) {
		this.id = id;
		this.packages_id = packages_id;
		this.packages = packages;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<PackageBox> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageBox> packages) {
		this.packages = packages;
	}

	public long getPackages_id() {
		return packages_id;
	}

	public void setPackages_id(long packages_id) {
		this.packages_id = packages_id;
	}
}
