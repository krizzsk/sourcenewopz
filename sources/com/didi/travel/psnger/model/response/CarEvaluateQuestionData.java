package com.didi.travel.psnger.model.response;

import com.didi.component.framework.pages.carcheck.CarCheckActivity;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class CarEvaluateQuestionData extends BaseObject {
    public String[] answer_list;
    public int[] answer_state;
    public String[] answers;
    public String caller;
    public String question_body;
    public int question_id;
    public String[] replay_answer_list;
    public String title;
    public String user_reply;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        super.parse(jSONObject);
        if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("question");
            if (optJSONObject2 != null) {
                optJSONObject = optJSONObject2;
            }
            int i = 0;
            if (optJSONObject.has("v2") && optJSONObject.optJSONObject("v2") != null) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("v2");
                this.caller = optJSONObject3.optString("caller");
                this.question_id = optJSONObject3.optInt("question_id");
                this.question_body = optJSONObject3.optString(CarCheckActivity.QUESTION_BODY);
                this.title = optJSONObject3.optString("title");
                this.user_reply = optJSONObject3.optString(CarCheckActivity.USER_REPLY);
                JSONArray optJSONArray5 = optJSONObject3.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                    int length = optJSONArray5.length();
                    this.answers = new String[length];
                    this.answer_list = new String[length];
                    this.answer_state = new int[length];
                    while (i < length) {
                        JSONObject optJSONObject4 = optJSONArray5.optJSONObject(i);
                        if (optJSONObject4 != null) {
                            this.answers[i] = optJSONObject4.optString("text");
                            this.answer_list[i] = this.answers[i];
                            this.answer_state[i] = optJSONObject4.optInt("state");
                        }
                        i++;
                    }
                }
            } else if (optJSONObject.has("v1") && optJSONObject.optJSONObject("v1") != null) {
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("v1");
                this.question_id = optJSONObject5.optInt("question_id");
                this.title = optJSONObject5.optString("title");
                this.question_body = optJSONObject5.optString(CarCheckActivity.QUESTION_BODY);
                if (optJSONObject5.has(CarCheckActivity.ANSWERS) && (optJSONArray4 = optJSONObject5.optJSONArray(CarCheckActivity.ANSWERS)) != null) {
                    int length2 = optJSONArray4.length();
                    this.answers = new String[length2];
                    for (int i2 = 0; i2 < length2; i2++) {
                        this.answers[i2] = optJSONArray4.optString(i2);
                    }
                }
                if (optJSONObject5.has("answer_list") && (optJSONArray3 = optJSONObject5.optJSONArray("answer_list")) != null) {
                    int length3 = optJSONArray3.length();
                    this.answer_list = new String[length3];
                    for (int i3 = 0; i3 < length3; i3++) {
                        this.answer_list[i3] = optJSONArray3.optString(i3);
                    }
                }
                if (optJSONObject5.has("user_reply_list") && (optJSONArray2 = optJSONObject5.optJSONArray("user_reply_list")) != null) {
                    int length4 = optJSONArray2.length();
                    this.replay_answer_list = new String[length4];
                    for (int i4 = 0; i4 < length4; i4++) {
                        this.replay_answer_list[i4] = optJSONArray2.optString(i4);
                    }
                }
                if (optJSONObject5.has("answer_state") && (optJSONArray = optJSONObject5.optJSONArray("answer_state")) != null) {
                    int length5 = optJSONArray.length();
                    this.answer_state = new int[length5];
                    while (i < length5) {
                        this.answer_state[i] = optJSONArray.optInt(i);
                        i++;
                    }
                }
                this.user_reply = optJSONObject5.optString(CarCheckActivity.USER_REPLY);
            }
        }
    }
}
