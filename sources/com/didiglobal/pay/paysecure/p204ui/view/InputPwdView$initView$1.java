package com.didiglobal.pay.paysecure.p204ui.view;

import android.view.KeyEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo175978d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.InputPwdView$initView$1 */
/* compiled from: InputPwdView.kt */
final class InputPwdView$initView$1 implements View.OnKeyListener {
    final /* synthetic */ InputPwdView this$0;

    InputPwdView$initView$1(InputPwdView inputPwdView) {
        this.this$0 = inputPwdView;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkExpressionValueIsNotNull(keyEvent, "event");
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i >= 7 && i <= 16) {
            if (InputPwdView.access$getMAdapter$p(this.this$0).addPwd((char) keyEvent.getUnicodeChar())) {
                this.this$0.getMResultListener().onResult(new String(InputPwdView.access$getMAdapter$p(this.this$0).getInputList()));
            } else {
                this.this$0.getMResultListener().onChange();
            }
            return true;
        } else if (i != 67) {
            return false;
        } else {
            InputPwdView.access$getMAdapter$p(this.this$0).removePwd();
            this.this$0.getMResultListener().onChange();
            return true;
        }
    }
}
