package com.didi.onekeyshare.wrapper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.didi.global.ninja.Ninja;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.Contants;
import com.didi.onekeyshare.util.DownloadImageUtil;
import com.didi.onekeyshare.util.ShareConvertCompat;
import com.didi.onekeyshare.util.Utils;
import com.didi.onekeyshare.view.ProgressDialogUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.sharesdk.OneKeyShareModel;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.facebook.FacebookSdk;
import com.facebook.messenger.MessengerUtils;
import com.facebook.messenger.ShareToMessengerParams;
import com.facebook.share.model.ShareLinkContent;
import com.taxis99.R;
import java.io.File;

@ServiceProvider({IPlatform.class})
public class InternationalPlatform implements IPlatform {

    /* renamed from: a */
    Activity f29841a;

    /* renamed from: b */
    private String f29842b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ProgressDialogUtil f29843c;

    public void share(Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        if (!Ninja.getInstance(context).isHit("INTERNATIONAL_SHARE")) {
            if (this.f29843c == null) {
                this.f29843c = new ProgressDialogUtil();
            }
            final OneKeyShareModel convert = ShareConvertCompat.convert(oneKeyShareInfo);
            this.f29841a = (Activity) context;
            if (!TextUtils.isEmpty(oneKeyShareInfo.imageUrl)) {
                this.f29843c.showDialogLoading(this.f29841a);
                DownloadImageUtil.downloadImage(this.f29841a, oneKeyShareInfo.imageUrl, new DownloadImageUtil.DownLoadImageCallback() {
                    public void onSuccess(String str, String str2) {
                        InternationalPlatform.this.f29843c.dismissDialog();
                        convert.imgPath = str2;
                        InternationalPlatform internationalPlatform = InternationalPlatform.this;
                        internationalPlatform.m20929a(internationalPlatform.f29841a, convert);
                    }

                    public void onFail() {
                        InternationalPlatform.this.f29843c.dismissDialog();
                    }
                });
                return;
            }
            m20929a(this.f29841a, convert);
        }
    }

