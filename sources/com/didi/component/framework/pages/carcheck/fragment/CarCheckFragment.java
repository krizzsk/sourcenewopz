package com.didi.component.framework.pages.carcheck.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.framework.pages.carcheck.CarCheckActivity;
import com.didi.component.framework.pages.carcheck.presenter.CarCheckPresenter;
import com.didi.component.framework.pages.carcheck.view.CarCheckListener;
import com.didi.component.framework.pages.carcheck.view.CarCheckView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010#\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/fragment/CarCheckFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didi/component/framework/pages/carcheck/view/CarCheckView;", "()V", "carType", "", "card", "mListener", "Lcom/didi/component/framework/pages/carcheck/view/CarCheckListener;", "mPresenter", "Lcom/didi/component/framework/pages/carcheck/presenter/CarCheckPresenter;", "mRootView", "Landroid/view/View;", "orderId", "questionAnswer", "", "[Ljava/lang/String;", "questionBody", "questionId", "", "hideLoadingView", "", "initCarDetails", "initContent", "jumpToResultPage", "bundle", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "setPresenter", "presenter", "showLoadingView", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarCheckFragment.kt */
public final class CarCheckFragment extends Fragment implements CarCheckView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CarCheckPresenter f13763a;

    /* renamed from: b */
    private View f13764b;

    /* renamed from: c */
    private CarCheckListener f13765c;

    /* renamed from: d */
    private String f13766d = "";

    /* renamed from: e */
    private int f13767e = -1;

    /* renamed from: f */
    private String f13768f = "";

    /* renamed from: g */
    private String[] f13769g;

    /* renamed from: h */
    private String f13770h = "";

    /* renamed from: i */
    private String f13771i = "";

    public void _$_clearFindViewByIdCache() {
    }

    public void setPresenter(CarCheckPresenter carCheckPresenter) {
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/fragment/CarCheckFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/component/framework/pages/carcheck/fragment/CarCheckFragment;", "bundle", "Landroid/os/Bundle;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CarCheckFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CarCheckFragment newInstance$default(Companion companion, Bundle bundle, int i, Object obj) {
            if ((i & 1) != 0) {
                bundle = null;
            }
            return companion.newInstance(bundle);
        }

        public final CarCheckFragment newInstance(Bundle bundle) {
            CarCheckFragment carCheckFragment = new CarCheckFragment();
            carCheckFragment.setArguments(bundle);
            return carCheckFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String string;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        CarCheckPresenter carCheckPresenter = new CarCheckPresenter(activity);
        this.f13763a = carCheckPresenter;
        if (carCheckPresenter != null) {
            carCheckPresenter.setIView(this);
        }
        FragmentActivity activity2 = getActivity();
        String[] strArr = null;
        this.f13765c = activity2 instanceof CarCheckListener ? (CarCheckListener) activity2 : null;
        Bundle arguments = getArguments();
        String str4 = "";
        if (arguments == null || (str = arguments.getString("order_id")) == null) {
            str = str4;
        }
        this.f13766d = str;
        Bundle arguments2 = getArguments();
        this.f13767e = arguments2 == null ? -1 : arguments2.getInt("question_id");
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str2 = arguments3.getString(CarCheckActivity.QUESTION_BODY)) == null) {
            str2 = str4;
        }
        this.f13768f = str2;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            strArr = arguments4.getStringArray(CarCheckActivity.ANSWERS);
        }
        this.f13769g = strArr;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str3 = arguments5.getString(CarCheckActivity.CAR_TYPE)) == null) {
            str3 = str4;
        }
        this.f13770h = str3;
        Bundle arguments6 = getArguments();
        if (!(arguments6 == null || (string = arguments6.getString("card_num")) == null)) {
            str4 = string;
        }
        this.f13771i = str4;
        this.f13764b = layoutInflater.inflate(R.layout.global_car_check_fragment, viewGroup, false);
        m9556a();
        return this.f13764b;
    }

    /* JADX WARNING: type inference failed for: r0v15, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m9556a() {
        /*
            r6 = this;
            android.view.View r0 = r6.f13764b
            r1 = 0
            if (r0 != 0) goto L_0x0007
            r0 = r1
            goto L_0x0010
        L_0x0007:
            r2 = 2131428062(0x7f0b02de, float:1.8477758E38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0010:
            if (r0 != 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            java.lang.String r2 = r6.f13768f
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x001a:
            java.lang.String r0 = r6.f13771i
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r2 = 1
            r3 = 0
            if (r0 <= 0) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0092
            java.lang.String r0 = r6.f13770h
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0037
            r0 = 1
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x0092
            android.view.View r0 = r6.f13764b
            r4 = 2131428050(0x7f0b02d2, float:1.8477734E38)
            if (r0 != 0) goto L_0x0043
            r0 = r1
            goto L_0x0049
        L_0x0043:
            android.view.View r0 = r0.findViewById(r4)
            android.widget.Button r0 = (android.widget.Button) r0
        L_0x0049:
            if (r0 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            r0.setVisibility(r3)
        L_0x004f:
            android.view.View r0 = r6.f13764b
            if (r0 != 0) goto L_0x0055
            r0 = r1
            goto L_0x005b
        L_0x0055:
            android.view.View r0 = r0.findViewById(r4)
            android.widget.Button r0 = (android.widget.Button) r0
        L_0x005b:
            if (r0 != 0) goto L_0x005e
            goto L_0x0065
        L_0x005e:
            java.lang.String r4 = r6.f13771i
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
        L_0x0065:
            android.view.View r0 = r6.f13764b
            r4 = 2131428053(0x7f0b02d5, float:1.847774E38)
            if (r0 != 0) goto L_0x006e
            r0 = r1
            goto L_0x0074
        L_0x006e:
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0074:
            if (r0 != 0) goto L_0x0077
            goto L_0x007e
        L_0x0077:
            java.lang.String r5 = r6.f13770h
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x007e:
            android.view.View r0 = r6.f13764b
            if (r0 != 0) goto L_0x0083
            goto L_0x009c
        L_0x0083:
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 != 0) goto L_0x008c
            goto L_0x009c
        L_0x008c:
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setTextColor(r4)
            goto L_0x009c
        L_0x0092:
            com.didi.component.framework.pages.carcheck.presenter.CarCheckPresenter r0 = r6.f13763a
            if (r0 != 0) goto L_0x0097
            goto L_0x009c
        L_0x0097:
            java.lang.String r4 = r6.f13766d
            r0.getCarDetails(r4)
        L_0x009c:
            java.lang.String[] r0 = r6.f13769g
            if (r0 != 0) goto L_0x00a2
        L_0x00a0:
            r0 = 0
            goto L_0x00a7
        L_0x00a2:
            int r0 = r0.length
            r4 = 2
            if (r0 != r4) goto L_0x00a0
            r0 = 1
        L_0x00a7:
            if (r0 == 0) goto L_0x012a
            android.view.View r0 = r6.f13764b
            if (r0 != 0) goto L_0x00af
            r0 = r1
            goto L_0x00b8
        L_0x00af:
            r4 = 2131428061(0x7f0b02dd, float:1.8477756E38)
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x00b8:
            if (r0 != 0) goto L_0x00bb
            goto L_0x00c7
        L_0x00bb:
            java.lang.String[] r4 = r6.f13769g
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r3 = r4[r3]
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x00c7:
            android.view.View r0 = r6.f13764b
            if (r0 != 0) goto L_0x00cc
            goto L_0x00d6
        L_0x00cc:
            r1 = 2131428060(0x7f0b02dc, float:1.8477754E38)
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x00d6:
            if (r1 != 0) goto L_0x00d9
            goto L_0x00e5
        L_0x00d9:
            java.lang.String[] r0 = r6.f13769g
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0 = r0[r2]
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x00e5:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = r6.f13766d
            java.lang.String r2 = "order_id"
            r0.putString(r2, r1)
            int r1 = r6.f13767e
            java.lang.String r2 = "question_id"
            r0.putInt(r2, r1)
            android.view.View r1 = r6.f13764b
            if (r1 != 0) goto L_0x00fd
            goto L_0x0111
        L_0x00fd:
            r2 = 2131428054(0x7f0b02d6, float:1.8477742E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 != 0) goto L_0x0109
            goto L_0x0111
        L_0x0109:
            com.didi.component.framework.pages.carcheck.fragment.-$$Lambda$CarCheckFragment$p_CGXfWx7e_wf4ytbiy7D-Guth8 r2 = new com.didi.component.framework.pages.carcheck.fragment.-$$Lambda$CarCheckFragment$p_CGXfWx7e_wf4ytbiy7D-Guth8
            r2.<init>(r0, r6)
            r1.setOnClickListener(r2)
        L_0x0111:
            android.view.View r1 = r6.f13764b
            if (r1 != 0) goto L_0x0116
            goto L_0x012a
        L_0x0116:
            r2 = 2131428052(0x7f0b02d4, float:1.8477738E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 != 0) goto L_0x0122
            goto L_0x012a
        L_0x0122:
            com.didi.component.framework.pages.carcheck.fragment.-$$Lambda$CarCheckFragment$L65YE0YdS2xhGhLicZvu2Y90NrM r2 = new com.didi.component.framework.pages.carcheck.fragment.-$$Lambda$CarCheckFragment$L65YE0YdS2xhGhLicZvu2Y90NrM
            r2.<init>(r0, r6)
            r1.setOnClickListener(r2)
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.carcheck.fragment.CarCheckFragment.m9556a():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9557a(Bundle bundle, CarCheckFragment carCheckFragment, View view) {
        TextView textView;
        CharSequence text;
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        Intrinsics.checkNotNullParameter(carCheckFragment, "this$0");
        String str = null;
        if (!(view == null || (textView = (TextView) view.findViewById(R.id.car_check_text_yes)) == null || (text = textView.getText()) == null)) {
            str = text.toString();
        }
        if (str != null) {
            bundle.putString("answer", str);
            CarCheckPresenter carCheckPresenter = carCheckFragment.f13763a;
            if (carCheckPresenter != null) {
                carCheckPresenter.commitCheckResult(bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m9558b(Bundle bundle, CarCheckFragment carCheckFragment, View view) {
        TextView textView;
        CharSequence text;
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        Intrinsics.checkNotNullParameter(carCheckFragment, "this$0");
        String str = null;
        if (!(view == null || (textView = (TextView) view.findViewById(R.id.car_check_text_no)) == null || (text = textView.getText()) == null)) {
            str = text.toString();
        }
        if (str != null) {
            bundle.putString("answer", str);
            CarCheckPresenter carCheckPresenter = carCheckFragment.f13763a;
            if (carCheckPresenter != null) {
                carCheckPresenter.commitCheckResult(bundle);
            }
        }
    }

    public void showLoadingView() {
        CarCheckListener carCheckListener = this.f13765c;
        if (carCheckListener != null) {
            carCheckListener.showLoadingView();
        }
    }

    public void hideLoadingView() {
        CarCheckListener carCheckListener = this.f13765c;
        if (carCheckListener != null) {
            carCheckListener.hideLoadingView();
        }
    }

    public void jumpToResultPage(Bundle bundle) {
        CarCheckListener carCheckListener = this.f13765c;
        if (carCheckListener != null) {
            carCheckListener.switchToTargetPage(CarCheckActivity.CAR_RESULT, bundle);
        }
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initCarDetails(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "card"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "carType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.view.View r0 = r4.f13764b
            r1 = 2131428050(0x7f0b02d2, float:1.8477734E38)
            r2 = 0
            if (r0 != 0) goto L_0x0014
            r0 = r2
            goto L_0x001a
        L_0x0014:
            android.view.View r0 = r0.findViewById(r1)
            android.widget.Button r0 = (android.widget.Button) r0
        L_0x001a:
            if (r0 != 0) goto L_0x001d
            goto L_0x0021
        L_0x001d:
            r3 = 0
            r0.setVisibility(r3)
        L_0x0021:
            android.view.View r0 = r4.f13764b
            if (r0 != 0) goto L_0x0027
            r0 = r2
            goto L_0x002d
        L_0x0027:
            android.view.View r0 = r0.findViewById(r1)
            android.widget.Button r0 = (android.widget.Button) r0
        L_0x002d:
            if (r0 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x0035:
            android.view.View r5 = r4.f13764b
            r0 = 2131428053(0x7f0b02d5, float:1.847774E38)
            if (r5 != 0) goto L_0x003d
            goto L_0x0044
        L_0x003d:
            android.view.View r5 = r5.findViewById(r0)
            r2 = r5
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x0044:
            if (r2 != 0) goto L_0x0047
            goto L_0x004c
        L_0x0047:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
        L_0x004c:
            android.view.View r5 = r4.f13764b
            if (r5 != 0) goto L_0x0051
            goto L_0x005f
        L_0x0051:
            android.view.View r5 = r5.findViewById(r0)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 != 0) goto L_0x005a
            goto L_0x005f
        L_0x005a:
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r5.setTextColor(r6)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.carcheck.fragment.CarCheckFragment.initCarDetails(java.lang.String, java.lang.String):void");
    }
}
