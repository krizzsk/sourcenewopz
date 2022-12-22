package com.didiglobal.privacysdk.law.update.response;

import com.didiglobal.privacysdk.law.update.model.BaseObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LegalNotice extends BaseObject {
    @SerializedName("data")
    public LegalNoticeData legalNoticeData;

    public static class LegalNoticeData implements Serializable {
        public String content;
        @SerializedName("law_id")
        public String lawId;
        @SerializedName("law_version")
        public String lawVersion;
        @SerializedName("link_text")
        public String linkText;
        @SerializedName("link_url")
        public String linkUrl;
        @SerializedName("pop_law")
        public String popLaw;
        public String title;
    }
}
