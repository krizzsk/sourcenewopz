package com.didi.dimina.container.secondparty.http;

import didihttp.MediaType;
import didihttp.RequestBody;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

class ProgressRequestBody extends RequestBody {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ProgressListener f17114a;

    /* renamed from: b */
    private final RequestBody f17115b;

    public interface ProgressListener {
        void onProgressUpdate(long j, long j2);
    }

    ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        this.f17115b = requestBody;
        this.f17114a = progressListener;
    }

    public MediaType contentType() {
        return this.f17115b.contentType();
    }

    public long contentLength() throws IOException {
        return this.f17115b.contentLength();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        final long contentLength = contentLength();
        BufferedSink buffer = Okio.buffer((Sink) new ForwardingSink(bufferedSink) {
            private long mCurrentLength;

            public void write(Buffer buffer, long j) throws IOException {
                this.mCurrentLength += j;
                if (ProgressRequestBody.this.f17114a != null) {
                    ProgressRequestBody.this.f17114a.onProgressUpdate(this.mCurrentLength, contentLength);
                }
                super.write(buffer, j);
            }
        });
        this.f17115b.writeTo(buffer);
        buffer.flush();
    }
}
