package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.streetview.StreetVersion;
import com.didi.map.global.component.streetview.StreetViewComp;
import com.didi.map.global.component.streetview.StreetViewCompParams;
import com.didi.map.sdk.env.PaxEnvironment;

public class StreetViewEntranceManager {

    /* renamed from: a */
    private String f26880a = "StreetViewEntranceManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f26881b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public StreetViewComp f26882c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public StreetLoadCallback f26883d;

    /* renamed from: e */
    private Context f26884e;

    /* renamed from: f */
    private StreetVersion f26885f;

    /* renamed from: g */
    private String f26886g = "";

    /* renamed from: h */
    private String f26887h;

    /* renamed from: i */
    private String f26888i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f26889j = false;

    /* renamed from: k */
    private String f26890k = "";

    /* renamed from: l */
    private StreetViewComp.ILoadCallback f26891l = new StreetViewComp.ILoadCallback() {
        public void onSuccess() {
            boolean unused = StreetViewEntranceManager.this.f26889j = true;
            if (StreetViewEntranceManager.this.f26882c != null) {
                StreetViewEntranceManager streetViewEntranceManager = StreetViewEntranceManager.this;
                View unused2 = streetViewEntranceManager.f26881b = streetViewEntranceManager.f26882c.getTipsView();
            }
            if (StreetViewEntranceManager.this.f26883d != null) {
                StreetViewEntranceManager.this.f26883d.onStreetLoadSuccess();
            }
        }

        public void onFail() {
            boolean unused = StreetViewEntranceManager.this.f26889j = false;
            if (StreetViewEntranceManager.this.f26883d != null) {
                StreetViewEntranceManager.this.f26883d.onStreetLoadFails();
            }
        }

        public void onStreetViewInvalid() {
            boolean unused = StreetViewEntranceManager.this.f26889j = false;
            if (StreetViewEntranceManager.this.f26883d != null) {
                StreetViewEntranceManager.this.f26883d.onStreetInvalid();
            }
        }
    };

    public interface StreetLoadCallback {
        void onStreetInvalid();

        void onStreetLoadFails();

        void onStreetLoadSuccess();
    }

    public StreetViewEntranceManager(Context context, StreetVersion streetVersion, String str, String str2, String str3, String str4, StreetLoadCallback streetLoadCallback) {
        if (context != null) {
            this.f26884e = context;
            this.f26883d = streetLoadCallback;
            this.f26885f = streetVersion;
            this.f26887h = str2;
            this.f26888i = str3;
            this.f26890k = str4;
            this.f26886g = str;
            if (streetVersion != null) {
                m18988a();
                int i = C96852.f26892x1b7f6d62[streetVersion.ordinal()];
                if (i == 1) {
                    DLog.m7384d(this.f26880a, "快车预加载街景", new Object[0]);
                    StreetViewComp streetViewComp = this.f26882c;
                    if (streetViewComp != null) {
                        streetViewComp.load(this.f26891l);
                    }
                } else if (i == 2) {
                    DLog.m7384d(this.f26880a, "快车懒加载街景", new Object[0]);
                    StreetViewComp streetViewComp2 = this.f26882c;
                    if (streetViewComp2 != null) {
                        this.f26881b = streetViewComp2.getTipsView();
                    }
                } else if (i == 3) {
                    DLog.m7384d(this.f26880a, "小巴预加载街景", new Object[0]);
                    StreetViewComp streetViewComp3 = this.f26882c;
                    if (streetViewComp3 != null) {
                        this.f26881b = streetViewComp3.getTipsView();
                        this.f26882c.load(this.f26891l);
                    }
                }
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager$2 */
    static /* synthetic */ class C96852 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$streetview$StreetVersion */
        static final /* synthetic */ int[] f26892x1b7f6d62;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.map.global.component.streetview.StreetVersion[] r0 = com.didi.map.global.component.streetview.StreetVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26892x1b7f6d62 = r0
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26892x1b7f6d62     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26892x1b7f6d62     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V3     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager.C96852.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m18988a() {
        if (TextUtils.isEmpty(this.f26887h) || this.f26885f == null) {
            destroy();
            DLog.m7384d(this.f26880a, "input data is invalid", new Object[0]);
            return;
        }
        StreetViewComp streetViewComp = this.f26882c;
        if (streetViewComp != null) {
            streetViewComp.onDestroy();
            this.f26882c = null;
        }
        this.f26882c = new StreetViewComp(new StreetViewCompParams.Builder().activity((FragmentActivity) this.f26884e).uid(PaxEnvironment.getInstance().getUid()).tripId(this.f26888i).orderId(this.f26890k).streetViewUrl(this.f26887h).panningGesturesEnable(false).userNavigationEnabled(false).streetNamesEnabled(false).setStreetVersion(this.f26885f).setStreetHintContent(this.f26886g).build());
    }

    public void loadAndShowStreetView() {
        DLog.m7384d(this.f26880a, "点击后懒加载街景", new Object[0]);
        if (this.f26889j) {
            showBigStreet();
            return;
        }
        StreetViewComp streetViewComp = this.f26882c;
        if (streetViewComp != null) {
            streetViewComp.load(this.f26891l);
        }
    }

    public void destroy() {
        StreetViewComp streetViewComp = this.f26882c;
        if (streetViewComp != null) {
            streetViewComp.onDestroy();
            this.f26882c = null;
        }
    }

    public View getSmallStreetView() {
        return this.f26881b;
    }

    public void showBigStreet() {
        StreetViewComp streetViewComp = this.f26882c;
        if (streetViewComp != null) {
            streetViewComp.show();
        }
    }

    public void hideBigStreet() {
        StreetViewComp streetViewComp = this.f26882c;
        if (streetViewComp != null) {
            streetViewComp.hide();
        }
    }

    public boolean isStreetViewShow() {
        StreetViewComp streetViewComp = this.f26882c;
        if (streetViewComp != null) {
            return streetViewComp.isStreetViewDialogShow();
        }
        return false;
    }
}
