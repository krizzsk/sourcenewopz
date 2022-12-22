package com.didi.component.business.data.form;

import android.content.Context;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.p205sa.biz.formstore.IClearFormSore;
import com.taxis99.R;

@ServiceProvider({IClearFormSore.class})
public class ClearFormStore implements IClearFormSore {
    public void clearFromStore() {
        FormStore.getInstance().clear();
        FormStore.getInstance().setDepartureAddress((Address) null);
        FormStore.getInstance().setTransportTime(0);
        FormStore.getInstance().setSeatCount(1);
        if (TripRecordingManager.Companion.getInstance().isRecording()) {
            TripRecordingManager.Companion.getInstance().stopAndUpload();
            ToastHelper.showShortCompleted((Context) DIDIApplication.getAppContext(), (int) R.string.global_record_stop_toast);
        }
        SafeToolKit.getIns().setProductId(ConfProxy.getInstance().getSelectedGroupId());
        SafeToolKit.getIns().setBusinessType("ride");
    }
}
