
package ascelion.research.bbm.perf.model.destination;

import java.util.List;

import ascelion.research.bbm.perf.model.source.Address;

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
public class Shop
{

	private String shopName;
	private Address shopAddres;
	private String shopUrl;
	private List<Review> reviews;
}
