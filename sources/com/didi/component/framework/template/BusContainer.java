package com.didi.component.framework.template;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.never.base.PageFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.business.ISABusiness;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.eevee_framework.node.page.FirstFragment;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "bus", value = {ISABusiness.class})
@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/framework/template/BusContainer;", "Lcom/didi/sdk/app/business/ISABusiness;", "()V", "transitionFragment", "Landroidx/fragment/app/Fragment;", "url", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusContainer.kt */
public final class BusContainer implements ISABusiness {
    public Fragment transitionFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        URI uri = new URI(str);
        SystemUtils.log(6, "busContainer", uri.getQuery() + "host" + uri.getHost() + "path" + uri.getPath(), (Throwable) null, "com.didi.component.framework.template.BusContainer", 16);
        if (!Intrinsics.areEqual((Object) uri.getPath(), (Object) "/entrance")) {
            return null;
        }
        PageFragment newInstance = FirstFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_sa", true);
        newInstance.setArguments(bundle);
        return newInstance;
    }
}
