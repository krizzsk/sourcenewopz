package com.didi.component.service.cancelreason.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import java.io.Serializable;

public class CancelReasonListResponse extends BaseObject {
    public CancelReasonListModel data;

    public static class CancelReasonListModel implements Serializable {
        public CancelReasonInfo cancel_reason_info;
    }
}
