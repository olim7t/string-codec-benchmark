package benchmark;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;

public class StringCodecWithoutThreadLocal implements StringCodec {
    private static final Charset utf8Charset = Charset.forName("UTF-8");

    @Override
    public ByteBuffer serialize(String value) throws Exception {
        return utf8Charset.newEncoder().encode(CharBuffer.wrap(value));
    }

    @Override
    public String deserialize(ByteBuffer bytes) throws Exception {
        return utf8Charset.newDecoder().decode(bytes.duplicate()).toString();
    }
}
