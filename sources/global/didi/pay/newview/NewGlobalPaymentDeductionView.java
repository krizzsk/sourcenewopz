package global.didi.pay.newview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.component.view.DeductionItemType;
import com.didi.unifiedPay.component.view.VoucherViewConfig;
import com.taxis99.R;
import java.util.List;

public class NewGlobalPaymentDeductionView extends LinearLayout {
    /* access modifiers changed from: private */
    public View.OnClickListener mClickListener;
    private Context mContext;
    private LinearLayout mSupplyContainer;

    public NewGlobalPaymentDeductionView(Context context) {
        super(context);
        init();
    }

    public NewGlobalPaymentDeductionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NewGlobalPaymentDeductionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mSupplyContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_voucher_container, this).findViewById(R.id.oc_pay_supplement_container);
        this.mContext = getContext();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void addDeductionItem(VoucherViewConfig voucherViewConfig) {
        if (voucherViewConfig != null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_g_payment_voucher_item, this.mSupplyContainer, false);
            inflate.setTag(voucherViewConfig);
            TextView textView = (TextView) inflate.findViewById(R.id.oc_tv_voucher_left);
            textView.setText(voucherViewConfig.leftDes);
            TextView textView2 = (TextView) inflate.findViewById(R.id.oc_tv_voucher_mount);
            textView2.setText(voucherViewConfig.rightDes);
            if (textView.getText() != null) {
                inflate.setContentDescription(textView.getText().toString() + textView2.getText());
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.id.oc_iv_pay_voucher_icon);
            if (voucherViewConfig.showOrangeText) {
                textView2.setTextColor(getResources().getColor(R.color.oc_color_00ccaa));
            } else {
                textView2.setTextColor(getResources().getColor(R.color.oc_color_919599));
            }
            if (voucherViewConfig.showRightIcon) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (voucherViewConfig.canClick) {
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (NewGlobalPaymentDeductionView.this.mClickListener != null) {
                            NewGlobalPaymentDeductionView.this.mClickListener.onClick(view);
                        }
                    }
                });
                inflate.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.oc_view_selector));
                if (voucherViewConfig.deductionType == DeductionItemType.TYPE_VOUCHER) {
                    inflate.setContentDescription(inflate.getContentDescription() + getContext().getString(R.string.oc_voice_button) + getContext().getString(R.string.oc_uni_voice_change_coupons));
                }
            } else {
                inflate.setOnClickListener((View.OnClickListener) null);
                inflate.setBackgroundDrawable((Drawable) null);
            }
            this.mSupplyContainer.addView(inflate);
            if (this.mSupplyContainer.getVisibility() != 0) {
                this.mSupplyContainer.setVisibility(0);
            }
        }
    }

    public void addDeductionItems(List<VoucherViewConfig> list) {
        if (list != null && list.size() >= 1) {
            removeAllDeductions();
            for (int i = 0; i < list.size(); i++) {
                addDeductionItem(list.get(i));
            }
        }
    }

    public void removeAllDeductions() {
        if (this.mSupplyContainer.getChildCount() > 0) {
            this.mSupplyContainer.removeAllViews();
        }
        this.mSupplyContainer.setVisibility(8);
    }
}
