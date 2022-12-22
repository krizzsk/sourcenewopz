package com.didi.beatles.p099im.plugin.robot.net.response;

import android.text.TextUtils;
import com.didi.beatles.p099im.api.entity.IMBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotGetConfigureResponse */
public class IMRobotGetConfigureResponse extends IMBaseResponse {
    @SerializedName("body")
    public Body body;

    /* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotGetConfigureResponse$PraiseBtnConfig */
    public static class PraiseBtnConfig implements Serializable {
        @SerializedName("btn_text")
        public String btnText;
        @SerializedName("type")
        public int type;
    }

    /* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotGetConfigureResponse$Body */
    public static class Body implements Serializable {
        @SerializedName("default_robot_id")
        public String defaultRobotId;
        @SerializedName("is_anon")
        public int isAnon;
        @SerializedName("btn_config")
        public List<PraiseBtnConfig> praiseBtnConfigList;
        @SerializedName("robot_list")
        public List<Robot> robotList;
        @SerializedName("share_btn")
        public String shareBtnText;

        public boolean isAnon() {
            return this.isAnon == 1;
        }
    }

    /* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotGetConfigureResponse$Robot */
    public static class Robot implements Serializable {
        public static final int THEME_DEFAULT = 0;
        public static final int THEME_SPRING_FESTIVAL = 1;
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_STAR = 1;
        public transient boolean canLoadPraiseList = true;
        @SerializedName("card_img")
        public String cardImg;
        @SerializedName("eid")
        public int eid;
        public transient int guidePraiseIndex = -1;
        @SerializedName("guide_praise")
        public List<IMRobotPraise> guidePraiseList;
        @SerializedName("icon")
        public String icon;
        @SerializedName("is_lock")
        public int isLock;
        public transient int loadPraiseRetryCount = 0;
        @SerializedName("name")
        public String name;
        @SerializedName("nav_img")
        public String navStarImg;
        public transient int praiseIndex = -1;
        @SerializedName("praise_list")
        public List<IMRobotPraise> praiseList;
        @SerializedName("robot_id")
        public String robotId;
        @SerializedName("share_url")
        public String shareUrl;
        @SerializedName("star_img_v2")
        public String starImgBig;
        @SerializedName("star_img")
        public String startImg;
        @SerializedName("theme")
        public int theme;
        @SerializedName("title")
        public String title;
        @SerializedName("type")
        public int type;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotGetConfigureResponse$Robot$Theme */
        public @interface Theme {
        }

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotGetConfigureResponse$Robot$Type */
        public @interface Type {
        }

        public boolean isLock() {
            return this.isLock == 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return TextUtils.equals(this.robotId, ((Robot) obj).robotId);
        }

        public int hashCode() {
            String str = this.robotId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }
    }
}
