package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.TaskQueue;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionStateUtil;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingOutputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteEvent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListener;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListenerSource;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class HttpRequestEntityImpl implements StreamCompleteListener, HttpEntity {

    /* renamed from: a */
    private final HttpEntity f47977a;

    /* renamed from: b */
    private final TransactionState f47978b;

    public HttpRequestEntityImpl(HttpEntity httpEntity, TransactionState transactionState) {
        this.f47977a = httpEntity;
        this.f47978b = transactionState;
    }

    public void consumeContent() throws IOException {
        try {
            this.f47977a.consumeContent();
        } catch (IOException e) {
            m34245a(e);
            throw e;
        }
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        try {
            if (this.f47978b.isSent()) {
                return this.f47977a.getContent();
            }
            CountingInputStream countingInputStream = new CountingInputStream(this.f47977a.getContent());
            countingInputStream.addStreamCompleteListener(this);
            return countingInputStream;
        } catch (IOException e) {
            m34245a(e);
            throw e;
        } catch (IllegalStateException e2) {
            m34245a(e2);
            throw e2;
        }
    }

    public Header getContentEncoding() {
        return this.f47977a.getContentEncoding();
    }

    public long getContentLength() {
        return this.f47977a.getContentLength();
    }

    public Header getContentType() {
        return this.f47977a.getContentType();
    }

    public boolean isChunked() {
        return this.f47977a.isChunked();
    }

    public boolean isRepeatable() {
        return this.f47977a.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f47977a.isStreaming();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (!this.f47978b.isSent()) {
                CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
                this.f47977a.writeTo(countingOutputStream);
                this.f47978b.setBytesSent(countingOutputStream.getCount());
                return;
            }
            this.f47977a.writeTo(outputStream);
        } catch (IOException e) {
            m34245a(e);
            throw e;
        }
    }

    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        this.f47978b.setBytesSent(streamCompleteEvent.getBytes());
    }

    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        m34246a(streamCompleteEvent.getException(), Long.valueOf(streamCompleteEvent.getBytes()));
    }

    /* renamed from: a */
    private void m34245a(Exception exc) {
        m34246a(exc, (Long) null);
    }

    /* renamed from: a */
    private void m34246a(Exception exc, Long l) {
        TransactionStateUtil.setErrorCodeFromException(this.f47978b, exc);
        if (!this.f47978b.isComplete()) {
            if (l != null) {
                this.f47978b.setBytesSent(l.longValue());
            }
            TransactionData end = this.f47978b.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            }
        }
    }
}
