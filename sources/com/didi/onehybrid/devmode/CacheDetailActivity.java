package com.didi.onehybrid.devmode;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.onehybrid.devmode.fragment.CacheDetailFragment;
import com.didi.onehybrid.devmode.interfaces.OnItemClickListener;
import com.didi.onehybrid.devmode.view.Title;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class CacheDetailActivity extends FragmentActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) R.layout.cache_detail_activity_layout);
        Title title = (Title) findViewById(R.id.title_cache);
        title.setTitleName("-缓存-");
        title.setOnClickLinstener(new OnItemClickListener() {
            public void onClickItem() {
                CacheDetailActivity.this.finish();
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.cache_list, CacheDetailFragment.newInstance(), CacheDetailFragment._TAG).commit();
    }
}
