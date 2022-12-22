package com.didi.onehybrid.devmode.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ListFragment;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.onehybrid.devmode.adapter.CacheDetailListAdapter;
import com.didi.onehybrid.resource.FusionCacheClient;
import java.util.ArrayList;

public class CacheDetailFragment extends ListFragment {
    public static final String _TAG = "CacheDetailFragment";

    /* renamed from: a */
    private View f29566a;

    /* renamed from: b */
    private CacheDetailListAdapter f29567b;

    public static CacheDetailFragment newInstance() {
        CacheDetailFragment cacheDetailFragment = new CacheDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("label", _TAG);
        cacheDetailFragment.setArguments(bundle);
        return cacheDetailFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f29566a = onCreateView;
        return onCreateView;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ArrayList arrayList = new ArrayList();
        FusionRuntimeInfo.RenderInfo.fillCacheDetail(FusionCacheClient.getHybridDir(), arrayList);
        CacheDetailListAdapter cacheDetailListAdapter = new CacheDetailListAdapter(getContext(), arrayList);
        this.f29567b = cacheDetailListAdapter;
        setListAdapter(cacheDetailListAdapter);
    }
}
