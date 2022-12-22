package com.didi.component.evaluateentrance.evaluate.model;

import com.didi.component.framework.pages.carcheck.CarCheckActivity;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.didi.travel.psnger.utils.JsonUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class EvaluateQuestionModel extends EvaluateModel {
    public int[] answerState;
    public String[] answers;
    public String avatarIcon;
    public CharSequence content;
    public boolean hasQuestionaireInfo = false;
    public boolean isVertical = false;
    public String oid;
    public CharSequence questionBody;
    public String questionCaller;
    public int questionID;
    public List<UnevaluatedViewModel.QuestionDataOption> questionOptions;
    public CharSequence questionTitle;
    public int style;
    public CharSequence subTitle;
    public GXPCarTipInfo tipInfo;
    public CharSequence userReply;
    public int xpanelPos;

    /* access modifiers changed from: protected */
    public void parseNormal(JSONObject jSONObject) {
        if (jSONObject.has("data") && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject.has("questionaire_info") && optJSONObject.optJSONObject("questionaire_info") != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("questionaire_info");
                if (optJSONObject2.has("v2") && optJSONObject2.optJSONObject("v2") != null) {
                    this.hasQuestionaireInfo = true;
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("v2");
                    initCommon(optJSONObject3);
                    this.questionCaller = optJSONObject3.optString("caller");
                    JSONArray optJSONArray = optJSONObject3.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    if (optJSONArray != null) {
                        this.questionOptions = new JsonUtil().parseJSONArray(optJSONArray, new UnevaluatedViewModel.QuestionDataOption());
                    }
                } else if (optJSONObject2.has("v1") && optJSONObject2.optJSONObject("v1") != null) {
                    this.hasQuestionaireInfo = true;
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("v1");
                    initCommon(optJSONObject4);
                    if (optJSONObject4.has(CarCheckActivity.ANSWERS) && optJSONObject4.optJSONArray(CarCheckActivity.ANSWERS) != null) {
                        JSONArray optJSONArray2 = optJSONObject4.optJSONArray(CarCheckActivity.ANSWERS);
                        int length = optJSONArray2.length();
                        this.answers = new String[length];
                        for (int i = 0; i < length; i++) {
                            this.answers[i] = optJSONArray2.optString(i);
                        }
                    }
                    if (optJSONObject4.has("answer_state") && optJSONObject4.optJSONArray("answer_state") != null) {
                        JSONArray optJSONArray3 = optJSONObject4.optJSONArray("answer_state");
                        int length2 = optJSONArray3.length();
                        this.answerState = new int[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            this.answerState[i2] = optJSONArray3.optInt(i2);
                        }
                    }
                }
            }
            if (optJSONObject.has("tip_info") && optJSONObject.optJSONObject("tip_info") != null) {
                GXPCarTipInfo gXPCarTipInfo = new GXPCarTipInfo();
                this.tipInfo = gXPCarTipInfo;
                gXPCarTipInfo.parse(optJSONObject.optJSONObject("tip_info"));
            }
            this.avatarIcon = optJSONObject.optString("avatar_icon");
        }
    }

    private void initCommon(JSONObject jSONObject) {
        this.questionID = jSONObject.optInt("question_id");
        this.questionTitle = jSONObject.optString(CarCheckActivity.QUESTION_BODY);
        this.questionBody = jSONObject.optString("description");
        this.userReply = jSONObject.optString(CarCheckActivity.USER_REPLY);
        this.style = jSONObject.optInt("style");
        this.xpanelPos = jSONObject.optInt("xpanel_pos");
    }
}
