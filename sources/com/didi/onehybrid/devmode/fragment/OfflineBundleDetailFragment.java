package com.didi.onehybrid.devmode.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.onehybrid.devmode.adapter.OfflineDetailListAdapter;
import com.didi.onehybrid.devmode.interfaces.CommunicationInterface;
import com.didi.onehybrid.util.C10393Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OfflineBundleDetailFragment extends BaseFragment {
    public static final String _TAG = "OfflineBundleDetailFragment";

    /* renamed from: a */
    HashMap<String, String> f29573a;

    /* renamed from: b */
    private OfflineDetailListAdapter f29574b;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public static OfflineBundleDetailFragment newInstance(CommunicationInterface communicationInterface, HashMap<String, String> hashMap) {
        OfflineBundleDetailFragment offlineBundleDetailFragment = new OfflineBundleDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("label", _TAG);
        offlineBundleDetailFragment.setArguments(bundle);
        offlineBundleDetailFragment.setChangeToTargetFragment(communicationInterface);
        offlineBundleDetailFragment.setCache(hashMap);
        return offlineBundleDetailFragment;
    }

    public void onResume() {
        super.onResume();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            m20802a();
        }
    }

    public void setCache(HashMap<String, String> hashMap) {
        this.f29573a = hashMap;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m20802a();
    }

    /* renamed from: a */
    private void m20802a() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f29573a.entrySet()) {
            File file = new File((String) next.getValue());
            OfflineDetailListAdapter.CacheItemInfo cacheItemInfo = new OfflineDetailListAdapter.CacheItemInfo();
            cacheItemInfo.mFileName = file.getName();
            cacheItemInfo.mFileSize = "File size :  " + C10393Util.smartConvert(file.length());
            cacheItemInfo.mFileUrl = "File source :  " + ((String) next.getKey());
            Date date = new Date(file.lastModified());
            cacheItemInfo.mModifyTime = "File modify time :  " + date.toString();
            cacheItemInfo.mFilePath = "Local path :  " + file.getAbsolutePath();
            arrayList.add(cacheItemInfo);
        }
        OfflineDetailListAdapter offlineDetailListAdapter = new OfflineDetailListAdapter(getContext(), arrayList);
        this.f29574b = offlineDetailListAdapter;
        setListAdapter(offlineDetailListAdapter);
    }
}
