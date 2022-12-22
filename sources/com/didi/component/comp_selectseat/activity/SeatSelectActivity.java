package com.didi.component.comp_selectseat.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.seatselect.SeatSelectFragment;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;

public class SeatSelectActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final int f12378a = 1;

    public static Intent getIntent(Context context, String str) {
        Intent intent = new Intent(context, SeatSelectActivity.class);
        intent.putExtra("uniqueId", str);
        intent.setFlags(268435456);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_minibus);
        m8406a();
    }

    /* renamed from: a */
    private void m8406a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, SeatSelectFragment.newInstance(getIntent().getStringExtra("uniqueId"))).commit();
    }

    public void toNext(JsonObject jsonObject) {
        if (jsonObject == null) {
            GLog.m7968e("MinibusActivity", "toNext>> mSelectValueParams is null");
            return;
        }
        try {
            String json = new Gson().toJson((JsonElement) jsonObject);
            Intent intent = new Intent(this, ShiftSelectActivity.class);
            intent.putExtra("mSelectValueParams", json);
            startActivityForResult(intent, 1);
            overridePendingTransition(R.anim.side_right_in, R.anim.anim_none);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        if (z) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null && !intent.getBooleanExtra("result", false)) {
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        FormStore.getInstance().setIsInMiniBus(false);
        GLog.m7965d("lxsMinibus", "onBackPressed()");
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_none, R.anim.side_right_out);
    }
}
