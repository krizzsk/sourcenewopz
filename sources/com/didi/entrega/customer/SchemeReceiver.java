package com.didi.entrega.customer;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.entrega.customer.app.CustomerActivityManager;
import com.didi.entrega.customer.biz.scheme.SchemeHelper;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.repo.CustomerFragmentInitRepo;
import java.util.Set;

public class SchemeReceiver implements IRouterHandler {

    /* renamed from: a */
    private static final String f19765a = "SchemeReceiver";

    /* renamed from: b */
    private boolean f19766b;

    public void handle(Request request, Result result) {
        Bundle extra = request.getExtra();
        Set<String> keySet = extra.keySet();
        final Uri.Builder buildUpon = request.getUri().buildUpon();
        if (keySet != null && keySet.size() > 0) {
            for (String str : keySet) {
                buildUpon = buildUpon.appendQueryParameter(str, String.valueOf(extra.get(str)));
            }
        }
        CustomerFragmentInitRepo.getInstance().subscribe(new Action1<Boolean>() {
            public void call(Boolean bool) {
                if (bool.booleanValue()) {
                    SchemeReceiver.this.m14652a(buildUpon.build());
                    CustomerFragmentInitRepo.getInstance().remove(this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14652a(Uri uri) {
        String queryParameter = uri.getQueryParameter("closeSideMenu");
        if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter)) {
            CustomerActivityManager.getInstance().popToRoot();
        }
        LogUtil.m14765i(f19765a, "dispatchBundle = " + this.f19766b);
        if (this.f19766b) {
            SchemeHelper.dispatchMsg(uri, false);
            return;
        }
        this.f19766b = true;
        if (LocationUtil.hasValidLocation()) {
            SchemeHelper.dispatchMsg(uri, false);
        } else {
            LogUtil.m14765i(f19765a, "dispatchBundle subscribeAddress");
        }
    }
}
