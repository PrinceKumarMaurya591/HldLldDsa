package com.conceptcoding.behavioralpatterns.observer.weatherstation.observer;

import com.conceptcoding.behavioralpatterns.observer.weatherstation.observable.WeatherStation;

// Observer interface - defines the update method
// Concrete observers implement this interface to update their state
// and respond to changes in its OWN way
public interface WeatherObserver {
    void update(WeatherStation weatherStation);
}
