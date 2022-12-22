package com.didi.soda.goodsV2.manager;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/goodsV2/manager/ActInfoRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "()V", "mActInfoStr", "", "getValueStr", "setValue", "", "value", "setValueStr", "actInfoStr", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActInfoRepo.kt */
public final class ActInfoRepo extends Repo<ActInfoEntity> {

    /* renamed from: a */
    private String f42519a;

    public final void setValueStr(String str) {
        this.f42519a = str;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            setValue((ActInfoEntity) null);
        }
        try {
            setValue((ActInfoEntity) GsonUtil.fromJson(str, ActInfoEntity.class));
        } catch (Exception e) {
            LogUtil.m29104i("ActInfoRepo", "actInfoStr parse error: " + e + '|' + str);
        }
    }

    public void setValue(ActInfoEntity actInfoEntity) {
        if (actInfoEntity == null) {
            this.f42519a = "";
        }
        try {
            this.f42519a = GsonUtil.toJson(actInfoEntity);
        } catch (Exception e) {
            LogUtil.m29104i("ActInfoRepo", "actInfoStr parse error: " + e + "|set");
        }
        super.setValue(actInfoEntity);
    }

    public final String getValueStr() {
        return this.f42519a;
    }
}
