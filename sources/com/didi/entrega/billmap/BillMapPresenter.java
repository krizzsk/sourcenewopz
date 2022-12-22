package com.didi.entrega.billmap;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.billmap.Contract;
import com.didi.entrega.billmap.model.BillMapInfoModel;
import com.didi.entrega.customer.repo.RepoFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/billmap/BillMapPresenter;", "Lcom/didi/entrega/billmap/Contract$AbsBillMapPresenter;", "()V", "onCreate", "", "refreshSenAndRecInfo", "mapInfoModel", "Lcom/didi/entrega/billmap/model/BillMapInfoModel;", "subscribeBillData", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillMapPresenter.kt */
public final class BillMapPresenter extends Contract.AbsBillMapPresenter {
    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m14639a();
    }

    /* renamed from: a */
    private final void m14639a() {
        ((BillMapStatusRepo) RepoFactory.getRepo(BillMapStatusRepo.class)).subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                BillMapPresenter.m14640a(BillMapPresenter.this, (BillMapInfoModel) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14640a(BillMapPresenter billMapPresenter, BillMapInfoModel billMapInfoModel) {
        Intrinsics.checkNotNullParameter(billMapPresenter, "this$0");
        billMapPresenter.m14641a(billMapInfoModel);
    }

    /* renamed from: a */
    private final void m14641a(BillMapInfoModel billMapInfoModel) {
        ((Contract.AbsBillMapView) getLogicView()).cleanSendAndRecMarker();
        if (billMapInfoModel != null) {
            LatLng senderLatLng = billMapInfoModel.getSenderLatLng();
            LatLng receiverLatLng = billMapInfoModel.getReceiverLatLng();
            String senderDisplayName = billMapInfoModel.getSenderDisplayName();
            String etaTips = billMapInfoModel.getEtaTips();
            if (TextUtils.isEmpty(etaTips)) {
                etaTips = billMapInfoModel.getReceiverDisplayName();
            }
            ((Contract.AbsBillMapView) getLogicView()).showSendAndRecMarkInfo(senderLatLng, receiverLatLng, senderDisplayName, etaTips);
        }
    }
}
