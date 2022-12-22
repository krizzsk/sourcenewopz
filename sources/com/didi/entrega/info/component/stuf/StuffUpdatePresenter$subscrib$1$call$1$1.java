package com.didi.entrega.info.component.stuf;

import com.didi.entrega.info.model.BaseContactModel;
import com.didi.entrega.info.repo.InfoRepo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/entrega/info/model/BaseContactModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StuffUpdatePresenter.kt */
final class StuffUpdatePresenter$subscrib$1$call$1$1 extends Lambda implements Function0<BaseContactModel> {
    final /* synthetic */ InfoRepo $infoRepo;
    final /* synthetic */ StuffUpdatePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StuffUpdatePresenter$subscrib$1$call$1$1(StuffUpdatePresenter stuffUpdatePresenter, InfoRepo infoRepo) {
        super(0);
        this.this$0 = stuffUpdatePresenter;
        this.$infoRepo = infoRepo;
    }

    public final BaseContactModel invoke() {
        this.this$0.getComponentRepo().setStuffTypeModelValue(this.$infoRepo.getContStuf());
        StuffUpdatePresenter stuffUpdatePresenter = this.this$0;
        stuffUpdatePresenter.setStuffTypeModel(stuffUpdatePresenter.getComponentRepo().getStuffTypeModel());
        return this.this$0.getStuffTypeModel();
    }
}
