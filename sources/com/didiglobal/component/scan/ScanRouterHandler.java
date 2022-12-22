package com.didiglobal.component.scan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.app.router.sidebar.BaseSideBarDRouterHandler;
import com.didi.component.common.bff.BFFStore;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didiglobal.scan.GlobalScan;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/component/scan/ScanRouterHandler;", "Lcom/didi/app/router/sidebar/BaseSideBarDRouterHandler;", "()V", "callRealHandle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "comp-scan_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ScanRouterHandler.kt */
public final class ScanRouterHandler extends BaseSideBarDRouterHandler {
    public void callRealHandle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        super.callRealHandle(request, result);
        Context context = request.getContext();
        if (context != null) {
            int carWanliuUserType = BFFStore.getCarWanliuUserType(context);
            ArrayList arrayList = new ArrayList();
            Uri uri = request.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "request.uri");
            try {
                String queryParameter = uri.getQueryParameter("manualinputinfo");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                Object fromJson = new Gson().fromJson(queryParameter, new ScanRouterHandler$callRealHandle$list$1().getType());
                Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(manualinpu…nputInfoItem>>() {}.type)");
                arrayList.addAll((ArrayList) fromJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
            if (currentActivity != null) {
                Intent intent = new Intent();
                intent.setClassName(currentActivity, "com.didi.component.openride.newscan.GlobalQRScanActivity");
                GlobalScan globalScan = GlobalScan.INSTANCE;
                String queryParameter2 = uri.getQueryParameter(CashierParam.PARAM_FROM_TYPE);
                if (queryParameter2 == null) {
                    queryParameter2 = "index";
                }
                intent.putExtras(GlobalScan.INSTANCE.getScanExtra(globalScan.transStrToForm(queryParameter2), carWanliuUserType, arrayList));
                currentActivity.startActivity(intent);
            }
        }
    }
}
