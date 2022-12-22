package com.didi.safetoolkit.business.share.store;

import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.net.SfResponseListener;
import java.util.List;

public interface ISfContactsStore {
    void clearData();

    void getMatchList(String str, SfCallback sfCallback);

    void getSOSContacts(SfCallback sfCallback);

    void getSystemContacts(SfCallback sfCallback);

    void share(List<SfContactsModel> list, String str, SfResponseListener sfResponseListener);

    void shareRetry();

    void shareToSOSContacts();
}
