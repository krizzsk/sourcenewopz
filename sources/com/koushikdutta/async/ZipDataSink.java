package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDataSink extends FilteredDataSink {

    /* renamed from: h */
    ByteArrayOutputStream f55238h = new ByteArrayOutputStream();

    /* renamed from: i */
    ZipOutputStream f55239i = new ZipOutputStream(this.f55238h);

    public ZipDataSink(DataSink dataSink) {
        super(dataSink);
    }

    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        this.f55239i.putNextEntry(zipEntry);
    }

    public void closeEntry() throws IOException {
        this.f55239i.closeEntry();
    }

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        CompletedCallback closedCallback = getClosedCallback();
        if (closedCallback != null) {
            closedCallback.onCompleted(exc);
        }
    }

    public void end() {
        try {
            this.f55239i.close();
            setMaxBuffer(Integer.MAX_VALUE);
            write(new ByteBufferList());
            super.end();
        } catch (IOException e) {
            report(e);
        }
    }

    public ByteBufferList filter(ByteBufferList byteBufferList) {
        if (byteBufferList != null) {
            while (byteBufferList.size() > 0) {
                try {
                    ByteBuffer remove = byteBufferList.remove();
                    ByteBufferList.writeOutputStream(this.f55239i, remove);
                    ByteBufferList.reclaim(remove);
                } catch (IOException e) {
                    report(e);
                    if (byteBufferList != null) {
                        byteBufferList.recycle();
                    }
                    return null;
                } catch (Throwable th) {
                    if (byteBufferList != null) {
                        byteBufferList.recycle();
                    }
                    throw th;
                }
            }
        }
        ByteBufferList byteBufferList2 = new ByteBufferList(this.f55238h.toByteArray());
        this.f55238h.reset();
        if (byteBufferList != null) {
            byteBufferList.recycle();
        }
        return byteBufferList2;
    }
}
