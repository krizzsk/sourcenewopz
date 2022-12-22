package com.didi.component.framework.pages.carcheck.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.framework.pages.carcheck.CarCheckActivity;
import com.didi.component.framework.pages.carcheck.presenter.CarResultPresenter;
import com.didi.component.framework.pages.carcheck.view.CarCheckListener;
import com.didi.component.framework.pages.carcheck.view.CarResultView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/fragment/CarResultFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didi/component/framework/pages/carcheck/view/CarResultView;", "()V", "answer", "", "mListener", "Lcom/didi/component/framework/pages/carcheck/view/CarCheckListener;", "mPresenter", "Lcom/didi/component/framework/pages/carcheck/presenter/CarResultPresenter;", "mRootView", "Landroid/view/View;", "oid", "questionAnswer", "", "[Ljava/lang/String;", "questionId", "", "reply", "hideLoadingView", "", "initContentView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setPresenter", "presenter", "showErrorDialog", "msg", "showErrorView", "showLoadingView", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarResultFragment.kt */
public final class CarResultFragment extends Fragment implements CarResultView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private View f13772a;

    /* renamed from: b */
    private CarResultPresenter f13773b;

    /* renamed from: c */
    private CarCheckListener f13774c;

    /* renamed from: d */
    private String f13775d = "";

    /* renamed from: e */
    private String f13776e = "";

    /* renamed from: f */
    private int f13777f = -1;

    /* renamed from: g */
    private String f13778g = "";

    /* renamed from: h */
    private String[] f13779h;

    public void _$_clearFindViewByIdCache() {
    }

    public void setPresenter(CarResultPresenter carResultPresenter) {
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/fragment/CarResultFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/component/framework/pages/carcheck/fragment/CarResultFragment;", "bundle", "Landroid/os/Bundle;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CarResultFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CarResultFragment newInstance$default(Companion companion, Bundle bundle, int i, Object obj) {
            if ((i & 1) != 0) {
                bundle = null;
            }
            return companion.newInstance(bundle);
        }

        public final CarResultFragment newInstance(Bundle bundle) {
            CarResultFragment carResultFragment = new CarResultFragment();
            carResultFragment.setArguments(bundle);
            return carResultFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String string;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        CarResultPresenter carResultPresenter = new CarResultPresenter(activity);
        this.f13773b = carResultPresenter;
        if (carResultPresenter != null) {
            carResultPresenter.setIView(this);
        }
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        String[] strArr = null;
        this.f13774c = activity2 instanceof CarCheckListener ? (CarCheckListener) activity2 : null;
        Bundle arguments = getArguments();
        String str3 = "";
        if (arguments == null || (str = arguments.getString(CarCheckActivity.USER_REPLY)) == null) {
            str = str3;
        }
        this.f13778g = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("order_id")) == null) {
            str2 = str3;
        }
        this.f13775d = str2;
        Bundle arguments3 = getArguments();
        if (!(arguments3 == null || (string = arguments3.getString("answer")) == null)) {
            str3 = string;
        }
        this.f13776e = str3;
        Bundle arguments4 = getArguments();
        this.f13777f = arguments4 == null ? -1 : arguments4.getInt("question_id");
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            strArr = arguments5.getStringArray(CarCheckActivity.ANSWERS);
        }
        this.f13779h = strArr;
        boolean z = false;
        this.f13772a = layoutInflater.inflate(R.layout.global_car_check_result_fragment, viewGroup, false);
        if (this.f13778g.length() > 0) {
            z = true;
        }
        if (z) {
            initContentView(this.f13778g);
        } else {
            CarResultPresenter carResultPresenter2 = this.f13773b;
            if (carResultPresenter2 != null) {
                carResultPresenter2.getCarCheckResult(this.f13775d, this.f13777f, this.f13776e);
            }
        }
        return this.f13772a;
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initContentView(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "reply"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.view.View r0 = r5.f13772a
            r1 = 0
            if (r0 != 0) goto L_0x000c
            r0 = r1
            goto L_0x0015
        L_0x000c:
            r2 = 2131428058(0x7f0b02da, float:1.847775E38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x0015:
            r2 = 0
            if (r0 != 0) goto L_0x0019
            goto L_0x001c
        L_0x0019:
            r0.setVisibility(r2)
        L_0x001c:
            android.view.View r0 = r5.f13772a
            r3 = 2131428059(0x7f0b02db, float:1.8477752E38)
            if (r0 != 0) goto L_0x0025
            r0 = r1
            goto L_0x002b
        L_0x0025:
            android.view.View r0 = r0.findViewById(r3)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x002b:
            if (r0 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            r0.setVisibility(r2)
        L_0x0031:
            java.lang.String[] r0 = r5.f13779h
            r4 = 1
            if (r0 == 0) goto L_0x0040
            int r0 = r0.length
            if (r0 != 0) goto L_0x003b
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r4 = 0
        L_0x0040:
            if (r4 == 0) goto L_0x0045
            java.lang.String r0 = ""
            goto L_0x004c
        L_0x0045:
            java.lang.String[] r0 = r5.f13779h
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0 = r0[r2]
        L_0x004c:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x0063
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            android.content.Context r6 = (android.content.Context) r6
            r0 = 2131954910(0x7f130cde, float:1.9546333E38)
            java.lang.String r6 = com.didi.sdk.util.ResourcesHelper.getString(r6, r0)
            goto L_0x0073
        L_0x0063:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            android.content.Context r6 = (android.content.Context) r6
            r0 = 2131954909(0x7f130cdd, float:1.954633E38)
            java.lang.String r6 = com.didi.sdk.util.ResourcesHelper.getString(r6, r0)
        L_0x0073:
            android.view.View r0 = r5.f13772a
            if (r0 != 0) goto L_0x0078
            goto L_0x007f
        L_0x0078:
            android.view.View r0 = r0.findViewById(r3)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x007f:
            if (r1 != 0) goto L_0x0082
            goto L_0x0087
        L_0x0082:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.setText(r6)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.carcheck.fragment.CarResultFragment.initContentView(java.lang.String):void");
    }

    public void showErrorDialog(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        CarCheckListener carCheckListener = this.f13774c;
        if (carCheckListener != null) {
            carCheckListener.showErrorDialog(str);
        }
    }

    public void showErrorView() {
        TextView textView;
        View view = this.f13772a;
        LinearLayout linearLayout = view == null ? null : (LinearLayout) view.findViewById(R.id.car_check_error_view);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        View view2 = this.f13772a;
        if (view2 != null && (textView = (TextView) view2.findViewById(R.id.car_check_reload)) != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CarResultFragment.m9559a(CarResultFragment.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9559a(CarResultFragment carResultFragment, View view) {
        Intrinsics.checkNotNullParameter(carResultFragment, "this$0");
        CarResultPresenter carResultPresenter = carResultFragment.f13773b;
        if (carResultPresenter != null) {
            carResultPresenter.getCarCheckResult(carResultFragment.f13775d, carResultFragment.f13777f, carResultFragment.f13776e);
        }
        View view2 = carResultFragment.f13772a;
        LinearLayout linearLayout = view2 == null ? null : (LinearLayout) view2.findViewById(R.id.car_check_error_view);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void showLoadingView() {
        CarCheckListener carCheckListener = this.f13774c;
        if (carCheckListener != null) {
            carCheckListener.showLoadingView();
        }
    }

    public void hideLoadingView() {
        CarCheckListener carCheckListener = this.f13774c;
        if (carCheckListener != null) {
            carCheckListener.hideLoadingView();
        }
    }
}
