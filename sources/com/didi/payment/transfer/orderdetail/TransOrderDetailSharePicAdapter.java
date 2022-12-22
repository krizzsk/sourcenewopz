package com.didi.payment.transfer.orderdetail;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.payment.transfer.orderdetail.presenter.TransPayResultResp;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TransOrderDetailSharePicAdapter implements WalletOrderSharePicContract.WalletOrderSharePicAdapter {

    /* renamed from: a */
    private Activity f31460a;

    /* renamed from: b */
    private TransPayResultResp.PayResultData f31461b;

    /* renamed from: c */
    private List<TransPayResultResp.ItemModel> f31462c;

    /* renamed from: d */
    private List<TransPayResultResp.ItemModel> f31463d;

    /* renamed from: e */
    private List<TransPayResultResp.ItemModel> f31464e;

    public int getTitleColorId() {
        return 0;
    }

    public TransOrderDetailSharePicAdapter(Activity activity) {
        this.f31460a = activity;
    }

    public void setData(TransPayResultResp.PayResultData payResultData) {
        this.f31461b = payResultData;
        this.f31462c = new LinkedList();
        this.f31463d = new LinkedList();
        this.f31464e = new LinkedList();
        TransPayResultResp.PayResultData payResultData2 = this.f31461b;
        if (payResultData2 != null && !CollectionUtil.isEmpty((Collection) payResultData2.statement)) {
            this.f31462c.addAll(this.f31461b.statement);
        }
        TransPayResultResp.PayResultData payResultData3 = this.f31461b;
        if (payResultData3 != null && !CollectionUtil.isEmpty((Collection) payResultData3.statementExtend)) {
            this.f31462c.addAll(this.f31461b.statementExtend);
        }
        TransPayResultResp.PayResultData payResultData4 = this.f31461b;
        if (payResultData4 != null && !CollectionUtil.isEmpty((Collection) payResultData4.rechargeStatement)) {
            this.f31463d.addAll(this.f31461b.rechargeStatement);
        }
        TransPayResultResp.PayResultData payResultData5 = this.f31461b;
        if (payResultData5 != null && !CollectionUtil.isEmpty((Collection) payResultData5.payeeStatement)) {
            this.f31464e.addAll(this.f31461b.payeeStatement);
        }
    }

    public String getTitle() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        return payResultData != null ? payResultData.resultMainTitle : "";
    }

    public String getSubTitle() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        return payResultData != null ? payResultData.resultSubTitle : "";
    }

    public int getSubTitleColorId() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        if (payResultData == null || payResultData.subTitleColor == null) {
            return 0;
        }
        return Color.parseColor(this.f31461b.subTitleColor);
    }

    public int getSubTitleBgColorId() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        if (payResultData == null || payResultData.subTitleBgColor == null) {
            return 0;
        }
        return Color.parseColor(this.f31461b.subTitleBgColor);
    }

    public int getStatusImg() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        if (payResultData == null) {
            return 0;
        }
        if (payResultData.status == 1) {
            return R.drawable.wallet_transfer_icon_success;
        }
        return (this.f31461b.status == 0 || this.f31461b.status == 6) ? R.drawable.wallet_transfer_icon_processing : R.drawable.wallet_transfer_icon_failed;
    }

    public String getRechargementTitle() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        return (payResultData == null || payResultData.rechargeStatementTile == null) ? "" : this.f31461b.rechargeStatementTile;
    }

    public String getPayeementTitle() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        return (payResultData == null || payResultData.payeeStatementTitle == null) ? "" : this.f31461b.payeeStatementTitle;
    }

    public int getRechargementItemCount() {
        List<TransPayResultResp.ItemModel> list = this.f31463d;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f31463d.size();
        }
        return 0;
    }

    public int getPayeementItemCount() {
        List<TransPayResultResp.ItemModel> list = this.f31464e;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f31464e.size();
        }
        return 0;
    }

    public int getResultIcon() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        if (payResultData == null) {
            return 0;
        }
        if (payResultData.status == 1) {
            return R.drawable.wallet_toast_icon_successful;
        }
        if (this.f31461b.status == 2) {
            return R.drawable.wallet_toast_icon_fail;
        }
        return 0;
    }

    public int getItemsCount() {
        List<TransPayResultResp.ItemModel> list = this.f31462c;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f31462c.size();
        }
        return 0;
    }

    public View getItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f31462c)) {
            return null;
        }
        TransPayResultResp.ItemModel itemModel = this.f31462c.get(i);
        View inflate = LayoutInflater.from(this.f31460a).inflate(R.layout.trans_orderdetail_item_lay, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
        ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
        return inflate;
    }

    public View getRechargeItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f31463d)) {
            return null;
        }
        TransPayResultResp.ItemModel itemModel = this.f31463d.get(i);
        View inflate = LayoutInflater.from(this.f31460a).inflate(R.layout.trans_orderdetail_item_lay, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
        ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
        if (!TextUtils.isEmpty(itemModel.color)) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTextColor(Color.parseColor(itemModel.color));
        }
        if (itemModel.isBold) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTypeface(Typeface.defaultFromStyle(1));
        }
        return inflate;
    }

    public View getPayeeItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f31464e)) {
            return null;
        }
        TransPayResultResp.ItemModel itemModel = this.f31464e.get(i);
        View inflate = LayoutInflater.from(this.f31460a).inflate(R.layout.trans_orderdetail_item_lay, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
        ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
        if (!TextUtils.isEmpty(itemModel.color)) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTextColor(Color.parseColor(itemModel.color));
        }
        if (itemModel.isBold) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTypeface(Typeface.defaultFromStyle(1));
        }
        return inflate;
    }

    public String getSymbol() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        return payResultData != null ? payResultData.currencySymbol : "";
    }

    public String getPrice() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        return payResultData != null ? payResultData.amount : "";
    }

    public String getBannerText() {
        TransPayResultResp.PayResultData payResultData = this.f31461b;
        return payResultData != null ? payResultData.shareBannerText : "";
    }
}
