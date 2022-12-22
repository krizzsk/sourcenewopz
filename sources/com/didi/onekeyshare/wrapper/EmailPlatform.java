package com.didi.onekeyshare.wrapper;

import android.content.Context;
import android.content.Intent;
import com.didi.global.ninja.Ninja;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IPlatform.class})
public class EmailPlatform implements IPlatform {
    public void share(Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        if (!Ninja.getInstance(context).isHit("EMAIL_SHARE")) {
            Intent intent = new Intent("android.intent.action.SEND");
            if (oneKeyShareInfo.recipients == null || oneKeyShareInfo.recipients.size() <= 0) {
                intent.putExtra("android.intent.extra.EMAIL", new String[]{""});
            } else {
                int size = oneKeyShareInfo.recipients.size();
                String[] strArr = new String[size];
                for (int i = 0; i < size; i++) {
                    strArr[i] = oneKeyShareInfo.recipients.get(i);
                }
                intent.putExtra("android.intent.extra.EMAIL", strArr);
            }
            intent.putExtra("android.intent.extra.SUBJECT", oneKeyShareInfo.title);
            if (!(oneKeyShareInfo.content == null || oneKeyShareInfo.url == null || oneKeyShareInfo.content.endsWith(oneKeyShareInfo.url))) {
                intent.putExtra("android.intent.extra.TEXT", oneKeyShareInfo.content + " " + oneKeyShareInfo.url);
            }
            intent.setType("message/rfc822");
            context.startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        }
    }

    public boolean matchPlatform(String str) {
        return SharePlatform.EMAIL_PLATFORM.platformName().equals(str);
    }
}
