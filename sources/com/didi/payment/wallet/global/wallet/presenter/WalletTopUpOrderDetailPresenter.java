package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.model.resp.WalletTopupOrderConfirmResp;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpPayResultContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopupHistoryActivity;
import com.didi.sdk.sidebar.history.constant.HistoryRecordConstant;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class WalletTopUpOrderDetailPresenter implements WalletTopUpPayResultContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GGKDrawer f32113a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GGKDrawer f32114b;
    protected FragmentActivity mContext;
    protected WalletPayResultResp.PayResultData mData;
    protected String mOrderId;
    protected int mOrderType = -1;
    protected int mPageFrom = -1;
    protected int mProductLine;
    protected WalletTopUpPayResultContract.View mView;
    protected WalletPageModel mWalletPageModel;

    public boolean isSupportCountdonw() {
        return false;
    }

    public void onCancelBtnClick() {
    }

    public WalletTopUpOrderDetailPresenter(FragmentActivity fragmentActivity, WalletTopUpPayResultContract.View view) {
        this.mContext = fragmentActivity;
        this.mView = view;
        this.mWalletPageModel = new WalletPageModel(fragmentActivity);
        Intent intent = fragmentActivity.getIntent();
        if (intent != null) {
            this.mProductLine = intent.getIntExtra("product_line", 0);
            this.mOrderId = intent.getStringExtra("order_id");
            this.mOrderType = intent.getIntExtra("order_type", -1);
            this.mPageFrom = intent.getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
        }
    }

    public boolean isTopupByDriver() {
        return this.mOrderType == 1;
    }

    public boolean isCancelableOrder() {
        return this.mProductLine == 650 && isTopupByDriver();
    }

    public void trackOmega(int i) {
        if (i == 0) {
            PayTracker.trackEvent("ibt_mouton_pax_balance_topup_by_drv_confirmation_sw");
        } else if (i == 1) {
            PayTracker.trackEvent("ibt_mouton_pax_balance_topup_by_drv_confirmation_ck");
        } else if (i == 2) {
            HashMap hashMap = new HashMap();
            int i2 = this.mPageFrom;
            if (i2 == 256) {
                hashMap.put("source_page", HistoryRecordConstant.VAMOS_HISTORY);
            } else if (i2 == 258) {
                hashMap.put("source_page", "amt_page");
            }
            WalletPayResultResp.PayResultData payResultData = this.mData;
            if (payResultData != null) {
                hashMap.put("trip_status", Integer.valueOf(payResultData.tripStatus));
            }
            PayTracker.trackEvent("ibt_gp_didipay_driver_topup_penging_order_detail_sw", hashMap);
        } else if (i == 3) {
            HashMap hashMap2 = new HashMap();
            int i3 = this.mPageFrom;
            if (i3 == 256) {
                hashMap2.put("source_page", HistoryRecordConstant.VAMOS_HISTORY);
            } else if (i3 == 258) {
                hashMap2.put("source_page", "amt_page");
            }
            WalletPayResultResp.PayResultData payResultData2 = this.mData;
            if (payResultData2 != null) {
                hashMap2.put("trip_status", Integer.valueOf(payResultData2.tripStatus));
            }
            PayTracker.trackEvent("ibt_gp_didipay_driver_topup_order_detail_cancel_ck", hashMap2);
        } else if (i == 4) {
            HashMap hashMap3 = new HashMap();
            WalletPayResultResp.PayResultData payResultData3 = this.mData;
            if (payResultData3 != null) {
                hashMap3.put("trip_status", Integer.valueOf(payResultData3.tripStatus));
            }
            PayTracker.trackEvent("ibt_gp_didipay_driver_topup_in_trip_order_detail_sw", hashMap3);
        } else if (i == 5) {
            HashMap hashMap4 = new HashMap();
            WalletPayResultResp.PayResultData payResultData4 = this.mData;
            if (payResultData4 != null) {
                hashMap4.put("trip_status", Integer.valueOf(payResultData4.tripStatus));
            }
            PayTracker.trackEvent("ibt_gp_didipay_driver_topup_order_detail_send_to_driver_ck", hashMap4);
        }
    }

    public void onOperationItemShown(WalletOperationItem walletOperationItem) {
        PayTracker.trackEvent("ibt_didipay_driver_phone_topup_success_signup_sw");
    }

    public void onOperationItemClicked(WalletOperationItem walletOperationItem) {
        PayTracker.trackEvent("ibt_didipay_driver_phone_topup_success_signup_ck");
        if (walletOperationItem != null && !TextUtils.isEmpty(walletOperationItem.linkUrl)) {
            if (walletOperationItem.linkUrl.startsWith("http")) {
                WebBrowserUtil.startInternalWebActivity(this.mContext, walletOperationItem.linkUrl, "");
            } else {
                DRouter.build(walletOperationItem.linkUrl).start((Context) null);
            }
        }
    }

    public void executeTask() {
        this.mView.showLoadingStart();
        this.mView.showLoadingDialog();
        getOrderStatus();
    }

    public void startPollingStatus() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                WalletTopUpOrderDetailPresenter.this.getOrderStatus();
            }
        }, 100);
    }

    /* access modifiers changed from: protected */
    public void getOrderStatus() {
        this.mWalletPageModel.getOrderStatus(this.mProductLine, this.mOrderId, new RpcService.Callback<WalletPayResultResp>() {
            public void onSuccess(WalletPayResultResp walletPayResultResp) {
                if (walletPayResultResp.errno != 0 || walletPayResultResp.data == null) {
                    onFinish((WalletPayResultResp.PayResultData) null);
                    return;
                }
                WalletTopUpOrderDetailPresenter.this.mData = walletPayResultResp.data;
                onFinish(walletPayResultResp.data);
            }

            public void onFailure(IOException iOException) {
                onFinish((WalletPayResultResp.PayResultData) null);
            }

            private void onFinish(WalletPayResultResp.PayResultData payResultData) {
                WalletTopUpOrderDetailPresenter.this.mView.showLoadingFinish(payResultData);
                WalletTopUpOrderDetailPresenter.this.mView.dismissLoadingDialog();
                WalletTopUpOrderDetailPresenter.this.m22794a(payResultData);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22794a(WalletPayResultResp.PayResultData payResultData) {
        if (payResultData != null) {
            if (isCancelableOrder() && payResultData.status == 0) {
                trackOmega(2);
            }
            if (isTopupByDriver() && payResultData.status == 99) {
                trackOmega(4);
            }
            if (this.mProductLine == 605 && isTopupByDriver() && this.mData.status == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("page_source", m22799b());
                FinOmegaSDK.trackEvent("ibt_gp_didipay_drv_phone_topup_pending_order_detail_sw", hashMap);
            }
        }
    }

    public void handleBackClick() {
        if (!WalletApolloUtil.getTopUpIsNew() && this.mProductLine != 99999) {
            WalletRouter.gotoTopUpChannelPage(this.mContext);
        }
        this.mContext.finish();
    }

    public void handleEnterHistory() {
        Bundle bundle = new Bundle();
        bundle.putInt("product_line", this.mProductLine);
        bundle.putInt("order_type", this.mOrderType);
        bundle.putInt("params_topup_confirm_flag", 0);
        WalletTopupHistoryActivity.startActivity((Context) this.mContext, bundle);
        this.mContext.finish();
    }

    public void handleConfirmClick() {
        if (this.mData == null) {
            this.mContext.finish();
        } else if (isCancelableOrder() && this.mData.status == 0) {
            trackOmega(3);
            m22793a();
        } else if (isTopupByDriver() && this.mData.status == 99) {
            trackOmega(5);
            send2Driver();
        }
    }

    /* renamed from: a */
    private void m22793a() {
        String string = this.mContext.getString(R.string.GRider_Riders_Are_you_mQmY);
        String string2 = this.mContext.getString(R.string.GRider_Riders_Confirmation_aCEH);
        String string3 = this.mContext.getString(R.string.GRider_Riders_Return_ixVw);
        C112273 r3 = new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (WalletTopUpOrderDetailPresenter.this.f32113a != null) {
                    WalletTopUpOrderDetailPresenter.this.f32113a.dismiss();
                }
                WalletTopUpOrderDetailPresenter.this.m22797a((Runnable) new Runnable() {
                    public void run() {
                        WalletTopUpOrderDetailPresenter.this.toHistoryPage(true);
                    }
                });
            }
        };
        C112294 r4 = new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (WalletTopUpOrderDetailPresenter.this.f32113a != null) {
                    WalletTopUpOrderDetailPresenter.this.f32113a.dismiss();
                }
            }
        };
        C112305 r5 = new GGKDrawerModel1(string, new GGKBtnTextAndCallback(string2, r3)) {
            /* access modifiers changed from: protected */
            public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
                gGKDrawerModel.isTwoBtnHorizontal = true;
                return gGKDrawerModel;
            }
        };
        r5.addMinorBtn(new GGKBtnTextAndCallback(string3, r4));
        this.f32113a = GGKUICreatorWithThemeCheck.showDrawerModel(this.mContext, r5);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22797a(final Runnable runnable) {
        this.mView.showLoadingDialog();
        this.mWalletPageModel.closeOrder(this.mProductLine, this.mOrderId, new RpcService.Callback<WBaseResp>() {
            public void onSuccess(WBaseResp wBaseResp) {
                WalletTopUpOrderDetailPresenter.this.mView.dismissLoadingDialog();
                if (wBaseResp != null) {
                    if (wBaseResp.errno == 0) {
                        Runnable runnable = runnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                    } else if (!TextUtils.isEmpty(wBaseResp.errmsg)) {
                        WalletToast.showFailedMsg(WalletTopUpOrderDetailPresenter.this.mContext, wBaseResp.errmsg);
                    } else {
                        WalletToast.showFailedMsg(WalletTopUpOrderDetailPresenter.this.mContext, ResourcesHelper.getString(WalletTopUpOrderDetailPresenter.this.mContext, R.string.pay_base_network_error));
                    }
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpOrderDetailPresenter.this.mView.dismissLoadingDialog();
                WalletToast.showFailedMsg(WalletTopUpOrderDetailPresenter.this.mContext, ResourcesHelper.getString(WalletTopUpOrderDetailPresenter.this.mContext, R.string.pay_base_network_error));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void send2Driver() {
        GGKDrawerModel1 gGKDrawerModel1 = new GGKDrawerModel1(this.mContext.getString(R.string.GRider_Riders_Trip_cash_JLkS), new GGKBtnTextAndCallback(this.mContext.getString(R.string.wallet_dialog_ok_ok), new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                WalletTopUpOrderDetailPresenter.this.trackOmega(1);
                WalletTopUpOrderDetailPresenter.this.confirmSend2Driver();
                if (WalletTopUpOrderDetailPresenter.this.f32114b != null) {
                    WalletTopUpOrderDetailPresenter.this.f32114b.dismiss();
                }
            }
        }));
        gGKDrawerModel1.setSubTitle(this.mContext.getString(R.string.GRider_Riders_Pay_check_Tcff));
        this.f32114b = GGKUICreatorWithThemeCheck.showDrawerModel(this.mContext, gGKDrawerModel1);
        trackOmega(0);
    }

    /* access modifiers changed from: protected */
    public void confirmSend2Driver() {
        this.mView.showLoadingDialog();
        this.mWalletPageModel.sendTopupOrder2Driver(this.mProductLine, this.mOrderId, new RpcService.Callback<WalletTopupOrderConfirmResp>() {
            public void onSuccess(WalletTopupOrderConfirmResp walletTopupOrderConfirmResp) {
                WalletTopUpOrderDetailPresenter.this.mView.dismissLoadingDialog();
                WalletTopUpOrderDetailPresenter.this.toHistoryPage();
            }

            public void onFailure(IOException iOException) {
                WalletTopUpOrderDetailPresenter.this.mView.dismissLoadingDialog();
            }
        });
    }

    /* renamed from: b */
    private String m22799b() {
        int intExtra = this.mContext.getIntent().getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
        if (intExtra == 258) {
            return "amount_select";
        }
        return intExtra == 256 ? "hisotry" : "push";
    }

    /* access modifiers changed from: protected */
    public void toHistoryPage(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("product_line", this.mProductLine);
        if (!z) {
            bundle.putInt("params_topup_confirm_flag", 1);
        }
        WalletTopupHistoryActivity.startActivity((Context) this.mContext, bundle);
        this.mContext.finish();
    }

    /* access modifiers changed from: protected */
    public void toHistoryPage() {
        toHistoryPage(false);
    }
}
