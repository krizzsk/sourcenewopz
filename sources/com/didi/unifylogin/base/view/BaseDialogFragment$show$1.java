package com.didi.unifylogin.base.view;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: BaseDialogFragment.kt */
final class BaseDialogFragment$show$1 implements Runnable {
    final /* synthetic */ FragmentManager $manager;
    final /* synthetic */ String $tag;
    final /* synthetic */ BaseDialogFragment this$0;

    BaseDialogFragment$show$1(BaseDialogFragment baseDialogFragment, FragmentManager fragmentManager, String str) {
        this.this$0 = baseDialogFragment;
        this.$manager = fragmentManager;
        this.$tag = str;
    }

    public final void run() {
        Fragment findFragmentByTag;
        if (!this.$manager.isDestroyed() && (findFragmentByTag = this.$manager.findFragmentByTag(this.$tag)) != this.this$0) {
            if (findFragmentByTag instanceof DialogFragment) {
                ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
            }
            FragmentTransaction beginTransaction = this.$manager.beginTransaction();
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this.this$0, this.$tag);
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
