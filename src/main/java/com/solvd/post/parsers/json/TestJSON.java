package com.solvd.post.parsers.json;

import java.io.FileReader;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.solvd.post.dao.models.Car;

public class TestJSON {

	public static List<Car> parseCars() {

		JSONParser parser = new JSONParser();
		List<Car> carList = new ArrayList<>();

		try (FileReader reader = new FileReader("src/main/resources/json/cars.json")) {

			JSONObject root = (JSONObject) parser.parse(reader);

			String name = (String) root.get("name");

			JSONArray carsJSON = (JSONArray) root.get("cars");

			for (Object item : carsJSON) {
				JSONObject carJSONObj = (JSONObject) item;

				long idCar = (long) carJSONObj.get("id");
				String modelCar = (String) carJSONObj.get("model");
				long yearCar = (long) carJSONObj.get("year");
				long capasityCar = (long) carJSONObj.get("capasity");
				Car car = new Car(idCar, modelCar, (int) yearCar, (int) capasityCar);
				carList.add(car);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return carList;
	}

	
	public static void writeCars() {
	
		
	}
	
}
