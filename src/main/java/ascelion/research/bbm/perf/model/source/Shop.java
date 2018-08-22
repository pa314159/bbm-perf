
package ascelion.research.bbm.perf.model.source;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shop
{

	private String shopName;
	private Address shopAddres;
	private String shopUrl;
	private List<Review> reviews;
}
