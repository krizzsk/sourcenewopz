package com.jumio.defaultui.view;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.material.button.MaterialButton;
import com.jumio.commons.log.Log;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, mo175978d2 = {"Lcom/jumio/defaultui/view/StartFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/text/Spanned;", "getConsentSpanned", "", "paddableString", "", "drawableId", "Landroid/text/Spannable;", "prepadStringWithDrawable", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "", "onDestroyView", "v", "onClick", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "Landroidx/appcompat/widget/AppCompatTextView;", "tvConsent", "Landroidx/appcompat/widget/AppCompatTextView;", "tvTitle", "Lcom/google/android/material/button/MaterialButton;", "btnStart", "Lcom/google/android/material/button/MaterialButton;", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: StartFragment.kt */
public final class StartFragment extends BaseFragment implements View.OnClickListener {
    private static final String CONSENT_LINK = "Privacy Policy";
    private static final String CONSENT_TEXT = "By clicking \"%s\" you consent to Jumio collecting and disclosing your biometric data pursuant to its %s.";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static String TAG = StartFragment.class.getSimpleName();
    private MaterialButton btnStart;
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new StartFragment$special$$inlined$activityViewModels$default$1(this), new StartFragment$special$$inlined$activityViewModels$default$2(this));
    private AppCompatTextView tvConsent;
    private AppCompatTextView tvTitle;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\tR\u001e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\u00040\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\u0010"}, mo175978d2 = {"Lcom/jumio/defaultui/view/StartFragment$Companion;", "", "Landroid/content/Context;", "context", "", "consentUrl", "", "openConsentUrl", "CONSENT_LINK", "Ljava/lang/String;", "CONSENT_TEXT", "kotlin.jvm.PlatformType", "TAG", "<init>", "()V", "a", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: StartFragment.kt */
    public static final class Companion {

        /* renamed from: com.jumio.defaultui.view.StartFragment$Companion$a */
        /* compiled from: StartFragment.kt */
        public static final class C20076a extends ClickableSpan {

            /* renamed from: a */
            public final String f55039a;

            public C20076a(String str) {
                Intrinsics.checkNotNullParameter(str, "consentUrl");
                this.f55039a = str;
            }

            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Intrinsics.checkNotNullParameter(view, "widget");
                Companion companion = StartFragment.Companion;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "widget.context");
                companion.openConsentUrl(context, this.f55039a);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void openConsentUrl(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "consentUrl");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.putExtra("com.android.browser.application_id", context.getPackageName());
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Log.m39474w(Intrinsics.stringPlus("Activity was not found for intent, ", intent));
            }
        }
    }

    private final Spanned getConsentSpanned() {
        Object obj;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        MaterialButton materialButton = this.btnStart;
        if (materialButton == null || (obj = materialButton.getText()) == null) {
            obj = "Continue";
        }
        objArr[0] = obj;
        objArr[1] = CONSENT_LINK;
        String format = String.format(CONSENT_TEXT, Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        SpannableString spannableString = new SpannableString(format);
        String str = format;
        spannableString.setSpan(new Companion.C20076a(getJumioViewModel().mo66w()), StringsKt.indexOf$default((CharSequence) str, CONSENT_LINK, 0, false, 6, (Object) null), StringsKt.indexOf$default((CharSequence) str, CONSENT_LINK, 0, false, 6, (Object) null) + 14, 33);
        return spannableString;
    }

    private final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    private final Spannable prepadStringWithDrawable(String str, int i) {
        SpannableString spannableString;
        Drawable drawable;
        if (str == null || getContext() == null || (drawable = ContextCompat.getDrawable(requireContext(), i)) == null) {
            spannableString = null;
        } else {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            ImageSpan imageSpan = new ImageSpan(drawable, 1);
            spannableString = new SpannableString(Intrinsics.stringPlus("  ", str));
            spannableString.setSpan(imageSpan, 0, 1, 17);
        }
        return spannableString == null ? new SpannableString("") : spannableString;
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_start, viewGroup, false);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.btn_start);
        this.btnStart = materialButton;
        if (materialButton != null) {
            materialButton.setOnClickListener(this);
        }
        this.tvConsent = (AppCompatTextView) inflate.findViewById(R.id.tv_consent);
        String str2 = null;
        if (getJumioViewModel().mo66w().length() > 0) {
            AppCompatTextView appCompatTextView = this.tvConsent;
            if (appCompatTextView != null) {
                appCompatTextView.setText(getConsentSpanned());
            }
            AppCompatTextView appCompatTextView2 = this.tvConsent;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            AppCompatTextView appCompatTextView3 = this.tvConsent;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView4 = this.tvConsent;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setOnClickListener((View.OnClickListener) null);
            }
        }
        this.tvTitle = (AppCompatTextView) inflate.findViewById(R.id.tv_title);
        int size = getJumioViewModel().mo43f().size();
        if (size > 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ENGLISH;
            Context context = getContext();
            if (context == null || (str = context.getString(R.string.jumio_start_title_plural)) == null) {
                str = "";
            }
            String format = String.format(locale, str, Arrays.copyOf(new Object[]{Integer.valueOf(size)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            AppCompatTextView appCompatTextView5 = this.tvTitle;
            if (appCompatTextView5 != null) {
                appCompatTextView5.setText(prepadStringWithDrawable(format, R.drawable.jumio_ic_shield));
            }
        } else {
            AppCompatTextView appCompatTextView6 = this.tvTitle;
            if (appCompatTextView6 != null) {
                Context context2 = getContext();
                if (context2 != null) {
                    str2 = context2.getString(R.string.jumio_start_title_singular);
                }
                appCompatTextView6.setText(prepadStringWithDrawable(str2, R.drawable.jumio_ic_shield));
            }
        }
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_category_list);
        if ((true ^ getJumioViewModel().mo43f().isEmpty()) && getContext() != null) {
            ArrayList<JumioCredentialInfo> f = getJumioViewModel().mo43f();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(f, 10));
            for (JumioCredentialInfo category : f) {
                arrayList.add(category.getCategory());
            }
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                recyclerView.setAdapter(new StartStepsViewAdapter(arrayList));
            }
        }
        return inflate;
    }

    public void onClick(View view) {
        JumioFragmentCallback callback;
        AutoTrackHelper.trackViewOnClick(view);
        if ((view != null && view.getId() == R.id.btn_start) && (callback = getCallback()) != null) {
            callback.startUserJourney();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.tvConsent = null;
        this.tvTitle = null;
        this.btnStart = null;
    }
}
