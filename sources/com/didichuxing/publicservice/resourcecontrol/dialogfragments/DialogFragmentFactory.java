package com.didichuxing.publicservice.resourcecontrol.dialogfragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class DialogFragmentFactory {
    private static Map<Integer, BaseDialogFragment> dialogfragments = new HashMap();
    private static ResourceApi.OnSplashListener mSplashListener;

    public static BaseDialogFragment createDialogFragment(Bundle bundle) {
        BaseDialogFragment baseDialogFragment;
        int i = bundle.getInt(ConstantUtils.EXTRA_RESOURCE_TYPE);
        HashMap hashMap = new HashMap();
        hashMap.put("resouceType", i + "");
        OmegaSDKAdapter.trackEvent("theone_ppx_publicservice_test14", "", hashMap);
        switch (i) {
            case 1001:
                baseDialogFragment = AssetListViewDialogFragment.newInstance(bundle);
                break;
            case 1002:
                baseDialogFragment = AssetSplashViewDialogFragment.newInstance(bundle);
                break;
            case 1003:
                OmegaSDKAdapter.trackEvent("theone_ppx_publicservice_test15", "", hashMap);
                baseDialogFragment = AssetPopwindowDialogFragment.newInstance(bundle);
                break;
            case 1004:
                baseDialogFragment = AssetWebviewDialogFragment.newInstance(bundle);
                break;
            case 1005:
                OmegaSDKAdapter.trackEvent("theone_ppx_publicservice_test15", "", hashMap);
                baseDialogFragment = AssetPopwindowDialogFragment.newInstance(bundle);
                break;
            case 1006:
                OmegaSDKAdapter.trackEvent("theone_ppx_publicservice_test15", "", hashMap);
                baseDialogFragment = AssetPopwindowDialogFragment2.newInstance(bundle);
                break;
            default:
                baseDialogFragment = null;
                break;
        }
        if (baseDialogFragment != null) {
            baseDialogFragment.setOnSplashListener(mSplashListener);
        }
        return baseDialogFragment;
    }

    public static void showDialogFragment(FragmentManager fragmentManager, BaseDialogFragment baseDialogFragment, String str) {
        AppUtils.log("======== showDialogFragment ===========");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.add((Fragment) baseDialogFragment, str);
        beginTransaction.commitAllowingStateLoss();
    }

    public static void setOnSplashListener(ResourceApi.OnSplashListener onSplashListener) {
        mSplashListener = onSplashListener;
    }

    public static void destroyOnSplashListener() {
        mSplashListener = null;
    }
}
