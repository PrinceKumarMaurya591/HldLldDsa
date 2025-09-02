package com.conceptcoding.behavioralpatterns.observer.notifymefeature.observable;

import com.conceptcoding.behavioralpatterns.observer.notifymefeature.observer.StockAvailabilityObserver;

import java.util.ArrayList;
import java.util.List;

// Concrete Observable
public class IphoneProduct implements StockAvailabilityPublisher {
    private String productId;
    private double price;
    private List<StockAvailabilityObserver> stockObservers;
    private String productName;
    private int stockQuantity;

    public IphoneProduct(String productId, String productName, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.stockObservers = new ArrayList<>();
    }

    @Override
    public void addStockObserver(StockAvailabilityObserver observer) {
        stockObservers.add(observer);
        System.out.println("[+]" + observer.getUserId() + " subscribed for notifications on " + productName);

    }

    @Override
    public void removeStockObserver(StockAvailabilityObserver observer) {
        stockObservers.remove(observer);
        System.out.println("[-]" + observer.getUserId() + " unsubscribed for notifications on " + productName);
    }

    @Override
    public void notifyStockObservers() {
        if (stockQuantity > 0 && !stockObservers.isEmpty()) {
            System.out.print("Notifying " + stockObservers.size() + " subscribers...[");
            System.out.println("STOCK ALERT: " + productName
                    + " is now available!"
                    + " Available quantity: " + stockQuantity
                    + " | "
                    + " Price: $" + price
                    + "]");

            // Create a copy to avoid concurrent modification
            List<StockAvailabilityObserver> observersToNotify = new ArrayList<>(stockObservers);

            for (StockAvailabilityObserver observer : observersToNotify) {
                observer.notify(this);
            }
        }
    }

    // Method to restock items
    public void restock(int quantity) {
        boolean wasOutOfStock = (stockQuantity == 0);
        stockQuantity += quantity;
        System.out.println("RESTOCKED: " + productName + " - Added " + quantity + " items " + " | " + "Current stock: " + stockQuantity);
        // Only notify if product was previously out of stock
        if (wasOutOfStock && stockQuantity > 0) {
            notifyStockObservers();
        }
    }

    // Method to purchase items
    public boolean purchase(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            System.out.println("PURCHASE SUCCESS: " + quantity + " units of " + productName + " | " + "Remaining stock: " + stockQuantity);
            return true;
        } else {
            System.out.println("PURCHASE FAILED: " + productName + " is out of stock! | " + "Available Quantity: " + stockQuantity);
            return false;
        }
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
