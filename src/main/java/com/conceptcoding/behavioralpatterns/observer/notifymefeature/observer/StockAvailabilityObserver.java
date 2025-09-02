package com.conceptcoding.behavioralpatterns.observer.notifymefeature.observer;

import com.conceptcoding.behavioralpatterns.observer.notifymefeature.observable.IphoneProduct;

// Observer interface for stock availability notifications
public interface StockAvailabilityObserver {
    void notify(IphoneProduct iphoneProduct);

    String getNotificationMethod();

    String getUserId();
}
