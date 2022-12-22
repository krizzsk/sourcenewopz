package com.didi.component.estimate.dynamicprice;

import android.os.Bundle;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;
import com.taxis99.R;

public class DynamicOnceWebActivity extends WebActivity {

    /* renamed from: a */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13025a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            DynamicOnceWebActivity.this.finish();
            DynamicOnceWebActivity.super.overridePendingTransition(R.anim.anim_none, R.anim.side_right_out);
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        setTheme(R.style.WebViewStyle);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.common_status_background));
        super.onCreate(bundle);
        getWebTitleBar().setOnBackClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DynamicOnceWebActivity.this.finish();
                DynamicOnceWebActivity.super.overridePendingTransition(R.anim.anim_none, R.anim.side_right_out);
            }
        });
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_DYNAMIC_CLOSE, this.f13025a);
        overridePendingTransition(R.anim.side_right_in, R.anim.anim_none);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_DYNAMIC_CLOSE, this.f13025a);
    }
}
