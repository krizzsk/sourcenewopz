package didihttp.internal.connection;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public class FlowSink implements Sink {

    /* renamed from: a */
    private Sink f56650a;

    /* renamed from: b */
    private Callback f56651b;

    /* renamed from: c */
    private long f56652c = 0;

    public interface Callback {
        void onClose(long j);

        void onFlush(long j);
    }

    public FlowSink(Sink sink) {
        this.f56650a = sink;
    }

    public void setCallback(Callback callback) {
        this.f56651b = callback;
    }

    public long getCount() {
        return this.f56652c;
    }

    public void reset() {
        this.f56652c = 0;
    }

    public void write(Buffer buffer, long j) throws IOException {
        try {
            this.f56650a.write(buffer, j);
            this.f56652c += j;
        } catch (NullPointerException e) {
            throw new IOException(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.f56650a.flush();
        } finally {
            Callback callback = this.f56651b;
            if (callback != null) {
                callback.onFlush(this.f56652c);
            }
        }
    }

    public Timeout timeout() {
        return this.f56650a.timeout();
    }

    public void close() throws IOException {
        try {
            this.f56650a.close();
        } finally {
            Callback callback = this.f56651b;
            if (callback != null) {
                callback.onClose(this.f56652c);
            }
        }
    }
}
