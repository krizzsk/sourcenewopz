package com.didi.component.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.model.GlobalWebModel;
import com.didi.component.common.util.ActivityCollector;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;
import com.taxis99.R;

public class GlobalWebActivity extends WebActivity implements ActivityCollector.ActivityFinishListener {
    public static final String KEY_GLOBAL_WEB_MODEL = "global_web_model";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GlobalWebModel f11467a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        ActivityCollector.addFinishListener(this);
        GlobalWebModel globalWebModel = (GlobalWebModel) getIntent().getSerializableExtra(KEY_GLOBAL_WEB_MODEL);
        this.f11467a = globalWebModel;
        if (globalWebModel != null && !TextUtils.isEmpty(globalWebModel.titleBarRightBtnText)) {
            this.mWebTitleBar.setRightText(this.f11467a.titleBarRightBtnText);
            this.mWebTitleBar.setRightClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    Intent intent = new Intent(GlobalWebActivity.this, WebActivity.class);
                    intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(GlobalWebActivity.this.f11467a.titleBarRightBtnUrl));
                    GlobalWebActivity.this.startActivity(intent);
                    GlobalWebActivity.this.overridePendingTransition(R.anim.side_right_in, R.anim.anim_none);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeFinishListener(this);
    }

    public void onActivityFinish() {
        finish();
    }
}
