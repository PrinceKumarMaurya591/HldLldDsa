package com.conceptcoding.behavioralpatterns.observer.weatherstation.observer;

import com.conceptcoding.behavioralpatterns.observer.weatherstation.observable.WeatherStation;

// Concrete Observer 4 - Forecast Display - Predicts weather based on pressure changes
public class ForecastDisplay implements WeatherObserver {
    private final WeatherStation weatherStation;
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);
    }

    // ForecastDisplay implements the update method in its own way
    @Override
    public void update(WeatherStation weatherStation) {
        lastPressure = currentPressure;
        currentPressure = weatherStation.getPressure();
        display();
    }

    // Display the forecast based on the current pressure
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("Weather is the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather!");
        }
    }
}
