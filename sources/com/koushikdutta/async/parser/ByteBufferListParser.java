package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import java.lang.reflect.Type;

public class ByteBufferListParser implements AsyncParser<ByteBufferList> {
    public String getMime() {
        return null;
    }

    public Future<ByteBufferList> parse(final DataEmitter dataEmitter) {
        final ByteBufferList byteBufferList = new ByteBufferList();
        final C202501 r1 = new SimpleFuture<ByteBufferList>() {
            /* access modifiers changed from: protected */
            public void cancelCleanup() {
                dataEmitter.close();
            }
        };
        dataEmitter.setDataCallback(new DataCallback() {
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                byteBufferList.get(byteBufferList);
            }
        });
        dataEmitter.setEndCallback(new CompletedCallback() {
            public void onCompleted(Exception exc) {
                if (exc != null) {
                    r1.setComplete(exc);
                    return;
                }
                try {
                    r1.setComplete(byteBufferList);
                } catch (Exception e) {
                    r1.setComplete(e);
                }
            }
        });
        return r1;
    }

    public void write(DataSink dataSink, ByteBufferList byteBufferList, CompletedCallback completedCallback) {
        C20137Util.writeAll(dataSink, byteBufferList, completedCallback);
    }

    public Type getType() {
        return ByteBufferList.class;
    }
}
