package com.didi.payment.creditcard.global.activity;

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
import com.didi.payment.base.event.home.MapEventKey;
import com.didi.payment.base.event.home.MapEventManager;
import com.didi.payment.base.proxy.ConfigProxyHolder;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.web.WebSignParam;
import com.didi.payment.creditcard.base.binrule.BlackCardRule;
import com.didi.payment.creditcard.base.binrule.CardBinRuleFactory;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
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
import com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil;
import com.didi.payment.creditcard.global.presenter.GlobalAddAccountPresenter;
import com.didi.payment.creditcard.global.utils.CheckViewHelperOpt;
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

public class GlobalCreditCardAddOptActivity extends GlobalBaseActivity implements CreditCardAddContract.IView, CardEditText.OnPasteListener {
    public static final String RESP_EXTRA_CARD_INDEX = "card_index";

    /* renamed from: a */
    private static final String f30299a = "2.0";

    /* renamed from: b */
    private static final String f30300b = "SIGN_PARAM";

    /* renamed from: c */
    private static final int f30301c = 603;

    /* renamed from: d */
    private static final int f30302d = 604;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f30303A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String f30304B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public CheckTipDialogFragment f30305C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ScanCardResult f30306D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f30307E;

    /* renamed from: F */
    private ISignErrorHandler f30308F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public long f30309G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public long f30310H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public boolean f30311I;

    /* renamed from: J */
    private FinExtAttrBiz f30312J = new FinExtAttrBiz();
    /* access modifiers changed from: private */

    /* renamed from: K */
    public String f30313K = "0";

