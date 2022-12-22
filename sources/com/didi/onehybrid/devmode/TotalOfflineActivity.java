package com.didi.onehybrid.devmode;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.onehybrid.devmode.fragment.OfflineAllBundlesFragment;
import com.didi.onehybrid.devmode.interfaces.OnItemClickListener;
import com.didi.onehybrid.devmode.view.Title;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class TotalOfflineActivity extends FragmentActivity {

    /* renamed from: a */
    FusionRuntimeInfo f29565a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) R.layout.total_offline_activity_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.f29565a = (FusionRuntimeInfo) intent.getSerializableExtra(Const._FUSION_ALL_OFFLINE_CACHE_INFO);
        }
        Title title = (Title) findViewById(R.id.title_total_offline);
        title.setTitleName("-所有离线包-");
        title.setOnClickLinstener(new OnItemClickListener() {
            public void onClickItem() {
                TotalOfflineActivity.this.finish();
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.all_offline, OfflineAllBundlesFragment.newInstance(this.f29565a), OfflineAllBundlesFragment._TAG).commit();
    }
}
