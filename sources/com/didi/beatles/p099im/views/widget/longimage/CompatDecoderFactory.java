package com.didi.beatles.p099im.views.widget.longimage;

/* renamed from: com.didi.beatles.im.views.widget.longimage.CompatDecoderFactory */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {

    /* renamed from: a */
    private Class<? extends T> f10516a;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this.f10516a = cls;
    }

    public T make() throws IllegalAccessException, InstantiationException {
        return this.f10516a.newInstance();
    }
}
