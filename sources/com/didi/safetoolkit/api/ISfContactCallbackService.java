package com.didi.safetoolkit.api;

import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;

public interface ISfContactCallbackService {
    void onContactsShared();

    void onNewAreaCodeContactAdded();

    void onNewTrustedContactAdded(boolean z);

    void onTrustedContactChanged(SfContactsManageModel sfContactsManageModel);
}
