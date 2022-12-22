package com.didi.dimina.container.secondparty.permission.runtime;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.checker.DoubleChecker;
import com.didi.dimina.container.secondparty.permission.checker.PermissionChecker;
import com.didi.dimina.container.secondparty.permission.checker.StandardChecker;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.didi.dimina.container.secondparty.permission.runtime.b */
/* compiled from: MRequest */
class C7607b implements RequestExecutor, BridgeRequest.Callback, PermissionRequest {

    /* renamed from: a */
    private static final PermissionChecker f17395a = new StandardChecker();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final PermissionChecker f17396b = new DoubleChecker();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Source f17397c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String[] f17398d;

    /* renamed from: e */
    private Rationale<List<String>> f17399e = new MRequest$1(this);

    /* renamed from: f */
    private Action<List<String>> f17400f;

    /* renamed from: g */
    private Action<List<String>> f17401g;

    /* renamed from: h */
    private String[] f17402h;

    C7607b(Source source) {
        this.f17397c = source;
    }

    public PermissionRequest permission(String... strArr) {
        this.f17398d = strArr;
        return this;
    }

    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        this.f17399e = rationale;
        return this;
    }

    public PermissionRequest onGranted(Action<List<String>> action) {
        this.f17400f = action;
        return this;
    }

    public PermissionRequest onDenied(Action<List<String>> action) {
        this.f17401g = action;
        return this;
    }

    public void start() {
        List<String> b = m12943b(f17395a, this.f17397c, this.f17398d);
        String[] strArr = (String[]) b.toArray(new String[b.size()]);
        this.f17402h = strArr;
        if (strArr.length > 0) {
            List<String> a = m12940a(this.f17397c, strArr);
            if (a.size() > 0) {
                this.f17399e.showRationale(this.f17397c.getContext(), a, this);
            } else {
                execute();
            }
        } else {
            onCallback();
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f17397c);
        bridgeRequest.setType(2);
        bridgeRequest.setPermissions(this.f17402h);
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
    public void m12944b() {
        if (this.f17400f != null) {
            List asList = Arrays.asList(this.f17398d);
            try {
                this.f17400f.onAction(asList);
            } catch (Exception e) {
                LogUtil.m13410e("AndPermission", "Please check the onGranted() method body for bugs." + e);
                Action<List<String>> action = this.f17401g;
                if (action != null) {
                    action.onAction(asList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12942a(List<String> list) {
        Action<List<String>> action = this.f17401g;
        if (action != null) {
            action.onAction(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m12943b(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m12940a(Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (source.isShowRationalePermission(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
