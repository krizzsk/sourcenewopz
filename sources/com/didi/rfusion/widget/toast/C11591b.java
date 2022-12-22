package com.didi.rfusion.widget.toast;

import android.app.Application;
import com.didi.rfusion.widget.toast.helper.RFNotificationToastHelper;

/* renamed from: com.didi.rfusion.widget.toast.b */
/* compiled from: RFNotificationToast */
class C11591b extends C11590a {

    /* renamed from: a */
    private final RFNotificationToastHelper f34007a;

    public C11591b(Application application) {
        super(application);
        this.f34007a = new RFNotificationToastHelper(this, application);
    }

    public void show() {
        this.f34007a.show();
    }

    public void cancel() {
        this.f34007a.cancel();
    }
}
