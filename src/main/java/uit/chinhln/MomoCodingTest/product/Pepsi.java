package uit.chinhln.MomoCodingTest.product;

public class Pepsi extends AbstractProduct {
    public Pepsi() {
        this.setName("Pepsi");
        this.setPrice(10000);
    }

    public Pepsi(int id) {
        this();
        this.setId(id);
    }
}
