package com.koushikdutta.async.http.cache;

import java.io.ByteArrayOutputStream;

class StrictLineReader$1 extends ByteArrayOutputStream {
    final /* synthetic */ C20220e this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StrictLineReader$1(C20220e eVar, int i) {
        super(i);
        this.this$0 = eVar;
    }

    public String toString() {
        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1);
    }
}
