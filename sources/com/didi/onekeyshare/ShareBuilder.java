package com.didi.onekeyshare;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.onekeyshare.ShareConfig;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.callback.intercept.ShareDialogInterceptUtil;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.ShareInstrInfo;
import com.didi.onekeyshare.view.fragment.GlobalShareFragment;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import com.didi.onekeyshare.view.fragment.ShareFragment;
import com.didi.onekeyshare.wrapper.ShareWrapper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.ArrayList;

public final class ShareBuilder {

    /* renamed from: a */
    private static boolean f29754a = false;

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ShareInfo shareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        return buildShare(fragmentActivity, shareInfo, iPlatformShareCallback, (ICallback.IPlatformClickCallback) null);
    }

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ShareInfo shareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        if (fragmentActivity == null || fragmentActivity.isFinishing() || shareInfo == null || ShareDialogInterceptUtil.intercept(fragmentActivity, shareInfo)) {
            return null;
        }
        ShareFragment a = m20881a(shareInfo);
        try {
            a.setShareCallBack(iPlatformShareCallback);
            a.setSharePlatformClickCallBack(iPlatformClickCallback);
            a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
            return a;
        } catch (Exception unused) {
            SystemUtils.log(3, "ShareBuilder", "try catch fragment commit loss", (Throwable) null, "com.didi.onekeyshare.ShareBuilder", 57);
            return null;
        }
    }

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ShareInfo shareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback, final PlatformClickListener platformClickListener) {
        return buildShare(fragmentActivity, shareInfo, iPlatformShareCallback, (ICallback.IPlatformClickCallback) new ICallback.IPlatformClickCallback() {
            public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                if (platformClickListener != null && oneKeyShareInfo != null && oneKeyShareInfo.platform != null) {
                    platformClickListener.onClick(oneKeyShareInfo.platform);
                }
            }
        });
    }

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ShareInfo shareInfo, ShareInstrInfo shareInstrInfo, ICallback.IPlatformShareCallback iPlatformShareCallback, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        if (fragmentActivity == null || fragmentActivity.isFinishing() || shareInfo == null || ShareDialogInterceptUtil.intercept(fragmentActivity, shareInfo)) {
            return null;
        }
        ShareFragment a = m20882a(shareInfo, shareInstrInfo);
        try {
            a.setShareCallBack(iPlatformShareCallback);
            a.setSharePlatformClickCallBack(iPlatformClickCallback);
            a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
            return a;
        } catch (Exception unused) {
            SystemUtils.log(3, "ShareBuilder", "try catch fragment commit loss", (Throwable) null, "com.didi.onekeyshare.ShareBuilder", 102);
            return null;
        }
    }

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ShareInfo shareInfo, ShareInstrInfo shareInstrInfo, ICallback.IPlatformShareCallback iPlatformShareCallback, final PlatformClickListener platformClickListener) {
        return buildShare(fragmentActivity, shareInfo, shareInstrInfo, iPlatformShareCallback, (ICallback.IPlatformClickCallback) new ICallback.IPlatformClickCallback() {
            public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                if (platformClickListener != null && oneKeyShareInfo != null && oneKeyShareInfo.platform != null) {
                    platformClickListener.onClick(oneKeyShareInfo.platform);
                }
            }
        });
    }

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ArrayList<OneKeyShareInfo> arrayList, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        return buildShare(fragmentActivity, arrayList, iPlatformShareCallback, (ICallback.IPlatformClickCallback) null);
    }

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ArrayList<OneKeyShareInfo> arrayList, ICallback.IPlatformShareCallback iPlatformShareCallback, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        if (fragmentActivity == null || fragmentActivity.isFinishing() || arrayList == null || ShareDialogInterceptUtil.intercept(fragmentActivity, arrayList)) {
            return null;
        }
        ShareFragment a = m20883a(arrayList);
        try {
            a.setShareCallBack(iPlatformShareCallback);
            a.setSharePlatformClickCallBack(iPlatformClickCallback);
            a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
            return a;
        } catch (Exception unused) {
            SystemUtils.log(3, "ShareBuilder", "try catch fragment commit loss", (Throwable) null, "com.didi.onekeyshare.ShareBuilder", 151);
            return null;
        }
    }

    public static ShareFragment buildShare(FragmentActivity fragmentActivity, ArrayList<OneKeyShareInfo> arrayList, ICallback.IPlatformShareCallback iPlatformShareCallback, final PlatformClickListener platformClickListener) {
        return buildShare(fragmentActivity, arrayList, iPlatformShareCallback, (ICallback.IPlatformClickCallback) new ICallback.IPlatformClickCallback() {
            public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                if (platformClickListener != null && oneKeyShareInfo != null && oneKeyShareInfo.platform != null) {
                    platformClickListener.onClick(oneKeyShareInfo.platform);
                }
            }
        });
    }

    public static ShareFragment buildH5Share(FragmentActivity fragmentActivity, ShareInfo shareInfo, ICallback.IH5ShareCallback iH5ShareCallback) {
        return buildH5Share(fragmentActivity, shareInfo, iH5ShareCallback, (ICallback.IPlatformClickCallback) null);
    }

    public static ShareFragment buildH5Share(FragmentActivity fragmentActivity, ShareInfo shareInfo, ICallback.IH5ShareCallback iH5ShareCallback, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        if (fragmentActivity == null || fragmentActivity.isFinishing() || shareInfo == null || ShareDialogInterceptUtil.intercept(fragmentActivity, shareInfo)) {
            return null;
        }
        ShareFragment a = m20881a(shareInfo);
        try {
            a.setShareCallBack(iH5ShareCallback);
            a.setSharePlatformClickCallBack(iPlatformClickCallback);
            a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
            return a;
        } catch (Exception unused) {
            SystemUtils.log(3, "ShareBuilder", "try catch fragment commit loss", (Throwable) null, "com.didi.onekeyshare.ShareBuilder", 194);
            return null;
        }
    }

    public static ShareFragment buildH5Share(FragmentActivity fragmentActivity, ShareInfo shareInfo, ICallback.IH5ShareCallback iH5ShareCallback, final PlatformClickListener platformClickListener) {
        return buildH5Share(fragmentActivity, shareInfo, iH5ShareCallback, (ICallback.IPlatformClickCallback) new ICallback.IPlatformClickCallback() {
            public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                if (platformClickListener != null && oneKeyShareInfo != null && oneKeyShareInfo.platform != null) {
                    platformClickListener.onClick(oneKeyShareInfo.platform);
                }
            }
        });
    }

    public static ShareFragment buildH5Share(FragmentActivity fragmentActivity, ArrayList<OneKeyShareInfo> arrayList, ICallback.IH5ShareCallback iH5ShareCallback) {
        return buildH5Share(fragmentActivity, arrayList, iH5ShareCallback, (ICallback.IPlatformClickCallback) null);
    }

    public static ShareFragment buildH5Share(FragmentActivity fragmentActivity, ArrayList<OneKeyShareInfo> arrayList, ICallback.IH5ShareCallback iH5ShareCallback, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        if (fragmentActivity == null || fragmentActivity.isFinishing() || arrayList == null || ShareDialogInterceptUtil.intercept(fragmentActivity, arrayList)) {
            return null;
        }
        ShareFragment a = m20883a(arrayList);
        try {
            a.setShareCallBack(iH5ShareCallback);
            a.setSharePlatformClickCallBack(iPlatformClickCallback);
            a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
            return a;
        } catch (Exception unused) {
            SystemUtils.log(3, "ShareBuilder", "try catch fragment commit loss", (Throwable) null, "com.didi.onekeyshare.ShareBuilder", 251);
            return null;
        }
    }

    public static ShareFragment buildH5Share(FragmentActivity fragmentActivity, ArrayList<OneKeyShareInfo> arrayList, ICallback.IH5ShareCallback iH5ShareCallback, final PlatformClickListener platformClickListener) {
        return buildH5Share(fragmentActivity, arrayList, iH5ShareCallback, (ICallback.IPlatformClickCallback) new ICallback.IPlatformClickCallback() {
            public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                if (platformClickListener != null && oneKeyShareInfo != null && oneKeyShareInfo.platform != null) {
                    platformClickListener.onClick(oneKeyShareInfo.platform);
                }
            }
        });
    }

    /* renamed from: a */
    private static ShareFragment m20883a(ArrayList<OneKeyShareInfo> arrayList) {
        ShareConfig config = ShareConfig.getConfig();
        if (config.getShareFragmentFactory() != null) {
            return config.getShareFragmentFactory().createShareFragment(arrayList);
        }
        if (C104016.$SwitchMap$com$didi$onekeyshare$ShareConfig$Nation[config.getNation().ordinal()] != 1) {
            return ShareFragment.newInstance(arrayList);
        }
        return GlobalShareFragment.newInstance(arrayList);
    }

    /* renamed from: com.didi.onekeyshare.ShareBuilder$6 */
    static /* synthetic */ class C104016 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$onekeyshare$ShareConfig$Nation;

        static {
            int[] iArr = new int[ShareConfig.Nation.values().length];
            $SwitchMap$com$didi$onekeyshare$ShareConfig$Nation = iArr;
            try {
                iArr[ShareConfig.Nation.GLOBAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: a */
    private static ShareFragment m20881a(ShareInfo shareInfo) {
        return m20882a(shareInfo, (ShareInstrInfo) null);
    }

    /* renamed from: a */
    private static ShareFragment m20882a(ShareInfo shareInfo, ShareInstrInfo shareInstrInfo) {
        ShareConfig config = ShareConfig.getConfig();
        if (config.getShareFragmentFactory() != null) {
            return config.getShareFragmentFactory().createShareFragment(shareInfo);
        }
        if (C104016.$SwitchMap$com$didi$onekeyshare$ShareConfig$Nation[config.getNation().ordinal()] == 1) {
            return GlobalShareFragment.newInstance(shareInfo);
        }
        if (shareInstrInfo == null) {
            return ShareFragment.newInstance(shareInfo);
        }
        return ShareFragment.newInstance(shareInfo, shareInstrInfo);
    }

    public static void shareToPlatform(Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        ShareWrapper.shareToPlatform(context, oneKeyShareInfo, iPlatformShareCallback);
    }

    /* renamed from: a */
    private static void m20884a(Activity activity) {
        if (!f29754a) {
            f29754a = true;
            OmegaSDK.init(activity.getApplicationContext());
        }
    }
}
