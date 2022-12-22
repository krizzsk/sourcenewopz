package didihttp.internal.huc;

import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;
import java.io.IOException;
import java.io.OutputStream;
import okio.BufferedSink;
import okio.Timeout;

/* renamed from: didihttp.internal.huc.c */
/* compiled from: OutputStreamRequestBody */
abstract class C20777c extends RequestBody {

    /* renamed from: a */
    private Timeout f56867a;

    /* renamed from: b */
    private long f56868b;

    /* renamed from: c */
    boolean f56869c;

    /* renamed from: d */
    private OutputStream f56870d;

    /* renamed from: a */
    public Request mo170307a(Request request) throws IOException {
        return request;
    }

    public final MediaType contentType() {
        return null;
    }

    C20777c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo170309a(BufferedSink bufferedSink, long j) {
        this.f56867a = bufferedSink.timeout();
        this.f56868b = j;
        this.f56870d = new OutputStreamRequestBody$1(this, j, bufferedSink);
    }

    /* renamed from: a */
    public final OutputStream mo170308a() {
        return this.f56870d;
    }

    /* renamed from: b */
    public final Timeout mo170310b() {
        return this.f56867a;
    }

    /* renamed from: c */
    public final boolean mo170311c() {
        return this.f56869c;
    }

    public long contentLength() throws IOException {
        return this.f56868b;
    }
}
