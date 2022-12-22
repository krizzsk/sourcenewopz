package com.didi.dimina.container.secondparty;

import android.os.Handler;
import android.os.Looper;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.Dimina4DiContainerActivity;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006¸\u0006\u0000"}, mo175978d2 = {"com/didi/dimina/container/secondparty/Dimina4DiContainerActivity$startDimina$1$1", "Lcom/didi/dimina/container/mina/IDMCommonAction;", "Lcom/didi/dimina/container/DMMina$InstallStatus;", "callback", "", "t", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Dimina4DiContainerActivity.kt */
public final class Dimina4DiContainerActivity$startDimina$$inlined$let$lambda$1 implements IDMCommonAction<DMMina.InstallStatus> {
    final /* synthetic */ DMMina $it;
    final /* synthetic */ Dimina4DiContainerActivity this$0;

    Dimina4DiContainerActivity$startDimina$$inlined$let$lambda$1(DMMina dMMina, Dimina4DiContainerActivity dimina4DiContainerActivity) {
        this.$it = dMMina;
        this.this$0 = dimina4DiContainerActivity;
    }

    public void callback(final DMMina.InstallStatus installStatus) {
        DMConfig config = this.$it.getConfig();
        if (config != null && config.getLaunchConfig() != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ Dimina4DiContainerActivity$startDimina$$inlined$let$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    DMMina.InstallStatus installStatus = installStatus;
                    if (installStatus != null && Dimina4DiContainerActivity.WhenMappings.$EnumSwitchMapping$0[installStatus.ordinal()] == 2) {
                        Dimina4DiContainerActivity.access$getLoadingView$p(this.this$0.this$0).setVisibility(8);
                        this.this$0.this$0.m12567a();
                    }
                }
            });
        }
    }
}
