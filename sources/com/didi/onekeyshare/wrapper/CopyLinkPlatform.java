package com.didi.onekeyshare.wrapper;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.didi.global.ninja.Ninja;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;

@ServiceProvider({IPlatform.class})
public class CopyLinkPlatform implements IPlatform {
    public void share(Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        if (!Ninja.getInstance(context).isHit("COPYLINK_SHARE") && oneKeyShareInfo != null && oneKeyShareInfo.smsMessage != null) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            ClipData newPlainText = ClipData.newPlainText("Label", oneKeyShareInfo.smsMessage);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
                ToastHelper.showLongCompleted(context, (int) R.string.global_copy_lint_successful_toast);
            }
        }
    }

    public boolean matchPlatform(String str) {
        return SharePlatform.COPY_LINK_PLATFORM.platformName().equals(str);
    }
}
