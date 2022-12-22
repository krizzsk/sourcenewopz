package com.didi.payment.commonsdk.utils;

import androidx.fragment.app.FragmentActivity;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import com.didi.onekeyshare.view.fragment.ShareFragment;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class NCommonShareManager {

    /* renamed from: a */
    private ShareFragment f30197a;

    /* renamed from: b */
    private ArrayList<SharePlatform> f30198b;

    public interface CommonShareCallback extends ICallback.IPlatformShareCallback {
    }

    public static void showOrderDetailShareWindow(FragmentActivity fragmentActivity, String str, String str2, CommonShareCallback commonShareCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
        arrayList.add(SharePlatform.MESSENGER_PLATFORM);
        arrayList.add(SharePlatform.TWITTER_PLATFORM);
        arrayList.add(SharePlatform.EMAIL_PLATFORM);
        arrayList.add(SharePlatform.SAVEIMAGE_PLATFORM);
        new NCommonShareManager(arrayList).showShareWindow(fragmentActivity, str, str2, commonShareCallback);
    }

    public static void showCommonShareWindow(FragmentActivity fragmentActivity, String str, String str2, String str3, CommonShareCallback commonShareCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
        arrayList.add(SharePlatform.TWITTER_PLATFORM);
        arrayList.add(SharePlatform.EMAIL_PLATFORM);
        arrayList.add(SharePlatform.MESSENGER_PLATFORM);
        arrayList.add(SharePlatform.FACEBOOK_PLATFORM);
        arrayList.add(SharePlatform.SAVEIMAGE_PLATFORM);
        new NCommonShareManager(arrayList).showShareWindowWithoutUrl(fragmentActivity, str, str2, str3, commonShareCallback);
    }

    public NCommonShareManager() {
        this.f30198b = m21135a();
    }

    public NCommonShareManager(ArrayList<SharePlatform> arrayList) {
        this.f30198b = arrayList;
    }

    /* renamed from: a */
    private ArrayList<SharePlatform> m21135a() {
        ArrayList<SharePlatform> arrayList = new ArrayList<>();
        arrayList.add(SharePlatform.EMAIL_PLATFORM);
        arrayList.add(SharePlatform.SYSTEM_MESSAGE);
        arrayList.add(SharePlatform.TWITTER_PLATFORM);
        arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
        return arrayList;
    }

    /* renamed from: a */
    private ShareInfo m21134a(CommonTripShareInfo commonTripShareInfo) {
        String str;
        ArrayList<SharePlatform> arrayList = this.f30198b;
        if (CollectionUtil.isEmpty((Collection<?>) arrayList)) {
            arrayList = m21137b();
        }
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.title = commonTripShareInfo.shareTitle;
        shareInfo.content = commonTripShareInfo.shareContent;
        shareInfo.url = commonTripShareInfo.shareUrl;
        shareInfo.imageUrl = commonTripShareInfo.sharePicture;
        shareInfo.platforms = arrayList;
        shareInfo.imagePath = commonTripShareInfo.imagePath;
        String str2 = "";
        if (!TextUtil.isEmpty(commonTripShareInfo.shareTitle)) {
            str = commonTripShareInfo.shareTitle + ",";
        } else {
            str = str2;
        }
        if (!TextUtil.isEmpty(commonTripShareInfo.shareUrl)) {
            str2 = commonTripShareInfo.shareUrl;
        }
        shareInfo.smsMessage = str + commonTripShareInfo.shareContent + " " + str2;
        return shareInfo;
    }

    public void showSimpleStrShareWindow(FragmentActivity fragmentActivity, String str) {
        CommonTripShareInfo commonTripShareInfo = new CommonTripShareInfo();
        commonTripShareInfo.shareContent = str;
        m21138b(fragmentActivity, m21134a(commonTripShareInfo), (CommonShareCallback) null);
    }

    public void showShareWindow(FragmentActivity fragmentActivity, String str, String str2, CommonShareCallback commonShareCallback) {
        CommonTripShareInfo commonTripShareInfo = new CommonTripShareInfo();
        commonTripShareInfo.shareContent = str;
        commonTripShareInfo.imagePath = str2;
        m21138b(fragmentActivity, m21134a(commonTripShareInfo), commonShareCallback);
    }

    public void showShareWindowWithoutUrl(FragmentActivity fragmentActivity, String str, String str2, String str3, CommonShareCallback commonShareCallback) {
        CommonTripShareInfo commonTripShareInfo = new CommonTripShareInfo();
        commonTripShareInfo.shareContent = str;
        commonTripShareInfo.imagePath = str3;
        commonTripShareInfo.shareUrl = str2;
        m21136a(fragmentActivity, m21134a(commonTripShareInfo), commonShareCallback);
    }

    /* renamed from: b */
    private ArrayList<SharePlatform> m21137b() {
        ArrayList<SharePlatform> arrayList = new ArrayList<>();
        arrayList.add(SharePlatform.WHATSAPP_PLATFORM);
        arrayList.add(SharePlatform.SYSTEM_MESSAGE);
        return arrayList;
    }

    /* renamed from: a */
    private void m21136a(FragmentActivity fragmentActivity, ShareInfo shareInfo, final CommonShareCallback commonShareCallback) {
        PayTracker.trackEvent("ibt_didipay_sharing_channel_sw");
        this.f30197a = ShareBuilder.buildShare(fragmentActivity, shareInfo, (ICallback.IPlatformShareCallback) new ICallback.IPlatformShareCallback() {
            public void onComplete(SharePlatform sharePlatform) {
                if (sharePlatform != null) {
                    if (sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
                        PayTracker.trackEvent("ibt_didipay_sharing_save_success_sw");
                    }
                    CommonShareCallback commonShareCallback = commonShareCallback;
                    if (commonShareCallback != null) {
                        commonShareCallback.onComplete(sharePlatform);
                    }
                }
            }

            public void onError(SharePlatform sharePlatform) {
                if (sharePlatform != null) {
                    if (sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
                        PayTracker.trackEvent("ibt_didipay_sharing_save_failed_sw");
                    }
                    CommonShareCallback commonShareCallback = commonShareCallback;
                    if (commonShareCallback != null) {
                        commonShareCallback.onError(sharePlatform);
                    }
                }
            }

            public void onCancel(SharePlatform sharePlatform) {
                CommonShareCallback commonShareCallback = commonShareCallback;
                if (commonShareCallback != null) {
                    commonShareCallback.onCancel(sharePlatform);
                }
            }
        }, (ICallback.IPlatformClickCallback) new ICallback.IPlatformClickCallback() {
            public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                if (oneKeyShareInfo != null && oneKeyShareInfo.platform == null) {
                    HashMap hashMap = new HashMap();
                    if (oneKeyShareInfo.platform == SharePlatform.WHATSAPP_PLATFORM) {
                        hashMap.put("sharing_channel", 1);
                    } else if (oneKeyShareInfo.platform == SharePlatform.SYSTEM_MESSAGE) {
                        hashMap.put("sharing_channel", 2);
                    } else if (oneKeyShareInfo.platform == SharePlatform.EMAIL_PLATFORM) {
                        hashMap.put("sharing_channel", 3);
                    } else if (oneKeyShareInfo.platform == SharePlatform.TWITTER_PLATFORM) {
                        hashMap.put("sharing_channel", 4);
                    } else if (oneKeyShareInfo.platform == SharePlatform.SAVEIMAGE_PLATFORM) {
                        hashMap.put("sharing_channel", 5);
                    }
                    PayTracker.trackEvent("ibt_didipay_sharing_channel_ck", hashMap);
                    if (oneKeyShareInfo.platform != SharePlatform.EMAIL_PLATFORM) {
                        oneKeyShareInfo.url = null;
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private void m21138b(FragmentActivity fragmentActivity, ShareInfo shareInfo, final CommonShareCallback commonShareCallback) {
        PayTracker.trackEvent("ibt_didipay_sharing_channel_sw");
        this.f30197a = ShareBuilder.buildShare(fragmentActivity, shareInfo, (ICallback.IPlatformShareCallback) new ICallback.IPlatformShareCallback() {
            public void onComplete(SharePlatform sharePlatform) {
                if (sharePlatform != null) {
                    if (sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
                        PayTracker.trackEvent("ibt_didipay_sharing_save_success_sw");
                    }
                    CommonShareCallback commonShareCallback = commonShareCallback;
                    if (commonShareCallback != null) {
                        commonShareCallback.onComplete(sharePlatform);
                    }
                }
            }

            public void onError(SharePlatform sharePlatform) {
                if (sharePlatform != null) {
                    if (sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
                        PayTracker.trackEvent("ibt_didipay_sharing_save_failed_sw");
                    }
                    CommonShareCallback commonShareCallback = commonShareCallback;
                    if (commonShareCallback != null) {
                        commonShareCallback.onError(sharePlatform);
                    }
                }
            }

            public void onCancel(SharePlatform sharePlatform) {
                CommonShareCallback commonShareCallback = commonShareCallback;
                if (commonShareCallback != null) {
                    commonShareCallback.onCancel(sharePlatform);
                }
            }
        }, (PlatformClickListener) new PlatformClickListener() {
            public void onClick(SharePlatform sharePlatform) {
                if (sharePlatform != null) {
                    HashMap hashMap = new HashMap();
                    if (sharePlatform == SharePlatform.WHATSAPP_PLATFORM) {
                        hashMap.put("sharing_channel", 1);
                    } else if (sharePlatform == SharePlatform.SYSTEM_MESSAGE) {
                        hashMap.put("sharing_channel", 2);
                    } else if (sharePlatform == SharePlatform.EMAIL_PLATFORM) {
                        hashMap.put("sharing_channel", 3);
                    } else if (sharePlatform == SharePlatform.TWITTER_PLATFORM) {
                        hashMap.put("sharing_channel", 4);
                    } else if (sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
                        hashMap.put("sharing_channel", 5);
                    }
                    PayTracker.trackEvent("ibt_didipay_sharing_channel_ck", hashMap);
                }
            }
        });
    }

    public void disMissOneKeyShareDialog() {
        ShareFragment shareFragment = this.f30197a;
        if (shareFragment != null && !shareFragment.isHidden()) {
            try {
                this.f30197a.dismissAllowingStateLoss();
            } catch (Throwable unused) {
            }
            this.f30197a = null;
        }
    }

    public static class CommonTripShareInfo {
        public String imagePath;
        public String shareContent;
        public String sharePicture;
        public String shareTitle;
        public String shareUrl;

        public String toString() {
            return "CommonTripShareInfo{shareTitle='" + this.shareTitle + '\'' + ", shareContent='" + this.shareContent + '\'' + ", shareUrl='" + this.shareUrl + '\'' + ", sharePicture='" + this.sharePicture + '\'' + '}';
        }
    }
}
