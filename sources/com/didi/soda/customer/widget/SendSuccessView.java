package com.didi.soda.customer.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class SendSuccessView extends LinearLayout {
    @BindView(18102)
    ImageView mImage;
    @BindView(17956)
    RFMainButton mSuccessConfirmView;
    @BindView(18495)
    TextView mSuccessEmail;
    @BindView(18496)
    TextView mSuccessEmailTitle;

    public SendSuccessView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SendSuccessView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendSuccessView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29386a();
    }

    public void showSendSuccessView(String str, View.OnClickListener onClickListener) {
        showSendSuccessView(str, false, onClickListener);
    }

    public void showSendSuccessView(String str, boolean z, View.OnClickListener onClickListener) {
        setVisibility(0);
        TextView textView = this.mSuccessEmail;
        textView.setText(m29385a(R.string.customer_receipt_sent_to) + str);
        this.mSuccessConfirmView.setOnClickListener(onClickListener);
        if (z) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[]{(float) DisplayUtils.getScreenHeight(getContext()), 0.0f});
            ofFloat.setDuration(400);
            ofFloat.start();
        }
    }

    public void setSuccessData(String str, String str2, boolean z) {
        this.mSuccessEmailTitle.setText(str);
        this.mSuccessEmail.setText(str2);
        if (z) {
            this.mImage.setImageResource(R.drawable.customer_skin_img_personal_data_has_download);
        } else {
            this.mImage.setImageResource(R.drawable.customer_skin_img_personal_data_downloading);
        }
    }

    public void setSuccessEmailGravity(int i) {
        this.mSuccessEmail.setGravity(i);
    }

    /* renamed from: a */
    private void m29386a() {
        ButterKnife.bind((Object) this, inflate(getContext(), R.layout.customer_component_order_receipt_success, this));
        this.mSuccessConfirmView.setText(m29385a(R.string.customer_profile_complete));
        setVisibility(8);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mSuccessEmail, IToolsService.FontType.LIGHT);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mSuccessEmailTitle, IToolsService.FontType.BOLD);
    }

    /* renamed from: a */
    private String m29385a(int i) {
        return getContext().getResources().getString(i);
    }
}
