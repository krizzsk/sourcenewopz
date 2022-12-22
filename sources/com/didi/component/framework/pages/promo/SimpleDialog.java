package com.didi.component.framework.pages.promo;

import android.os.Bundle;
import android.view.View;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.sdk.view.dialog.AlertDialogBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\n"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/SimpleDialog;", "Lcom/didi/sdk/view/dialog/AlertDialogBase;", "()V", "getRootView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SimpleDialog.kt */
public final class SimpleDialog extends AlertDialogBase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f13927a = DMWebSocketListener.KEY_ERR_MSG;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v5, types: [android.view.View] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getRootView(android.view.LayoutInflater r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0005
            r4 = r0
            goto L_0x000d
        L_0x0005:
            r1 = 2131625445(0x7f0e05e5, float:1.8878098E38)
            r2 = 0
            android.view.View r4 = r4.inflate(r1, r5, r2)
        L_0x000d:
            android.os.Bundle r5 = r3.getArguments()
            if (r5 != 0) goto L_0x0015
            r5 = r0
            goto L_0x001b
        L_0x0015:
            java.lang.String r1 = f13927a
            java.lang.String r5 = r5.getString(r1)
        L_0x001b:
            if (r4 != 0) goto L_0x001f
            r1 = r0
            goto L_0x0028
        L_0x001f:
            r1 = 2131431120(0x7f0b0ed0, float:1.848396E38)
            android.view.View r1 = r4.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0028:
            if (r1 != 0) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x0030:
            if (r4 != 0) goto L_0x0033
            goto L_0x003d
        L_0x0033:
            r5 = 2131431118(0x7f0b0ece, float:1.8483956E38)
            android.view.View r5 = r4.findViewById(r5)
            r0 = r5
            android.widget.Button r0 = (android.widget.Button) r0
        L_0x003d:
            if (r0 != 0) goto L_0x0040
            goto L_0x0048
        L_0x0040:
            com.didi.component.framework.pages.promo.-$$Lambda$SimpleDialog$9PGHXsCfXd_l0tCQcNZGsemiTqE r5 = new com.didi.component.framework.pages.promo.-$$Lambda$SimpleDialog$9PGHXsCfXd_l0tCQcNZGsemiTqE
            r5.<init>()
            r0.setOnClickListener(r5)
        L_0x0048:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.promo.SimpleDialog.getRootView(android.view.LayoutInflater, android.view.ViewGroup):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9651a(SimpleDialog simpleDialog, View view) {
        Intrinsics.checkNotNullParameter(simpleDialog, "this$0");
        simpleDialog.dismiss();
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/SimpleDialog$Companion;", "", "()V", "errMsg", "", "newInstance", "Lcom/didi/component/framework/pages/promo/SimpleDialog;", "msg", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SimpleDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SimpleDialog newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "msg");
            SimpleDialog simpleDialog = new SimpleDialog();
            Bundle bundle = new Bundle();
            bundle.putString(SimpleDialog.f13927a, str);
            simpleDialog.setArguments(bundle);
            return simpleDialog;
        }
    }
}
