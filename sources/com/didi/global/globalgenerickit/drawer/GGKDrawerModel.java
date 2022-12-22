package com.didi.global.globalgenerickit.drawer;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import java.util.List;

public class GGKDrawerModel {
    public boolean backPressedEnabled = true;
    public GGKBtnTextAndCallback changeBtn;
    public GGKCheckboxModelAndCallback checkbox;
    public boolean clickOutsideCanCancel = true;
    public GGKEditModelAndCallback edit;
    public View extendedBottomView;
    public View extendedUpView;
    public View extendedView;
    public int imgPlaceHolder;
    public int imgResId;
    public String imgUrl;
    public boolean isImgUp = true;
    public boolean isLoadingEnable = false;
    public boolean isTwoBtnHorizontal;
    public GGKLinkModelAndCallback link;
    public GGKBtnTextAndCallback majorBtn;
    public List<GGKBtnTextAndCallback> minorBtns;
    public WidgetModel selectedText;
    public WidgetModel subTitle;
    public WidgetModel title;

    public static class WidgetModel {
        public int fontColor;
        public float fontSize;
        public boolean isBold;
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
                if (this.isBold) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
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
