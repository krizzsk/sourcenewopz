package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0007"}, mo175978d2 = {"Landroid/view/ViewGroup;", "", "layoutRes", "", "attachToRoot", "Landroid/view/View;", "inflate", "jumio-defaultui_release"}, mo175979k = 2, mo175980mv = {1, 5, 1})
/* compiled from: DocumentSelectionAdapter.kt */
public final class DocumentSelectionAdapterKt {
    /* access modifiers changed from: private */
    public static final View inflate(ViewGroup viewGroup, int i, boolean z) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(la…tRes, this, attachToRoot)");
        return inflate;
    }

    public static /* synthetic */ View inflate$default(ViewGroup viewGroup, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return inflate(viewGroup, i, z);
    }
}
