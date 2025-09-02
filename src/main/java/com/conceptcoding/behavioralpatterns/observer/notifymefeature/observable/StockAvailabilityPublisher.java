package com.conceptcoding.behavioralpatterns.observer.notifymefeature.observable;

import com.conceptcoding.behavioralpatterns.observer.notifymefeature.observer.StockAvailabilityObserver;

// Observable interface
public interface StockAvailabilityPublisher {
    void addStockObserver(StockAvailabilityObserver observer);

    void removeStockObserver(StockAvailabilityObserver observer);

    void notifyStockObservers();
}
