package com.didi.soda.customer.widget.tabbar;

import android.view.View;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabBarController.kt */
final class TabBarController$setupTabItemView$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ C13883a $model;
    final /* synthetic */ TabBarController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabBarController$setupTabItemView$2(TabBarController tabBarController, C13883a aVar) {
        super(1);
        this.this$0 = tabBarController;
        this.$model = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        ComponentController controller;
        Intrinsics.checkNotNullParameter(view, "it");
        if (!Intrinsics.areEqual((Object) this.this$0.f42193c, (Object) this.$model)) {
            LogUtil.m29100d("TabBar", "DoubleClick but not active");
            this.this$0.m29752b(this.$model);
            this.this$0.m29745a(this.$model, true);
            return;
        }
        LogUtil.m29100d("TabBar", "invoke onDoubleClickTab");
        C13883a access$getCurSelected$p = this.this$0.f42193c;
        if (access$getCurSelected$p != null && (controller = access$getCurSelected$p.mo106241a().getController()) != null) {
            controller.onDoubleClickTab();
        }
    }
}
