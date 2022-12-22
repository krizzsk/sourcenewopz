package com.rider.rlab_im_map_plugin.channel;

import com.didi.rlab.uni_im_map.map.IMMapErrorTrackerModel;
import com.didi.rlab.uni_im_map.map.IMMapEventTrackerModel;
import com.didi.rlab.uni_im_map.map.IMMapOmegaService;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.engine.OmegaParamsCallback;
import java.util.HashMap;
import java.util.Map;

public class IMMapOmegaServiceImpl implements IMMapOmegaService {
    public void traceEvent(IMMapEventTrackerModel iMMapEventTrackerModel) {
        if (iMMapEventTrackerModel != null && iMMapEventTrackerModel.getEventId() != null) {
            Event newEvent = OmegaSDK.newEvent(iMMapEventTrackerModel.getEventId());
            Map<String, Object> attrs = iMMapEventTrackerModel.getAttrs();
            if (attrs != null) {
                attrs.putAll(m40251a());
                newEvent.putAllAttrs(attrs);
            } else {
                newEvent.putAllAttrs(m40251a());
            }
            OmegaSDKAdapter.trackEvent(newEvent);
        }
    }

    public void trackError(IMMapErrorTrackerModel iMMapErrorTrackerModel) {
        if (iMMapErrorTrackerModel != null) {
            ErrorTracker create = ErrorTracker.create(iMMapErrorTrackerModel.getErrorName());
            String moduleName = iMMapErrorTrackerModel.getModuleName();
            if (moduleName != null) {
                create.setModuleName(moduleName);
            }
            String errorCode = iMMapErrorTrackerModel.getErrorCode();
            if (errorCode != null) {
                create.setErrorType(errorCode);
            }
            String errorMsg = iMMapErrorTrackerModel.getErrorMsg();
            if (errorMsg != null) {
                create.setErrorMessage(errorMsg);
            }
            if (iMMapErrorTrackerModel.getParameters() != null) {
                Map<String, Object> parameters = iMMapErrorTrackerModel.getParameters();
                parameters.putAll(m40251a());
                create.setExtraParams(parameters);
            }
            create.trackError();
        }
    }

    /* renamed from: a */
    private HashMap<String, Object> m40251a() {
        OmegaParamsCallback omegaParamsCallback = ImMapConfig.getInstance().getOmegaParamsCallback();
        if (omegaParamsCallback == null || omegaParamsCallback.getOmegaParams() == null) {
            return new HashMap<>();
        }
        return omegaParamsCallback.getOmegaParams();
    }
}
