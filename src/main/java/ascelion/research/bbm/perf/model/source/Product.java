
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
public class Product
{

	private BigDecimal price;
	private int quantity;
	private String name;
	private String description;
	boolean available;
	private RefundPolicy refundPolicy;
}
