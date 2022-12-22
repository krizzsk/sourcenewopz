package com.didi.component.business.sharetrip;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.sharetrip.ShareTripDialogCache;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.loading.XPanelLoadingWrapper;
import com.didi.component.common.util.GLog;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.callback.intercept.ShareDialogInterceptUtil;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import com.didi.onekeyshare.view.fragment.ShareFragment;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didiglobal.travel.util.CollectionUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommonTripShareManager extends XPanelLoadingWrapper {

    /* renamed from: a */
    private ShareFragment f11347a;

    /* renamed from: b */
    private ArrayList<SharePlatform> f11348b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f11349c = GlobalApolloUtil.isRiderSafetyToolkitShare();

    public CommonTripShareManager() {
    }

    public CommonTripShareManager(ArrayList<SharePlatform> arrayList) {
        this.f11348b = arrayList;
    }

    public void getTripShareInfo(final Activity activity, String str, int i) {
        disMissOneKeyShareDialog();
        if (activity != null) {
            showProgressDialog();
            ShareTripDialogCache.getInstance().getTripShareInfoWithNoCache(activity, str, i, new ShareTripDialogCache.RequestCallback<CommonTripShareInfo>() {
                public void onSuccess(CommonTripShareInfo commonTripShareInfo) {
                    CommonTripShareManager.this.dismissProgressDialog();
                    ShareInfo a = CommonTripShareManager.this.m7671a(commonTripShareInfo);
                    if (CommonTripShareManager.this.f11349c) {
                        CommonTripShareManager.this.m7675a((FragmentActivity) activity, a);
                    } else {
                        CommonTripShareManager.this.m7679b((FragmentActivity) activity, a);
                    }
                    CommonTripShareManager.this.dismissProgressDialog();
                }

                public void onFail(CommonTripShareInfo commonTripShareInfo) {
                    Activity activity = activity;
                    ToastHelper.showLongInfo((Context) activity, ResourcesHelper.getString(activity, R.string.global_net_failed_str));
                    CommonTripShareManager.this.dismissProgressDialog();
                }
            });
        }
    }

    @Deprecated
    public void showShareDialog(Activity activity, String str, int i) {
        CommonTripShareInfo shareInfo = ShareTripDialogCache.getInstance().getShareInfo();
        if (shareInfo == null || !this.f11349c) {
            getTripShareInfo(activity, str, i);
            return;
        }
        m7675a((FragmentActivity) activity, m7671a(shareInfo));
    }

    public ShareFragment showDialogIfAvailable(FragmentActivity fragmentActivity, ShareInfo shareInfo) {
        m7675a((FragmentActivity) Objects.requireNonNull(fragmentActivity), (ShareInfo) Objects.requireNonNull(shareInfo));
        return this.f11347a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ShareInfo m7671a(CommonTripShareInfo commonTripShareInfo) {
        ArrayList<SharePlatform> arrayList = this.f11348b;
        if (this.f11349c) {
            int countryId = OneConfStore.getInstance().getCountryId();
            if ("JP".equals(OneLoginFacade.getStore().getAreaCode()) || countryId == 81) {
                arrayList = m7674a();
            } else {
                arrayList = m7678b();
            }
        } else if (CollectionUtils.isEmpty((Collection<?>) arrayList)) {
            arrayList = m7681c();
        }
        if (CollectionUtil.isEmpty((Collection<?>) arrayList)) {
            arrayList = m7678b();
        }
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.title = commonTripShareInfo.shareTitle;
        shareInfo.content = commonTripShareInfo.shareCotent;
        shareInfo.url = commonTripShareInfo.shareUrl;
        shareInfo.imageUrl = commonTripShareInfo.sharePicture;
        shareInfo.platforms = arrayList;
        shareInfo.smsMessage = commonTripShareInfo.shareTitle + "," + commonTripShareInfo.shareCotent + " " + commonTripShareInfo.shareUrl;
        StringBuilder sb = new StringBuilder();
        sb.append("Trip share :: ");
        sb.append(commonTripShareInfo);
        GLog.m7968e("ldx", sb.toString());
        return shareInfo;
    }

    /* renamed from: a */
    private ArrayList<SharePlatform> m7674a() {
        ArrayList<SharePlatform> arrayList = new ArrayList<>();
        arrayList.add(SharePlatform.LINE_PLATFORM);
        arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
        arrayList.add(SharePlatform.CONTACTS_PLATFORM);
        arrayList.add(SharePlatform.COPY_LINK_PLATFORM);
        return arrayList;
    }

    /* renamed from: b */
    private ArrayList<SharePlatform> m7678b() {
        ArrayList<SharePlatform> arrayList = new ArrayList<>();
        arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
        arrayList.add(SharePlatform.CONTACTS_PLATFORM);
        arrayList.add(SharePlatform.COPY_LINK_PLATFORM);
        return arrayList;
    }

    /* renamed from: c */
    private ArrayList<SharePlatform> m7681c() {
        ArrayList<SharePlatform> arrayList = new ArrayList<>();
        arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
        arrayList.add(SharePlatform.FACEBOOK_PLATFORM);
        arrayList.add(SharePlatform.SYSTEM_MESSAGE);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7675a(FragmentActivity fragmentActivity, ShareInfo shareInfo) {
        this.f11347a = buildShare(fragmentActivity, shareInfo, (ICallback.IPlatformShareCallback) null, new PlatformClickListener() {
            public void onClick(SharePlatform sharePlatform) {
                HashMap hashMap = new HashMap();
                hashMap.put("source", 1);
                hashMap.put("channel", sharePlatform.platformName());
                GlobalOmegaUtils.trackEvent("pas_sharepannel_ck", (Map<String, Object>) hashMap);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7679b(FragmentActivity fragmentActivity, ShareInfo shareInfo) {
        this.f11347a = ShareBuilder.buildShare(fragmentActivity, shareInfo, (ICallback.IPlatformShareCallback) null, (PlatformClickListener) new PlatformClickListener() {
            public void onClick(SharePlatform sharePlatform) {
                HashMap hashMap = new HashMap();
                hashMap.put("source", 1);
                hashMap.put("channel", sharePlatform.platformName());
                GlobalOmegaUtils.trackEvent("pas_sharepannel_ck", (Map<String, Object>) hashMap);
            }
        });
    }

    public void disMissOneKeyShareDialog() {
        ShareFragment shareFragment = this.f11347a;
        if (shareFragment != null && !shareFragment.isHidden()) {
            try {
                this.f11347a.dismissAllowingStateLoss();
            } catch (Throwable unused) {
            }
            this.f11347a = null;
        }
    }

    /* access modifiers changed from: protected */
    public void showProgressDialog() {
        showLoading();
    }

    /* access modifiers changed from: protected */
    public void dismissProgressDialog() {
        hideLoading();
    }

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ShareInfo shareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback, PlatformClickListener platformClickListener) {
        if (fragmentActivity == null || fragmentActivity.isFinishing() || shareInfo == null || ShareDialogInterceptUtil.intercept(fragmentActivity, shareInfo)) {
            return null;
        }
        ShareFragment a = m7673a(shareInfo);
        try {
            a.setShareCallBack(iPlatformShareCallback);
            a.setPlatformClickListener(platformClickListener);
            a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
            return a;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static ShareFragment m7673a(ShareInfo shareInfo) {
        return ShareFragment4Contracts.newInstance(shareInfo);
    }
}
