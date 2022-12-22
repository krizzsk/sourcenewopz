package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.C18619i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.c */
public final class C18524c implements ReviewManager {

    /* renamed from: a */
    private final C18529h f53210a;

    /* renamed from: b */
    private final Handler f53211b = new Handler(Looper.getMainLooper());

    C18524c(C18529h hVar) {
        this.f53210a = hVar;
    }

    public final Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.mo149202a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        C18619i iVar = new C18619i();
        intent.putExtra("result_receiver", new C18523b(this.f53211b, iVar));
        activity.startActivity(intent);
        return iVar.mo149338a();
    }

    public final Task<ReviewInfo> requestReviewFlow() {
        return this.f53210a.mo149211a();
    }
}
