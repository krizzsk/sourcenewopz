package com.didiglobal.scan.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.scan.GlobalScan;
import com.didiglobal.scan.delegate.ScanSchemeDispatcherDelegate;
import com.google.gson.Gson;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didiglobal/scan/net/ScanNetRequest;", "", "()V", "ABILITY_SCAN", "", "gson", "Lcom/google/gson/Gson;", "request", "", "context", "Landroid/content/Context;", "from", "Lcom/didiglobal/scan/GlobalScan$ScanFrom;", "scanUrl", "userType", "", "loadingDelegate", "Lcom/didiglobal/scan/net/ScanNetRequest$LoadingDelegate;", "errorDelegate", "Lcom/didiglobal/scan/net/ScanNetRequest$ErrorActionDelegate;", "transActionType", "Lcom/didiglobal/scan/delegate/ScanSchemeDispatcherDelegate$ActionType;", "actionType", "ErrorActionDelegate", "LoadingDelegate", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ScanNetRequest.kt */
public final class ScanNetRequest {
    public static final ScanNetRequest INSTANCE = new ScanNetRequest();

    /* renamed from: a */
    private static final String f51362a = "commonApi/pGetScanResult";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Gson f51363b = new Gson();

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/scan/net/ScanNetRequest$ErrorActionDelegate;", "", "showError", "", "error", "", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ScanNetRequest.kt */
    public interface ErrorActionDelegate {
        void showError(String str);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo175978d2 = {"Lcom/didiglobal/scan/net/ScanNetRequest$LoadingDelegate;", "", "hideLoading", "", "showLoading", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ScanNetRequest.kt */
    public interface LoadingDelegate {
        void hideLoading();

        void showLoading();
    }

    private ScanNetRequest() {
    }

    public final void request(Context context, GlobalScan.ScanFrom scanFrom, String str, int i, LoadingDelegate loadingDelegate, ErrorActionDelegate errorActionDelegate) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(scanFrom, "from");
        Intrinsics.checkParameterIsNotNull(str, "scanUrl");
        if (loadingDelegate != null) {
            loadingDelegate.showLoading();
        }
        IBffProxy.Ability.Builder builder = new IBffProxy.Ability.Builder(context, f51362a);
        HashMap hashMap = new HashMap();
        hashMap.put("scan_url", str);
        hashMap.put("from", scanFrom.getFrom());
        hashMap.put(ParamKeys.PARAM_USER_TYPE, Integer.valueOf(i));
        Bff.call(builder.setParams(hashMap).setCallback(new ScanNetRequest$request$ability$2(loadingDelegate, errorActionDelegate, context)).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ScanSchemeDispatcherDelegate.ActionType m36777a(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -558860276) {
            if (hashCode != -503752126) {
                if (hashCode == 1471807280 && str.equals("cashiercode")) {
                    return ScanSchemeDispatcherDelegate.ActionType.CASHIERCODE;
                }
            } else if (str.equals("openride")) {
                return ScanSchemeDispatcherDelegate.ActionType.OPENRIDE;
            }
        } else if (str.equals("pixcode")) {
            return ScanSchemeDispatcherDelegate.ActionType.PIX;
        }
        return ScanSchemeDispatcherDelegate.ActionType.NONE;
    }
}
