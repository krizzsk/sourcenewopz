package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class DTSDKShareCouponModel extends BaseObject {
    public DTSDKApiShareInfo apiShareInfo;
    public int displayCoupon;
    public List<ScarShareCommonModel> mShareModelList;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("api_share_info");
            if (optJSONObject != null) {
                DTSDKApiShareInfo dTSDKApiShareInfo = new DTSDKApiShareInfo();
                this.apiShareInfo = dTSDKApiShareInfo;
                dTSDKApiShareInfo.parse(optJSONObject);
            }
            this.displayCoupon = jSONObject.optInt("display_coupon_logo");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("share_info");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("channels");
                ScarShareChannel scarShareChannel = null;
                if (optJSONObject3 != null) {
                    scarShareChannel = new ScarShareChannel();
                    scarShareChannel.parse(optJSONObject3.toString());
                }
                this.mShareModelList = new ArrayList();
                if (scarShareChannel != null) {
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("weixin_friend");
                    if (optJSONObject4 != null && scarShareChannel.openWXFriend) {
                        ScarShareCommonModel scarShareCommonModel = new ScarShareCommonModel();
                        scarShareCommonModel.shareChannel = "2";
                        scarShareCommonModel.parse(optJSONObject4);
                        this.mShareModelList.add(scarShareCommonModel);
                    }
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("weixin_moments");
                    if (optJSONObject5 != null && scarShareChannel.openWXCircle) {
                        ScarShareCommonModel scarShareCommonModel2 = new ScarShareCommonModel();
                        scarShareCommonModel2.shareChannel = "1";
                        scarShareCommonModel2.parse(optJSONObject5);
                        this.mShareModelList.add(scarShareCommonModel2);
                    }
                    JSONObject optJSONObject6 = optJSONObject2.optJSONObject("weibo");
                    if (optJSONObject6 != null && scarShareChannel.openSinaWeibo) {
                        ScarShareCommonModel scarShareCommonModel3 = new ScarShareCommonModel();
                        scarShareCommonModel3.shareChannel = "3";
                        scarShareCommonModel3.parse(optJSONObject6);
                        this.mShareModelList.add(scarShareCommonModel3);
                    }
                    JSONObject optJSONObject7 = optJSONObject2.optJSONObject("alipay_friend");
                    if (optJSONObject7 != null && scarShareChannel.openAlipayFriend) {
                        ScarShareCommonModel scarShareCommonModel4 = new ScarShareCommonModel();
                        scarShareCommonModel4.shareChannel = "11";
                        scarShareCommonModel4.parse(optJSONObject7);
                        this.mShareModelList.add(scarShareCommonModel4);
                    }
                    JSONObject optJSONObject8 = optJSONObject2.optJSONObject("alipay_life_circle");
                    if (optJSONObject8 != null && scarShareChannel.openAlipayCircle) {
                        ScarShareCommonModel scarShareCommonModel5 = new ScarShareCommonModel();
                        scarShareCommonModel5.shareChannel = "12";
                        scarShareCommonModel5.parse(optJSONObject8);
                        this.mShareModelList.add(scarShareCommonModel5);
                    }
                    JSONObject optJSONObject9 = optJSONObject2.optJSONObject("facebook");
                    if (optJSONObject9 != null && scarShareChannel.openFacebook) {
                        ScarShareCommonModel scarShareCommonModel6 = new ScarShareCommonModel();
                        scarShareCommonModel6.shareChannel = ScarShareReportModel.CHANNEL_FACEBOOK;
                        scarShareCommonModel6.parse(optJSONObject9);
                        this.mShareModelList.add(scarShareCommonModel6);
                    }
                    JSONObject optJSONObject10 = optJSONObject2.optJSONObject(ScarShareChannel.WHATS_APP);
                    if (optJSONObject10 != null && scarShareChannel.openWhatsapp) {
                        ScarShareCommonModel scarShareCommonModel7 = new ScarShareCommonModel();
                        scarShareCommonModel7.shareChannel = ScarShareReportModel.CHANNEL_WHATSAPP;
                        scarShareCommonModel7.parse(optJSONObject10);
                        this.mShareModelList.add(scarShareCommonModel7);
                    }
                    JSONObject optJSONObject11 = optJSONObject2.optJSONObject(ScarShareChannel.TWITTER);
                    if (optJSONObject11 != null && scarShareChannel.openTwitter) {
                        ScarShareCommonModel scarShareCommonModel8 = new ScarShareCommonModel();
                        scarShareCommonModel8.shareChannel = ScarShareReportModel.CHANNEL_TWITTER;
                        scarShareCommonModel8.parse(optJSONObject11);
                        this.mShareModelList.add(scarShareCommonModel8);
                    }
                    JSONObject optJSONObject12 = optJSONObject2.optJSONObject(ScarShareChannel.MESSENGER);
                    if (optJSONObject12 != null && scarShareChannel.openMessenger) {
                        ScarShareCommonModel scarShareCommonModel9 = new ScarShareCommonModel();
                        scarShareCommonModel9.shareChannel = ScarShareReportModel.CHANNEL_MESSENGER;
                        scarShareCommonModel9.parse(optJSONObject12);
                        this.mShareModelList.add(scarShareCommonModel9);
                    }
                    JSONObject optJSONObject13 = optJSONObject2.optJSONObject("email");
                    if (optJSONObject13 != null && scarShareChannel.openEmail) {
                        ScarShareCommonModel scarShareCommonModel10 = new ScarShareCommonModel();
                        scarShareCommonModel10.shareChannel = ScarShareReportModel.CHANNEL_EMAIL;
                        scarShareCommonModel10.parse(optJSONObject13);
                        this.mShareModelList.add(scarShareCommonModel10);
                    }
                    JSONObject optJSONObject14 = optJSONObject2.optJSONObject(ScarShareChannel.LINE);
                    if (optJSONObject14 != null && scarShareChannel.openLine) {
                        ScarShareCommonModel scarShareCommonModel11 = new ScarShareCommonModel();
                        scarShareCommonModel11.shareChannel = ScarShareReportModel.CHANNEL_LINE;
                        scarShareCommonModel11.parse(optJSONObject14);
                        this.mShareModelList.add(scarShareCommonModel11);
                    }
                }
            }
        }
    }

    public static class DTSDKApiShareInfo extends BaseObject {
        public String layerImageUrl;
        public int pattern;
        public int popLayerTime;
        public String shareBtnLater;
        public String shareBtnSend;
        public String shareText;
        public String shareTitle;
        public String shareUrl;
        public String toastPicBg;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.shareTitle = jSONObject.optString("share_title");
            this.shareText = jSONObject.optString("share_text");
            this.shareUrl = jSONObject.optString("share_url");
            this.shareBtnSend = jSONObject.optString("share_button_send");
            this.shareBtnLater = jSONObject.optString("share_button_later");
            this.popLayerTime = jSONObject.optInt("pop_layer_time");
            this.layerImageUrl = jSONObject.optString("layer_image_url");
            this.toastPicBg = jSONObject.optString("toastpic_bg");
            this.pattern = jSONObject.optInt("pattern");
        }
    }
}
