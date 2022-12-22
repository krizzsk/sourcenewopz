package com.didi.payment.pix.orderhistory.p137vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixOrderHistoryListResp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020)H\u0016J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020)R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\u001a\u0010\u001f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006-"}, mo175978d2 = {"Lcom/didi/payment/pix/orderhistory/vm/PixOrderHistoryVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "endOfListWatcher", "Landroidx/lifecycle/MutableLiveData;", "", "getEndOfListWatcher", "()Landroidx/lifecycle/MutableLiveData;", "setEndOfListWatcher", "(Landroidx/lifecycle/MutableLiveData;)V", "mIsRequesting", "mNextIndex", "", "mPageFrom", "getMPageFrom", "()I", "setMPageFrom", "(I)V", "mProductLine", "getMProductLine", "setMProductLine", "nextPageOrders", "", "Lcom/didi/payment/pix/net/response/PixOrderHistoryListResp$OrderItem;", "getNextPageOrders", "setNextPageOrders", "onItemClickListener", "getOnItemClickListener", "setOnItemClickListener", "orderType", "getOrderType", "setOrderType", "pixNetModel", "Lcom/didi/payment/pix/net/PixNetModel;", "getPixNetModel", "()Lcom/didi/payment/pix/net/PixNetModel;", "setPixNetModel", "(Lcom/didi/payment/pix/net/PixNetModel;)V", "loadData", "", "loadHistoryData", "firstPage", "loadNextPage", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.orderhistory.vm.PixOrderHistoryVM */
/* compiled from: PixOrderHistoryVM.kt */
public final class PixOrderHistoryVM extends WBaseViewModel {

    /* renamed from: a */
    private PixNetModel f31129a;

    /* renamed from: b */
    private MutableLiveData<Boolean> f31130b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<PixOrderHistoryListResp.OrderItem> f31131c = new MutableLiveData<>();

    /* renamed from: d */
    private MutableLiveData<List<PixOrderHistoryListResp.OrderItem>> f31132d = new MutableLiveData<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f31133e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f31134f;

    /* renamed from: g */
    private int f31135g;

    /* renamed from: h */
    private int f31136h;

    /* renamed from: i */
    private int f31137i;

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixOrderHistoryVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f31129a = new PixNetModel(application);
    }

    public final PixNetModel getPixNetModel() {
        return this.f31129a;
    }

    public final void setPixNetModel(PixNetModel pixNetModel) {
        Intrinsics.checkNotNullParameter(pixNetModel, "<set-?>");
        this.f31129a = pixNetModel;
    }

    public final MutableLiveData<Boolean> getEndOfListWatcher() {
        return this.f31130b;
    }

    public final void setEndOfListWatcher(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31130b = mutableLiveData;
    }

    public final MutableLiveData<PixOrderHistoryListResp.OrderItem> getOnItemClickListener() {
        return this.f31131c;
    }

    public final void setOnItemClickListener(MutableLiveData<PixOrderHistoryListResp.OrderItem> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31131c = mutableLiveData;
    }

    public final MutableLiveData<List<PixOrderHistoryListResp.OrderItem>> getNextPageOrders() {
        return this.f31132d;
    }

    public final void setNextPageOrders(MutableLiveData<List<PixOrderHistoryListResp.OrderItem>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f31132d = mutableLiveData;
    }

    /* access modifiers changed from: protected */
    public final int getMProductLine() {
        return this.f31135g;
    }

    /* access modifiers changed from: protected */
    public final void setMProductLine(int i) {
        this.f31135g = i;
    }

    /* access modifiers changed from: protected */
    public final int getOrderType() {
        return this.f31136h;
    }

    /* access modifiers changed from: protected */
    public final void setOrderType(int i) {
        this.f31136h = i;
    }

    /* access modifiers changed from: protected */
    public final int getMPageFrom() {
        return this.f31137i;
    }

    /* access modifiers changed from: protected */
    public final void setMPageFrom(int i) {
        this.f31137i = i;
    }

    public final void loadHistoryData(boolean z) {
        if (this.f31133e != -1) {
            this.f31134f = true;
            if (z) {
                isLoading().setValue(true);
            }
            this.f31129a.queryHistoryOrder(this.f31135g, this.f31133e, this.f31136h, new PixOrderHistoryVM$loadHistoryData$1(this, z));
        }
    }

    public final void loadNextPage() {
        if (this.f31133e != -1 && !this.f31134f) {
            loadHistoryData(false);
        }
    }
}
