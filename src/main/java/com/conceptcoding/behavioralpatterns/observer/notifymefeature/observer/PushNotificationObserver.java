package com.conceptcoding.behavioralpatterns.observer.notifymefeature.observer;

import com.conceptcoding.behavioralpatterns.observer.notifymefeature.observable.IphoneProduct;

// Concrete observer for push notifications
public class PushNotificationObserver implements StockAvailabilityObserver {
    private final String userId;
    private final String deviceToken;

    public PushNotificationObserver(String userId, String deviceToken) {
        this.userId = userId;
        this.deviceToken = deviceToken;
    }

    @Override
    public void notify(IphoneProduct iphoneProduct) {
        System.out.println("!! PUSH NOTIFICATION SENT to: " + deviceToken
                + " for " + iphoneProduct.getProductName()
                + " with available quantity " + iphoneProduct.getStockQuantity());
    }

    @Override
    public String getNotificationMethod() {
        return "Push Notification";
    }

    @Override
    public String getUserId() {
        return userId;
    }
}
