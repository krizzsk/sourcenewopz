package com.didi.soda.customer.blocks.widget.binder;

import android.widget.TextView;
import com.didi.soda.customer.widget.text.RichTextParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IconTextBinder.kt */
final class IconTextBinder$setText$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ IconTextBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconTextBinder$setText$1(IconTextBinder iconTextBinder) {
        super(1);
        this.this$0 = iconTextBinder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        CharSequence charSequence = str;
        if (this.this$0.f40764a.matcher(charSequence).find()) {
            ((TextView) this.this$0.getView()).setText(RichTextParser.parseIconText(charSequence));
        } else {
            IconTextBinder$setText$1.super.setText(str);
        }
    }
}
