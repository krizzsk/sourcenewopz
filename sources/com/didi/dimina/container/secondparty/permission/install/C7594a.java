package com.didi.dimina.container.secondparty.permission.install;

import android.content.Intent;
import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.AndPermission;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;
import java.io.File;

/* renamed from: com.didi.dimina.container.secondparty.permission.install.a */
/* compiled from: BaseRequest */
abstract class C7594a implements InstallRequest {

    /* renamed from: a */
    private final Source f17357a;

    /* renamed from: b */
    private File f17358b;

    /* renamed from: c */
    private Rationale<File> f17359c = new BaseRequest$1(this);

    /* renamed from: d */
    private Action<File> f17360d;

    /* renamed from: e */
    private Action<File> f17361e;

    C7594a(Source source) {
        this.f17357a = source;
    }

    public final InstallRequest file(File file) {
        this.f17358b = file;
        return this;
    }

    public final InstallRequest rationale(Rationale<File> rationale) {
        this.f17359c = rationale;
        return this;
    }

    public final InstallRequest onGranted(Action<File> action) {
        this.f17360d = action;
        return this;
    }

    public final InstallRequest onDenied(Action<File> action) {
        this.f17361e = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55902a(RequestExecutor requestExecutor) {
        this.f17359c.showRationale(this.f17357a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55901a() {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.setFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(AndPermission.getFileUri(this.f17357a.getContext(), this.f17358b), "application/vnd.android.package-archive");
        this.f17357a.startActivity(intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo55903b() {
        Action<File> action = this.f17360d;
        if (action != null) {
            action.onAction(this.f17358b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo55904c() {
        Action<File> action = this.f17361e;
        if (action != null) {
            action.onAction(this.f17358b);
        }
    }
}
