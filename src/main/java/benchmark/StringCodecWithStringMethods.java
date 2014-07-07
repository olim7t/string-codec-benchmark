package benchmark;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public class StringCodecWithStringMethods implements StringCodec {
    private final Charset charset;

    public StringCodecWithStringMethods() {
        this.charset = Charset.forName("UTF-8");
    }

    @Override
    public ByteBuffer serialize(String value) {
        return ByteBuffer.wrap(value.getBytes(charset));
    }

    @Override
    public String deserialize(ByteBuffer bytes) {
        return new String(getArray(bytes), charset);
    }

    // copied from Bytes in the java driver sources
    private static byte[] getArray(ByteBuffer bytes) {
        int length = bytes.remaining();

        if (bytes.hasArray()) {
            int boff = bytes.arrayOffset() + bytes.position();
            if (boff == 0 && length == bytes.array().length)
                return bytes.array();
            else
                return Arrays.copyOfRange(bytes.array(), boff, boff + length);
        }
        // else, DirectByteBuffer.get() is the fastest route
        byte[] array = new byte[length];
        bytes.duplicate().get(array);
        return array;
    }

}
