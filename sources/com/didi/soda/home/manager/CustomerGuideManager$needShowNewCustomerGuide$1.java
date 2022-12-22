package com.didi.soda.home.manager;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J!\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, mo175978d2 = {"com/didi/soda/home/manager/CustomerGuideManager$needShowNewCustomerGuide$1", "Lcom/didi/app/nova/skeleton/repo/Action2;", "", "call", "", "status", "s", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "(Ljava/lang/Integer;Lcom/didi/app/nova/skeleton/repo/Subscription;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerGuideManager.kt */
public final class CustomerGuideManager$needShowNewCustomerGuide$1 implements Action2<Integer> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ ViewGroup $parent;
    final /* synthetic */ CustomerGuideManager this$0;

    CustomerGuideManager$needShowNewCustomerGuide$1(CustomerGuideManager customerGuideManager, ViewGroup viewGroup, Context context) {
        this.this$0 = customerGuideManager;
        this.$parent = viewGroup;
        this.$ctx = context;
    }

    public void call(Integer num, Subscription subscription) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (num != null) {
            CustomerGuideManager customerGuideManager = this.this$0;
            ViewGroup viewGroup = this.$parent;
            Context context = this.$ctx;
            if (num.intValue() == 1) {
                customerGuideManager.m30145a(viewGroup, context);
            }
        }
    }
}
