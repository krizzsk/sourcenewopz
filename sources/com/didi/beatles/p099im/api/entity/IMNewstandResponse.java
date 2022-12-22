package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMNewstandResponse */
public class IMNewstandResponse implements Serializable {
    public NewStandInfo Info;
    public String errmsg;
    public int errno;

    /* renamed from: com.didi.beatles.im.api.entity.IMNewstandResponse$ActivityInfo */
    public static class ActivityInfo implements Serializable {
        public int activity_id;
        public String activity_img = "";
        public String activity_summary = "";
        public String activity_url = "";
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMNewstandResponse$NewStandActivity */
    public static class NewStandActivity implements Serializable {
        public ActivityInfo[] info = new ActivityInfo[1];
        public String title;
        public String title_url;
        public int type;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMNewstandResponse$NewStandHistory */
    public static class NewStandHistory implements Serializable {
        public NewStandMessage[] message = new NewStandMessage[1];
        public String title;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMNewstandResponse$NewStandMessage */
    public static class NewStandMessage implements Serializable {
        public String action = "";
        public String content = "";
        public String image = "";
        public int template;
        public long timestamp;
        public String title = "";
        public int type;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMNewstandResponse$NewStandInfo */
    public static class NewStandInfo implements Serializable {
        public NewStandActivity activity;
        public NewStandHistory history;
        public NewStandUserInfo user;

        public String toString() {
            return "NewStandInfo{user=" + this.user.toString() + ", activity=" + this.activity + ", history=" + this.history + '}';
        }
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMNewstandResponse$NewStandUserInfo */
    public static class NewStandUserInfo implements Serializable {
        public int user_follow;
        public int user_icon;
        public String user_img;
        public String user_info;
        public String user_name;
        public String user_summary;

        public String toString() {
            return "NewStandUserInfo{user_name='" + this.user_name + '\'' + ", user_icon=" + this.user_icon + ", user_img='" + this.user_img + '\'' + ", user_summary='" + this.user_summary + '\'' + ", user_info='" + this.user_info + '\'' + ", user_follow=" + this.user_follow + '}';
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IMNewstandResponse{errno=");
        sb.append(this.errno);
        sb.append(", errmsg='");
        sb.append(this.errmsg);
        sb.append('\'');
        sb.append(", Info=");
        NewStandInfo newStandInfo = this.Info;
        sb.append(newStandInfo != null ? newStandInfo.toString() : "");
        sb.append('}');
        return sb.toString();
    }
}
