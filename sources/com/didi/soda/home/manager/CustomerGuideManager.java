package com.didi.soda.home.manager;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.guide.NewCustomerGuideContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u001e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/home/manager/CustomerGuideManager;", "", "()V", "TAG", "", "mAlreadyFetchedHomeUpInfo", "", "getMAlreadyFetchedHomeUpInfo", "()Z", "setMAlreadyFetchedHomeUpInfo", "(Z)V", "mGuideView", "Lcom/didi/soda/customer/widget/guide/NewCustomerGuideContainer;", "attachToParent", "", "parent", "Landroid/view/ViewGroup;", "ctx", "Landroid/content/Context;", "checkShouldHideGuideContainer", "closeCustomerGuide", "needShowNewCustomerGuide", "scopeCtx", "Lcom/didi/app/nova/skeleton/ScopeContext;", "registerScrollListener", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "release", "syncAndTriggerCustomerGuideInfoShown", "triggerCustomerGuideInfoShown", "Companion", "Holder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerGuideManager.kt */
public final class CustomerGuideManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STATUS_OF_CHECK_NEW_GUIDE = 1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static CustomerGuideManager f42676d = Holder.INSTANCE.getHolder();

    /* renamed from: a */
    private NewCustomerGuideContainer f42677a;

    /* renamed from: b */
    private boolean f42678b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f42679c;

    public /* synthetic */ CustomerGuideManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CustomerGuideManager() {
        this.f42679c = "CustomerGuideManager";
    }

    public final boolean getMAlreadyFetchedHomeUpInfo() {
        return this.f42678b;
    }

    public final void setMAlreadyFetchedHomeUpInfo(boolean z) {
        this.f42678b = z;
    }

    public final void registerScrollListener(Context context, NovaRecyclerView novaRecyclerView) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        Ref.IntRef intRef = new Ref.IntRef();
        if (novaRecyclerView != null) {
            novaRecyclerView.addOnScrollListener(new CustomerGuideManager$registerScrollListener$1(intRef, context, this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30145a(ViewGroup viewGroup, Context context) {
        NewCustomerGuideContainer newCustomerGuideContainer = this.f42677a;
        if ((newCustomerGuideContainer == null ? null : newCustomerGuideContainer.getParent()) == null) {
            NewCustomerGuideContainer newCustomerGuideContainer2 = new NewCustomerGuideContainer(context);
            this.f42677a = newCustomerGuideContainer2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            Unit unit = Unit.INSTANCE;
            viewGroup.addView(newCustomerGuideContainer2, layoutParams);
            NewCustomerGuideContainer newCustomerGuideContainer3 = this.f42677a;
            if (newCustomerGuideContainer3 != null) {
                newCustomerGuideContainer3.setVisibility(0);
            }
            NewCustomerGuideContainer newCustomerGuideContainer4 = this.f42677a;
            if (newCustomerGuideContainer4 != null) {
                newCustomerGuideContainer4.startShake();
            }
            AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
            AppConfig data = appConfigStorage.getData();
            if (!data.mNewCustomerGuideShowed) {
                data.mNewCustomerGuideShowed = true;
            }
            appConfigStorage.setData(data);
        }
    }

    public final void checkShouldHideGuideContainer() {
        NewCustomerGuideContainer newCustomerGuideContainer = this.f42677a;
        if (newCustomerGuideContainer != null && newCustomerGuideContainer.getParent() != null && newCustomerGuideContainer.getVisibility() == 0) {
            newCustomerGuideContainer.setVisibility(8);
        }
    }

    public final void needShowNewCustomerGuide(ViewGroup viewGroup, Context context, ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(context, "ctx");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeCtx");
        if (!GlobalContext.isEmbed() && !((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mNewCustomerGuideShowed) {
            ((CustomerGuideCheckRepo) RepoFactory.getRepo(CustomerGuideCheckRepo.class)).subscribe(scopeContext, new CustomerGuideManager$needShowNewCustomerGuide$1(this, viewGroup, context));
        }
    }

    public final void syncAndTriggerCustomerGuideInfoShown() {
        this.f42678b = true;
        triggerCustomerGuideInfoShown();
    }

    public final void triggerCustomerGuideInfoShown() {
        boolean checkHomePopNeedShown = CustomerDialogShownManager.Companion.getInstance().checkHomePopNeedShown();
        String str = this.f42679c;
        LogUtil.m29100d(str, "triggerCustomerGuideInfoShown------checkHomePopNeedShown=" + checkHomePopNeedShown + "------mAlreadyFetchedHomeUpInfo=" + this.f42678b);
        if (checkHomePopNeedShown && this.f42678b) {
            Integer num = (Integer) ((CustomerGuideCheckRepo) RepoFactory.getRepo(CustomerGuideCheckRepo.class)).getValue();
            if (num == null || num.intValue() != 1) {
                ((CustomerGuideCheckRepo) RepoFactory.getRepo(CustomerGuideCheckRepo.class)).setValue(1);
            }
        }
    }

    public final void closeCustomerGuide() {
        NewCustomerGuideContainer newCustomerGuideContainer = this.f42677a;
        if (newCustomerGuideContainer != null) {
            newCustomerGuideContainer.setVisibility(8);
        }
    }

    public final void release() {
        RepoFactory.clearRepo(CustomerGuideCheckRepo.class);
        this.f42678b = false;
        this.f42677a = null;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/manager/CustomerGuideManager$Holder;", "", "()V", "holder", "Lcom/didi/soda/home/manager/CustomerGuideManager;", "getHolder", "()Lcom/didi/soda/home/manager/CustomerGuideManager;", "setHolder", "(Lcom/didi/soda/home/manager/CustomerGuideManager;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerGuideManager.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static CustomerGuideManager holder = new CustomerGuideManager((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final CustomerGuideManager getHolder() {
            return holder;
        }

        public final void setHolder(CustomerGuideManager customerGuideManager) {
            Intrinsics.checkNotNullParameter(customerGuideManager, "<set-?>");
            holder = customerGuideManager;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/home/manager/CustomerGuideManager$Companion;", "", "()V", "STATUS_OF_CHECK_NEW_GUIDE", "", "<set-?>", "Lcom/didi/soda/home/manager/CustomerGuideManager;", "instance", "getInstance", "()Lcom/didi/soda/home/manager/CustomerGuideManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerGuideManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomerGuideManager getInstance() {
            return CustomerGuideManager.f42676d;
        }
    }
}
