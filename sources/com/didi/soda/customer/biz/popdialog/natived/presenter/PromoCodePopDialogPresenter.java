package com.didi.soda.customer.biz.popdialog.natived.presenter;

import android.text.TextUtils;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.biz.popdialog.natived.view.PromoCodePopDialogView;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.rpc.entity.RedeemResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.SideBarRedeemEntity;
import com.didi.soda.customer.foundation.rpc.extra.CustomerActRpcManager;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.taxis99.R;

public class PromoCodePopDialogPresenter extends Contract.AbsPopDialogPresenter {

    /* renamed from: a */
    private static final String f40500a = "PromoCodePopDialogPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final CustomerActRpcManager f40501b = CustomerActRpcManager.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f40502c;

    public PromoCodePopDialogPresenter(NAPopDialogEntity nAPopDialogEntity) {
        super(nAPopDialogEntity);
    }

    public void onBtnClick() {
        super.onBtnClick();
        if (this.f40502c != -1) {
            ((Contract.AbsPopDialogView) getLogicView()).hidePopDialog(this.mPopDialogEntity);
        }
        int i = this.f40502c;
        if (i == -1) {
            m28731a();
        } else if (i == 0 && this.mPopDialogEntity.info != null && !TextUtils.isEmpty(this.mPopDialogEntity.info.btnUrl)) {
            SchemeHelper.dispatchMsg(this.mPopDialogEntity.info.btnUrl);
        }
        LogUtil.m29104i(f40500a, "onCloseBtnClick mErroCode = " + this.f40502c);
    }

    public void onImageClick() {
        super.onImageClick();
        LogUtil.m29104i(f40500a, "onImageClick");
        m28731a();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((Contract.AbsPopDialogView) getLogicView()).updatePopDialog(this.mPopDialogEntity);
    }

    /* renamed from: a */
    private void m28731a() {
        ((PromoCodePopDialogView) getLogicView()).goExchange(this.mPopDialogEntity);
        this.f40501b.sidebarRedeem(this.mPopDialogEntity.info.promoCode, new CustomerRpcCallback<SideBarRedeemEntity>() {
            public void onRpcSuccess(SideBarRedeemEntity sideBarRedeemEntity, long j) {
                if (sideBarRedeemEntity == null || TextUtils.isEmpty(sideBarRedeemEntity.ridapp)) {
                    int unused = PromoCodePopDialogPresenter.this.f40502c = -1;
                    ((PromoCodePopDialogView) PromoCodePopDialogPresenter.this.getLogicView()).exchangeResult(-1, PromoCodePopDialogPresenter.this.getContext().getResources().getString(R.string.customer_net_error_tip));
                    LogUtil.m29104i(PromoCodePopDialogPresenter.f40500a, "sidebarRedeem onRpcSuccess but sideRedeemEntity == null or ridApp == null ");
                    PromoCodePopDialogPresenter.this.mPopDialogOmageHelper.create(EventConst.PopDialog.REDENVELOPE_EXCHANGE_RESULT).addEventParam(ParamConst.PARAM_RESULT_TYPE, 2).addEventParam("error_msg", "sidebarRedeem success but entity == null").build().track();
                    return;
                }
                PromoCodePopDialogPresenter.this.f40501b.redeemResult(sideBarRedeemEntity.ridapp, new CustomerRpcCallback<RedeemResultEntity>() {
                    public void onRpcSuccess(RedeemResultEntity redeemResultEntity, long j) {
                        String str;
                        if (redeemResultEntity == null || CollectionsUtil.isEmpty(redeemResultEntity.couponList)) {
                            int unused = PromoCodePopDialogPresenter.this.f40502c = -1;
                            ((PromoCodePopDialogView) PromoCodePopDialogPresenter.this.getLogicView()).exchangeResult(-1, PromoCodePopDialogPresenter.this.getContext().getResources().getString(R.string.customer_net_error_tip));
                            LogUtil.m29104i(PromoCodePopDialogPresenter.f40500a, "redeemResult onRpcSuccess but RedeemResultEntity == null or couponList == null ");
                            PromoCodePopDialogPresenter.this.mPopDialogOmageHelper.create(EventConst.PopDialog.REDENVELOPE_EXCHANGE_RESULT).addEventParam(ParamConst.PARAM_RESULT_TYPE, 2).addEventParam("error_msg", "redeemResult success but entity == null").build().track();
                            return;
                        }
                        PromoCodePopDialogPresenter.this.mPopDialogOmageHelper.create(EventConst.PopDialog.REDENVELOPE_EXCHANGE_RESULT).addEventParam(ParamConst.PARAM_RESULT_TYPE, 1).build().track();
                        int size = redeemResultEntity.couponList.size();
                        if (size > 1) {
                            str = PromoCodePopDialogPresenter.this.getContext().getResources().getString(R.string.customer_pop_exchange_success_other_coupons, new Object[]{String.valueOf(size)});
                        } else {
                            str = PromoCodePopDialogPresenter.this.getContext().getResources().getString(R.string.customer_pop_exchange_success_one_coupon, new Object[]{redeemResultEntity.couponList.get(0).discountShow});
                        }
                        ((PromoCodePopDialogView) PromoCodePopDialogPresenter.this.getLogicView()).exchangeResult(0, str);
                        LogUtil.m29104i(PromoCodePopDialogPresenter.f40500a, "redeemResult onRpcSuccess");
                    }

                    public void onRpcFailure(SFRpcException sFRpcException) {
                        super.onRpcFailure(sFRpcException);
                        PromoCodePopDialogPresenter.this.mPopDialogOmageHelper.create(EventConst.PopDialog.REDENVELOPE_EXCHANGE_RESULT).addEventParam(ParamConst.PARAM_RESULT_TYPE, 2).addEventParam("error_code", Integer.valueOf(sFRpcException.getCode())).addEventParam("error_msg", sFRpcException.getOriginalMessage()).build().track();
                        int unused = PromoCodePopDialogPresenter.this.f40502c = sFRpcException.getCode();
                        ((PromoCodePopDialogView) PromoCodePopDialogPresenter.this.getLogicView()).exchangeResult(sFRpcException.getCode(), sFRpcException.getMessage());
                        LogUtil.m29104i(PromoCodePopDialogPresenter.f40500a, "redeemResult onRpcFailure mErroCode = " + PromoCodePopDialogPresenter.this.f40502c);
                    }
                });
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                PromoCodePopDialogPresenter.this.mPopDialogOmageHelper.create(EventConst.PopDialog.REDENVELOPE_EXCHANGE_RESULT).addEventParam(ParamConst.PARAM_RESULT_TYPE, 2).addEventParam("error_code", Integer.valueOf(sFRpcException.getCode())).addEventParam("error_msg", sFRpcException.getOriginalMessage()).build().track();
                int unused = PromoCodePopDialogPresenter.this.f40502c = sFRpcException.getCode();
                ((PromoCodePopDialogView) PromoCodePopDialogPresenter.this.getLogicView()).exchangeResult(sFRpcException.getCode(), sFRpcException.getMessage());
                LogUtil.m29104i(PromoCodePopDialogPresenter.f40500a, "sidebarRedeem onRpcFailure mErroCode = " + PromoCodePopDialogPresenter.this.f40502c);
            }
        });
    }
}
