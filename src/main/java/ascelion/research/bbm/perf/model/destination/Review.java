
package ascelion.research.bbm.perf.model.destination;

import ascelion.research.bbm.perf.model.source.User;

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
public class Review
{

	private int shippingGrade;
	private int pricingGrade;
	private int serviceGrade;
	private User reviewingUser;
	private String note;

}
