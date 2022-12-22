package com.iproov.sdk.p223ui.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.iproov.sdk.IProov;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.C19889if;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import com.iproov.sdk.p223ui.views.C19931do;
import com.iproov.sdk.p223ui.views.LivenessDebugOverlay;
import com.iproov.sdk.p223ui.views.OverlayView;
import com.iproov.sdk.p223ui.views.ProgressView;
import com.iproov.sdk.p223ui.views.ReticleView;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import p066native.C2381if;
import p090return.C3014do;
import p093switch.C3114const;
import p093switch.C3118final;
import p093switch.C3125super;
import p096try.C3136do;
import p096try.C3138if;
import p234final.C20831for;
import p234final.C20835new;
import p239if.C20994do;

/* renamed from: com.iproov.sdk.ui.activity.do */
/* compiled from: IProovActivity */
public class C19923do extends Activity implements C3014do, C3138if.C3147this {

    /* renamed from: A */
    private C20994do f54384A;

    /* renamed from: B */
    private AccessibilityManager f54385B;

    /* renamed from: a */
    private OverlayView f54386a;

    /* renamed from: b */
    private ReticleView f54387b;

    /* renamed from: c */
    private ImageView f54388c;

    /* renamed from: d */
    private ImageView f54389d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f54390e;

    /* renamed from: f */
    private TextView f54391f;

    /* renamed from: g */
    private TextView f54392g;

    /* renamed from: h */
    private TextView f54393h;

    /* renamed from: i */
    private TextView f54394i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ProgressView f54395j;

    /* renamed from: k */
    private LivenessDebugOverlay f54396k;

    /* renamed from: l */
    private SwitchCompat f54397l;

    /* renamed from: m */
    private View f54398m;

    /* renamed from: n */
    private C20831for f54399n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C19889if f54400o;

    /* renamed from: p */
    private C20835new f54401p;

    /* renamed from: q */
    private IProov.Options f54402q;

    /* renamed from: r */
    private boolean f54403r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public CountDownTimer f54404s;

    /* renamed from: t */
    private C2381if f54405t;

    /* renamed from: u */
    private GestureDetector f54406u;

    /* renamed from: v */
    private C3118final f54407v;

    /* renamed from: w */
    private C3118final f54408w;

    /* renamed from: x */
    private Animation f54409x;

    /* renamed from: y */
    private OpenGLRenderer f54410y;

    /* renamed from: z */
    private C19925for f54411z;

    /* renamed from: com.iproov.sdk.ui.activity.do$do */
    /* compiled from: IProovActivity */
    class C19924do extends CountDownTimer {

        /* renamed from: do */
        int f54412do = 2;

        C19924do(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            C19923do.this.f54404s.cancel();
            CountDownTimer unused = C19923do.this.f54404s = null;
            C19923do.this.f54395j.mo162211do();
            C19923do.this.f54395j.setProgress(33);
            C19923do.this.f54400o.m47524import();
        }

        public void onTick(long j) {
            int i = this.f54412do;
            this.f54412do = i - 1;
            C19923do.this.f54390e.announceForAccessibility(Integer.toString(i));
        }
    }

    /* renamed from: com.iproov.sdk.ui.activity.do$for */
    /* compiled from: IProovActivity */
    private enum C19925for {
        GPA_INIT_NO_SUPPLEMENTARY,
        GPA_INIT_SUPPLEMENTARY,
        GPA_SUPPLEMENTARY_FRAME,
        GPA_FACE,
        GPA_NO_FACE,
        GPA_FLASHING_STARTING,
        LIVENESS_SUPPLEMENTARY_FRAME,
        LIVENESS_SCAN,
        LIVENESS_STOP_SCAN,
        LIVENESS_FINISH,
        LIVENESS_INIT
    }

