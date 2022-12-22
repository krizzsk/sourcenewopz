package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;

public class ContentLengthFilter extends FilteredDataEmitter {

    /* renamed from: d */
    static final /* synthetic */ boolean f55409d = (!ContentLengthFilter.class.desiredAssertionStatus());

    /* renamed from: a */
    long f55410a;

    /* renamed from: b */
    long f55411b;

    /* renamed from: c */
    ByteBufferList f55412c = new ByteBufferList();

    public ContentLengthFilter(long j) {
        this.f55410a = j;
    }

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        if (exc == null && this.f55411b != this.f55410a) {
            exc = new PrematureDataEndException("End of data reached before content length was read: " + this.f55411b + "/" + this.f55410a + " Paused: " + isPaused());
        }
        super.report(exc);
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (f55409d || this.f55411b < this.f55410a) {
            byteBufferList.get(this.f55412c, (int) Math.min(this.f55410a - this.f55411b, (long) byteBufferList.remaining()));
            int remaining = this.f55412c.remaining();
            super.onDataAvailable(dataEmitter, this.f55412c);
            this.f55411b += (long) (remaining - this.f55412c.remaining());
            this.f55412c.get(byteBufferList);
            if (this.f55411b == this.f55410a) {
                report((Exception) null);
                return;
            }
            return;
        }
        throw new AssertionError();
    }
}
