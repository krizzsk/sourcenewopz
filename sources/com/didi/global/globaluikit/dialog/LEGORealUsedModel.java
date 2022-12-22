package com.didi.global.globaluikit.dialog;

import android.graphics.Typeface;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOCheckboxListener;
import com.didi.global.globaluikit.callback.LEGOImgModel;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import java.util.List;

public class LEGORealUsedModel {
    public TextWidgetModel mCheckContent;
    public LEGOCheckboxListener mCheckListener;
    public TextWidgetModel mContent;
    public TextWidgetModel mDescription;
    public TextWatcher mEditListener;
    public String mHint;
    public LEGOImgModel mImageModel;
    public boolean mIsChecked;
    public CompoundButton.OnCheckedChangeListener mLEGOCheckboxListener;
    public LEGOOnAntiShakeClickListener mLinkClickedListener;
    public List<LEGOBtnTextAndCallback> mListOfBtns;
    public LEGORichInfo mRichCheckbox;
    public LEGORichInfo mRichSubTitle;
    public LEGORichInfo mRichTitle;
    public List<TextWidgetModel> mSubContents;
    public TextWidgetModel mSubTitle;
    public TextWidgetModel mTitle;

    public static class TextWidgetModel {
        public int fontColor;
        public float fontSize;
        public boolean isBold = false;
        public String text;

        public void bind(TextView textView) {
            if (textView != null) {
                String str = this.text;
                if (str != null) {
                    textView.setText(str);
                }
                int i = this.fontColor;
                if (i != 0) {
                    textView.setTextColor(i);
                }
                float f = this.fontSize;
                if (f != 0.0f) {
                    textView.setTextSize(f);
                }
                if (this.isBold) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
            }
        }
    }
}
