package net.lingala.zip4j.model;

import java.nio.charset.Charset;

public class Zip4jConfig {

    /* renamed from: a */
    private Charset f4962a;

    /* renamed from: b */
    private int f4963b;

    public Zip4jConfig(Charset charset, int i) {
        this.f4962a = charset;
        this.f4963b = i;
    }

    public Charset getCharset() {
        return this.f4962a;
    }

    public int getBufferSize() {
        return this.f4963b;
    }
}
