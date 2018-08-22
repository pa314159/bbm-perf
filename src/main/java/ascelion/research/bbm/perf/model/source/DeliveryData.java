
package ascelion.research.bbm.perf.model.source;

import com.googlecode.jmapper.annotations.JMapAccessor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
