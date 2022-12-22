package com.didi.soda.bill.component.tipfee;

import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.tipfee.Contract;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.bill.view.item.tipfee.BillTipsFeeListItemAdapter;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/bill/component/tipfee/BillTipsFeeEditPresenter;", "Lcom/didi/soda/bill/component/tipfee/Contract$AbsTipsFeeEditPresenter;", "()V", "TAG", "", "mBillTipFeeModel", "Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "mCartId", "mCurrency", "mOrderPrice", "", "mSelectedFee", "", "mShopId", "confirmTipsFeeInput", "", "tipsFeeStr", "getBillTipFeeModel", "handleBillTipsFeeData", "onCreate", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTipsFeeEditPresenter.kt */
public final class BillTipsFeeEditPresenter extends Contract.AbsTipsFeeEditPresenter {

    /* renamed from: a */
    private final String f38974a = "BillTipsFeeEditPresenter";

    /* renamed from: b */
    private BillTipModel f38975b;

    /* renamed from: c */
    private String f38976c = "";

    /* renamed from: d */
    private int f38977d;

    /* renamed from: e */
    private long f38978e;

    /* renamed from: f */
    private String f38979f;

    /* renamed from: g */
    private String f38980g;

    public BillTipsFeeEditPresenter() {
        Long l = BillTipsFeeListItemAdapter.FLAG_OF_OTHER_ITEM_VALUE;
        Intrinsics.checkNotNullExpressionValue(l, "FLAG_OF_OTHER_ITEM_VALUE");
        this.f38978e = l.longValue();
    }

    public BillTipModel getBillTipFeeModel() {
        return this.f38975b;
    }

    public void confirmTipsFeeInput(String str) {
        Intrinsics.checkNotNullParameter(str, "tipsFeeStr");
        BillTipModel billTipModel = this.f38975b;
        if (billTipModel != null) {
            long parseLong = str.length() == 0 ? 0 : Long.parseLong(str);
            if (!billTipModel.isPercent()) {
                parseLong *= (long) 100;
            }
            billTipModel.setTipFeeValue(parseLong);
            BillOmegaHelper.Companion.traceBillTipsFeeCK(this.f38980g, this.f38979f, true, billTipModel.getTipFeeValue(), billTipModel.getTipFeeType());
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(billTipModel.convertToEntity());
            getScopeContext().getNavigator().finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m27680a();
    }

    /* renamed from: a */
    private final void m27680a() {
        String str = "";
        try {
            Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.KEY_BILL_TIP_FEE_MODEL);
            if (serializable != null) {
                this.f38975b = serializable instanceof BillTipModel ? (BillTipModel) serializable : null;
            }
            String string = getScopeContext().getBundle().getString(Const.PageParams.KEY_BILL_TIP_FEE_CURRENCY, str);
            if (string == null) {
                string = str;
            }
            this.f38976c = string;
            Object obj = getScopeContext().getBundle().get("price");
            if (obj != null) {
                this.f38977d = ((Integer) obj).intValue();
                Object obj2 = getScopeContext().getBundle().get(Const.PageParams.KEY_BILL_TIP_FEE_SELECTED_FEE);
                if (obj2 != null) {
                    this.f38978e = ((Long) obj2).longValue();
                    String string2 = getScopeContext().getBundle().getString(Const.PageParams.CART_ID, str);
                    if (string2 == null) {
                        string2 = str;
                    }
                    this.f38980g = string2;
                    String string3 = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID, str);
                    if (string3 != null) {
                        str = string3;
                    }
                    this.f38979f = str;
                    ((Contract.AbsTipsFeeEditView) getLogicView()).bindTipsFeeData(this.f38975b, this.f38978e, this.f38976c);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e) {
            LogUtil.m29104i(this.f38974a, e.getLocalizedMessage());
        }
    }
}
