package com.didiglobal.privacysdk;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class WebViewModel {

    /* renamed from: a */
    private String f50642a;

    /* renamed from: b */
    private String f50643b;

    /* renamed from: c */
    private WeakReference<Activity> f50644c;

    public String getTitle() {
        return this.f50642a;
    }

    public void setTitle(String str) {
        this.f50642a = str;
    }

    public String getUrl() {
        return this.f50643b;
    }

    public void setUrl(String str) {
        this.f50643b = str;
    }

    public Activity getActivity() {
        return (Activity) this.f50644c.get();
    }

    public void setActivity(Activity activity) {
        this.f50644c = new WeakReference<>(activity);
    }
}
