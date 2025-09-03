package com.conceptcoding.behavioralpatterns.observer.notifymefeature.observer;

import com.conceptcoding.behavioralpatterns.observer.notifymefeature.observable.IphoneProduct;

// Concrete observer for email notifications
public class EmailNotificationObserver implements StockNotificationObserver {
    private final String userId;
    private final String emailAddress;

    public EmailNotificationObserver(String userId, String emailAddress) {
        this.userId = userId;
        this.emailAddress = emailAddress;
    }

    @Override
    public void notify(IphoneProduct iPhoneProduct) {
        System.out.println("!! EMAIL SENT to: " + emailAddress
                + " for " + iPhoneProduct.getProductName() + "."
                + " Your wishlist item is available now.");
    }

    @Override
    public String getNotificationMethod() {
        return "Email";
    }

    @Override
    public String getUserId() {
        return userId;
    }
}
