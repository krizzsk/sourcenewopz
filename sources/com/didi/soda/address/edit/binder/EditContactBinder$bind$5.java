package com.didi.soda.address.edit.binder;

import com.didi.soda.address.edit.binder.EditContactBinder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "msg", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditContactBinder.kt */
final class EditContactBinder$bind$5 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ EditContactBinder.ViewHolder $holder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditContactBinder$bind$5(EditContactBinder.ViewHolder viewHolder) {
        super(1);
        this.$holder = viewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        EditContactBinder.ViewHolder viewHolder = this.$holder;
        viewHolder.showNameLineBg(viewHolder.getFirstNameLine(), true);
        EditContactBinder.ViewHolder viewHolder2 = this.$holder;
        viewHolder2.showNameLineBg(viewHolder2.getLastNameLine(), true);
        this.$holder.getNameErrorHintView().setText(str);
        this.$holder.getNameErrorHintView().setVisibility(0);
    }
}
