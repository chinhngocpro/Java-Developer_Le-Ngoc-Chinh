package uit.chinhln.MomoCodingTest.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractProduct implements Cloneable{

    int id;

    String name;

    int price;

    @Override
    public AbstractProduct clone() {
        try {
            AbstractProduct clone = (AbstractProduct) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
