package com.didi.sdk.view.dialog;

import com.didi.sdk.util.DataEntity;
import com.didi.sdk.view.TimePickerMode;

public class ProductThemeStyle {

    /* renamed from: a */
    private int f37987a = 0;

    /* renamed from: b */
    private int f37988b = 0;

    /* renamed from: c */
    private int f37989c = 0;

    /* renamed from: d */
    private int f37990d = 0;

    /* renamed from: e */
    private int f37991e = 0;

    /* renamed from: f */
    private int f37992f = 0;

    /* renamed from: g */
    private TitleBarStyle f37993g = new TitleBarStyle();

    /* renamed from: h */
    private int f37994h = 2;

    /* renamed from: i */
    private int f37995i = 0;

    /* renamed from: j */
    private TimePickerMode f37996j = TimePickerMode.Normal;

    /* renamed from: k */
    private ToastStyle f37997k;

    public void setTimePickerMode(TimePickerMode timePickerMode) {
        this.f37996j = timePickerMode;
    }

    public void setToastStyle(ToastStyle toastStyle) {
        this.f37997k = toastStyle;
    }

    public ToastStyle getToastStyle() {
        return this.f37997k;
    }

    public TimePickerMode getTimePickerMode() {
        return this.f37996j;
    }

    public void setCommonDialogBg(int i) {
        this.f37995i = i;
    }

    public int getCommonDialogBg() {
        return this.f37995i;
    }

    public TitleBarStyle getTitleBarStyle() {
        return this.f37993g;
    }

    public void setTitleBarStyle(TitleBarStyle titleBarStyle) {
        this.f37993g = titleBarStyle;
    }

    public int getDefaultButtonTextColor() {
        return this.f37988b;
    }

    public void setDefaultButtonTextColor(int i) {
        this.f37988b = i;
    }

    public int getIndeterminateDrawable() {
        return this.f37989c;
    }

    public void setIndeterminateDrawable(int i) {
        this.f37989c = i;
    }

    public int getCommonSwitchSelector() {
        return this.f37990d;
    }

    public void setCommonSwitchSelector(int i) {
        this.f37990d = i;
    }

    public int getCommonCheckboxSelector() {
        return this.f37991e;
    }

    public void setCommonCheckboxSelector(int i) {
        this.f37991e = i;
    }

    public int getCommonButtonBackground() {
        return this.f37992f;
    }

    public void setCommonButtonBackground(int i) {
        this.f37992f = i;
    }

    public int getProductBasicColor() {
        return this.f37987a;
    }

    public void setProductBasicColor(int i) {
        this.f37987a = i;
    }

    public int getMaxToastContentLines() {
        return this.f37994h;
    }

    public void setMaxToastContentLines(int i) {
        this.f37994h = i;
    }

    public class TitleBarStyle {
        private int mCommonTitleBarTextSelecter;
        private int mCommonTittleBackground = 0;
        private int mTitleColor = 0;

        public TitleBarStyle() {
        }

        public int getCommonTitleBarTextSelecter() {
            return this.mCommonTitleBarTextSelecter;
        }

        public void setCommonTitleBarTextSelecter(int i) {
            this.mCommonTitleBarTextSelecter = i;
        }

        public int getCommonTittleBackground() {
            return this.mCommonTittleBackground;
        }

        public void setCommonTittleBackground(int i) {
            this.mCommonTittleBackground = i;
        }

        public void setTitleColor(int i) {
            this.mTitleColor = i;
        }

        public int getTitleColor() {
            return this.mTitleColor;
        }
    }

    public static class ToastStyle {
        public DataEntity dataEntity;
        public int toastBackground;
        public int toastYoffset = -1;

        public int getToastBackground() {
            return this.toastBackground;
        }

        public void setToastBackground(int i) {
            this.toastBackground = i;
        }

        public int getToastYoffset() {
            return this.toastYoffset;
        }

        public void setToastYoffset(int i) {
            this.toastYoffset = i;
        }

        public DataEntity getDataEntity() {
            return this.dataEntity;
        }

        public void setDataEntity(DataEntity dataEntity2) {
            this.dataEntity = dataEntity2;
        }
    }
}
