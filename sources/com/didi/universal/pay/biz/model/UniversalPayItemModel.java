package com.didi.universal.pay.biz.model;

import android.text.TextUtils;
import java.io.Serializable;

public class UniversalPayItemModel implements Serializable {
    public static final int STATE_ARROW = 3;
    public static final int STATE_CHECKBOX_NORMAL = 2;
    public static final int STATE_CHECKBOX_SELECTED = 1;
    public static final int STATE_LOADING = 5;
    public static final int STATE_NOTHING = 4;
    public static final int STATE_TRANSLUCENT = 0;
    public boolean canCancel = true;
    public CharSequence descFirstLine;
    public CharSequence descSecondLine;
    public String iconURL;

    /* renamed from: id */
    public int f45101id;
    public boolean isHidden;
    public CharSequence marketDesc;
    public String name;
    public String payNumber;
    private int state = 2;
    public String url;
    public String value;

    public void setState(int i, int i2, int i3) {
        boolean z = i == 1;
        boolean z2 = i2 == 1;
        if (i3 == 3) {
            this.state = 0;
        } else if (i3 == 1) {
            if (TextUtils.isEmpty(this.url)) {
                this.state = 4;
            } else {
                this.state = 3;
            }
        } else if (i3 != 0) {
            this.state = 4;
        } else if (!z2) {
            this.state = 4;
        } else if (z) {
            this.state = 1;
        } else {
            this.state = 2;
        }
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }
}
