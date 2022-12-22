package com.didi.component.evaluateentrance.evaluate.model;

import java.io.Serializable;

public class EvaluateQuestionItemModel implements Serializable {
    public String iconUrl;
    public boolean selected;
    public String text;

    public EvaluateQuestionItemModel(String str, String str2, boolean z) {
        this.iconUrl = str;
        this.text = str2;
        this.selected = z;
    }
}
