package com.didi.dimina.container.secondparty.permission.runtime;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.checker.PermissionChecker;
import com.didi.dimina.container.secondparty.permission.checker.StrictChecker;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.didi.dimina.container.secondparty.permission.runtime.a */
/* compiled from: LRequest */
class C7606a implements PermissionRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final PermissionChecker f17390a = new StrictChecker();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Source f17391b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String[] f17392c;

    /* renamed from: d */
    private Action<List<String>> f17393d;

    /* renamed from: e */
    private Action<List<String>> f17394e;

    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        return this;
    }

    C7606a(Source source) {
        this.f17391b = source;
    }

    public PermissionRequest permission(String... strArr) {
        this.f17392c = strArr;
        return this;
    }

    public PermissionRequest onGranted(Action<List<String>> action) {
        this.f17393d = action;
        return this;
    }

    public PermissionRequest onDenied(Action<List<String>> action) {
        this.f17394e = action;
        return this;
    }

    public void start() {
        new LRequest$1(this).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12934b() {
        if (this.f17393d != null) {
            List asList = Arrays.asList(this.f17392c);
            try {
                this.f17393d.onAction(asList);
            } catch (Exception e) {
                LogUtil.m13410e("AndPermission", "Please check the onGranted() method body for bugs." + e);
                Action<List<String>> action = this.f17394e;
                if (action != null) {
                    action.onAction(asList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12932a(List<String> list) {
        Action<List<String>> action = this.f17394e;
        if (action != null) {
            action.onAction(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m12933b(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
