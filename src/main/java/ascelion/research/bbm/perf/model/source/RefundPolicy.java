
package ascelion.research.bbm.perf.model.source;

import java.util.List;

import com.googlecode.jmapper.annotations.JMapAccessor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
