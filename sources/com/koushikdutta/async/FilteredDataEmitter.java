package com.koushikdutta.async;

import com.koushikdutta.async.DataTrackingEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.wrapper.DataEmitterWrapper;

public class FilteredDataEmitter extends DataEmitterBase implements DataEmitter, DataTrackingEmitter, DataCallback, DataEmitterWrapper {
    boolean closed;
    private DataEmitter mEmitter;
    private int totalRead;
    private DataTrackingEmitter.DataTracker tracker;

    public DataEmitter getDataEmitter() {
        return this.mEmitter;
    }

    public void setDataEmitter(DataEmitter dataEmitter) {
        DataEmitter dataEmitter2 = this.mEmitter;
        if (dataEmitter2 != null) {
            dataEmitter2.setDataCallback((DataCallback) null);
        }
        this.mEmitter = dataEmitter;
        dataEmitter.setDataCallback(this);
        this.mEmitter.setEndCallback(new CompletedCallback() {
            public void onCompleted(Exception exc) {
                FilteredDataEmitter.this.report(exc);
            }
        });
    }

    public int getBytesRead() {
        return this.totalRead;
    }

    public DataTrackingEmitter.DataTracker getDataTracker() {
        return this.tracker;
    }

    public void setDataTracker(DataTrackingEmitter.DataTracker dataTracker) {
        this.tracker = dataTracker;
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (this.closed) {
            byteBufferList.recycle();
            return;
        }
        if (byteBufferList != null) {
            this.totalRead += byteBufferList.remaining();
        }
        C20137Util.emitAllData(this, byteBufferList);
        if (byteBufferList != null) {
            this.totalRead -= byteBufferList.remaining();
        }
        DataTrackingEmitter.DataTracker dataTracker = this.tracker;
        if (dataTracker != null && byteBufferList != null) {
            dataTracker.onData(this.totalRead);
        }
    }

    public boolean isChunked() {
        return this.mEmitter.isChunked();
    }

    public void pause() {
        this.mEmitter.pause();
    }

    public void resume() {
        this.mEmitter.resume();
    }

    public boolean isPaused() {
        return this.mEmitter.isPaused();
    }

    public AsyncServer getServer() {
        return this.mEmitter.getServer();
    }

    public void close() {
        this.closed = true;
        DataEmitter dataEmitter = this.mEmitter;
        if (dataEmitter != null) {
            dataEmitter.close();
        }
    }

    public String charset() {
        DataEmitter dataEmitter = this.mEmitter;
        if (dataEmitter == null) {
            return null;
        }
        return dataEmitter.charset();
    }
}
