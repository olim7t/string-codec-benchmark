package benchmark;

import java.nio.ByteBuffer;

public interface StringCodec {
    ByteBuffer serialize(String value) throws Exception;
    String deserialize(ByteBuffer bytes) throws Exception;
}
