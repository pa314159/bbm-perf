
package ascelion.research.bbm.perf.orika;

import ascelion.research.bbm.perf.Converter;
import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConverter implements Converter
{

	private final MapperFacade mapperFacade;

	public OrikaConverter()
	{
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		mapperFactory.classMap( DestinationOrder.class, SourceOrder.class ).field( "orderStatus", "status" ).byDefault().register();
		this.mapperFacade = mapperFactory.getMapperFacade();
	}

	@Override
	public DestinationOrder convert( SourceOrder sourceOrder )
	{
		return this.mapperFacade.map( sourceOrder, DestinationOrder.class );
	}

	@Override
	public DestinationCode convert( SourceCode sourceCode )
	{
		return this.mapperFacade.map( sourceCode, DestinationCode.class );
	}
}
