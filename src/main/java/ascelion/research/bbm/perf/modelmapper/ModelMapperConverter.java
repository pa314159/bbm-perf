
package ascelion.research.bbm.perf.modelmapper;

import ascelion.research.bbm.perf.Converter;
import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;

import org.modelmapper.ModelMapper;

public class ModelMapperConverter implements Converter
{

	private final ModelMapper modelMapper;

	public ModelMapperConverter()
	{
		this.modelMapper = new ModelMapper();
	}

	@Override
	public DestinationOrder convert( SourceOrder sourceOrder )
	{
		return this.modelMapper.map( sourceOrder, DestinationOrder.class );
	}

	@Override
	public DestinationCode convert( SourceCode sourceCode )
	{
		return this.modelMapper.map( sourceCode, DestinationCode.class );
	}
}
