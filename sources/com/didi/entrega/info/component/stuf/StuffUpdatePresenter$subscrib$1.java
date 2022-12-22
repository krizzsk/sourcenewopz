package com.didi.entrega.info.component.stuf;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.info.repo.InfoOrderRepoConfig;
import com.didi.entrega.info.repo.InfoRepo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/info/component/stuf/StuffUpdatePresenter$subscrib$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/entrega/info/repo/InfoOrderRepoConfig;", "call", "", "t", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StuffUpdatePresenter.kt */
public final class StuffUpdatePresenter$subscrib$1 implements Action1<InfoOrderRepoConfig> {
    final /* synthetic */ InfoRepo $infoRepo;
    final /* synthetic */ StuffUpdatePresenter this$0;

    StuffUpdatePresenter$subscrib$1(StuffUpdatePresenter stuffUpdatePresenter, InfoRepo infoRepo) {
        this.this$0 = stuffUpdatePresenter;
        this.$infoRepo = infoRepo;
    }

    public void call(InfoOrderRepoConfig infoOrderRepoConfig) {
        LogUtil.m14765i(this.this$0.getTAG(), "监听物品发生变化————————————");
        if (this.this$0.getComponentRepo().getStuffTypeModel() != null) {
            StuffUpdatePresenter stuffUpdatePresenter = this.this$0;
            stuffUpdatePresenter.setDataList(stuffUpdatePresenter.getStuffTypeModel(), new StuffUpdatePresenter$subscrib$1$call$1$1(stuffUpdatePresenter, this.$infoRepo));
        }
        if (this.this$0.getComponentRepo().getStuffRemarkModel() != null) {
            StuffUpdatePresenter stuffUpdatePresenter2 = this.this$0;
            stuffUpdatePresenter2.setDataList(stuffUpdatePresenter2.getStuffRemarkModel(), new StuffUpdatePresenter$subscrib$1$call$2$1(stuffUpdatePresenter2, this.$infoRepo));
        }
        LogUtil.m14765i(this.this$0.getTAG(), "监听物品发生变化end————————————");
    }
}
