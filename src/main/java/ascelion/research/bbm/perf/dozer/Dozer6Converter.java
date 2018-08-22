
package ascelion.research.bbm.perf.dozer;

import java.net.URL;

import ascelion.research.bbm.perf.Converter;
import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class Dozer6Converter implements Converter
{

	private final Mapper mapper;

	public Dozer6Converter()
	{
		final URL mf = getClass().getResource( "/dozer6-mapping.xml" );

		this.mapper = DozerBeanMapperBuilder.create()
			.withMappingFiles( mf.toExternalForm() )
			.build();
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
