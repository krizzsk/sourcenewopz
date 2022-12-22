package com.didichuxing.diface.biz.bioassay.fpp.util;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.megvii.livenessdetection.Detector;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class IDetection {

    /* renamed from: a */
    TextView f47233a;

    /* renamed from: b */
    String f47234b;

    /* renamed from: c */
    private View f47235c;

    /* renamed from: d */
    private Context f47236d;

    /* renamed from: e */
    private HashMap<Integer, Drawable> f47237e;
    public View[] mAnimViews;
    public int mCurShowIndex = -1;
    public ArrayList<Detector.DetectionType> mDetectionSteps;

    public IDetection(Context context, View view) {
        this.f47236d = context;
        this.f47235c = view;
        this.f47237e = new HashMap<>();
    }

    public void animationInit() {
        int[] iArr = {R.drawable.liveness_head_pitch, R.drawable.liveness_head_yaw, R.drawable.liveness_mouth_open_closed, R.drawable.liveness_eye_open_closed};
        int i = 0;
        while (i < 4) {
            int i2 = iArr[i];
            if (this.f47236d != null) {
                this.f47237e.put(Integer.valueOf(i2), this.f47236d.getResources().getDrawable(i2));
                i++;
            } else {
                return;
            }
        }
    }

    public void viewsInit() {
        View[] viewArr = new View[2];
        this.mAnimViews = viewArr;
        viewArr[0] = this.f47235c.findViewById(R.id.liveness_layout_first_layout);
        this.mAnimViews[1] = this.f47235c.findViewById(R.id.liveness_layout_second_layout);
        for (View visibility : this.mAnimViews) {
            visibility.setVisibility(4);
        }
    }

    public void changeType(Detector.DetectionType detectionType, long j) {
        Context context = this.f47236d;
        if (context != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.liveness_rightin);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f47236d, R.anim.liveness_leftout);
            int i = this.mCurShowIndex;
            if (i != -1) {
                this.mAnimViews[i].setVisibility(4);
                this.mAnimViews[this.mCurShowIndex].setAnimation(loadAnimation2);
            } else {
                this.mAnimViews[0].setVisibility(4);
                this.mAnimViews[0].startAnimation(loadAnimation2);
            }
            int i2 = this.mCurShowIndex;
            int i3 = (i2 != -1 && i2 == 0) ? 1 : 0;
            this.mCurShowIndex = i3;
            m33879a(detectionType, this.mAnimViews[i3]);
            this.mAnimViews[this.mCurShowIndex].setVisibility(0);
            this.mAnimViews[this.mCurShowIndex].startAnimation(loadAnimation);
        }
    }

    /* renamed from: a */
    private void m33879a(Detector.DetectionType detectionType, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.detection_step_image);
        imageView.setImageDrawable(m33878a(detectionType));
        ((AnimationDrawable) imageView.getDrawable()).start();
        this.f47233a = (TextView) view.findViewById(R.id.detection_step_name);
        String b = m33880b(detectionType);
        this.f47234b = b;
        this.f47233a.setText(b);
    }

    public void checkFaceTooLarge(boolean z) {
        TextView textView;
        if (this.f47236d != null && this.f47234b != null && (textView = this.f47233a) != null) {
            if (z && !textView.getText().toString().equals(this.f47236d.getString(R.string.face_too_large))) {
                this.f47233a.setText(R.string.face_too_large);
            } else if (!z && this.f47233a.getText().toString().equals(this.f47236d.getString(R.string.face_too_large))) {
                this.f47233a.setText(this.f47234b);
            }
        }
    }

    /* renamed from: com.didichuxing.diface.biz.bioassay.fpp.util.IDetection$1 */
    static /* synthetic */ class C154441 {
        static final /* synthetic */ int[] $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.megvii.livenessdetection.Detector$DetectionType[] r0 = com.megvii.livenessdetection.Detector.DetectionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType = r0
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_PITCH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_PITCH_UP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_PITCH_DOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW_LEFT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW_RIGHT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.MOUTH     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$megvii$livenessdetection$Detector$DetectionType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = com.megvii.livenessdetection.Detector.DetectionType.BLINK     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.fpp.util.IDetection.C154441.<clinit>():void");
        }
    }

    /* renamed from: a */
    private Drawable m33878a(Detector.DetectionType detectionType) {
        int i;
        switch (C154441.$SwitchMap$com$megvii$livenessdetection$Detector$DetectionType[detectionType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                i = R.drawable.liveness_head_pitch;
                break;
            case 4:
            case 5:
            case 6:
                i = R.drawable.liveness_head_yaw;
                break;
            case 7:
                i = R.drawable.liveness_mouth_open_closed;
                break;
            case 8:
                i = R.drawable.liveness_eye_open_closed;
                break;
            default:
                i = -1;
                break;
        }
        Drawable drawable = this.f47237e.get(Integer.valueOf(i));
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = this.f47236d.getResources().getDrawable(i);
        this.f47237e.put(Integer.valueOf(i), drawable2);
        return drawable2;
    }

    /* renamed from: b */
    private String m33880b(Detector.DetectionType detectionType) {
        if (this.f47236d == null) {
            return "";
        }
        int i = C154441.$SwitchMap$com$megvii$livenessdetection$Detector$DetectionType[detectionType.ordinal()];
        if (i == 1) {
            return this.f47236d.getString(R.string.meglive_pitch);
        }
        switch (i) {
            case 4:
                return this.f47236d.getString(R.string.meglive_pos_yaw_left);
            case 5:
                return this.f47236d.getString(R.string.meglive_pos_yaw_right);
            case 6:
                return this.f47236d.getString(R.string.meglive_yaw);
            case 7:
                return this.f47236d.getString(R.string.meglive_mouth_open_closed);
            case 8:
                return this.f47236d.getString(R.string.meglive_eye_open_closed);
            default:
                return null;
        }
    }

    public void detectionTypeInit() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Detector.DetectionType.BLINK);
        arrayList.add(Detector.DetectionType.MOUTH);
        arrayList.add(Detector.DetectionType.POS_PITCH);
        arrayList.add(Detector.DetectionType.POS_YAW);
        Collections.shuffle(arrayList);
        this.mDetectionSteps = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            this.mDetectionSteps.add(arrayList.get(i));
        }
    }

    public void detectionTypeInit(int[] iArr) {
        this.mDetectionSteps = new ArrayList<>(iArr.length);
        for (int i : iArr) {
            this.mDetectionSteps.add(Detector.DetectionType.values()[i]);
        }
    }

    public void onDestroy() {
        this.f47235c = null;
        this.f47236d = null;
        HashMap<Integer, Drawable> hashMap = this.f47237e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
