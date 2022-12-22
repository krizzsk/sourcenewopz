package global.didi.pay.merchant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.net.C14489Util;
import global.didi.pay.GlobalUniPayActivity;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchantcore.DSchemeConstantKt;
import global.didi.pay.merchantcore.model.DPayRequest;
import global.didi.pay.newview.NewGlobalPaymentView;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;
import global.didi.pay.presenter.GlobalAbsPaymentPresenter;
import global.didi.pay.presenter.GlobalMerchantPaymentPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0018"}, mo175978d2 = {"Lglobal/didi/pay/merchant/GlobalMerchantUniPayActivity;", "Lglobal/didi/pay/GlobalUniPayActivity;", "()V", "callStartActivity", "", "intent", "Landroid/content/Intent;", "callStartActivityForResult", "requestCode", "", "createPaymentView", "Lglobal/didi/pay/IGlobalPayView;", "createPresenter", "Lglobal/didi/pay/presenter/GlobalAbsPaymentPresenter;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyUp", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onNewIntent", "Companion", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalMerchantUniPayActivity.kt */
public final class GlobalMerchantUniPayActivity extends GlobalUniPayActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MERCHANT_REQUEST_TYPE = "merchantRequestType";

    @JvmStatic
    public static final void startActivity(Activity activity, MerchantRequestType merchantRequestType, PayParam payParam, DPayRequest dPayRequest, JSONObject jSONObject) {
        Companion.startActivity(activity, merchantRequestType, payParam, dPayRequest, jSONObject);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lglobal/didi/pay/merchant/GlobalMerchantUniPayActivity$Companion;", "", "()V", "MERCHANT_REQUEST_TYPE", "", "startActivity", "", "activity", "Landroid/app/Activity;", "merchantRequestType", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "payParam", "Lcom/didi/unifiedPay/component/model/PayParam;", "payRequest", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "extraParam", "Lorg/json/JSONObject;", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalMerchantUniPayActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void startActivity(Activity activity, MerchantRequestType merchantRequestType, PayParam payParam, DPayRequest dPayRequest, JSONObject jSONObject) {
            String str;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(merchantRequestType, GlobalMerchantUniPayActivity.MERCHANT_REQUEST_TYPE);
            Intrinsics.checkNotNullParameter(payParam, "payParam");
            Intent intent = new Intent(activity, GlobalMerchantUniPayActivity.class);
            Bundle bundle = new Bundle();
            if (jSONObject == null) {
                str = null;
            } else {
                str = jSONObject.toString();
            }
            bundle.putString(DSchemeConstantKt.EXTRA_JSON_PARAM, str);
            bundle.putParcelable("request", dPayRequest);
            intent.putExtra(GlobalMerchantUniPayActivity.MERCHANT_REQUEST_TYPE, merchantRequestType);
            bundle.putSerializable("uni_pay_param", C14489Util.jsonFromObject(payParam));
            Unit unit = Unit.INSTANCE;
            intent.putExtras(bundle);
            Unit unit2 = Unit.INSTANCE;
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setBackground(UnifiedPayThemeManager.Companion.getINS().getPayTheme(this));
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Bundle bundle;
        super.onNewIntent(intent);
        setIntent(intent);
        Bundle bundle2 = null;
        if (intent == null) {
            bundle = null;
        } else {
            bundle = intent.getExtras();
        }
        getBundleData(bundle);
        if (intent != null) {
            bundle2 = intent.getExtras();
        }
        if (bundle2 != null) {
            bundle2.putSerializable("pay_param", this.mPayParam);
        }
        this.mPayPresenter.onAdd(bundle2);
    }

    public void callStartActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void callStartActivity(Intent intent) {
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public IGlobalPayView createPaymentView() {
        return new NewGlobalPaymentView(this);
    }

    /* access modifiers changed from: protected */
    public GlobalAbsPaymentPresenter createPresenter() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        return new GlobalMerchantPaymentPresenter(this, supportFragmentManager, "", this);
    }
}
