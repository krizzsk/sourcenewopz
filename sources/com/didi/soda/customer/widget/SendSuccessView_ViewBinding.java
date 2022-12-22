package com.didi.soda.customer.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class SendSuccessView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SendSuccessView f41562a;

    public SendSuccessView_ViewBinding(SendSuccessView sendSuccessView) {
        this(sendSuccessView, sendSuccessView);
    }

    public SendSuccessView_ViewBinding(SendSuccessView sendSuccessView, View view) {
        this.f41562a = sendSuccessView;
        sendSuccessView.mSuccessEmail = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_layout_success_email, "field 'mSuccessEmail'", TextView.class);
        sendSuccessView.mSuccessEmailTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_layout_success_email_title, "field 'mSuccessEmailTitle'", TextView.class);
        sendSuccessView.mSuccessConfirmView = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_custom_common_success_confirm, "field 'mSuccessConfirmView'", RFMainButton.class);
        sendSuccessView.mImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_download_progress_image, "field 'mImage'", ImageView.class);
    }

    public void unbind() {
        SendSuccessView sendSuccessView = this.f41562a;
        if (sendSuccessView != null) {
            this.f41562a = null;
            sendSuccessView.mSuccessEmail = null;
            sendSuccessView.mSuccessEmailTitle = null;
            sendSuccessView.mSuccessConfirmView = null;
            sendSuccessView.mImage = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
