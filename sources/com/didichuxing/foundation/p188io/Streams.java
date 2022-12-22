package com.didichuxing.foundation.p188io;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;

/* renamed from: com.didichuxing.foundation.io.Streams */
public abstract class Streams {
    private Streams() {
    }

    public static byte[] readFully(InputStream inputStream) throws IOException {
        try {
            return readFullyNoClose(inputStream);
        } finally {
            inputStream.close();
        }
    }

    public static byte[] readFullyNoClose(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String readFullyNoClose(Reader reader) throws IOException {
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    public static String readFully(Reader reader) throws IOException {
        try {
            return readFullyNoClose(reader);
        } finally {
            reader.close();
        }
    }

    public static void consume(InputStream inputStream) throws IOException {
        do {
            inputStream.skip(Long.MAX_VALUE);
        } while (inputStream.read() != -1);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return i;
                }
                i += read;
                outputStream.write(bArr, 0, read);
            } finally {
                outputStream.flush();
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
