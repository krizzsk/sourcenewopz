package com.didi.payment.wallet.global.prepaidcard.interceptor;

import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.interceptor.IPrepaidInterceptor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001e\u0010(\u001a\u00020)2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006-"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/interceptor/RealPrepaidChain;", "Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor$Chain;", "interceptors", "", "Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor;", "activity", "Landroidx/fragment/app/FragmentActivity;", "netModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "index", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "(Ljava/util/List;Landroidx/fragment/app/FragmentActivity;Lcom/didi/payment/wallet/global/model/WalletPageModel;ILcom/didi/drouter/router/Request;Lcom/didi/drouter/router/Result;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "getIndex", "()I", "setIndex", "(I)V", "getInterceptors", "()Ljava/util/List;", "setInterceptors", "(Ljava/util/List;)V", "getNetModel", "()Lcom/didi/payment/wallet/global/model/WalletPageModel;", "setNetModel", "(Lcom/didi/payment/wallet/global/model/WalletPageModel;)V", "getRequest", "()Lcom/didi/drouter/router/Request;", "setRequest", "(Lcom/didi/drouter/router/Request;)V", "getResult", "()Lcom/didi/drouter/router/Result;", "setResult", "(Lcom/didi/drouter/router/Result;)V", "proceed", "", "params", "", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RealPrepaidChain.kt */
public final class RealPrepaidChain implements IPrepaidInterceptor.Chain {

    /* renamed from: a */
    private List<? extends IPrepaidInterceptor> f31770a;

    /* renamed from: b */
    private FragmentActivity f31771b;

    /* renamed from: c */
    private WalletPageModel f31772c;

    /* renamed from: d */
    private int f31773d;

    /* renamed from: e */
    private Request f31774e;

    /* renamed from: f */
    private Result f31775f;

    public RealPrepaidChain(List<? extends IPrepaidInterceptor> list, FragmentActivity fragmentActivity, WalletPageModel walletPageModel, int i, Request request, Result result) {
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(walletPageModel, "netModel");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        this.f31770a = list;
        this.f31771b = fragmentActivity;
        this.f31772c = walletPageModel;
        this.f31773d = i;
        this.f31774e = request;
        this.f31775f = result;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealPrepaidChain(List list, FragmentActivity fragmentActivity, WalletPageModel walletPageModel, int i, Request request, Result result, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, fragmentActivity, walletPageModel, (i2 & 8) != 0 ? 0 : i, request, result);
    }

    public final List<IPrepaidInterceptor> getInterceptors() {
        return this.f31770a;
    }

    public final void setInterceptors(List<? extends IPrepaidInterceptor> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f31770a = list;
    }

    public final FragmentActivity getActivity() {
        return this.f31771b;
    }

    public final WalletPageModel getNetModel() {
        return this.f31772c;
    }

    public final void setActivity(FragmentActivity fragmentActivity) {
        this.f31771b = fragmentActivity;
    }

    public final void setNetModel(WalletPageModel walletPageModel) {
        Intrinsics.checkNotNullParameter(walletPageModel, "<set-?>");
        this.f31772c = walletPageModel;
    }

    public final int getIndex() {
        return this.f31773d;
    }

    public final Request getRequest() {
        return this.f31774e;
    }

    public final Result getResult() {
        return this.f31775f;
    }

    public final void setIndex(int i) {
        this.f31773d = i;
    }

    public final void setRequest(Request request) {
        Intrinsics.checkNotNullParameter(request, "<set-?>");
        this.f31774e = request;
    }

    public final void setResult(Result result) {
        Intrinsics.checkNotNullParameter(result, "<set-?>");
        this.f31775f = result;
    }

    public void proceed(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        int size = this.f31770a.size();
        int i = this.f31773d;
        if (i < size) {
            ((IPrepaidInterceptor) this.f31770a.get(this.f31773d)).onInterceptor(this.f31771b, this.f31772c, new RealPrepaidChain(this.f31770a, this.f31771b, this.f31772c, i + 1, this.f31774e, this.f31775f), map, this.f31774e, this.f31775f);
        }
    }
}
