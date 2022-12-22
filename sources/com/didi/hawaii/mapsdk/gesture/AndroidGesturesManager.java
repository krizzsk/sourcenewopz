package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import com.didi.hawaii.mapsdk.gesture.MoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.MultiFingerTapGestureDetector;
import com.didi.hawaii.mapsdk.gesture.RotateGestureDetector;
import com.didi.hawaii.mapsdk.gesture.ShoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.SidewaysShoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.StandardGestureDetector;
import com.didi.hawaii.mapsdk.gesture.StandardScaleGestureDetector;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AndroidGesturesManager {
    public static final int GESTURE_TYPE_DOUBLE_TAP = 10;
    public static final int GESTURE_TYPE_DOUBLE_TAP_EVENT = 11;
    public static final int GESTURE_TYPE_DOWN = 9;
    public static final int GESTURE_TYPE_FLING = 7;
    public static final int GESTURE_TYPE_LONG_PRESS = 6;
    public static final int GESTURE_TYPE_MOVE = 13;
    public static final int GESTURE_TYPE_MULTI_FINGER_TAP = 4;
    public static final int GESTURE_TYPE_ROTATE = 2;
    public static final int GESTURE_TYPE_SCALE = 1;
    public static final int GESTURE_TYPE_SCROLL = 0;
    public static final int GESTURE_TYPE_SHOVE = 3;
    public static final int GESTURE_TYPE_SHOW_PRESS = 8;
    public static final int GESTURE_TYPE_SIDEWAYS_SHOVE = 14;
    public static final int GESTURE_TYPE_SINGLE_TAP_CONFIRMED = 12;
    public static final int GESTURE_TYPE_SINGLE_TAP_UP = 5;

    /* renamed from: a */
    private static final int f23488a = 255;

    /* renamed from: b */
    private static final int f23489b = 5;

    /* renamed from: c */
    private static final int f23490c = 6;

    /* renamed from: d */
    private final List<Set<Integer>> f23491d = new ArrayList();

    /* renamed from: e */
    private final List<BaseGesture> f23492e = new ArrayList();

    /* renamed from: f */
    private final StandardGestureDetector f23493f;

    /* renamed from: g */
    private final StandardScaleGestureDetector f23494g;

    /* renamed from: h */
    private final RotateGestureDetector f23495h;

    /* renamed from: i */
    private final ShoveGestureDetector f23496i;

    /* renamed from: j */
    private final MultiFingerTapGestureDetector f23497j;

    /* renamed from: k */
    private final MoveGestureDetector f23498k;

    /* renamed from: l */
    private final SidewaysShoveGestureDetector f23499l;

    /* renamed from: m */
    private NNGestureClassfy f23500m;

    /* renamed from: n */
    private AndroidGestureOption f23501n;

    /* renamed from: o */
    private boolean f23502o = false;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureType {
    }

    public AndroidGesturesManager(Context context, AndroidGestureOption androidGestureOption) {
        this.f23495h = new RotateGestureDetector(context, this);
        this.f23494g = new StandardScaleGestureDetector(context, this);
        this.f23496i = new ShoveGestureDetector(context, this);
        this.f23499l = new SidewaysShoveGestureDetector(context, this);
        this.f23497j = new MultiFingerTapGestureDetector(context, this);
        this.f23498k = new MoveGestureDetector(context, this);
        this.f23493f = new StandardGestureDetector(context, this);
        this.f23492e.add(this.f23496i);
        this.f23492e.add(this.f23495h);
        this.f23492e.add(this.f23498k);
        this.f23492e.add(this.f23494g);
        this.f23492e.add(this.f23499l);
        this.f23492e.add(this.f23497j);
        this.f23492e.add(this.f23493f);
        if (androidGestureOption != null) {
            if (androidGestureOption.exclusiveGestures != null && androidGestureOption.exclusiveGestures.size() > 0) {
                this.f23491d.addAll(androidGestureOption.exclusiveGestures);
            }
            if (androidGestureOption.useNNClassfy) {
                this.f23500m = new NNGestureClassfy();
            } else {
                Constants.m16786a();
            }
            if (androidGestureOption.applyDefaultThresholds) {
                m16784a();
            }
            this.f23501n = androidGestureOption;
        }
    }

    /* renamed from: a */
    private void m16784a() {
        for (BaseGesture next : this.f23492e) {
            boolean z = next instanceof MultiFingerTapGestureDetector;
            if (z) {
                ((MultiFingerGesture) next).setSpanThresholdResource(R.dimen.dmap_defaultMutliFingerSpanThreshold);
            }
            if (next instanceof StandardScaleGestureDetector) {
                ((StandardScaleGestureDetector) next).setSpanSinceStartThreshold((float) Constants.DEFAULT_SCALE_SPAN_START);
            }
            if (next instanceof MoveGestureDetector) {
                ((MoveGestureDetector) next).setMoveThresholdResource(R.dimen.min_multi_move_distance);
            }
            if (next instanceof ShoveGestureDetector) {
                ShoveGestureDetector shoveGestureDetector = (ShoveGestureDetector) next;
                shoveGestureDetector.setPixelDeltaThresholdResource(R.dimen.dmap_defaultShovePixelThreshold);
                shoveGestureDetector.setMaxShoveAngle(20.0f);
                shoveGestureDetector.setDeltTwoFingerCloser(R.dimen.dmap_shove_y_threshold);
            }
            if (next instanceof SidewaysShoveGestureDetector) {
                SidewaysShoveGestureDetector sidewaysShoveGestureDetector = (SidewaysShoveGestureDetector) next;
                sidewaysShoveGestureDetector.setPixelDeltaThresholdResource(R.dimen.dmap_defaultShovePixelThreshold);
                sidewaysShoveGestureDetector.setMaxShoveAngle(20.0f);
            }
            if (z) {
                MultiFingerTapGestureDetector multiFingerTapGestureDetector = (MultiFingerTapGestureDetector) next;
                multiFingerTapGestureDetector.setMultiFingerTapMovementThresholdResource(R.dimen.dmap_defaultMultiTapMovementThreshold);
                multiFingerTapGestureDetector.setMultiFingerTapTimeThreshold(150);
            }
            if (next instanceof RotateGestureDetector) {
                ((RotateGestureDetector) next).setAngleThreshold(Constants.DEFAULT_ROTATE_ANGLE_THRESHOLD);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NNGestureClassfy nNGestureClassfy = this.f23500m;
        if (nNGestureClassfy != null) {
            nNGestureClassfy.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f23502o = false;
        } else if (action == 5) {
            this.f23502o = true;
        }
        for (BaseGesture next : this.f23492e) {
            if (!(next instanceof StandardGestureDetector) || !this.f23502o || action != 2) {
                next.onTouchEvent(motionEvent);
            }
        }
        return true;
    }

    public void setStandardGestureListener(StandardGestureDetector.StandardOnGestureListener standardOnGestureListener) {
        this.f23493f.setListener(standardOnGestureListener);
    }

    public void removeStandardGestureListener() {
        this.f23493f.removeListener();
    }

    public void setStandardScaleGestureListener(StandardScaleGestureDetector.StandardOnScaleGestureListener standardOnScaleGestureListener) {
        this.f23494g.setListener(standardOnScaleGestureListener);
    }

    public void removeStandardScaleGestureListener() {
        this.f23494g.removeListener();
    }

    public void setRotateGestureListener(RotateGestureDetector.OnRotateGestureListener onRotateGestureListener) {
        this.f23495h.setListener(onRotateGestureListener);
    }

    public void removeRotateGestureListener() {
        this.f23495h.removeListener();
    }

    public void setShoveGestureListener(ShoveGestureDetector.OnShoveGestureListener onShoveGestureListener) {
        this.f23496i.setListener(onShoveGestureListener);
    }

    public void removeShoveGestureListener() {
        this.f23496i.removeListener();
    }

    public void setMultiFingerTapGestureListener(MultiFingerTapGestureDetector.OnMultiFingerTapGestureListener onMultiFingerTapGestureListener) {
        this.f23497j.setListener(onMultiFingerTapGestureListener);
    }

    public void removeMultiFingerTapGestureListener() {
        this.f23497j.removeListener();
    }

    public void setMoveGestureListener(MoveGestureDetector.OnMoveGestureListener onMoveGestureListener) {
        this.f23498k.setListener(onMoveGestureListener);
    }

    public void removeMoveGestureListener() {
        this.f23498k.removeListener();
    }

    public void setSidewaysShoveGestureListener(SidewaysShoveGestureDetector.OnSidewaysShoveGestureListener onSidewaysShoveGestureListener) {
        this.f23499l.setListener(onSidewaysShoveGestureListener);
    }

    public void removeSidewaysShoveGestureListener() {
        this.f23499l.removeListener();
    }

    public List<BaseGesture> getDetectors() {
        return this.f23492e;
    }

    public StandardGestureDetector getStandardGestureDetector() {
        return this.f23493f;
    }

    public StandardScaleGestureDetector getStandardScaleGestureDetector() {
        return this.f23494g;
    }

    public RotateGestureDetector getRotateGestureDetector() {
        return this.f23495h;
    }

    public ShoveGestureDetector getShoveGestureDetector() {
        return this.f23496i;
    }

    public MultiFingerTapGestureDetector getMultiFingerTapGestureDetector() {
        return this.f23497j;
    }

    public MoveGestureDetector getMoveGestureDetector() {
        return this.f23498k;
    }

    public SidewaysShoveGestureDetector getSidewaysShoveGestureDetector() {
        return this.f23499l;
    }

    @SafeVarargs
    public final void setMutuallyExclusiveGestures(Set<Integer>... setArr) {
        setMutuallyExclusiveGestures((List<Set<Integer>>) Arrays.asList(setArr));
    }

    public void setMutuallyExclusiveGestures(List<Set<Integer>> list) {
        this.f23491d.clear();
        this.f23491d.addAll(list);
    }

    public List<Set<Integer>> getMutuallyExclusiveGestures() {
        return this.f23491d;
    }

    public boolean useNNClassfy() {
        AndroidGestureOption androidGestureOption = this.f23501n;
        return androidGestureOption != null && androidGestureOption.useNNClassfy;
    }

    public Pair<String, Float> getClassFyResult() {
        if (this.f23500m != null) {
            return new Pair<>(this.f23500m.getLable(), Float.valueOf(this.f23500m.getCurAngle()));
        }
        return null;
    }
}
