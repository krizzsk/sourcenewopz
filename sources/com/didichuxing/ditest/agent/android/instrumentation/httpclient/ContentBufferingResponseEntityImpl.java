package com.didichuxing.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.ditest.agent.android.instrumentation.p187io.CountingInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class ContentBufferingResponseEntityImpl implements HttpEntity {
    private CountingInputStream contentStream;
    final HttpEntity impl;

    public ContentBufferingResponseEntityImpl(HttpEntity httpEntity) {
        if (httpEntity != null) {
            this.impl = httpEntity;
            return;
        }
        throw new IllegalArgumentException("Missing wrapped entity");
    }

    public void consumeContent() throws IOException {
        this.impl.consumeContent();
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        CountingInputStream countingInputStream = this.contentStream;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        CountingInputStream countingInputStream2 = new CountingInputStream(this.impl.getContent(), true);
        this.contentStream = countingInputStream2;
        return countingInputStream2;
    }

    public Header getContentEncoding() {
        return this.impl.getContentEncoding();
    }

    public long getContentLength() {
        return this.impl.getContentLength();
    }

    public Header getContentType() {
        return this.impl.getContentType();
    }

    public boolean isChunked() {
        return this.impl.isChunked();
    }

    public boolean isRepeatable() {
        return this.impl.isRepeatable();
    }

    public boolean isStreaming() {
        return this.impl.isStreaming();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.impl.writeTo(outputStream);
    }
}
