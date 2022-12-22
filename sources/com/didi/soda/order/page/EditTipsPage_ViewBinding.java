package com.didi.soda.order.page;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class EditTipsPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private EditTipsPage f43523a;

    public EditTipsPage_ViewBinding(EditTipsPage editTipsPage, View view) {
        this.f43523a = editTipsPage;
        editTipsPage.mCartContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_cart_container, "field 'mCartContainer'", FrameLayout.class);
    }

    public void unbind() {
        EditTipsPage editTipsPage = this.f43523a;
        if (editTipsPage != null) {
            this.f43523a = null;
            editTipsPage.mCartContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
