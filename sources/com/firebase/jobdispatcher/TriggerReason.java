package com.firebase.jobdispatcher;

import android.net.Uri;
import java.util.List;

public class TriggerReason {

    /* renamed from: a */
    private final List<Uri> f52144a;

    TriggerReason(List<Uri> list) {
        this.f52144a = list;
    }

    public List<Uri> getTriggeredContentUris() {
        return this.f52144a;
    }
}
