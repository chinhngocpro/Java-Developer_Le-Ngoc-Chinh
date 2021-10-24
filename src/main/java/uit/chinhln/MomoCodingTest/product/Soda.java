package uit.chinhln.MomoCodingTest.product;

public class Soda extends AbstractProduct {

    public Soda() {
        this.setName("Soda");
        this.setPrice(20000);
    }

    public Soda(int id) {
        this();
        this.setId(id);
    }
}
