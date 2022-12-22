package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.taxis99.R;

public class NewFiveStarEvaluatedView extends FiveStarEvaluatedView {
    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_new_evaluate_five_star_view_layout;
    }

    public NewFiveStarEvaluatedView(Context context) {
        super(context);
    }

    public NewFiveStarEvaluatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NewFiveStarEvaluatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void flushRateStar(int i) {
        super.flushRateStar(i);
        for (int i2 = 0; i2 < this.mCheckBoxes.size(); i2++) {
            CheckBox checkBox = (CheckBox) this.mCheckBoxes.get(i2);
            if (i == 4) {
                checkBox.setBackgroundResource(R.drawable.global_five_star_evauate_small_five_star_selector);
            } else {
                checkBox.setBackgroundResource(R.drawable.global_five_star_evauate_small_four_star_selector);
            }
        }
    }
}