    /* renamed from: L */
    private ISignErrorHandler.Callback f30314L = new ISignErrorHandler.Callback() {
        public void onResult(int i, SignResult signResult) {
            if (i == 1) {
                GlobalCreditCardAddOptActivity.this.m21305j();
            } else if (i == 2) {
                GlobalCreditCardAddOptActivity.this.m21303i();
            } else if (i == 4) {
                GlobalCreditCardAddOptActivity.this.m21282a(signResult);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: M */
    public CheckTipDialogFragment.DialogCallback f30315M = new CheckTipDialogFragment.DialogCallback() {
        private EditText mReOpenSoftEditText;

        public void beforeShow() {
            if (GlobalCreditCardAddOptActivity.this.f30327p.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptActivity.this.f30327p;
            } else if (GlobalCreditCardAddOptActivity.this.f30326o.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptActivity.this.f30326o;
            } else if (GlobalCreditCardAddOptActivity.this.f30325n.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptActivity.this.f30325n;
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
    public SignCardParam f30316e;

    /* renamed from: f */
    private TextView f30317f;

    /* renamed from: g */
    private TextView f30318g;

    /* renamed from: h */
    private TextView f30319h;

    /* renamed from: i */
    private TextView f30320i;

    /* renamed from: j */
    private ImageView f30321j;

    /* renamed from: k */
    private ImageView f30322k;

    /* renamed from: l */
    private ImageView f30323l;

    /* renamed from: m */
    private ImageView f30324m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CardEditText f30325n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public CardEditText f30326o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CardEditText f30327p;

    /* renamed from: q */
    private TextView f30328q;

    /* renamed from: r */
    private CardTypeSelectOptView f30329r;

    /* renamed from: s */
    private FrameLayout f30330s;

    /* renamed from: t */
    private TextView f30331t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public CreditCardAddContract.IPresenter f30332u;

    /* renamed from: v */
    private ICardBinRule f30333v;

    /* renamed from: w */
    private boolean f30334w;

    /* renamed from: x */
    private String f30335x;

    /* renamed from: y */
    private CheckViewHelperOpt f30336y;

    /* renamed from: z */
    private WatchViewHelperOpt f30337z;

    public void onSignSuccess(String str, String str2) {
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
        Intent intent = new Intent(activity, GlobalCreditCardAddOptActivity.class);
        intent.putExtra(f30300b, signCardParam);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_creditcard_global_activity_add_opt);
        m21276a();
        m21285b();
    }

    /* renamed from: a */
    private void m21276a() {
        String str;
        String str2;
        boolean z;
        String str3;
        int i;
        Intent intent = getIntent();
        if (intent != null) {
            this.f30316e = (SignCardParam) intent.getSerializableExtra(f30300b);
        }
        SignCardParam signCardParam = this.f30316e;
        if (signCardParam == null) {
            traceVendor("", "", "show");
            this.f30316e = new SignCardParam();
        } else {
            traceVendor(signCardParam.resourceId, this.f30316e.vendorType, "show");
        }
        if (TextUtils.isEmpty(this.f30316e.resourceId)) {
            this.f30316e.resourceId = "1";
        }
        this.f30311I = this.f30316e.isUpdateCard();
        this.f30333v = CardBinRuleFactory.createCardBinRule(this, this.f30316e.apolloName);
        GlobalAddAccountPresenter globalAddAccountPresenter = new GlobalAddAccountPresenter(this, f30299a, TextUtils.isEmpty(this.f30316e.discountContent) ^ true ? 1 : 0);
        this.f30332u = globalAddAccountPresenter;
        globalAddAccountPresenter.requestPublicKey(this.f30316e);
        ISignErrorHandler createErrorHandler = SignErrorFactory.createErrorHandler(this, this.f30316e);
        this.f30308F = createErrorHandler;
        createErrorHandler.setCallback(this.f30314L);
        this.f30312J.updateExtAttrs2FinGlobalAttrs(this.f30316e.extOmegaAttrs, FinExtAttrBiz.FROM_ADD_CARD_INIT);
        SignCardParam signCardParam2 = this.f30316e;
        if (signCardParam2 != null) {
            int i2 = signCardParam2.bindType;
            String str4 = this.f30316e.resourceId;
            String str5 = this.f30316e.appId;
            z = !TextUtils.isEmpty(this.f30316e.discountContent);
            i = i2;
            str3 = str4;
            str2 = str5;
            str = this.f30316e.productId;
        } else {
            str3 = "";
            str2 = str3;
            str = str2;
            i = 0;
            z = false;
        }
        GlobalOmegaUtils.trackAddCardPageSW(this, i, f30299a, str3, z ? 1 : 0, str2, str);
        GlobalOmegaErrorCounter.resetValue();
    }

    /* renamed from: b */
    private void m21285b() {
        int i = this.f30311I ? R.string.one_payment_creditcard_global_update_card : R.string.one_payment_creditcard_global_title;
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.layout_title_bar);
        commonTitleBar.setTitle(i);
        commonTitleBar.setRightVisible(4);
        int i2 = 8;
        commonTitleBar.setTitleBarLineVisible(8);
        commonTitleBar.setVisibility(0);
        commonTitleBar.setLeftImage((int) R.drawable.common_title_bar_btn_back_selector, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptActivity.this.onBackPressed();
            }
        });
        this.f30317f = (TextView) findViewById(R.id.tv_card_no_title);
        this.f30318g = (TextView) findViewById(R.id.tv_date_title);
        this.f30319h = (TextView) findViewById(R.id.tv_cvv_title);
        this.f30320i = (TextView) findViewById(R.id.tv_notice_msg);
        this.f30321j = (ImageView) findViewById(R.id.iv_card_icon);
        this.f30322k = (ImageView) findViewById(R.id.iv_camera_icon);
        this.f30323l = (ImageView) findViewById(R.id.iv_date_tip);
        this.f30324m = (ImageView) findViewById(R.id.iv_cvv_tip);
        this.f30329r = (CardTypeSelectOptView) findViewById(R.id.sv_card_type_select);
        this.f30330s = (FrameLayout) findViewById(R.id.fl_discount);
        this.f30331t = (TextView) findViewById(R.id.tv_discount_content);
        CardEditText cardEditText = (CardEditText) findViewById(R.id.et_card);
        this.f30325n = cardEditText;
        cardEditText.setType(CardEditText.TYPE.CARD_NUMBER);
        this.f30325n.setMaxLength(23);
        this.f30325n.setOnPasteListener(this);
        String c = m21290c();
        if (!TextUtil.isEmpty(c)) {
            this.f30325n.setHint(c);
        }
        CardEditText cardEditText2 = (CardEditText) findViewById(R.id.et_date);
        this.f30326o = cardEditText2;
        cardEditText2.setMaxLength(5);
        this.f30326o.setType(CardEditText.TYPE.DATE);
        CardEditText cardEditText3 = (CardEditText) findViewById(R.id.et_cvv);
        this.f30327p = cardEditText3;
        cardEditText3.setType(CardEditText.TYPE.CVV);
        this.f30327p.setMaxLength(4);
        int i3 = this.f30311I ? R.string.one_payment_creditcard_global_update : R.string.one_payment_creditcard_global_btn_confirm;
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f30328q = textView;
        textView.setText(i3);
        this.f30328q.setEnabled(false);
        this.f30328q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptActivity.this.m21292d();
                GlobalCreditCardAddOptActivity globalCreditCardAddOptActivity = GlobalCreditCardAddOptActivity.this;
                globalCreditCardAddOptActivity.m21277a(globalCreditCardAddOptActivity.f30311I ? 2 : 1);
            }
        });
        this.f30322k.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                GlobalCreditCardAddOptActivity.this.m21286b(603);
                GlobalOmegaUtils.trackOcrPageOcrCk(GlobalCreditCardAddOptActivity.this);
                int unused = GlobalCreditCardAddOptActivity.this.f30307E = 1;
            }
        });
        this.f30305C = new CheckTipDialogFragment(this);
        this.f30323l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptActivity.this.f30305C.show(3, GlobalCreditCardAddOptActivity.this.f30315M);
            }
        });
        final String string = getResources().getString(R.string.one_payment_creditcard_code_hint_cid);
        this.f30324m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String trim = GlobalCreditCardAddOptActivity.this.f30327p.getHint().toString().trim();
                if (string.equals(trim) || trim.length() > 3) {
                    GlobalCreditCardAddOptActivity.this.f30305C.show(2, GlobalCreditCardAddOptActivity.this.f30315M);
                } else {
                    GlobalCreditCardAddOptActivity.this.f30305C.show(1, GlobalCreditCardAddOptActivity.this.f30315M);
                }
            }
        });
        boolean z = this.f30316e.isSupportOcr && ScanCardHelper.supportScan(this);
        ImageView imageView = this.f30322k;
        if (z) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        if (!TextUtils.isEmpty(this.f30316e.noticeMsg)) {
            this.f30320i.setText(this.f30316e.noticeMsg);
        } else {
            this.f30320i.setText(R.string.one_payment_creditcard_global_notice_msg);
        }
        CheckViewHelperOpt checkViewHelperOpt = new CheckViewHelperOpt(this, this.f30333v, new BlackCardRule(this, this.f30316e.blackCardApolloName));
        this.f30336y = checkViewHelperOpt;
        WatchViewHelperOpt watchViewHelperOpt = new WatchViewHelperOpt(this.f30333v, checkViewHelperOpt);
        this.f30337z = watchViewHelperOpt;
        watchViewHelperOpt.initView(this.f30325n, this.f30326o, this.f30327p, this.f30317f, this.f30318g, this.f30319h, this.f30321j, this.f30329r, this.f30328q);
        this.f30337z.watch();
        InputTools.showKeyboard(this.f30325n);
        m21283a(this.f30316e.discountContent);
    }

    /* renamed from: c */
    private String m21290c() {
        String str = this.f30316e.cardNo;
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            return null;
        }
        return String.format("···· ···· ···· %s", new Object[]{str.substring(str.length() - 4)});
    }

    /* renamed from: a */
    private void m21283a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f30330s.setVisibility(0);
            this.f30331t.setText(str);
            CreditCardOmegaUtil.Companion.bindCardPasUpShowTrace(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            this.f30335x = intent.getStringExtra(SignConstant.KEY_ADYEN_ERROR_MSG);
        }
        this.f30332u.pollSignResult();
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
        return this.f30335x;
    }

    public void onSignSuccess(String str) {
        Intent intent = new Intent();
        intent.putExtra("card_index", str);
        setResult(-1, intent);
        MapEventManager.INSTANCE.postWalletEvent(MapEventKey.WALLET_HOME_BANK);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f30312J.updateExtAttrs2FinGlobalAttrs(this.f30316e.extOmegaAttrs, FinExtAttrBiz.FROM_ADD_CARD_RESUME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CreditCardAddContract.IPresenter iPresenter = this.f30332u;
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
                GlobalCreditCardAddOptActivity.this.m21286b(604);
            }
        });
    }

    public void onOcrVerifyFailure(OCRVerifyInfo oCRVerifyInfo) {
        ScanCardHelper.onOcrVerifyDone(false);
    }

    public void onOcrVerifySuccess() {
        int i = 1;
        ScanCardHelper.onOcrVerifyDone(true);
        if (this.f30311I) {
            i = 2;
        }
        m21277a(i);
    }

    public void showSignFailureGuideDialog(String str, String str2, String str3, String str4) {
        GlobalOmegaUtils.trackAddCardNetErrorPopupSW(this);
        GlobalDialogUtil.showAddCardFailureGuideDialog(this, str, str2, str3, str4, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackAddCardNetErrorBackBtnCK(GlobalCreditCardAddOptActivity.this);
                if (ConfigProxyHolder.getGlobalPageRouterProxy() != null) {
                    ConfigProxyHolder.getGlobalPageRouterProxy().toHomeActivity(GlobalCreditCardAddOptActivity.this, true);
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.didi.home");
                    intent.setPackage("com.didiglobal.passenger");
                    intent.setFlags(603979776);
                    GlobalCreditCardAddOptActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackAddCardNetErrorWaitBtnCK(GlobalCreditCardAddOptActivity.this);
            }
        });
    }

    public void showBindFailureDialog(SignResult signResult) {
        CreditCardErrorDialog.Companion.showBindFailureDialog(this, signResult);
    }

    public void showCardUpdateConfirmDialog() {
        GlobalDialogUtil.showCardUpdateDialog(this, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptActivity.this.m21277a(2);
            }
        }, (View.OnClickListener) null);
    }

    public void onCybs3DSSuccess(ThreedsCybsDataResponse threedsCybsDataResponse) {
        m21278a(this.f30311I ? 2 : 1, threedsCybsDataResponse);
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    public void finish() {
        super.finish();
        GlobalOmegaErrorCounter.onSignErrorEvent(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21277a(int i) {
        m21278a(i, (ThreedsCybsDataResponse) null);
    }

    /* renamed from: a */
    private void m21278a(int i, ThreedsCybsDataResponse threedsCybsDataResponse) {
        String textWithoutSpace = this.f30325n.getTextWithoutSpace();
        String textWithoutSpace2 = this.f30326o.getTextWithoutSpace();
        String textWithoutSpace3 = this.f30327p.getTextWithoutSpace();
        ICardBinRule createCardBinRule = CardBinRuleFactory.createCardBinRule(getContext(), this.f30316e.apolloName);
        int cardOrg = createCardBinRule.getCardOrg(textWithoutSpace);
        int cardType = this.f30329r.getCardType();
        int cardType2 = cardType == 0 ? createCardBinRule.getCardType(textWithoutSpace) : cardType;
        CreditCardAddContract.IPresenter iPresenter = this.f30332u;
        boolean z = this.f30303A;
        String str = this.f30304B;
        SignCardParam signCardParam = this.f30316e;
        iPresenter.commit(i, textWithoutSpace, textWithoutSpace2, textWithoutSpace3, cardType2, cardOrg, z, str, signCardParam, signCardParam.resourceId, threedsCybsDataResponse, this.f30313K);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21286b(int i) {
        this.f30310H = System.currentTimeMillis();
        this.f30309G = 0;
        String textWithoutSpace = this.f30325n.getTextWithoutSpace();
        final String textWithoutSpace2 = this.f30326o.getTextWithoutSpace();
        final String textWithoutSpace3 = this.f30327p.getTextWithoutSpace();
        final int cardType = this.f30329r.getCardType();
        if (cardType == 0) {
            cardType = this.f30333v.getCardType(textWithoutSpace);
        }
        String f = m21297f();
        ScanCardParam.Builder builder = new ScanCardParam.Builder(i == 603 ? 0 : 1, PayBaseParamUtil.getStringParam(this, "uid"));
        builder.countryCode(PayBaseParamUtil.getStringParam(this, "country"));
        builder.cardBin(f);
        ScanCardHelper.scan(this, builder.build(), new IScanCardCallback() {
            public void onScanResult(ScanCardResult scanCardResult) {
                long unused = GlobalCreditCardAddOptActivity.this.f30309G = System.currentTimeMillis() - GlobalCreditCardAddOptActivity.this.f30310H;
                if (scanCardResult.code == 0) {
                    ScanCardResult unused2 = GlobalCreditCardAddOptActivity.this.f30306D = scanCardResult;
                    boolean unused3 = GlobalCreditCardAddOptActivity.this.f30303A = true;
                    String unused4 = GlobalCreditCardAddOptActivity.this.f30304B = scanCardResult.cardNum;
                    int i = scanCardResult.type;
                    if (i == 0) {
                        GlobalCreditCardAddOptActivity.this.f30325n.setText(GlobalCreditCardAddOptActivity.this.f30304B);
                        GlobalCreditCardAddOptActivity.this.f30325n.setSelection(GlobalCreditCardAddOptActivity.this.f30325n.length());
                    } else if (i == 1) {
                        GlobalCreditCardAddOptActivity.this.f30332u.ocrVerify(GlobalCreditCardAddOptActivity.this.f30304B, textWithoutSpace2, textWithoutSpace3, cardType, GlobalCreditCardAddOptActivity.this.f30303A, GlobalCreditCardAddOptActivity.this.f30304B, GlobalCreditCardAddOptActivity.this.f30325n.getTextWithoutSpace(), GlobalCreditCardAddOptActivity.this.f30316e, GlobalCreditCardAddOptActivity.this.f30313K);
                    }
                } else {
                    SystemUtils.log(3, "CardAdd", "start error: code " + scanCardResult.code, (Throwable) null, "com.didi.payment.creditcard.global.activity.GlobalCreditCardAddOptActivity$11", 630);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21292d() {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(this.f30307E));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.OCR_STATUS, Integer.valueOf(m21294e()));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.MANUAL_INPUT, m21297f());
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.OCR_SESSION, Long.valueOf(this.f30309G));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.SAME_CHECK, Integer.valueOf(m21298g()));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.USER_OCR_RESULT, m21301h());
        GlobalOmegaUtils.trackOcrOperation(this, this.f30316e.bindType, hashMap);
    }

    /* renamed from: e */
    private int m21294e() {
        ScanCardResult scanCardResult = this.f30306D;
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

    /* renamed from: f */
    private String m21297f() {
        String textString = this.f30325n.getTextString();
        if (textString != null) {
            textString = textString.replace(" ", "");
        }
        if (textString == null || textString.length() < 6) {
            return "";
        }
        return textString.substring(0, 6);
    }

    /* renamed from: g */
    private int m21298g() {
        String textString = this.f30325n.getTextString();
        if (textString != null) {
            textString = textString.replace(" ", "");
        }
        return TextUtils.equals(textString, this.f30304B) ? 1 : 0;
    }

    /* renamed from: h */
    private String m21301h() {
        String str = this.f30304B;
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return "";
        }
        String replace = str.replace(" ", "");
        String substring = replace.substring(0, 6);
        String substring2 = replace.substring(replace.length() - 4);
        return substring + substring2;
    }

    public void onSignFail(SignResult signResult) {
        ISignErrorHandler iSignErrorHandler = this.f30308F;
        if (iSignErrorHandler != null) {
            iSignErrorHandler.handleError(signResult);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m21303i() {
        this.f30325n.setText("");
        this.f30327p.setText("");
        this.f30326o.setText("");
        this.f30325n.requestFocus();
        InputTools.showKeyboard(this.f30325n);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m21305j() {
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21282a(SignResult signResult) {
        if (signResult != null && !TextUtils.isEmpty(signResult.faqURL)) {
            WebBrowserUtil.startInternalWebActivity(this, signResult.faqURL, "");
        }
    }

    public void onPaste() {
        this.f30313K = "1";
    }
}
