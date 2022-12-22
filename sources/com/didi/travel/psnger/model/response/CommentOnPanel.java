package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import org.json.JSONObject;

public class CommentOnPanel extends BaseObject {
    public CarNoEvaluateData carNoEvaluateData;
    public int evaluateMark;
    public int evaluateScore;
    public UnevaluatedViewModel evaluatedViewModel;
    public CommentOnPanelOrderInfo orderInfo;
    public CarEvaluateQuestionData questionData;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        CarEvaluateQuestionData carEvaluateQuestionData = new CarEvaluateQuestionData();
        this.questionData = carEvaluateQuestionData;
        carEvaluateQuestionData.parse(jSONObject);
        CarNoEvaluateData carNoEvaluateData2 = new CarNoEvaluateData();
        this.carNoEvaluateData = carNoEvaluateData2;
        carNoEvaluateData2.parse(jSONObject);
        CommentOnPanelOrderInfo commentOnPanelOrderInfo = new CommentOnPanelOrderInfo();
        this.orderInfo = commentOnPanelOrderInfo;
        commentOnPanelOrderInfo.parse(jSONObject);
        UnevaluatedViewModel unevaluatedViewModel = new UnevaluatedViewModel();
        this.evaluatedViewModel = unevaluatedViewModel;
        unevaluatedViewModel.parse(jSONObject.optJSONObject("data"));
    }

    public boolean isQuestionEvaluate() {
        CarEvaluateQuestionData carEvaluateQuestionData = this.questionData;
        return carEvaluateQuestionData != null && !TextUtils.isEmpty(carEvaluateQuestionData.question_body);
    }

    public boolean isStarEvaluate() {
        CarNoEvaluateData carNoEvaluateData2 = this.carNoEvaluateData;
        return carNoEvaluateData2 != null && !carNoEvaluateData2.tags.isEmpty();
    }
}
