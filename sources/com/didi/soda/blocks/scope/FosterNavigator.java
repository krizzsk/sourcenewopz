package com.didi.soda.blocks.scope;

import android.os.Bundle;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.dialog.Dialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/blocks/scope/FosterNavigator;", "Lcom/didi/app/nova/skeleton/INavigator;", "()V", "finish", "", "data", "Landroid/os/Bundle;", "popToRoot", "push", "page", "Lcom/didi/app/nova/skeleton/Page;", "pushForResult", "showDialog", "dialog", "Lcom/didi/app/nova/skeleton/dialog/Dialog;", "tag", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SampleScopeContext.kt */
final class FosterNavigator implements INavigator {
    public void finish() {
    }

    public void finish(Bundle bundle) {
    }

    public void popToRoot() {
    }

    public void push(Page page) {
    }

    public void pushForResult(Page page) {
    }

    public void showDialog(Dialog dialog, String str) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        Intrinsics.checkParameterIsNotNull(str, "tag");
    }
}
