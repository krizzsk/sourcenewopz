package com.didi.payment.transfer.fillamount;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class TransConfirmBankInfoDialog extends SimplePopupBase {

    /* renamed from: a */
    private TextView f31358a;

    /* renamed from: b */
    private TextView f31359b;

    /* renamed from: c */
    private TextView f31360c;

    /* renamed from: d */
    private LinearLayout f31361d;

    /* renamed from: e */
    private TextView f31362e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OperationListener f31363f;

    /* renamed from: g */
    private ImageView f31364g;

    /* renamed from: h */
    private IConfirmTransferInfo f31365h;

    /* renamed from: i */
    private TextView f31366i;

    public interface OperationListener {
        public static final int ACTION_CANCEL = -1;
        public static final int ACTION_CONFIRM = 0;

        void onAction(int i, Bundle bundle);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.trans_2_bank_info_confirm_dialog;
    }

    public static TransConfirmBankInfoDialog newInstance(Bundle bundle) {
        TransConfirmBankInfoDialog transConfirmBankInfoDialog = new TransConfirmBankInfoDialog();
        transConfirmBankInfoDialog.setArguments(bundle);
        return transConfirmBankInfoDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f31365h = (IConfirmTransferInfo) getArguments().getSerializable("transfer_to_bank_data");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        this.mRootView = layoutInflater.inflate(getLayout(), viewGroup);
        initView();
        return this.mRootView;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_account_details_confirm_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f31364g = (ImageView) this.mRootView.findViewById(R.id.dialog_close_img);
        this.f31358a = (TextView) this.mRootView.findViewById(R.id.confirm_dialog_title_tv);
        this.f31366i = (TextView) this.mRootView.findViewById(R.id.trans_money_amount_tv);
        this.f31360c = (TextView) this.mRootView.findViewById(R.id.trans_money_amount_desc_tv);
        this.f31361d = (LinearLayout) this.mRootView.findViewById(R.id.trans_2_bank_info_list_ll);
        this.f31362e = (TextView) this.mRootView.findViewById(R.id.trans_2_bank_confirm_amount_btn);
        this.f31364g.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransConfirmBankInfoDialog.this.dismiss();
                if (TransConfirmBankInfoDialog.this.f31363f != null) {
                    TransConfirmBankInfoDialog.this.f31363f.onAction(-1, (Bundle) null);
                }
            }
        });
        this.f31362e.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransConfirmBankInfoDialog.this.dismiss();
                if (TransConfirmBankInfoDialog.this.f31363f != null) {
                    TransConfirmBankInfoDialog.this.f31363f.onAction(0, new Bundle());
                }
            }
        });
        IConfirmTransferInfo iConfirmTransferInfo = this.f31365h;
        if (iConfirmTransferInfo != null) {
            String valueByType = iConfirmTransferInfo.getValueByType(IConfirmTransferInfo.ValueType.Transfer_MoneySymbal);
            String valueByType2 = this.f31365h.getValueByType(IConfirmTransferInfo.ValueType.Transfer_Amount);
            String valueByType3 = this.f31365h.getValueByType(IConfirmTransferInfo.ValueType.Transfer_Total_Amount);
            String valueByType4 = this.f31365h.getValueByType(IConfirmTransferInfo.ValueType.Transfer_ServiceFee);
            this.f31366i.setText(m22092a(valueByType, valueByType3));
            this.f31360c.setText(String.format(getString(R.string.GRider_PAX__unk_gJkl), new Object[]{valueByType2, valueByType4}));
            this.f31361d.removeAllViews();
            for (IConfirmTransferInfo.ValueType next : this.f31365h.getChildTypeValue()) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.trans_label_text_item_lay, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.label_left_tv)).setText(this.f31365h.getTypekey(getActivity(), next));
                ((TextView) inflate.findViewById(R.id.text_right_tv)).setText(this.f31365h.getValueByType(next));
                this.f31361d.addView(inflate);
            }
        }
    }

    /* renamed from: a */
    private SpannableStringBuilder m22092a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(str).append(str2);
        int i = 0;
        if (!TextUtil.isEmpty(str)) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(PaymentTextUtil.dip2px(getContext(), 14.0f)), 0, str.length(), 34);
            i = str.length() + 0;
        }
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(PaymentTextUtil.dip2px(getContext(), 28.0f)), i, spannableStringBuilder.length(), 34);
        return spannableStringBuilder;
    }

    public void setOperationListener(OperationListener operationListener) {
        this.f31363f = operationListener;
    }
}
