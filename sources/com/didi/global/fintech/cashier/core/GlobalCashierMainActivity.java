package com.didi.global.fintech.cashier.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierView;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter;
import com.didi.global.fintech.cashier.core.utils.PayInfoManager;
import com.didi.global.fintech.cashier.core.view.GlobalCashierMainView;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.response.OrderInfo;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierMainActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "()V", "mCurCashierAction", "", "finish", "", "getPresenter", "getView", "layoutRes", "", "onActionInterceptJumpThirdPage", "action", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCallStartActivity", "intent", "onCallStartActivityForResult", "onClose", "payResult", "onResume", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierMainActivity.kt */
public class GlobalCashierMainActivity extends BaseCashierActivity<IGlobalMainCashierPresenter, IGlobalCashierView> implements IGlobalCashierActionInterceptCallback, IGlobalCashierCallback {

    /* renamed from: a */
    private String f21411a;

    public int layoutRes() {
        return R.layout.activity_global_cashier_main;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.drawer_bottom_out);
    }

    public IGlobalMainCashierPresenter getPresenter() {
        return new GlobalCashierMainPresenter(this, getMUniqueId(), this, this);
    }

    public IGlobalCashierView getView() {
        View findViewById = findViewById(R.id.activity_cashier_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.activity_cashier_root_view)");
        return new GlobalCashierMainView(this, (ViewGroup) findViewById);
    }

    public void onClose(int i) {
        OrderInfo orderInfo;
        IGlobalMainCashierPresenter iGlobalMainCashierPresenter = (IGlobalMainCashierPresenter) getMPresenter();
        if (iGlobalMainCashierPresenter != null) {
            iGlobalMainCashierPresenter.unBind();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        PayInfoResponse payInfo = PayInfoManager.getInstance().getPayInfo(getMUniqueId());
        bundle.putInt("code", i);
        String str = null;
        if (!(payInfo == null || (orderInfo = payInfo.getOrderInfo()) == null)) {
            str = orderInfo.getReturnUrl();
        }
        bundle.putString("return_url", str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public void onCallStartActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void onCallStartActivity(Intent intent) {
        startActivity(intent);
    }

    public void onBackPressed() {
        IGlobalMainCashierPresenter iGlobalMainCashierPresenter = (IGlobalMainCashierPresenter) getMPresenter();
        if (iGlobalMainCashierPresenter != null) {
            iGlobalMainCashierPresenter.onBackPressed("key");
        }
    }

    public void onActionInterceptJumpThirdPage(String str) {
        this.f21411a = str;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        String str = this.f21411a;
        if (Intrinsics.areEqual((Object) str, (Object) CashierAction.ACTION_RANDOM_VERIFY)) {
            this.f21411a = null;
            onCardVerify((String) null);
        } else if (Intrinsics.areEqual((Object) str, (Object) CashierAction.ACTION_TOP_UP)) {
            this.f21411a = null;
            onTopUp();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = -1
            if (r6 == r0) goto L_0x0007
            super.onActivityResult(r5, r6, r7)
            return
        L_0x0007:
            java.lang.String r0 = "card_index"
            r1 = 1
            r2 = 0
            if (r5 == r1) goto L_0x006e
            r3 = 2
            if (r5 == r3) goto L_0x0063
            r3 = 6
            if (r5 == r3) goto L_0x005f
            r3 = 8
            if (r5 == r3) goto L_0x005b
            r3 = 10
            if (r5 == r3) goto L_0x005b
            r3 = 100
            if (r5 == r3) goto L_0x0057
            r3 = 300(0x12c, float:4.2E-43)
            if (r5 == r3) goto L_0x0035
            r0 = 200(0xc8, float:2.8E-43)
            r1 = 7
            if (r5 == r0) goto L_0x0031
            r0 = 201(0xc9, float:2.82E-43)
            if (r5 == r0) goto L_0x002d
            goto L_0x0078
        L_0x002d:
            r4.onClose(r1)
            goto L_0x0078
        L_0x0031:
            r4.onClose(r1)
            goto L_0x0078
        L_0x0035:
            if (r7 != 0) goto L_0x0039
            r0 = r2
            goto L_0x003d
        L_0x0039:
            java.lang.String r0 = r7.getStringExtra(r0)
        L_0x003d:
            if (r7 != 0) goto L_0x0040
            goto L_0x004a
        L_0x0040:
            java.lang.String r2 = "installment_number"
            int r1 = r7.getIntExtra(r2, r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
        L_0x004a:
            com.didi.global.fintech.cashier.core.contract.IGlobalCashierBasePresenter r1 = r4.getMPresenter()
            com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter r1 = (com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter) r1
            if (r1 != 0) goto L_0x0053
            goto L_0x0078
        L_0x0053:
            r1.onInstallmentClick(r0, r2)
            goto L_0x0078
        L_0x0057:
            r4.onClose(r1)
            goto L_0x0078
        L_0x005b:
            r4.onTopUp()
            goto L_0x0078
        L_0x005f:
            r4.onCardVerify(r2)
            goto L_0x0078
        L_0x0063:
            if (r7 != 0) goto L_0x0066
            goto L_0x006a
        L_0x0066:
            java.lang.String r2 = r7.getStringExtra(r0)
        L_0x006a:
            r4.onCardVerify(r2)
            goto L_0x0078
        L_0x006e:
            if (r7 != 0) goto L_0x0071
            goto L_0x0075
        L_0x0071:
            java.lang.String r2 = r7.getStringExtra(r0)
        L_0x0075:
            r4.onCardBind(r2)
        L_0x0078:
            super.onActivityResult(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.GlobalCashierMainActivity.onActivityResult(int, int, android.content.Intent):void");
    }
}
