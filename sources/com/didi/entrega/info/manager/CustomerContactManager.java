package com.didi.entrega.info.manager;

import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.repo.HistoryListRepo;
import com.didi.entrega.info.repo.InfoComponentRepo;
import com.didi.entrega.info.repo.InfoOrderRepoConfig;
import com.didi.entrega.info.repo.InfoRepo;
import com.didi.entrega.manager.base.ICustomerContactManager;

public class CustomerContactManager implements ICustomerContactManager {

    /* renamed from: a */
    private final String f20792a = "ContactManager";

    public String getManagerName() {
        return "ContactManager";
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final InfoRepo getRepo() {
        return (InfoRepo) RepoFactory.getRepo(InfoRepo.class);
    }

    public void updateSendContact(AddressEntity addressEntity) {
        InfoOrderRepoConfig infoOrderRepoConfig = new InfoOrderRepoConfig();
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).updateSendContact(addressEntity, infoOrderRepoConfig);
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).setValue(infoOrderRepoConfig);
    }

    public void updateReceiveContact(AddressEntity addressEntity) {
        InfoOrderRepoConfig infoOrderRepoConfig = new InfoOrderRepoConfig();
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).updateReceiveContact(addressEntity, infoOrderRepoConfig);
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).setValue(infoOrderRepoConfig);
    }

    public void updateDoubleContact(AddressEntity addressEntity, AddressEntity addressEntity2) {
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).updateDoubleContact(addressEntity, addressEntity2);
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).setValue(new InfoOrderRepoConfig());
    }

    public void updateStuf(ContactStufEntity contactStufEntity) {
        InfoOrderRepoConfig infoOrderRepoConfig = new InfoOrderRepoConfig();
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).updateStuf(contactStufEntity, infoOrderRepoConfig);
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).setValue(infoOrderRepoConfig);
    }

    public void updateCartId(String str) {
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).updateCartId(str);
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).setValue(new InfoOrderRepoConfig());
    }

    public void clear() {
        ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).clear();
        ((InfoComponentRepo) RepoFactory.getRepo(InfoComponentRepo.class)).clear();
        ((HistoryListRepo) RepoFactory.getRepo(HistoryListRepo.class)).clear();
    }

    public AddressEntity getSendContact() {
        return ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).getSendContact();
    }

    public AddressEntity getReceiveContact() {
        return ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).getReceiveContact();
    }

    public ContactStufEntity getContStuf() {
        return ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).getContStuf();
    }

    public String getCartId() {
        return ((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).getCartId();
    }
}
