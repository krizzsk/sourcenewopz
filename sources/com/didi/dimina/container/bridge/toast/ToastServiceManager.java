package com.didi.dimina.container.bridge.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Timer;
import java.util.TimerTask;

public class ToastServiceManager {

    /* renamed from: f */
    private static final int f16773f = 0;

    /* renamed from: g */
    private static final int f16774g = 1;

    /* renamed from: a */
    private final Context f16775a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Toast f16776b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ToastType f16777c;

    /* renamed from: d */
    private int f16778d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CharSequence f16779e;

    /* renamed from: h */
    private Timer f16780h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Handler f16781i = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                try {
                    Toast unused = ToastServiceManager.this.f16776b = ToastServiceManager.this.m12445a(ToastServiceManager.this.f16777c, ToastServiceManager.this.f16779e);
                    SystemUtils.showToast(ToastServiceManager.this.f16776b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (i == 1) {
                ToastServiceManager.this.m12447a();
            }
        }
    };

    public ToastServiceManager(Context context) {
        this.f16775a = context;
    }

    public void showToast(ToastType toastType, CharSequence charSequence, int i) {
        m12447a();
        this.f16777c = toastType;
        this.f16778d = i;
        if (i < 0) {
            this.f16778d = 0;
        }
        this.f16779e = charSequence;
        Timer timer = new Timer();
        this.f16780h = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                ToastServiceManager.this.f16781i.sendEmptyMessage(0);
            }
        }, 0, 3000);
        this.f16781i.sendEmptyMessageDelayed(1, (long) this.f16778d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12447a() {
        this.f16781i.removeMessages(1);
        Toast toast = this.f16776b;
        if (toast != null) {
            toast.cancel();
            this.f16776b = null;
        }
        Timer timer = this.f16780h;
        if (timer != null) {
            timer.cancel();
            this.f16780h.purge();
        }
    }

    public void hideToast() {
        this.f16781i.sendEmptyMessage(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Toast m12445a(ToastType toastType, CharSequence charSequence) {
        return m12442a(this.f16775a, m12441a(this.f16775a, toastType, charSequence));
    }

    /* renamed from: a */
    private Toast m12442a(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setDuration(1);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        return toast;
    }

    /* renamed from: a */
    private View m12441a(Context context, ToastType toastType, CharSequence charSequence) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dimina_toast_view, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        View findViewById = inflate.findViewById(R.id.progress_bar);
        int i = C74433.$SwitchMap$com$didi$dimina$container$bridge$toast$ToastType[toastType.ordinal()];
        if (i == 1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.dimina_toast_notice);
        } else if (i == 2) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.dimina_toast_success);
        } else if (i != 3) {
            imageView.setVisibility(8);
            findViewById.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            findViewById.setVisibility(0);
        }
        ((TextView) inflate.findViewById(R.id.text)).setText(charSequence);
        return inflate;
    }

    /* renamed from: com.didi.dimina.container.bridge.toast.ToastServiceManager$3 */
    static /* synthetic */ class C74433 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$dimina$container$bridge$toast$ToastType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.dimina.container.bridge.toast.ToastType[] r0 = com.didi.dimina.container.bridge.toast.ToastType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$dimina$container$bridge$toast$ToastType = r0
                com.didi.dimina.container.bridge.toast.ToastType r1 = com.didi.dimina.container.bridge.toast.ToastType.ERROR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$dimina$container$bridge$toast$ToastType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dimina.container.bridge.toast.ToastType r1 = com.didi.dimina.container.bridge.toast.ToastType.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$dimina$container$bridge$toast$ToastType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dimina.container.bridge.toast.ToastType r1 = com.didi.dimina.container.bridge.toast.ToastType.LOADING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$dimina$container$bridge$toast$ToastType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.dimina.container.bridge.toast.ToastType r1 = com.didi.dimina.container.bridge.toast.ToastType.NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.toast.ToastServiceManager.C74433.<clinit>():void");
        }
    }
}
