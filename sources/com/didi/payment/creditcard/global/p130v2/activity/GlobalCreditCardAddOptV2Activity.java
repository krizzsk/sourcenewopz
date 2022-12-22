package com.didi.payment.creditcard.global.p130v2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.ConfigProxyHolder;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.web.WebSignParam;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.p129ui.helper.NLEGODialogBuilder;
import com.didi.payment.creditcard.base.binrule.BlackCardRule;
import com.didi.payment.creditcard.base.binrule.CardBinRuleFactory;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.global.activity.GlobalBaseActivity;
import com.didi.payment.creditcard.global.contract.CreditCardAddContract;
import com.didi.payment.creditcard.global.error.ISignErrorHandler;
import com.didi.payment.creditcard.global.error.SignErrorFactory;
import com.didi.payment.creditcard.global.model.SignCardParam;
import com.didi.payment.creditcard.global.model.bean.OCRVerifyInfo;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.ocr.OcrDialogUtil;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.omega.GlobalOmegaErrorCounter;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.p130v2.utils.CheckViewHelperOptV2;
import com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil;
import com.didi.payment.creditcard.global.presenter.GlobalAddAccountPresenter;
import com.didi.payment.creditcard.global.utils.GlobalDialogUtil;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.creditcard.global.utils.WatchViewHelperOpt;
import com.didi.payment.creditcard.global.widget.CardEditText;
import com.didi.payment.creditcard.global.widget.CardTypeSelectOptView;
import com.didi.payment.creditcard.global.widget.CheckTipDialogFragment;
import com.didi.payment.creditcard.global.widget.CreditCardErrorDialog;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.pay.sign.util.SignConstant;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didichuxing.gbankcard.ocr.IScanCardCallback;
import com.didichuxing.gbankcard.ocr.ScanCardHelper;
import com.didichuxing.gbankcard.ocr.ScanCardParam;
import com.didichuxing.gbankcard.ocr.ScanCardResult;
import com.taxis99.R;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.payment.creditcard.global.v2.activity.GlobalCreditCardAddOptV2Activity */
public class GlobalCreditCardAddOptV2Activity extends GlobalBaseActivity implements CreditCardAddContract.IView, CardEditText.OnPasteListener {
    public static final String RESP_EXTRA_CARD_INDEX = "card_index";

    /* renamed from: a */
    private static final String f30516a = "2.0";

    /* renamed from: b */
    private static final String f30517b = "SIGN_PARAM";

    /* renamed from: c */
    private static final int f30518c = 603;

    /* renamed from: d */
    private static final int f30519d = 604;

    /* renamed from: A */
    private CheckViewHelperOptV2 f30520A;

    /* renamed from: B */
    private WatchViewHelperOpt f30521B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f30522C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public String f30523D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public CheckTipDialogFragment f30524E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public ScanCardResult f30525F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f30526G;

    /* renamed from: H */
    private ISignErrorHandler f30527H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public long f30528I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f30529J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public boolean f30530K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public LEGODrawer f30531L;

    /* renamed from: M */
    private FinExtAttrBiz f30532M = new FinExtAttrBiz();
    /* access modifiers changed from: private */

    /* renamed from: N */
    public String f30533N = "0";

