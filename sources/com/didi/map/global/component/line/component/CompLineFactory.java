package com.didi.map.global.component.line.component;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.map.global.component.line.component.dot.DottedLine;
import com.didi.map.global.component.line.component.dot.FlowingAnimationLine;
import com.didi.map.global.component.line.component.traffic.TrafficLineComponent;

public class CompLineFactory {

    public enum LineType {
        LINE_COMMON,
        LINE_ARC,
        LINE_PULSE,
        LINE_TRAFFIC,
        LINE_DOT,
        LINE_DOT_PULSE,
        LINE_DOT_ARC
    }

    /* renamed from: com.didi.map.global.component.line.component.CompLineFactory$1 */
    static /* synthetic */ class C95161 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$line$component$CompLineFactory$LineType */
        static final /* synthetic */ int[] f25657xe2b91659;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.map.global.component.line.component.CompLineFactory$LineType[] r0 = com.didi.map.global.component.line.component.CompLineFactory.LineType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25657xe2b91659 = r0
                com.didi.map.global.component.line.component.CompLineFactory$LineType r1 = com.didi.map.global.component.line.component.CompLineFactory.LineType.LINE_COMMON     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25657xe2b91659     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.line.component.CompLineFactory$LineType r1 = com.didi.map.global.component.line.component.CompLineFactory.LineType.LINE_ARC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25657xe2b91659     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.line.component.CompLineFactory$LineType r1 = com.didi.map.global.component.line.component.CompLineFactory.LineType.LINE_PULSE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f25657xe2b91659     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.component.line.component.CompLineFactory$LineType r1 = com.didi.map.global.component.line.component.CompLineFactory.LineType.LINE_DOT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f25657xe2b91659     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.global.component.line.component.CompLineFactory$LineType r1 = com.didi.map.global.component.line.component.CompLineFactory.LineType.LINE_TRAFFIC     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f25657xe2b91659     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.map.global.component.line.component.CompLineFactory$LineType r1 = com.didi.map.global.component.line.component.CompLineFactory.LineType.LINE_DOT_PULSE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f25657xe2b91659     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.map.global.component.line.component.CompLineFactory$LineType r1 = com.didi.map.global.component.line.component.CompLineFactory.LineType.LINE_DOT_ARC     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.line.component.CompLineFactory.C95161.<clinit>():void");
        }
    }

    public static ICompLineContract createLineComponent(LineType lineType, Map map, Context context, LineParams lineParams) {
        ICompLineContract iCompLineContract = null;
        if (!(map == null || context == null)) {
            switch (C95161.f25657xe2b91659[lineType.ordinal()]) {
                case 1:
                    iCompLineContract = new CommLineComponent();
                    break;
                case 2:
                    iCompLineContract = new ArcLineComponent();
                    break;
                case 3:
                    iCompLineContract = new PulseLineComponent();
                    break;
                case 4:
                    iCompLineContract = new DottedLine();
                    break;
                case 5:
                    iCompLineContract = new TrafficLineComponent();
                    break;
                case 6:
                    iCompLineContract = new FlowingAnimationLine();
                    break;
                case 7:
                    iCompLineContract = new DotArcLineComponent();
                    break;
            }
            iCompLineContract.create(context, map);
            iCompLineContract.setConfigParam(lineParams);
        }
        return iCompLineContract;
    }
}
