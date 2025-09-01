package com.conceptcoding.behavioralpatterns.state.vendingmachinestates.impl;

import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;
import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.VendingMachineState;

// Step 2d: Concrete State - DispenseState
// When machine is dispensing the product
public class DispenseState implements VendingMachineState {
    @Override
    public void beginTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Transaction already in progress. Cancel to end the transaction.");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, String productCode) throws Exception {
        throw new Exception("Product cannot be chosen in DispenseState. You need to begin transaction first.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Double amountPaid) throws Exception {
        throw new Exception("You cannot pay in DispenseState.  You need to begin transaction first.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        System.out.println("Current State: " + vendingMachine.getCurrentState().getClass().getSimpleName());
        System.out.print("Product Dispensed: ");
        System.out.println(vendingMachine.getSelectedProduct().getName());
        System.out.println("Change Dispensed: " + vendingMachine.getChangeToReturn());
        vendingMachine.getInventory().stream()
                .filter(product -> product.getProductCode().equals(vendingMachine.getSelectedProduct().getProductCode()))
                .findFirst()
                .ifPresent(product -> product.setQuantity(product.getQuantity() - 1));
        vendingMachine.setCurrentState(new IdleState());
    }
}

