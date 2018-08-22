
package ascelion.research.bbm.perf.model.source;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User
{

	private String username;
	private String email;
	private AccountStatus userAccountStatus;
}
