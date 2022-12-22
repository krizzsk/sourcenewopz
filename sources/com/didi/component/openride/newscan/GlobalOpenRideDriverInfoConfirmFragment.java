package com.didi.component.openride.newscan;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.openride.widget.OpenRideDriverInfoPopWin;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/component/openride/newscan/GlobalOpenRideDriverInfoConfirmFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didi/component/openride/newscan/IQRScannerView;", "()V", "mOpenRidePresenter", "Lcom/didi/component/openride/newscan/GlobalOpenRideQRScanPresenter;", "mPop", "Lcom/didi/component/openride/widget/OpenRideDriverInfoPopWin;", "dismissRequestLoadingDialog", "", "finishWithResultOk", "initData", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "parseData", "Lcom/didi/travel/psnger/model/response/PinCodeInfoResult;", "data", "", "scanResume", "showNotRequireQRCodeToast", "showPop", "result", "showRequestFailedToast", "pinCodeInfoResult", "showRequestLoadingDialog", "Companion", "comp-openride_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalOpenRideDriverInfoConfirmFragment.kt */
public final class GlobalOpenRideDriverInfoConfirmFragment extends Fragment implements IQRScannerView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_DATA = "data";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OpenRideDriverInfoPopWin f14729a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GlobalOpenRideQRScanPresenter f14730b;

    public void _$_clearFindViewByIdCache() {
    }

    public void dismissRequestLoadingDialog() {
    }

    public void finishWithResultOk() {
    }

    public void showNotRequireQRCodeToast() {
    }

    public void showRequestFailedToast(PinCodeInfoResult pinCodeInfoResult) {
    }

    public void showRequestLoadingDialog() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/component/openride/newscan/GlobalOpenRideDriverInfoConfirmFragment$Companion;", "", "()V", "KEY_DATA", "", "comp-openride_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalOpenRideDriverInfoConfirmFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m10537b();
        m10536a();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_layout_global_openride_driverinfoconfirm, viewGroup, false);
    }

    /* renamed from: a */
    private final void m10536a() {
        String string;
        this.f14730b = new GlobalOpenRideQRScanPresenter(getContext(), this);
        Bundle arguments = getArguments();
        String str = "";
        if (!(arguments == null || (string = arguments.getString("data")) == null)) {
            str = string;
        }
        if (TextUtils.isEmpty(str)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        PinCodeInfoResult a = m10535a(str);
        if (a == null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        OpenRideDriverInfoPopWin openRideDriverInfoPopWin = new OpenRideDriverInfoPopWin(getContext(), getView());
        this.f14729a = openRideDriverInfoPopWin;
        if (openRideDriverInfoPopWin != null) {
            openRideDriverInfoPopWin.setOnClickListener(new GlobalOpenRideDriverInfoConfirmFragment$initData$1(this, a));
        }
        UiThreadHandler.getsUiHandler().postDelayed(new GlobalOpenRideDriverInfoConfirmFragment$initData$2(this), 500);
    }

    /* renamed from: a */
    private final PinCodeInfoResult m10535a(String str) {
        try {
            PinCodeInfoResult pinCodeInfoResult = new PinCodeInfoResult();
            pinCodeInfoResult.parse(new JSONObject().putOpt("data", new JSONObject(str)).toString());
            return pinCodeInfoResult;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    private final void m10537b() {
        StatusBarLightingCompat.setStatusBarBgLightning(getActivity(), true, 0);
    }

    public void scanResume() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void showPop(PinCodeInfoResult pinCodeInfoResult) {
        if (getContext() != null && !isDetached()) {
            OpenRideDriverInfoPopWin openRideDriverInfoPopWin = new OpenRideDriverInfoPopWin(getContext(), getView());
            this.f14729a = openRideDriverInfoPopWin;
            if (openRideDriverInfoPopWin != null) {
                openRideDriverInfoPopWin.setOnClickListener(new GlobalOpenRideDriverInfoConfirmFragment$showPop$1(this, pinCodeInfoResult));
            }
            OpenRideDriverInfoPopWin openRideDriverInfoPopWin2 = this.f14729a;
            if (openRideDriverInfoPopWin2 != null) {
                openRideDriverInfoPopWin2.show();
            }
        }
    }
}
