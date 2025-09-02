package com.conceptcoding.behavioralpatterns.observer.weatherstation.observer;

import com.conceptcoding.behavioralpatterns.observer.weatherstation.observable.WeatherStation;

// Concrete Observer 1 - Current Conditions Display (on TV or Mobile)
public class CurrentConditionsDisplay implements WeatherObserver {
    private final WeatherStation weatherStation;
    // Observer State
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);
    }

    // CurrentConditionsDisplay implements the update method in its own way
    @Override
    public void update(WeatherStation weatherStation) {
        this.temperature = weatherStation.getTemperature();
        this.humidity = weatherStation.getHumidity();
        this.pressure = weatherStation.getPressure();
        display();
    }

    // Display the current weather conditions
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees, " + humidity + "% humidity, and " + pressure + " pressure");
    }
}