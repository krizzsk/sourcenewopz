package com.component.android.comp_location.presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.component.android.comp_location.AbsGlobalLocationPresenter;
import com.didi.component.business.event.ResetMapEvent;
import com.didi.component.business.util.UiUtils;
import com.didi.component.core.ComponentParams;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class GlobalOnServiceLocationPresenter extends AbsGlobalLocationPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f3299a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f3300b = 0;

    /* renamed from: c */
    private Handler f3301c = new Handler() {
        public void handleMessage(Message message) {
            if (message != null && GlobalOnServiceLocationPresenter.this.m2246b()) {
                ResetMapEvent obtain = ResetMapEvent.obtain();
                GlobalOnServiceLocationPresenter globalOnServiceLocationPresenter = GlobalOnServiceLocationPresenter.this;
                int a = globalOnServiceLocationPresenter.getCalExtraHeightToShowBestView(globalOnServiceLocationPresenter.f3300b);
                obtain.fillData(0, GlobalOnServiceLocationPresenter.this.mPaddingTop, 0, a);
                Logger e = GlobalOnServiceLocationPresenter.this.f3299a;
                e.info("hhl-dobestview ^ EVENT_RESET_MAP:mPaddingTop=" + GlobalOnServiceLocationPresenter.this.mPaddingTop + ",mPaddingBottom=" + a, new Object[0]);
                GlobalOnServiceLocationPresenter.this.doPublish("event_map_reset_map", obtain);
                GlobalOnServiceLocationPresenter.this.requestMapLayout();
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m2246b() {
        return this.f3300b < (UiUtils.getWindowHeight((Activity) this.mContext) / 4) * 3;
    }

    public GlobalOnServiceLocationPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onXPanelScrollChanged(int i) {
        super.onXPanelScrollChanged(i);
        if (this.f3300b != i) {
            this.f3300b = i;
            m2248c();
        }
    }

    /* renamed from: c */
    private void m2248c() {
        this.f3301c.removeCallbacksAndMessages((Object) null);
        this.f3301c.sendEmptyMessageDelayed(0, 300);
    }
}
