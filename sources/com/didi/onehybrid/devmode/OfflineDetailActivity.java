package com.didi.onehybrid.devmode;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.onehybrid.devmode.fragment.CurrentPageOfflineAllBundlesFragment;
import com.didi.onehybrid.devmode.fragment.OfflineBundleDetailFragment;
import com.didi.onehybrid.devmode.interfaces.CommunicationInterface;
import com.didi.onehybrid.devmode.interfaces.OnItemClickListener;
import com.didi.onehybrid.devmode.view.Title;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;

public class OfflineDetailActivity extends FragmentActivity implements CommunicationInterface {

    /* renamed from: a */
    FusionRuntimeInfo f29562a;

    /* renamed from: b */
    String f29563b;

    /* renamed from: c */
    Fragment f29564c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) R.layout.offline_detail_activity_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.f29562a = (FusionRuntimeInfo) intent.getSerializableExtra(Const._FUSION_OFFLINE_CACHE_INFO);
        }
        m20800a(0, (HashMap<String, String>) null);
        Title title = (Title) findViewById(R.id.offline_title);
        title.setOnClickLinstener(new OnItemClickListener() {
            public void onClickItem() {
                OfflineDetailActivity.this.getSupportFragmentManager().beginTransaction();
                if (OfflineDetailActivity.this.f29563b.equalsIgnoreCase(OfflineBundleDetailFragment._TAG)) {
                    OfflineDetailActivity.this.m20800a(0, (HashMap<String, String>) null);
                } else {
                    OfflineDetailActivity.this.finish();
                }
            }
        });
        title.setTitleName("-离线包-");
    }

    public void onChange(String str) {
        m20800a(1, this.f29562a.getRenderInfo().mBundles.get(str));
    }

    public FusionRuntimeInfo getFusionRuntimeInfo() {
        return this.f29562a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20800a(int i, HashMap<String, String> hashMap) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (i == 0) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(CurrentPageOfflineAllBundlesFragment._TAG);
            if (findFragmentByTag == null) {
                findFragmentByTag = CurrentPageOfflineAllBundlesFragment.newInstance(this);
                beginTransaction.add(R.id.offline_bundles_item, findFragmentByTag, CurrentPageOfflineAllBundlesFragment._TAG);
                beginTransaction.commit();
            } else {
                beginTransaction.show(findFragmentByTag);
                beginTransaction.hide(this.f29564c);
                beginTransaction.commit();
            }
            this.f29563b = CurrentPageOfflineAllBundlesFragment._TAG;
            this.f29564c = findFragmentByTag;
        } else if (i == 1) {
            Fragment findFragmentByTag2 = getSupportFragmentManager().findFragmentByTag(OfflineBundleDetailFragment._TAG);
            if (findFragmentByTag2 == null) {
                findFragmentByTag2 = OfflineBundleDetailFragment.newInstance(this, hashMap);
                beginTransaction.add(R.id.offline_bundles_item, findFragmentByTag2, OfflineBundleDetailFragment._TAG);
                beginTransaction.commit();
            } else {
                ((OfflineBundleDetailFragment) findFragmentByTag2).setCache(hashMap);
                beginTransaction.show(findFragmentByTag2);
                beginTransaction.hide(this.f29564c);
                beginTransaction.commit();
            }
            this.f29563b = OfflineBundleDetailFragment._TAG;
            this.f29564c = findFragmentByTag2;
        }
    }
}
