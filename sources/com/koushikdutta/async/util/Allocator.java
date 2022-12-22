package com.koushikdutta.async.util;

import com.koushikdutta.async.ByteBufferList;
import java.nio.ByteBuffer;

public class Allocator {

    /* renamed from: a */
    final int f55455a;

    /* renamed from: b */
    int f55456b;

    /* renamed from: c */
    int f55457c;

    public Allocator(int i) {
        this.f55456b = 0;
        this.f55457c = 4096;
        this.f55455a = i;
    }

    public Allocator() {
        this.f55456b = 0;
        this.f55457c = 4096;
        this.f55455a = ByteBufferList.MAX_ITEM_SIZE;
    }

    public ByteBuffer allocate() {
        return allocate(this.f55456b);
    }

    public ByteBuffer allocate(int i) {
        return ByteBufferList.obtain(Math.min(Math.max(i, this.f55457c), this.f55455a));
    }

    public void track(long j) {
        this.f55456b = ((int) j) * 2;
    }

    public int getMaxAlloc() {
        return this.f55455a;
    }

    public void setCurrentAlloc(int i) {
        this.f55456b = i;
    }

    public int getMinAlloc() {
        return this.f55457c;
    }

    public Allocator setMinAlloc(int i) {
        this.f55457c = Math.max(0, i);
        return this;
    }
}
