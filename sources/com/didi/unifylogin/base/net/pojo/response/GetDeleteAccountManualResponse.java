package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class GetDeleteAccountManualResponse extends BaseResponse implements Serializable {
    @SerializedName("delete_account_prompt_texts")
    private List<DeleteContent> deleteAccountPromptTexts;
    @SerializedName("delete_account_warning")
    private String deleteAccountWarning;
    @SerializedName("sub_prompt_title")
    private String subPromptTitle;
    @SerializedName("sub_title")
    private String subTitle;

    public List<DeleteContent> getDeleteAccountPromptTexts() {
        return this.deleteAccountPromptTexts;
    }

    public GetDeleteAccountManualResponse setDeleteAccountPromptTexts(List<DeleteContent> list) {
        this.deleteAccountPromptTexts = list;
        return this;
    }

    public String getSubPromptTitle() {
        return this.subPromptTitle;
    }

    public GetDeleteAccountManualResponse setSubPromptTitle(String str) {
        this.subPromptTitle = str;
        return this;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public GetDeleteAccountManualResponse setSubTitle(String str) {
        this.subTitle = str;
        return this;
    }

    public String getDeleteAccountWarning() {
        return this.deleteAccountWarning;
    }

    public GetDeleteAccountManualResponse setDeleteAccountWarning(String str) {
        this.deleteAccountWarning = str;
        return this;
    }

    public static class DeleteContent implements Serializable {
        public static int TYPE_ERROR = 1;
        public static int TYPE_NORMAL;
        private String des;
        private String tag;
        private int type;

        public int getType() {
            return this.type;
        }

        public String getTag() {
            return this.tag;
        }

        public String getDesc() {
            return this.des;
        }

        public DeleteContent setType(int i) {
            this.type = i;
            return this;
        }

        public DeleteContent setTag(String str) {
            this.tag = str;
            return this;
        }

        public DeleteContent setDes(String str) {
            this.des = str;
            return this;
        }
    }
}
