
package ascelion.research.bbm.perf.mapstruct;

import ascelion.research.bbm.perf.Converter;
import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructConverter extends Converter
{

	MapStructConverter MAPPER = Mappers.getMapper( MapStructConverter.class );

	@Mapping( source = "status", target = "orderStatus" )
	@Override
	DestinationOrder convert( SourceOrder sourceOrder );

	@Override
	DestinationCode convert( SourceCode sourceCode );
}
