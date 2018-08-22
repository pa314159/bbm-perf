
package ascelion.research.bbm.perf.model.destination;

import java.util.List;

import ascelion.research.bbm.perf.model.source.SourceOrder;

import com.google.common.base.Objects;
import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationOrder
{

	@JMap
	private User orderingUser;
	@JMap
	private List<Product> orderedProducts;
	@JMap( "status" )
	private OrderStatus orderStatus;
	@JMap
	private String orderDate;
	@JMap
	private String orderFinishDate;
	@JMap
	private PaymentType paymentType;
	@JMap
	private Discount discount;
	@JMap
	private int orderId;
	@JMap
	private DeliveryData deliveryData;
	@JMap
	private Shop offeringShop;

	@Override
	public boolean equals( Object o )
	{
		if( o == this ) {
			return true;
		}
		if( o == null ) {
			return false;
		}

		if( o.getClass() == SourceOrder.class ) {
			final SourceOrder that = (SourceOrder) o;

			return Objects.equal( this.orderingUser, that.getOrderingUser() ) &&
				Objects.equal( this.orderedProducts, that.getOrderedProducts() ) &&
				this.orderStatus.ordinal() == that.getStatus().ordinal() &&
				Objects.equal( this.orderDate, that.getOrderDate() ) &&
				Objects.equal( this.orderFinishDate, that.getOrderFinishDate() ) &&
				this.paymentType.ordinal() == that.getPaymentType().ordinal() &&
				Objects.equal( this.discount, that.getDiscount() ) &&
				Objects.equal( this.deliveryData, that.getDeliveryData() );
		}

		if( o.getClass() != getClass() ) {
			return false;
		}

		final DestinationOrder that = (DestinationOrder) o;

		return Objects.equal( this.orderingUser, that.orderingUser ) &&
			Objects.equal( this.orderedProducts, that.orderedProducts ) &&
			this.orderStatus == that.orderStatus &&
			Objects.equal( this.orderDate, that.orderDate ) &&
			Objects.equal( this.orderFinishDate, that.orderFinishDate ) &&
			this.paymentType == that.paymentType &&
			Objects.equal( this.discount, that.discount ) &&
			Objects.equal( this.deliveryData, that.deliveryData );
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode( this.orderingUser, this.orderedProducts, this.orderStatus, this.orderDate, this.orderFinishDate, this.paymentType, this.discount, this.deliveryData );
	}

	@JMapConversion( from = "status", to = "orderStatus" )
	public OrderStatus conversion( ascelion.research.bbm.perf.model.source.OrderStatus status )
	{
		OrderStatus orderStatus = null;
		switch( status ) {
			case CREATED:
				orderStatus = OrderStatus.CREATED;
			break;
			case FINISHED:
				orderStatus = OrderStatus.FINISHED;
			break;

			case CONFIRMED:
				orderStatus = OrderStatus.CONFIRMED;
			break;

			case COLLECTING:
				orderStatus = OrderStatus.COLLECTING;
			break;

			case IN_TRANSPORT:
				orderStatus = OrderStatus.IN_TRANSPORT;
			break;
		}
		return orderStatus;
	}

	@JMapConversion( from = "paymentType", to = "paymentType" )
	public PaymentType conversion( ascelion.research.bbm.perf.model.source.PaymentType type )
	{
		PaymentType paymentType = null;
		switch( type ) {
			case CARD:
				paymentType = PaymentType.CARD;
			break;

			case CASH:
				paymentType = PaymentType.CASH;
			break;

			case TRANSFER:
				paymentType = PaymentType.TRANSFER;
			break;
		}
		return paymentType;
	}

}
