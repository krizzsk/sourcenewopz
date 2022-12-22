package com.didi.component.messagebar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.app.DIDIApplication;
import com.taxis99.R;

public class CountDownModel {
    public int countBeginTime;
    public int countEndTime;
    public LEGORichInfo info;
    public String prefix;
    public String suffix;
    public int type;

    public CountDownModel(LEGORichInfo lEGORichInfo, int i, String str, String str2, int i2, int i3) {
        this.info = lEGORichInfo;
        this.countBeginTime = i;
        this.countEndTime = i3;
        this.prefix = str;
        this.suffix = str2;
        this.type = i2;
    }

    public boolean isNeedUpdate() {
        return this.info != null && Math.abs(this.countBeginTime - this.countEndTime) >= 0;
    }

    public void updateTextInt() {
        updateText(this.prefix + m10406a(this.countBeginTime) + this.suffix);
    }

    public void updateText(String str) {
        LEGORichInfo lEGORichInfo = this.info;
        if (lEGORichInfo != null) {
            lEGORichInfo.setText(str);
        }
    }

    public void countDown() {
        if (this.type == 0) {
            this.countBeginTime--;
            return;
        }
        int i = this.countBeginTime;
        if (i < this.countEndTime) {
            this.countBeginTime = i + 1;
        }
    }

    /* renamed from: a */
    private String m10406a(int i) {
        String str;
        String string = DIDIApplication.getAppContext().getResources().getString(R.string.rider_on_the_way_minute);
        String string2 = DIDIApplication.getAppContext().getResources().getString(R.string.rider_on_the_way_second);
        int i2 = i / 60;
        int i3 = i % 60;
        if (i2 > 99) {
            return "99" + string + "99" + string2;
        }
        if (i2 < 10) {
            str = "0" + i2;
        } else {
            str = i2 < 0 ? "00" : String.valueOf(i2);
        }
        if (i3 < 10) {
            return str + string + "0" + i3 + string2;
        } else if (i3 < 0) {
            return str + ":00" + string2;
        } else {
            return str + string + i3 + string2;
        }
    }
}
