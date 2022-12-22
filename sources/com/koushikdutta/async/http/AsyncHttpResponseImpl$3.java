package com.koushikdutta.async.http;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;

class AsyncHttpResponseImpl$3 extends DataCallback.NullDataCallback {
    final /* synthetic */ C20198a this$0;

    AsyncHttpResponseImpl$3(C20198a aVar) {
        this.this$0 = aVar;
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        super.onDataAvailable(dataEmitter, byteBufferList);
        this.this$0.mSocket.close();
    }
}
