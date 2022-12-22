package com.didi.soda.address.edit.binder;

import android.text.Editable;
import android.text.TextWatcher;
import com.didi.raven.config.RavenKey;
import com.didi.soda.address.edit.binder.EditContactBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/soda/address/edit/binder/EditContactBinder$ViewHolder$nameTextChangeListener$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditContactBinder.kt */
public final class EditContactBinder$ViewHolder$nameTextChangeListener$1 implements TextWatcher {
    final /* synthetic */ EditContactBinder.ViewHolder this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    EditContactBinder$ViewHolder$nameTextChangeListener$1(EditContactBinder.ViewHolder viewHolder) {
        this.this$0 = viewHolder;
    }

    public void afterTextChanged(Editable editable) {
        this.this$0.getNameErrorHintView().setVisibility(4);
        EditContactBinder.ViewHolder viewHolder = this.this$0;
        viewHolder.showNameLineBg(viewHolder.getFirstNameLine(), false);
        EditContactBinder.ViewHolder viewHolder2 = this.this$0;
        viewHolder2.showNameLineBg(viewHolder2.getLastNameLine(), false);
    }
}
