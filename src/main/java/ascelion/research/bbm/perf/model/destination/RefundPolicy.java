
package ascelion.research.bbm.perf.model.destination;

import java.util.List;

import com.google.common.base.Objects;
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
public class RefundPolicy
{

	@JMapAccessor( get = "isRefundable", set = "setRefundable" )
	private boolean isRefundable;
	private int refundTimeInDays;
	private List<String> notes;

	@Override
	public boolean equals( Object o )
	{
		if( o == this ) {
			return true;
		}
		if( o == null ) {
			return false;
		}

		if( o.getClass() == ascelion.research.bbm.perf.model.source.RefundPolicy.class ) {
			final ascelion.research.bbm.perf.model.source.RefundPolicy that = (ascelion.research.bbm.perf.model.source.RefundPolicy) o;

			return this.isRefundable == that.isRefundable() &&
				this.refundTimeInDays == that.getRefundTimeInDays() &&
				Objects.equal( this.notes, that.getNotes() );
		}

		if( o.getClass() != getClass() ) {
			return false;
		}

		final RefundPolicy that = (RefundPolicy) o;

		return this.isRefundable == that.isRefundable &&
			this.refundTimeInDays == that.refundTimeInDays &&
			Objects.equal( this.notes, that.notes );
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode( this.isRefundable, this.refundTimeInDays, this.notes );
	}
}
