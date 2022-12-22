package com.didi.soda.bill.component.editremark2;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.textfield.RFTextField;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/soda/bill/component/editremark2/EditRemarkView2$init$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditRemarkView2.kt */
public final class EditRemarkView2$init$4 implements TextWatcher {
    final /* synthetic */ EditRemarkView2 this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    EditRemarkView2$init$4(EditRemarkView2 editRemarkView2) {
        this.this$0 = editRemarkView2;
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, RavenKey.STACK);
        RFTextField access$getContentEt$p = this.this$0.f38941a;
        Typeface typeface = null;
        if (access$getContentEt$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            access$getContentEt$p = null;
        }
        EditText editText = access$getContentEt$p.getEditText();
        if (editable.length() == 0) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(editText, IToolsService.FontType.LIGHT);
            return;
        }
        if (editText != null) {
            typeface = editText.getTypeface();
        }
        if (typeface != null && !Intrinsics.areEqual((Object) editText.getTypeface(), (Object) ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.MEDIUM))) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(editText, IToolsService.FontType.MEDIUM);
        }
    }
}
