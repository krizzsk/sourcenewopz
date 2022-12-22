package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class OutputStreamDataSink implements DataSink {

    /* renamed from: b */
    AsyncServer f55448b;

    /* renamed from: c */
    OutputStream f55449c;

    /* renamed from: d */
    WritableCallback f55450d;

    /* renamed from: e */
    boolean f55451e;

    /* renamed from: f */
    Exception f55452f;

    /* renamed from: g */
    CompletedCallback f55453g;

    /* renamed from: h */
    WritableCallback f55454h;

    public OutputStreamDataSink(AsyncServer asyncServer) {
        this(asyncServer, (OutputStream) null);
    }

    public void end() {
        try {
            if (this.f55449c != null) {
                this.f55449c.close();
            }
            reportClose((Exception) null);
        } catch (IOException e) {
            reportClose(e);
        }
    }

    public OutputStreamDataSink(AsyncServer asyncServer, OutputStream outputStream) {
        this.f55448b = asyncServer;
        setOutputStream(outputStream);
    }

    public void setOutputStream(OutputStream outputStream) {
        this.f55449c = outputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f55449c;
    }

    public void write(ByteBufferList byteBufferList) {
        while (byteBufferList.size() > 0) {
            try {
                ByteBuffer remove = byteBufferList.remove();
                getOutputStream().write(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                ByteBufferList.reclaim(remove);
            } catch (IOException e) {
                reportClose(e);
            } catch (Throwable th) {
                byteBufferList.recycle();
                throw th;
            }
        }
        byteBufferList.recycle();
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f55450d = writableCallback;
    }

    public WritableCallback getWriteableCallback() {
        return this.f55450d;
    }

    public boolean isOpen() {
        return this.f55451e;
    }

    public void reportClose(Exception exc) {
        if (!this.f55451e) {
            this.f55451e = true;
            this.f55452f = exc;
            CompletedCallback completedCallback = this.f55453g;
            if (completedCallback != null) {
                completedCallback.onCompleted(exc);
            }
        }
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f55453g = completedCallback;
    }

    public CompletedCallback getClosedCallback() {
        return this.f55453g;
    }

    public AsyncServer getServer() {
        return this.f55448b;
    }

    public void setOutputStreamWritableCallback(WritableCallback writableCallback) {
        this.f55454h = writableCallback;
    }
}
