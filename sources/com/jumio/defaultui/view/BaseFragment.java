package com.jumio.defaultui.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.google.android.material.button.MaterialButton;
import com.jumio.core.util.DataDogHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0004J\b\u0010\u000f\u001a\u00020\u000bH\u0016J*\u0010\u0015\u001a\u00020\u000b*\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012H\u0004J\u0012\u0010\u0019\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0017J\u0012\u0010\u001d\u001a\u00020\u001c2\n\u0010\u001b\u001a\u00020\u001a\"\u00020\u0010R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, mo175978d2 = {"Lcom/jumio/defaultui/view/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "createLayout", "", "onResume", "onPause", "dismissKeyboard", "onDestroyView", "", "visibility", "", "animDuration", "animDelay", "fadeAndScaleTo", "Lcom/google/android/material/button/MaterialButton;", "", "showProgress", "setShowProgress", "", "resourceId", "", "generateBulletPointList", "Lcom/jumio/defaultui/view/JumioFragmentCallback;", "callback", "Lcom/jumio/defaultui/view/JumioFragmentCallback;", "getCallback", "()Lcom/jumio/defaultui/view/JumioFragmentCallback;", "setCallback", "(Lcom/jumio/defaultui/view/JumioFragmentCallback;)V", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment extends Fragment {
    private JumioFragmentCallback callback;

    /* renamed from: com.jumio.defaultui.view.BaseFragment$a */
    /* compiled from: BaseFragment.kt */
    public static final class C20064a extends Lambda implements Function1<Integer, CharSequence> {

        /* renamed from: a */
        public final /* synthetic */ BaseFragment f55031a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C20064a(BaseFragment baseFragment) {
            super(1);
            this.f55031a = baseFragment;
        }

        /* renamed from: a */
        public final CharSequence mo163263a(int i) {
            String string = this.f55031a.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(resource)");
            return string;
        }

        public /* synthetic */ Object invoke(Object obj) {
            return mo163263a(((Number) obj).intValue());
        }
    }

    public static /* synthetic */ void fadeAndScaleTo$default(BaseFragment baseFragment, View view, int i, long j, long j2, int i2, Object obj) {
        if (obj == null) {
            baseFragment.fadeAndScaleTo(view, i, (i2 & 2) != 0 ? 50 : j, (i2 & 4) != 0 ? 50 : j2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fadeAndScaleTo");
    }

    public abstract View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dismissKeyboard() {
        /*
            r5 = this;
            android.content.Context r0 = r5.getContext()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            goto L_0x000e
        L_0x0008:
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = r1
            goto L_0x0016
        L_0x0010:
            java.lang.String r2 = "input_method"
            java.lang.Object r0 = r0.getSystemService(r2)
        L_0x0016:
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x001d
            goto L_0x0024
        L_0x001d:
            boolean r4 = r0.isAcceptingText()
            if (r4 != r2) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            if (r2 == 0) goto L_0x003c
            androidx.fragment.app.FragmentActivity r2 = r5.getActivity()
            if (r2 != 0) goto L_0x002e
            goto L_0x0039
        L_0x002e:
            android.view.View r2 = r2.getCurrentFocus()
            if (r2 != 0) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            android.os.IBinder r1 = r2.getWindowToken()
        L_0x0039:
            r0.hideSoftInputFromWindow(r1, r3)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.BaseFragment.dismissKeyboard():void");
    }

    public final void fadeAndScaleTo(View view, int i, long j, long j2) {
        if (view != null) {
            view.setVisibility(i);
            float f = (i == 0 || !(i == 4 || i == 8)) ? 1.0f : 0.0f;
            ViewPropertyAnimator animate = view.animate();
            animate.setInterpolator(new AccelerateDecelerateInterpolator());
            animate.alpha(f);
            animate.scaleX(f);
            animate.scaleY(f);
            animate.setDuration(j);
            animate.setStartDelay(j2);
            animate.start();
        }
    }

    public final String generateBulletPointList(int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, InvitationPageActivity.RESOURCE_ID);
        return ArraysKt.joinToString$default(iArr, (CharSequence) "\n• ", (CharSequence) "• ", (CharSequence) null, 0, (CharSequence) null, (Function1) new C20064a(this), 28, (Object) null);
    }

    public final JumioFragmentCallback getCallback() {
        return this.callback;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (getContext() instanceof JumioFragmentCallback) {
            Context context = getContext();
            if (context != null) {
                this.callback = (JumioFragmentCallback) context;
                return createLayout(layoutInflater, viewGroup);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.jumio.defaultui.view.JumioFragmentCallback");
        }
        throw new IllegalArgumentException("Activity must extend JumioFragmentInterface".toString());
    }

    public void onDestroyView() {
        this.callback = null;
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        DataDogHelper.INSTANCE.reportViewStop(this);
    }

    public void onResume() {
        super.onResume();
        DataDogHelper.INSTANCE.reportViewStart(this);
    }

    public final void setCallback(JumioFragmentCallback jumioFragmentCallback) {
        this.callback = jumioFragmentCallback;
    }

    public final void setShowProgress(MaterialButton materialButton, boolean z) {
        CircularProgressDrawable circularProgressDrawable;
        Resources.Theme theme;
        Intrinsics.checkNotNullParameter(materialButton, "<this>");
        if (z) {
            TypedValue typedValue = new TypedValue();
            Context context = materialButton.getContext();
            if (!(context == null || (theme = context.getTheme()) == null)) {
                theme.resolveAttribute(R.attr.jumio_primary_button_foreground, typedValue, true);
            }
            int i = typedValue.data;
            circularProgressDrawable = new CircularProgressDrawable(materialButton.getContext());
            circularProgressDrawable.setStyle(1);
            circularProgressDrawable.setColorSchemeColors(i);
            circularProgressDrawable.start();
            Unit unit = Unit.INSTANCE;
        } else {
            circularProgressDrawable = null;
        }
        materialButton.setIcon(circularProgressDrawable);
        if (materialButton.getIcon() != null) {
            materialButton.getIcon().setCallback(new BaseFragment$setShowProgress$2(materialButton));
        }
    }
}
