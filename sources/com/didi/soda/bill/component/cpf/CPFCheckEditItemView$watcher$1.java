package com.didi.soda.bill.component.cpf;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.didi.soda.bill.component.cpf.CPFCheckEditItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/soda/bill/component/cpf/CPFCheckEditItemView$watcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPFCheckEditItemView.kt */
public final class CPFCheckEditItemView$watcher$1 implements TextWatcher {
    final /* synthetic */ CPFCheckEditItemView this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    CPFCheckEditItemView$watcher$1(CPFCheckEditItemView cPFCheckEditItemView) {
        this.this$0 = cPFCheckEditItemView;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ImageView imageView = null;
        if (charSequence != null) {
            if (!(charSequence.length() == 0)) {
                ImageView access$getMCleanBtn$p = this.this$0.f38915b;
                if (access$getMCleanBtn$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCleanBtn");
                } else {
                    imageView = access$getMCleanBtn$p;
                }
                imageView.setVisibility(0);
                return;
            }
        }
        ImageView access$getMCleanBtn$p2 = this.this$0.f38915b;
        if (access$getMCleanBtn$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCleanBtn");
        } else {
            imageView = access$getMCleanBtn$p2;
        }
        imageView.setVisibility(4);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            try {
                CPFCheckEditItemView cPFCheckEditItemView = this.this$0;
                List<Pair> access$getKeyMap$p = cPFCheckEditItemView.f38919f;
                if (access$getKeyMap$p != null) {
                    String obj = editable.toString();
                    String str = obj;
                    for (Pair second : access$getKeyMap$p) {
                        str = StringsKt.replace$default(str, String.valueOf(((Character) second.getSecond()).charValue()), "", false, 4, (Object) null);
                    }
                    StringBuilder sb = new StringBuilder(str);
                    for (Pair pair : access$getKeyMap$p) {
                        if (sb.length() > ((Number) pair.getFirst()).intValue()) {
                            sb.insert(((Number) pair.getFirst()).intValue(), String.valueOf(((Character) pair.getSecond()).charValue()));
                        }
                    }
                    if (!Intrinsics.areEqual((Object) sb.toString(), (Object) editable.toString())) {
                        editable.replace(0, editable.length(), sb.toString());
                        return;
                    }
                    CPFCheckEditItemView.EditChangeListener access$getListener$p = cPFCheckEditItemView.f38920g;
                    if (access$getListener$p != null) {
                        access$getListener$p.afterTextChanged(editable.toString());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
