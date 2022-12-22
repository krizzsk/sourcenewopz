package com.didiglobal.pay.paysecure.prepaidcard.loading;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/loading/ILoading;", "", "hideLoading", "", "showLoading", "context", "Landroidx/fragment/app/FragmentActivity;", "view", "Landroid/view/View;", "msg", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ILoading.kt */
public interface ILoading {
    void hideLoading();

    void showLoading(FragmentActivity fragmentActivity, View view, String str);

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    /* compiled from: ILoading.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void showLoading$default(ILoading iLoading, FragmentActivity fragmentActivity, View view, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    view = null;
                }
                if ((i & 4) != 0) {
                    str = "";
                }
                iLoading.showLoading(fragmentActivity, view, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
        }
    }
}
