package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.C18428ac;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18442aq;
import com.google.android.play.core.tasks.C18619i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.h */
public final class C18529h {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C18432ag f53218b = new C18432ag("ReviewService");

    /* renamed from: a */
    final C18442aq<C18428ac> f53219a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f53220c;

    public C18529h(Context context) {
        this.f53220c = context.getPackageName();
        Context context2 = context;
        this.f53219a = new C18442aq(context2, f53218b, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), C18525d.f53212a);
    }

    /* renamed from: a */
    public final Task<ReviewInfo> mo149211a() {
        f53218b.mo149084c("requestInAppReview (%s)", this.f53220c);
        C18619i iVar = new C18619i();
        this.f53219a.mo149093a((C18433ah) new C18526e(this, iVar, iVar));
        return iVar.mo149338a();
    }
}
