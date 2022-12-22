package didihttp.internal.huc;

import com.google.common.net.HttpHeaders;
import didihttp.Request;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: didihttp.internal.huc.a */
/* compiled from: BufferedRequestBody */
final class C20775a extends C20777c {

    /* renamed from: a */
    final Buffer f56864a;

    /* renamed from: b */
    long f56865b = -1;

    C20775a(long j) {
        Buffer buffer = new Buffer();
        this.f56864a = buffer;
        mo170309a(buffer, j);
    }

    public long contentLength() throws IOException {
        return this.f56865b;
    }

    /* renamed from: a */
    public Request mo170307a(Request request) throws IOException {
        if (request.header(HttpHeaders.CONTENT_LENGTH) != null) {
            return request;
        }
        mo170308a().close();
        this.f56865b = this.f56864a.size();
        return request.newBuilder().removeHeader(HttpHeaders.TRANSFER_ENCODING).header(HttpHeaders.CONTENT_LENGTH, Long.toString(this.f56864a.size())).build();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.f56864a.copyTo(bufferedSink.buffer(), 0, this.f56864a.size());
    }
}
