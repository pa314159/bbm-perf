
package ascelion.research.bbm.perf.model.destination;

import java.util.Objects;

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
public class Address
{

	private String street;
	private String city;
	private String postalCode;
	private String country;

	@Override
	public boolean equals( Object o )
	{
		if( o == this ) {
			return true;
		}
		if( o == null ) {
			return false;
		}

		if( o.getClass() == ascelion.research.bbm.perf.model.source.Address.class ) {
			final ascelion.research.bbm.perf.model.source.Address that = (ascelion.research.bbm.perf.model.source.Address) o;

			return Objects.equals( this.street, that.getStreet() ) &&
				Objects.equals( this.city, that.getCity() ) &&
				Objects.equals( this.postalCode, that.getPostalCode() ) &&
				Objects.equals( this.country, that.getCountry() );
		}

		if( o.getClass() != getClass() ) {
			return false;
		}

		final Address that = (Address) o;

		return Objects.equals( this.street, that.street ) &&
			Objects.equals( this.city, that.city ) &&
			Objects.equals( this.postalCode, that.postalCode ) &&
			Objects.equals( this.country, that.country );
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( this.street, this.city, this.postalCode, this.country );
	}

}
