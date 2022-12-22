package com.didi.sdk.audiorecorder.utils;

import android.net.Uri;
import com.didichuxing.foundation.p188io.Streams;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class IOUtil {
    public static boolean saveFile(String str, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        if (!(str == null || str.length() <= 0 || inputStream == null)) {
            try {
                fileOutputStream = new FileOutputStream(str);
                Streams.copy(inputStream, fileOutputStream);
                Streams.closeQuietly(fileOutputStream);
                return true;
            } catch (Exception unused) {
            } catch (Throwable th) {
                Streams.closeQuietly(fileOutputStream);
                throw th;
            }
        }
        return false;
    }

    public static void save(Uri uri, byte[] bArr) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(uri.getPath()));
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteExpireFile(File file, long j) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (!file2.isDirectory()) {
                        if (TimeUtil.currentTimeMillis() - file2.lastModified() > j) {
                            file2.delete();
                        }
                        String absolutePath = file2.getAbsolutePath();
                        if (file2.length() / 1024 > 5120 && !absolutePath.endsWith("-1.txt")) {
                            File file3 = new File(absolutePath + "-1.txt");
                            if (file3.exists() && file3.isFile()) {
                                file3.delete();
                            }
                            if (file2.exists()) {
                                file2.renameTo(file3);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void closeQuitely(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

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
        byte[] allocate = ByteArrayAllocator.allocate(8192);
        long j = 0;
        if (allocate == null) {
            return 0;
        }
        while (true) {
            try {
                int read = inputStream.read(allocate);
                if (read == -1) {
                    return j;
                }
                j += (long) read;
                outputStream.write(allocate, 0, read);
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
}
