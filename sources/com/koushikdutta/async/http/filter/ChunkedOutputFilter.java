package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.FilteredDataSink;
import java.nio.ByteBuffer;

public class ChunkedOutputFilter extends FilteredDataSink {
    public ChunkedOutputFilter(DataSink dataSink) {
        super(dataSink);
    }

    public ByteBufferList filter(ByteBufferList byteBufferList) {
        byteBufferList.addFirst(ByteBuffer.wrap((Integer.toString(byteBufferList.remaining(), 16) + "\r\n").getBytes()));
        byteBufferList.add(ByteBuffer.wrap("\r\n".getBytes()));
        return byteBufferList;
    }

    public void end() {
        setMaxBuffer(Integer.MAX_VALUE);
        write(new ByteBufferList());
        setMaxBuffer(0);
    }
}
