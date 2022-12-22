package com.didichuxing.omega.sdk.feedback;

import android.net.Uri;
import com.didichuxing.afanty.common.record.FeedbackRecord;

public class FeedbackBitmap {
    private static FeedbackBitmap instance;

    /* renamed from: fr */
    private FeedbackRecord f48481fr;
    private Uri screenshot_uri;

    private FeedbackBitmap() {
    }

    public static synchronized FeedbackBitmap getInstance() {
        FeedbackBitmap feedbackBitmap;
        synchronized (FeedbackBitmap.class) {
            if (instance == null) {
                instance = new FeedbackBitmap();
            }
            feedbackBitmap = instance;
        }
        return feedbackBitmap;
    }

    public Uri getScreenshot_uri() {
        return this.screenshot_uri;
    }

    public void setScreenshot_uri(Uri uri) {
        this.screenshot_uri = uri;
    }

    public FeedbackRecord getFr() {
        return this.f48481fr;
    }

    public void setFr(FeedbackRecord feedbackRecord) {
        this.f48481fr = feedbackRecord;
    }
}
