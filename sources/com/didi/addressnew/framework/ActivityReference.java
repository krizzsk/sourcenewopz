package com.didi.addressnew.framework;

import java.lang.ref.WeakReference;

public class ActivityReference {

    /* renamed from: a */
    private static ActivityReference f4310a = new ActivityReference();

    /* renamed from: b */
    private WeakReference f4311b;

    public static ActivityReference getInstance() {
        synchronized (ActivityReference.class) {
            if (f4310a == null) {
                f4310a = new ActivityReference();
            }
        }
        return f4310a;
    }

    public SugMainDialogActivity getCurrentActivity() {
        WeakReference weakReference = this.f4311b;
        if (weakReference != null) {
            return (SugMainDialogActivity) weakReference.get();
        }
        return null;
    }

    public void setCurrentActivity(SugMainDialogActivity sugMainDialogActivity) {
        this.f4311b = new WeakReference(sugMainDialogActivity);
    }
}
