package com.didichuxing.omega.sdk.feedback.judgment;

import com.didi.component.comp_xpanel.XPanelScene;
import org.json.JSONException;
import org.json.JSONObject;

public class JudgeBean {
    public String confirm;
    public int errorNo;
    public String ignore;
    public String msg;
    public int tipId;
    public String tips;
    public String title;
    public String url;

    public static JudgeBean parse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("err_no");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            String optString = jSONObject2.optString("title");
            String optString2 = jSONObject2.optString("msg");
            String optString3 = jSONObject2.optString(XPanelScene.SCENE_CONFIRM);
            String optString4 = jSONObject2.optString("ignore");
            String optString5 = jSONObject2.optString("url");
            String optString6 = jSONObject2.optString("tips");
            return new Builder().errNo(optInt).title(optString).confirm(optString3).ignore(optString4).msg(optString2).url(optString5).tips(optString6).tipId(jSONObject2.optInt("id")).build();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JudgeBean();
        }
    }

    public static class Builder {
        private JudgeBean bean = new JudgeBean();

        public Builder errNo(int i) {
            this.bean.errorNo = i;
            return this;
        }

        public Builder title(String str) {
            this.bean.title = str;
            return this;
        }

        public Builder confirm(String str) {
            this.bean.confirm = str;
            return this;
        }

        public Builder ignore(String str) {
            this.bean.ignore = str;
            return this;
        }

        public Builder tips(String str) {
            this.bean.tips = str;
            return this;
        }

        public Builder url(String str) {
            this.bean.url = str;
            return this;
        }

        public Builder msg(String str) {
            this.bean.msg = str;
            return this;
        }

        public Builder tipId(int i) {
            this.bean.tipId = i;
            return this;
        }

        public JudgeBean build() {
            return this.bean;
        }
    }

    public String toString() {
        return "err no = " + this.errorNo + " title = " + this.title + " confirm = " + this.confirm + " ignore = " + this.ignore + "tips = " + this.tips + " msg = " + this.msg + " url = " + this.url + " tip id = " + this.tipId;
    }
}
