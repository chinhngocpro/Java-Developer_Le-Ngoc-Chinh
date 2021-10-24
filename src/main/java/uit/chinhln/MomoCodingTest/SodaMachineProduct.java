package uit.chinhln.MomoCodingTest;

import lombok.*;
import uit.chinhln.MomoCodingTest.product.AbstractProduct;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SodaMachineProduct {

    int id;

    @NonNull
    AbstractProduct product;

    int stock;
}
