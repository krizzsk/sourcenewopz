package com.didi.travel.psnger.model;

import com.didi.component.framework.pages.carcheck.CarCheckActivity;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class UnevaluatedViewModel extends BaseObject {
    public int[] answerState;
    public String[] answers;
    public CharSequence content;
    public String driverIconUrl;
    public boolean isVertical = false;
    public String oid;
    public OrderDriverInfo orderDriverInfo;
    public CharSequence questionBody;
    public String questionCaller;
    public String questionContent;
    public int questionID;
    public List<QuestionDataOption> questionOptions;
    public CharSequence questionTitle;
    public int showOrder;
    public int style;
    public CharSequence subTitle;
    public CharSequence title;
    public UnMatchInfo unMatchInfo;
    public CharSequence userReply;
    public int xpanelPos;

    public static class OrderDriverInfo {
        public String driverAvatar;
        public String driverName;
        public String orderTime;
        public String toAddress;
    }

    public static class UnMatchGuideMsg extends BaseObject {
        public String buttonMsg;
        public String showMsg;
        public CommonPopUp unMatchPopUp;
        public String unMatchedMsg;
    }

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            this.showOrder = jSONObject.optInt("show_order");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("question");
            if (optJSONObject2 != null) {
                if (optJSONObject2.has("v2") && optJSONObject2.optJSONObject("v2") != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("v2");
                    this.questionCaller = optJSONObject3.optString("caller");
                    this.userReply = optJSONObject3.optString(CarCheckActivity.USER_REPLY);
                    this.questionID = optJSONObject3.optInt("question_id");
                    this.questionBody = optJSONObject3.optString(CarCheckActivity.QUESTION_BODY);
                    this.questionTitle = optJSONObject3.optString("title");
                    this.questionContent = optJSONObject3.optString("description");
                    this.style = optJSONObject3.optInt("style");
                    this.xpanelPos = optJSONObject3.optInt("xpanel_pos");
                    JSONArray optJSONArray3 = optJSONObject3.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    if (optJSONArray3 != null) {
                        this.questionOptions = new JsonUtil().parseJSONArray(optJSONArray3, new QuestionDataOption());
                    }
                } else if (optJSONObject2.has("v1") && (optJSONObject = optJSONObject2.optJSONObject("v1")) != null) {
                    this.userReply = optJSONObject.optString(CarCheckActivity.USER_REPLY);
                    this.questionID = optJSONObject.optInt("question_id");
                    this.questionTitle = optJSONObject.optString("title");
                    this.questionBody = optJSONObject.optString(CarCheckActivity.QUESTION_BODY);
                    this.questionContent = optJSONObject.optString("description");
                    this.style = optJSONObject.optInt("style");
                    this.xpanelPos = optJSONObject.optInt("xpanel_pos");
                    if (optJSONObject.has(CarCheckActivity.ANSWERS) && (optJSONArray2 = optJSONObject.optJSONArray(CarCheckActivity.ANSWERS)) != null) {
                        int length = optJSONArray2.length();
                        this.answers = new String[length];
                        for (int i = 0; i < length; i++) {
                            this.answers[i] = optJSONArray2.optString(i);
                        }
                    }
                    if (optJSONObject.has("answer_state") && (optJSONArray = optJSONObject.optJSONArray("answer_state")) != null) {
                        int length2 = optJSONArray.length();
                        this.answerState = new int[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            this.answerState[i2] = optJSONArray.optInt(i2);
                        }
                    }
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("driver_info");
            if (optJSONObject4 != null) {
                OrderDriverInfo orderDriverInfo2 = new OrderDriverInfo();
                this.orderDriverInfo = orderDriverInfo2;
                orderDriverInfo2.driverAvatar = optJSONObject4.optString("avatar");
                this.orderDriverInfo.driverName = optJSONObject4.optString("name");
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("order_info");
            if (optJSONObject5 != null) {
                this.title = optJSONObject5.optString("title");
                this.subTitle = optJSONObject5.optString("tips");
                this.content = optJSONObject5.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
                this.oid = optJSONObject5.optString("order_id");
                OrderDriverInfo orderDriverInfo3 = this.orderDriverInfo;
                if (orderDriverInfo3 != null) {
                    orderDriverInfo3.orderTime = optJSONObject5.optString("create_timestamp");
                    this.orderDriverInfo.toAddress = optJSONObject5.optString("to_name");
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("unmatch");
            if (optJSONObject6 != null) {
                UnMatchInfo unMatchInfo2 = new UnMatchInfo();
                this.unMatchInfo = unMatchInfo2;
                unMatchInfo2.parse(optJSONObject6);
            }
        }
    }

    public static class UnMatchInfo extends BaseObject {
        public boolean isShow;
        public boolean isUnMatched;
        public UnMatchGuideMsg unMatchGuideMsg;

        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                boolean z = false;
                this.isShow = jSONObject.optInt("is_show") == 1;
                if (jSONObject.optInt("is_unmatched") == 1) {
                    z = true;
                }
                this.isUnMatched = z;
                JSONObject optJSONObject = jSONObject.optJSONObject("guide_msg");
                if (optJSONObject != null) {
                    UnMatchGuideMsg unMatchGuideMsg2 = new UnMatchGuideMsg();
                    this.unMatchGuideMsg = unMatchGuideMsg2;
                    unMatchGuideMsg2.showMsg = optJSONObject.optString("show_msg");
                    this.unMatchGuideMsg.buttonMsg = optJSONObject.optString("button_msg");
                    this.unMatchGuideMsg.unMatchedMsg = optJSONObject.optString("unmatched_msg");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(Const.POPUP);
                    if (optJSONObject2 != null) {
                        this.unMatchGuideMsg.unMatchPopUp = new CommonPopUp();
                        this.unMatchGuideMsg.unMatchPopUp.parse(optJSONObject2);
                    }
                }
            }
        }
    }

    public static class QuestionDataOption extends BaseObject {
        public String description;
        public String iconUrl;
        public CommonPopUp popUp;
        public int state;
        public String text;
        public String title;
        public int type;
        public String url;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.text = jSONObject.optString("text");
                this.state = jSONObject.optInt("state");
                this.type = jSONObject.optInt("type");
                this.iconUrl = jSONObject.optString("icon_url");
                this.title = jSONObject.optString("title");
                this.description = jSONObject.optString("description");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.url = optJSONObject.optString("url");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(Const.POPUP);
                    if (optJSONObject2 != null) {
                        CommonPopUp commonPopUp = new CommonPopUp();
                        this.popUp = commonPopUp;
                        commonPopUp.parse(optJSONObject2);
                    }
                }
            }
        }
    }
}
