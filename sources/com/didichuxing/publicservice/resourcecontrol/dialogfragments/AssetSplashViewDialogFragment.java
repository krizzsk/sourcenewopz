package com.didichuxing.publicservice.resourcecontrol.dialogfragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.apm.SystemUtils;
import com.didi.trackupload.sdk.Constants;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.p197bi.CommonBIUtil;
import com.didichuxing.publicservice.resourcecontrol.pojo.DSplashResource;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceTrack;
import com.didichuxing.publicservice.resourcecontrol.view.AssetSplashViewLayout;
import com.didichuxing.publicservice.screenAd.ScreenAdManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class AssetSplashViewDialogFragment extends BaseDialogFragment {
    public static final int SPLASH_FRAGMENT_CLOSE = 101;
    public static final int SPLASH_FRAGMENT_PAUSE = 102;
    public static String TAG = AssetSplashViewDialogFragment.class.getSimpleName();
    private AssetSplashViewLayout assetSplashViewLayout;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 101) {
                AssetSplashViewDialogFragment.this.exitSplash();
            } else if (i == 102) {
                AssetSplashViewDialogFragment.this.mSkipAdTimer.cancel();
            }
        }
    };
    /* access modifiers changed from: private */
    public int mAdTimeSeconds = 3;
    /* access modifiers changed from: private */
    public Timer mSkipAdTimer;

    static /* synthetic */ int access$206(AssetSplashViewDialogFragment assetSplashViewDialogFragment) {
        int i = assetSplashViewDialogFragment.mAdTimeSeconds - 1;
        assetSplashViewDialogFragment.mAdTimeSeconds = i;
        return i;
    }

    /* access modifiers changed from: private */
    public void exitSplash() {
        DSplashResource.DataBean dataBean;
        if (ResourceApi.isFromSlashActvity) {
            preExit();
        } else {
            dismissAllowingStateLoss();
        }
        if (this.onSplashListener != null) {
            this.onSplashListener.onSplashCloseOrAbsent();
        }
        this.onSplashListener = null;
        DialogFragmentFactory.destroyOnSplashListener();
        DSplashResource dSplashResource = (DSplashResource) this.serializable;
        if (dSplashResource != null && (dataBean = dSplashResource.data.get(0)) != null) {
            ResourceTrack.trackURL(dataBean.close_tracks);
        }
    }

    private void preExit() {
        this.mSkipAdTimer.cancel();
        ResourceApi.mResourceHandler.sendEmptyMessage(101);
    }

    public static AssetSplashViewDialogFragment newInstance(Bundle bundle) {
        AssetSplashViewDialogFragment assetSplashViewDialogFragment = new AssetSplashViewDialogFragment();
        assetSplashViewDialogFragment.setArguments(bundle);
        return assetSplashViewDialogFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.Asset_Notices);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.asset_frag_splashview_layout, this.rootContainer, true);
        setCancelable(false);
        AssetSplashViewLayout assetSplashViewLayout2 = (AssetSplashViewLayout) inflate.findViewById(R.id.assetSplashLayout);
        this.assetSplashViewLayout = assetSplashViewLayout2;
        assetSplashViewLayout2.setActivity(this.activity);
        DSplashResource dSplashResource = (DSplashResource) this.serializable;
        this.assetSplashViewLayout.showSplashComercial(dSplashResource, this.handler);
        HashMap hashMap = new HashMap();
        DSplashResource dSplashResource2 = (DSplashResource) this.serializable;
        hashMap.put(CommonBIUtil.KEY_ACDID, Integer.valueOf(getAcdId((DSplashResource) this.serializable)));
        if (!(dSplashResource == null || dSplashResource.data == null || dSplashResource.data.size() <= 0 || dSplashResource2.data.get(0) == null)) {
            hashMap.putAll(dSplashResource2.data.get(0).log_data);
        }
        String valueOf = String.valueOf(dSplashResource.data.get(0).activity_id);
        Map map = null;
        if (this.activity != null && !TextUtils.isEmpty(valueOf)) {
            map = ResourceApi.getMapFromString(SystemUtils.getPreferences(this.activity, 0), valueOf);
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            SharedPreferences preferences = SystemUtils.getPreferences(this.activity, 0);
            ResourceTrack.trackURL(ResourceApi.getListFromString(preferences, valueOf + "imp"));
        }
        ResourceTrack.trackEventSW(map);
        hashMap.put("key", ConstantUtils.PASSAGER_RESOURCE_NAME);
        OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_BUB_ACT_SW, (Map<String, Object>) hashMap);
        return onCreateView;
    }

    private int getAcdId(DSplashResource dSplashResource) {
        if (dSplashResource == null || dSplashResource.data == null || dSplashResource.data.size() <= 0) {
            return 0;
        }
        return dSplashResource.data.get(0).activity_id;
    }

    /* access modifiers changed from: private */
    public void setSkipAdTxt(int i) {
        if (getActivity() == null || !isAdded()) {
            this.mSkipAdTimer.cancel();
        } else {
            this.assetSplashViewLayout.setSkipInfo(i);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setSkipAdTxt(this.mAdTimeSeconds);
        Timer timer = new Timer("SkipAdTimer");
        this.mSkipAdTimer = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                AssetSplashViewDialogFragment.this.activity.runOnUiThread(new Runnable() {
                    public void run() {
                        if (AssetSplashViewDialogFragment.this.mAdTimeSeconds >= 0) {
                            AssetSplashViewDialogFragment.access$206(AssetSplashViewDialogFragment.this);
                            if (AssetSplashViewDialogFragment.this.mAdTimeSeconds > 0) {
                                AssetSplashViewDialogFragment.this.setSkipAdTxt(AssetSplashViewDialogFragment.this.mAdTimeSeconds);
                            }
                            if (AssetSplashViewDialogFragment.this.mAdTimeSeconds == 0) {
                                AssetSplashViewDialogFragment.this.exitSplash();
                            }
                        }
                    }
                });
            }
        }, 0, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
        DSplashResource dSplashResource = (DSplashResource) this.serializable;
        if (dSplashResource != null && dSplashResource.data != null && dSplashResource.data.size() > 0) {
            ScreenAdManager.getInstance().updateLastShowTime(this.activity.getApplicationContext(), (long) dSplashResource.data.get(0).activity_id);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AppUtils.log("splash--onDestroy-release-->>>");
        this.assetSplashViewLayout.release();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mSkipAdTimer.cancel();
        this.assetSplashViewLayout.destorySplashBitmap();
    }
}
