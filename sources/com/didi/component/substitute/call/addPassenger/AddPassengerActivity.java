package com.didi.component.substitute.call.addPassenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.contacts.GCommonContactsModel;
import com.didi.component.common.contacts.GCommonGetContactsActivity;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.util.UIUtils;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.adapter.IntroducesAdapter;
import com.didi.component.substitute.call.model.ContactModel;
import com.didi.component.substitute.call.model.ErrorObject;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SPUtils;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.estimate.daijiao.AddPhoneModel;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.flutter.LoginEventHandler;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0001gB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u000204H\u0002J\u001a\u00105\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000201H\u0002J\u0018\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0002J\b\u0010<\u001a\u000201H\u0002J\u0006\u0010=\u001a\u000201J\u0010\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002J\u001c\u0010D\u001a\u0002042\b\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020/2\b\u0010J\u001a\u0004\u0018\u00010KH\u0014J\b\u0010L\u001a\u000201H\u0016J\u0012\u0010M\u001a\u0002012\b\u0010;\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010N\u001a\u0002012\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u000201H\u0014J\b\u0010R\u001a\u000201H\u0014J\b\u0010S\u001a\u000201H\u0002J\b\u0010T\u001a\u000201H\u0002J\b\u0010U\u001a\u000201H\u0002J\b\u0010V\u001a\u000201H\u0002J\b\u0010W\u001a\u000201H\u0002J\u001a\u0010X\u001a\u0002012\u0006\u0010Y\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010[\u001a\u0002012\u0006\u0010\\\u001a\u00020$H\u0007J\b\u0010]\u001a\u000201H\u0002J\b\u0010^\u001a\u000201H\u0002J\b\u0010_\u001a\u000201H\u0003J\u001c\u0010`\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010\u00052\b\u0010b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/XD¢\u0006\u0002\n\u0000¨\u0006h"}, mo175978d2 = {"Lcom/didi/component/substitute/call/addPassenger/AddPassengerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "mAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "mBack", "Landroid/widget/ImageView;", "mBubble", "Lcom/didi/global/globaluikit/popup/LEGOBubble;", "mClickStation", "Landroid/widget/TextView;", "mConfirm", "mContacts", "mContactsImgTips", "mCountryCode", "mCountryCodeStr", "mCountryFlag", "mCountryOpen", "mFirstName", "mFirstNameInput", "Landroid/widget/EditText;", "mFirstNameStation", "mIntroductions", "Landroidx/recyclerview/widget/RecyclerView;", "mLegoDrawer", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "getMLegoDrawer", "()Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "setMLegoDrawer", "(Lcom/didi/global/globaluikit/drawer/LEGODrawer;)V", "mLoginEventHandler", "Lcom/didi/unifylogin/flutter/LoginEventHandler;", "mNameBottomLine", "Landroid/view/View;", "mPhoneBottomLine", "mPhoneNum", "mPhoneNumInput", "mPhoneNumStation", "mRefreshLis", "Lcom/didi/component/core/event/BaseEventPublisher$OnEventListener;", "Lcom/didi/component/substitute/call/model/ErrorObject;", "mTitle", "sContactsImgTipsHasShow", "sResultForGetContacts", "", "changeBottomLineColor", "", "bottomLine", "isChanged", "", "changeBottomLineHeight", "value", "", "clickConfirm", "clickTrackEvent", "eventId", "v", "closeContactsTipsBubble", "hideLoading", "hideSoftKeyboard", "activity", "Landroid/app/Activity;", "initDate", "initView", "inputListener", "isNoName", "phone", "name", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "openContacts", "openCountries", "pageShowTrackEvent", "popShowTrackEvent", "setConfirmEnable", "setHint", "hint", "editText", "setupUI", "view", "showBubble", "showLoading", "showPopRemindNoSeat", "updateCountryInfo", "url", "code", "updatePhoneNumAndFirstName", "result", "Ljava/util/ArrayList;", "Lcom/didi/component/common/contacts/GCommonContactsModel;", "Companion", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddPassengerActivity.kt */
public final class AddPassengerActivity extends AppCompatActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: A */
    private LEGODrawer f16037A;

    /* renamed from: a */
    private final String f16038a = "AddPassengerActivity";

    /* renamed from: b */
    private EditText f16039b;

    /* renamed from: c */
    private EditText f16040c;

    /* renamed from: d */
    private TextView f16041d;

    /* renamed from: e */
    private TextView f16042e;

    /* renamed from: f */
    private TextView f16043f;

    /* renamed from: g */
    private TextView f16044g;

    /* renamed from: h */
    private TextView f16045h;

    /* renamed from: i */
    private TextView f16046i;

    /* renamed from: j */
    private ImageView f16047j;

    /* renamed from: k */
    private ImageView f16048k;

    /* renamed from: l */
    private ImageView f16049l;

    /* renamed from: m */
    private ImageView f16050m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f16051n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f16052o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f16053p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public View f16054q;

    /* renamed from: r */
    private LoginEventHandler f16055r;

    /* renamed from: s */
    private final int f16056s = 1;

    /* renamed from: t */
    private RecyclerView f16057t;

    /* renamed from: u */
    private String f16058u;

    /* renamed from: v */
    private String f16059v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final String f16060w = "sContactsImgTipsHasShow";
    /* access modifiers changed from: private */

    /* renamed from: x */
    public LEGOBubble f16061x;

    /* renamed from: y */
    private LottieAnimationView f16062y;

    /* renamed from: z */
    private final BaseEventPublisher.OnEventListener<ErrorObject> f16063z = new AddPassengerActivity$mRefreshLis$1(this);

    public void _$_clearFindViewByIdCache() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/substitute/call/addPassenger/AddPassengerActivity$Companion;", "", "()V", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AddPassengerActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, AddPassengerActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            GLog.m7968e(this.f16038a, "onCreate: savedInstanceState");
            finish();
        }
        setContentView((int) R.layout.activity_add_passenger);
        m11775a();
        m11782b();
        m11786d();
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Confirm.EVENT_SUBSTITUTE_CALL_REFRESH, this.f16063z, ErrorObject.class);
        View childAt = ((ViewGroup) findViewById(16908290)).getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "findViewById<ViewGroup>(…d.content)).getChildAt(0)");
        setupUI(childAt);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m11793k();
    }

    /* renamed from: a */
    private final void m11775a() {
        this.f16041d = (TextView) findViewById(R.id.tv_title);
        TextView textView = (TextView) findViewById(R.id.tv_country_code);
        this.f16042e = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.f16057t = (RecyclerView) findViewById(R.id.rv_introductions);
        this.f16043f = (TextView) findViewById(R.id.tv_phone_num_station);
        this.f16044g = (TextView) findViewById(R.id.tv_first_name_station);
        this.f16045h = (TextView) findViewById(R.id.tv_click_tips);
        TextView textView2 = (TextView) findViewById(R.id.tv_sc_confirm);
        this.f16046i = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(new AddPassengerActivity$initView$1(this));
        }
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        this.f16047j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_country);
        this.f16048k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_drop_down);
        this.f16049l = imageView3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        ImageView imageView4 = (ImageView) findViewById(R.id.iv_add_contacts);
        this.f16050m = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(this);
        }
        this.f16039b = (EditText) findViewById(R.id.et_phone);
        this.f16040c = (EditText) findViewById(R.id.et_name);
        this.f16053p = findViewById(R.id.phone_bottom_line);
        this.f16054q = findViewById(R.id.name_bottom_line);
        ImageView imageView5 = this.f16050m;
        if (imageView5 != null) {
            imageView5.post(new AddPassengerActivity$initView$2(this));
        }
        this.f16062y = (LottieAnimationView) findViewById(R.id.animation_view);
    }

    /* renamed from: b */
    private final void m11782b() {
        EditText editText = this.f16039b;
        if (editText != null) {
            editText.addTextChangedListener(new AddPassengerActivity$inputListener$1(this));
        }
        EditText editText2 = this.f16039b;
        if (editText2 != null) {
            editText2.setOnFocusChangeListener(new AddPassengerActivity$inputListener$2(this));
        }
        EditText editText3 = this.f16040c;
        if (editText3 != null) {
            editText3.addTextChangedListener(new AddPassengerActivity$inputListener$3(this));
        }
        EditText editText4 = this.f16040c;
        if (editText4 != null) {
            editText4.setOnFocusChangeListener(new AddPassengerActivity$inputListener$4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m11778a(View view, boolean z) {
        if (z) {
            if (view != null) {
                view.setBackgroundColor(getResources().getColor(R.color.cut_down_time_color));
            }
        } else if (view != null) {
            view.setBackgroundColor(getResources().getColor(R.color.g_color_ddd));
        }
        m11777a(view, 0.5f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m11777a(View view, float f) {
        Context context = null;
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        if (layoutParams != null) {
            if (view != null) {
                context = view.getContext();
            }
            layoutParams.height = UIUtils.dip2pxInt(context, f);
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m11784c() {
        TextView textView = this.f16046i;
        if (textView != null) {
            textView.setEnabled(!TextUtils.isEmpty(this.f16052o) && !TextUtils.isEmpty(this.f16051n));
        }
    }

    /* renamed from: d */
    private final void m11786d() {
        AddPhoneModel addPhoneModel;
        TextView textView;
        TextView textView2;
        SubstituteCallModel substituteCallModel = FormStore.getInstance().getSubstituteCallModel();
        if (substituteCallModel != null && (addPhoneModel = substituteCallModel.getAddPhoneModel()) != null) {
            String title = addPhoneModel.getTitle();
            if (!(title == null || (textView2 = this.f16041d) == null)) {
                textView2.setText(title);
            }
            List<String> introductions = addPhoneModel.getIntroductions();
            if (introductions != null) {
                RecyclerView recyclerView = this.f16057t;
                if (recyclerView != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
                }
                RecyclerView recyclerView2 = this.f16057t;
                if (recyclerView2 != null) {
                    recyclerView2.setAdapter(new IntroducesAdapter(this, introductions));
                }
            }
            String confirmBtnText = addPhoneModel.getConfirmBtnText();
            if (!(confirmBtnText == null || (textView = this.f16046i) == null)) {
                textView.setText(confirmBtnText);
            }
            GlobalRichInfo phone_intro = addPhoneModel.getPhone_intro();
            if (phone_intro != null) {
                phone_intro.bindTextView(this.f16043f);
            }
            GlobalRichInfo nameIntro = addPhoneModel.getNameIntro();
            if (nameIntro != null) {
                nameIntro.bindTextView(this.f16044g);
            }
            GlobalRichInfo confirmIntro = addPhoneModel.getConfirmIntro();
            if (confirmIntro != null) {
                confirmIntro.bindTextView(this.f16045h);
            }
            String phoneNumHint = addPhoneModel.getPhoneNumHint();
            if (phoneNumHint != null) {
                m11779a(phoneNumHint, this.f16039b);
            }
            String nameHint = addPhoneModel.getNameHint();
            if (nameHint != null) {
                m11779a(nameHint, this.f16040c);
            }
            this.f16059v = addPhoneModel.getContactsImgTips();
            CountryManager ins = CountryManager.getIns();
            this.f16058u = ins.getCurrentCountryCode();
            m11780a(ins.getDefCountry().getNationalFlagUrl(), this.f16058u);
        }
    }

    /* renamed from: a */
    private final void m11779a(String str, EditText editText) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(24, true), 0, spannableString.length(), 33);
        if (editText != null) {
            editText.setHint(new SpannedString(spannableString));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m11780a(String str, String str2) {
        ImageView imageView;
        if (!(str == null || (imageView = this.f16048k) == null)) {
            Glide.with((FragmentActivity) this).load(str).into(imageView);
        }
        if (str2 != null) {
            TextView textView = this.f16042e;
            if (textView != null) {
                textView.setText(str2);
            }
            this.f16058u = str2;
        }
    }

    /* renamed from: a */
    private final void m11781a(ArrayList<GCommonContactsModel> arrayList) {
        String str;
        GCommonContactsModel gCommonContactsModel = arrayList.get(0);
        if (gCommonContactsModel != null) {
            CharSequence charSequence = gCommonContactsModel.phone;
            if (charSequence == null || charSequence.length() == 0) {
                m11778a(this.f16053p, false);
                str = "";
            } else {
                str = gCommonContactsModel.phone;
                Intrinsics.checkNotNullExpressionValue(str, "it.phone");
                String str2 = this.f16058u;
                if (str2 != null && StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
                    str = str.substring(str2.length());
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                }
                EditText editText = this.f16039b;
                if (editText != null) {
                    editText.setText(StringUtil.getNum(str));
                }
                this.f16051n = str;
                EditText editText2 = this.f16039b;
                if (editText2 != null) {
                    editText2.clearFocus();
                }
                m11777a(this.f16053p, 1.5f);
                View view = this.f16053p;
                if (view != null) {
                    view.setBackgroundColor(getResources().getColor(R.color.cut_down_time_color));
                }
            }
            if (m11783b(str, gCommonContactsModel.name)) {
                EditText editText3 = this.f16040c;
                if (editText3 != null) {
                    editText3.setText("");
                }
                m11778a(this.f16054q, false);
                return;
            }
            EditText editText4 = this.f16040c;
            if (editText4 != null) {
                editText4.setText(gCommonContactsModel.name);
            }
            this.f16052o = gCommonContactsModel.name;
            EditText editText5 = this.f16040c;
            if (editText5 != null) {
                editText5.clearFocus();
            }
            m11777a(this.f16054q, 1.5f);
            View view2 = this.f16054q;
            if (view2 != null) {
                view2.setBackgroundColor(getResources().getColor(R.color.cut_down_time_color));
            }
        }
    }

    /* renamed from: b */
    private final boolean m11783b(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        CharSequence charSequence2 = str2;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (z) {
            return true;
        }
        return Intrinsics.areEqual((Object) new Regex("\\s").replace(charSequence, ""), (Object) new Regex("\\s").replace(charSequence2, ""));
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (Intrinsics.areEqual((Object) view, (Object) this.f16047j)) {
            m11785c("ibt_gp_write_rider_back_ck", WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME);
            onBackPressed();
        } else if (Intrinsics.areEqual((Object) view, (Object) this.f16049l)) {
            m11787e();
        } else if (Intrinsics.areEqual((Object) view, (Object) this.f16042e)) {
            m11787e();
        } else if (Intrinsics.areEqual((Object) view, (Object) this.f16050m)) {
            m11788f();
        }
    }

    /* renamed from: e */
    private final void m11787e() {
        Context context = this;
        DRouter.build("GuaranaOneTravel://one/country_code/calling_code").start(context);
        this.f16055r = new LoginEventHandler(context);
        LoginEventHandler.setCountryCodeSelectListener(new AddPassengerActivity$openCountries$1(this));
    }

    /* renamed from: f */
    private final void m11788f() {
        Context context = this;
        startActivityForResult(GCommonGetContactsActivity.getIntent(context, 1), this.f16056s);
        m11792j();
        SPUtils.put(context, this.f16060w, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m11789g() {
        EditText editText = this.f16040c;
        if (editText != null) {
            editText.clearFocus();
        }
        m11795m();
        ContactModel contactModel = new ContactModel();
        contactModel.setName(this.f16052o);
        contactModel.setPhone(this.f16051n);
        contactModel.setType(1);
        String str = this.f16058u;
        if (str != null) {
            contactModel.setCountryCode(StringUtil.getNum(str));
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_SIMPLE_REQUEST_SUBSTITUTE_CALL, contactModel);
        m11785c("ibt_gp_write_rider_confirm_ck", XPanelScene.SCENE_CONFIRM);
    }

    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.f16052o) || !TextUtils.isEmpty(this.f16051n)) {
            m11790h();
            return;
        }
        FormStore.getInstance().setSkipEstimateGet(true);
        finish();
    }

    public final LEGODrawer getMLegoDrawer() {
        return this.f16037A;
    }

    public final void setMLegoDrawer(LEGODrawer lEGODrawer) {
        this.f16037A = lEGODrawer;
    }

    /* renamed from: h */
    private final void m11790h() {
        String string = getResources().getString(R.string.GRider_call_Cancel_adding_XgNS);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_call_Cancel_adding_XgNS)");
        String string2 = getResources().getString(R.string.GRider_call_Cancel_zEeS);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st….GRider_call_Cancel_zEeS)");
        String string3 = getResources().getString(R.string.GRider_call_Confirmation_NsHE);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…r_call_Confirmation_NsHE)");
        LEGOBaseDrawerModel lEGODrawerModel1 = new LEGODrawerModel1(string, new LEGOBtnTextAndCallback(string3, new AddPassengerActivity$showPopRemindNoSeat$model$1(this)));
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(string2, new AddPassengerActivity$showPopRemindNoSeat$butCancel$1(this)));
        lEGODrawerModel1.setSubTitle(getResources().getString(R.string.GRider_call_If_the_Krmm));
        this.f16037A = LEGOUICreator.showDrawerTemplate(this, lEGODrawerModel1);
        m11794l();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m11791i() {
        int i;
        int[] measureWidthAndHeight;
        int[] measureWidthAndHeight2;
        Context context = this;
        int i2 = 0;
        Object obj = SPUtils.get(context, this.f16060w, false);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } else if (!((Boolean) obj).booleanValue()) {
            LEGOBubble.Builder builder = new LEGOBubble.Builder(context);
            builder.setDirection("bottom_right");
            builder.setBgColor(ResourcesHelper.getColor(context, R.color.g_color_5C6166));
            String str = this.f16059v;
            if (str != null) {
                builder.setText(str);
            }
            builder.setCloseBtnVisible(false);
            builder.setTextProps(14, 1, 1);
            builder.setWidthAndHeight(-2, -2);
            LEGOBubble build = builder.build();
            this.f16061x = build;
            if (build == null || (measureWidthAndHeight2 = build.getMeasureWidthAndHeight()) == null) {
                i = 0;
            } else {
                i = measureWidthAndHeight2[1];
            }
            LEGOBubble lEGOBubble = this.f16061x;
            if (!(lEGOBubble == null || (measureWidthAndHeight = lEGOBubble.getMeasureWidthAndHeight()) == null)) {
                i2 = measureWidthAndHeight[0];
            }
            builder.setContentViewOnClick(new AddPassengerActivity$showBubble$2(this));
            try {
                int dimensionPixelSize = i + ResourcesHelper.getDimensionPixelSize(this, R.dimen.bubble_address_book_bottom);
                int dimensionPixelOffset = (-i2) + getResources().getDimensionPixelOffset(R.dimen.lego_bubble_default_offset) + UIUtils.dip2pxInt(this, 15.5f) + 20;
                LEGOBubble lEGOBubble2 = this.f16061x;
                if (lEGOBubble2 != null) {
                    lEGOBubble2.show(this.f16050m, dimensionPixelOffset, -dimensionPixelSize);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle bundleExtra;
        Serializable serializable;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == this.f16056s && intent != null && (bundleExtra = intent.getBundleExtra("data")) != null && (serializable = bundleExtra.getSerializable("list")) != null) {
            try {
                m11781a((ArrayList<GCommonContactsModel>) (ArrayList) serializable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m11792j();
        hideLoading();
        LoginEventHandler.setCountryCodeSelectListener((LoginEventHandler.CountryCodeSelectListener) null);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Confirm.EVENT_SUBSTITUTE_CALL_REFRESH, this.f16063z, ErrorObject.class);
    }

    /* renamed from: j */
    private final void m11792j() {
        LEGOBubble lEGOBubble = this.f16061x;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            LEGOBubble lEGOBubble2 = this.f16061x;
            if (lEGOBubble2 != null) {
                lEGOBubble2.dismiss();
            }
            this.f16061x = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m11785c(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, str2);
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "write_rider_page");
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: k */
    private final void m11793k() {
        Map hashMap = new HashMap();
        hashMap.put("k", "access");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "write_rider_page");
        GlobalOmegaUtils.trackEvent("ibt_gp_write_rider_page_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: l */
    private final void m11794l() {
        Map hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put(RavenKey.VERSION, "interpret_pop");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "write_rider_page");
        GlobalOmegaUtils.trackEvent("ibt_gp_interpret_pop_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: m */
    private final void m11795m() {
        LottieAnimationView lottieAnimationView = this.f16062y;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
        }
        LottieAnimationView lottieAnimationView2 = this.f16062y;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
        TextView textView = this.f16046i;
        if (textView != null) {
            textView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView3 = this.f16062y;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.playAnimation();
        }
    }

    public final void hideLoading() {
        LottieAnimationView lottieAnimationView = this.f16062y;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
            if (lottieAnimationView.isAnimating()) {
                lottieAnimationView.cancelAnimation();
            }
        }
        TextView textView = this.f16046i;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public final void setupUI(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new AddPassengerActivity$setupUI$1(this));
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                while (true) {
                    int i2 = i + 1;
                    View childAt = viewGroup.getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "innerView");
                    setupUI(childAt);
                    if (i2 < childCount) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m11776a(Activity activity) {
        Object systemService = activity.getSystemService("input_method");
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            EditText editText = this.f16040c;
            if (editText != null && editText.hasFocus()) {
                editText.clearFocus();
            }
            EditText editText2 = this.f16039b;
            if (editText2 != null && editText2.hasFocus()) {
                editText2.clearFocus();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
