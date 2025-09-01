package com.conceptcoding.behavioralpatterns.state.context;

import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.VendingMachineState;
import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.impl.IdleState;

import java.util.ArrayList;

// Step 3: Context class - VendingMachine
// Holds reference to current state of the vending machine
public class VendingMachine {
    public ArrayList<Product> inventory;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private double paymentMade;
    private double changeToReturn;

    public VendingMachine() {
        this.setCurrentState(new IdleState()); // Initial state
        this.setInventory(stockUpVendingMachine()); // Load the vending machine with products
    }

    public VendingMachineState getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }

    public Product getSelectedProduct() {
        return this.selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public double getPaymentMade() {
        return this.paymentMade;
    }

    public void setPaymentMade(double paymentMade) {
        this.paymentMade = paymentMade;
        this.setChangeToReturn(paymentMade - selectedProduct.getPrice());
    }

    public double getChangeToReturn() {
        return this.changeToReturn;
    }

    public void setChangeToReturn(double changeToReturn) {
        this.changeToReturn = changeToReturn;
    }

    public ArrayList<Product> getInventory() {
        return this.inventory;
    }

    public void setInventory(ArrayList<Product> productList) {
        this.inventory = productList;
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : inventory) {
            System.out.println(product.toString());
        }
    }

    // State methods
    public void beginTransaction() throws Exception {
        currentState.beginTransaction(this);
    }

    public void chooseProduct(String productCode) throws Exception {
        currentState.chooseProduct(this, productCode);
    }

    public void insertCoin(Double amountPaid) throws Exception {
        currentState.insertCoin(this, amountPaid);
    }

    public void dispenseProduct() throws Exception {
        currentState.dispenseProduct(this);
    }

    public void initiateRefund(double changeToReturn) {
        System.out.println("Refunded Amount: " + changeToReturn);
        this.changeToReturn = 0.00;
    }

    private ArrayList<Product> stockUpVendingMachine() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Stocking up the vending machine...");
        ArrayList<Product> products = new ArrayList<>();
        // Shelf 1 - Soft Drinks
        products.add(new Product(ProductType.SOFT_DRINKS, "Coke", "101", 70.00, 5));
        products.add(new Product(ProductType.SOFT_DRINKS, "Pepsi", "102", 50.00, 5));
        products.add(new Product(ProductType.SOFT_DRINKS, "Sprite", "103", 50.00, 5));
        // Shelf 2 - Chips
        products.add(new Product(ProductType.CHIPS, "Lays", "201", 20.00, 5));
        products.add(new Product(ProductType.CHIPS, "Nachos", "202", 60.00, 5));
        products.add(new Product(ProductType.CHIPS, "Pringles", "203", 50.00, 5));
        // Shelf 3 - Chocolates
        products.add(new Product(ProductType.CHOCOLATE, "Munch", "301", 20.00, 5));
        products.add(new Product(ProductType.CHOCOLATE, "Snickers", "302", 50.00, 5));
        products.add(new Product(ProductType.CHOCOLATE, "5star", "303", 35.00, 1));

        return products;
    }
}

