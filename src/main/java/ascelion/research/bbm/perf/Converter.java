
package ascelion.research.bbm.perf;

import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;

public interface Converter
{

	DestinationOrder convert( SourceOrder sourceOrder );

	DestinationCode convert( SourceCode sourceCode );
}
