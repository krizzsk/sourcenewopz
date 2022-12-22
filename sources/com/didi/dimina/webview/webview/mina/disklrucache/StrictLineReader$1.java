package com.didi.dimina.webview.webview.mina.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

class StrictLineReader$1 extends ByteArrayOutputStream {
    final /* synthetic */ C7824a this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StrictLineReader$1(C7824a aVar, int i) {
        super(i);
        this.this$0 = aVar;
    }

    public String toString() {
        try {
            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, this.this$0.f18469d.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
