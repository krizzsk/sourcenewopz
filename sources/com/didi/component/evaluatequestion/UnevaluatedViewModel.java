package com.didi.component.evaluatequestion;

import com.didi.component.framework.pages.carcheck.CarCheckActivity;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.model.response.CarEvaluateQuestionData;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class UnevaluatedViewModel implements Serializable {
    public int[] answerState;
    public String[] answers;
    public CharSequence content;
    public String driverIconUrl;
    public String oid;
    public CharSequence questionBody;
    public String questionCaller;
    public int questionID;
    public CharSequence questionTitle;
    public CharSequence subTitle;
    public CharSequence title;
    public CharSequence userReply;

    @Deprecated
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("order_info");
            if (optJSONObject != null) {
                this.title = optJSONObject.optString("title");
                this.subTitle = optJSONObject.optString("tips");
                this.content = optJSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
                this.oid = optJSONObject.optString("order_id");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("question");
            if (optJSONObject2 != null) {
                this.userReply = optJSONObject2.optString(CarCheckActivity.USER_REPLY);
                this.questionID = optJSONObject2.optInt("question_id");
                this.questionBody = optJSONObject2.optString(CarCheckActivity.QUESTION_BODY);
                if (optJSONObject2.has(CarCheckActivity.ANSWERS) && (optJSONArray2 = optJSONObject2.optJSONArray(CarCheckActivity.ANSWERS)) != null) {
                    int length = optJSONArray2.length();
                    this.answers = new String[length];
                    for (int i = 0; i < length; i++) {
                        this.answers[i] = optJSONArray2.optString(i);
                    }
                }
                if (optJSONObject2.has("answer_state") && (optJSONArray = optJSONObject2.optJSONArray("answer_state")) != null) {
                    int length2 = optJSONArray.length();
                    this.answerState = new int[length2];
                    for (int i2 = 0; i2 < length2; i2++) {
                        this.answerState[i2] = optJSONArray.optInt(i2);
                    }
                }
            }
        }
    }

    public void parse(String str, CarEvaluateQuestionData carEvaluateQuestionData) {
        if (carEvaluateQuestionData != null) {
            this.oid = str;
            this.questionID = carEvaluateQuestionData.question_id;
            this.questionTitle = carEvaluateQuestionData.title;
            this.questionBody = carEvaluateQuestionData.question_body;
            this.userReply = carEvaluateQuestionData.user_reply;
            this.answers = carEvaluateQuestionData.answers;
            this.answerState = carEvaluateQuestionData.answer_state;
            this.questionCaller = carEvaluateQuestionData.caller;
        }
    }
}
