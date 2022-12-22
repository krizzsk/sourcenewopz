package com.didi.soda.home.manager;

import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "refresh", "", "isGmsDialogShown"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerDialogShownManager.kt */
final class CustomerDialogShownManager$onResumeCheckLocationSettingService$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ CustomerDialogShownManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerDialogShownManager$onResumeCheckLocationSettingService$1(CustomerDialogShownManager customerDialogShownManager) {
        super(2);
        this.this$0 = customerDialogShownManager;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(6);
            }
            this.this$0.f42675e = 0;
        }
    }
}
