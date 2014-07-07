package benchmark;

import java.util.Random;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Benchmark;

@State(Scope.Thread)
public class StringCodecBenchmark {

    Random random = new Random();

    @Benchmark
    public String testCodecWithStringMethods() throws Exception {
        return testCodec(new StringCodecWithStringMethods());
    }

    @Benchmark
    public String testCodecWithoutThreadLocal() throws Exception {
        return testCodec(new StringCodecWithoutThreadLocal());
    }

    @Benchmark
    public String testCodecWithThreadLocal() throws Exception {
        return testCodec(new StringCodecWithThreadLocal());
    }

    private String testCodec(StringCodec codec) throws Exception {
        String input = Integer.toString(random.nextInt());
        String result = codec.deserialize(codec.serialize(input));
        if (!input.equals(result))
            throw new AssertionError(input + " " + result);
        return result;
    }
}
