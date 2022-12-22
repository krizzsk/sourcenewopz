package com.turbomanage.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public interface RequestHandler {
    public static final String UTF8 = "UTF-8";

    boolean onError(HttpRequestException httpRequestException);

    HttpURLConnection openConnection(String str) throws IOException;

    InputStream openInput(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream openOutput(HttpURLConnection httpURLConnection) throws IOException;

    void prepareConnection(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) throws IOException;

    byte[] readStream(InputStream inputStream) throws IOException;

    void writeStream(OutputStream outputStream, byte[] bArr) throws IOException;
}
