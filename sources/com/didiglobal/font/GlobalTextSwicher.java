package com.didiglobal.font;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/font/GlobalTextSwicher;", "Landroid/widget/TextSwitcher;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getNextView", "Landroid/view/View;", "fontlib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GlobalTextSwicher.kt */
public final class GlobalTextSwicher extends TextSwitcher {

    /* renamed from: a */
    private HashMap f50235a;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f50235a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f50235a == null) {
            this.f50235a = new HashMap();
        }
        View view = (View) this.f50235a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f50235a.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public GlobalTextSwicher(Context context) {
        super(context);
    }

    public GlobalTextSwicher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public View getNextView() {
        View nextView = super.getNextView();
        if (nextView instanceof TextView) {
            DIDIFontUtils.Companion.setTypeface(nextView.getContext(), nextView);
        }
        Intrinsics.checkExpressionValueIsNotNull(nextView, "view");
        return nextView;
    }
}
