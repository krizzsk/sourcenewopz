package com.didichuxing.diface.biz.bioassay.alpha.p180M.upload_capture;

import com.didichuxing.diface.data.BaseResult;
import java.io.Serializable;

/* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.upload_capture.UploadCaptureResult */
public class UploadCaptureResult extends BaseResult {
    public Data data;

    /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.upload_capture.UploadCaptureResult$Data */
    public static class Data implements Serializable {
        public int code;
        public String message;
    }
}
