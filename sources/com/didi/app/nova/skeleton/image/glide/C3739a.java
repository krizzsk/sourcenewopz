package com.didi.app.nova.skeleton.image.glide;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.didi.app.nova.skeleton.ScopeContext;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.didi.app.nova.skeleton.image.glide.a */
/* compiled from: GlideSupport */
class C3739a implements RequestManagerTreeNode {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SkeletonLifecycle f8462a = new SkeletonLifecycle();

    /* renamed from: b */
    private SkeletonRequestManager f8463b;

    public C3739a(ScopeContext scopeContext, Context context) {
        this.f8463b = new SkeletonRequestManager(Glide.get(context), this.f8462a, this, context);
        scopeContext.addObserver(new GlideSupport$1(this));
        if (scopeContext.getLiveHandler().isActive()) {
            this.f8462a.mo40974a();
        }
    }

    /* renamed from: a */
    public SkeletonRequestManager mo40977a() {
        return this.f8463b;
    }

    public Set<RequestManager> getDescendants() {
        return Collections.EMPTY_SET;
    }
}
