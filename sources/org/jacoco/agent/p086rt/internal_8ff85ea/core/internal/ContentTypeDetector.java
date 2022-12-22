package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.ContentTypeDetector */
public class ContentTypeDetector {
    private static final int BUFFER_SIZE = 8;
    public static final int CLASSFILE = -889275714;
    public static final int GZFILE = 529203200;
    public static final int PACK200FILE = -889270259;
    public static final int UNKNOWN = -1;
    public static final int ZIPFILE = 1347093252;

    /* renamed from: in */
    private final InputStream f6591in;
    private final int type;

    public ContentTypeDetector(InputStream inputStream) throws IOException {
        if (inputStream.markSupported()) {
            this.f6591in = inputStream;
        } else {
            this.f6591in = new BufferedInputStream(inputStream, 8);
        }
        this.f6591in.mark(8);
        this.type = determineType(this.f6591in);
        this.f6591in.reset();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0 != 1347093252) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int determineType(java.io.InputStream r3) throws java.io.IOException {
        /*
            int r0 = readInt(r3)
            r1 = -889275714(0xffffffffcafebabe, float:-8346975.0)
            if (r0 == r1) goto L_0x0015
            r3 = -889270259(0xffffffffcafed00d, float:-8349702.5)
            if (r0 == r3) goto L_0x0014
            r3 = 1347093252(0x504b0304, float:1.36238899E10)
            if (r0 == r3) goto L_0x0014
            goto L_0x0021
        L_0x0014:
            return r3
        L_0x0015:
            int r3 = readInt(r3)
            r2 = 196653(0x3002d, float:2.7557E-40)
            if (r3 == r2) goto L_0x002b
            switch(r3) {
                case 46: goto L_0x002b;
                case 47: goto L_0x002b;
                case 48: goto L_0x002b;
                case 49: goto L_0x002b;
                case 50: goto L_0x002b;
                case 51: goto L_0x002b;
                case 52: goto L_0x002b;
                case 53: goto L_0x002b;
                default: goto L_0x0021;
            }
        L_0x0021:
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r3 = r3 & r0
            r0 = 529203200(0x1f8b0000, float:5.886879E-20)
            if (r3 != r0) goto L_0x0029
            return r0
        L_0x0029:
            r3 = -1
            return r3
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.ContentTypeDetector.determineType(java.io.InputStream):int");
    }

    private static int readInt(InputStream inputStream) throws IOException {
        return inputStream.read() | (inputStream.read() << 24) | (inputStream.read() << 16) | (inputStream.read() << 8);
    }

    public InputStream getInputStream() {
        return this.f6591in;
    }

    public int getType() {
        return this.type;
    }
}
