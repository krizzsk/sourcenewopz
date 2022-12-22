package com.didi.map.global.component.dropoff.data;

import com.didi.map.global.component.dropoff.data.IDropOffDataTask;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.sdk.poibase.CallFrom;

public class DropOffDataTaskParam {

    /* renamed from: a */
    private int f25509a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CallFrom f25510b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DropOffLocationInfo f25511c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f25512d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f25513e;

    /* renamed from: f */
    private IDropOffDataTask.TaskCallback f25514f;

    private DropOffDataTaskParam(int i, IDropOffDataTask.TaskCallback taskCallback) {
        this.f25509a = i;
        this.f25514f = taskCallback;
    }

    public int getId() {
        return this.f25509a;
    }

    public CallFrom getReqCallerId() {
        return this.f25510b;
    }

    public DropOffLocationInfo getLocationInfo() {
        return this.f25511c;
    }

    public String getMapType() {
        return this.f25512d;
    }

    public String getUserOperationType() {
        return this.f25513e;
    }

    public IDropOffDataTask.TaskCallback getTaskCallback() {
        return this.f25514f;
    }

    public static class Builder {
        private DropOffDataTaskParam dataTaskParam;

        public Builder(int i, IDropOffDataTask.TaskCallback taskCallback) {
            this.dataTaskParam = new DropOffDataTaskParam(i, taskCallback);
        }

        public Builder reqCallerId(CallFrom callFrom) {
            CallFrom unused = this.dataTaskParam.f25510b = callFrom;
            return this;
        }

        public Builder locationInfo(DropOffLocationInfo dropOffLocationInfo) {
            DropOffLocationInfo unused = this.dataTaskParam.f25511c = dropOffLocationInfo;
            return this;
        }

        public Builder mapType(String str) {
            String unused = this.dataTaskParam.f25512d = str;
            return this;
        }

        public Builder userOperationType(String str) {
            String unused = this.dataTaskParam.f25513e = str;
            return this;
        }

        public DropOffDataTaskParam build() {
            return this.dataTaskParam;
        }
    }
}
