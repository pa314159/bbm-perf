
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
public class Product
{

	private BigDecimal price;
	private int quantity;
	private String name;
	private String description;
	private boolean available;
	private RefundPolicy refundPolicy;

	@Override
	public boolean equals( Object o )
	{
		if( o == this ) {
			return true;
		}
		if( o == null ) {
			return false;
		}

		if( o.getClass() == ascelion.research.bbm.perf.model.source.Product.class ) {
			final ascelion.research.bbm.perf.model.source.Product that = (ascelion.research.bbm.perf.model.source.Product) o;

			return this.quantity == that.getQuantity() &&
				this.available == that.isAvailable() &&
				Objects.equal( this.price, that.getPrice() ) &&
				Objects.equal( this.name, that.getName() ) &&
				Objects.equal( this.description, that.getDescription() ) &&
				Objects.equal( this.refundPolicy, that.getRefundPolicy() );
		}

		if( o.getClass() != getClass() ) {
			return false;
		}

		final Product that = (Product) o;

		return this.quantity == that.quantity &&
			this.available == that.available &&
			Objects.equal( this.price, that.price ) &&
			Objects.equal( this.name, that.name ) &&
			Objects.equal( this.description, that.description ) &&
			Objects.equal( this.refundPolicy, that.refundPolicy );
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode( this.price, this.quantity, this.name, this.description, this.available, this.refundPolicy );
	}
}
