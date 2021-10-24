package uit.chinhln.MomoCodingTest;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import uit.chinhln.MomoCodingTest.exception.*;
import uit.chinhln.MomoCodingTest.product.AbstractProduct;
import uit.chinhln.MomoCodingTest.wallet.CustomerWallet;
import uit.chinhln.MomoCodingTest.wallet.DefaultCustomerWallet;

import java.util.*;

public class SodaMachine {

    @Getter
    @Setter
    @NonNull
    CustomerWallet customerWallet;

    Map<Integer, SodaMachineProduct> storage = new HashMap<>();

    Set<Integer> acceptedBankNotes = new HashSet<>();

    public SodaMachine() {
        customerWallet = new DefaultCustomerWallet();
    }

    public void insertBankNote(@NonNull Integer amount) throws InvalidBankNoteValueException, InvalidValueException {
        if (!acceptedBankNotes.contains(amount)) {
            throw new InvalidBankNoteValueException(acceptedBankNotes);
        }

        this.customerWallet.deposit(amount);
    }

    public AbstractProduct selectProduct(int productId) throws ProductNotFoundException, ProductOutOfStockException, BalanceNotEnoughException, SystemErrorException {
        SodaMachineProduct machineProduct = storage.get(productId);

        if (machineProduct == null) {
            throw new ProductNotFoundException();
        }

        if (machineProduct.getStock() <= 0) {
            throw new ProductOutOfStockException();
        }

        if (machineProduct.getProduct().getPrice() > customerWallet.checkBalance()) {
            throw new BalanceNotEnoughException();
        }

        try {
            customerWallet.withdraw(machineProduct.getProduct().getPrice());

            machineProduct.setStock(machineProduct.getStock() - 1);

            return machineProduct.getProduct().clone();
        } catch (Exception e) {
            throw new SystemErrorException();
        }
    }

    public int cancelRequest() {
        return customerWallet.withdrawAll();
    }

    public SodaMachineProduct getMachineProduct(int sodaMachineProductID) {
        return storage.get(sodaMachineProductID);
    }

    public void setMachineProduct(SodaMachineProduct sodaMachineProduct) {
        storage.put(sodaMachineProduct.getId(), sodaMachineProduct);
    }

    public void removeMachineProduct(int sodaMachineProductID) {
        storage.remove(sodaMachineProductID);
    }

    public void addAcceptedBankNote(int value) {
        acceptedBankNotes.add(value);
    }

    public void removeAcceptedBankNote(int value) {
        acceptedBankNotes.remove(value);
    }

    public void clearAcceptedBankNote() {
        acceptedBankNotes.clear();
    }
}
