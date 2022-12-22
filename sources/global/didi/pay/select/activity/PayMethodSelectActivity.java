package global.didi.pay.select.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.util.ABTestProxyHolder;
import com.taxis99.R;
import global.didi.pay.select.GlobalWalletParam;
import global.didi.pay.select.model.PayMethodItemInfo;
import global.didi.pay.select.model.PayMethodPageInfo;
import global.didi.pay.select.presenter.PayMethodSelectPresenter;
import global.didi.pay.select.view.base.IPayMethodListView;
import global.didi.pay.select.view.base.IPayMethodPageEventListener;
import global.didi.pay.select.view.brazil.BrazilPayMethodPageView;
import global.didi.pay.select.view.other.PayMethodPageView;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;
import global.didi.pay.view.dialog.tip.GlobalPayTipDialog;
import global.didi.pay.web.UniPayWebModel;
import global.didi.pay.web.UniPayWebUtil;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PayMethodSelectActivity extends BasePayMethodListActivity {
    public static final int PAGE_TYPE_NORMAL = 1;
    public static final int PAGE_TYPE_THIRD_SHOW_ERROR = 2;
    public static final int REQ_CODE_ADD_CARD = 1;
    public static final int REQ_CODE_ADD_PAYPAL = 3;
    public static final int REQ_CODE_TOPUP_AMOUNT = 8;
    public static final int REQ_CODE_TOPUP_CHANNEL = 10;
    public static final int REQ_CODE_VERIFY_BALANCE = 6;
    /* access modifiers changed from: private */
    public boolean mFromEmpty;
    private IPayMethodListView<PayMethodPageInfo> mPayMethodListPageView;
    private GlobalPayTipDialog mPayTipDialog;
    protected PayMethodSelectPresenter mPresenter;
    /* access modifiers changed from: private */
    public PayMethodItemInfo mSelectItemInfo;

    public static Intent createIntent(Context context, PayMethodPageInfo payMethodPageInfo, PayParam payParam, String str, int i) {
        Intent intent = new Intent(context, PayMethodSelectActivity.class);
        intent.putExtra("pay_method_list_param", payMethodPageInfo);
        intent.putExtra("pay_param", payParam);
        intent.putExtra(GlobalWalletParam.Extra.PAY_ADD_CARD_INSTALLMENT, str);
        intent.putExtra("page_type", i);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        if (isGroupSwitchOpen()) {
            initStatusBar(R.color.oc_color_F3F4F5);
        } else {
            initStatusBar(R.color.white);
        }
        super.onCreate(bundle);
        initBase();
        initView();
        initData();
        initClickListener();
        EventBus.getDefault().register(this);
        if (this.mPageType != 2 || this.mPageInfo == null || this.mPageInfo.headInfo == null) {
            this.mOmegaManager.trackPayMethodSelectPageSW(this.mContext, this.mPresenter.getOmegaSource(), this.mPresenter.getOmegaDefaultPayment());
        } else {
            this.mOmegaManager.trackPayMethodThirdSDKSelectPageSW(this.mPageInfo.headInfo.content);
        }
    }

    private void initView() {
        if (isGroupSwitchOpen()) {
            this.mPayMethodListPageView = new BrazilPayMethodPageView(this);
        } else {
            this.mPayMethodListPageView = new PayMethodPageView(this);
        }
        setContentView((View) this.mPayMethodListPageView);
    }

    private boolean isGroupSwitchOpen() {
        return ABTestProxyHolder.getPayMethodGroupSwitch() != null && ABTestProxyHolder.getPayMethodGroupSwitch().isAllowPayMethodGroup();
    }

    private void initData() {
        PayMethodSelectPresenter payMethodSelectPresenter = new PayMethodSelectPresenter(this);
        this.mPresenter = payMethodSelectPresenter;
        payMethodSelectPresenter.setView(this.mPayMethodListPageView);
        this.mPresenter.initData(this.mPageInfo, this.mInstallmentAddcard);
    }

    private void initClickListener() {
        this.mPayMethodListPageView.setPayMethodPageEventListener(new IPayMethodPageEventListener<PayMethodItemInfo, PayMethodPageInfo>() {
            public void onPayMethodClickEvent(View view, PayMethodItemInfo payMethodItemInfo) {
                if (payMethodItemInfo != null) {
                    if (view.getId() == R.id.iv_paymethod_desc_tip) {
                        PayMethodSelectActivity.this.showPayTipDialog(payMethodItemInfo.subTitleTip);
                        return;
                    }
                    PayMethodSelectActivity.this.mOmegaManager.trackPayMethodSelectPageChannelCK(PayMethodSelectActivity.this.mContext, payMethodItemInfo.channelId, PayMethodSelectActivity.this.mPresenter.getOmegaSource(), PayMethodSelectActivity.this.mPresenter.getOmegaClickType(payMethodItemInfo), PayMethodSelectActivity.this.mPresenter.getOmegaCardCount(), PayMethodSelectActivity.this.mPresenter.getOmegaDefaultPaymentName(), PayMethodSelectActivity.this.mPresenter.getOmegaHas99Balance());
                    int i = payMethodItemInfo.channelId;
                    if (i == 150) {
                        PayMethodSelectActivity.this.mPresenter.jumpToCreditCardActivity(payMethodItemInfo);
                    } else if (i == 152) {
                        PayMethodSelectActivity.this.mPresenter.jumpToPayPalPage(payMethodItemInfo);
                    } else if (i == 190) {
                        PayMethodSelectActivity.this.mPresenter.jumpToNineNinePayPage(payMethodItemInfo, PayMethodSelectActivity.this.mOmegaManager.getOmegaAttr(GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE));
                    } else if (i == 182) {
                        PayMethodSelectActivity.this.mPresenter.jumpToPayPayPage(payMethodItemInfo);
                    } else if (i == 183) {
                        PayMethodSelectActivity.this.mPresenter.jumpToNewPayPalPage(payMethodItemInfo);
                    }
                }
            }

            public void onPayMethodSelectEvent(View view, PayMethodItemInfo payMethodItemInfo) {
                if (payMethodItemInfo == null) {
                    PayMethodSelectActivity.this.onBackPressed();
                } else if (view.getId() == R.id.iv_paymethod_desc_tip) {
                    PayMethodSelectActivity.this.showPayTipDialog(payMethodItemInfo.subTitleTip);
                } else {
                    PayMethodItemInfo unused = PayMethodSelectActivity.this.mSelectItemInfo = payMethodItemInfo;
                    PayMethodSelectActivity.this.mOmegaManager.trackPayMethodSelectPageChannelCK(PayMethodSelectActivity.this.mContext, payMethodItemInfo.channelId, PayMethodSelectActivity.this.mPresenter.getOmegaSource(), PayMethodSelectActivity.this.mPresenter.getOmegaClickType(payMethodItemInfo), PayMethodSelectActivity.this.mPresenter.getOmegaCardCount(), PayMethodSelectActivity.this.mPresenter.getOmegaDefaultPaymentName(), PayMethodSelectActivity.this.mPresenter.getOmegaHas99Balance());
                    int i = payMethodItemInfo.channelId;
                    if (!(i == 121 || i == 150 || i == 152 || i == 175 || i == 178 || i == 190 || i == 2005 || i == 182 || i == 183)) {
                        switch (i) {
                            case 200:
                            case 201:
                            case 202:
                            case 203:
                            case 204:
                            case 205:
                                break;
                            default:
                                switch (i) {
                                    case 212:
                                    case 213:
                                    case 214:
                                    case 215:
                                        break;
                                    default:
                                        return;
                                }
                        }
                    }
                    PayMethodSelectActivity.this.onBackPressed();
                }
            }

            public void onPageClickEvent(View view, PayMethodPageInfo payMethodPageInfo) {
                int id = view.getId();
                if (String.valueOf(view.getTag()).equals("add_card")) {
                    PayMethodSelectActivity.this.mPresenter.jumpToAddCreditCardActivity();
                    PayMethodSelectActivity.this.mOmegaManager.trackPayMethodBindCardCk(PayMethodSelectActivity.this.mContext, PayMethodSelectActivity.this.mPresenter.getOmegaAppid(), PayMethodSelectActivity.this.mPresenter.getOmegaProductid());
                } else if (id == R.id.ll_empty) {
                    boolean unused = PayMethodSelectActivity.this.mFromEmpty = true;
                    PayMethodSelectActivity.this.mPresenter.requestDataFromServer();
                } else if (id == R.id.iv_close) {
                    PayMethodSelectActivity.this.mOmegaManager.trackPayMethodSelectPageReturnCK(PayMethodSelectActivity.this.mContext, PayMethodSelectActivity.this.mPresenter.getOmegaSource());
                    PayMethodSelectActivity.this.onBackPressed();
                }
            }

            public void onFrozenTitleClick(String str) {
                if (PayMethodSelectActivity.this.mPayParam != null && !TextUtils.isEmpty(str)) {
                    UniPayWebModel uniPayWebModel = new UniPayWebModel();
                    uniPayWebModel.context = PayMethodSelectActivity.this.mContext;
                    uniPayWebModel.url = str;
                    uniPayWebModel.sid = PayMethodSelectActivity.this.mPayParam.sid;
                    uniPayWebModel.intentFlag = View.STATUS_BAR_TRANSIENT;
                    uniPayWebModel.requestCode = -1;
                    UniPayWebUtil.startWebPage(uniPayWebModel, PayMethodSelectActivity.this);
                }
            }
        });
    }

    public void onBackPressed() {
        setResult(this.mSelectItemInfo);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = "";
        if (i != 1) {
            if (i != 3) {
                if (i != 6) {
                    if (i != 8) {
                        if (i == 10 && i2 == -1) {
                            this.mPresenter.requestDataFromServer(190, str, i);
                            return;
                        }
                        return;
                    } else if (i2 == -1) {
                        this.mPresenter.requestDataFromServer(190, str, i);
                        return;
                    } else {
                        return;
                    }
                }
            } else if (i2 == -1 && intent != null && intent.getIntExtra("errno", -1) == 0) {
                this.mPresenter.requestDataFromServer(152, str, i);
                return;
            } else {
                return;
            }
        }
        if (i2 == -1) {
            if (intent != null) {
                str = intent.getStringExtra("card_index");
            }
            this.mPresenter.requestDataFromServer(150, str, i);
        }
    }

    @Subscribe
    public void onEvent(PayMethodPageInfo payMethodPageInfo) {
        if (payMethodPageInfo != null) {
            this.mPresenter.initData(payMethodPageInfo, (String) null);
            if (!this.mFromEmpty) {
                this.mSelectItemInfo = null;
                this.mFromEmpty = false;
                onBackPressed();
            }
        }
    }

    @Subscribe
    public void onEvent(PayMethodItemInfo payMethodItemInfo) {
        if (payMethodItemInfo != null) {
            setResult(payMethodItemInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: private */
    public void showPayTipDialog(String str) {
        if (this.mPayTipDialog == null) {
            this.mPayTipDialog = GlobalPayTipDialog.createDialog(this.mContext);
        }
        if (!this.mPayTipDialog.isShowing()) {
            UnifiedPayDialogConfig unifiedPayDialogConfig = UnifiedPayDialogConfig.TIP_PAY_METHOD_SELECT;
            unifiedPayDialogConfig.setContent(str);
            this.mPayTipDialog.setConfig(unifiedPayDialogConfig);
            SystemUtils.showDialog(this.mPayTipDialog);
        }
    }
}
