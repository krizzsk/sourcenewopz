package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.data;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.data.CompactDataInput */
public class CompactDataInput extends DataInputStream {
    public CompactDataInput(InputStream inputStream) {
        super(inputStream);
    }

    public int readVarInt() throws IOException {
        byte readByte = readByte() & 255;
        if ((readByte & 128) == 0) {
            return readByte;
        }
        return (readByte & Byte.MAX_VALUE) | (readVarInt() << 7);
    }

    public boolean[] readBooleanArray() throws IOException {
        int readVarInt = readVarInt();
        boolean[] zArr = new boolean[readVarInt];
        int i = 0;
        for (int i2 = 0; i2 < readVarInt; i2++) {
            if (i2 % 8 == 0) {
                i = readByte();
            }
            zArr[i2] = (i & 1) != 0;
            i >>>= 1;
        }
        return zArr;
    }
}
