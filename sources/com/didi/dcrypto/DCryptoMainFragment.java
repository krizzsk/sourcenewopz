package com.didi.dcrypto;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.dcrypto.chart.ChartCallback;
import com.didi.dcrypto.chart.ChartUtil;
import com.didi.dcrypto.chart.ScrollViewCallback;
import com.didi.dcrypto.cryptoprice.CryptoPriceCallback;
import com.didi.dcrypto.model.AccountInfoMulticoinBalance;
import com.didi.dcrypto.model.BitcoinHistoryItemModel;
import com.didi.dcrypto.multicoin.recyclerview.BalanceAdapter;
import com.didi.dcrypto.multicoin.recyclerview.DcryptoDividerItemDecorator;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.dcrypto.util.DigitUtils;
import com.didi.dcrypto.util.MulticoinUtils;
import com.didi.dcrypto.util.OmegaUtils;
import com.didi.dcrypto.util.TextUtil;
import com.didi.dcrypto.util.TimeUtils;
import com.didi.dcrypto.util.dialog.GlobalAlertDialog;
import com.didi.dcrypto.util.network.CommonProxyHolder;
import com.didi.dcrypto.util.network.NetworkConstants;
import com.didi.dcrypto.util.network.NetworkUtils;
import com.didi.dcrypto.util.network.UrlParamsUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel4;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.api.ILoginActionApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.global.didi.elvish.Elvish;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;
import com.taxis99.R;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DCryptoMainFragment extends Fragment implements View.OnClickListener, ChartCallback, ScrollViewCallback, CryptoPriceCallback {
    public static final String CRYPTO_ACCOUNT_STATUS_NOT_APPLIED = "not_applied";
    public static final String CRYPTO_ACCOUNT_STATUS_VERIFIED = "verified_simple_account";
    public static final String CRYPTO_ACCOUNT_STATUS_VERIFYING = "verifying_simple_account";
    public static final String DCRYPTO_EMPTY_STRING = "";
    public static final String DCRYPTO_NA = "N/A";
    public static final String DCRYPTO_NULL = "null";
    public static final String DCRYPTO_ZERO = "0.00";

    /* renamed from: F */
    private static final String f16388F = "ACTIVE";

    /* renamed from: G */
    private static final String f16389G = "FILLED";

    /* renamed from: H */
    private static final String f16390H = "PARTIALLY_FILLED";

    /* renamed from: I */
    private static final String f16391I = "PARTIALLY_CANCELED";
    public static final String IS_FULL_KYC_NO = "0";
    public static final String IS_FULL_KYC_YES = "1";

    /* renamed from: J */
    private static final String f16392J = "CANCELLED";

    /* renamed from: K */
    private static String f16393K = null;

    /* renamed from: L */
    private static String f16394L = null;

    /* renamed from: M */
    private static String f16395M = null;

    /* renamed from: N */
    private static final String f16396N = "BUY";

    /* renamed from: O */
    private static final String f16397O = "SELL";

    /* renamed from: ab */
    private static boolean f16398ab = true;

    /* renamed from: c */
    private static final String f16399c = "pt-BR";

    /* renamed from: d */
    private static final String f16400d = "en-US";
    public static boolean shouldUpdatePrice = true;

    /* renamed from: A */
    private CardView f16401A;

    /* renamed from: B */
    private CardView f16402B;

    /* renamed from: C */
    private CardView f16403C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public String f16404D = "0";

    /* renamed from: E */
    private String f16405E = CRYPTO_ACCOUNT_STATUS_NOT_APPLIED;

    /* renamed from: P */
    private boolean f16406P = false;

    /* renamed from: Q */
    private Timer f16407Q;

    /* renamed from: R */
    private RadioGroup f16408R;

    /* renamed from: S */
    private RadioButton f16409S;

    /* renamed from: T */
    private RadioButton f16410T;

    /* renamed from: U */
    private RadioButton f16411U;

    /* renamed from: V */
    private RadioButton f16412V;

    /* renamed from: W */
    private RadioButton f16413W;

    /* renamed from: X */
    private RadioButton f16414X;

    /* renamed from: Y */
    private RadioButton f16415Y;

    /* renamed from: Z */
    private RadioButton f16416Z;

    /* renamed from: a */
    String f16417a = (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());

    /* renamed from: aa */
    private RadioButton f16418aa;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public LEGODrawer f16419ac;

    /* renamed from: ad */
    private AlertDialog f16420ad;

    /* renamed from: ae */
    private AlertDialog f16421ae;

    /* renamed from: af */
    private String f16422af = "";

    /* renamed from: ag */
    private String f16423ag = "";
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public LEGODrawer f16424ah;

    /* renamed from: ai */
    private ChartUtil f16425ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public String f16426aj;

    /* renamed from: ak */
    private RecyclerView f16427ak;

    /* renamed from: al */
    private BalanceAdapter f16428al;

    /* renamed from: am */
    private List<AccountInfoMulticoinBalance> f16429am;

    /* renamed from: an */
    private Map<String, MulticoinState> f16430an;

    /* renamed from: ao */
    private final LoginListeners.LoginOutListener f16431ao = new LoginListeners.LoginOutListener() {
        public final void onSuccess() {
            DCryptoMainFragment.this.m12017J();
        }
    };

    /* renamed from: b */
    final int f16432b = 40;

    /* renamed from: e */
    private final String[] f16433e = {DCryptoUtils.KEY_HOME_GET_CRYPTO_PRICE, DCryptoUtils.KEY_HOME_HISTORY_ITEMS, DCryptoUtils.KEY_HOME_ACCOUNT_STATUS, DCryptoUtils.KEY_HOME_ACCOUNT_BALANCE, DCryptoUtils.KEY_HOME_DAILY_PROFIT_AND_LOSS, DCryptoUtils.KEY_HOME_UI_CONFIG, DCryptoUtils.KEY_HOME_TOP_BANNER};

    /* renamed from: f */
    private ScrollView f16434f;

    /* renamed from: g */
    private TextView f16435g;

    /* renamed from: h */
    private ImageView f16436h;

    /* renamed from: i */
    private RelativeLayout f16437i;

    /* renamed from: j */
    private ImageView f16438j;

    /* renamed from: k */
    private TextView f16439k;

    /* renamed from: l */
    private TextView f16440l;

    /* renamed from: m */
    private TextView f16441m;

    /* renamed from: n */
    private TextView f16442n;

    /* renamed from: o */
    private TextView f16443o;

    /* renamed from: p */
    private ImageView f16444p;

    /* renamed from: q */
    private TextView f16445q;

    /* renamed from: r */
    private Button f16446r;

    /* renamed from: s */
    private Button f16447s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public CardView f16448t;

    /* renamed from: u */
    private TextView f16449u;

    /* renamed from: v */
    private RelativeLayout f16450v;

    /* renamed from: w */
    private RelativeLayout f16451w;

    /* renamed from: x */
    private TextView f16452x;

    /* renamed from: y */
    private TextView f16453y;

    /* renamed from: z */
    private CardView f16454z;

    enum MulticoinState {
        HAS_TRANSACTION,
        NO_TRANSACTION
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void m12017J() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                DCryptoMainFragment.this.m12018K();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void m12018K() {
        m12039b();
        SystemUtils.log(4, "Dcrypto passport", "Passport Logout listener detected user has been logged out or kicked out", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 281);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DCryptoUtils.getBundle(this);
        this.f16426aj = NetworkConstants.CURRENCY_BTC;
        NetworkConstants.BASIC_PARAMS = UrlParamsUtils.getBasicUrlParams(getContext());
        View inflate = layoutInflater.inflate(R.layout.fragment_page_my, viewGroup, false);
        if (getContext() != null) {
            f16393K = getString(R.string.Wallet_App_process_Success_PvkG);
            f16394L = getString(R.string.Wallet_App_process_Processing_CGYA);
            f16395M = getString(R.string.Wallet_App_process_Failure_mwvP);
        }
        this.f16425ai = new ChartUtil(this, this, this, getContext(), inflate);
        m12023a(inflate);
        m12041b(inflate);
        m12050c(inflate);
        m12108u();
        m12109v();
        this.f16430an = new HashMap();
        m12058d(this.f16426aj);
        if (getContext() != null) {
            Elvish.Companion.init(getContext(), "pt_BR", "BR", "55000001");
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (f16398ab) {
            m12093l();
        }
        SystemUtils.log(4, "Dcrypto", "Dcrypto lifecycle: onResume()", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 352);
        this.f16422af = TimeUtils.getCurrentLocalDateTimeStamp();
    }

    public void onPause() {
        super.onPause();
        m12104q();
        boolean isLoginNow = OneLoginFacade.getStore().isLoginNow();
        String currentLocalDateTimeStamp = TimeUtils.getCurrentLocalDateTimeStamp();
        this.f16423ag = currentLocalDateTimeStamp;
        if (this.f16406P) {
            OmegaUtils.ibt_microinvest_mihomepurchased_page_browse_time_ex(isLoginNow, this.f16422af, currentLocalDateTimeStamp);
        } else {
            OmegaUtils.ibt_microinvest_mihomenotpurchased_page_browse_time_ex(isLoginNow, this.f16422af, currentLocalDateTimeStamp);
        }
        this.f16422af = "";
        this.f16423ag = "";
        SystemUtils.log(4, "Dcrypto", "Dcrypto lifecycle: onPause()", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 376);
    }

    public void onHiddenChanged(boolean z) {
        if (getContext() != null) {
            f16398ab = !z;
            if (!z) {
                SystemUtils.log(4, "Dcrypto", "Dcrypto lifecycle: onHiddenChange() -> Fragment Show", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 391);
                m12093l();
                return;
            }
            SystemUtils.log(4, "Dcrypto", "Dcrypto lifecycle: onHiddenChange() -> Fragment Hidden", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 396);
        }
    }

    public void onInitChart() {
        this.f16414X.performClick();
        m12049c((int) R.id.btn_crypto_graph_btn_day);
    }

    public void onReceiveData(String str, String str2) {
        this.f16425ai.updateData(str, str2);
    }

    public void onResetChart() {
        this.f16409S.performClick();
        m12040b((int) R.id.btn_coin_btc);
        this.f16409S.setChecked(true);
        this.f16411U.setChecked(false);
        this.f16413W.setChecked(false);
        this.f16412V.setChecked(false);
        this.f16410T.setChecked(false);
        this.f16414X.performClick();
        m12049c((int) R.id.btn_crypto_graph_btn_day);
        this.f16414X.setChecked(true);
        this.f16415Y.setChecked(false);
        this.f16416Z.setChecked(false);
        this.f16418aa.setChecked(false);
    }

    public void setInterceptTouch(boolean z) {
        this.f16434f.requestDisallowInterceptTouchEvent(z);
    }

    /* renamed from: a */
    private void m12022a(int i) {
        this.f16437i.setVisibility(i);
    }

    /* renamed from: a */
    private void m12035a(boolean z, String str, String str2, String str3, String str4) {
        m12022a(8);
        this.f16439k.setText(str);
        this.f16440l.setText(str2);
        if (DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON) && z && !TextUtil.isEmpty(str3)) {
            Picasso.with(getContext()).load(str3).placeholder((int) R.drawable.crypto_home_top_banner).into(this.f16438j);
        }
        NetworkConstants.urlBannerTop = str4 + NetworkConstants.BASIC_PARAMS;
        NetworkConstants.urlBannerTop = NetworkConstants.urlBannerTop.substring(0, NetworkConstants.urlBannerTop.lastIndexOf(38));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12021a() {
        if (getContext() != null) {
            LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(getString(R.string.GRider_request_For_policy_eYxl), new LEGOBtnTextAndCallback(Payload.RESPONSE_OK, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    DCryptoMainFragment.this.f16424ah.dismiss();
                    if (DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON) && DCryptoMainFragment.this.getActivity() != null) {
                        DCryptoMainFragment.this.getActivity().finish();
                    }
                }
            }));
            lEGODrawerModel1.setClickOutsideCanCancel(false);
            lEGODrawerModel1.setmBackPressedEnabled(false);
            this.f16424ah = LEGOUICreator.showDrawerTemplate(getActivity(), lEGODrawerModel1);
        }
    }

    /* renamed from: b */
    private void m12039b() {
        if (getContext() != null) {
            m12022a(0);
            m12110w();
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f16408R.getLayoutParams();
            if (getContext() != null) {
                layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (float) 0, getContext().getResources().getDisplayMetrics()), 0, 0);
            }
            this.f16408R.setLayoutParams(layoutParams);
            m12060e();
            this.f16425ai.resetChart();
            m12048c();
            m12066f();
            m12072g();
            this.f16448t.setVisibility(8);
            m12081i();
            m12077h();
            m12104q();
            m12056d((View) this.f16434f);
            DCryptoUtils.clearIPBlockTimestamp();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12048c() {
        if (getContext() != null) {
            this.f16447s.setVisibility(8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f16446r.getLayoutParams();
            if (getContext() != null) {
                layoutParams.setMarginStart((int) TypedValue.applyDimension(1, (float) 20, getContext().getResources().getDisplayMetrics()));
            }
            this.f16446r.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: d */
    private void m12055d() {
        if (getContext() != null) {
            this.f16447s.setVisibility(0);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f16446r.getLayoutParams();
            if (getContext() != null) {
                layoutParams.setMarginStart((int) TypedValue.applyDimension(1, (float) 16, getContext().getResources().getDisplayMetrics()));
            }
            this.f16446r.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m12060e() {
        if (getContext() != null) {
            shouldUpdatePrice = true;
            this.f16441m.setText("");
            this.f16442n.setText(DCRYPTO_ZERO);
            this.f16445q.setText("0.00%");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m12066f() {
        if (getContext() != null) {
            try {
                this.f16452x.setText(MulticoinUtils.getMulticoinCurrency(DigitUtils.getElvishedCurrency(Double.parseDouble(DCRYPTO_ZERO))));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "Reset Account Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 595);
                e.printStackTrace();
                this.f16452x.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f16452x.setText(DCRYPTO_NA);
            }
            m12072g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m12072g() {
        if (getContext() != null) {
            try {
                String elvishedCurrency = DigitUtils.getElvishedCurrency(Double.parseDouble(DCRYPTO_ZERO));
                this.f16453y.setTextColor(-16777216);
                this.f16453y.setText(MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "Amount Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 617);
                e.printStackTrace();
                this.f16453y.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f16453y.setText(DCRYPTO_NA);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m12077h() {
        if (getContext() != null) {
            this.f16404D = "0";
            this.f16405E = CRYPTO_ACCOUNT_STATUS_NOT_APPLIED;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m12081i() {
        if (getContext() != null) {
            RelativeLayout relativeLayout = this.f16450v;
            BitcoinHistoryItemModel bitcoinHistoryItemModel = r2;
            BitcoinHistoryItemModel bitcoinHistoryItemModel2 = new BitcoinHistoryItemModel(DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, 0);
            m12027a(relativeLayout, bitcoinHistoryItemModel);
            m12027a(this.f16451w, new BitcoinHistoryItemModel(DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, 0));
            this.f16406P = false;
        }
    }

    /* renamed from: j */
    private void m12085j() {
        if (getContext() != null) {
            this.f16451w.setVisibility(8);
        }
    }

    /* renamed from: k */
    private void m12090k() {
        if (getContext() != null) {
            this.f16451w.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m12093l() {
        if (getContext() != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(OneLoginFacade.getStore().isLoginNow()) {
                public final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    SystemUtils.log(4, "DcryptoLogin", "Dcrypto Passport status at refresh(): OneLoginFacade.getStore().isLoginNow() = " + this.f$0, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 662);
                }
            });
            if (getContext() != null && !DCryptoUtils.isBubbleViewed(getContext())) {
                m12106s();
            } else if (!OneLoginFacade.getStore().isLoginNow()) {
                m12039b();
                m12105r();
                this.f16425ai.startGraphChart(this.f16426aj);
            } else {
                m12097m();
            }
        }
    }

    /* renamed from: m */
    private void m12097m() {
        if (getContext() != null) {
            m12100n();
            m12103p();
            m12102o();
            this.f16425ai.startGraphChart(this.f16426aj);
        }
    }

    /* renamed from: n */
    private void m12100n() {
        SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Try Fetch :Check timestamp", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 694);
        if (DCryptoUtils.shouldFetchIPBlock()) {
            SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Fetch NOW!!", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 696);
            DCryptoUtils.setDcryptoIPStatus(getContext(), DCryptoUtils.KEY_IP_BLOCKING_STATUS_DEFAULT);
            new GetIPBlockAsyncTask().execute(new String[]{""});
            return;
        }
        SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Try Fetch :Under Time Interval. Will not fetch.", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 701);
        if (DCryptoUtils.getDcryptoIPStatus(getContext()).equalsIgnoreCase(DCryptoUtils.KEY_IP_BLOCKING_STATUS_DEFAULT)) {
            SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Default", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 703);
        } else if (DCryptoUtils.getDcryptoIPStatus(getContext()).equalsIgnoreCase(DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK)) {
            SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Block", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 706);
            this.f16425ai.getChart().post(new Runnable() {
                public final void run() {
                    DCryptoMainFragment.this.m12021a();
                }
            });
        } else {
            SystemUtils.log(4, "IPBlock Cache", "Enter Cache = UNBlock", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 711);
        }
    }

    /* renamed from: o */
    private void m12102o() {
        for (String a : this.f16433e) {
            m12030a(a);
        }
    }

    /* renamed from: a */
    private void m12030a(String str) {
        SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Start API: " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 723);
        if (str != null && !str.equalsIgnoreCase("")) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1776939641:
                    if (str.equals(DCryptoUtils.KEY_HOME_GET_CRYPTO_PRICE)) {
                        c = 0;
                        break;
                    }
                    break;
                case -780842326:
                    if (str.equals(DCryptoUtils.KEY_HOME_DAILY_PROFIT_AND_LOSS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 116686890:
                    if (str.equals(DCryptoUtils.KEY_HOME_ACCOUNT_STATUS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 501780587:
                    if (str.equals(DCryptoUtils.KEY_HOME_UI_CONFIG)) {
                        c = 5;
                        break;
                    }
                    break;
                case 681795201:
                    if (str.equals(DCryptoUtils.KEY_HOME_HISTORY_ITEMS)) {
                        c = 1;
                        break;
                    }
                    break;
                case 880264612:
                    if (str.equals(DCryptoUtils.KEY_HOME_ACCOUNT_BALANCE)) {
                        c = 3;
                        break;
                    }
                    break;
                case 2032596492:
                    if (str.equals(DCryptoUtils.KEY_HOME_TOP_BANNER)) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m12105r();
                    return;
                case 1:
                    new GetTransactionHistoryAsyncTask().execute(new String[]{""});
                    return;
                case 2:
                    new GetAccountStatusAsyncTask().execute(new String[]{""});
                    return;
                case 3:
                    new GetAccountInfoAsyncTask().execute(new String[]{""});
                    return;
                case 4:
                    new GetDailyProfitLossAsyncTask().execute(new String[]{""});
                    return;
                case 5:
                    new GetUIConfigForBannersAsyncTask().execute(new String[]{""});
                    return;
                case 6:
                    new GetCryptoTopBannersAsyncTask().execute(new String[]{""});
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: p */
    private void m12103p() {
        String valueOf = String.valueOf(LoginStore.getInstance().getUid());
        String dcryptoCache = DCryptoUtils.getDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_UID);
        SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Load Cached Data: UID LoginStre: " + valueOf, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 759);
        SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Load Cached Data: UID Cached: " + dcryptoCache, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 760);
        int i = 0;
        if (!valueOf.equalsIgnoreCase(dcryptoCache)) {
            SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Clear Cache", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 769);
            String[] strArr = this.f16433e;
            int length = strArr.length;
            while (i < length) {
                DCryptoUtils.clearDcryptoCache(getContext(), strArr[i]);
                i++;
            }
            SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Update new UID: " + valueOf, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 774);
            DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_UID, valueOf);
            return;
        }
        String[] strArr2 = this.f16433e;
        int length2 = strArr2.length;
        while (i < length2) {
            m12044b(strArr2[i]);
            i++;
        }
    }

    /* renamed from: b */
    private void m12044b(String str) {
        SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Load Cache: " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 785);
        if (getContext() != null) {
            String dcryptoCache = DCryptoUtils.getDcryptoCache(getContext(), str);
            if (!"".equalsIgnoreCase(dcryptoCache)) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -1776939641:
                        if (str.equals(DCryptoUtils.KEY_HOME_GET_CRYPTO_PRICE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -780842326:
                        if (str.equals(DCryptoUtils.KEY_HOME_DAILY_PROFIT_AND_LOSS)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 116686890:
                        if (str.equals(DCryptoUtils.KEY_HOME_ACCOUNT_STATUS)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 501780587:
                        if (str.equals(DCryptoUtils.KEY_HOME_UI_CONFIG)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 681795201:
                        if (str.equals(DCryptoUtils.KEY_HOME_HISTORY_ITEMS)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 880264612:
                        if (str.equals(DCryptoUtils.KEY_HOME_ACCOUNT_BALANCE)) {
                            c = 3;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    m12071f(dcryptoCache);
                } else if (c == 1) {
                    m12088j(dcryptoCache);
                } else if (c == 2) {
                    m12076g(dcryptoCache);
                } else if (c == 3) {
                    m12080h(dcryptoCache);
                } else if (c == 4) {
                    m12084i(dcryptoCache);
                } else if (c == 5) {
                    m12092k(dcryptoCache);
                }
            }
        }
    }

    /* renamed from: q */
    private void m12104q() {
        Timer timer;
        if (getContext() != null && (timer = this.f16407Q) != null) {
            timer.cancel();
            this.f16407Q.purge();
        }
    }

    /* renamed from: r */
    private void m12105r() {
        if (getContext() != null) {
            m12104q();
            Timer timer = new Timer();
            this.f16407Q = timer;
            timer.schedule(new GetPriceTimerTask(), 0, 5000);
        }
    }

    /* renamed from: s */
    private void m12106s() {
        if (getContext() != null) {
            SystemUtils.showDialog(this.f16420ad);
        }
    }

    /* renamed from: t */
    private void m12107t() {
        if (getContext() != null) {
            SystemUtils.showDialog(this.f16421ae);
        }
    }

    /* renamed from: u */
    private void m12108u() {
        if (getContext() != null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.BubbleDialog);
            View inflate = layoutInflater.inflate(R.layout.layout_bubble_1, (ViewGroup) null);
            builder.setView(inflate);
            AlertDialog create = builder.create();
            this.f16420ad = create;
            create.setCanceledOnTouchOutside(false);
            this.f16420ad.setCancelable(false);
            ((Button) inflate.findViewById(R.id.btn_bubble_ok)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m12101n(view);
                }
            });
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext(), R.style.BubbleDialog);
            View inflate2 = layoutInflater.inflate(R.layout.layout_bubble_2, (ViewGroup) null);
            builder2.setView(inflate2);
            this.f16421ae = builder2.create();
            this.f16421ae.setCanceledOnTouchOutside(false);
            this.f16421ae.setCancelable(false);
            ((Button) inflate2.findViewById(R.id.btn_bubble_ok)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m12098m(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void m12101n(View view) {
        this.f16420ad.dismiss();
        m12107t();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void m12098m(View view) {
        if (getContext() != null) {
            DCryptoUtils.setBubbleViewed(getContext(), true);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                DCryptoMainFragment.this.m12093l();
            }
        });
        this.f16421ae.dismiss();
    }

    /* renamed from: v */
    private void m12109v() {
        ArrayList arrayList = new ArrayList();
        this.f16429am = arrayList;
        BalanceAdapter balanceAdapter = new BalanceAdapter(arrayList, getContext(), this.f16426aj);
        this.f16428al = balanceAdapter;
        this.f16427ak.setAdapter(balanceAdapter);
        this.f16427ak.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /* renamed from: a */
    private void m12023a(View view) {
        if (getContext() != null) {
            this.f16434f = (ScrollView) view.findViewById(R.id.sv_crypto_home);
            this.f16435g = (TextView) view.findViewById(R.id.tv_crypto_main_title);
            this.f16436h = (ImageView) view.findViewById(R.id.iv_crypto_customer_service);
            this.f16437i = (RelativeLayout) view.findViewById(R.id.rl_crypto_top_banner);
            this.f16438j = (ImageView) view.findViewById(R.id.iv_crypto_top_banner);
            this.f16439k = (TextView) view.findViewById(R.id.tv_drypto_banner_top_title);
            this.f16440l = (TextView) view.findViewById(R.id.tv_drypto_banner_top_subtitle);
            this.f16441m = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_prefix);
            this.f16442n = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_price);
            this.f16443o = (TextView) view.findViewById(R.id.tv_multicoin_title);
            this.f16444p = (ImageView) view.findViewById(R.id.iv_currency_question_mark);
            this.f16445q = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_percentage);
            this.f16408R = (RadioGroup) view.findViewById(R.id.rg_multi_coin);
            this.f16409S = (RadioButton) view.findViewById(R.id.btn_coin_btc);
            this.f16410T = (RadioButton) view.findViewById(R.id.btn_coin_eth);
            this.f16411U = (RadioButton) view.findViewById(R.id.btn_coin_usdc);
            this.f16412V = (RadioButton) view.findViewById(R.id.btn_coin_solana);
            this.f16413W = (RadioButton) view.findViewById(R.id.btn_coin_mana);
            this.f16414X = (RadioButton) view.findViewById(R.id.btn_crypto_graph_btn_day);
            this.f16415Y = (RadioButton) view.findViewById(R.id.btn_crypto_graph_btn_week);
            this.f16416Z = (RadioButton) view.findViewById(R.id.btn_crypto_graph_btn_month);
            this.f16418aa = (RadioButton) view.findViewById(R.id.btn_crypto_graph_btn_year);
            this.f16446r = (Button) view.findViewById(R.id.btn_crypto_bitcoin_buy);
            this.f16447s = (Button) view.findViewById(R.id.btn_crypto_bitcoin_sell);
            this.f16448t = (CardView) view.findViewById(R.id.cardview_crypto_bitcoin_history);
            this.f16449u = (TextView) view.findViewById(R.id.tv_crypto_bitcoint_transaction_history);
            this.f16450v = (RelativeLayout) view.findViewById(R.id.lv_crypto_bitcoin_history_item_1);
            this.f16451w = (RelativeLayout) view.findViewById(R.id.lv_crypto_bitcoin_history_item_2);
            this.f16452x = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_value_total_value_content);
            this.f16453y = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_value_p_and_l);
            this.f16427ak = (RecyclerView) view.findViewById(R.id.recyclerViewMulticoinBalance);
        }
    }

    /* renamed from: b */
    private void m12041b(View view) {
        if (getContext() != null) {
            this.f16437i.setOnClickListener(this);
            this.f16436h.setOnClickListener(this);
            this.f16409S.setOnClickListener(this);
            this.f16410T.setOnClickListener(this);
            this.f16411U.setOnClickListener(this);
            this.f16412V.setOnClickListener(this);
            this.f16413W.setOnClickListener(this);
            this.f16414X.setOnClickListener(this);
            this.f16415Y.setOnClickListener(this);
            this.f16416Z.setOnClickListener(this);
            this.f16418aa.setOnClickListener(this);
            this.f16446r.setOnClickListener(this);
            this.f16447s.setOnClickListener(this);
            this.f16449u.setOnClickListener(this);
            this.f16444p.setOnClickListener(this);
        }
    }

    /* renamed from: c */
    private void m12050c(View view) {
        if (getContext() != null) {
            if (DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                this.f16435g.setVisibility(8);
                this.f16436h.setVisibility(8);
                this.f16446r.setBackgroundResource(R.drawable.roundbutton_mouton);
                this.f16446r.setTextColor(getResources().getColor(R.color.didi_black));
                this.f16447s.setBackgroundResource(R.drawable.roundbutton_mouton);
                this.f16447s.setTextColor(getResources().getColor(R.color.didi_black));
                ((ImageView) this.f16450v.findViewById(R.id.item_bitcoin_history_item_info)).setImageResource(R.drawable.bitcoin_history_icon_mouton);
                ((ImageView) this.f16451w.findViewById(R.id.item_bitcoin_history_item_info)).setImageResource(R.drawable.bitcoin_history_icon_mouton);
                Button button = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_1)).findViewById(R.id.btn_crypto_bottom_banner);
                button.setBackgroundResource(R.drawable.roundbutton_mouton);
                button.setTextColor(getResources().getColor(R.color.didi_black));
                Button button2 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_2)).findViewById(R.id.btn_crypto_bottom_banner);
                button2.setBackgroundResource(R.drawable.roundbutton_mouton);
                button2.setTextColor(getResources().getColor(R.color.didi_black));
                Button button3 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_3)).findViewById(R.id.btn_crypto_bottom_banner);
                button3.setBackgroundResource(R.drawable.roundbutton_mouton);
                button3.setTextColor(getResources().getColor(R.color.didi_black));
                Button button4 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_4)).findViewById(R.id.btn_crypto_bottom_banner);
                button4.setBackgroundResource(R.drawable.roundbutton_mouton);
                button4.setTextColor(getResources().getColor(R.color.didi_black));
            } else if (DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                this.f16446r.setBackgroundResource(R.drawable.roundbutton_latour);
                this.f16446r.setTextColor(getResources().getColor(R.color.white));
                this.f16447s.setBackgroundResource(R.drawable.roundbutton_latour);
                this.f16447s.setTextColor(getResources().getColor(R.color.white));
                ((ImageView) this.f16450v.findViewById(R.id.item_bitcoin_history_item_info)).setImageResource(R.drawable.bitcoin_history_icon_latour);
                ((ImageView) this.f16451w.findViewById(R.id.item_bitcoin_history_item_info)).setImageResource(R.drawable.bitcoin_history_icon_latour);
                Button button5 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_1)).findViewById(R.id.btn_crypto_bottom_banner);
                button5.setBackgroundResource(R.drawable.roundbutton_latour);
                button5.setTextColor(getResources().getColor(R.color.white));
                Button button6 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_2)).findViewById(R.id.btn_crypto_bottom_banner);
                button6.setBackgroundResource(R.drawable.roundbutton_latour);
                button6.setTextColor(getResources().getColor(R.color.white));
                Button button7 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_3)).findViewById(R.id.btn_crypto_bottom_banner);
                button7.setBackgroundResource(R.drawable.roundbutton_latour);
                button7.setTextColor(getResources().getColor(R.color.white));
                Button button8 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_4)).findViewById(R.id.btn_crypto_bottom_banner);
                button8.setBackgroundResource(R.drawable.roundbutton_latour);
                button8.setTextColor(getResources().getColor(R.color.white));
            }
        }
    }

    /* renamed from: a */
    private void m12027a(RelativeLayout relativeLayout, BitcoinHistoryItemModel bitcoinHistoryItemModel) {
        String str;
        if (getContext() != null && bitcoinHistoryItemModel != null) {
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_bitcoin_history_item_title);
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_bitcoin_history_item_date);
            TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_bitcoin_history_item_amount);
            TextView textView4 = (TextView) relativeLayout.findViewById(R.id.tv_bitcoin_history_item_status);
            if (bitcoinHistoryItemModel.remark == null || bitcoinHistoryItemModel.remark.equalsIgnoreCase("") || bitcoinHistoryItemModel.remark.equalsIgnoreCase("null")) {
                String str2 = bitcoinHistoryItemModel.side;
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 66150) {
                    if (hashCode == 2541394 && str2.equals(f16397O)) {
                        c = 1;
                    }
                } else if (str2.equals(f16396N)) {
                    c = 0;
                }
                if (c == 0) {
                    str = getString(R.string.Wallet_App_process_Purchase_zUpv);
                } else if (c != 1) {
                    str = "default";
                } else {
                    str = getString(R.string.Wallet_App_process_Sale_PNCZ);
                }
            } else {
                str = getString(R.string.Wallet_App_cashback_Bitcoin_cash_tecP);
            }
            textView.setText(str + " " + bitcoinHistoryItemModel.quantity_executed + " " + bitcoinHistoryItemModel.market_symbol.substring(0, bitcoinHistoryItemModel.market_symbol.length() - 3).toUpperCase());
            Date date = new Date(bitcoinHistoryItemModel.timestamp);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            textView2.setText(simpleDateFormat.format(date));
            if (bitcoinHistoryItemModel.quantity_executed.equalsIgnoreCase("null") || bitcoinHistoryItemModel.quantity_executed.equalsIgnoreCase(DCRYPTO_NA)) {
                textView3.setText("");
            } else {
                try {
                    textView3.setText(MulticoinUtils.getMulticoinCurrency(DigitUtils.getElvishedCurrency(Double.parseDouble(bitcoinHistoryItemModel.quantity_executed) * Double.parseDouble(bitcoinHistoryItemModel.priceAve))));
                } catch (NumberFormatException e) {
                    SystemUtils.log(6, "Dcrypto Error", "History Amount Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1100);
                    e.printStackTrace();
                    textView3.setText(DCRYPTO_NA);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    textView3.setText(DCRYPTO_NA);
                }
            }
            textView4.setText(bitcoinHistoryItemModel.state);
        }
    }

    /* renamed from: a */
    private Calendar m12020a(Date date) {
        if (getContext() == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public void updateMainPriceTitle(String str, String str2) {
        if (getContext() != null) {
            try {
                String elvishedCurrency = DigitUtils.getElvishedCurrency(Double.parseDouble(str));
                this.f16441m.setText("");
                this.f16442n.setText(MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "Today Bitcoin price Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1134);
                e.printStackTrace();
                this.f16441m.setText("");
                this.f16442n.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f16441m.setText("");
                this.f16442n.setText(DCRYPTO_NA);
            }
            if (str != null && str2 != null) {
                try {
                    double parseDouble = (Double.parseDouble(str) / Double.parseDouble(str2)) - 1.0d;
                    if (parseDouble > 0.0d) {
                        if (DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                            this.f16445q.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_LATOUR));
                        } else {
                            this.f16445q.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
                        }
                        String keepNumOfDecimalDigits = DigitUtils.keepNumOfDecimalDigits(parseDouble * 100.0d, 2);
                        TextView textView = this.f16445q;
                        textView.setText("↑" + keepNumOfDecimalDigits + "%");
                        return;
                    }
                    this.f16445q.setTextColor(Color.parseColor(ColorUtils.DIDI_RED));
                    String keepNumOfDecimalDigits2 = DigitUtils.keepNumOfDecimalDigits(parseDouble * 100.0d, 2);
                    TextView textView2 = this.f16445q;
                    textView2.setText("↓" + keepNumOfDecimalDigits2 + "%");
                } catch (NumberFormatException e3) {
                    SystemUtils.log(6, "Dcrypto Error", "Bitcoin Percentage Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1174);
                    e3.printStackTrace();
                    this.f16445q.setTextColor(Color.parseColor(ColorUtils.DIDI_GREY));
                    this.f16445q.setText(DCRYPTO_NA);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    this.f16445q.setTextColor(Color.parseColor(ColorUtils.DIDI_GREY));
                    this.f16445q.setText(DCRYPTO_NA);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12045b(String str, String str2, List<AccountInfoMulticoinBalance> list) {
        if (getContext() != null) {
            try {
                this.f16452x.setText(MulticoinUtils.getMulticoinCurrency(DigitUtils.getElvishedCurrency(Double.parseDouble(str2))));
                double parseDouble = Double.parseDouble(str2);
                String.format(Locale.getDefault(), "%.8f", new Object[]{Double.valueOf(parseDouble)});
                ArrayList arrayList = new ArrayList();
                this.f16429am = arrayList;
                arrayList.addAll(list);
                BalanceAdapter balanceAdapter = new BalanceAdapter(this.f16429am, getContext(), this.f16426aj);
                this.f16428al = balanceAdapter;
                this.f16427ak.setAdapter(balanceAdapter);
                this.f16427ak.addItemDecoration(new DcryptoDividerItemDecorator(ContextCompat.getDrawable(getContext(), R.drawable.divider)));
                this.f16427ak.setLayoutManager(new LinearLayoutManager(getContext()));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "Account Balance Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1215);
                e.printStackTrace();
                this.f16452x.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f16452x.setText(DCRYPTO_NA);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12099m(String str) {
        if (getContext() != null) {
            try {
                double parseDouble = Double.parseDouble(str);
                String elvishedCurrency = DigitUtils.getElvishedCurrency(parseDouble);
                if (parseDouble >= 0.0d) {
                    if (DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                        this.f16453y.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_LATOUR));
                    } else {
                        this.f16453y.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
                    }
                    TextView textView = this.f16453y;
                    textView.setText("+" + MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
                    return;
                }
                this.f16453y.setTextColor(Color.parseColor(ColorUtils.DIDI_RED));
                TextView textView2 = this.f16453y;
                textView2.setText("" + MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "P&L Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1245);
                e.printStackTrace();
                this.f16453y.setTextColor(Color.parseColor(ColorUtils.DIDI_GREY));
                this.f16453y.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f16453y.setTextColor(Color.parseColor(ColorUtils.DIDI_GREY));
                this.f16453y.setText(DCRYPTO_NA);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void startLoginPage() {
        ILoginActionApi action;
        if (getContext() != null && (action = OneLoginFacade.getAction()) != null && getContext() != null) {
            action.go2Login(getContext());
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (getContext() != null) {
            boolean isLoginNow = OneLoginFacade.getStore().isLoginNow();
            new Handler(Looper.getMainLooper()).post(new Runnable(isLoginNow) {
                public final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    SystemUtils.log(4, "DcryptoLogin", "Dcrypto Passport status at onClick(View view): OneLoginFacade.getStore().isLoginNow() = " + this.f$0, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1275);
                }
            });
            int id = view.getId();
            if (id == R.id.btn_crypto_bitcoin_buy) {
                if (this.f16406P) {
                    OmegaUtils.ibt_microinvest_mihomepurchased_buy_ck(isLoginNow, this.f16426aj);
                } else {
                    OmegaUtils.ibt_microinvest_mihomenotpurchased_buy_ck(isLoginNow, this.f16404D, this.f16405E);
                }
                if (!isLoginNow) {
                    startLoginPage();
                } else if (CRYPTO_ACCOUNT_STATUS_NOT_APPLIED.equalsIgnoreCase(this.f16405E)) {
                    m12112y();
                } else if (CRYPTO_ACCOUNT_STATUS_VERIFIED.equalsIgnoreCase(this.f16405E)) {
                    DRouter.build("pay99://one/btc/buy_bitcoin_keyBoard?crypto=" + this.f16426aj).start(getContext());
                } else if (CRYPTO_ACCOUNT_STATUS_VERIFYING.equalsIgnoreCase(this.f16405E)) {
                    DRouter.build("pay99://one/btc/account_under_review").start(getContext());
                } else {
                    DRouter.build("pay99://one/btc/account_under_review").start(getContext());
                }
            } else if (id == R.id.btn_crypto_bitcoin_sell) {
                OmegaUtils.ibt_microinvest_mihomepurchased_sell_ck(isLoginNow, this.f16426aj);
                if (isLoginNow) {
                    DRouter.build("pay99://one/btc/sell_bitcoin_keyBoard?crypto=" + this.f16426aj).start(getContext());
                    return;
                }
                startLoginPage();
            } else if (id == R.id.tv_crypto_bitcoint_transaction_history) {
                OmegaUtils.ibt_microinvest_mihomepurchased_trx_ck();
                if (isLoginNow) {
                    DRouter.build("pay99://one/btc/transaction_history").start(getContext());
                } else {
                    startLoginPage();
                }
            } else if (id == R.id.iv_currency_question_mark) {
                m12111x();
            } else if (id == R.id.btn_crypto_graph_btn_day) {
                m12049c((int) R.id.btn_crypto_graph_btn_day);
                this.f16425ai.refreshGraph(0);
            } else if (id == R.id.btn_crypto_graph_btn_week) {
                m12049c((int) R.id.btn_crypto_graph_btn_week);
                this.f16425ai.refreshGraph(1);
            } else if (id == R.id.btn_crypto_graph_btn_month) {
                m12049c((int) R.id.btn_crypto_graph_btn_month);
                this.f16425ai.refreshGraph(2);
            } else if (id == R.id.btn_crypto_graph_btn_year) {
                m12049c((int) R.id.btn_crypto_graph_btn_year);
                this.f16425ai.refreshGraph(3);
            } else if (id == R.id.btn_coin_btc) {
                this.f16426aj = NetworkConstants.CURRENCY_BTC;
                m12058d(NetworkConstants.CURRENCY_BTC);
                m12040b((int) R.id.btn_coin_btc);
                this.f16425ai.startGraphChart(this.f16426aj);
            } else if (id == R.id.btn_coin_eth) {
                this.f16426aj = NetworkConstants.CURRENCY_ETH;
                m12058d(NetworkConstants.CURRENCY_ETH);
                m12040b((int) R.id.btn_coin_eth);
                this.f16425ai.startGraphChart(this.f16426aj);
            } else if (id == R.id.btn_coin_usdc) {
                this.f16426aj = NetworkConstants.CURRENCY_USDC;
                m12058d(NetworkConstants.CURRENCY_USDC);
                m12040b((int) R.id.btn_coin_usdc);
                this.f16425ai.startGraphChart(this.f16426aj);
            } else if (id == R.id.btn_coin_solana) {
                this.f16426aj = NetworkConstants.CURRENCY_SOLANA;
                m12058d(NetworkConstants.CURRENCY_SOLANA);
                m12040b((int) R.id.btn_coin_solana);
                this.f16425ai.startGraphChart(this.f16426aj);
            } else if (id == R.id.btn_coin_mana) {
                this.f16426aj = NetworkConstants.CURRENCY_MANA;
                m12058d(NetworkConstants.CURRENCY_MANA);
                m12040b((int) R.id.btn_coin_mana);
                this.f16425ai.startGraphChart(this.f16426aj);
            } else if (id == R.id.iv_crypto_customer_service) {
                DRouter.build(NetworkConstants.URL_CUSTOMER_SERVICE).start(getContext());
            } else if (id == R.id.rl_crypto_top_banner) {
                DRouter.build(NetworkConstants.urlBannerTop).start(getContext());
            }
        }
    }

    /* renamed from: d */
    private void m12058d(String str) {
        this.f16443o.setText(getString(R.string.multicoin_card_title, MulticoinUtils.getMulticoinName(str)));
    }

    /* renamed from: b */
    private void m12040b(int i) {
        if (getContext() != null && getContext() != null) {
            Typeface font = ResourcesCompat.getFont(getContext(), R.font.regular);
            Typeface font2 = ResourcesCompat.getFont(getContext(), R.font.bold);
            if (i == R.id.btn_coin_btc) {
                this.f16409S.setTypeface(font2, 1);
                this.f16410T.setTypeface(font, 0);
                this.f16411U.setTypeface(font, 0);
                this.f16412V.setTypeface(font, 0);
                this.f16413W.setTypeface(font, 0);
                m12064e(NetworkConstants.CURRENCY_BTC);
            } else if (i == R.id.btn_coin_eth) {
                this.f16409S.setTypeface(font, 0);
                this.f16410T.setTypeface(font2, 1);
                this.f16411U.setTypeface(font, 0);
                this.f16412V.setTypeface(font, 0);
                this.f16413W.setTypeface(font, 0);
                m12064e(NetworkConstants.CURRENCY_ETH);
            } else if (i == R.id.btn_coin_usdc) {
                this.f16409S.setTypeface(font, 0);
                this.f16410T.setTypeface(font, 0);
                this.f16411U.setTypeface(font2, 1);
                this.f16412V.setTypeface(font, 0);
                this.f16413W.setTypeface(font, 0);
                m12064e(NetworkConstants.CURRENCY_USDC);
            } else if (i == R.id.btn_coin_solana) {
                this.f16409S.setTypeface(font, 0);
                this.f16410T.setTypeface(font, 0);
                this.f16411U.setTypeface(font, 0);
                this.f16412V.setTypeface(font2, 1);
                this.f16413W.setTypeface(font, 0);
                m12064e(NetworkConstants.CURRENCY_SOLANA);
            } else if (i == R.id.btn_coin_mana) {
                this.f16409S.setTypeface(font, 0);
                this.f16410T.setTypeface(font, 0);
                this.f16411U.setTypeface(font, 0);
                this.f16412V.setTypeface(font, 0);
                this.f16413W.setTypeface(font2, 1);
                m12064e(NetworkConstants.CURRENCY_MANA);
            }
        }
    }

    /* renamed from: e */
    private void m12064e(String str) {
        MulticoinState multicoinState = this.f16430an.get(str);
        if (multicoinState == null) {
            m12048c();
        } else if (multicoinState.equals(MulticoinState.HAS_TRANSACTION)) {
            m12055d();
        } else {
            m12048c();
        }
    }

    /* renamed from: c */
    private void m12049c(int i) {
        if (getContext() != null && getContext() != null) {
            Typeface font = ResourcesCompat.getFont(getContext(), R.font.regular);
            Typeface font2 = ResourcesCompat.getFont(getContext(), R.font.bold);
            if (i == R.id.btn_crypto_graph_btn_day) {
                this.f16414X.setTypeface(font2, 1);
                this.f16415Y.setTypeface(font, 0);
                this.f16416Z.setTypeface(font, 0);
                this.f16418aa.setTypeface(font, 0);
            } else if (i == R.id.btn_crypto_graph_btn_week) {
                this.f16414X.setTypeface(font, 0);
                this.f16415Y.setTypeface(font2, 1);
                this.f16416Z.setTypeface(font, 0);
                this.f16418aa.setTypeface(font, 0);
            } else if (i == R.id.btn_crypto_graph_btn_month) {
                this.f16414X.setTypeface(font, 0);
                this.f16415Y.setTypeface(font, 0);
                this.f16416Z.setTypeface(font2, 1);
                this.f16418aa.setTypeface(font, 0);
            } else if (i == R.id.btn_crypto_graph_btn_year) {
                this.f16414X.setTypeface(font, 0);
                this.f16415Y.setTypeface(font, 0);
                this.f16416Z.setTypeface(font, 0);
                this.f16418aa.setTypeface(font2, 1);
            }
        }
    }

    /* renamed from: a */
    private void m12033a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("dcrypto_banner_top_title");
            String optString2 = jSONObject.optString("dcrypto_banner_top_subtitle");
            this.f16439k.setText(optString);
            this.f16440l.setText(optString2);
        }
    }

    /* renamed from: a */
    private void m12026a(View view, JSONObject jSONObject) {
        m12025a(view, (int) R.id.cardview_crypto_bottom_banner_1, jSONObject);
        m12025a(view, (int) R.id.cardview_crypto_bottom_banner_2, jSONObject);
        m12025a(view, (int) R.id.cardview_crypto_bottom_banner_3, jSONObject);
        m12025a(view, (int) R.id.cardview_crypto_bottom_banner_4, jSONObject);
    }

    /* renamed from: a */
    private void m12025a(View view, int i, JSONObject jSONObject) {
        CardView cardView = (CardView) view.findViewById(i);
        TextView textView = (TextView) cardView.findViewById(R.id.tv_crypto_bottom_banner_title);
        TextView textView2 = (TextView) cardView.findViewById(R.id.tv_crypto_bottom_banner_subtitle);
        Button button = (Button) cardView.findViewById(R.id.btn_crypto_bottom_banner);
        ImageView imageView = (ImageView) cardView.findViewById(R.id.iv_crypto_bottom_banner_img);
        if (i == R.id.cardview_crypto_bottom_banner_1) {
            this.f16454z = cardView;
            JSONObject optJSONObject = jSONObject.optJSONObject("dcrypto_banner_1");
            textView.setText(optJSONObject.optString("dcrypto_banner_1_title"));
            textView2.setText(optJSONObject.optString("dcrypto_banner_1_subtitle"));
            button.setText(optJSONObject.optString("dcrypto_banner_1_btn_text"));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m12094l(view);
                }
            });
            if (getContext() != null && DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                Picasso.with(getContext()).load(optJSONObject.optString("dcrypto_banner_1_url")).placeholder((int) R.drawable.bottom_banner_pic_1).into(imageView);
            }
        } else if (i == R.id.cardview_crypto_bottom_banner_2) {
            this.f16401A = cardView;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("dcrypto_banner_2");
            textView.setText(optJSONObject2.optString("dcrypto_banner_2_title"));
            textView2.setText(optJSONObject2.optString("dcrypto_banner_2_subtitle"));
            button.setText(optJSONObject2.optString("dcrypto_banner_2_btn_text"));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m12091k(view);
                }
            });
            if (getContext() != null && DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                Picasso.with(getContext()).load(optJSONObject2.optString("dcrypto_banner_2_url")).placeholder((int) R.drawable.bottom_banner_pic_1).into(imageView);
            }
        } else if (i == R.id.cardview_crypto_bottom_banner_3) {
            this.f16402B = cardView;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("dcrypto_banner_3");
            textView.setText(optJSONObject3.optString("dcrypto_banner_3_title"));
            textView2.setText(optJSONObject3.optString("dcrypto_banner_3_subtitle"));
            button.setText(optJSONObject3.optString("dcrypto_banner_3_btn_text"));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m12086j(view);
                }
            });
            if (getContext() != null && DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                Picasso.with(getContext()).load(optJSONObject3.optString("dcrypto_banner_3_url")).placeholder((int) R.drawable.bottom_banner_pic_1).into(imageView);
            }
        } else if (i == R.id.cardview_crypto_bottom_banner_4) {
            this.f16403C = cardView;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("dcrypto_banner_4");
            textView.setText(optJSONObject4.optString("dcrypto_banner_4_title"));
            textView2.setText(optJSONObject4.optString("dcrypto_banner_4_subtitle"));
            button.setText(optJSONObject4.optString("dcrypto_banner_4_btn_text"));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m12082i(view);
                }
            });
            if (getContext() != null && DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                Picasso.with(getContext()).load(optJSONObject4.optString("dcrypto_banner_4_url")).placeholder((int) R.drawable.bottom_banner_pic_1).into(imageView);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m12094l(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_1).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void m12091k(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_2).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m12086j(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_3).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m12082i(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_4).start(getContext());
    }

    /* renamed from: w */
    private void m12110w() {
        if (getContext() != null) {
            String string = getString(R.string.Fintech_Payment_Solution_Buy_Crypto_hwEw);
            String string2 = getString(R.string.dcrypto_banner_top_subtitle);
            this.f16439k.setText(string);
            this.f16440l.setText(string2);
        }
    }

    /* renamed from: d */
    private void m12056d(View view) {
        m12024a(view, (int) R.id.cardview_crypto_bottom_banner_1);
        m12024a(view, (int) R.id.cardview_crypto_bottom_banner_2);
        m12024a(view, (int) R.id.cardview_crypto_bottom_banner_3);
        m12024a(view, (int) R.id.cardview_crypto_bottom_banner_4);
    }

    /* renamed from: a */
    private void m12024a(View view, int i) {
        if (getContext() != null) {
            CardView cardView = (CardView) view.findViewById(i);
            TextView textView = (TextView) cardView.findViewById(R.id.tv_crypto_bottom_banner_title);
            TextView textView2 = (TextView) cardView.findViewById(R.id.tv_crypto_bottom_banner_subtitle);
            Button button = (Button) cardView.findViewById(R.id.btn_crypto_bottom_banner);
            ImageView imageView = (ImageView) cardView.findViewById(R.id.iv_crypto_bottom_banner_img);
            if (DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                button.setBackgroundResource(R.drawable.roundbutton_mouton);
            } else if (DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                button.setBackgroundResource(R.drawable.roundbutton_latour);
            }
            if (i == R.id.cardview_crypto_bottom_banner_1) {
                this.f16454z = cardView;
                textView.setText(getString(R.string.dcrypto_banner_1_title));
                textView2.setText(getString(R.string.dcrypto_banner_1_subtitle));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DCryptoMainFragment.this.m12078h(view);
                    }
                });
                imageView.setImageResource(R.drawable.bottom_banner_pic_1);
            } else if (i == R.id.cardview_crypto_bottom_banner_2) {
                this.f16401A = cardView;
                textView.setText(getString(R.string.dcrypto_banner_2_title));
                textView2.setText(getString(R.string.dcrypto_banner_2_subtitle));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DCryptoMainFragment.this.m12073g(view);
                    }
                });
                imageView.setImageResource(R.drawable.bottom_banner_pic_2);
            } else if (i == R.id.cardview_crypto_bottom_banner_3) {
                this.f16402B = cardView;
                textView.setText(getString(R.string.dcrypto_banner_3_title));
                textView2.setText(getString(R.string.dcrypto_banner_3_subtitle));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DCryptoMainFragment.this.m12067f(view);
                    }
                });
                imageView.setImageResource(R.drawable.bottom_banner_pic_3);
            } else if (i == R.id.cardview_crypto_bottom_banner_4) {
                this.f16403C = cardView;
                textView.setText(getString(R.string.dcrypto_banner_4_title));
                textView2.setText(getString(R.string.dcrypto_banner_4_subtitle));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DCryptoMainFragment.this.m12061e(view);
                    }
                });
                imageView.setImageResource(R.drawable.bottom_banner_pic_4);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m12078h(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_1).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m12073g(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_2).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m12067f(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_3).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m12061e(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_4).start(getContext());
    }

    /* renamed from: x */
    private void m12111x() {
        if (getContext() != null) {
            final GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(Payload.RESPONSE_OK);
            arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public void onBtnClick(DialogFragment dialogFragment, int i) {
                    globalAlertDialog.dismiss();
                }
            });
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.setTitle(MulticoinUtils.getMulticoinDialogTitle(getContext(), this.f16426aj));
            globalAlertDialog.setMsg(MulticoinUtils.getMulticoinDialogSubtitle(getContext(), this.f16426aj));
            if (!globalAlertDialog.isVisible()) {
                globalAlertDialog.show(((FragmentActivity) getContext()).getSupportFragmentManager(), "pwdDialog");
            }
        }
    }

    /* renamed from: y */
    private void m12112y() {
        if (getContext() != null) {
            this.f16419ac = LEGOUICreator.showDrawerTemplate(getContext(), new LEGODrawerModel4(getString(R.string.Wallet_App_process_We_need_NqaR), getString(R.string.Wallet_App_process_You_just_supq), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                }
            }, new LEGOBtnTextAndCallback(getString(R.string.Wallet_App_process_Continue_Qujd), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (DCryptoMainFragment.this.f16404D.equalsIgnoreCase("1")) {
                        DRouter.build("pay99://one/btc/kyc_policy_page").start(DCryptoMainFragment.this.getContext());
                    } else {
                        ((Request) ((Request) DRouter.build("99OneTravel://one/full_kyc_channel").putExtra("type", "99")).putExtra("source", "7")).start(DCryptoMainFragment.this.getContext());
                    }
                    DCryptoMainFragment.this.f16419ac.dismiss();
                    OmegaUtils.ibt_microinvest_agreementpopup_continue_ck();
                }
            }), new LEGOBtnTextAndCallback(getString(R.string.Wallet_App_process_Cancel_kZXx), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    DCryptoMainFragment.this.f16419ac.dismiss();
                    OmegaUtils.ibt_microinvest_agreementpopup_cancel_ck();
                }
            })).setClickOutsideCanCancel(false).setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                }
            }));
            OmegaUtils.ibt_microinvest_agreementpopup_popup_sw();
        }
    }

    class GetPriceTimerTask extends TimerTask {
        GetPriceTimerTask() {
        }

        public void run() {
            new GetPriceAsyncTask().execute(new String[]{""});
        }
    }

    public class GetPriceAsyncTask extends AsyncTask<String, Void, String[]> {
        String server_response;

        public GetPriceAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String[] doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_PRICE + ("?cryptoCurrencySymbol=" + DCryptoMainFragment.this.f16426aj + "&lang=en-US&token=") + OneLoginFacade.getStore().getToken()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetPrice requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetPriceAsyncTask", 1770);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "getprice response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetPriceAsyncTask", 1775);
                    return DCryptoMainFragment.this.m12071f(this.server_response);
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12060e();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String[] strArr) {
            super.onPostExecute(strArr);
            if (DCryptoMainFragment.shouldUpdatePrice && strArr != null && strArr.length != 0 && strArr[0] != null && strArr[1] != null) {
                SystemUtils.log(3, "Dcrypto HTTP", "" + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetPriceAsyncTask", 1809);
                DCryptoMainFragment.this.updateMainPriceTitle(strArr[0], strArr[1]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String[] m12071f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SystemUtils.log(2, "Dcrypto HTTP", "GetPrice result = " + jSONObject.toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1821);
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (optInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String optString2 = optJSONObject.optString("ask_price");
                optJSONObject.optString("bid_price");
                String optString3 = optJSONObject.optString("midnight_price");
                SystemUtils.log(4, "Dcrypto HTTP", "GetPrice price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1829);
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_GET_CRYPTO_PRICE, jSONObject.toString());
                }
                return new String[]{optString2, optString3};
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    DCryptoMainFragment.this.m12060e();
                }
            });
            SystemUtils.log(4, "Dcrypto HTTP", "GetPrice error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1844);
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public class GetAccountStatusAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetAccountStatusAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_ACCOUNT_STATUS + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountStatus requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetAccountStatusAsyncTask", 1888);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetAccountStatus response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetAccountStatusAsyncTask", 1893);
                    DCryptoMainFragment.this.m12076g(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12077h();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m12076g(String str) {
        try {
            SystemUtils.log(2, "Dcrypto HTTP", "GetAccountStatus result = " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1928);
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (optInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.f16404D = optJSONObject.optString("is_full_kyc");
                this.f16405E = optJSONObject.optString("crypto_account_status");
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountStatus price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1941);
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_ACCOUNT_STATUS, str);
                    return;
                }
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    DCryptoMainFragment.this.m12077h();
                }
            });
            SystemUtils.log(4, "Dcrypto HTTP", "GetAccountStatus error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1955);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class GetAccountInfoAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetAccountInfoAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_ACCOUNT_INFO + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountInfo requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetAccountInfoAsyncTask", 1977);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetAccountInfo response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetAccountInfoAsyncTask", 1982);
                    DCryptoMainFragment.this.m12080h(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12066f();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m12080h(String str) {
        ArrayList arrayList;
        String str2 = str;
        String str3 = NetworkConstants.CURRENCY_BTC;
        String str4 = "has_transaction";
        String str5 = "Default";
        try {
            SystemUtils.log(2, "Dcrypto HTTP", "GetAccountBalance result = " + str2, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2012);
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("errmsg");
            String str6 = "";
            String str7 = DCryptoUtils.KEY_HOME_ACCOUNT_BALANCE;
            if (optInt == 401) {
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountBalance errorno = " + optInt, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2018);
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountBalance error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2019);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12009B();
                    }
                });
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12066f();
                    }
                });
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), str7, str6);
                }
            } else if (optInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String optString2 = optJSONObject.optString("total_profit_loss");
                if ((optJSONObject.optInt(str4, 0) == 1 ? MulticoinState.HAS_TRANSACTION : MulticoinState.NO_TRANSACTION).equals(MulticoinState.HAS_TRANSACTION)) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m12008A();
                        }
                    });
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m12009B();
                        }
                    });
                }
                String optString3 = optJSONObject.optString("total_value");
                JSONArray optJSONArray = optJSONObject.optJSONArray("currency_balances");
                ArrayList arrayList2 = new ArrayList();
                int i = 0;
                while (i < optJSONArray.length()) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                    String optString4 = jSONObject2.optString("balance", str5);
                    String optString5 = jSONObject2.optString("currency_symbol", str5);
                    String optString6 = jSONObject2.optString("balance_available", str5);
                    JSONArray jSONArray = optJSONArray;
                    String optString7 = jSONObject2.optString("balance_locked", str5);
                    String optString8 = jSONObject2.optString("amount_brl", str5);
                    String str8 = str7;
                    String optString9 = jSONObject2.optString("ask_price", str5);
                    String str9 = optString2;
                    String optString10 = jSONObject2.optString("bid_price", str5);
                    String str10 = optString3;
                    String optString11 = jSONObject2.optString("midnight_price", str5);
                    int i2 = i;
                    String optString12 = jSONObject2.optString("daily_profit_loss", str5);
                    ArrayList arrayList3 = arrayList2;
                    String optString13 = jSONObject2.optString("icon_url", str6);
                    String str11 = str6;
                    String str12 = str5;
                    String optString14 = jSONObject2.optString("crypto_title", str5);
                    int optInt2 = jSONObject2.optInt(str4, 0);
                    MulticoinState multicoinState = optInt2 == 1 ? MulticoinState.HAS_TRANSACTION : MulticoinState.NO_TRANSACTION;
                    boolean equalsIgnoreCase = optString5.equalsIgnoreCase(str3);
                    String str13 = NetworkConstants.CURRENCY_MANA;
                    String str14 = str3;
                    String str15 = str4;
                    String str16 = optString13;
                    int i3 = optInt2;
                    if (equalsIgnoreCase) {
                        str13 = str14;
                    } else if (optString5.equalsIgnoreCase(NetworkConstants.CURRENCY_ETH)) {
                        str13 = NetworkConstants.CURRENCY_ETH;
                    } else if (optString5.equalsIgnoreCase(NetworkConstants.CURRENCY_USDC)) {
                        str13 = NetworkConstants.CURRENCY_USDC;
                    } else if (optString5.equalsIgnoreCase(NetworkConstants.CURRENCY_SOLANA)) {
                        str13 = NetworkConstants.CURRENCY_SOLANA;
                    } else if (!optString5.equalsIgnoreCase(str13)) {
                        str13 = "null";
                    }
                    if (!str13.equalsIgnoreCase("null")) {
                        this.f16430an.put(str13, multicoinState);
                    }
                    try {
                        if (Double.parseDouble(optString6) >= 0.0d) {
                            arrayList = arrayList3;
                            try {
                                arrayList.add(new AccountInfoMulticoinBalance(optString4, optString5, optString6, optString7, optString8, optString9, optString10, optString11, optString12, i3, str16, optString14));
                            } catch (Exception e) {
                                e = e;
                            }
                        } else {
                            arrayList = arrayList3;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = arrayList3;
                        SystemUtils.log(4, "DcryptoMulticoin", e.getMessage(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2089);
                        arrayList.add(new AccountInfoMulticoinBalance(optString4, optString5, optString6, optString7, optString8, optString9, optString10, optString11, optString12, i3, str16, optString14));
                        i = i2 + 1;
                        String str17 = str;
                        arrayList2 = arrayList;
                        optJSONArray = jSONArray;
                        str7 = str8;
                        optString2 = str9;
                        optString3 = str10;
                        str6 = str11;
                        str5 = str12;
                        str3 = str14;
                        str4 = str15;
                    }
                    i = i2 + 1;
                    String str172 = str;
                    arrayList2 = arrayList;
                    optJSONArray = jSONArray;
                    str7 = str8;
                    optString2 = str9;
                    optString3 = str10;
                    str6 = str11;
                    str5 = str12;
                    str3 = str14;
                    str4 = str15;
                }
                String str18 = str7;
                new Handler(Looper.getMainLooper()).post(new Runnable(optString2, optString3, arrayList2) {
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ String f$2;
                    public final /* synthetic */ List f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        DCryptoMainFragment.this.m12045b(this.f$1, this.f$2, this.f$3);
                    }
                });
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), str18, str);
                }
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12066f();
                    }
                });
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountBalance error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2106);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public class GetDailyProfitLossAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetDailyProfitLossAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_DAILY_PROFIT_LOSS + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetDailyProfitLoss requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetDailyProfitLossAsyncTask", 2126);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetDailyProfitLoss response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetDailyProfitLossAsyncTask", 2131);
                    DCryptoMainFragment.this.m12084i(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12072g();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m12084i(String str) {
        try {
            SystemUtils.log(2, "Dcrypto HTTP", "GetDailyProfitLoss result = " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2162);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (i == 0) {
                new Handler(Looper.getMainLooper()).post(new Runnable(jSONObject.optJSONObject("data").optString("daily_profit_loss")) {
                    public final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DCryptoMainFragment.this.m12099m(this.f$1);
                    }
                });
                SystemUtils.log(4, "Dcrypto HTTP", "GetDailyProfitLoss price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2170);
            } else {
                SystemUtils.log(4, "Dcrypto HTTP", "GetDailyProfitLoss error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2172);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12072g();
                    }
                });
            }
            if (getContext() != null) {
                DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_DAILY_PROFIT_AND_LOSS, str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class GetTransactionHistoryAsyncTask extends AsyncTask<String, Void, JSONObject> {
        String server_response;

        /* access modifiers changed from: protected */
        public void onPostExecute(JSONObject jSONObject) {
        }

        public GetTransactionHistoryAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public JSONObject doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_TRANSACTION_HISTORY + "?cryptoCurrencySymbol=ALL&lang=en-US&token=" + OneLoginFacade.getStore().getToken()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetTransactionHistory requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetTransactionHistoryAsyncTask", 2205);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetTransactionHistory response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetTransactionHistoryAsyncTask", 2209);
                    DCryptoMainFragment.this.m12088j(this.server_response);
                    return null;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.GetTransactionHistoryAsyncTask.this.mo53759xeadd0a68();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        /* renamed from: lambda$doInBackground$0$DCryptoMainFragment$GetTransactionHistoryAsyncTask */
        public /* synthetic */ void mo53759xeadd0a68() {
            DCryptoMainFragment.this.m12081i();
            DCryptoMainFragment.this.m12048c();
            DCryptoMainFragment.this.f16448t.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m12088j(String str) {
        try {
            SystemUtils.log(2, "Dcrypto HTTP", "GetTransactionHistory result = " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2244);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errno");
            String optString = jSONObject.optString("errmsg");
            this.f16406P = false;
            if (i == 0) {
                JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("orders");
                if (optJSONArray.length() > 0) {
                    this.f16406P = true;
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m12016I();
                        }
                    });
                    new Handler(Looper.getMainLooper()).post(new Runnable(m12037b(optJSONArray.optJSONObject(0))) {
                        public final /* synthetic */ BitcoinHistoryItemModel f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m12043b(this.f$1);
                        }
                    });
                    if (optJSONArray.length() > 1) {
                        new Handler(Looper.getMainLooper()).post(new Runnable(m12037b(optJSONArray.optJSONObject(1))) {
                            public final /* synthetic */ BitcoinHistoryItemModel f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                DCryptoMainFragment.this.m12029a(this.f$1);
                            }
                        });
                    }
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m12015H();
                        }
                    });
                }
                SystemUtils.log(4, "Dcrypto HTTP", "GetTransactionHistory = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2287);
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_HISTORY_ITEMS, str);
                    return;
                }
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    DCryptoMainFragment.this.m12014G();
                }
            });
            SystemUtils.log(4, "Dcrypto HTTP", "GetTransactionHistory error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2308);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void m12016I() {
        m12113z();
        OmegaUtils.ibt_microinvest_mihomepurchased_page_sw();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m12043b(BitcoinHistoryItemModel bitcoinHistoryItemModel) {
        m12085j();
        m12027a(this.f16450v, bitcoinHistoryItemModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12029a(BitcoinHistoryItemModel bitcoinHistoryItemModel) {
        m12090k();
        m12027a(this.f16451w, bitcoinHistoryItemModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void m12015H() {
        m12010C();
        OmegaUtils.ibt_microinvest_mihomenotpurchased_page_sw();
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void m12014G() {
        m12081i();
        m12048c();
        this.f16448t.setVisibility(8);
        OmegaUtils.ibt_microinvest_mihomenotpurchased_page_sw();
    }

    /* renamed from: b */
    private BitcoinHistoryItemModel m12037b(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = jSONObject;
        try {
            String optString = jSONObject2.optString("sn");
            String optString2 = jSONObject2.optString("client_order_id");
            String optString3 = jSONObject2.optString("market_symbol");
            String optString4 = jSONObject2.optString("side");
            String optString5 = jSONObject2.optString(ParamConst.PARAM_CART_REMARK);
            String optString6 = jSONObject2.optString("state");
            if (!f16388F.equalsIgnoreCase(optString6) && !f16391I.equalsIgnoreCase(optString6)) {
                if (!f16390H.equalsIgnoreCase(optString6)) {
                    if (f16389G.equalsIgnoreCase(optString6)) {
                        str = "";
                    } else {
                        str = f16392J.equalsIgnoreCase(optString6) ? f16395M : DCRYPTO_NA;
                    }
                    return new BitcoinHistoryItemModel(optString, optString2, optString3, optString4, optString5, str, jSONObject2.optString("price_avg"), jSONObject2.optString(FirebaseAnalytics.Param.QUANTITY), jSONObject2.optString("quantity_executed"), jSONObject2.optString("instant_amount"), jSONObject2.optString("instant_amount_executed"), jSONObject2.optString("created_at"), jSONObject2.getLong("timestamp"));
                }
            }
            str = f16394L;
            return new BitcoinHistoryItemModel(optString, optString2, optString3, optString4, optString5, str, jSONObject2.optString("price_avg"), jSONObject2.optString(FirebaseAnalytics.Param.QUANTITY), jSONObject2.optString("quantity_executed"), jSONObject2.optString("instant_amount"), jSONObject2.optString("instant_amount_executed"), jSONObject2.optString("created_at"), jSONObject2.getLong("timestamp"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: z */
    private void m12113z() {
        if (getContext() != null) {
            this.f16448t.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m12008A() {
        if (getContext() != null) {
            m12022a(8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f16408R.getLayoutParams();
            if (getContext() != null) {
                layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (float) 30, getContext().getResources().getDisplayMetrics()), 0, 0);
            }
            this.f16408R.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m12009B() {
        m12022a(0);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f16408R.getLayoutParams();
        if (getContext() != null) {
            layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (float) 0, getContext().getResources().getDisplayMetrics()), 0, 0);
        }
        this.f16408R.setLayoutParams(layoutParams);
    }

    /* renamed from: C */
    private void m12010C() {
        if (getContext() != null) {
            m12081i();
            m12008A();
            m12048c();
            this.f16448t.setVisibility(8);
        }
    }

    public class GetUIConfigForBannersAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetUIConfigForBannersAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_UI_CONFIG_FOR_BANNERS + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "get GetUIConfig requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetUIConfigForBannersAsyncTask", 2429);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetUIConfigForBannersAsyncTask", 2434);
                    DCryptoMainFragment.this.m12092k(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12011D();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m12092k(String str) {
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int i = jSONObject.getInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (i == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (this.f16417a.equalsIgnoreCase("en-US")) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject) {
                        public final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m12070f(this.f$1);
                        }
                    });
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject) {
                        public final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m12065e(this.f$1);
                        }
                    });
                } else if (this.f16417a.equalsIgnoreCase("pt-BR")) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject) {
                        public final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m12059d(this.f$1);
                        }
                    });
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject) {
                        public final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m12053c(this.f$1);
                        }
                    });
                } else {
                    SystemUtils.log(4, "Dcrypto HTTP", "error retrieving Locale before parsing data", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2477);
                }
                SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2482);
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_UI_CONFIG, str2);
                }
            } else {
                SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2488);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12011D();
                    }
                });
            }
            SystemUtils.log(2, "Dcrypto HTTP", "GetUIConfig result = " + str2, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2492);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m12070f(JSONObject jSONObject) {
        m12026a((View) this.f16434f, jSONObject.optJSONObject("en-US"));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m12065e(JSONObject jSONObject) {
        m12033a(jSONObject.optJSONObject("en-US").optJSONObject("dcrypto_banner_top"));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m12059d(JSONObject jSONObject) {
        m12026a((View) this.f16434f, jSONObject.optJSONObject("pt-BR"));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m12053c(JSONObject jSONObject) {
        m12033a(jSONObject.optJSONObject("pt-BR").optJSONObject("dcrypto_banner_top"));
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m12011D() {
        m12110w();
        m12056d((View) this.f16434f);
    }

    public class GetIPBlockAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetIPBlockAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_IP_BLOCK + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "get IPBlock requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetIPBlockAsyncTask", 2517);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "IPBlock response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetIPBlockAsyncTask", 2522);
                    DCryptoUtils.setIPBlockTimestamp();
                    DCryptoMainFragment.this.m12096l(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12011D();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m12096l(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (i == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String optString2 = optJSONObject.optString("country_code");
                optJSONObject.optString("ip");
                if (optString2.equalsIgnoreCase(GlobalCountryCode.CHINA)) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m12013F();
                        }
                    });
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m12012E();
                        }
                    });
                }
            } else {
                SystemUtils.log(4, "Dcrypto HTTP", "processIPBlock error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2575);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m12011D();
                    }
                });
            }
            SystemUtils.log(2, "Dcrypto HTTP", "processIPBlock result = " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2579);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void m12013F() {
        if (getContext() != null) {
            DCryptoUtils.setDcryptoIPStatus(getContext(), DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK);
        }
        this.f16425ai.getChart().post(new Runnable() {
            public final void run() {
                DCryptoMainFragment.this.m12021a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void m12012E() {
        if (getContext() != null) {
            DCryptoUtils.setDcryptoIPStatus(getContext(), DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK);
        }
    }

    public class GetCryptoTopBannersAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetCryptoTopBannersAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_CRYPTO_TOP_BANNER + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                DCryptoMainFragment.this.m12032a((URLConnection) httpURLConnection);
                SystemUtils.log(4, "Dcrypto HTTP", "get GetUIConfig requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2600);
                if (httpURLConnection.getResponseCode() != 200) {
                    return null;
                }
                this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2605);
                JSONObject jSONObject = new JSONObject(this.server_response);
                int i = jSONObject.getInt("errno");
                String optString = jSONObject.optString("errmsg");
                if (i == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    optJSONObject.optBoolean("shown", false);
                    optJSONObject.optString("title", "Default title");
                    optJSONObject.optString("subTitle", "Default subTitle");
                    optJSONObject.optString("pictureUrl", "Default pictureUrl");
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject.optString("linkUrl", "Default linkUrl")) {
                        public final /* synthetic */ String f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            DCryptoMainFragment.GetCryptoTopBannersAsyncTask.lambda$doInBackground$0(this.f$0);
                        }
                    });
                    SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2623);
                    return "";
                }
                SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2626);
                SystemUtils.log(2, "Dcrypto HTTP", "GetUIConfig result = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2630);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }

        static /* synthetic */ void lambda$doInBackground$0(String str) {
            if (str != null && !str.equalsIgnoreCase("")) {
                NetworkConstants.URL_BANNER_BOTTOM_1 = str;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12032a(URLConnection uRLConnection) {
        String str;
        Object obj = CommonProxyHolder.getProxy() == null ? null : CommonProxyHolder.getProxy().getBaseParams(getContext()).get("city_id");
        if (obj == null) {
            str = "null";
        } else {
            str = (String) obj;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Cityid", str);
        jsonObject.addProperty("FlowTag", "0");
        jsonObject.addProperty("Productid", "21032");
        jsonObject.addProperty(ServerParam.PARAM_TRIPCOUNTRY, "BR");
        jsonObject.addProperty("app_timeout_ms", "30000");
        jsonObject.addProperty("lang", "es-419");
        jsonObject.addProperty("lat", "-25.354746934932187");
        jsonObject.addProperty("lng", "-49.11376760594505");
        jsonObject.addProperty("locale", "es_CO");
        jsonObject.addProperty("location_cityid", str);
        jsonObject.addProperty("location_country", "BR");
        jsonObject.addProperty("passengerUtcOffset", "-180");
        jsonObject.addProperty("product_id", "21032");
        jsonObject.addProperty("utc_offset", "-180");
        uRLConnection.setRequestProperty("didi-header-hint-content", jsonObject.toString());
    }
}
