package com.didiglobal.pay.paysecure;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H&J\b\u0010\r\u001a\u00020\u0003H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/PaySecureNetParamListener;", "", "getCityId", "", "getCountry", "getExtraInfo", "", "getLanguage", "getLat", "", "getLng", "getLocale", "getOmegaParams", "getProductId", "getToken", "getUtcOffset", "", "appContext", "Landroid/content/Context;", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Listener.kt */
public interface PaySecureNetParamListener {
    String getCityId();

    String getCountry();

    Map<String, Object> getExtraInfo();

    String getLanguage();

    double getLat();

    double getLng();

    String getLocale();

    Map<String, Object> getOmegaParams();

    String getProductId();

    String getToken();

    int getUtcOffset(Context context);
}
