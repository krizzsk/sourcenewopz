package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

/* renamed from: com.google.android.play.core.assetpacks.h */
final /* synthetic */ class C18399h implements OnFailureListener {

    /* renamed from: a */
    static final OnFailureListener f53074a = new C18399h();

    private C18399h() {
    }

    public final void onFailure(Exception exc) {
        C18401j.f53077a.mo149085d(String.format("Could not sync active asset packs. %s", new Object[]{exc}), new Object[0]);
    }
}
