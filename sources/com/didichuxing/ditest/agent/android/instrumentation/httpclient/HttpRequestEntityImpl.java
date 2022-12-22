package com.didichuxing.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.ditest.agent.android.TaskQueue;
import com.didichuxing.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.ditest.agent.android.instrumentation.TransactionStateUtil;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.CountingInputStream;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.CountingOutputStream;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.StreamCompleteEvent;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.StreamCompleteListener;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.StreamCompleteListenerSource;
import com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class HttpRequestEntityImpl implements StreamCompleteListener, HttpEntity {
    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpRequestEntityImpl(HttpEntity httpEntity, TransactionState transactionState2) {
        this.impl = httpEntity;
        this.transactionState = transactionState2;
    }

    public void consumeContent() throws IOException {
        try {
            this.impl.consumeContent();
        } catch (IOException e) {
            handleException(e);
            throw e;
        }
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        try {
            if (this.transactionState.isSent()) {
                return this.impl.getContent();
            }
            CountingInputStream countingInputStream = new CountingInputStream(this.impl.getContent());
            countingInputStream.addStreamCompleteListener(this);
            return countingInputStream;
        } catch (IOException e) {
            handleException(e);
            throw e;
        } catch (IllegalStateException e2) {
            handleException(e2);
            throw e2;
        }
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
        try {
            if (!this.transactionState.isSent()) {
                CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
                this.impl.writeTo(countingOutputStream);
                this.transactionState.setBytesSent(countingOutputStream.getCount());
                return;
            }
            this.impl.writeTo(outputStream);
        } catch (IOException e) {
            handleException(e);
            throw e;
        }
    }

    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        this.transactionState.setBytesSent(streamCompleteEvent.getBytes());
    }

    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        handleException(streamCompleteEvent.getException(), Long.valueOf(streamCompleteEvent.getBytes()));
    }

    private void handleException(Exception exc) {
        handleException(exc, (Long) null);
    }

    private void handleException(Exception exc, Long l) {
        TransactionStateUtil.setErrorCodeFromException(this.transactionState, exc);
        if (!this.transactionState.isComplete()) {
            if (l != null) {
                this.transactionState.setBytesSent(l.longValue());
            }
            TransactionData end = this.transactionState.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            }
        }
    }
}
