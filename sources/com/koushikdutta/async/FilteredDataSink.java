package com.koushikdutta.async;

public class FilteredDataSink extends BufferedDataSink {
    public ByteBufferList filter(ByteBufferList byteBufferList) {
        return byteBufferList;
    }

    public FilteredDataSink(DataSink dataSink) {
        super(dataSink);
        setMaxBuffer(0);
    }

    /* access modifiers changed from: protected */
    public void onDataAccepted(ByteBufferList byteBufferList) {
        ByteBufferList filter = filter(byteBufferList);
        if (filter != byteBufferList) {
            byteBufferList.recycle();
            filter.get(byteBufferList);
        }
    }
}
