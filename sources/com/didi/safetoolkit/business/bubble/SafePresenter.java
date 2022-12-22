package com.didi.safetoolkit.business.bubble;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.safetoolkit.api.ISfJarvisService;
import com.didi.safetoolkit.business.bubble.ISafePresenter;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.util.SfLog;
import com.didichuxing.foundation.spi.ServiceLoader;

public class SafePresenter implements ISafePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f34267a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SfJarvisData f34268b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SfBubbleData f34269c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ISafePresenter.Callback f34270d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f34271e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f34272f = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f34273g = new Runnable() {
        public void run() {
            if (!TextUtils.isEmpty(SafePresenter.this.f34269c.bubbleId)) {
                SafePresenter.this.f34272f.removeCallbacksAndMessages((Object) null);
                SafePresenter safePresenter = SafePresenter.this;
                safePresenter.m24238a(safePresenter.f34267a, SafePresenter.this.f34269c.bubbleId);
                return;
            }
            SfLog.m24409i("lxs", "runnable");
            boolean z = true;
            int d = SafePresenter.this.f34271e + 1;
            SafePresenter safePresenter2 = SafePresenter.this;
            int unused = safePresenter2.f34271e = d % safePresenter2.f34268b.bubbles.size();
            SafePresenter safePresenter3 = SafePresenter.this;
            SfBubbleData unused2 = safePresenter3.f34269c = safePresenter3.f34268b.bubbles.get(SafePresenter.this.f34271e);
            ISafePresenter.Callback f = SafePresenter.this.f34270d;
            SfBubbleData a = SafePresenter.this.f34269c;
            if (d >= SafePresenter.this.f34268b.bubbles.size()) {
                z = false;
            }
            f.callback(a, z);
            SafePresenter.this.f34272f.postDelayed(SafePresenter.this.f34273g, (long) (SafePresenter.this.f34269c.show * 1000));
        }
    };

    public SafePresenter(Context context) {
        this.f34267a = context;
    }

    public void onActionClick(String str) {
        DRouter.build(str).start(this.f34267a);
    }

    public void refreshJarvisData(SfJarvisData sfJarvisData, ISafePresenter.Callback callback) {
        this.f34268b = sfJarvisData;
        this.f34270d = callback;
        this.f34271e = 0;
        this.f34272f.removeCallbacksAndMessages((Object) null);
        SfLog.m24409i("lxs", "refreshJarvisData");
        if (!m24240a(sfJarvisData)) {
            callback.callback((SfBubbleData) null, true);
        } else if (sfJarvisData.bubbles == null || sfJarvisData.bubbles.size() <= 0) {
            callback.callback((SfBubbleData) null, true);
        } else {
            SfBubbleData sfBubbleData = sfJarvisData.bubbles.get(this.f34271e);
            this.f34269c = sfBubbleData;
            if (sfBubbleData.show == -1) {
                callback.callback(this.f34269c, true);
                return;
            }
            callback.callback(this.f34269c, true);
            this.f34272f.postDelayed(this.f34273g, (long) (this.f34269c.show * 1000));
        }
    }

    public void removeCallBacks() {
        this.f34272f.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24238a(Context context, String str) {
        ISfJarvisService iSfJarvisService = (ISfJarvisService) ServiceLoader.load(ISfJarvisService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfJarvisService != null) {
            iSfJarvisService.monitorAbnormalClick(context, str);
        }
    }

    /* renamed from: a */
    private boolean m24240a(SfJarvisData sfJarvisData) {
        return sfJarvisData != null && sfJarvisData.errno == 0;
    }
}
