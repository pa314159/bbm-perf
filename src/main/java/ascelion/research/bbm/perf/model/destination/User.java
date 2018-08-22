
package ascelion.research.bbm.perf.model.destination;

import com.google.common.base.Objects;
import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMapConversion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JGlobalMap
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User
{

	private String username;
	private String email;
	private AccountStatus userAccountStatus;

	@Override
	public boolean equals( Object o )
	{
		if( o == this ) {
			return true;
		}
		if( o == null ) {
			return false;
		}

		if( o.getClass() == ascelion.research.bbm.perf.model.source.User.class ) {
			final ascelion.research.bbm.perf.model.source.User that = (ascelion.research.bbm.perf.model.source.User) o;

			return Objects.equal( this.username, that.getUsername() ) &&
				Objects.equal( this.email, that.getEmail() ) &&
				this.userAccountStatus.ordinal() == that.getUserAccountStatus().ordinal();
		}

		if( o.getClass() != getClass() ) {
			return false;
		}

		final User that = (User) o;

		return Objects.equal( this.username, that.username ) &&
			Objects.equal( this.email, that.email ) &&
			this.userAccountStatus == that.userAccountStatus;
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode( this.username, this.email, this.userAccountStatus );
	}

	@JMapConversion( from = "userAccountStatus", to = "userAccountStatus" )
	public AccountStatus conversion( ascelion.research.bbm.perf.model.source.AccountStatus status )
	{
		AccountStatus accountStatus = null;
		switch( status ) {
			case ACTIVE:
				accountStatus = AccountStatus.ACTIVE;
			break;
			case NOT_ACTIVE:
				accountStatus = AccountStatus.NOT_ACTIVE;
			break;

			case BANNED:
				accountStatus = AccountStatus.BANNED;
			break;
		}
		return accountStatus;
	}
}
