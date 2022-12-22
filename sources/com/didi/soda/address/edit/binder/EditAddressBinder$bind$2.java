package com.didi.soda.address.edit.binder;

import android.text.Editable;
import com.didi.soda.address.edit.binder.EditAddressBinder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressBinder.kt */
final class EditAddressBinder$bind$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EditAddressBinder.ViewHolder $holder;
    final /* synthetic */ EditAddressBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditAddressBinder$bind$2(EditAddressBinder editAddressBinder, EditAddressBinder.ViewHolder viewHolder) {
        super(0);
        this.this$0 = editAddressBinder;
        this.$holder = viewHolder;
    }

    public final void invoke() {
        EditAddressBinder editAddressBinder = this.this$0;
        Editable editableText = this.$holder.getApartmentNumberView().getEditableText();
        EditAddressBinder.onHouseBuildChanged$default(editAddressBinder, editableText == null ? null : editableText.toString(), (String) null, 2, (Object) null);
    }
}
