package com.didi.soda.order.component.tips;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import com.didi.soda.cart.component.globalmini.Contract;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayTipResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.abnormal.AbnormalFactory;
import com.didi.soda.jadux.Action;
import com.didi.soda.jadux.Store;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.pay.PayMethodPage;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.taxis99.R;
import java.io.IOException;
import p242io.reactivex.functions.Consumer;

public class EditTipsPresenter extends Contract.AbsEditTipsPresenter {
    public static final int TIPS_TYPE_PERCENT = 2;
    public static final int TIPS_TYPE_QUOTA = 1;

    /* renamed from: a */
    private Store<TipState> f43471a;

    /* renamed from: b */
    private TipState f43472b;

    public void finish() {
        getScopeContext().getNavigator().finish();
    }

    public void onCreate() {
        super.onCreate();
        Bundle bundle = getScopeContext().getBundle();
        TipState tipState = new TipState();
        this.f43472b = tipState;
        tipState.mOrderId = bundle.getString("orderId");
        this.f43472b.mOrderPrice = (long) bundle.getInt(Const.FlutterBundleKey.AFTER_FAV_PRICE);
        this.f43472b.mCurrency = bundle.getString("currency");
        this.f43472b.mIsFromOrder = bundle.getBoolean(Const.FlutterBundleKey.IS_FROM_ORDER);
        m30788a();
    }

    public void onPaymethodSelect() {
        TipState state = this.f43471a.getState();
        PayMethodPage.toPayMethod(getScopeContext(), state.mBusinessId, (int) state.mTips.tipPayValue, 2, "", 0, state.mPaychannel);
    }

    public void onSelectCard(PayChannelEntity payChannelEntity) {
        this.f43471a.dispatch(new Action(TipActionType.SELECT_PAYCARD, payChannelEntity));
    }

    public void onTipsInputChange(String str) {
        if (!str.equals(this.f43471a.getState().mInput)) {
            this.f43471a.dispatch(TipActionCreator.inputTip(str));
        }
    }

