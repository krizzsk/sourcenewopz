package com.didi.travel.psnger.model.response;

import com.didi.address.model.WayPoint;
import com.didi.address.util.SugWayPointsUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.namespace.IdentityNamespace;

public class NextCommonPushMsg extends BaseObject {
    private boolean appVibrate;
    private CarUnderServiceBannerTopInfo bannerTopInfo;
    private String buttonText;
    private String buttonUrl;
    private CommonInfo commonInfo;
    private String commonTipMessage;
    private String commonTitle;
    private FixedPriceExceedModel fixedPriceExceedModel;
    private DialogMessage flierUpgradeMessage;
    private String icon;
    private String oid;
    private String poi_pic_url;
    private String recommendMessage;
    private int recommendType;
    private RedirectActionModel redirectAction;
    private String subtitle;
    private String title;
    public List<WayPoint> wayPointList;
    public String wayPointsVersion;

    public String getCommonTitle() {
        return this.commonTitle;
    }

    public void setCommonTitle(String str) {
        this.commonTitle = str;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public String getButtonUrl() {
        return this.buttonUrl;
    }

    public void setButtonUrl(String str) {
        this.buttonUrl = str;
    }

    public NextCommonPushMsg(int i, String str) {
        this.recommendType = i;
        this.recommendMessage = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.oid = jSONObject.optString("oid");
            this.commonTipMessage = jSONObject.optString("msg");
            this.commonTitle = jSONObject.optString("title");
            this.buttonText = jSONObject.optString("button_text");
            this.buttonUrl = jSONObject.optString("button_url");
            RedirectActionModel redirectActionModel = new RedirectActionModel();
            this.redirectAction = redirectActionModel;
            redirectActionModel.parse(jSONObject);
            this.title = jSONObject.optString("airport_card_title");
            this.subtitle = jSONObject.optString("airport_card_subtitle");
            this.icon = jSONObject.optString("icon");
            this.poi_pic_url = jSONObject.optString("poi_pic_url");
            this.wayPointsVersion = jSONObject.optString(ParamKeys.PARAM_WAY_POINTS_VERSION);
            this.wayPointList = SugWayPointsUtils.getWayPointListFromJson(jSONObject.optString(ParamKeys.PARAM_WAY_POINTS));
            if (jSONObject.has("dialogue")) {
                DialogMessage dialogMessage = new DialogMessage();
                this.flierUpgradeMessage = dialogMessage;
                dialogMessage.parse(jSONObject.getJSONObject("dialogue"));
            }
            if (jSONObject.has("pushTips_top")) {
                CarUnderServiceBannerTopInfo carUnderServiceBannerTopInfo = new CarUnderServiceBannerTopInfo();
                this.bannerTopInfo = carUnderServiceBannerTopInfo;
                carUnderServiceBannerTopInfo.parse(jSONObject.optJSONObject("pushTips_top"));
            }
            boolean z = true;
            if (jSONObject.optInt("vibrate_tag") != 1) {
                z = false;
            }
            this.appVibrate = z;
            if (jSONObject.has("common_info")) {
                CommonInfo commonInfo2 = new CommonInfo();
                this.commonInfo = commonInfo2;
                commonInfo2.parse(jSONObject.optJSONObject("common_info"));
            }
            if (jSONObject.has("dialogue")) {
                FixedPriceExceedModel fixedPriceExceedModel2 = new FixedPriceExceedModel();
                this.fixedPriceExceedModel = fixedPriceExceedModel2;
                fixedPriceExceedModel2.parse(jSONObject.optJSONObject("dialogue"));
            }
        } catch (Exception unused) {
        }
    }

    public int getRecommendType() {
        return this.recommendType;
    }

    public String getRecommendMessage() {
        return this.recommendMessage;
    }

    public String getCommonTipMessage() {
        return this.commonTipMessage;
    }

    public void setRecommendType(int i) {
        this.recommendType = i;
    }

    public void setRecommendMessage(String str) {
        this.recommendMessage = str;
    }

    public void setCommonTipMessage(String str) {
        this.commonTipMessage = str;
    }

    public String getOid() {
        return this.oid;
    }

    public void setOid(String str) {
        this.oid = str;
    }

    public RedirectActionModel getRedirectAction() {
        return this.redirectAction;
    }

    public void setRedirectAction(RedirectActionModel redirectActionModel) {
        this.redirectAction = redirectActionModel;
    }

    public String getTitle() {
        return this.title;
    }

    public CommonInfo getCommonInfo() {
        return this.commonInfo;
    }

    public void setCommonInfo(CommonInfo commonInfo2) {
        this.commonInfo = commonInfo2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getPoi_pic_url() {
        return this.poi_pic_url;
    }

    public void setPoi_pic_url(String str) {
        this.poi_pic_url = str;
    }

    public DialogMessage getDialogMessage() {
        return this.flierUpgradeMessage;
    }

    public CarUnderServiceBannerTopInfo getBannerTopInfo() {
        return this.bannerTopInfo;
    }

    public boolean isAppVibrate() {
        return this.appVibrate;
    }

    public FixedPriceExceedModel getFixedPriceExceedModel() {
        return this.fixedPriceExceedModel;
    }

    public void setFixedPriceExceedModel(FixedPriceExceedModel fixedPriceExceedModel2) {
        this.fixedPriceExceedModel = fixedPriceExceedModel2;
    }

    public static class DialogMessage extends BaseObject {
        public String background;
        public String background_new;
        public String button;
        public List<String> documentation;
        public String subTitle;
        public String title;
        public int type;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            JSONArray optJSONArray;
            super.parse(jSONObject);
            this.type = jSONObject.optInt("type");
            this.title = jSONObject.optString("title");
            this.subTitle = jSONObject.optString("subtitle");
            this.background = jSONObject.optString(Constants.BACKGROUND);
            this.background_new = jSONObject.optString("background_new");
            if (jSONObject.has(IdentityNamespace.CAPABILITY_DOCUMENTATION_ATTRIBUTE) && (optJSONArray = jSONObject.optJSONArray(IdentityNamespace.CAPABILITY_DOCUMENTATION_ATTRIBUTE)) != null) {
                int length = optJSONArray.length();
                this.documentation = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    this.documentation.add(optJSONArray.optString(i));
                }
            }
            this.button = jSONObject.optString(CarServerParam.PARAM_BUTTON);
        }

        public String toString() {
            return "DialogMessage{type=" + this.type + ", title='" + this.title + '\'' + ", subTitle='" + this.subTitle + '\'' + ", background='" + this.background + '\'' + ", documentation=" + this.documentation + ", button='" + this.button + '\'' + '}';
        }
    }

    public static class CommonInfo extends BaseObject {
        public int businessId;

        /* renamed from: id */
        public int f44222id;
        public String info;
        public String type;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.f44222id = jSONObject.optInt("id");
            this.type = jSONObject.optString("type");
            this.businessId = jSONObject.optInt("business_id");
            this.info = jSONObject.optString("info");
        }
    }

    public static class FixedPriceExceedModel extends BaseObject {
        public String button;
        public String content;
        public String title;
        public int type;

        private FixedPriceExceedModel() {
        }

        public void parse(JSONObject jSONObject) {
            this.title = jSONObject.optString("title");
            this.type = jSONObject.optInt("type");
            this.content = jSONObject.optString("subtitle");
            this.button = jSONObject.optString(CarServerParam.PARAM_BUTTON);
        }
    }
}
