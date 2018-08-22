
package ascelion.research.bbm.perf.model.source;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount
{

	private String startTime;
	private String endTime;
	private BigDecimal discountPrice;

}
