package com.didi.component.common.view.card;

import android.content.Context;
import android.util.AttributeSet;
import com.taxis99.R;

public class GlobalTemplateNewCardView extends GlobalTemplateCardView {
    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.global_template_new_card_layout;
    }

    public GlobalTemplateNewCardView(Context context) {
        super(context);
    }

    public GlobalTemplateNewCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GlobalTemplateNewCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
