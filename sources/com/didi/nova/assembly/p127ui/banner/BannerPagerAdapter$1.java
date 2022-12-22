package com.didi.nova.assembly.p127ui.banner;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.nova.assembly.ui.banner.BannerPagerAdapter$1 */
class BannerPagerAdapter$1 implements View.OnClickListener {
    final /* synthetic */ C10277a this$0;
    final /* synthetic */ int val$position;

    BannerPagerAdapter$1(C10277a aVar, int i) {
        this.this$0 = aVar;
        this.val$position = i;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int a = this.this$0.m20635b(this.val$position);
        if (((Banner) this.this$0.f29251d.get()).f29227a != null) {
            ((Banner) this.this$0.f29251d.get()).f29227a.onBannerClick(a);
        }
        SystemUtils.log(3, "Banner", "banner click, pos = " + a, (Throwable) null, "com.didi.nova.assembly.ui.banner.BannerPagerAdapter$1", 71);
    }
}
