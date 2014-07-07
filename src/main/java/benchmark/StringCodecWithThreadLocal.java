package benchmark;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;

public class StringCodecWithThreadLocal implements StringCodec {
    private static final Charset utf8Charset = Charset.forName("UTF-8");

    private static final ThreadLocal<CharsetDecoder> utf8Decoders = new ThreadLocal<CharsetDecoder>() {
        @Override
        protected CharsetDecoder initialValue() {
            return utf8Charset.newDecoder();
        }
    };
    private static final ThreadLocal<CharsetEncoder> utf8Encoders = new ThreadLocal<CharsetEncoder>() {
        @Override
        protected CharsetEncoder initialValue() {
            return utf8Charset.newEncoder();
        }
    };

    @Override
    public ByteBuffer serialize(String value) throws Exception {
        return utf8Encoders.get().encode(CharBuffer.wrap(value));
    }

    @Override
    public String deserialize(ByteBuffer bytes) throws Exception {
        return utf8Decoders.get().decode(bytes.duplicate()).toString();
    }
}
