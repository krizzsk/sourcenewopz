package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public interface HttpEntity extends Closeable {
    Charset getCharset();

    InputStream getContent() throws IOException;

    long getContentLength() throws IOException;

    MimeType getContentType();

    String getTransferEncoding();

    void writeTo(OutputStream outputStream) throws IOException;
}
