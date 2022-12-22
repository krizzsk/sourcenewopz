package com.didi.component.service.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;
import com.didi.travel.psnger.store.DDTravelConfigStore;

public class DynamicWebActivity extends WebActivity {
    public static final int CLICK_RESULT_AGREE = 1;
    public static final int CLICK_RESULT_DISAGREE = 2;
    public static final String KEY_CLICK_RESULT = "click_result";

    /* renamed from: a */
    private BaseEventPublisher.OnEventListener<String> f15658a = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            DynamicWebActivity.this.m11429a(str2);
        }
    };

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        getWebTitleBar().setOnBackClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DynamicWebActivity.this.finish();
            }
        });
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_DYNAMIC_BRIDGE_CALLBACK, this.f15658a);
    }

    public void setFinishResult(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_DYNAMIC_BRIDGE_CALLBACK, this.f15658a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11429a(String str) {
        if ("close".equals(str)) {
            Intent intent = new Intent();
            intent.putExtra(KEY_CLICK_RESULT, 2);
            setFinishResult(intent);
        } else if ("disagree".equals(str)) {
            Intent intent2 = new Intent();
            intent2.putExtra(KEY_CLICK_RESULT, 2);
            setFinishResult(intent2);
        } else if ("agree".equals(str)) {
            DDTravelConfigStore.getInstance().setDynamicPriceConfirmMark(true);
            Intent intent3 = new Intent();
            intent3.putExtra(KEY_CLICK_RESULT, 1);
            setFinishResult(intent3);
        }
    }
}
