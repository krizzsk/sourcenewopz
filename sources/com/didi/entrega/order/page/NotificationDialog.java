package com.didi.entrega.order.page;

import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.storage.AppConfigStorage;
import com.didi.entrega.customer.foundation.storage.model.AppConfig;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/order/page/NotificationDialog;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NotificationDialog.kt */
public final class NotificationDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/order/page/NotificationDialog$Companion;", "", "()V", "showNotificationSetting", "", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NotificationDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void showNotificationSetting(Context context, ScopeContext scopeContext) {
            if (scopeContext != null && context != null && !CustomerSystemUtil.areNotificationsEnabled(context)) {
                AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
                AppConfig data = appConfigStorage.getData();
                long j = data.mNotificationRemindShowTime;
                if (j <= 0 || System.currentTimeMillis() - j >= GlobalBubbleShowHelper.ONE_WEEK) {
                    DialogUtil.showNotificationRemindDialog(scopeContext.getNavigator(), C8215xa2384fae.INSTANCE, (RFDialogInterface.OnClickListener) null);
                    data.mNotificationRemindShowTime = System.currentTimeMillis();
                    appConfigStorage.setData(data);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: showNotificationSetting$lambda-0  reason: not valid java name */
        public static final void m46403showNotificationSetting$lambda0(RFDialog rFDialog) {
            CustomerSystemUtil.goNotificationSetting(GlobalContext.getContext());
        }
    }
}
