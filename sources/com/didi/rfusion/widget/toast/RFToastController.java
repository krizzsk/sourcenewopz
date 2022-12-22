package com.didi.rfusion.widget.toast;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationManagerCompat;
import com.didi.rfusion.RFusion;
import com.didi.rfusion.utils.RFActivityManager;
import com.didi.rfusion.widget.toast.helper.RFToastSafeHook;
import com.didi.sdk.apm.SystemUtils;

class RFToastController {

    /* renamed from: a */
    private static final int f34001a = 3;

    /* renamed from: b */
    private static final Handler f34002b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private C11590a f34003c;

    private RFToastController() {
    }

    private static final class InnerHolder {
        /* access modifiers changed from: private */
        public static final RFToastController INSTANCE = new RFToastController();

        private InnerHolder() {
        }
    }

    /* renamed from: a */
    public static RFToastController m24003a() {
        return InnerHolder.INSTANCE;
    }

    /* renamed from: a */
    public void mo88597a(String str, int i, boolean z) {
        if (z || RFActivityManager.getInstance().isApplicationForeground()) {
            Context context = RFusion.getContext();
            if (context instanceof Application) {
                f34002b.post(new Runnable(context, str, i) {
                    public final /* synthetic */ Context f$1;
                    public final /* synthetic */ String f$2;
                    public final /* synthetic */ int f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        RFToastController.this.m24005a(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m24005a(Context context, String str, int i) {
        m24007b();
        C11590a a = m24004a((Application) context);
        this.f34003c = a;
        a.mo88599a(str);
        this.f34003c.mo88598a(i);
        SystemUtils.showToast(this.f34003c);
    }

    /* renamed from: a */
    private C11590a m24004a(Application application) {
        C11590a aVar;
        if (m24006a((Context) application)) {
            aVar = new C11590a(application);
        } else {
            aVar = new C11591b(application);
        }
        if (Build.VERSION.SDK_INT == 25) {
            RFToastSafeHook.makeSafe(aVar);
        }
        return aVar;
    }

    /* renamed from: b */
    private void m24007b() {
        C11590a aVar = this.f34003c;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    /* renamed from: a */
    private static boolean m24006a(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }
}
