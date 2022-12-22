package com.didi.component.comp_flex.offer_price;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.util.DecimalUtils;
import com.didi.component.common.view.AmountDecimalEditText;
import com.didi.component.core.PresenterGroup;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.taxis99.R;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FlexOfferPriceFragment extends AbsNormalFragment {
    public static final String KEY_FLEX_DATA = "felx_offer_raise_data";

    /* renamed from: a */
    private View f12174a;

    /* renamed from: b */
    private TextView f12175b;

    /* renamed from: c */
    private TextView f12176c;

    /* renamed from: d */
    private TextView f12177d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AmountDecimalEditText f12178e;

    /* renamed from: f */
    private TextView f12179f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f12180g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BigDecimal f12181h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BigDecimal f12182i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Context f12183j;

    /* renamed from: k */
    private FlexOfferFragmentPresenter f12184k;

    /* renamed from: l */
    private View f12185l;

    /* renamed from: m */
    private final Logger f12186m = LoggerFactory.getLogger("FlexOfferPriceDialog");
    public JSONObject maxTipsSheet;
    public JSONObject minTipsSheet;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8230a(String str) {
        this.f12186m.info(str, new Object[0]);
    }

    public static FlexOfferPriceFragment newInstance(String str) {
        FlexOfferPriceFragment flexOfferPriceFragment = new FlexOfferPriceFragment();
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(KEY_FLEX_DATA, str);
        }
        flexOfferPriceFragment.setArguments(bundle);
        return flexOfferPriceFragment;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12185l = layoutInflater.inflate(R.layout.flex_offer_price_layout, viewGroup, false);
        initView();
        return this.f12185l;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f12183j = getContext();
        View findViewById = this.f12185l.findViewById(R.id.flex_back_iv);
        this.f12174a = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("k", "click");
                hashMap.put(RavenKey.VERSION, "offerprice_back");
                GlobalOmegaUtils.trackEvent("ibt_gp_offerprice_back_ck", (Map<String, Object>) hashMap);
                FlexOfferPriceFragment.this.m8234c();
            }
        });
        this.f12175b = (TextView) this.f12185l.findViewById(R.id.price_title);
        this.f12176c = (TextView) this.f12185l.findViewById(R.id.sub_price_title);
        this.f12177d = (TextView) this.f12185l.findViewById(R.id.flex_currency_symbol);
        this.f12178e = (AmountDecimalEditText) this.f12185l.findViewById(R.id.price_input_et);
        if (DRtlToolkit.rtl()) {
            this.f12178e.setLayoutDirection(1);
        }
        this.f12179f = (TextView) this.f12185l.findViewById(R.id.reference_price);
        TextView textView = (TextView) this.f12185l.findViewById(R.id.flex_confirm_price_btn);
        this.f12180g = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FlexOfferPriceFragment.this.f12180g.setEnabled(false);
                String obj = FlexOfferPriceFragment.this.f12178e.getText().toString();
                String standardAmountString = DecimalUtils.getStandardAmountString(obj);
                FlexOfferPriceFragment flexOfferPriceFragment = FlexOfferPriceFragment.this;
                flexOfferPriceFragment.m8230a("flex_confirm_price_btn onclick price =" + standardAmountString + "/ minPrice=" + FlexOfferPriceFragment.this.f12181h + "/ maxPrice=" + FlexOfferPriceFragment.this.f12182i + "? bargainAmountInputtedText= " + obj);
                HashMap hashMap = new HashMap();
                hashMap.put("k", "click");
                hashMap.put(RavenKey.VERSION, "offerprice_request");
                hashMap.put("price", standardAmountString);
                GlobalOmegaUtils.trackEvent("ibt_gp_offerprice_request_ck", (Map<String, Object>) hashMap);
                BigDecimal bigDecimal = new BigDecimal(standardAmountString);
                if (bigDecimal.compareTo(FlexOfferPriceFragment.this.f12181h) < 0) {
                    FlexOfferPriceFragment.this.m8227a();
                } else if (bigDecimal.compareTo(FlexOfferPriceFragment.this.f12182i) > 0) {
                    FlexOfferPriceFragment.this.m8232b();
                } else {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_ENTER_CONFIRM_ADDRESS, standardAmountString);
                    FlexOfferPriceFragment.this.m8234c();
                }
            }
        });
        this.f12178e.setCustomizedAfterTextChangeListener(new AmountDecimalEditText.CustomizedAfterTextChangeListener() {
            public void afterTextChanged(String str) {
                FlexOfferPriceFragment.this.f12180g.setEnabled(str != null && !TextUtils.isEmpty(str));
            }
        });
        this.f12180g.setEnabled(false);
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getString(KEY_FLEX_DATA) == null)) {
            OfferFlexPriceModel offerFlexPriceModel = new OfferFlexPriceModel();
            offerFlexPriceModel.parse(arguments.getString(KEY_FLEX_DATA));
            setData(offerFlexPriceModel);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("k", "access");
        hashMap.put(RavenKey.VERSION, "offerprice");
        GlobalOmegaUtils.trackEvent("ibt_gp_offerprice_sw", (Map<String, Object>) hashMap);
    }

    public void autoShowKeyboard() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                ((InputMethodManager) FlexOfferPriceFragment.this.f12178e.getContext().getSystemService("input_method")).showSoftInput(FlexOfferPriceFragment.this.f12178e, 0);
            }
        }, 500);
    }

    public void hideKeyboard() {
        AmountDecimalEditText amountDecimalEditText = this.f12178e;
        if (amountDecimalEditText != null) {
            ((InputMethodManager) amountDecimalEditText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f12178e.getWindowToken(), 0);
        }
    }

    public void setData(OfferFlexPriceModel offerFlexPriceModel) {
        if (offerFlexPriceModel == null) {
            m8230a("offer price data is null");
            return;
        }
        this.f12181h = new BigDecimal(offerFlexPriceModel.min_price);
        this.f12182i = new BigDecimal(offerFlexPriceModel.max_price);
        this.minTipsSheet = offerFlexPriceModel.minTipsSheet;
        this.maxTipsSheet = offerFlexPriceModel.maxTipsSheet;
        if (!TextUtils.isEmpty(offerFlexPriceModel.recommend_price)) {
            BigDecimal bigDecimal = new BigDecimal(offerFlexPriceModel.recommend_price);
            if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                this.f12178e.setText(bigDecimal.toString());
            }
        }
        this.f12178e.requestFocus();
        offerFlexPriceModel.title.bindTextView(this.f12175b);
        offerFlexPriceModel.sub_title.bindTextView(this.f12176c);
        this.f12177d.setText(offerFlexPriceModel.currency_symbol);
        offerFlexPriceModel.reference_price.bindTextView(this.f12179f);
        this.f12180g.setText(offerFlexPriceModel.button_text);
        this.f12180g.setEnabled(false);
        try {
            this.f12180g.setBackground(DidiThemeManager.getIns().getResPicker(this.f12185l.getContext()).getDrawable(R.attr.global_overall_main_button_selector));
            this.f12180g.setTextColor(ContextCompat.getColorStateList(this.f12183j, DidiThemeManager.getIns().getResPicker(this.f12183j).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
            if (offerFlexPriceModel.button_text != null && !TextUtils.isEmpty(offerFlexPriceModel.button_text)) {
                this.f12180g.setText(offerFlexPriceModel.button_text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        autoShowKeyboard();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8227a() {
        GGKConfigManager.legoConfig(getActivity(), this.minTipsSheet, "passenger_newSheet", new GGKConfigCallbackAdapter() {
            public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
                if (lEGODrawer == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    DRouter.build(str).start(FlexOfferPriceFragment.this.f12183j);
                    FlexOfferPriceFragment.this.m8234c();
                }
                FlexOfferPriceFragment.this.f12180g.setEnabled(true);
                if (buttonModel.nodismiss == 1) {
                    return false;
                }
                lEGODrawer.dismiss();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8232b() {
        GGKConfigManager.legoConfig(getActivity(), this.maxTipsSheet, "passenger_newSheet", new GGKConfigCallbackAdapter() {
            public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
                if (lEGODrawer == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    DRouter.build(str).start(FlexOfferPriceFragment.this.f12183j);
                    FlexOfferPriceFragment.this.m8234c();
                }
                FlexOfferPriceFragment.this.f12180g.setEnabled(true);
                if (buttonModel.nodismiss == 1) {
                    return false;
                }
                lEGODrawer.dismiss();
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        FlexOfferFragmentPresenter flexOfferFragmentPresenter = new FlexOfferFragmentPresenter(getContext(), getArguments());
        this.f12184k = flexOfferFragmentPresenter;
        return flexOfferFragmentPresenter;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8234c() {
        getActivity().finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.f12185l = null;
        hideKeyboard();
    }
}
