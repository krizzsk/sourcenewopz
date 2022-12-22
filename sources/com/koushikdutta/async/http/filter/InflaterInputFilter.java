package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import java.nio.ByteBuffer;
import java.util.zip.Inflater;

public class InflaterInputFilter extends FilteredDataEmitter {

    /* renamed from: c */
    static final /* synthetic */ boolean f55418c = (!InflaterInputFilter.class.desiredAssertionStatus());

    /* renamed from: a */
    private Inflater f55419a;

    /* renamed from: b */
    ByteBufferList f55420b;

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        this.f55419a.end();
        if (exc != null && this.f55419a.getRemaining() > 0) {
            exc = new DataRemainingException("data still remaining in inflater", exc);
        }
        super.report(exc);
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        try {
            ByteBuffer obtain = ByteBufferList.obtain(byteBufferList.remaining() * 2);
            while (byteBufferList.size() > 0) {
                ByteBuffer remove = byteBufferList.remove();
                if (remove.hasRemaining()) {
                    int remaining = remove.remaining();
                    this.f55419a.setInput(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                    do {
                        obtain.position(obtain.position() + this.f55419a.inflate(obtain.array(), obtain.arrayOffset() + obtain.position(), obtain.remaining()));
                        if (!obtain.hasRemaining()) {
                            obtain.flip();
                            this.f55420b.add(obtain);
                            if (!f55418c) {
                                if (remaining == 0) {
                                    throw new AssertionError();
                                }
                            }
                            obtain = ByteBufferList.obtain(obtain.capacity() * 2);
                        }
                        if (this.f55419a.needsInput()) {
                            break;
                        }
                    } while (this.f55419a.finished());
                }
                ByteBufferList.reclaim(remove);
            }
            obtain.flip();
            this.f55420b.add(obtain);
            C20137Util.emitAllData(this, this.f55420b);
        } catch (Exception e) {
            report(e);
        }
    }

    public InflaterInputFilter() {
        this(new Inflater());
    }

    public InflaterInputFilter(Inflater inflater) {
        this.f55420b = new ByteBufferList();
        this.f55419a = inflater;
    }
}
