package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Measurements;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.TaskQueue;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionStateUtil;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingOutputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteEvent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListener;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListenerSource;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.AbstractHttpMessage;

public final class HttpResponseEntityImpl implements StreamCompleteListener, HttpEntity {

    /* renamed from: a */
    private static final String f47979a = "Transfer-Encoding";

    /* renamed from: b */
    private static final String f47980b = "chunked";

    /* renamed from: g */
    private static final AgentLog f47981g = AgentLogManager.getAgentLog();

    /* renamed from: c */
    private final HttpEntity f47982c;

    /* renamed from: d */
    private final TransactionState f47983d;

    /* renamed from: e */
    private final long f47984e;

    /* renamed from: f */
    private CountingInputStream f47985f;

    public HttpResponseEntityImpl(HttpEntity httpEntity, TransactionState transactionState, long j) {
        this.f47982c = httpEntity;
        this.f47983d = transactionState;
        this.f47984e = j;
    }

    public void consumeContent() throws IOException {
        try {
            this.f47982c.consumeContent();
        } catch (IOException e) {
            m34248a((Exception) e);
            throw e;
        }
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        CountingInputStream countingInputStream = this.f47985f;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        try {
            boolean z = true;
            if (this.f47982c instanceof AbstractHttpMessage) {
                Header lastHeader = this.f47982c.getLastHeader("Transfer-Encoding");
                if (lastHeader != null && f47980b.equalsIgnoreCase(lastHeader.getValue())) {
                    z = false;
                }
            } else if (this.f47982c instanceof HttpEntityWrapper) {
                z = true ^ this.f47982c.isChunked();
            }
            CountingInputStream countingInputStream2 = new CountingInputStream(this.f47982c.getContent(), z);
            this.f47985f = countingInputStream2;
            countingInputStream2.addStreamCompleteListener(this);
            return this.f47985f;
        } catch (IOException e) {
            m34248a((Exception) e);
            throw e;
        }
    }

    public Header getContentEncoding() {
        return this.f47982c.getContentEncoding();
    }

    public long getContentLength() {
        return this.f47982c.getContentLength();
    }

    public Header getContentType() {
        return this.f47982c.getContentType();
    }

    public boolean isChunked() {
        return this.f47982c.isChunked();
    }

    public boolean isRepeatable() {
        return this.f47982c.isRepeatable();
    }

    public boolean isStreaming() {
        return this.f47982c.isStreaming();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (!this.f47983d.isComplete()) {
            CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
            try {
                this.f47982c.writeTo(countingOutputStream);
                if (!this.f47983d.isComplete()) {
                    long j = this.f47984e;
                    if (j >= 0) {
                        this.f47983d.setBytesReceived(j);
                    } else {
                        this.f47983d.setBytesReceived(countingOutputStream.getCount());
                    }
                    m34247a(this.f47983d);
                }
            } catch (IOException e) {
                m34249a(e, Long.valueOf(countingOutputStream.getCount()));
                e.printStackTrace();
                throw e;
            }
        } else {
            this.f47982c.writeTo(outputStream);
        }
    }

    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        if (!this.f47983d.isComplete()) {
            long j = this.f47984e;
            if (j >= 0) {
                this.f47983d.setBytesReceived(j);
            } else {
                this.f47983d.setBytesReceived(streamCompleteEvent.getBytes());
            }
            m34247a(this.f47983d);
        }
    }

    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        TransactionStateUtil.setErrorCodeFromException(this.f47983d, streamCompleteEvent.getException());
        if (!this.f47983d.isComplete()) {
            this.f47983d.setBytesReceived(streamCompleteEvent.getBytes());
        }
    }

    /* renamed from: a */
    private void m34247a(TransactionState transactionState) {
        TransactionData end = transactionState.end();
        if (end != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            if (transactionState.getStatusCode() >= 400) {
                StringBuilder sb = new StringBuilder();
                try {
                    InputStream content = getContent();
                    if (content instanceof CountingInputStream) {
                        sb.append(((CountingInputStream) content).getBufferAsString());
                    }
                } catch (Exception e) {
                    f47981g.error(e.toString());
                }
                Header contentType = this.f47982c.getContentType();
                TreeMap treeMap = new TreeMap();
                if (!(contentType == null || contentType.getValue() == null || "".equals(contentType.getValue()))) {
                    treeMap.put("content_type", contentType.getValue());
                }
                treeMap.put("content_length", transactionState.getBytesReceived() + "");
                Measurements.addHttpError(end, sb.toString(), treeMap);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m34248a(Exception exc) {
        m34249a(exc, (Long) null);
    }

    /* renamed from: a */
    private void m34249a(Exception exc, Long l) {
        TransactionStateUtil.setErrorCodeFromException(this.f47983d, exc);
        if (!this.f47983d.isComplete()) {
            if (l != null) {
                this.f47983d.setBytesReceived(l.longValue());
            }
            TransactionData end = this.f47983d.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            }
        }
    }
}
