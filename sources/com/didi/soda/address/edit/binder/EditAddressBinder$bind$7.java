package com.didi.soda.address.edit.binder;

import android.view.ViewTreeObserver;
import com.didi.soda.address.edit.binder.EditAddressBinder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/address/edit/binder/EditAddressBinder$bind$7", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressBinder.kt */
public final class EditAddressBinder$bind$7 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ EditAddressBinder.ViewHolder $holder;
    final /* synthetic */ EditAddressBinder this$0;

    EditAddressBinder$bind$7(EditAddressBinder.ViewHolder viewHolder, EditAddressBinder editAddressBinder) {
        this.$holder = viewHolder;
        this.this$0 = editAddressBinder;
    }

    public boolean onPreDraw() {
        this.$holder.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
        this.this$0.onBindFinish(this.$holder.itemView.getMeasuredHeight());
        EditAddressBinder editAddressBinder = this.this$0;
        editAddressBinder.getFirstViewHeight(editAddressBinder.cauTotalHeight(this.$holder.getAddressDetailNameView()) + this.this$0.cauTotalHeight(this.$holder.getAddressNameView()) + this.this$0.getExpandMarginHeight());
        return true;
    }
}
