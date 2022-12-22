package com.didichuxing.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.ditest.agent.android.Measurements;
import com.didichuxing.ditest.agent.android.TaskQueue;
import com.didichuxing.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.ditest.agent.android.instrumentation.TransactionStateUtil;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.CountingInputStream;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.CountingOutputStream;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.StreamCompleteEvent;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.StreamCompleteListener;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.StreamCompleteListenerSource;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.AbstractHttpMessage;

public final class HttpResponseEntityImpl implements StreamCompleteListener, HttpEntity {
    private static final String ENCODING_CHUNKED = "chunked";
    private static final String TRANSFER_ENCODING_HEADER = "Transfer-Encoding";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final long contentLengthFromHeader;
    private CountingInputStream contentStream;
    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpResponseEntityImpl(HttpEntity httpEntity, TransactionState transactionState2, long j) {
        this.impl = httpEntity;
        this.transactionState = transactionState2;
        this.contentLengthFromHeader = j;
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
        CountingInputStream countingInputStream = this.contentStream;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        try {
            boolean z = true;
            if (this.impl instanceof AbstractHttpMessage) {
                Header lastHeader = this.impl.getLastHeader("Transfer-Encoding");
                if (lastHeader != null && ENCODING_CHUNKED.equalsIgnoreCase(lastHeader.getValue())) {
                    z = false;
                }
            } else if (this.impl instanceof HttpEntityWrapper) {
                z = true ^ this.impl.isChunked();
            }
            CountingInputStream countingInputStream2 = new CountingInputStream(this.impl.getContent(), z);
            this.contentStream = countingInputStream2;
            countingInputStream2.addStreamCompleteListener(this);
            return this.contentStream;
        } catch (IOException e) {
            handleException(e);
            throw e;
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
        if (!this.transactionState.isComplete()) {
            CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
            try {
                this.impl.writeTo(countingOutputStream);
                if (!this.transactionState.isComplete()) {
                    long j = this.contentLengthFromHeader;
                    if (j >= 0) {
                        this.transactionState.setBytesReceived(j);
                    } else {
                        this.transactionState.setBytesReceived(countingOutputStream.getCount());
                    }
                    addTransactionAndErrorData(this.transactionState);
                }
            } catch (IOException e) {
                handleException(e, Long.valueOf(countingOutputStream.getCount()));
                e.printStackTrace();
                throw e;
            }
        } else {
            this.impl.writeTo(outputStream);
        }
    }

    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        if (!this.transactionState.isComplete()) {
            long j = this.contentLengthFromHeader;
            if (j >= 0) {
                this.transactionState.setBytesReceived(j);
            } else {
                this.transactionState.setBytesReceived(streamCompleteEvent.getBytes());
            }
            addTransactionAndErrorData(this.transactionState);
        }
    }

    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        TransactionStateUtil.setErrorCodeFromException(this.transactionState, streamCompleteEvent.getException());
        if (!this.transactionState.isComplete()) {
            this.transactionState.setBytesReceived(streamCompleteEvent.getBytes());
        }
    }

    private void addTransactionAndErrorData(TransactionState transactionState2) {
        TransactionData end = transactionState2.end();
        if (end != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            if (transactionState2.getStatusCode() >= 400) {
                StringBuilder sb = new StringBuilder();
                try {
                    InputStream content = getContent();
                    if (content instanceof CountingInputStream) {
                        sb.append(((CountingInputStream) content).getBufferAsString());
                    }
                } catch (Exception e) {
                    log.error(e.toString());
                }
                Header contentType = this.impl.getContentType();
                TreeMap treeMap = new TreeMap();
                if (!(contentType == null || contentType.getValue() == null || "".equals(contentType.getValue()))) {
                    treeMap.put("content_type", contentType.getValue());
                }
                treeMap.put("content_length", transactionState2.getBytesReceived() + "");
                Measurements.addHttpError(end, sb.toString(), treeMap);
                return;
            }
        }
    }

    private void handleException(Exception exc) {
        handleException(exc, (Long) null);
    }

    private void handleException(Exception exc, Long l) {
        TransactionStateUtil.setErrorCodeFromException(this.transactionState, exc);
        if (!this.transactionState.isComplete()) {
            if (l != null) {
                this.transactionState.setBytesReceived(l.longValue());
            }
            TransactionData end = this.transactionState.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            }
        }
    }
}
