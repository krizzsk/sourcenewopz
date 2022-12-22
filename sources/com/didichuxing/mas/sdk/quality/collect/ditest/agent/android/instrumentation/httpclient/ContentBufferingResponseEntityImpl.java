package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class ContentBufferingResponseEntityImpl implements HttpEntity {

    /* renamed from: a */
    final HttpEntity f47975a;

    /* renamed from: b */
    private CountingInputStream f47976b;

    public ContentBufferingResponseEntityImpl(HttpEntity httpEntity) {
        if (httpEntity != null) {
            this.f47975a = httpEntity;
            return;
        }
        throw new IllegalArgumentException("Missing wrapped entity");
    }

    public void consumeContent() throws IOException {
        this.f47975a.consumeContent();
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        CountingInputStream countingInputStream = this.f47976b;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        CountingInputStream countingInputStream2 = new CountingInputStream(this.f47975a.getContent(), true);
        this.f47976b = countingInputStream2;
        return countingInputStream2;
    }

    public Header getContentEncoding() {
        return this.f47975a.getContentEncoding();
    }

    public long getContentLength() {
        return this.f47975a.getContentLength();
    }

    public Header getContentType() {
        return this.f47975a.getContentType();
    }

    public boolean isChunked() {
        return this.f47975a.isChunked();
    }

    public boolean isRepeatable() {
        return this.f47975a.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f47975a.isStreaming();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.f47975a.writeTo(outputStream);
    }
}
