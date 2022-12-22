package com.didi.component.common.view.card;

import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class GlobalTemplateCardModel implements Serializable {
    public static final int IMAGE_CENTER_VERTICAL_STYLE = 3;
    public static final int IMAGE_CENTER_VERTICAL_WITH_MARGIN_STYLE = 2;
    public static final int IMAGE_RIGHT_TOP_STYLE = 1;
    public static final int IMAGE_RIGHT_TOP_WITH_MARGIN_STYLE = 4;
    public static final int TEXT_COLOR_DARK_STYLE = 2;
    public static final int TEXT_COLOR_LIGHT_STYLE = 1;
    public ExtendsViewModel bigExtendsViewModel;
    public BtnModel btnModel;
    private int cardBackGround;
    public ImageModel imageModel;
    public LinkBtnModel linkBtnModel;
    public NewBtnModel newBtnModel;
    public ExtendsViewModel smallExtendsViewModel;
    public TextAreaModel textAreaModel;
    private int textColorStyle = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageLocationStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextColorStyle {
    }

    public int getTextColorStyle() {
        return this.textColorStyle;
    }

    public void setTextColorStyle(int i) {
        this.textColorStyle = i;
    }

    public int getCardBackGround() {
        return this.cardBackGround;
    }

    public void setCardBackGround(int i) {
        this.cardBackGround = i;
    }

    public static class TextAreaModel {
        public String contentText;
        public int mainTitleMaxLine;
        public String maintTitleText;
        public String subTitleText;

        public TextAreaModel(String str, String str2, String str3) {
            this.mainTitleMaxLine = 3;
            this.maintTitleText = str;
            this.subTitleText = str2;
            this.contentText = str3;
        }

        public TextAreaModel(String str, String str2, String str3, int i) {
            this(str, str2, str3);
            this.mainTitleMaxLine = i;
        }
    }

    public static class BtnModel {
        public static final int TYPE_LEFT = 1;
        public static final int TYPE_RIGHT = 0;
        public String btnText;
        public String describeText;
        public View.OnClickListener listener;
        public int type;

        public BtnModel(String str, String str2, View.OnClickListener onClickListener) {
            this(str, str2, 0, onClickListener);
        }

        public BtnModel(String str, String str2, int i, View.OnClickListener onClickListener) {
            this.describeText = str;
            this.btnText = str2;
            this.listener = onClickListener;
            this.type = i;
        }
    }

    public static class NewBtnModel {
        public String btnText;
        public View.OnClickListener listener;

        public NewBtnModel(String str, View.OnClickListener onClickListener) {
            this.btnText = str;
            this.listener = onClickListener;
        }
    }

    public static class LinkBtnModel {
        public String linkText;
        public View.OnClickListener listener;

        public LinkBtnModel(String str, View.OnClickListener onClickListener) {
            this.linkText = str;
            this.listener = onClickListener;
        }
    }

    public static class ExtendsViewModel {
        public ViewGroup.LayoutParams layoutParams;
        public View view;

        public ExtendsViewModel(View view2, ViewGroup.LayoutParams layoutParams2) {
            this.view = view2;
            this.layoutParams = layoutParams2;
        }
    }

    public static class ImageModel {
        public int defaultDrawableId;
        public int drawableId;
        public String drawableUri;
        public int height;
        public int style = 1;
        public int width;

        public ImageModel(int i, int i2, int i3, int i4) {
            this.drawableId = i;
            this.height = i2;
            this.width = i3;
            this.style = i4;
        }

        public ImageModel(int i, String str, int i2, int i3, int i4) {
            this.drawableUri = str;
            this.defaultDrawableId = i;
            this.height = i2;
            this.width = i3;
            this.style = i4;
        }
    }
}
