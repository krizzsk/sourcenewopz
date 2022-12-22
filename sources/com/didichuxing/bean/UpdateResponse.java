package com.didichuxing.bean;

public class UpdateResponse {
    public String errMsg;
    public int errNum;
    public String ignoreBtn;
    public boolean isForce;
    public boolean needUpdate;
    public int taskId;
    public String updateBtn;
    public String updateDesc;
    public String updateTitle;
    public int updateType;
    public String updateUrl;
    public String version;
    public int versionCode;
    public int versionId;

    public UpdateResponse() {
    }

    public UpdateResponse(int i, String str) {
        this.errNum = i;
        this.errMsg = str;
    }

    public static class Builder {
        private UpdateResponse response = new UpdateResponse();

        public Builder errNum(int i) {
            this.response.errNum = i;
            return this;
        }

        public Builder errMsg(String str) {
            this.response.errMsg = str;
            return this;
        }

        public Builder version(String str) {
            this.response.version = str;
            return this;
        }

        public Builder versionCode(int i) {
            this.response.versionCode = i;
            return this;
        }

        public Builder versionId(int i) {
            this.response.versionId = i;
            return this;
        }

        public Builder taskId(int i) {
            this.response.taskId = i;
            return this;
        }

        public Builder updateType(int i) {
            this.response.updateType = i;
            return this;
        }

        public Builder isForce(boolean z) {
            this.response.isForce = z;
            return this;
        }

        public Builder needUpdate(boolean z) {
            this.response.needUpdate = z;
            return this;
        }

        public Builder updateTitle(String str) {
            this.response.updateTitle = str;
            return this;
        }

        public Builder updateDesc(String str) {
            this.response.updateDesc = str;
            return this;
        }

        public Builder updateBtn(String str) {
            this.response.updateBtn = str;
            return this;
        }

        public Builder ignoreBtn(String str) {
            this.response.ignoreBtn = str;
            return this;
        }

        public Builder updateUrl(String str) {
            this.response.updateUrl = str;
            return this;
        }

        public UpdateResponse builder() {
            return this.response;
        }
    }

    public String toString() {
        return "UpdateResponse { \n  errNo " + this.errNum + " \n  errMsg " + this.errMsg + " \n  version " + this.version + " \n  versionCode " + this.versionCode + " \n  versionId " + this.versionId + " \n  taskId " + this.taskId + " \n  updateType " + this.updateType + " \n  isForce " + this.isForce + " \n  needUpdate " + this.needUpdate + " \n  updateTitle " + this.updateTitle + " \n  updateDesc " + this.updateDesc + " \n  updateBtn " + this.updateBtn + " \n  ignoreBtn " + this.ignoreBtn + " \n  updateUrl " + this.updateUrl + " \n " + '}';
    }
}
