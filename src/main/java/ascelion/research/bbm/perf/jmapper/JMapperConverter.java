
package ascelion.research.bbm.perf.jmapper;

import ascelion.research.bbm.perf.Converter;
import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

public class JMapperConverter implements Converter
{

	JMapper realLifeMapper;
	JMapper simpleMapper;

	public JMapperConverter()
	{
		final JMapperAPI api = new JMapperAPI().add( JMapperAPI.mappedClass( DestinationOrder.class ) );
		this.realLifeMapper = new JMapper( DestinationOrder.class, SourceOrder.class, api );
		final JMapperAPI simpleApi = new JMapperAPI().add( JMapperAPI.mappedClass( DestinationCode.class ) );
		this.simpleMapper = new JMapper( DestinationCode.class, SourceCode.class, simpleApi );
	}

	@Override
	public DestinationOrder convert( SourceOrder sourceOrder )
	{
		return (DestinationOrder) this.realLifeMapper.getDestination( sourceOrder );
	}

	@Override
	public DestinationCode convert( SourceCode sourceCode )
	{
		return (DestinationCode) this.simpleMapper.getDestination( sourceCode );
	}
}
