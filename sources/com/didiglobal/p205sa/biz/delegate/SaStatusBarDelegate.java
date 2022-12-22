package com.didiglobal.p205sa.biz.delegate;

import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.business.ISaStatusBarDelegate;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;

@ServiceProvider({ISaStatusBarDelegate.class})
@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/delegate/SaStatusBarDelegate;", "Lcom/didi/sdk/app/business/ISaStatusBarDelegate;", "()V", "getStatusBarHeight", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.delegate.SaStatusBarDelegate */
/* compiled from: SaStatusBarDelegate.kt */
public final class SaStatusBarDelegate implements ISaStatusBarDelegate {
    public int getStatusBarHeight() {
        return AppUtils.getStatusBarHeight(DIDIApplication.getAppContext());
    }
}
