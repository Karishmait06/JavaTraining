import java.lang.annotation.*;

// Annotation Definition
@Retention(RetentionPolicy.RUNTIME)   // Exists only in source code
@Target(ElementType.TYPE)            // Can be applied to classes
@interface DiscountEligible {
}




class Laptop {
    double price = 50000;
}

@DiscountEligible
class GiftCard {
    double price = 1000;
}

// Business Service

class DiscountService {

    // Only discountable product type allowed
    double applyDiscount(GiftCard product) {
        return product.price * 0.9;   // 10% discount
    }
}

// Application Entry Point

public class AnnotationBasic {

    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        GiftCard giftCard = new GiftCard();

        DiscountService service = new DiscountService();

        double discountedPrice = service.applyDiscount(giftCard);

        System.out.println("Original Gift Card Price: " + giftCard.price);
        System.out.println("Discounted Gift Card Price: " + discountedPrice);


        service.applyDiscount(giftCard);
    }
}
