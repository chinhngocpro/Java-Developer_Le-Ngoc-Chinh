package uit.chinhln.MomoCodingTest;

import uit.chinhln.MomoCodingTest.exception.*;
import uit.chinhln.MomoCodingTest.product.AbstractProduct;
import uit.chinhln.MomoCodingTest.product.Coke;
import uit.chinhln.MomoCodingTest.product.Pepsi;
import uit.chinhln.MomoCodingTest.product.Soda;

public class Main {

    public static void main(String... args) {
        SodaMachine sodaMachine = new SodaMachine();
        sodaMachine.setMachineProduct(new SodaMachineProduct(1, new Coke(), 100));
        sodaMachine.setMachineProduct(new SodaMachineProduct(2, new Pepsi(), 1));
        sodaMachine.setMachineProduct(new SodaMachineProduct(3, new Soda(), 2));
        sodaMachine.addAcceptedBankNote(10000);
        sodaMachine.addAcceptedBankNote(20000);
        sodaMachine.addAcceptedBankNote(50000);
        sodaMachine.addAcceptedBankNote(100000);
        sodaMachine.addAcceptedBankNote(200000);

        deposit(sodaMachine, 10000);
        deposit(sodaMachine, -10000);
        deposit(sodaMachine, 500000);

        mua(sodaMachine, 1);
        mua(sodaMachine, 1);

        deposit(sodaMachine, 100000);

        mua(sodaMachine, 1);
        mua(sodaMachine, 2);
        mua(sodaMachine, 3);
        mua(sodaMachine, 4);

        int refundAmount = sodaMachine.cancelRequest();
        System.out.println(String.format("Rut tien thanh cong: %d VND", refundAmount));

        mua(sodaMachine, 1);

    }

    public static void deposit(SodaMachine sodaMachine, int amount) {
        try {
            sodaMachine.insertBankNote(amount);
            System.out.println(String.format("Nap thanh cong %d VND", amount));
        } catch (InvalidBankNoteValueException e) {
            System.out.println("Nap tien that bai: " + e.getMessage());
        } catch (InvalidValueException e) {
            System.out.println("So tien khong hop le");
        }
    }

    public static void mua(SodaMachine sodaMachine, int slotId) {
        try {
            AbstractProduct product = sodaMachine.selectProduct(slotId);
            System.out.println(String.format("Mua thanh cong 1 lon %s", product.getName()));
        } catch (ProductNotFoundException e) {
            System.out.println("Slot ID khong ton tai");
        } catch (ProductOutOfStockException e) {
            System.out.println("San pham da het hang");
        } catch (BalanceNotEnoughException e) {
            System.out.println("Ban khong du tien");
        } catch (SystemErrorException e) {
            System.out.println("Loi he thong");
            e.printStackTrace();
        }
    }

}
