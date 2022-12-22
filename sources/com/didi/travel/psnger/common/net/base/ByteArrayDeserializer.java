package com.didi.travel.psnger.common.net.base;

import com.didichuxing.foundation.p188io.AbstractDeserializer;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayDeserializer extends AbstractDeserializer<byte[]> {
    public byte[] deserialize(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[512];
        byte[] bArr2 = null;
        int i = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= -1) {
                    break;
                }
                int i2 = i + read;
                byte[] bArr3 = new byte[i2];
                if (bArr2 != null) {
                    System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                }
                System.arraycopy(bArr, 0, bArr3, i, read);
                i = i2;
                bArr2 = bArr3;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        return bArr2;
    }
}
