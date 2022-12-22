package com.didi.component.comp_selectseat.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.shiftselect.ShiftSelectFragment;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class ShiftSelectActivity extends AppCompatActivity {

    /* renamed from: a */
    private final String f12379a = "ShiftSelectActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_shift_select);
        m8407a(getIntent().getStringExtra("mSelectValueParams"));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        GLog.m7972v("ShiftSelectActivity", "onStart: ");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        GLog.m7972v("ShiftSelectActivity", "onResume: ");
    }

    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        if (z) {
            finish();
        }
    }

    /* renamed from: a */
    private void m8407a(String str) {
        getSupportFragmentManager().beginTransaction().replace(R.id.shift_fragment_container, ShiftSelectFragment.newInstance(str)).commit();
    }

    public void clickConfirm() {
        Intent intent = new Intent();
        intent.putExtra("result", false);
        setResult(1, intent);
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_none, R.anim.side_right_out);
    }
}
