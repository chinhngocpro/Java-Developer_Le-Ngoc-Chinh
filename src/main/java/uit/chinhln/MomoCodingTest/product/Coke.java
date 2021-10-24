package uit.chinhln.MomoCodingTest.product;

public class Coke extends AbstractProduct {

    public Coke() {
        this.setName("Coke");
        this.setPrice(10000);
    }

    public Coke(int id) {
        this();
        this.setId(id);
    }

}
