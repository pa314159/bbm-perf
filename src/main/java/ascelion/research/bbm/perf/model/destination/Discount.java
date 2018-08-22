
package ascelion.research.bbm.perf.model.destination;

import java.math.BigDecimal;

import com.google.common.base.Objects;
import com.googlecode.jmapper.annotations.JGlobalMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JGlobalMap
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount
{

	private String startTime;
	private String endTime;
	private BigDecimal discountPrice;

	@Override
	public boolean equals( Object o )
	{
		if( o == this ) {
			return true;
		}
		if( o == null ) {
			return false;
		}

		if( o.getClass() == ascelion.research.bbm.perf.model.source.Discount.class ) {
			final ascelion.research.bbm.perf.model.source.Discount that = (ascelion.research.bbm.perf.model.source.Discount) o;

			return Objects.equal( this.startTime, that.getStartTime() ) &&
				Objects.equal( this.endTime, that.getEndTime() ) &&
				Objects.equal( this.discountPrice, that.getDiscountPrice() );
		}

		if( o.getClass() != getClass() ) {
			return false;
		}

		final Discount that = (Discount) o;

		return Objects.equal( this.startTime, that.startTime ) &&
			Objects.equal( this.endTime, that.endTime ) &&
			Objects.equal( this.discountPrice, that.discountPrice );
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode( this.startTime, this.endTime, this.discountPrice );
	}
}
