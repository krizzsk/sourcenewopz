package com.didiglobal.pay.paysecure.prepaidcard;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/KeyboardUtil;", "", "()V", "Companion", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: KeyboardUtil.kt */
public final class KeyboardUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/KeyboardUtil$Companion;", "", "()V", "hideKeyboard", "", "v", "Landroid/view/View;", "showKeyboard", "delay", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: KeyboardUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void showKeyboard$default(Companion companion, View view, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = 50;
            }
            companion.showKeyboard(view, j);
        }

        public final void showKeyboard(View view, long j) {
            Intrinsics.checkParameterIsNotNull(view, RavenKey.VERSION);
            view.postDelayed(new KeyboardUtil$Companion$showKeyboard$1(view), j);
        }

        public final void hideKeyboard(View view) {
            Intrinsics.checkParameterIsNotNull(view, RavenKey.VERSION);
            Object systemService = view.getContext().getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }
}
