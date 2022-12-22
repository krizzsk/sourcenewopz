package com.didi.onekeyshare.wrapper;

import android.content.Context;
import android.text.TextUtils;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.SmsUtil;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IPlatform.class})
public class SmsPlatform implements IPlatform {
    public void share(Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        if (!TextUtil.isEmpty(oneKeyShareInfo.smsMessage)) {
            SmsUtil.sendSMS(context, m20940b(oneKeyShareInfo), oneKeyShareInfo.smsMessage);
            return;
        }
        SmsUtil.sendSMS(context, m20940b(oneKeyShareInfo), m20939a(oneKeyShareInfo).toString());
    }

    /* renamed from: a */
    private StringBuilder m20939a(OneKeyShareInfo oneKeyShareInfo) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(oneKeyShareInfo.title)) {
            sb.append(oneKeyShareInfo.title);
        }
        if (!TextUtils.isEmpty(oneKeyShareInfo.content)) {
            sb.append(oneKeyShareInfo.content);
        }
        if (!TextUtils.isEmpty(oneKeyShareInfo.url)) {
            sb.append(oneKeyShareInfo.url);
        }
        return sb;
    }

    /* renamed from: b */
    private String m20940b(OneKeyShareInfo oneKeyShareInfo) {
        String str = !TextUtils.isEmpty(oneKeyShareInfo.phone) ? oneKeyShareInfo.phone : "";
        return (oneKeyShareInfo.recipients == null || oneKeyShareInfo.recipients.size() <= 0) ? str : oneKeyShareInfo.recipients.get(0);
    }

    public boolean matchPlatform(String str) {
        return SharePlatform.SYSTEM_MESSAGE.platformName().equals(str);
    }
}