    public boolean matchPlatform(String str) {
        this.f29842b = str;
        return SharePlatform.LINE_PLATFORM.platformName().equals(str) || SharePlatform.MESSENGER_PLATFORM.platformName().equals(str) || SharePlatform.TWITTER_PLATFORM.platformName().equals(str) || SharePlatform.VK_PLATFORM.platformName().equals(str) || SharePlatform.WHATSAPP_PLATFORM.platformName().equals(str) || SharePlatform.TELEGRAM_PLATFORM.platformName().equals(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20929a(Activity activity, OneKeyShareModel oneKeyShareModel) {
        Uri uri;
        if (SharePlatform.TELEGRAM_PLATFORM.platformName().equals(this.f29842b)) {
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.title == null || oneKeyShareModel.content.startsWith(oneKeyShareModel.title))) {
                oneKeyShareModel.content = oneKeyShareModel.title + "," + oneKeyShareModel.content;
            }
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.url == null || oneKeyShareModel.content.endsWith(oneKeyShareModel.url))) {
                oneKeyShareModel.content += " " + oneKeyShareModel.url;
            }
            m20930a(activity, oneKeyShareModel.content, oneKeyShareModel.imgPath, TextUtils.isEmpty(oneKeyShareModel.imgPath) ? "text/plain" : Contants.SHARE_INTENT_SENDTYPE.INTENT_TYPE_IMAGE, Contants.SHARE_INTENT_PACKAGE_NAME.PACKAGE_TELEGRAM, activity.getString(R.string.GRider_CAR_The_Telegram_CmUW));
        } else if (SharePlatform.LINE_PLATFORM.platformName().equals(this.f29842b)) {
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.title == null || oneKeyShareModel.content.startsWith(oneKeyShareModel.title))) {
                oneKeyShareModel.content = oneKeyShareModel.title + "," + oneKeyShareModel.content;
            }
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.url == null || oneKeyShareModel.content.endsWith(oneKeyShareModel.url))) {
                oneKeyShareModel.content += " " + oneKeyShareModel.url;
            }
            m20930a(activity, oneKeyShareModel.content, "", "text/plain", Contants.SHARE_INTENT_PACKAGE_NAME.PACKAGE_NAME_LINE, activity.getString(R.string.tip_line_not_install));
        } else if (SharePlatform.VK_PLATFORM.platformName().equals(this.f29842b)) {
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.title == null || oneKeyShareModel.content.startsWith(oneKeyShareModel.title))) {
                oneKeyShareModel.content = oneKeyShareModel.title + "," + oneKeyShareModel.content;
            }
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.url == null || oneKeyShareModel.content.endsWith(oneKeyShareModel.url))) {
                oneKeyShareModel.content += " " + oneKeyShareModel.url;
            }
            m20930a(activity, oneKeyShareModel.content, oneKeyShareModel.imgPath, TextUtils.isEmpty(oneKeyShareModel.imgPath) ? "text/plain" : Contants.SHARE_INTENT_SENDTYPE.INTENT_TYPE_IMAGE, Contants.SHARE_INTENT_PACKAGE_NAME.PACKAGE_VK, activity.getString(R.string.tip_vk_not_install));
        } else if (SharePlatform.WHATSAPP_PLATFORM.platformName().equals(this.f29842b)) {
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.title == null || oneKeyShareModel.content.startsWith(oneKeyShareModel.title))) {
                oneKeyShareModel.content = oneKeyShareModel.title + "," + oneKeyShareModel.content;
            }
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.url == null || oneKeyShareModel.content.endsWith(oneKeyShareModel.url))) {
                oneKeyShareModel.content += " " + oneKeyShareModel.url;
            }
            m20930a(activity, oneKeyShareModel.content, oneKeyShareModel.imgPath, TextUtils.isEmpty(oneKeyShareModel.imgPath) ? "text/plain" : Contants.SHARE_INTENT_SENDTYPE.INTENT_TYPE_IMAGE, "com.whatsapp", activity.getString(R.string.tip_whatsapp_not_install));
        } else if (SharePlatform.MESSENGER_PLATFORM.platformName().equals(this.f29842b)) {
            if (!TextUtils.isEmpty(oneKeyShareModel.content)) {
                if (!(oneKeyShareModel.content == null || oneKeyShareModel.title == null || oneKeyShareModel.content.startsWith(oneKeyShareModel.title))) {
                    oneKeyShareModel.content = oneKeyShareModel.title + "," + oneKeyShareModel.content;
                }
                if (!(oneKeyShareModel.content == null || oneKeyShareModel.url == null || oneKeyShareModel.content.endsWith(oneKeyShareModel.url))) {
                    oneKeyShareModel.content += " " + oneKeyShareModel.url;
                }
                m20930a(activity, oneKeyShareModel.content, "", "text/plain", "com.facebook.orca", activity.getString(R.string.tip_messsenger_not_install));
                ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
                if (!TextUtils.isEmpty(oneKeyShareModel.url)) {
                    builder.setContentUrl(Uri.parse(oneKeyShareModel.url));
                }
            } else if (!TextUtils.isEmpty(oneKeyShareModel.imgPath)) {
                if (!FacebookSdk.isInitialized()) {
                    FacebookSdk.sdkInitialize(activity.getApplicationContext());
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".share.provider", new File(oneKeyShareModel.imgPath));
                } else {
                    uri = Uri.fromFile(new File(oneKeyShareModel.imgPath));
                }
                try {
                    MessengerUtils.shareToMessenger(activity, 1001, ShareToMessengerParams.newBuilder(uri, PicUploadActivity.IMAGE_UNSPECIFIED).build());
                } catch (Exception unused) {
                }
            }
        } else if (SharePlatform.TWITTER_PLATFORM.platformName().equals(this.f29842b)) {
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.title == null || oneKeyShareModel.content.startsWith(oneKeyShareModel.title))) {
                oneKeyShareModel.content = oneKeyShareModel.title + "," + oneKeyShareModel.content;
            }
            if (!(oneKeyShareModel.content == null || oneKeyShareModel.url == null || oneKeyShareModel.content.endsWith(oneKeyShareModel.url))) {
                oneKeyShareModel.content += " " + oneKeyShareModel.url;
            }
            m20930a(activity, oneKeyShareModel.content, oneKeyShareModel.imgPath, Contants.SHARE_INTENT_SENDTYPE.INTENT_TYPE_IMAGE, Contants.SHARE_INTENT_PACKAGE_NAME.PACKAGE_NAME_TWITTER, activity.getString(R.string.tip_twitter_not_install));
        }
    }

    /* renamed from: a */
    private void m20930a(Activity activity, String str, String str2, String str3, String str4, String str5) {
        Uri uri;
        if (Utils.isAppInstalled(activity, str4)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType(str3);
            if (!TextUtils.isEmpty(str2)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".share.provider", new File(str2));
                } else {
                    uri = Uri.fromFile(new File(str2));
                }
                intent.putExtra("android.intent.extra.STREAM", uri);
            }
            intent.setPackage(str4);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivityForResult(intent, 1001);
            } else {
                ToastHelper.showLongError((Context) activity, str5);
            }
        } else {
            ToastHelper.showLongError((Context) activity, str5);
        }
    }
}
