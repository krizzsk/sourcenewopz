package com.jumio.core.extraction;

import java.util.concurrent.atomic.AtomicInteger;

public class ExtractionUpdateState {

    /* renamed from: id */
    public static AtomicInteger f54726id;
    public static final int notifyFocus;
    public static final int receiveClickListener = f54726id.getAndIncrement();
    public static final int resetOverlay = f54726id.getAndIncrement();
    public static final int saveImage = f54726id.getAndIncrement();
    public static final int shotTaken = f54726id.getAndIncrement();

    static {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        f54726id = atomicInteger;
        notifyFocus = atomicInteger.getAndIncrement();
    }
}
