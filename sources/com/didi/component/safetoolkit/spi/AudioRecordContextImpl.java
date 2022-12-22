package com.didi.component.safetoolkit.spi;

import android.content.Context;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.net.UploadService;
import com.didi.travel.psnger.common.net.host.HostGroupManager;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "trip_audio_record_alias_passenger", value = {AudioRecordContext.class})
public class AudioRecordContextImpl implements AudioRecordContext {

    /* renamed from: a */
    private static final String f15418a = (HostGroupManager.getInstance().getDiDiBizHost() + "gulfstream/csi/v1/service/voice/pSubmitVoiceEvidence");

    public boolean debugable() {
        return false;
    }

    public String getAudioCacheDir() {
        return null;
    }

    public String getCaller() {
        return "record_in_trip";
    }

    public int getClientType() {
        return 2;
    }

    public String getExtraJson() {
        return null;
    }

    public String getLanguage() {
        return null;
    }

    public AudioRecordContext.Logger getLogger() {
        return null;
    }

    public int getMaxUploadRetryCount() {
        return 3;
    }

    public String getSensitiveWordsUploadUrl() {
        return "";
    }

    public UploadService getUploadService() {
        return null;
    }

    public int getUtcOffsetInMinutes() {
        return 0;
    }

    public boolean isBluetoothRecordEnable() {
        return false;
    }

    public boolean speechDetectEnable() {
        return false;
    }

    public Context getAppContext() {
        return DIDIApplication.getAppContext();
    }

    public int getAudioSegmentDuration() {
        return GlobalApolloUtil.getTripRecordSegment() * 1000;
    }

    public long getAudioExpiredDuration() {
        return (long) (GlobalApolloUtil.getTripRecordExpired() * 1000);
    }

    public String getUploadUrl() {
        return f15418a;
    }

    public String getOrderIds() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            return order.getOid();
        }
        return null;
    }

    public String getUserToken() {
        return NationComponentDataUtil.getToken();
    }

    public String getUserId() {
        return NationComponentDataUtil.getUid() + "";
    }

    public String getUserPhone() {
        return NationComponentDataUtil.getPhone();
    }

    public String getBusinessId() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return null;
        }
        return order.getProductId() + "";
    }

    public AudioRecordContext.ConvertSwitchConfig getConvertImplSwitch() {
        IToggle toggle = Apollo.getToggle("gd_trip_recorder_switch");
        if (!toggle.allow()) {
            return null;
        }
        IExperiment experiment = toggle.getExperiment();
        AudioRecordContext.ConvertSwitchConfig convertSwitchConfig = new AudioRecordContext.ConvertSwitchConfig();
        convertSwitchConfig.pcmSwitch = ((Integer) experiment.getParam("pcm", 0)).intValue();
        convertSwitchConfig.amrSwitch = ((Integer) experiment.getParam("amr", 0)).intValue();
        convertSwitchConfig.amrBitRate = ((Integer) experiment.getParam("amr_rate", 0)).intValue();
        return convertSwitchConfig;
    }
}