    /* renamed from: com.iproov.sdk.ui.activity.do$if */
    /* compiled from: IProovActivity */
    static /* synthetic */ class C19926if {

        /* renamed from: do */
        static final /* synthetic */ int[] f54416do;

        /* renamed from: for  reason: not valid java name */
        static final /* synthetic */ int[] f61831for;

        /* renamed from: if */
        static final /* synthetic */ int[] f54417if;

        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(67:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(72:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|81|82|84) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00bd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00c7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00db */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00ef */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00f9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0105 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x011d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0129 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0146 */
        static {
            /*
                com.iproov.sdk.ui.activity.do$for[] r0 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f61831for = r0
                r1 = 1
                com.iproov.sdk.ui.activity.do$for r2 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.GPA_INIT_NO_SUPPLEMENTARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f61831for     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.ui.activity.do$for r3 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.GPA_INIT_SUPPLEMENTARY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f61831for     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.ui.activity.do$for r4 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.GPA_SUPPLEMENTARY_FRAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f61831for     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.ui.activity.do$for r5 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.GPA_FACE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f61831for     // Catch:{ NoSuchFieldError -> 0x003e }
                com.iproov.sdk.ui.activity.do$for r6 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.GPA_NO_FACE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f61831for     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.iproov.sdk.ui.activity.do$for r7 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.GPA_FLASHING_STARTING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f61831for     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.iproov.sdk.ui.activity.do$for r8 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.LIVENESS_INIT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f61831for     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.iproov.sdk.ui.activity.do$for r9 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.LIVENESS_SUPPLEMENTARY_FRAME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f61831for     // Catch:{ NoSuchFieldError -> 0x006c }
                com.iproov.sdk.ui.activity.do$for r10 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.LIVENESS_SCAN     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                r9 = 10
                int[] r10 = f61831for     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.iproov.sdk.ui.activity.do$for r11 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.LIVENESS_STOP_SCAN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r10 = 11
                int[] r11 = f61831for     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.iproov.sdk.ui.activity.do$for r12 = com.iproov.sdk.p223ui.activity.C19923do.C19925for.LIVENESS_FINISH     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                try.do[] r11 = p096try.C3136do.values()
                int r11 = r11.length
                int[] r11 = new int[r11]
                f54417if = r11
                try.do r12 = p096try.C3136do.END_FACE_PATH     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r11[r12] = r1     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r11 = f54417if     // Catch:{ NoSuchFieldError -> 0x009f }
                try.do r12 = p096try.C3136do.READY     // Catch:{ NoSuchFieldError -> 0x009f }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r11[r12] = r0     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                int[] r11 = f54417if     // Catch:{ NoSuchFieldError -> 0x00a9 }
                try.do r12 = p096try.C3136do.FACE_PATH     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r11[r12] = r2     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x00b3 }
                try.do r11 = p096try.C3136do.NO_FACE_PATH     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r2[r11] = r3     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x00bd }
                try.do r3 = p096try.C3136do.TOO_FAR_FACE_PATH     // Catch:{ NoSuchFieldError -> 0x00bd }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bd }
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00bd }
            L_0x00bd:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x00c7 }
                try.do r3 = p096try.C3136do.TOO_CLOSE_FACE_PATH     // Catch:{ NoSuchFieldError -> 0x00c7 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c7 }
                r2[r3] = r5     // Catch:{ NoSuchFieldError -> 0x00c7 }
            L_0x00c7:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x00d1 }
                try.do r3 = p096try.C3136do.NO_FACE     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r2[r3] = r6     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x00db }
                try.do r3 = p096try.C3136do.TOO_FAR     // Catch:{ NoSuchFieldError -> 0x00db }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r2[r3] = r7     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x00e5 }
                try.do r3 = p096try.C3136do.TOO_CLOSE     // Catch:{ NoSuchFieldError -> 0x00e5 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e5 }
                r2[r3] = r8     // Catch:{ NoSuchFieldError -> 0x00e5 }
            L_0x00e5:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x00ef }
                try.do r3 = p096try.C3136do.TOO_BRIGHT     // Catch:{ NoSuchFieldError -> 0x00ef }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ef }
                r2[r3] = r9     // Catch:{ NoSuchFieldError -> 0x00ef }
            L_0x00ef:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x00f9 }
                try.do r3 = p096try.C3136do.ROLL_TOO_HIGH     // Catch:{ NoSuchFieldError -> 0x00f9 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f9 }
                r2[r3] = r10     // Catch:{ NoSuchFieldError -> 0x00f9 }
            L_0x00f9:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x0105 }
                try.do r3 = p096try.C3136do.ROLL_TOO_LOW     // Catch:{ NoSuchFieldError -> 0x0105 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0105 }
                r4 = 12
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0105 }
            L_0x0105:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x0111 }
                try.do r3 = p096try.C3136do.YAW_TOO_HIGH     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r4 = 13
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x011d }
                try.do r3 = p096try.C3136do.YAW_TOO_LOW     // Catch:{ NoSuchFieldError -> 0x011d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x011d }
                r4 = 14
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x011d }
            L_0x011d:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x0129 }
                try.do r3 = p096try.C3136do.PITCH_TOO_LOW     // Catch:{ NoSuchFieldError -> 0x0129 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0129 }
                r4 = 15
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0129 }
            L_0x0129:
                int[] r2 = f54417if     // Catch:{ NoSuchFieldError -> 0x0135 }
                try.do r3 = p096try.C3136do.PITCH_TOO_HIGH     // Catch:{ NoSuchFieldError -> 0x0135 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0135 }
                r4 = 16
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0135 }
            L_0x0135:
                if.do[] r2 = p239if.C20994do.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f54416do = r2
                if.do r3 = p239if.C20994do.GENUINE_PRESENCE_ASSURANCE     // Catch:{ NoSuchFieldError -> 0x0146 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0146 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0146 }
            L_0x0146:
                int[] r1 = f54416do     // Catch:{ NoSuchFieldError -> 0x0150 }
                if.do r2 = p239if.C20994do.LIVENESS     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p223ui.activity.C19923do.C19926if.<clinit>():void");
        }
    }

    /* renamed from: com.iproov.sdk.ui.activity.do$new */
    /* compiled from: IProovActivity */
    private class C19927new extends GestureDetector.SimpleOnGestureListener {
        private C19927new() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            C19923do.this.m39331m();
            C19923do.this.f54400o.m47524import();
            return true;
        }

        /* synthetic */ C19927new(C19923do doVar, C19924do doVar2) {
            this();
        }
    }

    /* renamed from: d */
    private void m39321d() {
        this.f54386a.m47554for();
        this.f54387b.m47557try();
    }

    /* renamed from: e */
    private void m39322e() {
        this.f54399n.m47637for(C20831for.C20832do.COMPLETED);
    }

    /* renamed from: f */
    private void m39324f() {
        this.f54401p = new C20835new(getWindow());
        this.f54399n = new C20831for(this);
        if (!this.f54402q.f53992ui.enableScreenshots) {
            getWindow().setFlags(8192, 8192);
        }
        this.f54401p.mo170679do(true);
        this.f54401p.mo170680if(true);
    }

    /* renamed from: g */
    private void m39325g() {
        this.f54393h.setTextColor(this.f54402q.f53992ui.headerTextColor);
        this.f54398m.setBackgroundColor(this.f54402q.f53992ui.headerBackgroundColor);
        this.f54390e.setTextColor(this.f54402q.f53992ui.getPromptTextColor());
        ProgressView progressView = this.f54395j;
        IProov.Options.C19751UI ui = this.f54402q.f53992ui;
        progressView.setProgressDrawable(C3125super.m4041do(ui.footerBackgroundColor, ui.genuinePresenceAssurance.progressBarColor));
        if (this.f54402q.f53992ui.floatingPromptEnabled) {
            PaintDrawable paintDrawable = new PaintDrawable();
            paintDrawable.setCornerRadius(getResources().getDimension(R.dimen.iproov__prompt_text_corner_radius));
            this.f54392g.setBackground(paintDrawable);
        }
    }

    /* renamed from: h */
    private void m39326h() {
        this.f54387b = (ReticleView) findViewById(R.id.iproov__reticleView);
        this.f54386a = (OverlayView) findViewById(R.id.iproov__ovalView);
        this.f54410y = (OpenGLRenderer) findViewById(R.id.iproov__rendererView);
        this.f54394i = (TextView) findViewById(R.id.iproov__textViewDebug);
        this.f54388c = (ImageView) findViewById(R.id.iproov__imageHistogramPreView);
        this.f54395j = (ProgressView) findViewById(R.id.iproov__progressBarCaptureBottom);
        this.f54389d = (ImageView) findViewById(R.id.iproov__logoImageView);
        this.f54393h = (TextView) findViewById(R.id.iproov__titleTextView);
        this.f54391f = (TextView) findViewById(R.id.iproov__promptTextView);
        this.f54392g = (TextView) findViewById(R.id.iproov__floatingPromptTextView);
        this.f54396k = (LivenessDebugOverlay) findViewById(R.id.iproov__liveness_debug_overlay);
        this.f54397l = (SwitchCompat) findViewById(R.id.iproov__debugOverlaySwitch);
        this.f54398m = findViewById(R.id.iproov__header);
        if (this.f54402q.f53992ui.floatingPromptEnabled) {
            this.f54392g.setVisibility(0);
            this.f54391f.setVisibility(8);
            this.f54390e = this.f54392g;
        } else {
            this.f54390e = this.f54391f;
        }
        m39312a(this.f54390e, -1);
    }

    /* renamed from: i */
    private void m39327i() {
        int i = 0;
        this.f54394i.setVisibility(this.f54405t.m46148const() ? 0 : 4);
        ImageView imageView = this.f54388c;
        if (!this.f54405t.m46148const()) {
            i = 4;
        }
        imageView.setVisibility(i);
    }

    /* renamed from: j */
    private void m39328j() {
        if (!this.f54402q.f53992ui.orientation.isPortrait()) {
            this.f54393h.setMaxLines(1);
        }
        int i = 0;
        this.f54388c.setVisibility(this.f54405t.m46147class() ? 0 : 4);
        this.f54397l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C19923do.this.m39311a(compoundButton, z);
            }
        });
        this.f54397l.setChecked(this.f54405t.m46148const());
        SwitchCompat switchCompat = this.f54397l;
        if (!this.f54405t.m46147class()) {
            i = 8;
        }
        switchCompat.setVisibility(i);
        m39327i();
    }

    /* renamed from: k */
    private void m39329k() {
        Typeface typeface;
        IProov.Options.C19751UI ui = this.f54402q.f53992ui;
        int i = ui.fontResource;
        if (i != -1) {
            typeface = C3114const.m4020do((Context) this, i);
        } else {
            String str = ui.fontPath;
            typeface = (str == null || str.isEmpty()) ? null : C3114const.m4021do((Context) this, this.f54402q.f53992ui.fontPath);
        }
        if (typeface != null) {
            C3114const.m4022do(this.f54390e, typeface);
            C3114const.m4022do(this.f54393h, typeface);
        }
    }

    /* renamed from: l */
    private void m39330l() {
        m39338t();
        this.f54390e.announceForAccessibility(Integer.toString(3));
        this.f54404s = new C19924do(2000, 1000).start();
        this.f54395j.mo162212do(33, 2000);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m39331m() {
        CountDownTimer countDownTimer = this.f54404s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f54404s = null;
        }
        m39338t();
    }

    /* renamed from: n */
    private void m39332n() {
        this.f54395j.mo162212do(0, 100);
    }

    /* renamed from: o */
    private void m39333o() {
        this.f54399n.m47637for(C20831for.C20832do.START_FLASHING);
        m39317b((int) R.string.iproov__prompt_scanning);
        mo162173do(C19925for.GPA_FLASHING_STARTING);
        mo162170b();
        ((View) this.f54393h.getParent()).setVisibility(4);
        this.f54392g.setTextColor(0);
        this.f54392g.setBackgroundColor(0);
        this.f54392g.setVisibility(8);
    }

    /* renamed from: p */
    private void m39334p() {
        mo162169a();
        mo162170b();
        this.f54407v = new C3118final(1000, false, new Runnable() {
            public final void run() {
                C19923do.this.m39340v();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m39335q() {
        this.f54408w.mo38620do();
        m39336r();
        this.f54408w = new C3118final(2000, true, new Runnable() {
            public final void run() {
                C19923do.this.m39336r();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m39336r() {
        if (this.f54409x == null) {
            this.f54409x = AnimationUtils.loadAnimation(this, this.f54402q.f53992ui.floatingPromptEnabled ? R.anim.iproov__pop : R.anim.iproov__wiggle);
        }
        this.f54390e.startAnimation(this.f54409x);
    }

    /* renamed from: s */
    private void m39337s() {
        this.f54385B = (AccessibilityManager) getSystemService("accessibility");
    }

    /* renamed from: t */
    private void m39338t() {
        if (this.f54385B == null) {
            m39337s();
        }
        AccessibilityManager accessibilityManager = this.f54385B;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            this.f54385B.interrupt();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void m39339u() {
        this.f54386a.setScanLineType(C19931do.INSIDE_OVAL_ONLY);
        this.f54386a.mo162201if(true, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void m39340v() {
        mo162173do(C19925for.LIVENESS_STOP_SCAN);
        mo162171c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo162169a() {
        C3118final finalR = this.f54407v;
        if (finalR != null) {
            finalR.mo38620do();
            this.f54407v = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo162170b() {
        C3118final finalR = this.f54408w;
        if (finalR != null) {
            finalR.mo38620do();
            this.f54408w = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo162171c() {
        mo162170b();
        boolean z = this.f54400o.m47525new() == C20994do.LIVENESS;
        if (!this.f54402q.f53992ui.floatingPromptEnabled && !z) {
            return;
        }
        if (z) {
            this.f54408w = new C3118final(Const.DELAY_TIME4LAST_GPS_TASK, false, new Runnable() {
                public final void run() {
                    C19923do.this.m39335q();
                }
            });
            return;
        }
        m39336r();
        this.f54408w = new C3118final(2000, true, new Runnable() {
            public final void run() {
                C19923do.this.m39336r();
            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f54406u.onTouchEvent(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: do */
    public void mo38695do(C3138if ifVar) {
    }

    public void finish() {
        mo162169a();
        mo162170b();
        m39331m();
        this.f54400o.mo162098do((C3014do) null);
        super.finish();
    }

    public void onBackPressed() {
        this.f54400o.m47523class();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        C19889if captureManager = IProov.getCaptureManager();
        this.f54400o = captureManager;
        if (captureManager != null) {
            this.f54402q = captureManager.m47528try();
            super.onCreate(bundle);
            this.f54405t = new C2381if(this);
            this.f54406u = new GestureDetector(this, new C19927new(this, (C19924do) null));
            setContentView(R.layout.iproov__activity_iproov);
            m39326h();
            this.f54400o.mo162098do((C3014do) this);
            m39328j();
            m39329k();
            m39324f();
            m39325g();
            this.f54400o.mo162097do(this.f54410y);
            this.f54410y.setBackgroundColor(this.f54402q.f53992ui.backgroundColor);
            m39337s();
            return;
        }
        throw new IllegalStateException("Error launching iProov. A common cause of this error is launching iProov from an Activity with android:launchMode=\"singleInstance\". Please either change the launchMode in AndroidManifest.xml, or consider using Option.ui.activityCompatibilityRequestCode and read the FAQ (https://github.com/iProov/android/wiki/Frequently-Asked-Questions).");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f54400o.mo162098do((C3014do) null);
        m39321d();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (!isFinishing() && !this.f54403r) {
            this.f54400o.m47523class();
        }
        this.f54403r = false;
        super.onPause();
        this.f54410y.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 2001 && iArr.length > 0) {
            if (iArr[0] == 0) {
                this.f54400o.m47522catch();
            } else {
                this.f54400o.m47521break();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f54410y.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f54401p.mo170680if(false);
        this.f54401p.mo170679do(false);
        super.onStop();
    }

    /* renamed from: a */
    private void m39309a(int i) {
        PaintDrawable paintDrawable = (PaintDrawable) this.f54392g.getBackground();
        if (paintDrawable != null) {
            paintDrawable.getPaint().setColor(i);
        }
    }

    /* renamed from: b */
    private void m39317b(int i) {
        m39310a(i, true);
    }

    /* renamed from: new  reason: not valid java name */
    public Orientation m47549new() {
        return Orientation.findByDegrees(getWindowManager().getDefaultDisplay().getRotation() * 90);
    }

    /* renamed from: try  reason: not valid java name */
    public void m47550try() {
        int i = C19926if.f54416do[this.f54384A.ordinal()];
        if (i == 1) {
            mo162173do(C19925for.GPA_SUPPLEMENTARY_FRAME);
        } else if (i == 2) {
            mo162173do(C19925for.LIVENESS_SUPPLEMENTARY_FRAME);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39311a(CompoundButton compoundButton, boolean z) {
        this.f54405t.mo23986do(z);
        this.f54400o.m47526static();
        m39327i();
    }

    /* renamed from: for  reason: not valid java name */
    public void m47548for() {
        this.f54399n.m47637for(C20831for.C20832do.FACE_FOUND);
    }

    /* renamed from: a */
    private void m39314a(String str) {
        this.f54393h.setVisibility(0);
        if (!str.equals(this.f54393h.getText().toString())) {
            this.f54393h.announceForAccessibility(str);
        }
        this.f54393h.setText(str);
    }

    /* renamed from: a */
    private void m39312a(TextView textView, int i) {
        if (i == -1) {
            textView.setText("");
            textView.setVisibility(4);
            return;
        }
        textView.setText(i);
        textView.setVisibility(0);
    }

    /* renamed from: a */
    private void m39310a(int i, boolean z) {
        String string = i != -1 ? getString(i) : "";
        boolean z2 = true;
        boolean z3 = !string.equals(this.f54390e.getText().toString());
        if (i == -1) {
            z2 = false;
        }
        if (z3) {
            if (z && z2) {
                m39338t();
                this.f54390e.announceForAccessibility(string);
            }
            m39312a(this.f54390e, i);
            if (z2) {
                mo162171c();
            }
        }
    }

    /* renamed from: if */
    public LivenessDebugOverlay mo38441if() {
        return this.f54396k;
    }

    /* renamed from: a */
    private void m39313a(IProov.Options.C19751UI ui) {
        if (ui.logoImageResource != -1) {
            this.f54389d.setImageResource(this.f54402q.f53992ui.logoImageResource);
        } else if (ui.logoImageDrawable != null) {
            this.f54389d.setImageDrawable(this.f54402q.f53992ui.logoImageDrawable);
        }
    }

    /* renamed from: do */
    public void mo38438do(String str) {
        if (this.f54405t.m46148const()) {
            this.f54394i.setText(str);
        }
    }

    /* renamed from: do */
    public void mo38436do(Bitmap bitmap) {
        if (bitmap == null) {
            this.f54388c.setVisibility(4);
            return;
        }
        this.f54388c.setVisibility(0);
        this.f54388c.setImageBitmap(bitmap);
        this.f54388c.destroyDrawingCache();
    }

    /* renamed from: do */
    public void mo38434do() {
        if (ContextCompat.checkSelfPermission(this, Permission.CAMERA) != 0) {
            this.f54403r = true;
        }
        ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA}, 2001);
    }

    /* renamed from: do */
    public void mo38435do(double d) {
        this.f54401p.mo170678do((float) d);
    }

    /* renamed from: do */
    public void mo38437do(C20994do doVar, boolean z) {
        this.f54384A = doVar;
        if (doVar == C20994do.GENUINE_PRESENCE_ASSURANCE) {
            if (z) {
                mo162173do(C19925for.GPA_INIT_SUPPLEMENTARY);
            } else {
                mo162173do(C19925for.GPA_INIT_NO_SUPPLEMENTARY);
            }
        }
        if (doVar == C20994do.LIVENESS) {
            mo162173do(C19925for.LIVENESS_INIT);
        }
    }

    /* renamed from: do */
    public void mo38439do(boolean z) {
        if (z) {
            mo162169a();
            mo162173do(C19925for.LIVENESS_FINISH);
            m39322e();
            return;
        }
        m39334p();
        mo162173do(C19925for.LIVENESS_SCAN);
    }

    /* renamed from: do */
    public void mo38693do(C3138if.C3146new newR) {
        this.f54393h.setVisibility(8);
        m39317b((int) R.string.iproov__prompt_connecting);
    }

    /* renamed from: do */
    public void mo38691do(C3138if.C3143for forR) {
        String str = forR.m46228new();
        if (str != null) {
            m39314a(str);
        }
        m39313a(this.f54402q.f53992ui);
    }

    /* renamed from: do */
    public void mo38692do(C3138if.C3145if ifVar) {
        C3136do doVar = ifVar.m46230new();
        int[] iArr = C19926if.f54417if;
        switch (iArr[doVar.ordinal()]) {
            case 1:
                mo162173do(C19925for.LIVENESS_FINISH);
                this.f54386a.mo162198do(new Runnable() {
                    public final void run() {
                        C19923do.this.finish();
                    }
                }, 600, 400);
                this.f54387b.mo162214do(600, 400);
                break;
            case 2:
                if (!this.f54402q.f53992ui.genuinePresenceAssurance.autoStartDisabled && this.f54404s == null) {
                    m39330l();
                }
                mo162173do(C19925for.GPA_FACE);
                this.f54399n.m47637for(C20831for.C20832do.FACE_FOUND);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                if (this.f54404s != null) {
                    m39331m();
                }
                m39332n();
                mo162173do(C19925for.GPA_NO_FACE);
                break;
        }
        switch (iArr[doVar.ordinal()]) {
            case 1:
                m39317b((int) R.string.iproov__prompt_liveness_scan_completed);
                return;
            case 2:
                if (this.f54402q.f53992ui.genuinePresenceAssurance.autoStartDisabled) {
                    m39317b((int) R.string.iproov__prompt_tap_to_begin);
                    return;
                } else {
                    m39310a((int) R.string.iproov__prompt_get_ready, false);
                    return;
                }
            case 3:
                m39317b((int) R.string.iproov__prompt_liveness_align_face);
                return;
            case 4:
                m39317b((int) R.string.iproov__prompt_liveness_no_target);
                return;
            case 5:
                m39317b((int) R.string.iproov__prompt_too_far);
                return;
            case 6:
                m39317b((int) R.string.iproov__prompt_too_close);
                return;
            case 7:
                m39317b((int) R.string.iproov__prompt_genuine_presence_align_face);
                return;
            case 8:
                m39317b((int) R.string.iproov__prompt_too_far);
                return;
            case 9:
                m39317b((int) R.string.iproov__prompt_too_close);
                return;
            case 10:
                m39317b((int) R.string.iproov__prompt_too_bright);
                return;
            case 11:
                m39317b((int) R.string.iproov__prompt_roll_too_high);
                return;
            case 12:
                m39317b((int) R.string.iproov__prompt_roll_too_low);
                return;
            case 13:
                m39317b((int) R.string.iproov__prompt_yaw_too_high);
                return;
            case 14:
                m39317b((int) R.string.iproov__prompt_yaw_too_low);
                return;
            case 15:
                m39317b((int) R.string.iproov__prompt_pitch_too_low);
                return;
            case 16:
                m39317b((int) R.string.iproov__prompt_pitch_too_high);
                return;
            default:
                return;
        }
    }

    /* renamed from: do */
    public void mo38690do(C3138if.C3142else elseR) {
        if (elseR.m46225else()) {
            m39333o();
            return;
        }
        this.f54395j.mo162212do((int) ((((double) elseR.m46224case()) * 66.6d) + 33.3d), (long) elseR.m46226new());
    }

    /* renamed from: do */
    public void mo38687do(C3138if.C3139break breakR) {
        if (this.f54400o.m47525new() == C20994do.GENUINE_PRESENCE_ASSURANCE) {
            finish();
        }
    }

    /* renamed from: do */
    public void mo38688do(C3138if.C3140case caseR) {
        finish();
    }

    /* renamed from: do */
    public void mo38694do(C3138if.C3148try tryR) {
        finish();
    }

    /* renamed from: do */
    public void mo38689do(C3138if.C3141do doVar) {
        finish();
    }

    /* renamed from: do */
    public void mo162173do(C19925for forR) {
        C19925for forR2 = this.f54411z;
        if (forR2 != forR) {
            if (forR != C19925for.LIVENESS_SUPPLEMENTARY_FRAME || (forR2 != C19925for.LIVENESS_SCAN && forR2 != C19925for.LIVENESS_STOP_SCAN && forR2 != C19925for.LIVENESS_FINISH)) {
                switch (C19926if.f61831for[forR.ordinal()]) {
                    case 1:
                        m39319c(this.f54402q.f53992ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f54386a.setBGColor(this.f54402q.f53992ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f54386a.setOvalVisible(true);
                        this.f54387b.setReticleVisible(true);
                        m39315a(false, false);
                        this.f54386a.mo162201if(false, false);
                        break;
                    case 2:
                        m39319c(this.f54402q.f53992ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f54386a.setBGColor(this.f54402q.f53992ui.genuinePresenceAssurance.notReadyTintColor);
                        break;
                    case 3:
                        this.f54386a.setScanLineType(C19931do.OUTSIDE_OVAL_ONLY);
                        this.f54386a.setOvalVisible(true);
                        this.f54387b.setReticleVisible(true);
                        m39315a(false, false);
                        this.f54386a.mo162201if(true, true);
                        break;
                    case 4:
                        m39319c(this.f54402q.f53992ui.genuinePresenceAssurance.readyTintColor);
                        this.f54386a.setBGColor(this.f54402q.f53992ui.genuinePresenceAssurance.readyTintColor);
                        this.f54387b.m47556for();
                        break;
                    case 5:
                        m39319c(this.f54402q.f53992ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f54386a.setBGColor(this.f54402q.f53992ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f54387b.m47555case();
                        break;
                    case 6:
                        m39319c(ContextCompat.getColor(this, R.color.iproov__white));
                        this.f54392g.setVisibility(4);
                        this.f54386a.setBGColor(ContextCompat.getColor(this, 17170445));
                        this.f54386a.mo162201if(false, true);
                        this.f54386a.setAlpha(0.5f);
                        this.f54387b.setReticleVisible(false);
                        break;
                    case 7:
                        m39319c(this.f54402q.f53992ui.livenessAssurance.primaryTintColor);
                        this.f54387b.setReticleVisible(true);
                        break;
                    case 8:
                        m39319c(this.f54402q.f53992ui.livenessAssurance.primaryTintColor);
                        this.f54386a.setBGColor(this.f54402q.f53992ui.livenessAssurance.secondaryTintColor);
                        this.f54386a.setScanLineType(C19931do.FULLSCREEN);
                        this.f54386a.setOvalVisible(false);
                        this.f54386a.mo162201if(true, true);
                        m39315a(false, false);
                        break;
                    case 9:
                        m39319c(this.f54402q.f53992ui.livenessAssurance.primaryTintColor);
                        this.f54386a.setBGColor(this.f54402q.f53992ui.livenessAssurance.secondaryTintColor);
                        m39315a(false, true);
                        this.f54386a.mo162197do(new Runnable() {
                            public final void run() {
                                C19923do.this.m39339u();
                            }
                        });
                        break;
                    case 10:
                        m39319c(this.f54402q.f53992ui.livenessAssurance.primaryTintColor);
                        this.f54386a.setBGColor(this.f54402q.f53992ui.livenessAssurance.secondaryTintColor);
                        this.f54386a.mo162201if(false, true);
                        m39315a(true, true);
                        break;
                    case 11:
                        m39319c(this.f54402q.f53992ui.livenessAssurance.primaryTintColor);
                        this.f54386a.setBGColor(this.f54402q.f53992ui.livenessAssurance.primaryTintColor);
                        this.f54386a.mo162201if(false, false);
                        m39315a(false, false);
                        this.f54387b.m47556for();
                        break;
                }
                this.f54411z = forR;
            }
        }
    }

    /* renamed from: c */
    private void m39319c(int i) {
        this.f54386a.setFGColor(i);
        this.f54387b.setColor(i);
        m39309a(i);
    }

    /* renamed from: a */
    private void m39315a(boolean z, boolean z2) {
        this.f54386a.mo162199do(z, z2);
        this.f54387b.mo162215do(z, z2);
    }
}
