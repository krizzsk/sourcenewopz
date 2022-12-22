package com.didi.entrega.info.repo;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.entrega.bill.repo.BillConfigRepo;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.model.BaseContactModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\tJ,\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u001a\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010\tJ\u0018\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0002J\u0010\u0010%\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\tJ\u0018\u0010&\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0002J\u0010\u0010'\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\tJ\u0018\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0002J\u0018\u0010*\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, mo175978d2 = {"Lcom/didi/entrega/info/repo/InfoRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/entrega/info/repo/InfoOrderRepoConfig;", "()V", "cartId", "", "contactStuf", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "receiveContact", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "sendContact", "clear", "", "getCartId", "getContStuf", "getReceiveContact", "getSendContact", "setRealValue", "Lcom/didi/entrega/info/model/BaseContactModel;", "target", "checkSetBlock", "Lkotlin/Function0;", "config", "setValue", "value", "subscribeViscidity", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "pageContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "Lcom/didi/app/nova/skeleton/repo/Action;", "updateCartId", "updateDoubleContact", "sendContac", "receive", "updateReceiveContact", "contact", "updateReceiveContactNotNotyfy", "updateSendContact", "updateSendContactNotNotify", "updateStuf", "contactContact", "updateStufDontNotyfy", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoRepo.kt */
public final class InfoRepo extends Repo<InfoOrderRepoConfig> {

    /* renamed from: a */
    private AddressEntity f20817a;

    /* renamed from: b */
    private AddressEntity f20818b;

    /* renamed from: c */
    private ContactStufEntity f20819c;

    /* renamed from: d */
    private String f20820d;

    public void setValue(InfoOrderRepoConfig infoOrderRepoConfig) {
        super.setValue(infoOrderRepoConfig);
    }

    public final Subscription subscribeViscidity(ScopeContext scopeContext, Action<InfoOrderRepoConfig> action) {
        Subscription subscribe = getLiveData().from().shutViscidityNotice().subscribe(scopeContext, action);
        Intrinsics.checkNotNullExpressionValue(subscribe, "liveData.from().shutVisc…ribe(pageContext, action)");
        return subscribe;
    }

    public final AddressEntity getSendContact() {
        AddressEntity addressEntity = this.f20817a;
        return addressEntity == null ? new AddressEntity() : addressEntity;
    }

    public final AddressEntity getReceiveContact() {
        AddressEntity addressEntity = this.f20818b;
        return addressEntity == null ? new AddressEntity() : addressEntity;
    }

    public final ContactStufEntity getContStuf() {
        ContactStufEntity contactStufEntity = this.f20819c;
        return contactStufEntity == null ? new ContactStufEntity() : contactStufEntity;
    }

    public final String getCartId() {
        return this.f20820d;
    }

    public final void updateSendContact(AddressEntity addressEntity, InfoOrderRepoConfig infoOrderRepoConfig) {
        Intrinsics.checkNotNullParameter(infoOrderRepoConfig, "config");
        AddressEntity clone = addressEntity == null ? null : addressEntity.clone();
        if (clone == null) {
            clone = new AddressEntity();
        }
        this.f20817a = clone;
        setValue(infoOrderRepoConfig);
    }

    public final void updateSendContactNotNotify(AddressEntity addressEntity) {
        AddressEntity clone = addressEntity == null ? null : addressEntity.clone();
        if (clone == null) {
            clone = new AddressEntity();
        }
        this.f20817a = clone;
    }

    public final void updateReceiveContact(AddressEntity addressEntity, InfoOrderRepoConfig infoOrderRepoConfig) {
        Intrinsics.checkNotNullParameter(infoOrderRepoConfig, "config");
        AddressEntity clone = addressEntity == null ? null : addressEntity.clone();
        if (clone == null) {
            clone = new AddressEntity();
        }
        this.f20818b = clone;
        setValue(infoOrderRepoConfig);
    }

    public final void updateReceiveContactNotNotyfy(AddressEntity addressEntity) {
        AddressEntity clone = addressEntity == null ? null : addressEntity.clone();
        if (clone == null) {
            clone = new AddressEntity();
        }
        this.f20818b = clone;
    }

    public final void updateStuf(ContactStufEntity contactStufEntity, InfoOrderRepoConfig infoOrderRepoConfig) {
        Intrinsics.checkNotNullParameter(infoOrderRepoConfig, "config");
        if (contactStufEntity == null) {
            contactStufEntity = new ContactStufEntity();
        }
        this.f20819c = contactStufEntity;
        setValue(infoOrderRepoConfig);
    }

    public final void updateStufDontNotyfy(ContactStufEntity contactStufEntity, InfoOrderRepoConfig infoOrderRepoConfig) {
        Intrinsics.checkNotNullParameter(infoOrderRepoConfig, "config");
        if (contactStufEntity == null) {
            contactStufEntity = new ContactStufEntity();
        }
        this.f20819c = contactStufEntity;
    }

    public final void updateCartId(String str) {
        this.f20820d = str;
        InfoOrderRepoConfig infoOrderRepoConfig = new InfoOrderRepoConfig();
        infoOrderRepoConfig.setUpdateType(0);
        Unit unit = Unit.INSTANCE;
        setValue(infoOrderRepoConfig);
    }

    /* renamed from: a */
    private final BaseContactModel m15223a(BaseContactModel baseContactModel, Function0<? extends BaseContactModel> function0, InfoOrderRepoConfig infoOrderRepoConfig) {
        return infoOrderRepoConfig.getUpdateType() == 0 ? baseContactModel : (BaseContactModel) function0.invoke();
    }

    public final void updateDoubleContact(AddressEntity addressEntity, AddressEntity addressEntity2) {
        AddressEntity addressEntity3 = null;
        this.f20817a = addressEntity == null ? null : addressEntity.clone();
        if (addressEntity2 != null) {
            addressEntity3 = addressEntity2.clone();
        }
        this.f20818b = addressEntity3;
        setValue(new InfoOrderRepoConfig());
    }

    public final void clear() {
        this.f20818b = null;
        this.f20817a = null;
        this.f20819c = null;
        this.f20820d = null;
        RepoFactory.clearRepo(BillConfigRepo.class);
    }
}
