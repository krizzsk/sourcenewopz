package com.didiglobal.travel.infra.widget;

import android.widget.TextView;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"setTextWithVisible", "", "Landroid/widget/TextView;", "text", "", "goneIfInvisible", "", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: TextView.kt */
public final class TextViewKt {
    public static /* synthetic */ void setTextWithVisible$default(TextView textView, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        setTextWithVisible(textView, charSequence, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if ((r4.length() > 0) != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setTextWithVisible(android.widget.TextView r3, java.lang.CharSequence r4, boolean r5) {
        /*
            java.lang.String r0 = "$this$setTextWithVisible"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x0015
            int r2 = r4.length()
            if (r2 <= 0) goto L_0x0011
            r2 = 1
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            if (r2 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r4 = r1
        L_0x0016:
            if (r4 == 0) goto L_0x0024
            r3.setText(r4)
            r1 = r3
            android.view.View r1 = (android.view.View) r1
            r1.setVisibility(r0)
            if (r4 == 0) goto L_0x0024
            goto L_0x0034
        L_0x0024:
            android.view.View r3 = (android.view.View) r3
            if (r5 == 0) goto L_0x002e
            r4 = 8
            r3.setVisibility(r4)
            goto L_0x0032
        L_0x002e:
            r4 = 4
            r3.setVisibility(r4)
        L_0x0032:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.widget.TextViewKt.setTextWithVisible(android.widget.TextView, java.lang.CharSequence, boolean):void");
    }
}
