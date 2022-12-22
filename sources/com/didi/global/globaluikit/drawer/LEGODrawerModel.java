package com.didi.global.globaluikit.drawer;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.global.globaluikit.callback.LEGOCheckboxListener;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import java.util.List;

public class LEGODrawerModel {
    public View allExtendView;
    public boolean backPressedEnabled = true;
    public LEGOCheckboxModelAndCallback checkbox;
    public boolean clickOutsideCanCancel = true;
    public LEGODrawerDismissListener dismissListener;
    public int drawerStyle;
    public View extendedBottomView;
    public View extendedUpView;
    public View extendedView;
    public int imgPlaceHolder;
    public int imgResId;
    public String imgUrl;
    public boolean isLoadingEnable = false;
    public boolean isShowCloseImg;
    public boolean isTwoBtnHorizontal;
    public WidgetModel leftText;
    public LEGOLinkModelAndCallback link;
    public LEGOCheckboxListener mCheckListener;
    public LEGOOnAntiShakeClickListener mCloseImgListener;
    public boolean mIsChecked;
    public LEGOOnAntiShakeClickListener mLinkListener;
    public LEGORichInfo mRichCheckbox;
    public LEGORichInfo mRichLeft;
    public LEGORichInfo mRichLink;
    public LEGORichInfo mRichSubTitle;
    public LEGORichInfo mRichTitle;
    public LEGOBtnModelAndCallback mRightBtn;
    public LEGOBtnModelAndCallback majorBtn;
    public List<LEGOBtnModelAndCallback> minorBtns;
    public LEGOBtnModelAndCallback rightBtn;
    public WidgetModel subTitle;
    public WidgetModel title;

    public static class WidgetModel {
        public int fontColor;
        public float fontSize;
        public boolean isBold;
        public boolean isItalic;
        public String text;

        /* access modifiers changed from: package-private */
        public void bind(TextView textView) {
            if (textView != null && !TextUtils.isEmpty(this.text)) {
                textView.setText(this.text);
                float f = this.fontSize;
                if (f != 0.0f) {
                    textView.setTextSize(f);
                }
                int i = this.fontColor;
                if (i != 0) {
                    textView.setTextColor(i);
                }
                if (this.isBold && this.isItalic) {
                    textView.setTypeface(Typeface.defaultFromStyle(3));
                } else if (this.isBold) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                } else if (this.isItalic) {
                    textView.setTypeface(Typeface.defaultFromStyle(2));
                }
            }
        }
    }

    public static class EditModel extends WidgetModel {
        public String hint;

        /* access modifiers changed from: package-private */
        public void bind(TextView textView) {
            super.bind(textView);
            if (textView instanceof EditText) {
                textView.setHint(this.hint);
            }
        }
    }
}