    public void payTips() {
        TipState state = this.f43471a.getState();
        PayChannelEntity payChannelEntity = state.mPaychannel;
        if (payChannelEntity == null) {
            ToastUtil.showCustomerErrorToast(getScopeContext(), getContext().getResources().getString(R.string.customer_name_pelease_select_pay_method));
        } else if (!((Contract.AbsEditTipsView) getLogicView()).isLoading()) {
            ((Contract.AbsEditTipsView) getLogicView()).showConfirmLoading();
            CustomerRpcManagerProxy.get().tipPay(state.mOrderId, state.mTips.tipFeeValue, state.mTips.tipFeeType, payChannelEntity, DeviceTokenWrapper.getInstance().getDeviceToken(), new CustomerRpcCallback<PayTipResultEntity>() {
                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    ((Contract.AbsEditTipsView) EditTipsPresenter.this.getLogicView()).hideConfirmLoading();
                    if (sFRpcException == null || TextUtils.isEmpty(sFRpcException.getMessage())) {
                        ToastUtil.showCustomerErrorToast(EditTipsPresenter.this.getScopeContext(), EditTipsPresenter.this.getContext().getResources().getString(R.string.customer_order_wait_pay_fail));
                    } else {
                        ToastUtil.showCustomerErrorToast(EditTipsPresenter.this.getScopeContext(), sFRpcException.getMessage());
                    }
                    ErrorTracker.Builder create = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_ORDER_TIP_PAY_ERROR);
                    ApiErrorUtil.Companion companion = ApiErrorUtil.Companion;
                    create.addErrorType(companion.getErrorType(sFRpcException.getCode() + "")).addErrorMsg(sFRpcException.getOriginalMessage()).addModuleName("order").build().trackError();
                }

                public void onRpcSuccess(PayTipResultEntity payTipResultEntity, long j) {
                    EditTipsPresenter.this.m30793a(payTipResultEntity.orderId, payTipResultEntity.transId);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30789a(TipsConfigEntity tipsConfigEntity) {
        this.f43472b.mConfig = tipsConfigEntity;
        ((Contract.AbsEditTipsView) getLogicView()).initView(this.f43472b);
        if (this.f43472b.mTips == null) {
            TipFeeInfoEntity tipFeeInfoEntity = new TipFeeInfoEntity();
            tipFeeInfoEntity.tipFeeType = tipsConfigEntity.tipFeeType;
            this.f43472b.mTips = tipFeeInfoEntity;
        }
        if (this.f43472b.mTips.tipFeeType != tipsConfigEntity.tipFeeType) {
            TipFeeInfoEntity tipFeeInfoEntity2 = new TipFeeInfoEntity();
            tipFeeInfoEntity2.tipFeeType = tipsConfigEntity.tipFeeType;
            this.f43472b.mTips = tipFeeInfoEntity2;
        }
        boolean z = false;
        if (tipsConfigEntity.tipFeeConfig != null) {
            int i = 0;
            while (true) {
                if (i >= tipsConfigEntity.tipFeeConfig.size()) {
                    break;
                }
                long longValue = tipsConfigEntity.tipFeeConfig.get(i).longValue();
                if (tipsConfigEntity.tipFeeType != 1 || longValue != this.f43472b.mTips.tipFeeValue * 100) {
                    if (tipsConfigEntity.tipFeeType == 2 && longValue == this.f43472b.mTips.tipFeeValue) {
                        this.f43472b.mSelectStatus.put(Integer.valueOf(i), true);
                        break;
                    }
                    i++;
                } else {
                    this.f43472b.mSelectStatus.put(Integer.valueOf(i), true);
                    break;
                }
            }
        }
        z = true;
        if (z && this.f43472b.mTips.tipFeeValue > 0) {
            if (tipsConfigEntity.tipFeeType == 1) {
                TipState tipState = this.f43472b;
                tipState.mInput = (((double) this.f43472b.mTips.tipFeeValue) / 100.0d) + "";
            } else if (tipsConfigEntity.tipFeeType == 2) {
                TipState tipState2 = this.f43472b;
                tipState2.mInput = this.f43472b.mTips.tipFeeValue + "";
            }
        }
        Store<TipState> createStore = new Store().createStore(new TipReducer(getContext()), this.f43472b);
        this.f43471a = createStore;
        createStore.subscribe(new Consumer<TipState>() {
            public void accept(TipState tipState) {
                ((Contract.AbsEditTipsView) EditTipsPresenter.this.getLogicView()).updateView(tipState);
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th) throws Exception {
                th.printStackTrace();
                throw new Exception(th);
            }
        });
        ((Contract.AbsEditTipsView) getLogicView()).initTipsGroupStore(this.f43471a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30788a() {
        ((Contract.AbsEditTipsView) getLogicView()).showLoading();
        CustomerRpcManagerProxy.get().tipConfig(this.f43472b.mOrderId, new CustomerRpcCallback<TipsConfigEntity>() {
            public void onFailure(IOException iOException) {
                super.onFailure(iOException);
                EditTipsPresenter.this.m30794b();
            }

            public void onRpcSuccess(TipsConfigEntity tipsConfigEntity, long j) {
                ((Contract.AbsEditTipsView) EditTipsPresenter.this.getLogicView()).showSuccess();
                EditTipsPresenter.this.m30789a(tipsConfigEntity);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30793a(final String str, String str2) {
        ICustomerPayManager.PayParamEntity payParamEntity = new ICustomerPayManager.PayParamEntity();
        payParamEntity.token = LoginUtil.getToken();
        payParamEntity.transId = str2;
        ((ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class)).getPayStatus((Activity) getContext(), getScopeContext(), payParamEntity, new ICustomerPayManager.PayCallback() {
            public void onThirdPayStart(int i) {
            }

            public void payFail(int i, String str, PayStatusModel payStatusModel) {
                ((Contract.AbsEditTipsView) EditTipsPresenter.this.getLogicView()).hideConfirmLoading();
                if (TextUtils.isEmpty(str)) {
                    ToastUtil.showCustomerErrorToast(EditTipsPresenter.this.getScopeContext(), EditTipsPresenter.this.getContext().getString(R.string.customer_order_wait_pay_fail));
                } else {
                    ToastUtil.showCustomerErrorToast(EditTipsPresenter.this.getScopeContext(), str);
                }
            }

            public void paySucceed() {
                ((Contract.AbsEditTipsView) EditTipsPresenter.this.getLogicView()).hideConfirmLoading();
                EditTipsPresenter.this.getScopeContext().getNavigator().finish();
                ToastUtil.showCustomerSuccessToast(EditTipsPresenter.this.getScopeContext(), EditTipsPresenter.this.getContext().getString(R.string.customer_name_pay_success));
                ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateOrder2Monitor(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30794b() {
        ((Contract.AbsEditTipsView) getLogicView()).showLoadError(AbnormalFactory.buildRetryView((int) R.string.customer_net_error_tip, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                EditTipsPresenter.this.m30788a();
            }
        }));
    }
}
