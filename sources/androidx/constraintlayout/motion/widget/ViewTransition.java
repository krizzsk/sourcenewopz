package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.C0273R;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class ViewTransition {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    static final int LINEAR = 3;
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static String TAG = "ViewTransition";
    private static final int UNSET = -1;
    static final int VIEWTRANSITIONMODE_ALLSTATES = 1;
    static final int VIEWTRANSITIONMODE_CURRENTSTATE = 0;
    static final int VIEWTRANSITIONMODE_NOSTATE = 2;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";
    private int mClearsTag = -1;
    ConstraintSet.Constraint mConstraintDelta;
    Context mContext;
    private int mDefaultInterpolator = 0;
    private int mDefaultInterpolatorID = -1;
    private String mDefaultInterpolatorString = null;
    private boolean mDisabled = false;
    private int mDuration = -1;
    private int mId;
    private int mIfTagNotSet = -1;
    private int mIfTagSet = -1;
    KeyFrames mKeyFrames;
    private int mOnStateTransition = -1;
    private int mPathMotionArc = 0;
    private int mSetsTag = -1;
    private int mSharedValueCurrent = -1;
    private int mSharedValueID = -1;
    private int mSharedValueTarget = -1;
    private int mTargetId;
    private String mTargetString;
    private int mUpDuration = -1;
    int mViewTransitionMode;
    ConstraintSet set;

    public int getSharedValueCurrent() {
        return this.mSharedValueCurrent;
    }

    public void setSharedValueCurrent(int i) {
        this.mSharedValueCurrent = i;
    }

    public int getStateTransition() {
        return this.mOnStateTransition;
    }

    public void setStateTransition(int i) {
        this.mOnStateTransition = i;
    }

    public int getSharedValue() {
        return this.mSharedValueTarget;
    }

    public void setSharedValue(int i) {
        this.mSharedValueTarget = i;
    }

    public int getSharedValueID() {
        return this.mSharedValueID;
    }

    public void setSharedValueID(int i) {
        this.mSharedValueID = i;
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.mContext, this.mId) + ")";
    }

    /* access modifiers changed from: package-private */
    public Interpolator getInterpolator(Context context) {
        int i = this.mDefaultInterpolator;
        if (i == -2) {
            return AnimationUtils.loadInterpolator(context, this.mDefaultInterpolatorID);
        }
        if (i == -1) {
            final Easing interpolator = Easing.getInterpolator(this.mDefaultInterpolatorString);
            return new Interpolator() {
                public float getInterpolation(float f) {
                    return (float) interpolator.get((double) f);
                }
            };
        } else if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i == 1) {
                return new AccelerateInterpolator();
            }
            if (i == 2) {
                return new DecelerateInterpolator();
            }
            if (i == 4) {
                return new BounceInterpolator();
            }
            if (i == 5) {
                return new OvershootInterpolator();
            }
            if (i != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ViewTransition(android.content.Context r19, org.xmlpull.v1.XmlPullParser r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            r18.<init>()
            r3 = -1
            r1.mOnStateTransition = r3
            r4 = 0
            r1.mDisabled = r4
            r1.mPathMotionArc = r4
            r1.mDuration = r3
            r1.mUpDuration = r3
            r1.mDefaultInterpolator = r4
            r5 = 0
            r1.mDefaultInterpolatorString = r5
            r1.mDefaultInterpolatorID = r3
            r1.mSetsTag = r3
            r1.mClearsTag = r3
            r1.mIfTagSet = r3
            r1.mIfTagNotSet = r3
            r1.mSharedValueTarget = r3
            r1.mSharedValueID = r3
            r1.mSharedValueCurrent = r3
            r1.mContext = r0
            int r5 = r20.getEventType()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
        L_0x0030:
            r6 = 1
            if (r5 == r6) goto L_0x00fd
            java.lang.String r7 = "ViewTransition"
            r8 = 3
            r9 = 2
            if (r5 == r9) goto L_0x0048
            if (r5 == r8) goto L_0x003d
            goto L_0x00ee
        L_0x003d:
            java.lang.String r5 = r20.getName()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            boolean r5 = r7.equals(r5)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            if (r5 == 0) goto L_0x00ee
            return
        L_0x0048:
            java.lang.String r5 = r20.getName()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            int r10 = r5.hashCode()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r11 = 4
            switch(r10) {
                case -1962203927: goto L_0x007b;
                case -1239391468: goto L_0x0071;
                case 61998586: goto L_0x0069;
                case 366511058: goto L_0x005f;
                case 1791837707: goto L_0x0055;
                default: goto L_0x0054;
            }     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
        L_0x0054:
            goto L_0x0085
        L_0x0055:
            java.lang.String r7 = "CustomAttribute"
            boolean r7 = r5.equals(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            if (r7 == 0) goto L_0x0085
            r7 = 3
            goto L_0x0086
        L_0x005f:
            java.lang.String r7 = "CustomMethod"
            boolean r7 = r5.equals(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            if (r7 == 0) goto L_0x0085
            r7 = 4
            goto L_0x0086
        L_0x0069:
            boolean r7 = r5.equals(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            if (r7 == 0) goto L_0x0085
            r7 = 0
            goto L_0x0086
        L_0x0071:
            java.lang.String r7 = "KeyFrameSet"
            boolean r7 = r5.equals(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            if (r7 == 0) goto L_0x0085
            r7 = 1
            goto L_0x0086
        L_0x007b:
            java.lang.String r7 = "ConstraintOverride"
            boolean r7 = r5.equals(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            if (r7 == 0) goto L_0x0085
            r7 = 2
            goto L_0x0086
        L_0x0085:
            r7 = -1
        L_0x0086:
            if (r7 == 0) goto L_0x00eb
            if (r7 == r6) goto L_0x00e3
            if (r7 == r9) goto L_0x00dc
            if (r7 == r8) goto L_0x00d4
            if (r7 == r11) goto L_0x00d4
            java.lang.String r13 = TAG     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r7 = androidx.constraintlayout.motion.widget.Debug.getLoc()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r7 = " unknown tag "
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r6.append(r5)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r14 = r6.toString()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r12 = 6
            r15 = 0
            java.lang.String r16 = "androidx.constraintlayout.motion.widget.ViewTransition"
            r17 = 240(0xf0, float:3.36E-43)
            com.didi.sdk.apm.SystemUtils.log(r12, r13, r14, r15, r16, r17)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r6 = TAG     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r7 = ".xml:"
            r5.append(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            int r7 = r20.getLineNumber()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r5.append(r7)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r7 = r5.toString()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r5 = 6
            r8 = 0
            java.lang.String r9 = "androidx.constraintlayout.motion.widget.ViewTransition"
            r10 = 241(0xf1, float:3.38E-43)
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            goto L_0x00ee
        L_0x00d4:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r5 = r1.mConstraintDelta     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r5 = r5.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r0, r2, r5)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            goto L_0x00ee
        L_0x00dc:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r5 = androidx.constraintlayout.widget.ConstraintSet.buildDelta(r19, r20)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r1.mConstraintDelta = r5     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            goto L_0x00ee
        L_0x00e3:
            androidx.constraintlayout.motion.widget.KeyFrames r5 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r5.<init>(r0, r2)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            r1.mKeyFrames = r5     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            goto L_0x00ee
        L_0x00eb:
            r18.parseViewTransitionTags(r19, r20)     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
        L_0x00ee:
            int r5 = r20.next()     // Catch:{ XmlPullParserException -> 0x00f9, IOException -> 0x00f4 }
            goto L_0x0030
        L_0x00f4:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00fd
        L_0x00f9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    private void parseViewTransitionTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0273R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C0273R.styleable.ViewTransition_android_id) {
                this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
            } else if (index == C0273R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    this.mTargetId = resourceId;
                    if (resourceId == -1) {
                        this.mTargetString = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.mTargetString = obtainStyledAttributes.getString(index);
                } else {
                    this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                }
            } else if (index == C0273R.styleable.ViewTransition_onStateTransition) {
                this.mOnStateTransition = obtainStyledAttributes.getInt(index, this.mOnStateTransition);
            } else if (index == C0273R.styleable.ViewTransition_transitionDisable) {
                this.mDisabled = obtainStyledAttributes.getBoolean(index, this.mDisabled);
            } else if (index == C0273R.styleable.ViewTransition_pathMotionArc) {
                this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
            } else if (index == C0273R.styleable.ViewTransition_duration) {
                this.mDuration = obtainStyledAttributes.getInt(index, this.mDuration);
            } else if (index == C0273R.styleable.ViewTransition_upDuration) {
                this.mUpDuration = obtainStyledAttributes.getInt(index, this.mUpDuration);
            } else if (index == C0273R.styleable.ViewTransition_viewTransitionMode) {
                this.mViewTransitionMode = obtainStyledAttributes.getInt(index, this.mViewTransitionMode);
            } else if (index == C0273R.styleable.ViewTransition_motionInterpolator) {
                TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                if (peekValue.type == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.mDefaultInterpolatorID = resourceId2;
                    if (resourceId2 != -1) {
                        this.mDefaultInterpolator = -2;
                    }
                } else if (peekValue.type == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mDefaultInterpolatorString = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.mDefaultInterpolator = -1;
                    } else {
                        this.mDefaultInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                        this.mDefaultInterpolator = -2;
                    }
                } else {
                    this.mDefaultInterpolator = obtainStyledAttributes.getInteger(index, this.mDefaultInterpolator);
                }
            } else if (index == C0273R.styleable.ViewTransition_setsTag) {
                this.mSetsTag = obtainStyledAttributes.getResourceId(index, this.mSetsTag);
            } else if (index == C0273R.styleable.ViewTransition_clearsTag) {
                this.mClearsTag = obtainStyledAttributes.getResourceId(index, this.mClearsTag);
            } else if (index == C0273R.styleable.ViewTransition_ifTagSet) {
                this.mIfTagSet = obtainStyledAttributes.getResourceId(index, this.mIfTagSet);
            } else if (index == C0273R.styleable.ViewTransition_ifTagNotSet) {
                this.mIfTagNotSet = obtainStyledAttributes.getResourceId(index, this.mIfTagNotSet);
            } else if (index == C0273R.styleable.ViewTransition_SharedValueId) {
                this.mSharedValueID = obtainStyledAttributes.getResourceId(index, this.mSharedValueID);
            } else if (index == C0273R.styleable.ViewTransition_SharedValue) {
                this.mSharedValueTarget = obtainStyledAttributes.getInteger(index, this.mSharedValueTarget);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void applyIndependentTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.setBothStates(view);
        this.mKeyFrames.addAllFrames(motionController);
        motionController.setup(motionLayout.getWidth(), motionLayout.getHeight(), (float) this.mDuration, System.nanoTime());
        ViewTransitionController viewTransitionController2 = viewTransitionController;
        MotionController motionController2 = motionController;
        new Animate(viewTransitionController2, motionController2, this.mDuration, this.mUpDuration, this.mOnStateTransition, getInterpolator(motionLayout.getContext()), this.mSetsTag, this.mClearsTag);
    }

    static class Animate {
        boolean hold_at_100 = false;
        KeyCache mCache = new KeyCache();
        private final int mClearsTag;
        float mDpositionDt;
        int mDuration;
        Interpolator mInterpolator;
        long mLastRender;
        MotionController mMC;
        float mPosition;
        private final int mSetsTag;
        long mStart;
        Rect mTempRec = new Rect();
        int mUpDuration;
        ViewTransitionController mVtController;
        boolean reverse = false;

        Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            this.mVtController = viewTransitionController;
            this.mMC = motionController;
            this.mDuration = i;
            this.mUpDuration = i2;
            long nanoTime = System.nanoTime();
            this.mStart = nanoTime;
            this.mLastRender = nanoTime;
            this.mVtController.addAnimation(this);
            this.mInterpolator = interpolator;
            this.mSetsTag = i4;
            this.mClearsTag = i5;
            if (i3 == 3) {
                this.hold_at_100 = true;
            }
            this.mDpositionDt = i == 0 ? Float.MAX_VALUE : 1.0f / ((float) i);
            mutate();
        }

        /* access modifiers changed from: package-private */
        public void reverse(boolean z) {
            int i;
            this.reverse = z;
            if (z && (i = this.mUpDuration) != -1) {
                this.mDpositionDt = i == 0 ? Float.MAX_VALUE : 1.0f / ((float) i);
            }
            this.mVtController.invalidate();
            this.mLastRender = System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void mutate() {
            if (this.reverse) {
                mutateReverse();
            } else {
                mutateForward();
            }
        }

        /* access modifiers changed from: package-private */
        public void mutateReverse() {
            long nanoTime = System.nanoTime();
            this.mLastRender = nanoTime;
            float f = this.mPosition - (((float) (((double) (nanoTime - this.mLastRender)) * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = f;
            if (f < 0.0f) {
                this.mPosition = 0.0f;
            }
            Interpolator interpolator = this.mInterpolator;
            float interpolation = interpolator == null ? this.mPosition : interpolator.getInterpolation(this.mPosition);
            MotionController motionController = this.mMC;
            boolean interpolate = motionController.interpolate(motionController.mView, interpolation, nanoTime, this.mCache);
            if (this.mPosition <= 0.0f) {
                if (this.mSetsTag != -1) {
                    this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.mMC.getView().setTag(this.mClearsTag, (Object) null);
                }
                this.mVtController.removeAnimation(this);
            }
            if (this.mPosition > 0.0f || interpolate) {
                this.mVtController.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public void mutateForward() {
            long nanoTime = System.nanoTime();
            this.mLastRender = nanoTime;
            float f = this.mPosition + (((float) (((double) (nanoTime - this.mLastRender)) * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = f;
            if (f >= 1.0f) {
                this.mPosition = 1.0f;
            }
            Interpolator interpolator = this.mInterpolator;
            float interpolation = interpolator == null ? this.mPosition : interpolator.getInterpolation(this.mPosition);
            MotionController motionController = this.mMC;
            boolean interpolate = motionController.interpolate(motionController.mView, interpolation, nanoTime, this.mCache);
            if (this.mPosition >= 1.0f) {
                if (this.mSetsTag != -1) {
                    this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.mMC.getView().setTag(this.mClearsTag, (Object) null);
                }
                if (!this.hold_at_100) {
                    this.mVtController.removeAnimation(this);
                }
            }
            if (this.mPosition < 1.0f || interpolate) {
                this.mVtController.invalidate();
            }
        }

        public void reactTo(int i, float f, float f2) {
            if (i != 1) {
                if (i == 2) {
                    this.mMC.getView().getHitRect(this.mTempRec);
                    if (!this.mTempRec.contains((int) f, (int) f2) && !this.reverse) {
                        reverse(true);
                    }
                }
            } else if (!this.reverse) {
                reverse(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void applyTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i, ConstraintSet constraintSet, View... viewArr) {
        if (!this.mDisabled) {
            int i2 = this.mViewTransitionMode;
            if (i2 == 2) {
                applyIndependentTransition(viewTransitionController, motionLayout, viewArr[0]);
                return;
            }
            if (i2 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i3 : constraintSetIds) {
                    if (i3 != i) {
                        ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i3);
                        for (View id : viewArr) {
                            ConstraintSet.Constraint constraint = constraintSet2.getConstraint(id.getId());
                            ConstraintSet.Constraint constraint2 = this.mConstraintDelta;
                            if (constraint2 != null) {
                                constraint2.applyDelta(constraint);
                                constraint.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
                            }
                        }
                    }
                }
            }
            ConstraintSet constraintSet3 = new ConstraintSet();
            constraintSet3.clone(constraintSet);
            for (View id2 : viewArr) {
                ConstraintSet.Constraint constraint3 = constraintSet3.getConstraint(id2.getId());
                ConstraintSet.Constraint constraint4 = this.mConstraintDelta;
                if (constraint4 != null) {
                    constraint4.applyDelta(constraint3);
                    constraint3.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
                }
            }
            motionLayout.updateState(i, constraintSet3);
            motionLayout.updateState(C0273R.C0277id.view_transition, constraintSet);
            motionLayout.setState(C0273R.C0277id.view_transition, -1, -1);
            MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.mScene, C0273R.C0277id.view_transition, i);
            for (View updateTransition : viewArr) {
                updateTransition(transition, updateTransition);
            }
            motionLayout.setTransition(transition);
            motionLayout.transitionToEnd(new Runnable(viewArr) {
                public final /* synthetic */ View[] f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ViewTransition.this.lambda$applyTransition$0$ViewTransition(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$applyTransition$0$ViewTransition(View[] viewArr) {
        if (this.mSetsTag != -1) {
            for (View tag : viewArr) {
                tag.setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.mClearsTag != -1) {
            for (View tag2 : viewArr) {
                tag2.setTag(this.mClearsTag, (Object) null);
            }
        }
    }

    private void updateTransition(MotionScene.Transition transition, View view) {
        int i = this.mDuration;
        if (i != -1) {
            transition.setDuration(i);
        }
        transition.setPathMotionArc(this.mPathMotionArc);
        transition.setInterpolatorInfo(this.mDefaultInterpolator, this.mDefaultInterpolatorString, this.mDefaultInterpolatorID);
        int id = view.getId();
        KeyFrames keyFrames = this.mKeyFrames;
        if (keyFrames != null) {
            ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            Iterator<Key> it = keyFramesForView.iterator();
            while (it.hasNext()) {
                keyFrames2.addKey(it.next().clone().setViewId(id));
            }
            transition.addKeyFrame(keyFrames2);
        }
    }

    /* access modifiers changed from: package-private */
    public int getId() {
        return this.mId;
    }

    /* access modifiers changed from: package-private */
    public void setId(int i) {
        this.mId = i;
    }

    /* access modifiers changed from: package-private */
    public boolean matchesView(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.mTargetId == -1 && this.mTargetString == null) || !checkTags(view)) {
            return false;
        }
        if (view.getId() == this.mTargetId) {
            return true;
        }
        if (this.mTargetString != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).constraintTag) != null && str.matches(this.mTargetString)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean supports(int i) {
        int i2 = this.mOnStateTransition;
        return i2 == 1 ? i == 0 : i2 == 2 ? i == 1 : i2 == 3 && i == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isEnabled() {
        return !this.mDisabled;
    }

    /* access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.mDisabled = !z;
    }

    /* access modifiers changed from: package-private */
    public boolean checkTags(View view) {
        int i = this.mIfTagSet;
        boolean z = i == -1 || view.getTag(i) != null;
        int i2 = this.mIfTagNotSet;
        boolean z2 = i2 == -1 || view.getTag(i2) == null;
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
