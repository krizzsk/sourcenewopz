package com.didi.entrega.manager.base;

import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.info.repo.InfoRepo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/manager/base/ICustomerContactManager;", "Lcom/didi/entrega/manager/base/ICustomerManager;", "clear", "", "getCartId", "", "getContStuf", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "getReceiveContact", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getRepo", "Lcom/didi/entrega/info/repo/InfoRepo;", "getSendContact", "updateCartId", "cartId", "updateDoubleContact", "sendContac", "receive", "updateReceiveContact", "contact", "updateSendContact", "updateStuf", "contactContact", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ICustomerContactManager.kt */
public interface ICustomerContactManager extends ICustomerManager {
    void clear();

    String getCartId();

    ContactStufEntity getContStuf();

    AddressEntity getReceiveContact();

    InfoRepo getRepo();

    AddressEntity getSendContact();

    void updateCartId(String str);

    void updateDoubleContact(AddressEntity addressEntity, AddressEntity addressEntity2);

    void updateReceiveContact(AddressEntity addressEntity);

    void updateSendContact(AddressEntity addressEntity);

    void updateStuf(ContactStufEntity contactStufEntity);
}
