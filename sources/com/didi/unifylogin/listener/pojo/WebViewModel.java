package com.didi.unifylogin.listener.pojo;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class WebViewModel {

    /* renamed from: a */
    private String f44819a;

    /* renamed from: b */
    private String f44820b;

    /* renamed from: c */
    private WeakReference<Activity> f44821c;

    public String getTitle() {
        return this.f44819a;
    }

    public void setTitle(String str) {
        this.f44819a = str;
    }

    public String getUrl() {
        return this.f44820b;
    }

    public void setUrl(String str) {
        this.f44820b = str;
    }

    public Activity getActivity() {
        return (Activity) this.f44821c.get();
    }

    public void setActivity(Activity activity) {
        this.f44821c = new WeakReference<>(activity);
    }
}
