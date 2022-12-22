package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.g */
final /* synthetic */ class C18398g implements OnSuccessListener {

    /* renamed from: a */
    private final C18319bb f53073a;

    private C18398g(C18319bb bbVar) {
        this.f53073a = bbVar;
    }

    /* renamed from: a */
    static OnSuccessListener m37695a(C18319bb bbVar) {
        return new C18398g(bbVar);
    }

    public final void onSuccess(Object obj) {
        this.f53073a.mo148913a((List<String>) (List) obj);
    }
}
