package com.yanzhenjie.permission.runtime;

import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.checker.DoubleChecker;
import com.yanzhenjie.permission.checker.PermissionChecker;
import com.yanzhenjie.permission.checker.StandardChecker;
import com.yanzhenjie.permission.source.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.b */
/* compiled from: MRequest */
class C20719b implements RequestExecutor, BridgeRequest.Callback, PermissionRequest {

    /* renamed from: a */
    private static final PermissionChecker f56235a = new StandardChecker();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final PermissionChecker f56236b = new DoubleChecker();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Source f56237c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String[] f56238d;

    /* renamed from: e */
    private Rationale<List<String>> f56239e = new MRequest$1(this);

    /* renamed from: f */
    private Action<List<String>> f56240f;

    /* renamed from: g */
    private Action<List<String>> f56241g;

    /* renamed from: h */
    private String[] f56242h;

    C20719b(Source source) {
        this.f56237c = source;
    }

    public PermissionRequest permission(String... strArr) {
        this.f56238d = strArr;
        return this;
    }

    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        this.f56239e = rationale;
        return this;
    }

    public PermissionRequest onGranted(Action<List<String>> action) {
        this.f56240f = action;
        return this;
    }

    public PermissionRequest onDenied(Action<List<String>> action) {
        this.f56241g = action;
        return this;
    }

    public void start() {
        List<String> b = m40511b(f56235a, this.f56237c, this.f56238d);
        String[] strArr = (String[]) b.toArray(new String[b.size()]);
        this.f56242h = strArr;
        if (strArr.length > 0) {
            List<String> a = m40508a(this.f56237c, strArr);
            if (a.size() > 0) {
                this.f56239e.showRationale(this.f56237c.getContext(), a, this);
            } else {
                execute();
            }
        } else {
            onCallback();
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f56237c);
        bridgeRequest.setType(2);
        bridgeRequest.setPermissions(this.f56242h);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        onCallback();
    }

    public void onCallback() {
        new MRequest$2(this).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40512b() {
        if (this.f56240f != null) {
            List asList = Arrays.asList(this.f56238d);
            try {
                this.f56240f.onAction(asList);
            } catch (Exception e) {
                SystemUtils.log(6, "AndPermission", "Please check the onGranted() method body for bugs.", e, "com.yanzhenjie.permission.runtime.MRequest", 145);
                Action<List<String>> action = this.f56241g;
                if (action != null) {
                    action.onAction(asList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40510a(List<String> list) {
        Action<List<String>> action = this.f56241g;
        if (action != null) {
            action.onAction(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m40511b(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m40508a(Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (source.isShowRationalePermission(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
