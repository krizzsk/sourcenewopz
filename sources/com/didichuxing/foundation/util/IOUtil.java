package com.didichuxing.foundation.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class IOUtil {
    public static byte[] readAsByteArray(String str) throws IOException {
        return readAsByteArray(new File(str));
    }

    public static byte[] readAsByteArray(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return readAsByteArray((InputStream) fileInputStream);
        } finally {
            close(fileInputStream);
        }
    }

    public static byte[] readAsByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(inputStream, (OutputStream) byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
            close(byteArrayOutputStream);
        }
    }

    public static String readAsString(String str) throws IOException {
        return readAsString(new File(str));
    }

    public static String readAsString(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        try {
            return readAsString((Reader) fileReader);
        } finally {
            close(fileReader);
        }
    }

    public static String readAsString(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        try {
            copy(reader, (Writer) stringWriter);
            return stringWriter.toString();
        } finally {
            close(stringWriter);
        }
    }

    public static long copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[8192];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            j += (long) read;
            writer.write(cArr, 0, read);
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return j;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                outputStream.flush();
            }
        }
    }

    public static final void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private IOUtil() {
    }
}
