package com.conceptcoding.behavioralpatterns.observer.weatherstation.observable;

import com.conceptcoding.behavioralpatterns.observer.weatherstation.observer.WeatherObserver;

// Observable(Subject) interface
// Defines methods for managing observers and notifying them of changes
public interface WeatherPublisher {

    void addObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();
}
