
package ascelion.research.bbm.perf.model.destination;

import java.util.Objects;

import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMapAccessor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JGlobalMap
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryData
{

	private Address deliveryAddress;
	@JMapAccessor( get = "isPrePaid", set = "setPrePaid" )
	private boolean isPrePaid;
	private String trackingCode;
	private int expectedDeliveryTimeInDays;

	@SuppressWarnings( "unlikely-arg-type" )
	@Override
	public boolean equals( Object o )
	{
		if( o == this ) {
			return true;
		}
		if( o == null ) {
			return false;
		}

		if( o.getClass() == ascelion.research.bbm.perf.model.source.DeliveryData.class ) {
			final ascelion.research.bbm.perf.model.source.DeliveryData that = (ascelion.research.bbm.perf.model.source.DeliveryData) o;

			return this.isPrePaid == that.isPrePaid() &&
				this.expectedDeliveryTimeInDays == that.getExpectedDeliveryTimeInDays() &&
				Objects.equals( this.deliveryAddress, that.getDeliveryAddress() ) &&
				Objects.equals( this.trackingCode, that.getTrackingCode() );
		}

		if( o.getClass() != getClass() ) {
			return false;
		}

		final DeliveryData that = (DeliveryData) o;

		return this.isPrePaid == that.isPrePaid &&
			this.expectedDeliveryTimeInDays == that.expectedDeliveryTimeInDays &&
			Objects.equals( this.deliveryAddress, that.deliveryAddress ) &&
			Objects.equals( this.trackingCode, that.trackingCode );
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( this.deliveryAddress, this.isPrePaid, this.trackingCode, this.expectedDeliveryTimeInDays );
	}
}
