package com.didi.component.common;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.font.iface.IFontConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider({IFontConfig.class})
@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\r\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\rJ\r\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/component/common/GlobalFontConfig;", "Lcom/didiglobal/font/iface/IFontConfig;", "()V", "getContext", "Landroid/content/Context;", "getCssConfig", "", "getWeightRule", "isFlutterSupport", "", "()Ljava/lang/Boolean;", "isH5Support", "url", "(Ljava/lang/String;)Ljava/lang/Boolean;", "isSupport", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalFontConfig.kt */
public final class GlobalFontConfig implements IFontConfig {
    public Boolean isSupport() {
        boolean isFontSupport = GlobalApolloUtil.isFontSupport();
        GLog.m7965d("fontconfig", Intrinsics.stringPlus("is support fontSupport=", Boolean.valueOf(isFontSupport)));
        if (!isFontSupport) {
            return false;
        }
        String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
        GLog.m7965d("fontconfig", Intrinsics.stringPlus("currentLanguage  ", localeCode));
        if (TextUtils.isEmpty(localeCode)) {
            return false;
        }
        return Boolean.valueOf(GlobalApolloUtil.isFontSupport(localeCode));
    }

    public String getCssConfig() {
        String fontH5CssConfig = GlobalApolloUtil.getFontH5CssConfig();
        GLog.m7965d("fontconfig", Intrinsics.stringPlus("is isH5Support css ", fontH5CssConfig));
        Intrinsics.checkNotNullExpressionValue(fontH5CssConfig, "cssConfig");
        return fontH5CssConfig;
    }

    public Boolean isH5Support(String str) {
        boolean fontH5BlackListConfig = GlobalApolloUtil.getFontH5BlackListConfig(str);
        GLog.m7965d("fontconfig", Intrinsics.stringPlus("is isH5Support blacklist ", Boolean.valueOf(fontH5BlackListConfig)));
        return Boolean.valueOf(fontH5BlackListConfig);
    }

    public Boolean isH5Support() {
        boolean isFontH5Support = GlobalApolloUtil.isFontH5Support();
        GLog.m7965d("fontconfig", "is isH5Support " + isFontH5Support + "  config ");
        return Boolean.valueOf(isFontH5Support);
    }

    public Boolean isFlutterSupport() {
        boolean isFontFlutterSupport = GlobalApolloUtil.isFontFlutterSupport();
        GLog.m7965d("fontconfig", Intrinsics.stringPlus("is isFlutterSupport ", Boolean.valueOf(isFontFlutterSupport)));
        return Boolean.valueOf(isFontFlutterSupport);
    }

    public Context getContext() {
        Application appContext = DIDIApplication.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
        return appContext;
    }

    public String getWeightRule() {
        String fontWeight = GlobalApolloUtil.getFontWeight();
        GLog.m7965d("fontconfig", Intrinsics.stringPlus(" getWeightRule ", fontWeight));
        Intrinsics.checkNotNullExpressionValue(fontWeight, "rlue");
        return fontWeight;
    }
}
