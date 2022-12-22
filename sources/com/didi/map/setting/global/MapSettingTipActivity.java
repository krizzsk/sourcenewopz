package com.didi.map.setting.global;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.MapSettingBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class MapSettingTipActivity extends MapSettingBaseActivity {
    public static void startMapSettingTipActivity(Context context) {
        context.startActivity(new Intent(context, MapSettingTipActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.map_setting_tip_layout);
        findViewById(R.id.map_setting_know_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingTipActivity.this.finish();
            }
        });
    }
}
