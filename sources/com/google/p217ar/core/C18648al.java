package com.google.p217ar.core;

import android.media.ImageReader;

/* renamed from: com.google.ar.core.al */
final /* synthetic */ class C18648al implements ImageReader.OnImageAvailableListener {

    /* renamed from: a */
    static final ImageReader.OnImageAvailableListener f53508a = new C18648al();

    private C18648al() {
    }

    public final void onImageAvailable(ImageReader imageReader) {
        SharedCamera.lambda$setDummyOnImageAvailableListener$0$SharedCamera(imageReader);
    }
}
