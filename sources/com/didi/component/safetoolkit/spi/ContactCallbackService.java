package com.didi.component.safetoolkit.spi;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.sharetrip.ShareTripDialogCache;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.safetoolkit.api.ISfContactCallbackService;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {ISfContactCallbackService.class})
public class ContactCallbackService implements ISfContactCallbackService {
    public void onNewAreaCodeContactAdded() {
    }

    public void onNewTrustedContactAdded(boolean z) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_NEW_TRUSTED_CONTACT_ADDED_FROM_NEW_SHARE);
        if (z) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_DISMISS_BUBBLE);
        }
    }

    public void onContactsShared() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_DISMISS_BUBBLE);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS);
    }

    public void onTrustedContactChanged(SfContactsManageModel sfContactsManageModel) {
        if (sfContactsManageModel != null && sfContactsManageModel.datas != null && sfContactsManageModel.datas.contacts != null) {
            ShareTripDialogCache.getInstance().setContacts(sfContactsManageModel.datas.contacts);
        }
    }
}
