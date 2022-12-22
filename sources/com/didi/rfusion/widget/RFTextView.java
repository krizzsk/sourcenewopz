package com.didi.rfusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.passenger.C10448R;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.utils.RFFontUtils;

public class RFTextView extends AppCompatTextView {
    private static final String TAG = "RFTextView";
    private RFLogger mLogger;

    /* access modifiers changed from: protected */
    public boolean useTypeFace() {
        return true;
    }

    public RFTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLogger = RFLogger.getLogger();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (useTypeFace()) {
            int i = 0;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFTextView);
                i = obtainStyledAttributes.getInt(0, 0);
                obtainStyledAttributes.recycle();
            }
            RFFontUtils.setTypeFace(this, i);
        }
    }

    public void setTypeface(int i) {
        if (useTypeFace()) {
            RFFontUtils.setTypeFace(this, i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        updateTextAppearance(i);
    }

    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        updateTextAppearance(i);
    }

    private void updateTextAppearance(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, C10448R.styleable.RFTextView);
        int i2 = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        RFLogger rFLogger = this.mLogger;
        rFLogger.info(TAG, "updateTextAppearance:" + i2);
        RFFontUtils.setTypeFace(this, i2);
    }
}
