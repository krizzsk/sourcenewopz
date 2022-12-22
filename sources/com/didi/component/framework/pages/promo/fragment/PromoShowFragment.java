package com.didi.component.framework.pages.promo.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.framework.pages.promo.PromoCodePage;
import com.didi.component.framework.pages.promo.helper.MapToSharePlatform;
import com.didi.component.framework.pages.promo.model.PromoData;
import com.didi.component.framework.pages.promo.presenter.PromoShowPresenter;
import com.didi.component.framework.pages.promo.view.IPromoShowView;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebTitleBar;
import com.didi.sdk.webview.WebViewModel;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002-.B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J8\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00052&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a`\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\fH\u0016J&\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/fragment/PromoShowFragment;", "Lcom/didi/sdk/home/BizEntranceFragment;", "Lcom/didi/component/framework/pages/promo/view/IPromoShowView;", "()V", "mCountryCode", "", "mListener", "Lcom/didi/component/framework/pages/promo/fragment/ActionListener;", "mPresenter", "Lcom/didi/component/framework/pages/promo/presenter/PromoShowPresenter;", "mPromoCode", "mRootView", "Landroid/view/View;", "mTitle", "mTitleBar", "Lcom/didi/sdk/webview/WebTitleBar;", "getFallbackView", "getView", "hideLoadingView", "", "onApplyError", "msg", "onApplyH5Success", "url", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onApplySuccess", "rspData", "Lcom/didi/component/framework/pages/promo/model/PromoData;", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setPresenter", "presenter", "showLoadingView", "traceEvent", "event", "Companion", "EmojiFilter", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoShowFragment.kt */
public final class PromoShowFragment extends BizEntranceFragment implements IPromoShowView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: h */
    private static final String f13937h = "promoCode";

    /* renamed from: i */
    private static final String f13938i = "countryCode";

    /* renamed from: j */
    private static final String f13939j = "title";

    /* renamed from: k */
    private static final String f13940k = "https://page.didiglobal.com/common-biz/global-coupon/index.html";

    /* renamed from: l */
    private static final String f13941l = "https://page.99taxis.mobi/pay_intl_passenger/coupon_list/coupon_list.html";

    /* renamed from: a */
    private View f13942a;

    /* renamed from: b */
    private PromoShowPresenter f13943b;

    /* renamed from: c */
    private String f13944c = "";

    /* renamed from: d */
    private String f13945d = "br";

    /* renamed from: e */
    private String f13946e = "";

    /* renamed from: f */
    private ActionListener f13947f;

    /* renamed from: g */
    private WebTitleBar f13948g;

    public void _$_clearFindViewByIdCache() {
    }

    public void setPresenter(PromoShowPresenter promoShowPresenter) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        WebTitleBar webTitleBar;
        String str;
        View view;
        EditText editText;
        EditText editText2;
        EditText editText3;
        TextView textView;
        TextView textView2;
        String str2;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.global_fragment_coupon_show, viewGroup, false);
        this.f13942a = inflate;
        TextView textView3 = null;
        if (inflate == null) {
            webTitleBar = null;
        } else {
            webTitleBar = (WebTitleBar) inflate.findViewById(R.id.center_title_bar);
        }
        this.f13948g = webTitleBar;
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        PromoShowPresenter promoShowPresenter = new PromoShowPresenter(activity);
        this.f13943b = promoShowPresenter;
        if (promoShowPresenter != null) {
            promoShowPresenter.setIView(this);
        }
        FragmentActivity activity2 = getActivity();
        this.f13947f = activity2 instanceof ActionListener ? (ActionListener) activity2 : null;
        Bundle arguments = getArguments();
        String str3 = "";
        if (arguments == null || (str = arguments.getString("promoCode", str3)) == null) {
            str = str3;
        }
        this.f13944c = str;
        Bundle arguments2 = getArguments();
        String str4 = "br";
        if (!(arguments2 == null || (string2 = arguments2.getString("countryCode")) == null)) {
            str4 = string2;
        }
        this.f13945d = str4;
        Bundle arguments3 = getArguments();
        if (!(arguments3 == null || (string = arguments3.getString("title")) == null)) {
            str3 = string;
        }
        this.f13946e = str3;
        WebTitleBar webTitleBar2 = this.f13948g;
        boolean z = true;
        if (webTitleBar2 != null) {
            if (str3.length() > 0) {
                str2 = this.f13946e;
            } else {
                FragmentActivity activity3 = getActivity();
                Intrinsics.checkNotNull(activity3);
                str2 = ResourcesHelper.getString(activity3, R.string.global_promo_code_top);
            }
            webTitleBar2.setTitle(str2);
        }
        View view2 = this.f13942a;
        Button button = view2 == null ? null : (Button) view2.findViewById(R.id.global_promo_apply_btn);
        if (button != null) {
            button.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_selector));
        }
        if (button != null) {
            try {
                FragmentActivity activity4 = getActivity();
                Intrinsics.checkNotNull(activity4);
                button.setTextColor(ContextCompat.getColorStateList(activity4, DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            } catch (Resources.NotFoundException e) {
                GLog.m7965d("PromoShowFragment", e.getMessage());
            }
        }
        if (button != null) {
            button.setOnClickListener(this);
        }
        View view3 = this.f13942a;
        if (!(view3 == null || (textView2 = (TextView) view3.findViewById(R.id.global_promo_terms_of_use)) == null)) {
            textView2.setOnClickListener(this);
        }
        View view4 = this.f13942a;
        if (!(view4 == null || (textView = (TextView) view4.findViewById(R.id.global_promo_vouchers)) == null)) {
            textView.setOnClickListener(this);
        }
        InputFilter[] inputFilterArr = {new InputFilter.LengthFilter(50), new EmojiFilter(this)};
        View view5 = this.f13942a;
        EditText editText4 = view5 == null ? null : (EditText) view5.findViewById(R.id.global_promo_etv);
        if (editText4 != null) {
            editText4.setFilters(inputFilterArr);
        }
        View view6 = this.f13942a;
        if (!(view6 == null || (editText3 = (EditText) view6.findViewById(R.id.global_promo_etv)) == null)) {
            editText3.addTextChangedListener(new PromoShowFragment$onCreateView$1(button));
        }
        View view7 = this.f13942a;
        if (!(view7 == null || (editText2 = (EditText) view7.findViewById(R.id.global_promo_etv)) == null)) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    PromoShowFragment.m9667a(PromoShowFragment.this, view, z);
                }
            });
        }
        if (this.f13944c.length() <= 0) {
            z = false;
        }
        if (z && this.f13944c.length() > 2 && (view = this.f13942a) != null && (editText = (EditText) view.findViewById(R.id.global_promo_etv)) != null) {
            editText.setText(this.f13944c);
        }
        WebTitleBar webTitleBar3 = this.f13948g;
        if (webTitleBar3 != null) {
            webTitleBar3.setCloseBtnVisibility(8);
        }
        WebTitleBar webTitleBar4 = this.f13948g;
        if (webTitleBar4 != null) {
            webTitleBar4.setMoreBtnVisibility(8);
        }
        WebTitleBar webTitleBar5 = this.f13948g;
        if (webTitleBar5 != null) {
            webTitleBar5.setBackBtnVisibility(0);
        }
        WebTitleBar webTitleBar6 = this.f13948g;
        TextView middleTv = webTitleBar6 == null ? null : webTitleBar6.getMiddleTv();
        if (middleTv != null) {
            middleTv.setTypeface(Typeface.DEFAULT_BOLD);
        }
        WebTitleBar webTitleBar7 = this.f13948g;
        if (webTitleBar7 != null) {
            textView3 = webTitleBar7.getMiddleTv();
        }
        if (textView3 != null) {
            textView3.setTextSize(21.0f);
        }
        WebTitleBar webTitleBar8 = this.f13948g;
        if (webTitleBar8 != null) {
            webTitleBar8.setOnBackClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PromoShowFragment.m9666a(PromoShowFragment.this, view);
                }
            });
        }
        m9668a(MapToSharePlatform.PROMO_SHOW_PAGE);
        return this.f13942a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9667a(PromoShowFragment promoShowFragment, View view, boolean z) {
        Intrinsics.checkNotNullParameter(promoShowFragment, "this$0");
        if (z) {
            promoShowFragment.m9668a(MapToSharePlatform.PROMO_CODE_INPUT_CK);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9666a(PromoShowFragment promoShowFragment, View view) {
        Intrinsics.checkNotNullParameter(promoShowFragment, "this$0");
        ActionListener actionListener = promoShowFragment.f13947f;
        if (actionListener != null) {
            actionListener.onBackArrowClick(PromoCodePage.PAGE_SHOW);
        }
    }

    public WebTitleBar getFallbackView() {
        return this.f13948g;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/fragment/PromoShowFragment$Companion;", "", "()V", "COUNTRY_CODE", "", "MY_VOUCHERS_URL_BR", "MY_VOUCHERS_URL_GLOBAL", "PROMO_CODE", "TITLE", "newInstance", "Lcom/didi/component/framework/pages/promo/fragment/PromoShowFragment;", "promoCode", "countryCode", "title", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PromoShowFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PromoShowFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "promoCode");
            Intrinsics.checkNotNullParameter(str2, "countryCode");
            Intrinsics.checkNotNullParameter(str3, "title");
            PromoShowFragment promoShowFragment = new PromoShowFragment();
            Bundle bundle = new Bundle();
            bundle.putString("promoCode", str);
            bundle.putString("countryCode", str2);
            bundle.putString("title", str3);
            promoShowFragment.setArguments(bundle);
            return promoShowFragment;
        }
    }

    public View getView() {
        return this.f13942a;
    }

    public void onClick(View view) {
        EditText editText;
        AutoTrackHelper.trackViewOnClick(view);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        boolean isGlobalApp = AppUtils.isGlobalApp(activity);
        View view2 = getView();
        Object obj = null;
        if (Intrinsics.areEqual((Object) view, (Object) view2 == null ? null : view2.findViewById(R.id.global_promo_apply_btn))) {
            PromoShowPresenter promoShowPresenter = this.f13943b;
            if (promoShowPresenter != null) {
                View view3 = this.f13942a;
                if (!(view3 == null || (editText = (EditText) view3.findViewById(R.id.global_promo_etv)) == null)) {
                    obj = editText.getText();
                }
                promoShowPresenter.applyPromoCode(String.valueOf(obj));
            }
            m9668a(MapToSharePlatform.PROMO_APPLY_CLICK);
            return;
        }
        View view4 = getView();
        if (Intrinsics.areEqual((Object) view, (Object) view4 == null ? null : view4.findViewById(R.id.global_promo_terms_of_use))) {
            PromoShowPresenter promoShowPresenter2 = this.f13943b;
            if (promoShowPresenter2 != null) {
                promoShowPresenter2.goToTargetWeb("https://page.didiglobal.com/global/passenger/apps/redeem/rule-all/index.html");
            }
            m9668a(MapToSharePlatform.PROMO_TERM_OF_USE);
            return;
        }
        View view5 = getView();
        if (view5 != null) {
            obj = view5.findViewById(R.id.global_promo_vouchers);
        }
        if (Intrinsics.areEqual((Object) view, obj)) {
            if (isGlobalApp) {
                PromoShowPresenter promoShowPresenter3 = this.f13943b;
                if (promoShowPresenter3 != null) {
                    promoShowPresenter3.goToTargetWeb(f13940k);
                }
            } else {
                PromoShowPresenter promoShowPresenter4 = this.f13943b;
                if (promoShowPresenter4 != null) {
                    promoShowPresenter4.goToTargetWeb(f13941l);
                }
            }
            m9668a(MapToSharePlatform.PROMO_COUPON_CLICK);
        }
    }

    public void onApplySuccess(PromoData promoData) {
        ActionListener actionListener = this.f13947f;
        if (actionListener != null) {
            actionListener.addRspData(promoData);
        }
        ActionListener actionListener2 = this.f13947f;
        if (actionListener2 != null) {
            actionListener2.switchToSharePage();
        }
    }

    public void onApplyError(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        ActionListener actionListener = this.f13947f;
        if (actionListener != null) {
            actionListener.showDialog(str);
        }
    }

    public void showLoadingView() {
        showLoading();
        View view = this.f13942a;
        Button button = view == null ? null : (Button) view.findViewById(R.id.global_promo_apply_btn);
        if (button != null) {
            button.setEnabled(false);
        }
    }

    public void hideLoadingView() {
        hideLoading();
        View view = this.f13942a;
        Button button = view == null ? null : (Button) view.findViewById(R.id.global_promo_apply_btn);
        if (button != null) {
            button.setEnabled(true);
        }
    }

    public void onApplyH5Success(String str, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(hashMap, "params");
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.url = GlobalWebUrl.buildUrl(str, hashMap);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intent intent = new Intent(activity, BaseWebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        startActivity(intent);
    }

    /* renamed from: a */
    private final void m9668a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("country_code", this.f13945d);
        hashMap.put("city_id", NationComponentDataUtil.getLocCityId());
        LocationController instance = LocationController.getInstance();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        hashMap.put("locationA", Double.valueOf(instance.getLng(activity)));
        LocationController instance2 = LocationController.getInstance();
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        hashMap.put("locationB", Double.valueOf(instance2.getLat(activity2)));
        hashMap.put("userId", Long.valueOf(NationComponentDataUtil.getUid()));
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/fragment/PromoShowFragment$EmojiFilter;", "Landroid/text/InputFilter;", "(Lcom/didi/component/framework/pages/promo/fragment/PromoShowFragment;)V", "emoji", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getEmoji", "()Ljava/util/regex/Pattern;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PromoShowFragment.kt */
    public final class EmojiFilter implements InputFilter {
        private final Pattern emoji = Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66);
        final /* synthetic */ PromoShowFragment this$0;

        public EmojiFilter(PromoShowFragment promoShowFragment) {
            Intrinsics.checkNotNullParameter(promoShowFragment, "this$0");
            this.this$0 = promoShowFragment;
        }

        public final Pattern getEmoji() {
            return this.emoji;
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (this.emoji.matcher(charSequence).find()) {
                return "";
            }
            return null;
        }
    }
}
