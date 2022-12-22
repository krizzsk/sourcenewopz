package com.didi.soda.address.edit.binder;

import android.text.Editable;
import com.didi.soda.address.edit.binder.EditAddressBinder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/soda/address/edit/binder/EditAddressModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressBinder.kt */
final class EditAddressBinder$bind$6 extends Lambda implements Function0<EditAddressModel> {
    final /* synthetic */ EditAddressModel $editAddressModel;
    final /* synthetic */ EditAddressBinder.ViewHolder $holder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditAddressBinder$bind$6(EditAddressBinder.ViewHolder viewHolder, EditAddressModel editAddressModel) {
        super(0);
        this.$holder = viewHolder;
        this.$editAddressModel = editAddressModel;
    }

    public final EditAddressModel invoke() {
        Editable text = this.$holder.getApartmentNumberView().getText();
        Intrinsics.checkNotNullExpressionValue(text, "holder.apartmentNumberView.text");
        Editable text2 = this.$holder.getBuildNameView().getText();
        Intrinsics.checkNotNullExpressionValue(text2, "holder.buildNameView.text");
        this.$editAddressModel.setBuildingName(text2.toString());
        this.$editAddressModel.setHouseNumber(text.toString());
        return this.$editAddressModel;
    }
}
