package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeReviewManager implements ReviewManager {

    /* renamed from: a */
    private final Context f53221a;

    /* renamed from: b */
    private ReviewInfo f53222b;

    public FakeReviewManager(Context context) {
        this.f53221a = context;
    }

    public Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        return reviewInfo != this.f53222b ? Tasks.m38220a((Exception) new C18530a()) : Tasks.m38221a(null);
    }

    public Task<ReviewInfo> requestReviewFlow() {
        ReviewInfo a = ReviewInfo.m38019a(PendingIntent.getBroadcast(this.f53221a, 0, new Intent(), 0));
        this.f53222b = a;
        return Tasks.m38221a(a);
    }
}
