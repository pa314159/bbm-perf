
package ascelion.research.bbm.perf.model.source;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review
{

	private int shippingGrade;
	private int pricingGrade;
	private int serviceGrade;
	private User reviewingUser;
	private String note;
}
