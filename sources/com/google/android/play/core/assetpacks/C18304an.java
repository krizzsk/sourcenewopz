package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.an */
final class C18304an extends C18301ak<Void> {

    /* renamed from: c */
    final /* synthetic */ C18308ar f52746c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18304an(C18308ar arVar, C18619i<Void> iVar) {
        super(arVar, iVar);
        this.f52746c = arVar;
    }

    /* renamed from: a */
    public final void mo148879a(Bundle bundle, Bundle bundle2) {
        super.mo148879a(bundle, bundle2);
        if (!this.f52746c.f52761g.compareAndSet(true, false)) {
            C18308ar.f52755a.mo149085d("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.f52746c.mo148891a();
        }
    }
}
