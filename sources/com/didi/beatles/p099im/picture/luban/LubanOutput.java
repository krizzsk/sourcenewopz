package com.didi.beatles.p099im.picture.luban;

import java.io.File;

/* renamed from: com.didi.beatles.im.picture.luban.LubanOutput */
public class LubanOutput {

    /* renamed from: a */
    private File f9432a;

    /* renamed from: b */
    private int f9433b;

    /* renamed from: c */
    private int f9434c;

    /* renamed from: d */
    private long f9435d;

    /* renamed from: e */
    private int f9436e;

    /* renamed from: f */
    private int f9437f;

    public LubanOutput(File file) {
        this.f9432a = file;
        this.f9433b = -1;
        this.f9434c = -1;
        this.f9435d = -1;
    }

    public LubanOutput(File file, int i, int i2, long j, int i3, int i4) {
        this.f9432a = file;
        this.f9433b = i;
        this.f9434c = i2;
        this.f9435d = j;
        this.f9436e = i3;
        this.f9437f = i4;
    }

    public File getFile() {
        return this.f9432a;
    }

    public int getWidth() {
        return this.f9433b;
    }

    public int getHeight() {
        return this.f9434c;
    }

    public long getSize() {
        return this.f9435d;
    }

    public int getCompressCount() {
        return this.f9436e;
    }

    public int getCompressQuality() {
        return this.f9437f;
    }
}
