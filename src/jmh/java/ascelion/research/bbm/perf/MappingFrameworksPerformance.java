
package ascelion.research.bbm.perf;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

@Fork( value = 1, warmups = 5 )
@OutputTimeUnit( TimeUnit.MILLISECONDS )
@BenchmarkMode( Mode.All )
@Measurement( iterations = 5 )
@State( Scope.Group )
public class MappingFrameworksPerformance
{

	static public void main( String[] args ) throws IOException, RunnerException
	{
		org.openjdk.jmh.Main.main( args );
	}

	private static final Converter ORIKA_CONVERTER = new OrikaConverter();
	private static final Converter JMAPPER_CONVERTER = new JMapperConverter();
	private static final Converter MODEL_MAPPER_CONVERTER = new ModelMapperConverter();
	private static final Converter DOZER5_CONVERTER = new Dozer5Converter();
	private static final Converter DOZER6_CONVERTER = new Dozer6Converter();
	private static final Converter REMAP_CONVERTER = new RemapConverter();

	private SourceOrder sourceOrder;
	private SourceCode sourceCode;

	@Setup
	public void setUp()
	{
		this.sourceOrder = SourceOrder.createSample();
		this.sourceCode = SourceCode.createSample();
	}

	////

	@Benchmark
	@Group( "realLifeTest" )
	public DestinationOrder orikaMapperRealLifeBenchmark()
	{
		return ORIKA_CONVERTER.convert( this.sourceOrder );
	}

	@Benchmark
	@Group( "realLifeTest" )
	public DestinationOrder jmapperRealLifeBenchmark()
	{
		return JMAPPER_CONVERTER.convert( this.sourceOrder );
	}

	@Benchmark
	@Group( "realLifeTest" )
	public DestinationOrder modelMapperRealLifeBenchmark()
	{
		return MODEL_MAPPER_CONVERTER.convert( this.sourceOrder );
	}

	@Benchmark
	@Group( "realLifeTest" )
	public DestinationOrder dozer5MapperRealLifeBenchmark()
	{
		return DOZER5_CONVERTER.convert( this.sourceOrder );
	}

	@Benchmark
	@Group( "realLifeTest" )
	public DestinationOrder dozer6MapperRealLifeBenchmark()
	{
		return DOZER6_CONVERTER.convert( this.sourceOrder );
	}

	@Benchmark
	@Group( "realLifeTest" )
	public DestinationOrder remapMapperRealLifeBenchmark()
	{
		return REMAP_CONVERTER.convert( this.sourceOrder );
	}

	@Benchmark
	@Group( "realLifeTest" )
	public DestinationOrder mapStructRealLifeMapperBenchmark()
	{
		return MapStructConverter.MAPPER.convert( this.sourceOrder );
	}

	////

	@Benchmark
	@Group( "simpleTest" )
	public DestinationCode orikaMapperSimpleBenchmark()
	{
		return ORIKA_CONVERTER.convert( this.sourceCode );
	}

	@Benchmark
	@Group( "simpleTest" )
	public DestinationCode jmapperSimpleBenchmark()
	{
		return JMAPPER_CONVERTER.convert( this.sourceCode );
	}

	@Benchmark
	@Group( "simpleTest" )
	public DestinationCode modelMapperBenchmark()
	{
		return MODEL_MAPPER_CONVERTER.convert( this.sourceCode );
	}

	@Benchmark
	@Group( "simpleTest" )
	public DestinationCode dozer5MapperSimpleBenchmark()
	{
		return DOZER5_CONVERTER.convert( this.sourceCode );
	}

	@Benchmark
	@Group( "simpleTest" )
	public DestinationCode dozer6MapperSimpleBenchmark()
	{
		return DOZER6_CONVERTER.convert( this.sourceCode );
	}

	@Benchmark
	@Group( "simpleTest" )
	public DestinationCode remapMapperSimpleBenchmark()
	{
		return REMAP_CONVERTER.convert( this.sourceCode );
	}

	@Benchmark
	@Group( "simpleTest" )
	public DestinationCode mapStructMapperSimpleBenchmark()
	{
		return MapStructConverter.MAPPER.convert( this.sourceCode );
	}
}
