
package ascelion.research.bbm.perf.dozer;

import ascelion.research.bbm.perf.Converter;
import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class Dozer5Converter implements Converter
{

	private final Mapper mapper;

	public Dozer5Converter()
	{
		final DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping( getClass().getResourceAsStream( "/dozer5-mapping.xml" ) );
		this.mapper = mapper;
	}

	@Override
	public DestinationOrder convert( SourceOrder sourceOrder )
	{
		return this.mapper.map( sourceOrder, DestinationOrder.class );
	}

	@Override
	public DestinationCode convert( SourceCode sourceCode )
	{
		return this.mapper.map( sourceCode, DestinationCode.class );
	}
}
