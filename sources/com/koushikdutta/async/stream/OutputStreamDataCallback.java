package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class OutputStreamDataCallback implements CompletedCallback, DataCallback {
    private OutputStream mOutput;

    public OutputStreamDataCallback(OutputStream outputStream) {
        this.mOutput = outputStream;
    }

    public OutputStream getOutputStream() {
        return this.mOutput;
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        while (byteBufferList.size() > 0) {
            try {
                ByteBuffer remove = byteBufferList.remove();
                this.mOutput.write(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                ByteBufferList.reclaim(remove);
            } catch (Exception e) {
                onCompleted(e);
            } catch (Throwable th) {
                byteBufferList.recycle();
                throw th;
            }
        }
        byteBufferList.recycle();
    }

    public void close() {
        try {
            this.mOutput.close();
        } catch (IOException e) {
            onCompleted(e);
        }
    }

    public void onCompleted(Exception exc) {
        exc.printStackTrace();
    }
}
