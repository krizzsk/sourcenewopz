package com.didi.sdk.global.sign.payselect.module;

import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.base.module.LazyBizModule;
import com.didi.sdk.global.sign.payselect.PayMethodSelVM;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/NetErrModule;", "Lcom/didi/sdk/global/base/module/LazyBizModule;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewStub", "Landroid/view/ViewStub;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewStub;)V", "vm", "Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM;", "bindData", "", "data", "type", "", "initView", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Companion", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NetErrModule.kt */
public final class NetErrModule extends LazyBizModule<Object> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final PayMethodSelVM f36270a;

    public void bindData(Object obj, int i) {
        Intrinsics.checkNotNullParameter(obj, "data");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetErrModule(FragmentActivity fragmentActivity, ViewStub viewStub) {
        super(fragmentActivity, viewStub, fragmentActivity, fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        ViewModel viewModel = new ViewModelProvider(getViewModelStoreOwner()).get(PayMethodSelVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo…yMethodSelVM::class.java)");
        this.f36270a = (PayMethodSelVM) viewModel;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/NetErrModule$Companion;", "", "()V", "create", "Lcom/didi/sdk/global/sign/payselect/module/NetErrModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewStub", "Landroid/view/ViewStub;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NetErrModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NetErrModule create(FragmentActivity fragmentActivity, ViewStub viewStub) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(viewStub, "viewStub");
            return new NetErrModule(fragmentActivity, viewStub);
        }
    }

    public void initView() {
        getRootView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NetErrModule.m25654a(NetErrModule.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25654a(NetErrModule netErrModule, View view) {
        Intrinsics.checkNotNullParameter(netErrModule, "this$0");
        DidiGlobalPayMethodListData.PayMethodListParam mParam = netErrModule.f36270a.getMParam();
        if (mParam != null) {
            PayMethodSelVM payMethodSelVM = netErrModule.f36270a;
            DidiGlobalPayMethodListData.Entrance entrance = mParam.from;
            Intrinsics.checkNotNullExpressionValue(entrance, "it.from");
            payMethodSelVM.requestDataFromServer(entrance);
        }
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.f36270a.isNetErrorLD().observe(getLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                NetErrModule.m25655a(NetErrModule.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25655a(NetErrModule netErrModule, Boolean bool) {
        Intrinsics.checkNotNullParameter(netErrModule, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isNetError");
        if (bool.booleanValue()) {
            if (!netErrModule.isInflatedViewStub()) {
                netErrModule.inflateViewStub();
            }
            netErrModule.getRootView().setVisibility(0);
        } else if (netErrModule.isInflatedViewStub()) {
            netErrModule.getRootView().setVisibility(8);
        }
    }
}
