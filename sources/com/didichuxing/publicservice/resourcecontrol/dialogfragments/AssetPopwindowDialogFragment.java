package com.didichuxing.publicservice.resourcecontrol.dialogfragments;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.p197bi.CommonBIUtil;
import com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource;
import com.didichuxing.publicservice.resourcecontrol.utils.AssetWindowUtil;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceTrack;
import com.didichuxing.publicservice.resourcecontrol.view.AssetPopwindowLayout;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class AssetPopwindowDialogFragment extends BaseDialogFragment {
    public static String TAG = AssetPopwindowDialogFragment.class.getSimpleName();
    /* access modifiers changed from: private */
    public AssetPopwindowLayout assetPopwindowLayout;
    DPopResource dPopResource;
    private ImageView imgClose;
    /* access modifiers changed from: private */
    public View mAnimContainer;

    public static AssetPopwindowDialogFragment newInstance(Bundle bundle) {
        AssetPopwindowDialogFragment assetPopwindowDialogFragment = new AssetPopwindowDialogFragment();
        assetPopwindowDialogFragment.setArguments(bundle);
        return assetPopwindowDialogFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        final View inflate = layoutInflater.inflate(R.layout.asset_frag_popowindow_layout, this.rootContainer, true);
        AssetPopwindowLayout assetPopwindowLayout2 = (AssetPopwindowLayout) inflate.findViewById(R.id.popwindowLayout);
        this.assetPopwindowLayout = assetPopwindowLayout2;
        assetPopwindowLayout2.setUsedInSDKFragment(true);
        this.assetPopwindowLayout.setActivity(this.activity);
        this.assetPopwindowLayout.setResourceId(ConstantUtils.ResourceId.getResource(this.resouceId));
        this.assetPopwindowLayout.initView((DPopResource) this.serializable);
        this.assetPopwindowLayout.setActivity(this.activity);
        this.assetPopwindowLayout.setDialogFragment(this);
        this.imgClose = (ImageView) this.assetPopwindowLayout.findViewById(R.id.popClose);
        this.mAnimContainer = this.assetPopwindowLayout.findViewById(R.id.tone_pubserv_anim_container);
        final HashMap hashMap = new HashMap();
        hashMap.put(CommonBIUtil.KEY_RESOURCEID, CommonBIUtil.convertBiz(this.assetPopwindowLayout.getResourceId()));
        hashMap.put(CommonBIUtil.KEY_ACDID, this.assetPopwindowLayout.getAcdId((DPopResource) this.serializable, 0));
        hashMap.put("key", "pas_notice_webview");
        DPopResource dPopResource2 = (DPopResource) this.serializable;
        this.dPopResource = dPopResource2;
        if (dPopResource2 != null) {
            for (DPopResource.DataBean dataBean : dPopResource2.data) {
                if (dataBean != null) {
                    hashMap.putAll(dataBean.log_data);
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        try {
            String convertBiz = CommonBIUtil.convertBiz(ConstantUtils.ResourceId.getResource(this.resouceId));
            String valueOf = String.valueOf(this.dPopResource.data[0].activity_id);
            hashMap2.put(CommonBIUtil.KEY_RESOURCEID, convertBiz);
            hashMap2.put(CommonBIUtil.KEY_ACDID, valueOf);
            hashMap2.putAll(this.dPopResource.data[0].log_data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_HOME_NTPP_SW, (Map<String, Object>) hashMap2);
        ResourceTrack.trackEventSW(hashMap2);
        this.imgClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DPopResource.DataBean dataBean;
                AutoTrackHelper.trackViewOnClick(view);
                Animation loadAnimation = AnimationUtils.loadAnimation(AssetPopwindowDialogFragment.this.activity, R.anim.asset_popupwindow_slide_out);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(AssetPopwindowDialogFragment.this.activity, R.anim.asset_popupwindow_bg_slide_out);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        AssetPopwindowDialogFragment.this.dismissAllowingStateLoss();
                    }
                });
                AssetPopwindowDialogFragment.this.mAnimContainer.startAnimation(loadAnimation);
                inflate.startAnimation(loadAnimation2);
                int currentItem = AssetPopwindowDialogFragment.this.assetPopwindowLayout.getViewPager().getCurrentItem() % AssetPopwindowDialogFragment.this.assetPopwindowLayout.getPageSize();
                int i = currentItem + 1;
                if (i == 1) {
                    hashMap.put("key", "pas_notice_webview");
                } else {
                    HashMap hashMap = hashMap;
                    hashMap.put("key", "pas_notice_webview_page" + i);
                }
                OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_HOME_NTPPQ_CK, (Map<String, Object>) hashMap);
                if (AssetPopwindowDialogFragment.this.dPopResource != null && AssetPopwindowDialogFragment.this.dPopResource.data != null && currentItem < AssetPopwindowDialogFragment.this.dPopResource.data.length && (dataBean = AssetPopwindowDialogFragment.this.dPopResource.data[currentItem]) != null) {
                    ResourceTrack.trackEventClose(dataBean.log_data);
                    ResourceTrack.trackURL(dataBean.close_tracks);
                }
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AssetPopwindowDialogFragment.this.dismissAllowingStateLoss();
            }
        });
        Animation loadAnimation = AnimationUtils.loadAnimation(this.activity, R.anim.asset_popupwindow_slide_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.activity, R.anim.asset_popupwindow_bg_slide_in);
        this.mAnimContainer.startAnimation(loadAnimation);
        inflate.startAnimation(loadAnimation2);
        return onCreateView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        int i2;
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            Rect rect = new Rect();
            getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            Point point = new Point();
            getActivity().getWindowManager().getDefaultDisplay().getSize(point);
            int i3 = point.y;
            if (i3 > rect.bottom) {
                i = i3 - AssetWindowUtil.getNavigationBarHeight(getActivity().getApplicationContext());
                i2 = rect.top;
            } else {
                i = rect.bottom;
                i2 = rect.top;
            }
            int i4 = i - i2;
            this.assetPopwindowLayout.autoCalculateViewMargin(i4);
            SystemUtils.log(3, "chenyi-public", " screentHeight = " + i4, (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.dialogfragments.AssetPopwindowDialogFragment", 168);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        AssetPopwindowLayout assetPopwindowLayout2 = this.assetPopwindowLayout;
        if (assetPopwindowLayout2 != null) {
            assetPopwindowLayout2.releaseResource();
        }
    }
}
