package com.conceptcoding.behavioralpatterns.state.vendingmachinestates.impl;

import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;
import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.VendingMachineState;

// Step 2c: Concrete State - CollectMoneyState
// When the customer makes the payment for selected product
public class CollectMoneyState implements VendingMachineState {
    @Override
    public void beginTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Transaction already in progress. Cancel to end the transaction.");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, String codeNumber) throws Exception {
        throw new Exception("Product cannot be chosen in HasMoneyState. You need to begin transaction first.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Double amountPaid) throws Exception {
        System.out.println("Current State: " + vendingMachine.getCurrentState().getClass().getSimpleName());
        System.out.println("You Paid: " + amountPaid);
        if (amountPaid < vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.initiateRefund(amountPaid);
            vendingMachine.setCurrentState(new IdleState());
            throw new Exception("INSUFFICIENT AMOUNT: Amount paid is less than the product price. Amount Refunded.");
        }
        vendingMachine.setPaymentMade(amountPaid);
        vendingMachine.setCurrentState(new DispenseState());
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Product cannot be dispensed in CollectMoneyState. You need to pay first.");
    }
}

