package com.didi.dimina.p108v8;

import java.io.Closeable;

/* renamed from: com.didi.dimina.v8.Releasable */
public interface Releasable extends Closeable {
    void close();

    void release();
}
