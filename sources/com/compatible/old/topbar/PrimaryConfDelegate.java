package com.compatible.old.topbar;

import com.didi.sdk.misconfig.p153v2.IPrimaryConf;
import com.didi.sdk.misconfig.p153v2.IPrimaryConfDelegate;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;

@ServiceProvider({IPrimaryConfDelegate.class})
@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo175978d2 = {"Lcom/compatible/old/topbar/PrimaryConfDelegate;", "Lcom/didi/sdk/misconfig/v2/IPrimaryConfDelegate;", "()V", "getPrimaryDelegate", "Lcom/didi/sdk/misconfig/v2/IPrimaryConf;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrimaryConfDelegate.kt */
public final class PrimaryConfDelegate implements IPrimaryConfDelegate {
    public IPrimaryConf getPrimaryDelegate() {
        return new SaIndexPriConf();
    }
}
