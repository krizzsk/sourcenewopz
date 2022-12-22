package didihttp.internal.huc;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okio.BufferedSink;

class OutputStreamRequestBody$1 extends OutputStream {
    private long bytesReceived;
    final /* synthetic */ C20777c this$0;
    final /* synthetic */ long val$expectedContentLength;
    final /* synthetic */ BufferedSink val$sink;

    OutputStreamRequestBody$1(C20777c cVar, long j, BufferedSink bufferedSink) {
        this.this$0 = cVar;
        this.val$expectedContentLength = j;
        this.val$sink = bufferedSink;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.this$0.f56869c) {
            long j = this.val$expectedContentLength;
            if (j == -1 || this.bytesReceived + ((long) i2) <= j) {
                this.bytesReceived += (long) i2;
                try {
                    this.val$sink.write(bArr, i, i2);
                } catch (InterruptedIOException e) {
                    throw new SocketTimeoutException(e.getMessage());
                }
            } else {
                throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived + i2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public void flush() throws IOException {
        if (!this.this$0.f56869c) {
            this.val$sink.flush();
        }
    }

    public void close() throws IOException {
        this.this$0.f56869c = true;
        long j = this.val$expectedContentLength;
        if (j == -1 || this.bytesReceived >= j) {
            this.val$sink.close();
            return;
        }
        throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived);
    }
}