    /* renamed from: O */
    private ISignErrorHandler.Callback f30534O = new ISignErrorHandler.Callback() {
        public void onResult(int i, SignResult signResult) {
            if (i == 1) {
                GlobalCreditCardAddOptV2Activity.this.m21500k();
            } else if (i == 2) {
                GlobalCreditCardAddOptV2Activity.this.m21498j();
            } else if (i == 4) {
                GlobalCreditCardAddOptV2Activity.this.m21469a(signResult);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: P */
    public CheckTipDialogFragment.DialogCallback f30535P = new CheckTipDialogFragment.DialogCallback() {
        private EditText mReOpenSoftEditText;

        public void beforeShow() {
            if (GlobalCreditCardAddOptV2Activity.this.f30549r.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptV2Activity.this.f30549r;
            } else if (GlobalCreditCardAddOptV2Activity.this.f30548q.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptV2Activity.this.f30548q;
            } else if (GlobalCreditCardAddOptV2Activity.this.f30547p.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptV2Activity.this.f30547p;
            } else {
                this.mReOpenSoftEditText = null;
            }
        }

        public void afterDismiss() {
            EditText editText = this.mReOpenSoftEditText;
            if (editText != null) {
                InputTools.showKeyboard(editText);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SignCardParam f30536e;

    /* renamed from: f */
    private TextView f30537f;

    /* renamed from: g */
    private TextView f30538g;

    /* renamed from: h */
    private TextView f30539h;

    /* renamed from: i */
    private TextView f30540i;

    /* renamed from: j */
    private ImageView f30541j;

    /* renamed from: k */
    private ImageView f30542k;

    /* renamed from: l */
    private ImageView f30543l;

    /* renamed from: m */
    private ImageView f30544m;

    /* renamed from: n */
    private ImageView f30545n;

    /* renamed from: o */
    private ImageView f30546o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CardEditText f30547p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CardEditText f30548q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public CardEditText f30549r;
    public String retainTips;

    /* renamed from: s */
    private TextView f30550s;
    public String successTips;
    public String successUrl;

    /* renamed from: t */
    private CardTypeSelectOptView f30551t;

    /* renamed from: u */
    private FrameLayout f30552u;

    /* renamed from: v */
    private TextView f30553v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public CreditCardAddContract.IPresenter f30554w;

    /* renamed from: x */
    private ICardBinRule f30555x;

    /* renamed from: y */
    private boolean f30556y;

    /* renamed from: z */
    private String f30557z;

    public void onSignSuccess(String str) {
    }

    public static void launch(Activity activity, int i, SignCardParam signCardParam) {
        if (activity != null) {
            activity.startActivityForResult(getIntent(activity, signCardParam), i);
        }
    }

    public static void launch(Fragment fragment, int i, SignCardParam signCardParam) {
        if (fragment != null && fragment.getActivity() != null) {
            fragment.startActivityForResult(getIntent(fragment.getActivity(), signCardParam), i);
        }
    }

    public static Intent getIntent(Activity activity, SignCardParam signCardParam) {
        Intent intent = new Intent(activity, GlobalCreditCardAddOptV2Activity.class);
        intent.putExtra(f30517b, signCardParam);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_creditcard_global_activity_add_opt_v2);
        m21466a();
        m21475b();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* renamed from: a */
    private void m21466a() {
        String str;
        String str2;
        boolean z;
        String str3;
        int i;
        Intent intent = getIntent();
        if (intent != null) {
            this.f30536e = (SignCardParam) intent.getSerializableExtra(f30517b);
        }
        SignCardParam signCardParam = this.f30536e;
        if (signCardParam == null) {
            traceVendor("", "", "show");
            this.f30536e = new SignCardParam();
        } else {
            traceVendor(signCardParam.resourceId, this.f30536e.vendorType, "show");
        }
        if (TextUtils.isEmpty(this.f30536e.resourceId)) {
            this.f30536e.resourceId = "1";
        }
        this.f30530K = this.f30536e.isUpdateCard();
        this.f30555x = CardBinRuleFactory.createCardBinRule(this, this.f30536e.apolloName);
        GlobalAddAccountPresenter globalAddAccountPresenter = new GlobalAddAccountPresenter(this, f30516a, TextUtils.isEmpty(this.f30536e.discountContent) ^ true ? 1 : 0);
        this.f30554w = globalAddAccountPresenter;
        globalAddAccountPresenter.requestPublicKey(this.f30536e);
        ISignErrorHandler createErrorHandler = SignErrorFactory.createErrorHandler(this, this.f30536e);
        this.f30527H = createErrorHandler;
        createErrorHandler.setCallback(this.f30534O);
        this.f30532M.updateExtAttrs2FinGlobalAttrs(this.f30536e.extOmegaAttrs, FinExtAttrBiz.FROM_ADD_CARD_V2_INIT);
        SignCardParam signCardParam2 = this.f30536e;
        if (signCardParam2 != null) {
            int i2 = signCardParam2.bindType;
            String str4 = this.f30536e.resourceId;
            String str5 = this.f30536e.appId;
            z = !TextUtils.isEmpty(this.f30536e.discountContent);
            i = i2;
            str3 = str4;
            str2 = str5;
            str = this.f30536e.productId;
        } else {
            str3 = "";
            str2 = str3;
            str = str2;
            i = 0;
            z = false;
        }
        GlobalOmegaUtils.trackAddCardPageSW(this, i, f30516a, str3, z ? 1 : 0, str2, str);
        GlobalOmegaErrorCounter.resetValue();
        this.successTips = this.f30536e.successTips;
        this.successUrl = this.f30536e.successUrl;
        this.retainTips = this.f30536e.retainTips;
    }

    /* renamed from: b */
    private void m21475b() {
        int i = this.f30530K ? R.string.one_payment_creditcard_global_update_card : R.string.one_payment_creditcard_global_title;
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.layout_title_bar);
        commonTitleBar.setTitle(i);
        int i2 = 4;
        commonTitleBar.setRightVisible(4);
        commonTitleBar.setTitleBarLineVisible(8);
        commonTitleBar.setVisibility(0);
        commonTitleBar.setLeftImage((int) R.drawable.common_title_bar_btn_back_selector, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptV2Activity.this.onBackPressed();
            }
        });
        this.f30537f = (TextView) findViewById(R.id.tv_card_no_title_error);
        this.f30538g = (TextView) findViewById(R.id.tv_date_title_error);
        this.f30539h = (TextView) findViewById(R.id.tv_cvv_title_error);
        this.f30540i = (TextView) findViewById(R.id.tv_notice_msg);
        this.f30541j = (ImageView) findViewById(R.id.iv_card_icon);
        this.f30542k = (ImageView) findViewById(R.id.iv_camera_icon);
        this.f30543l = (ImageView) findViewById(R.id.iv_clear_icon);
        this.f30544m = (ImageView) findViewById(R.id.iv_date_tip);
        this.f30545n = (ImageView) findViewById(R.id.iv_cvv_tip);
        this.f30551t = (CardTypeSelectOptView) findViewById(R.id.sv_card_type_select);
        this.f30552u = (FrameLayout) findViewById(R.id.fl_discount);
        this.f30553v = (TextView) findViewById(R.id.tv_discount_content);
        this.f30546o = (ImageView) findViewById(R.id.iv_creditcardLogo);
        CardEditText cardEditText = (CardEditText) findViewById(R.id.et_card);
        this.f30547p = cardEditText;
        cardEditText.setType(CardEditText.TYPE.CARD_NUMBER);
        this.f30547p.setMaxLength(23);
        this.f30547p.setOnPasteListener(this);
        String d = m21485d();
        if (!TextUtil.isEmpty(d)) {
            this.f30547p.setHint(d);
        }
        CardEditText cardEditText2 = (CardEditText) findViewById(R.id.et_date);
        this.f30548q = cardEditText2;
        cardEditText2.setMaxLength(5);
        this.f30548q.setType(CardEditText.TYPE.DATE);
        CardEditText cardEditText3 = (CardEditText) findViewById(R.id.et_cvv);
        this.f30549r = cardEditText3;
        cardEditText3.setType(CardEditText.TYPE.CVV);
        this.f30549r.setMaxLength(4);
        int i3 = this.f30530K ? R.string.one_payment_creditcard_global_update : R.string.one_payment_creditcard_global_btn_confirm;
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f30550s = textView;
        textView.setText(i3);
        this.f30550s.setEnabled(false);
        this.f30550s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptV2Activity.this.m21488e();
                GlobalCreditCardAddOptV2Activity globalCreditCardAddOptV2Activity = GlobalCreditCardAddOptV2Activity.this;
                globalCreditCardAddOptV2Activity.m21467a(globalCreditCardAddOptV2Activity.f30530K ? 2 : 1);
            }
        });
        this.f30542k.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                GlobalCreditCardAddOptV2Activity.this.m21476b(603);
                GlobalOmegaUtils.trackOcrPageOcrCk(GlobalCreditCardAddOptV2Activity.this);
                int unused = GlobalCreditCardAddOptV2Activity.this.f30526G = 1;
            }
        });
        this.f30543l.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                GlobalCreditCardAddOptV2Activity.this.f30547p.setText("");
            }
        });
        this.f30524E = new CheckTipDialogFragment(this);
        this.f30544m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptV2Activity.this.f30524E.show(3, GlobalCreditCardAddOptV2Activity.this.f30535P);
            }
        });
        final String string = getResources().getString(R.string.one_payment_creditcard_code_hint_cid);
        this.f30545n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String trim = GlobalCreditCardAddOptV2Activity.this.f30549r.getHint().toString().trim();
                if (string.equals(trim) || trim.length() > 3) {
                    GlobalCreditCardAddOptV2Activity.this.f30524E.show(2, GlobalCreditCardAddOptV2Activity.this.f30535P);
                } else {
                    GlobalCreditCardAddOptV2Activity.this.f30524E.show(1, GlobalCreditCardAddOptV2Activity.this.f30535P);
                }
            }
        });
        boolean z = this.f30536e.isSupportOcr && ScanCardHelper.supportScan(this);
        ImageView imageView = this.f30542k;
        if (z) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        if (!TextUtils.isEmpty(this.f30536e.noticeMsg)) {
            this.f30540i.setText(this.f30536e.noticeMsg);
        } else {
            this.f30540i.setText(R.string.one_payment_creditcard_global_notice_msg);
        }
        CheckViewHelperOptV2 checkViewHelperOptV2 = new CheckViewHelperOptV2(this, this.f30555x, new BlackCardRule(this, this.f30536e.blackCardApolloName));
        this.f30520A = checkViewHelperOptV2;
        WatchViewHelperOpt watchViewHelperOpt = new WatchViewHelperOpt(this.f30555x, checkViewHelperOptV2);
        this.f30521B = watchViewHelperOpt;
        watchViewHelperOpt.initView(this.f30547p, this.f30548q, this.f30549r, this.f30537f, this.f30538g, this.f30539h, this.f30541j, this.f30551t, this.f30550s);
        this.f30521B.watch();
        InputTools.showKeyboard(this.f30547p);
        m21473a(this.f30536e.discountContent);
        m21482c();
    }

    /* renamed from: c */
    private void m21482c() {
        SignCardParam signCardParam = this.f30536e;
        if (signCardParam != null && signCardParam.didi_icon != null && !this.f30536e.didi_icon.isEmpty()) {
            GlideUtils.with2load2into(this, this.f30536e.didi_icon, this.f30546o);
        }
    }

    /* renamed from: d */
    private String m21485d() {
        String str = this.f30536e.cardNo;
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            return null;
        }
        return String.format("···· ···· ···· %s", new Object[]{str.substring(str.length() - 4)});
    }

    /* renamed from: a */
    private void m21473a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f30552u.setVisibility(0);
            this.f30553v.setText(str);
            CreditCardOmegaUtil.Companion.bindCardPasUpShowTrace(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            this.f30557z = intent.getStringExtra(SignConstant.KEY_ADYEN_ERROR_MSG);
        }
        this.f30554w.pollSignResult();
    }

    public Context getContext() {
        return super.getContext();
    }

    public void showLoadingDialog(String str) {
        super.showLoadingDialog(str);
    }

    public void dismissLoadingDialog() {
        super.dismissLoadingDialog();
    }

    public void openCreditCardSignPage(String str, String str2, String str3) {
        WebSignParam webSignParam = new WebSignParam();
        webSignParam.activity = this;
        webSignParam.title = getString(R.string.one_payment_creditcard_pagetitle);
        webSignParam.url = str;
        webSignParam.postData = str2;
        webSignParam.backUrl = str3;
        webSignParam.requestCode = 1;
        WebBrowserUtil.startCreditCardWebActivity(webSignParam);
    }

    public String getSignH5ErrMsg() {
        return this.f30557z;
    }

    public void onSignSuccess(String str, String str2) {
        if (!TextUtils.isEmpty(this.successTips)) {
            m21484c(str);
            return;
        }
        showToastCompleted(str2);
        m21480b(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21480b(String str) {
        Intent intent = new Intent();
        intent.putExtra("card_index", str);
        setResult(-1, intent);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
        EventBus.getDefault().post(new WalletRefreshDataEvent());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f30532M.updateExtAttrs2FinGlobalAttrs(this.f30536e.extOmegaAttrs, FinExtAttrBiz.FROM_ADD_CARD_V2_RESUME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CreditCardAddContract.IPresenter iPresenter = this.f30554w;
        if (iPresenter != null) {
            iPresenter.onDestory();
        }
        super.onDestroy();
    }

    public void showOcrConfirmDialog() {
        OcrDialogUtil.showOrcConfirmDialog(this, new OcrDialogUtil.Callback() {
            public void onCancel() {
            }

            public void onOk() {
                GlobalCreditCardAddOptV2Activity.this.m21476b(604);
            }
        });
    }

    public void onOcrVerifyFailure(OCRVerifyInfo oCRVerifyInfo) {
        ScanCardHelper.onOcrVerifyDone(false);
    }

    public void onOcrVerifySuccess() {
        int i = 1;
        ScanCardHelper.onOcrVerifyDone(true);
        if (this.f30530K) {
            i = 2;
        }
        m21467a(i);
    }

    public void showSignFailureGuideDialog(String str, String str2, String str3, String str4) {
        GlobalOmegaUtils.trackAddCardNetErrorPopupSW(this);
        GlobalDialogUtil.showAddCardFailureGuideDialog(this, str, str2, str3, str4, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackAddCardNetErrorBackBtnCK(GlobalCreditCardAddOptV2Activity.this);
                if (ConfigProxyHolder.getGlobalPageRouterProxy() != null) {
                    ConfigProxyHolder.getGlobalPageRouterProxy().toHomeActivity(GlobalCreditCardAddOptV2Activity.this, true);
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.didi.home");
                    intent.setPackage("com.didiglobal.passenger");
                    intent.setFlags(603979776);
                    GlobalCreditCardAddOptV2Activity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackAddCardNetErrorWaitBtnCK(GlobalCreditCardAddOptV2Activity.this);
            }
        });
    }

    public void showBindFailureDialog(SignResult signResult) {
        CreditCardErrorDialog.Companion.showBindFailureDialog(this, signResult);
    }

    public void showCardUpdateConfirmDialog() {
        this.f30531L = new NLEGODialogBuilder(getActivity()).title(getString(R.string.one_payment_creditcard_dialog_update_confirm_title)).subTitle(getString(R.string.one_payment_creditcard_dialog_update_confirm_content)).confirmAction(getString(R.string.one_payment_creditcard_dialog_update_confirm_positive), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (GlobalCreditCardAddOptV2Activity.this.f30531L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f30531L.dismiss();
                }
                GlobalCreditCardAddOptV2Activity.this.m21467a(2);
            }
        }).negativeAction(getString(R.string.one_payment_creditcard_dialog_update_confirm_negative), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (GlobalCreditCardAddOptV2Activity.this.f30531L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f30531L.dismiss();
                }
            }
        }).build(1).show();
    }

    public void onCybs3DSSuccess(ThreedsCybsDataResponse threedsCybsDataResponse) {
        m21468a(this.f30530K ? 2 : 1, threedsCybsDataResponse);
    }

    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.retainTips)) {
            m21501l();
            return;
        }
        setResult(0);
        finish();
    }

    public void finish() {
        super.finish();
        GlobalOmegaErrorCounter.onSignErrorEvent(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21467a(int i) {
        m21468a(i, (ThreedsCybsDataResponse) null);
    }

    /* renamed from: a */
    private void m21468a(int i, ThreedsCybsDataResponse threedsCybsDataResponse) {
        String textWithoutSpace = this.f30547p.getTextWithoutSpace();
        String textWithoutSpace2 = this.f30548q.getTextWithoutSpace();
        String textWithoutSpace3 = this.f30549r.getTextWithoutSpace();
        ICardBinRule createCardBinRule = CardBinRuleFactory.createCardBinRule(getContext(), this.f30536e.apolloName);
        int cardOrg = createCardBinRule.getCardOrg(textWithoutSpace);
        int cardType = this.f30551t.getCardType();
        int cardType2 = cardType == 0 ? createCardBinRule.getCardType(textWithoutSpace) : cardType;
        CreditCardAddContract.IPresenter iPresenter = this.f30554w;
        boolean z = this.f30522C;
        String str = this.f30523D;
        SignCardParam signCardParam = this.f30536e;
        iPresenter.commit(i, textWithoutSpace, textWithoutSpace2, textWithoutSpace3, cardType2, cardOrg, z, str, signCardParam, signCardParam.resourceId, threedsCybsDataResponse, this.f30533N);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21476b(int i) {
        this.f30529J = System.currentTimeMillis();
        this.f30528I = 0;
        String textWithoutSpace = this.f30547p.getTextWithoutSpace();
        final String textWithoutSpace2 = this.f30548q.getTextWithoutSpace();
        final String textWithoutSpace3 = this.f30549r.getTextWithoutSpace();
        final int cardType = this.f30551t.getCardType();
        if (cardType == 0) {
            cardType = this.f30555x.getCardType(textWithoutSpace);
        }
        String g = m21492g();
        ScanCardParam.Builder builder = new ScanCardParam.Builder(i == 603 ? 0 : 1, PayBaseParamUtil.getStringParam(this, "uid"));
        builder.countryCode(PayBaseParamUtil.getStringParam(this, "country"));
        builder.cardBin(g);
        ScanCardHelper.scan(this, builder.build(), new IScanCardCallback() {
            public void onScanResult(ScanCardResult scanCardResult) {
                long unused = GlobalCreditCardAddOptV2Activity.this.f30528I = System.currentTimeMillis() - GlobalCreditCardAddOptV2Activity.this.f30529J;
                if (scanCardResult.code == 0) {
                    ScanCardResult unused2 = GlobalCreditCardAddOptV2Activity.this.f30525F = scanCardResult;
                    boolean unused3 = GlobalCreditCardAddOptV2Activity.this.f30522C = true;
                    String unused4 = GlobalCreditCardAddOptV2Activity.this.f30523D = scanCardResult.cardNum;
                    int i = scanCardResult.type;
                    if (i == 0) {
                        GlobalCreditCardAddOptV2Activity.this.f30547p.setText(GlobalCreditCardAddOptV2Activity.this.f30523D);
                        GlobalCreditCardAddOptV2Activity.this.f30547p.setSelection(GlobalCreditCardAddOptV2Activity.this.f30547p.length());
                    } else if (i == 1) {
                        GlobalCreditCardAddOptV2Activity.this.f30554w.ocrVerify(GlobalCreditCardAddOptV2Activity.this.f30523D, textWithoutSpace2, textWithoutSpace3, cardType, GlobalCreditCardAddOptV2Activity.this.f30522C, GlobalCreditCardAddOptV2Activity.this.f30523D, GlobalCreditCardAddOptV2Activity.this.f30547p.getTextWithoutSpace(), GlobalCreditCardAddOptV2Activity.this.f30536e, GlobalCreditCardAddOptV2Activity.this.f30533N);
                    }
                } else {
                    SystemUtils.log(3, "CardAdd", "start error: code " + scanCardResult.code, (Throwable) null, "com.didi.payment.creditcard.global.v2.activity.GlobalCreditCardAddOptV2Activity$13", 689);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m21488e() {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(this.f30526G));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.OCR_STATUS, Integer.valueOf(m21489f()));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.MANUAL_INPUT, m21492g());
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.OCR_SESSION, Long.valueOf(this.f30528I));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.SAME_CHECK, Integer.valueOf(m21493h()));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.USER_OCR_RESULT, m21496i());
        GlobalOmegaUtils.trackOcrOperation(this, this.f30536e.bindType, hashMap);
    }

    /* renamed from: f */
    private int m21489f() {
        ScanCardResult scanCardResult = this.f30525F;
        if (scanCardResult == null) {
            return 0;
        }
        int i = scanCardResult.code;
        if (i == 0) {
            return 2;
        }
        switch (i) {
            case 103:
            case 104:
            case 106:
                return 1;
            case 105:
                return 4;
            default:
                return 3;
        }
    }

    /* renamed from: g */
    private String m21492g() {
        String textString = this.f30547p.getTextString();
        if (textString != null) {
            textString = textString.replace(" ", "");
        }
        if (textString == null || textString.length() < 6) {
            return "";
        }
        return textString.substring(0, 6);
    }

    /* renamed from: h */
    private int m21493h() {
        String textString = this.f30547p.getTextString();
        if (textString != null) {
            textString = textString.replace(" ", "");
        }
        return TextUtils.equals(textString, this.f30523D) ? 1 : 0;
    }

    /* renamed from: i */
    private String m21496i() {
        String str = this.f30523D;
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return "";
        }
        String replace = str.replace(" ", "");
        String substring = replace.substring(0, 6);
        String substring2 = replace.substring(replace.length() - 4);
        return substring + substring2;
    }

    public void onSignFail(SignResult signResult) {
        ISignErrorHandler iSignErrorHandler = this.f30527H;
        if (iSignErrorHandler != null) {
            iSignErrorHandler.handleError(signResult);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m21498j() {
        this.f30547p.setText("");
        this.f30549r.setText("");
        this.f30548q.setText("");
        this.f30547p.requestFocus();
        InputTools.showKeyboard(this.f30547p);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m21500k() {
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21469a(SignResult signResult) {
        if (signResult != null && !TextUtils.isEmpty(signResult.faqURL)) {
            WebBrowserUtil.startInternalWebActivity(this, signResult.faqURL, "");
        }
    }

    /* renamed from: l */
    private void m21501l() {
        this.f30531L = new NLEGODialogBuilder(getActivity()).title(this.retainTips).confirmAction(getString(R.string.Fintech_Payment_optimization_Give_up_IWAv), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                CreditCardOmegaUtil.Companion.bindCardGiveUpOkCkTrace(GlobalCreditCardAddOptV2Activity.this.retainTips);
                if (GlobalCreditCardAddOptV2Activity.this.f30531L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f30531L.dismiss();
                }
                GlobalCreditCardAddOptV2Activity.this.setResult(0);
                GlobalCreditCardAddOptV2Activity.this.finish();
            }
        }).negativeAction(getString(R.string.Fintech_Payment_optimization_Stay_on_mWSQ), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                CreditCardOmegaUtil.Companion.bindCardGiveUpCancelCkTrace(GlobalCreditCardAddOptV2Activity.this.retainTips);
                if (GlobalCreditCardAddOptV2Activity.this.f30531L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f30531L.dismiss();
                }
            }
        }).isClickOutsideCanCancel(false).build(1).show();
        CreditCardOmegaUtil.Companion.bindCardGiveUpShowTrace(this.retainTips);
    }

    /* renamed from: c */
    private void m21484c(final String str) {
        this.f30531L = new NLEGODialogBuilder(getActivity()).title(this.successTips).confirmAction(getString(R.string.Fintech_Payment_optimization_To_use_hfam), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                CreditCardOmegaUtil.Companion.bindCardSuccessCkTrace(GlobalCreditCardAddOptV2Activity.this.retainTips);
                if (GlobalCreditCardAddOptV2Activity.this.f30531L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f30531L.dismiss();
                }
                if (!TextUtils.isEmpty(GlobalCreditCardAddOptV2Activity.this.successUrl)) {
                    DRouter.build(GlobalCreditCardAddOptV2Activity.this.successUrl).start(GlobalCreditCardAddOptV2Activity.this);
                }
                GlobalCreditCardAddOptV2Activity.this.m21480b(str);
            }
        }).isShowCloseImage(true).closeAction(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (GlobalCreditCardAddOptV2Activity.this.f30531L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f30531L.dismiss();
                }
                GlobalCreditCardAddOptV2Activity.this.m21480b(str);
            }
        }).setImageResource(R.drawable.one_payment_add_car_succeed_icon).isClickOutsideCanCancel(false).build(1).show();
        CreditCardOmegaUtil.Companion.bindCardSuccessShowTrace(this.retainTips);
    }

    public void onPaste() {
        this.f30533N = "1";
    }
}
