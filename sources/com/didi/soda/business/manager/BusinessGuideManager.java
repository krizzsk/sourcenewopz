package com.didi.soda.business.manager;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.soda.business.component.dynamic.guide.BusinessGuideWidget;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\bJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessGuideManager;", "", "()V", "TAG", "", "mBusinessGuideView", "Lcom/didi/soda/business/component/dynamic/guide/BusinessGuideWidget;", "attachToParent", "", "parent", "Landroid/view/ViewGroup;", "ctx", "Landroid/content/Context;", "handleKeyBack", "", "hideBusinessGuideView", "isGuideWidgetShown", "release", "showBusinessGuideView", "Companion", "Holder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessGuideManager.kt */
public final class BusinessGuideManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static BusinessGuideManager f39675c = Holder.INSTANCE.getHolder();

    /* renamed from: a */
    private final String f39676a;

    /* renamed from: b */
    private BusinessGuideWidget f39677b;

    public /* synthetic */ BusinessGuideManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BusinessGuideManager() {
        this.f39676a = "BusinessGuideManager";
    }

    /* renamed from: a */
    private final void m28274a(ViewGroup viewGroup, Context context) {
        BusinessGuideWidget businessGuideWidget = this.f39677b;
        if ((businessGuideWidget == null ? null : businessGuideWidget.getParent()) == null) {
            BusinessGuideWidget businessGuideWidget2 = new BusinessGuideWidget(context);
            viewGroup.addView(businessGuideWidget2, new ViewGroup.LayoutParams(-1, -1));
            businessGuideWidget2.setVisibility(0);
            AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
            AppConfig data = appConfigStorage.getData();
            if (!data.mBusinessGuideShowed) {
                data.mBusinessGuideShowed = true;
            }
            appConfigStorage.setData(data);
            Unit unit = Unit.INSTANCE;
            this.f39677b = businessGuideWidget2;
            if (businessGuideWidget2 != null) {
                businessGuideWidget2.setOnDismissListener(new BusinessGuideWidget.OnDismissListener() {
                    public final void onDismiss() {
                        BusinessGuideManager.m28275a(BusinessGuideManager.this);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28275a(BusinessGuideManager businessGuideManager) {
        Intrinsics.checkNotNullParameter(businessGuideManager, "this$0");
        LogUtil.m29100d(businessGuideManager.f39676a, " business guide  has been clicked");
    }

    public final void showBusinessGuideView(ViewGroup viewGroup, Context context) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(context, "ctx");
        if (!((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mBusinessGuideShowed) {
            BusinessGuideWidget businessGuideWidget = this.f39677b;
            boolean z = false;
            if (businessGuideWidget != null && businessGuideWidget.isShown()) {
                z = true;
            }
            if (!z) {
                m28274a(viewGroup, context);
                LogUtil.m29104i(this.f39676a, "business guide show success ");
                return;
            }
        }
        LogUtil.m29100d(this.f39676a, " business guide  has been already shown");
    }

    public final void hideBusinessGuideView() {
        LogUtil.m29104i(this.f39676a, "hideTipsView");
        BusinessGuideWidget businessGuideWidget = this.f39677b;
        if (businessGuideWidget != null && businessGuideWidget.getParent() != null && businessGuideWidget.getVisibility() == 0) {
            businessGuideWidget.setVisibility(8);
        }
    }

    public final boolean handleKeyBack() {
        BusinessGuideWidget businessGuideWidget = this.f39677b;
        if (!(businessGuideWidget != null && businessGuideWidget.isShown())) {
            return false;
        }
        hideBusinessGuideView();
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        data.mBusinessGuideShowed = true;
        appConfigStorage.setData(data);
        return true;
    }

    public final boolean isGuideWidgetShown() {
        BusinessGuideWidget businessGuideWidget = this.f39677b;
        return businessGuideWidget != null && businessGuideWidget.isShown();
    }

    public final void release() {
        LogUtil.m29100d(this.f39676a, "release");
        hideBusinessGuideView();
        this.f39677b = null;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessGuideManager$Holder;", "", "()V", "holder", "Lcom/didi/soda/business/manager/BusinessGuideManager;", "getHolder", "()Lcom/didi/soda/business/manager/BusinessGuideManager;", "setHolder", "(Lcom/didi/soda/business/manager/BusinessGuideManager;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessGuideManager.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static BusinessGuideManager holder = new BusinessGuideManager((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final BusinessGuideManager getHolder() {
            return holder;
        }

        public final void setHolder(BusinessGuideManager businessGuideManager) {
            Intrinsics.checkNotNullParameter(businessGuideManager, "<set-?>");
            holder = businessGuideManager;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessGuideManager$Companion;", "", "()V", "<set-?>", "Lcom/didi/soda/business/manager/BusinessGuideManager;", "instance", "getInstance", "()Lcom/didi/soda/business/manager/BusinessGuideManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessGuideManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BusinessGuideManager getInstance() {
            return BusinessGuideManager.f39675c;
        }
    }
}
