package global.didi.pay.select.view.other;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import global.didi.pay.select.model.PayMethodItemInfo;

public class PayMethodCardView extends LinearLayout {
    private ImageView iv_paymethod_check;
    private ImageView iv_paymethod_desc_tip;
    private ImageView iv_paymethod_icon;
    private PayMethodItemInfo mItemInfo;
    private View.OnClickListener mOnClickListener;
    private TextView tv_paymethod_copy_writing;
    private TextView tv_paymethod_desc;
    private TextView tv_paymethod_label;
    private TextView tv_paymethod_name;
    private TextView tv_paymethod_right_text_green_bg;
    private TextView tv_paymethod_right_text_grey;

    public PayMethodCardView(Context context) {
        super(context);
        init(context);
    }

    public PayMethodCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PayMethodCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_v_paymethod_list_card, this, true);
        this.iv_paymethod_icon = (ImageView) findViewById(R.id.iv_paymethod_icon);
        this.iv_paymethod_check = (ImageView) findViewById(R.id.iv_paymethod_check);
        this.tv_paymethod_name = (TextView) findViewById(R.id.tv_paymethod_name);
        this.tv_paymethod_desc = (TextView) findViewById(R.id.tv_paymethod_desc);
        this.tv_paymethod_right_text_grey = (TextView) findViewById(R.id.tv_paymethod_right_text_grey);
        this.tv_paymethod_right_text_green_bg = (TextView) findViewById(R.id.tv_paymethod_right_text_green_bg);
        this.tv_paymethod_label = (TextView) findViewById(R.id.tv_paymethod_label);
        this.iv_paymethod_desc_tip = (ImageView) findViewById(R.id.iv_paymethod_desc_tip);
        this.tv_paymethod_copy_writing = (TextView) findViewById(R.id.tv_paymethod_copy_writing);
    }

    public void setPayMethodItemInfo(PayMethodItemInfo payMethodItemInfo) {
        if (payMethodItemInfo != null) {
            this.mItemInfo = payMethodItemInfo;
            setSelectStyle(payMethodItemInfo.style);
            this.tv_paymethod_name.setText(payMethodItemInfo.title);
            setTitleStyle(payMethodItemInfo.isEnabled, payMethodItemInfo.titleStyle);
            if (TextUtils.isEmpty(payMethodItemInfo.subTitle)) {
                this.tv_paymethod_desc.setVisibility(8);
            } else {
                this.tv_paymethod_desc.setVisibility(0);
                this.tv_paymethod_desc.setText(payMethodItemInfo.subTitle);
                setSubTitleStyle(payMethodItemInfo.isEnabled, payMethodItemInfo.subTitleStyle);
            }
            if (TextUtils.isEmpty(payMethodItemInfo.copyWriting)) {
                this.tv_paymethod_copy_writing.setVisibility(8);
            } else {
                this.tv_paymethod_copy_writing.setVisibility(0);
                this.tv_paymethod_copy_writing.setText(payMethodItemInfo.copyWriting);
            }
            if (TextUtils.isEmpty(payMethodItemInfo.label)) {
                this.tv_paymethod_label.setVisibility(8);
            } else {
                this.tv_paymethod_label.setVisibility(0);
                this.tv_paymethod_label.setText(payMethodItemInfo.label);
            }
            if (TextUtil.isEmpty(payMethodItemInfo.info)) {
                this.tv_paymethod_right_text_grey.setVisibility(8);
            } else {
                this.tv_paymethod_right_text_grey.setVisibility(0);
                this.tv_paymethod_right_text_grey.setText(payMethodItemInfo.info);
                setInfoTextStyle(payMethodItemInfo.infoStyle);
            }
            if (TextUtil.isEmpty(payMethodItemInfo.discount)) {
                this.tv_paymethod_right_text_green_bg.setVisibility(8);
            } else {
                this.tv_paymethod_right_text_green_bg.setVisibility(0);
                this.tv_paymethod_right_text_green_bg.setText(payMethodItemInfo.discount);
            }
            if (!TextUtils.isEmpty(payMethodItemInfo.iconUrl)) {
                GlideUtils.with2load2into(getContext(), payMethodItemInfo.iconUrl, this.iv_paymethod_icon);
            } else {
                int i = payMethodItemInfo.channelId;
                if (i == 121) {
                    this.iv_paymethod_icon.setImageResource(R.drawable.wallet_global_paymethod_list_icon_enterprise_selector);
                } else if (i == 150) {
                    this.iv_paymethod_icon.setImageResource(R.drawable.wallet_global_paymethod_list_icon_bank_selector);
                } else if (i == 152 || i == 183) {
                    this.iv_paymethod_icon.setImageResource(R.drawable.wallet_global_paymethod_list_icon_paypal_selector);
                } else if (i == 190) {
                    this.iv_paymethod_icon.setImageResource(R.drawable.wallet_global_paymethod_list_icon_99pay_normal);
                }
            }
            setMethodEnabled(payMethodItemInfo.isEnabled);
            if (payMethodItemInfo.isEnabled) {
                setIsSelected(payMethodItemInfo.isSelected);
            } else {
                setIsSelected(false);
            }
            if (!TextUtils.isEmpty(payMethodItemInfo.subTitleTip)) {
                this.iv_paymethod_desc_tip.setVisibility(0);
            } else {
                this.iv_paymethod_desc_tip.setVisibility(8);
            }
        }
    }

    public PayMethodItemInfo getPayMethodItemInfo() {
        return this.mItemInfo;
    }

    public int getChannelId() {
        PayMethodItemInfo payMethodItemInfo = this.mItemInfo;
        if (payMethodItemInfo != null) {
            return payMethodItemInfo.channelId;
        }
        return 0;
    }

    public String getCardIndex() {
        PayMethodItemInfo payMethodItemInfo = this.mItemInfo;
        return payMethodItemInfo != null ? payMethodItemInfo.cardIndex : "";
    }

    private void setSelectStyle(int i) {
        int i2;
        if (i == 1) {
            this.iv_paymethod_check.setVisibility(0);
            int i3 = R.drawable.wallet_global_paymethod_list_check_selector;
            try {
                i2 = DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.checkbox_selector);
            } catch (Exception unused) {
                i2 = R.drawable.wallet_global_paymethod_list_check_selector;
            }
            if (i2 != 0) {
                i3 = i2;
            }
            this.iv_paymethod_check.setImageResource(i3);
        } else if (i == 2) {
            this.iv_paymethod_check.setImageResource(R.drawable.wallet_global_paymethod_list_check_right_arrow);
            this.iv_paymethod_check.setVisibility(0);
        }
    }

    public void setIsSelected(boolean z) {
        this.mItemInfo.isSelected = z;
        this.iv_paymethod_check.setSelected(z);
    }

    public void setTitleStyle(boolean z, int i) {
        if (z && isEnabled()) {
            if (i != 0) {
                this.tv_paymethod_name.setEnabled(false);
            } else {
                this.tv_paymethod_name.setEnabled(true);
            }
        }
    }

    public void setSubTitleStyle(boolean z, int i) {
        if (z && isEnabled()) {
            if (i != 0) {
                this.tv_paymethod_desc.setEnabled(false);
            } else {
                this.tv_paymethod_desc.setEnabled(true);
            }
        }
    }

    public void setInfoTextStyle(int i) {
        if (!isEnabled()) {
            return;
        }
        if (i == 1) {
            this.tv_paymethod_right_text_grey.setTextColor(Color.parseColor("#FF584C"));
        } else {
            this.tv_paymethod_right_text_grey.setTextColor(Color.parseColor("#999999"));
        }
    }

    public boolean getIsSelected() {
        return this.mItemInfo.isSelected;
    }

    public void setMethodClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        setOnClickListener(onClickListener);
        this.iv_paymethod_desc_tip.setOnClickListener(onClickListener);
    }

    private void setMethodEnabled(boolean z) {
        this.iv_paymethod_icon.setEnabled(z);
        this.tv_paymethod_name.setEnabled(z);
        this.iv_paymethod_check.setEnabled(z);
        this.tv_paymethod_desc.setEnabled(z);
        this.tv_paymethod_right_text_grey.setEnabled(z);
        this.tv_paymethod_right_text_green_bg.setEnabled(z);
        if (!z) {
            setOnClickListener((View.OnClickListener) null);
        } else {
            setOnClickListener(this.mOnClickListener);
        }
    }
}
