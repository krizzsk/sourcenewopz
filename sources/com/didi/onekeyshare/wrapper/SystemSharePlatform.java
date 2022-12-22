package com.didi.onekeyshare.wrapper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.Contants;
import com.didi.onekeyshare.util.DownloadImageUtil;
import com.didi.onekeyshare.util.ShareConvertCompat;
import com.didi.onekeyshare.view.ProgressDialogUtil;
import com.didi.sharesdk.OneKeyShareModel;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.File;

@ServiceProvider({IPlatform.class})
public class SystemSharePlatform implements IPlatform {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ProgressDialogUtil f29850a;

    public void share(final Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        if (this.f29850a == null) {
            this.f29850a = new ProgressDialogUtil();
        }
        final OneKeyShareModel convert = ShareConvertCompat.convert(oneKeyShareInfo);
        if (!TextUtils.isEmpty(oneKeyShareInfo.imageUrl)) {
            this.f29850a.showDialogLoading(context);
            DownloadImageUtil.downloadImage(context, oneKeyShareInfo.imageUrl, new DownloadImageUtil.DownLoadImageCallback() {
                public void onSuccess(String str, String str2) {
                    SystemSharePlatform.this.f29850a.dismissDialog();
                    convert.imgPath = str2;
                    SystemSharePlatform.this.m20942a(context, convert);
                }

                public void onFail() {
                    SystemSharePlatform.this.f29850a.dismissDialog();
                }
            });
            return;
        }
        m20942a(context, convert);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20942a(Context context, OneKeyShareModel oneKeyShareModel) {
        if (!(oneKeyShareModel.content == null || oneKeyShareModel.title == null || oneKeyShareModel.content.startsWith(oneKeyShareModel.title))) {
            oneKeyShareModel.content = oneKeyShareModel.title + "," + oneKeyShareModel.content;
        }
        if (!(oneKeyShareModel.content == null || oneKeyShareModel.url == null || oneKeyShareModel.content.endsWith(oneKeyShareModel.url))) {
            oneKeyShareModel.content += " " + oneKeyShareModel.url;
        }
        m20943a(context, oneKeyShareModel.content, oneKeyShareModel.imgPath, TextUtils.isEmpty(oneKeyShareModel.imgPath) ? "text/plain" : Contants.SHARE_INTENT_SENDTYPE.INTENT_TYPE_IMAGE);
    }

    public boolean matchPlatform(String str) {
        return SharePlatform.SYSTEM_PLATFORM.platformName().equals(str);
    }

    /* renamed from: a */
    private void m20943a(Context context, String str, String str2, String str3) {
        Uri uri;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType(str3);
        if (!TextUtils.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.getUriForFile(context, context.getPackageName() + ".share.provider", new File(str2));
            } else {
                uri = Uri.fromFile(new File(str2));
            }
            intent.putExtra("android.intent.extra.STREAM", uri);
        }
        intent.addFlags(1);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
