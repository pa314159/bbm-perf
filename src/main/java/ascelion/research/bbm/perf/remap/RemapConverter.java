
package ascelion.research.bbm.perf.remap;

import ascelion.research.bbm.perf.Converter;
import ascelion.research.bbm.perf.model.destination.AccountStatus;
import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.destination.OrderStatus;
import ascelion.research.bbm.perf.model.destination.PaymentType;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;

import com.remondis.remap.Mapping;

public class RemapConverter implements Converter
{

	@Override
	public DestinationOrder convert( SourceOrder sourceOrder )
	{
		return Mapping.from( SourceOrder.class )
			.to( DestinationOrder.class )

			.replace( SourceOrder::getStatus, DestinationOrder::getOrderStatus )
			.with( s -> OrderStatus.valueOf( s.name() ) )

			.replace( SourceOrder::getPaymentType, DestinationOrder::getPaymentType )
			.with( s -> PaymentType.valueOf( s.name() ) )

			.replace( SourceOrder::getDiscount, DestinationOrder::getDiscount )
			.with( Mapping
				.from( ascelion.research.bbm.perf.model.source.Discount.class )
				.to( ascelion.research.bbm.perf.model.destination.Discount.class )
				.mapper()::map )

			.replace( SourceOrder::getDeliveryData, DestinationOrder::getDeliveryData )
			.with( Mapping
				.from( ascelion.research.bbm.perf.model.source.DeliveryData.class )
				.to( ascelion.research.bbm.perf.model.destination.DeliveryData.class )

				.replace( ascelion.research.bbm.perf.model.source.DeliveryData::getDeliveryAddress, ascelion.research.bbm.perf.model.destination.DeliveryData::getDeliveryAddress )
				.with( Mapping
					.from( ascelion.research.bbm.perf.model.source.Address.class )
					.to( ascelion.research.bbm.perf.model.destination.Address.class )
					.mapper()::map )

				.mapper()::map )

			.replaceCollection( SourceOrder::getOrderedProducts, DestinationOrder::getOrderedProducts )
			.with( Mapping
				.from( ascelion.research.bbm.perf.model.source.Product.class )
				.to( ascelion.research.bbm.perf.model.destination.Product.class )
				.replace( ascelion.research.bbm.perf.model.source.Product::getRefundPolicy, ascelion.research.bbm.perf.model.destination.Product::getRefundPolicy )
				.with( Mapping
					.from( ascelion.research.bbm.perf.model.source.RefundPolicy.class )
					.to( ascelion.research.bbm.perf.model.destination.RefundPolicy.class )
					.mapper()::map )
				.mapper()::map )

			.replace( SourceOrder::getOrderingUser, DestinationOrder::getOrderingUser )
			.with( Mapping
				.from( ascelion.research.bbm.perf.model.source.User.class )
				.to( ascelion.research.bbm.perf.model.destination.User.class )

				.replace( ascelion.research.bbm.perf.model.source.User::getUserAccountStatus, ascelion.research.bbm.perf.model.destination.User::getUserAccountStatus )
				.with( s -> AccountStatus.valueOf( s.name() ) )

				.mapper()::map )

			.replace( SourceOrder::getOfferingShop, DestinationOrder::getOfferingShop )
			.with( Mapping
				.from( ascelion.research.bbm.perf.model.source.Shop.class )
				.to( ascelion.research.bbm.perf.model.destination.Shop.class )

				.replace( ascelion.research.bbm.perf.model.source.Shop::getReviews, ascelion.research.bbm.perf.model.destination.Shop::getReviews )
				.with( Mapping
					.from( ascelion.research.bbm.perf.model.source.Review.class )
					.to( ascelion.research.bbm.perf.model.destination.Review.class )
					.mapper()::map )

				.mapper()::map )

			.mapper()
			.map( sourceOrder );
	}

	@Override
	public DestinationCode convert( SourceCode sourceCode )
	{
		return Mapping.from( SourceCode.class )
			.to( DestinationCode.class )
			.mapper()
			.map( sourceCode );
	}

}
