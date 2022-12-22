package com.turbomanage.httpclient;

import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class BasicRequestHandler implements RequestHandler {
    private final RequestLogger logger;

    public BasicRequestHandler() {
        this(new ConsoleRequestLogger());
    }

    public BasicRequestHandler(RequestLogger requestLogger) {
        this.logger = requestLogger;
    }

    public HttpURLConnection openConnection(String str) throws IOException {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public void prepareConnection(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) throws IOException {
        httpURLConnection.setRequestMethod(httpMethod.getMethodName());
        httpURLConnection.setDoOutput(httpMethod.getDoOutput());
        httpURLConnection.setDoInput(httpMethod.getDoInput());
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
    }

    public OutputStream openOutput(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    public void writeStream(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }

    public InputStream openInput(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    public byte[] readStream(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public boolean onError(HttpRequestException httpRequestException) {
        HttpResponse httpResponse = httpRequestException.getHttpResponse();
        if (this.logger.isLoggingEnabled()) {
            this.logger.log("BasicRequestHandler.onError got");
            httpRequestException.printStackTrace();
        }
        return httpResponse != null && httpResponse.getStatus() > 0;
    }
}
