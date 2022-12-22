package com.didi.entrega.info.component.send;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.info.repo.InfoOrderRepoConfig;
import com.didi.entrega.info.repo.InfoRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/info/component/send/SendContactUpdatePresenter$subscrib$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/entrega/info/repo/InfoOrderRepoConfig;", "call", "", "t", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SendContactUpdatePresenter.kt */
public final class SendContactUpdatePresenter$subscrib$1 implements Action1<InfoOrderRepoConfig> {
    final /* synthetic */ InfoRepo $infoRepo;
    final /* synthetic */ SendContactUpdatePresenter this$0;

    SendContactUpdatePresenter$subscrib$1(InfoRepo infoRepo, SendContactUpdatePresenter sendContactUpdatePresenter) {
        this.$infoRepo = infoRepo;
        this.this$0 = sendContactUpdatePresenter;
    }

    public void call(InfoOrderRepoConfig infoOrderRepoConfig) {
        AddressEntity sendContact = this.$infoRepo.getSendContact();
        int indexOf = this.this$0.getDataListManager().indexOf(this.this$0.getContractModel());
        LogUtil.m14765i(this.this$0.getTAG(), Intrinsics.stringPlus("联系人发生变化,index:", Integer.valueOf(indexOf)));
        if (indexOf >= 0) {
            this.this$0.getComponentRepo().setSenderValue(sendContact);
            SendContactUpdatePresenter sendContactUpdatePresenter = this.this$0;
            sendContactUpdatePresenter.setContractModel(sendContactUpdatePresenter.getComponentRepo().getSender());
            if (this.this$0.getContractModel() != null) {
                this.this$0.getDataListManager().set(indexOf, this.this$0.getContractModel());
            }
        }
    }
}
