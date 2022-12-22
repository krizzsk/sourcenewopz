package com.didiglobal.p205sa.biz.activity;

import com.didiglobal.p205sa.biz.tab.manager.SATabManager;
import com.didiglobal.p205sa.biz.tab.model.SaTabDataModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "tabDataModel", "Lcom/didiglobal/sa/biz/tab/model/SaTabDataModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.activity.SuperAppMainActivity$initView$1 */
/* compiled from: SuperAppMainActivity.kt */
final class SuperAppMainActivity$initView$1 extends Lambda implements Function1<SaTabDataModel, Unit> {
    final /* synthetic */ SuperAppMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuperAppMainActivity$initView$1(SuperAppMainActivity superAppMainActivity) {
        super(1);
        this.this$0 = superAppMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SaTabDataModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SaTabDataModel saTabDataModel) {
        Intrinsics.checkNotNullParameter(saTabDataModel, "tabDataModel");
        SATabManager access$getSaTabManager$p = this.this$0.f50725g;
        if (access$getSaTabManager$p != null) {
            access$getSaTabManager$p.refreshTab(saTabDataModel);
        }
    }
}
