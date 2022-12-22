package com.yanzhenjie.permission.runtime;

import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.checker.PermissionChecker;
import com.yanzhenjie.permission.checker.StrictChecker;
import com.yanzhenjie.permission.source.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.a */
/* compiled from: LRequest */
class C20718a implements PermissionRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final PermissionChecker f56230a = new StrictChecker();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Source f56231b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String[] f56232c;

    /* renamed from: d */
    private Action<List<String>> f56233d;

    /* renamed from: e */
    private Action<List<String>> f56234e;

    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        return this;
    }

    C20718a(Source source) {
        this.f56231b = source;
    }

    public PermissionRequest permission(String... strArr) {
        this.f56232c = strArr;
        return this;
    }

    public PermissionRequest onGranted(Action<List<String>> action) {
        this.f56233d = action;
        return this;
    }

    public PermissionRequest onDenied(Action<List<String>> action) {
        this.f56234e = action;
        return this;
    }

    public void start() {
        new LRequest$1(this).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40502b() {
        if (this.f56233d != null) {
            List asList = Arrays.asList(this.f56232c);
            try {
                this.f56233d.onAction(asList);
            } catch (Exception e) {
                SystemUtils.log(6, "AndPermission", "Please check the onGranted() method body for bugs.", e, "com.yanzhenjie.permission.runtime.LRequest", 100);
                Action<List<String>> action = this.f56234e;
                if (action != null) {
                    action.onAction(asList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40500a(List<String> list) {
        Action<List<String>> action = this.f56234e;
        if (action != null) {
            action.onAction(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m40501b(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
