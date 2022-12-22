package com.didi.safetoolkit.business.contacts.request;

import com.didi.safetoolkit.net.ISfNetService;
import com.didi.safetoolkit.net.ISfRpcRequest;
import com.didi.safetoolkit.net.SfRpcParam;
import com.didi.safetoolkit.net.SfUrls;

public class SfSyncContactRequest implements ISfRpcRequest<ISfNetService> {
    public static final int ADD_CONTACTS = 0;
    public static final int DELETE_CONTACT = 2;
    public static final int PULL_CONTACTS = 1;
    public static final int UPDATE_CONTACTS = 3;
    @SfRpcParam("params")
    public String nameAndPhones;
    @SfRpcParam("type")
    public int type;

    public String getPathParameter() {
        return null;
    }

    public String getServiceName() {
        return "syncContact";
    }

    public String getBaseUrl() {
        return SfUrls.getBaseUrl();
    }
}
