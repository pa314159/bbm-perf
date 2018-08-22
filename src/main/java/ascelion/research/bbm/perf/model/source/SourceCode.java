
package ascelion.research.bbm.perf.model.source;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public class SourceCode
{

	private String code;

	static public SourceCode createSample()
	{
		return new SourceCode( "This is source code!" );
	}
}
