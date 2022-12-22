package com.didi.beatles.p099im.api.entity;

import android.os.Build;
import android.text.TextUtils;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.IMGD;
import com.didi.beatles.p099im.api.url.IMApiUrl;
import com.didi.beatles.p099im.utils.IMLog;
import java.io.Serializable;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.api.entity.IMBaseRequest */
public class IMBaseRequest implements Serializable {
    public String app;
    public int app_chan_id;
    public String appversion;
    public String dataversion;
    public String device_id;
    public String lag;
    public int op_type;

    /* renamed from: os */
    public String f9124os;
    public int product;
    public String token;
    public long uid;

    public IMBaseRequest(int i) {
        this(i, 0);
    }

    public IMBaseRequest(int i, int i2) {
        Locale locale;
        this.op_type = i;
        this.product = i2;
        this.token = IMApiUrl.getCurrentUrlType() == 0 ? IMCommonContextInfoHelper.getToken() : "beatlion_token";
        this.uid = IMCommonContextInfoHelper.getUid();
        String appVersion = IMCommonContextInfoHelper.getAppVersion();
        this.appversion = appVersion;
        if (TextUtils.isEmpty(appVersion)) {
            IMLog.m6632e("IMBaseRequest", "-----Null App Version-----");
        }
        this.dataversion = IMGD.IM_DATA_VERSION;
        this.device_id = IMCommonContextInfoHelper.getDeviceId();
        this.f9124os = "android";
        if (IMCommonContextInfoHelper.getContext() != null) {
            this.app = IMCommonContextInfoHelper.getContext().getPackageName();
            if (Build.VERSION.SDK_INT < 24) {
                locale = IMCommonContextInfoHelper.getContext().getResources().getConfiguration().locale;
            } else {
                locale = IMCommonContextInfoHelper.getContext().getResources().getConfiguration().getLocales().get(0);
            }
            if (locale != null) {
                this.lag = locale.getLanguage() + "-" + locale.getCountry();
            }
            this.app_chan_id = IMCommonContextInfoHelper.getAppChannel();
        }
    }
}
