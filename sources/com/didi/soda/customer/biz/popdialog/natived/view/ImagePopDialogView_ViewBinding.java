package com.didi.soda.customer.biz.popdialog.natived.view;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class ImagePopDialogView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ImagePopDialogView f40512a;

    public ImagePopDialogView_ViewBinding(ImagePopDialogView imagePopDialogView, View view) {
        this.f40512a = imagePopDialogView;
        imagePopDialogView.mRootView = Utils.findRequiredView(view, R.id.customer_ll_pop_root, "field 'mRootView'");
        imagePopDialogView.mPopImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_pop_image, "field 'mPopImage'", ImageView.class);
        imagePopDialogView.mPopClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_pop_close, "field 'mPopClose'", ImageView.class);
    }

    public void unbind() {
        ImagePopDialogView imagePopDialogView = this.f40512a;
        if (imagePopDialogView != null) {
            this.f40512a = null;
            imagePopDialogView.mRootView = null;
            imagePopDialogView.mPopImage = null;
            imagePopDialogView.mPopClose = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
