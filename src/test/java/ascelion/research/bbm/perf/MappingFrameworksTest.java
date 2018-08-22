
package ascelion.research.bbm.perf;

import ascelion.research.bbm.perf.dozer.Dozer5Converter;
import ascelion.research.bbm.perf.dozer.Dozer6Converter;
import ascelion.research.bbm.perf.jmapper.JMapperConverter;
import ascelion.research.bbm.perf.mapstruct.MapStructConverter;
import ascelion.research.bbm.perf.model.destination.DestinationCode;
import ascelion.research.bbm.perf.model.destination.DestinationOrder;
import ascelion.research.bbm.perf.model.source.SourceCode;
import ascelion.research.bbm.perf.model.source.SourceOrder;
import ascelion.research.bbm.perf.modelmapper.ModelMapperConverter;
import ascelion.research.bbm.perf.orika.OrikaConverter;
import ascelion.research.bbm.perf.remap.RemapConverter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith( Parameterized.class )
@RequiredArgsConstructor
public class MappingFrameworksTest
{

	@Parameterized.Parameters( name = "{0}" )
	static public Object data()
	{
		return new Object[] {
			data( new Dozer5Converter() ),
			data( new Dozer6Converter() ),
			data( new JMapperConverter() ),
			data( MapStructConverter.MAPPER ),
			data( new ModelMapperConverter() ),
			data( new OrikaConverter() ),
			data( new RemapConverter() ),
		};
	}

	static private Object[] data( Converter cv )
	{
		return new Object[] { cv.getClass().getSimpleName(), cv };
	}

	private final String testName;
	private final Converter cv;

	@Test
	public void code()
	{
		final SourceCode source = SourceCode.createSample();
		final DestinationCode target = this.cv.convert( source );

		assertThat( target.getCode(), is( equalTo( source.getCode() ) ) );
	}

	@Test
	public void order()
	{
		final SourceOrder source = SourceOrder.createSample();
		final DestinationOrder target = this.cv.convert( source );

		assertThat( target, is( equalTo( source ) ) );
	}

}
