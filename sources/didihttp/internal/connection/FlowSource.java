package didihttp.internal.connection;

import java.io.IOException;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

public class FlowSource implements Source {

    /* renamed from: a */
    private Source f56653a;

    /* renamed from: b */
    private Callback f56654b;

    /* renamed from: c */
    private long f56655c = 0;

    public interface Callback {
        void onClose(long j);
    }

    public FlowSource(Source source) {
        this.f56653a = source;
    }

    public void setCallback(Callback callback) {
        this.f56654b = callback;
    }

    public long getCount() {
        return this.f56655c;
    }

    public void reset() {
        this.f56655c = 0;
    }

    public long read(Buffer buffer, long j) throws IOException {
        try {
            long read = this.f56653a.read(buffer, j);
            if (read > 0) {
                this.f56655c += read;
            }
            return read;
        } catch (NullPointerException e) {
            throw new IOException(e);
        }
    }

    public Timeout timeout() {
        return this.f56653a.timeout();
    }

    public void close() throws IOException {
        try {
            this.f56653a.close();
        } finally {
            Callback callback = this.f56654b;
            if (callback != null) {
                callback.onClose(this.f56655c);
            }
        }
    }
}
