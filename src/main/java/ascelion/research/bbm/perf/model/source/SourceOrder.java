
package ascelion.research.bbm.perf.model.source;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public class SourceOrder
{

	static public SourceOrder createSample()
	{
		final User user = new User( "John", "John@doe.com", AccountStatus.ACTIVE );
		final RefundPolicy refundPolicy = new RefundPolicy( true, 30, Collections
			.singletonList( "Refundable only if not used!" ) );

		final Product product = new Product(	BigDecimal.valueOf( 10.99 ),
												100,
												"Sample Product",
												"Sample Product to be sold",
												true,
												refundPolicy );

		final Discount discount = new Discount( Instant.now().toString(), Instant.now().toString(), BigDecimal.valueOf( 5.99 ) );
		final Address deliveryAddress = new Address( "Washington Street 5", "New York", "55045", "USA" );
		final DeliveryData deliveryData = new DeliveryData( deliveryAddress, true, "", 10 );
		final Address shopAddress = new Address( "Roosvelt Street 9", "Boston", "55042", "USA" );
		final User reviewingUser = new User( "John", "Johhny@John.com", AccountStatus.ACTIVE );
		final User negativeReviewingUser = new User( "Carl", "Carl@Coral.com", AccountStatus.ACTIVE );
		final Review review = new Review( 5, 5, 5, reviewingUser, "The best shop I've ever bought things in" );

		final Review negativeReview = new Review( 1, 1, 1, negativeReviewingUser, "I will never buy anything again here!" );

		final List<Review> reviewList = new ArrayList<>();
		reviewList.add( review );
		reviewList.add( negativeReview );
		final Shop shop = new Shop( "Super Shop", shopAddress, "www.super-shop.com", reviewList );

		return new SourceOrder(	OrderStatus.CONFIRMED,
								Instant.now().toString(),
								Instant.MAX.toString(),
								PaymentType.TRANSFER,
								discount,
								deliveryData,
								user,
								Collections.singletonList( product ),
								shop,
								1 );

	}

	private OrderStatus status;
	private String orderDate;
	private String orderFinishDate;
	private PaymentType paymentType;
	private Discount discount;
	private DeliveryData deliveryData;
	private User orderingUser;
	private List<Product> orderedProducts;
	private Shop offeringShop;
	private int orderId;
}
