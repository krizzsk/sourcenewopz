package com.didichuxing.publicservice.resourcecontrol.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.pojo.Resource;

public class AssetBasicFragment extends Fragment {
    protected FragmentActivity mActivity;
    public Resource resource;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActivity = getActivity();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public static AssetBasicFragment creatFragmentByCode(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        switch (bundle.getInt(ConstantUtils.EXTRA_RESOURCE_TYPE)) {
            case 1001:
                return AssetListViewFragment.newInstance(bundle);
            case 1002:
                return AssetSplashViewFragment.newInstance(bundle);
            case 1003:
                return AssetPopwindowFragment.newInstance(bundle);
            case 1004:
                return AssetWebviewFragment.newInstance(bundle);
            default:
                return null;
        }
    }
}
