package com.didi.global.globalgenerickit.template.yoga.view;

import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.global.globalgenerickit.template.yoga.IParser;

public class LottieView extends LottieAnimationView implements IParser {
    public View getView() {
        return this;
    }

    public LottieView(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r5, java.lang.String r6, com.facebook.yoga.YogaNode r7) {
        /*
            r4 = this;
            int r7 = r5.hashCode()
            r0 = -602198800(0xffffffffdc1b2cf0, float:-1.74712123E17)
            r1 = 2
            r2 = 1
            r3 = -1
            if (r7 == r0) goto L_0x002b
            r0 = 3327652(0x32c6a4, float:4.663034E-39)
            if (r7 == r0) goto L_0x0021
            r0 = 1147634399(0x446782df, float:926.04486)
            if (r7 == r0) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.String r7 = "end-progress"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0035
            r5 = 2
            goto L_0x0036
        L_0x0021:
            java.lang.String r7 = "loop"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0035
            r5 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r7 = "from-progress"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0035
            r5 = 1
            goto L_0x0036
        L_0x0035:
            r5 = -1
        L_0x0036:
            if (r5 == 0) goto L_0x004d
            if (r5 == r2) goto L_0x0045
            if (r5 == r1) goto L_0x003d
            goto L_0x0060
        L_0x003d:
            float r5 = java.lang.Float.parseFloat(r6)
            r4.setMaxProgress(r5)
            goto L_0x0060
        L_0x0045:
            float r5 = java.lang.Float.parseFloat(r6)
            r4.setMinProgress(r5)
            goto L_0x0060
        L_0x004d:
            java.lang.String r5 = "1"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0059
            r4.setRepeatCount(r3)
            goto L_0x0060
        L_0x0059:
            int r5 = java.lang.Integer.parseInt(r6)
            r4.setRepeatCount(r5)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.view.LottieView.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    public void onParseEnd() {
        playAnimation();
    }
}
