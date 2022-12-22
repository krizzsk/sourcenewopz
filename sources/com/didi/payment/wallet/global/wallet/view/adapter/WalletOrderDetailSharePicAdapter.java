package com.didi.payment.wallet.global.wallet.view.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class WalletOrderDetailSharePicAdapter implements WalletOrderSharePicContract.WalletOrderSharePicAdapter {

    /* renamed from: a */
    private Activity f32323a;

    /* renamed from: b */
    private boolean f32324b;

    /* renamed from: c */
    private WalletPayResultResp.PayResultData f32325c;

    /* renamed from: d */
    private List<WalletPayResultResp.ItemModel> f32326d;

    /* renamed from: e */
    private List<WalletPayResultResp.ItemModel> f32327e;

    /* renamed from: f */
    private List<WalletPayResultResp.ItemModel> f32328f;

    public int getTitleColorId() {
        return 0;
    }

    public WalletOrderDetailSharePicAdapter(Activity activity, boolean z) {
        this.f32323a = activity;
        this.f32324b = z;
    }

    public void setData(WalletPayResultResp.PayResultData payResultData) {
        this.f32325c = payResultData;
        this.f32326d = new LinkedList();
        this.f32327e = new LinkedList();
        this.f32328f = new LinkedList();
        WalletPayResultResp.PayResultData payResultData2 = this.f32325c;
        if (payResultData2 != null && !CollectionUtil.isEmpty((Collection) payResultData2.statement)) {
            this.f32326d.addAll(this.f32325c.statement);
        }
        WalletPayResultResp.PayResultData payResultData3 = this.f32325c;
        if (payResultData3 != null && !CollectionUtil.isEmpty((Collection) payResultData3.statementExtend)) {
            this.f32326d.addAll(this.f32325c.statementExtend);
        }
        WalletPayResultResp.PayResultData payResultData4 = this.f32325c;
        if (payResultData4 != null && !CollectionUtil.isEmpty((Collection) payResultData4.rechargeStatement)) {
            this.f32327e.addAll(this.f32325c.rechargeStatement);
        }
        WalletPayResultResp.PayResultData payResultData5 = this.f32325c;
        if (payResultData5 != null && !CollectionUtil.isEmpty((Collection) payResultData5.payeeStatement)) {
            this.f32328f.addAll(this.f32325c.payeeStatement);
        }
    }

    public String getTitle() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        return payResultData != null ? payResultData.resultMainTitle : "";
    }

    public String getSubTitle() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        return payResultData != null ? payResultData.resultSubTitle : "";
    }

    public int getSubTitleColorId() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        if (payResultData == null || payResultData.subTitleColor == null) {
            return 0;
        }
        return Color.parseColor(this.f32325c.subTitleColor);
    }

    public int getSubTitleBgColorId() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        if (payResultData == null || payResultData.subTitleBgColor == null) {
            return 0;
        }
        return Color.parseColor(this.f32325c.subTitleBgColor);
    }

    public int getStatusImg() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        if (payResultData == null) {
            return 0;
        }
        if (payResultData.status == 1) {
            return R.drawable.wallet_transfer_icon_success;
        }
        return (this.f32325c.status == 0 || this.f32325c.status == 6) ? R.drawable.wallet_transfer_icon_processing : R.drawable.wallet_transfer_icon_failed;
    }

    public String getRechargementTitle() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        return (payResultData == null || payResultData.rechargeStatementTile == null) ? "" : this.f32325c.rechargeStatementTile;
    }

    public String getPayeementTitle() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        return (payResultData == null || payResultData.payeeStatementTitle == null) ? "" : this.f32325c.payeeStatementTitle;
    }

    public int getRechargementItemCount() {
        List<WalletPayResultResp.ItemModel> list = this.f32327e;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f32327e.size();
        }
        return 0;
    }

    public int getPayeementItemCount() {
        List<WalletPayResultResp.ItemModel> list = this.f32328f;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f32328f.size();
        }
        return 0;
    }

    public int getResultIcon() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        if (payResultData == null) {
            return 0;
        }
        if (payResultData.status == 1) {
            return R.drawable.wallet_toast_icon_successful;
        }
        if (this.f32325c.status == 2) {
            return R.drawable.wallet_toast_icon_fail;
        }
        return 0;
    }

    public int getItemsCount() {
        List<WalletPayResultResp.ItemModel> list = this.f32326d;
        if (list != null && !CollectionUtil.isEmpty((Collection) list)) {
            return this.f32326d.size();
        }
        return 0;
    }

    public View getItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f32326d)) {
            return null;
        }
        WalletPayResultResp.ItemModel itemModel = this.f32326d.get(i);
        View inflate = LayoutInflater.from(this.f32323a).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
        ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
        if (!TextUtils.isEmpty(itemModel.color)) {
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setTextColor(Color.parseColor(itemModel.color));
        }
        return inflate;
    }

    public View getRechargeItemView(ViewGroup viewGroup, int i) {
        if (CollectionUtil.isEmpty((Collection) this.f32327e)) {
            return null;
        }
        WalletPayResultResp.ItemModel itemModel = this.f32327e.get(i);
        View inflate = LayoutInflater.from(this.f32323a).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, viewGroup, false);
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
        if (CollectionUtil.isEmpty((Collection) this.f32328f)) {
            return null;
        }
        WalletPayResultResp.ItemModel itemModel = this.f32328f.get(i);
        View inflate = LayoutInflater.from(this.f32323a).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, viewGroup, false);
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
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        return payResultData != null ? payResultData.currencySymbol : "";
    }

    public String getPrice() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        return payResultData != null ? payResultData.amount : "";
    }

    public String getBannerText() {
        WalletPayResultResp.PayResultData payResultData = this.f32325c;
        return payResultData != null ? payResultData.shareBannerText : "";
    }
}
