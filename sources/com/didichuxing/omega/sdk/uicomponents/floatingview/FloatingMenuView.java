package com.didichuxing.omega.sdk.uicomponents.floatingview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.uicomponents.dialog.NoticeDialog;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FloatingMenuView {
    /* access modifiers changed from: private */
    public static List<FloatingViewListener> floatingViewListeners = new ArrayList();
    /* access modifiers changed from: private */
    public int bottom;
    /* access modifiers changed from: private */
    public Activity currentActivity;
    private Set<String> exceptActivities;
    /* access modifiers changed from: private */
    public FloatingActionButton floatingActionButton;
    private boolean floatingViewExist = false;
    /* access modifiers changed from: private */
    public GestureDetector gestureDetector;
    /* access modifiers changed from: private */
    public int lastX;
    /* access modifiers changed from: private */
    public int lastY;
    /* access modifiers changed from: private */
    public int left;
    private int mBottomOffsetOfFab;
    /* access modifiers changed from: private */
    public View mHintView;
    private FrameLayout.LayoutParams mHintViewParams;
    private int mLeftOffsetFab;
    private ViewGroup mParentViewOfHintView;
    private int mRightOffsetOfFab;
    private int mTopOffsetOfFab;
    /* access modifiers changed from: private */
    public List<MenuItem> menuItems = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public FrameLayout.LayoutParams params;
    private ViewGroup parentViewOfFloatingView;
    /* access modifiers changed from: private */
    public ViewGroup parentViewOfSubMenuLayoutRoot;
    /* access modifiers changed from: private */
    public int right;
    /* access modifiers changed from: private */
    public int screenHeight;
    /* access modifiers changed from: private */
    public int screenWidth;
    /* access modifiers changed from: private */
    public boolean subMenuExist = false;
    /* access modifiers changed from: private */
    public LinearLayout subMenuLayout;
    /* access modifiers changed from: private */
    public LinearLayout subMenuLayoutRoot;
    /* access modifiers changed from: private */
    public LinearLayout.LayoutParams subMenuLayoutRootParams;
    /* access modifiers changed from: private */
    public int top;
    /* access modifiers changed from: private */
    public int value;

    public FloatingMenuView(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels - 50;
        initFloatingActionButton(context);
        setViewLocation((this.screenWidth - C16159Util.dpToPx(context, 18.0f)) - 94, this.screenHeight - C16159Util.dpToPx(context, 470.0f));
        this.gestureDetector = new GestureDetector(context, new FloatingActionButtonOnGestureListener());
    }

    private void initFloatingActionButton(Context context) {
        FloatingActionButton floatingActionButton2 = this.floatingActionButton;
        if (floatingActionButton2 != null) {
            try {
                this.params = (FrameLayout.LayoutParams) floatingActionButton2.getLayoutParams();
            } catch (Exception e) {
                SystemUtils.log(6, "FloatingMenuView", "get layout params err:" + e.toString(), (Throwable) null, "com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView", 98);
                this.params = null;
            }
        }
        if (this.params == null) {
            this.params = new FrameLayout.LayoutParams(-2, -2);
        }
        if (this.floatingActionButton == null) {
            this.floatingActionButton = new FloatingActionButton(context);
        }
        this.floatingActionButton.setButtonSize(1);
        this.floatingActionButton.setLayoutParams(this.params);
        this.floatingActionButton.setOnTouchListener(new FloatingActionButtonTouchListener());
    }

    public void destroyFloatingActionButton() {
        this.floatingActionButton = null;
        this.subMenuLayout = null;
    }

    private class FloatingActionButtonTouchListener implements View.OnTouchListener {
        private FloatingActionButtonTouchListener() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
            if (r0 != 3) goto L_0x0107;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
            /*
                r6 = this;
                int r0 = r8.getAction()
                if (r0 == 0) goto L_0x00f3
                r1 = 1
                if (r0 == r1) goto L_0x00d6
                r1 = 2
                if (r0 == r1) goto L_0x0011
                r1 = 3
                if (r0 == r1) goto L_0x00d6
                goto L_0x0107
            L_0x0011:
                float r0 = r8.getRawX()
                int r0 = (int) r0
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r1 = r1.lastX
                int r0 = r0 - r1
                float r1 = r8.getRawY()
                int r1 = (int) r1
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r2 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r2 = r2.lastY
                int r1 = r1 - r2
                int r2 = r7.getLeft()
                int r2 = r2 + r0
                int r3 = r7.getBottom()
                int r3 = r3 + r1
                int r4 = r7.getRight()
                int r4 = r4 + r0
                int r0 = r7.getTop()
                int r0 = r0 + r1
                r1 = 0
                if (r2 >= 0) goto L_0x0047
                int r2 = r7.getWidth()
                int r4 = r2 + 0
                r2 = 0
            L_0x0047:
                if (r0 >= 0) goto L_0x0050
                int r0 = r7.getHeight()
                int r3 = r0 + 0
                r0 = 0
            L_0x0050:
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r1 = r1.screenWidth
                if (r4 <= r1) goto L_0x0064
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r4 = r1.screenWidth
                int r1 = r7.getWidth()
                int r2 = r4 - r1
            L_0x0064:
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r1 = r1.screenHeight
                if (r3 <= r1) goto L_0x0078
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r0 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r3 = r0.screenHeight
                int r0 = r7.getHeight()
                int r0 = r3 - r0
            L_0x0078:
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int unused = r1.left = r2
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int unused = r1.top = r0
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int unused = r1.right = r4
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int unused = r1.bottom = r3
                r7.layout(r2, r0, r4, r3)
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r0 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                float r1 = r8.getRawX()
                int r1 = (int) r1
                int unused = r0.lastX = r1
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r0 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                float r1 = r8.getRawY()
                int r1 = (int) r1
                int unused = r0.lastY = r1
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r0 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                android.widget.FrameLayout$LayoutParams r0 = r0.params
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r1 = r1.left
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r2 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r2 = r2.top
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r3 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r3 = r3.right
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r4 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r4 = r4.bottom
                r0.setMargins(r1, r2, r3, r4)
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r0 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                android.widget.FrameLayout$LayoutParams r0 = r0.params
                r7.setLayoutParams(r0)
                r7.postInvalidate()
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r7 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                r7.hideHintView()
                goto L_0x0107
            L_0x00d6:
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r0 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r2 = r0.left
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r3 = r1.top
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r4 = r1.right
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r1 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                int r5 = r1.bottom
                r1 = r7
                r0.resetPosition(r1, r2, r3, r4, r5)
                goto L_0x0107
            L_0x00f3:
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r7 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                float r0 = r8.getRawX()
                int r0 = (int) r0
                int unused = r7.lastX = r0
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r7 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                float r0 = r8.getRawY()
                int r0 = (int) r0
                int unused = r7.lastY = r0
            L_0x0107:
                com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView r7 = com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.this
                android.view.GestureDetector r7 = r7.gestureDetector
                boolean r7 = r7.onTouchEvent(r8)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView.FloatingActionButtonTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* access modifiers changed from: private */
    public void resetPosition(final View view, int i, int i2, int i3, int i4) {
        int i5 = this.screenWidth;
        if (i < i5 / 2) {
            this.left = 0;
            this.top = i2;
            this.right = i5 - view.getMeasuredWidth();
            this.bottom = i4;
        } else {
            this.left = i5 - view.getMeasuredWidth();
            this.top = i2;
            this.right = 0;
            this.bottom = i4;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, this.left});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = FloatingMenuView.this.value = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{i3, this.right});
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingMenuView.this.params.setMargins(FloatingMenuView.this.value, FloatingMenuView.this.top, ((Integer) valueAnimator.getAnimatedValue()).intValue(), FloatingMenuView.this.bottom);
                view.setLayoutParams(FloatingMenuView.this.params);
                view.postInvalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150);
        animatorSet.playTogether(new Animator[]{ofInt, ofInt2});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (FloatingMenuView.this.mHintView != null) {
                    FloatingMenuView.this.mHintView.setVisibility(0);
                }
                FloatingMenuView.this.showHintView(true);
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                FloatingMenuView.this.hideHintView();
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (FloatingMenuView.this.mHintView != null) {
                    FloatingMenuView.this.mHintView.setVisibility(0);
                }
                FloatingMenuView.this.params.setMargins(FloatingMenuView.this.value, FloatingMenuView.this.top, FloatingMenuView.this.right, FloatingMenuView.this.bottom);
                view.setLayoutParams(FloatingMenuView.this.params);
                view.postInvalidate();
                FloatingMenuView.this.showHintView(true);
            }
        });
        animatorSet.start();
    }

    private class FloatingActionButtonOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        private FloatingActionButtonOnGestureListener() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (FloatingMenuView.this.isHintViewShowing()) {
                FloatingMenuView.this.mHintView.performClick();
                FloatingMenuView.this.removeHintView();
                return super.onSingleTapConfirmed(motionEvent);
            } else if (FloatingMenuView.this.subMenuExist || !FloatingMenuView.this.isShowFloaingActionButtion()) {
                FloatingMenuView.this.hiddenSubMenu();
                if (!FloatingMenuView.this.isShowFloaingActionButtion()) {
                    FloatingMenuView.this.hidden();
                }
                return super.onSingleTapConfirmed(motionEvent);
            } else {
                FloatingMenuView.this.removeHintView();
                if (FloatingMenuView.this.currentActivity == null) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                LinearLayout unused = FloatingMenuView.this.subMenuLayoutRoot = new LinearLayout(FloatingMenuView.this.currentActivity);
                LinearLayout.LayoutParams unused2 = FloatingMenuView.this.subMenuLayoutRootParams = new LinearLayout.LayoutParams(-1, -1);
                FloatingMenuView.this.subMenuLayoutRoot.setLayoutParams(FloatingMenuView.this.subMenuLayoutRootParams);
                FloatingMenuView.this.subMenuLayoutRoot.setGravity(81);
                FloatingMenuView.this.subMenuLayoutRoot.setBackgroundColor(Color.argb(100, 0, 0, 0));
                FloatingMenuView.this.subMenuLayoutRoot.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        FloatingMenuView.this.hiddenSubMenu();
                        FloatingMenuView.this.show(FloatingMenuView.this.currentActivity);
                    }
                });
                LinearLayout unused3 = FloatingMenuView.this.subMenuLayout = new LinearLayout(FloatingMenuView.this.currentActivity);
                FloatingMenuView.this.subMenuLayout.setOrientation(1);
                FloatingMenuView.this.subMenuLayout.setBackgroundColor(-1);
                FloatingMenuView.this.subMenuLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                FloatingMenuView.this.subMenuLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                    }
                });
                Context baseContext = FloatingMenuView.this.currentActivity.getBaseContext();
                Collections.sort(FloatingMenuView.this.menuItems);
                int i = 0;
                for (final MenuItem menuItem : FloatingMenuView.this.menuItems) {
                    if (i == 0) {
                        TextView textView = new TextView(FloatingMenuView.this.currentActivity);
                        textView.setBackgroundColor(-1);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.height = C16159Util.dpToPx(baseContext, 8.0f);
                        textView.setLayoutParams(layoutParams);
                        FloatingMenuView.this.subMenuLayout.addView(textView);
                    }
                    LinearLayout linearLayout = new LinearLayout(FloatingMenuView.this.currentActivity);
                    linearLayout.setOrientation(0);
                    linearLayout.setGravity(16);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.height = C16159Util.dpToPx(baseContext, 30.0f);
                    int dpToPx = C16159Util.dpToPx(baseContext, 5.0f);
                    layoutParams2.setMargins(C16159Util.dpToPx(baseContext, 25.0f), dpToPx, dpToPx, dpToPx);
                    layoutParams2.gravity = 16;
                    linearLayout.setLayoutParams(layoutParams2);
                    ImageView imageView = new ImageView(FloatingMenuView.this.currentActivity);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.height = C16159Util.dpToPx(baseContext, 16.0f);
                    layoutParams3.width = C16159Util.dpToPx(baseContext, 16.0f);
                    layoutParams3.rightMargin = C16159Util.dpToPx(baseContext, 15.0f);
                    layoutParams3.leftMargin = C16159Util.dpToPx(baseContext, 8.0f);
                    imageView.setLeft(C16159Util.dpToPx(baseContext, 15.0f));
                    imageView.setImageDrawable(menuItem.getIcon());
                    imageView.setLayoutParams(layoutParams3);
                    LinearLayout linearLayout2 = new LinearLayout(FloatingMenuView.this.currentActivity);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
                    linearLayout2.setGravity(17);
                    layoutParams4.height = C16159Util.dpToPx(baseContext, 20.0f);
                    layoutParams4.width = C16159Util.dpToPx(baseContext, 20.0f);
                    linearLayout2.setLayoutParams(layoutParams4);
                    linearLayout2.addView(imageView);
                    linearLayout.addView(linearLayout2);
                    TextView textView2 = new TextView(FloatingMenuView.this.currentActivity);
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams5.setMargins(26, 0, 0, 0);
                    textView2.setGravity(16);
                    textView2.setText(menuItem.getText());
                    textView2.setTextColor(Color.argb(255, 102, 102, 102));
                    textView2.setLeft(10);
                    textView2.setRight(10);
                    textView2.setLayoutParams(layoutParams5);
                    linearLayout.addView(textView2);
                    TextView textView3 = new TextView(FloatingMenuView.this.currentActivity);
                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(C16159Util.dpToPx(baseContext, 14.0f), C16159Util.dpToPx(baseContext, 14.0f));
                    layoutParams6.leftMargin = 10;
                    textView3.setText(menuItem.getCount() + "");
                    textView3.setTextSize(2, 10.0f);
                    textView3.setTextColor(-1);
                    textView3.setLeft(10);
                    textView3.setRight(10);
                    textView3.setGravity(17);
                    textView3.setBackgroundResource(R.drawable.shape_countbg);
                    textView3.setLayoutParams(layoutParams6);
                    linearLayout.addView(textView3);
                    if (menuItem.getCount() <= 0) {
                        textView3.setVisibility(4);
                    } else {
                        textView3.setVisibility(0);
                    }
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            FloatingMenuView.this.hiddenSubMenu();
                            FloatingMenuView.this.show(FloatingMenuView.this.currentActivity);
                            if (menuItem.getL() != null) {
                                menuItem.getL().onClick(view);
                            }
                        }
                    });
                    FloatingMenuView.this.subMenuLayout.addView(linearLayout);
                    i++;
                }
                TextView textView4 = new TextView(FloatingMenuView.this.currentActivity);
                textView4.setBackgroundColor(Color.argb(35, 102, 102, 102));
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams7.height = C16159Util.dpToPx(baseContext, 1.0f);
                layoutParams7.topMargin = C16159Util.dpToPx(baseContext, 8.0f);
                textView4.setLayoutParams(layoutParams7);
                FloatingMenuView.this.subMenuLayout.addView(textView4);
                LinearLayout linearLayout3 = new LinearLayout(FloatingMenuView.this.currentActivity);
                linearLayout3.setOrientation(0);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
                int dpToPx2 = C16159Util.dpToPx(baseContext, 14.0f);
                layoutParams8.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
                linearLayout3.setLayoutParams(layoutParams8);
                linearLayout3.setGravity(17);
                TextView textView5 = new TextView(FloatingMenuView.this.currentActivity);
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -1);
                if (FloatingViewConfig.iConfig != null) {
                    textView5.setText(FloatingViewConfig.iConfig.getCloseItemText());
                }
                textView5.setGravity(16);
                textView5.setTextColor(Color.argb(255, 135, 135, 135));
                textView5.setLayoutParams(layoutParams9);
                linearLayout3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SystemUtils.showDialog(new NoticeDialog(FloatingMenuView.this.getCurrentActivity(), new View.OnClickListener() {
                            public void onClick(View view) {
                                FloatingMenuView.this.hiddenSubMenu();
                                FloatingMenuView.this.hidden();
                                UIComponentCache.userClosedFloatingView();
                            }
                        }));
                    }
                });
                linearLayout3.addView(textView5);
                FloatingMenuView.this.subMenuLayout.addView(linearLayout3);
                TextView textView6 = new TextView(FloatingMenuView.this.currentActivity);
                textView6.setBackgroundColor(Color.argb(35, 102, 102, 102));
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams10.height = C16159Util.dpToPx(baseContext, 1.0f);
                textView6.setLayoutParams(layoutParams10);
                FloatingMenuView.this.subMenuLayout.addView(textView6);
                LinearLayout linearLayout4 = new LinearLayout(FloatingMenuView.this.currentActivity);
                linearLayout4.setOrientation(0);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
                int dpToPx3 = C16159Util.dpToPx(baseContext, 14.0f);
                layoutParams11.setMargins(dpToPx3, dpToPx3, dpToPx3, dpToPx3);
                linearLayout4.setLayoutParams(layoutParams11);
                linearLayout4.setGravity(17);
                TextView textView7 = new TextView(FloatingMenuView.this.currentActivity);
                LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -1);
                if (FloatingViewConfig.iConfig != null) {
                    textView7.setText(FloatingViewConfig.iConfig.getCancelItemText());
                }
                textView7.setGravity(16);
                textView7.setTextColor(Color.argb(255, 135, 135, 135));
                textView7.setLayoutParams(layoutParams12);
                linearLayout4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        FloatingMenuView.this.hiddenSubMenu();
                        FloatingMenuView.this.show(FloatingMenuView.this.currentActivity);
                    }
                });
                linearLayout4.addView(textView7);
                FloatingMenuView.this.subMenuLayout.addView(linearLayout4);
                FloatingMenuView.this.subMenuLayoutRoot.addView(FloatingMenuView.this.subMenuLayout);
                FloatingMenuView.this.hiddenSubMenu();
                FloatingMenuView.this.currentActivity.addContentView(FloatingMenuView.this.subMenuLayoutRoot, FloatingMenuView.this.subMenuLayoutRootParams);
                FloatingMenuView floatingMenuView = FloatingMenuView.this;
                ViewGroup unused4 = floatingMenuView.parentViewOfSubMenuLayoutRoot = (ViewGroup) floatingMenuView.subMenuLayoutRoot.getParent();
                for (FloatingViewListener onClick : FloatingMenuView.floatingViewListeners) {
                    onClick.onClick(FloatingMenuView.this.floatingActionButton);
                }
                boolean unused5 = FloatingMenuView.this.subMenuExist = true;
                FloatingMenuView.this.hidden();
                return super.onSingleTapConfirmed(motionEvent);
            }
        }
    }

    public synchronized void addSubMenuItem(Drawable drawable, String str, int i, FloatingViewMenuItemListener floatingViewMenuItemListener) {
        if (!checkSubMenuItemExist(str)) {
            MenuItem menuItem = new MenuItem();
            menuItem.setIcon(drawable);
            menuItem.setText(str);
            menuItem.setL(floatingViewMenuItemListener);
            menuItem.setCount(i);
            this.menuItems.add(menuItem);
            if (!this.floatingViewExist && this.currentActivity != null && !isExceptActivity(this.currentActivity)) {
                show(this.currentActivity);
            }
        }
        if (this.floatingViewExist && this.currentActivity != null && isExceptActivity(this.currentActivity)) {
            hidden();
        }
    }

    public synchronized void removeSubMenuItem(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.menuItems) {
            for (MenuItem next : this.menuItems) {
                if (str != null && str.equals(next.getText())) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                this.menuItems.removeAll(arrayList);
            }
        }
    }

    public void updateSubMenuItemText(String str, String str2) {
        if (str != null && str2 != null) {
            for (MenuItem next : this.menuItems) {
                if (str.equals(next.getText())) {
                    next.setText(str2);
                }
            }
        }
    }

    private boolean checkSubMenuItemExist(String str) {
        synchronized (this.menuItems) {
            for (MenuItem next : this.menuItems) {
                if (str != null && str.equals(next.getText())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void setSubMenuItemOrderWeight(String str, int i) {
        if (str != null) {
            synchronized (this.menuItems) {
                for (MenuItem next : this.menuItems) {
                    if (str.equals(next.getText())) {
                        next.setOrderWeight(i);
                        return;
                    }
                }
            }
        }
    }

    public void updateMenuItemount(String str, int i) {
        if (str != null) {
            for (MenuItem next : this.menuItems) {
                if (str.equals(next.getText())) {
                    next.setCount(i);
                }
            }
        }
    }

    public void addFloatingViewOnClickLinstener(FloatingViewListener floatingViewListener) {
        floatingViewListeners.add(floatingViewListener);
    }

    public void addHintView(View view, FrameLayout.LayoutParams layoutParams) {
        removeHintView();
        this.mHintView = view;
        this.mHintViewParams = layoutParams;
        showHintView(false);
    }

    /* access modifiers changed from: private */
    public boolean isHintViewShowing() {
        View view = this.mHintView;
        return view != null && view.isShown();
    }

    /* access modifiers changed from: private */
    public void hideHintView() {
        if (isHintViewShowing()) {
            this.mHintView.setVisibility(4);
        }
    }

    private void moveHintView(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams;
        if (this.mHintView != null && (layoutParams = this.mHintViewParams) != null && this.mParentViewOfHintView != null) {
            layoutParams.setMargins(i + this.mLeftOffsetFab, i2 + this.mTopOffsetOfFab, i3 + this.mRightOffsetOfFab, i4 + this.mBottomOffsetOfFab);
            this.mHintView.postInvalidate();
        }
    }

    public void removeHintView() {
        View view;
        ViewGroup viewGroup = this.mParentViewOfHintView;
        if (viewGroup != null && (view = this.mHintView) != null) {
            viewGroup.removeView(view);
            this.mHintView = null;
            this.mParentViewOfHintView = null;
        }
    }

    public synchronized void show(Activity activity) {
        hidden();
        if (UIComponentCache.isUserClosedFloatingView()) {
            SystemUtils.log(6, "SEE_THIS", "isUserClosedFloatingView ", (Throwable) null, "com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView", 670);
            return;
        }
        if (activity != null) {
            if (!activity.isFinishing()) {
                initFloatingActionButton(activity);
                if (this.parentViewOfFloatingView == null) {
                    this.currentActivity = activity;
                    try {
                        activity.addContentView(this.floatingActionButton, this.params);
                    } catch (Exception e) {
                        SystemUtils.log(6, "FloatingView", "add floatingview into current activity err:" + e.toString(), (Throwable) null, "com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView", 684);
                        initFloatingActionButton(this.currentActivity);
                        this.currentActivity.addContentView(this.floatingActionButton, this.params);
                    }
                    this.parentViewOfFloatingView = (ViewGroup) this.floatingActionButton.getParent();
                    this.floatingViewExist = true;
                }
                showHintView(false);
                return;
            }
        }
        SystemUtils.log(6, "SEE_THIS", "activity is null or activity is finishing. ", (Throwable) null, "com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingMenuView", 674);
    }

    public int getMenuItemCount() {
        return this.menuItems.size();
    }

    /* access modifiers changed from: private */
    public void showHintView(boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.mHintView != null && (layoutParams = this.mHintViewParams) != null && this.currentActivity != null && layoutParams.width != 0 && this.mHintViewParams.height != 0) {
            int dpToPx = C16159Util.dpToPx(this.currentActivity, 46.0f);
            if (this.left < this.screenWidth / 2) {
                this.mTopOffsetOfFab = (dpToPx - this.mHintViewParams.height) / 2;
                this.mBottomOffsetOfFab = 0 - ((dpToPx - this.mHintViewParams.height) / 2);
                this.mLeftOffsetFab = dpToPx;
                this.mRightOffsetOfFab = this.mHintViewParams.width - dpToPx;
            } else {
                this.mTopOffsetOfFab = (dpToPx - this.mHintViewParams.height) / 2;
                this.mBottomOffsetOfFab = 0 - ((dpToPx - this.mHintViewParams.height) / 2);
                this.mLeftOffsetFab = -this.mHintViewParams.width;
                this.mRightOffsetOfFab = this.mHintViewParams.width + dpToPx;
            }
            this.mHintViewParams.setMargins(this.left + this.mLeftOffsetFab, this.top + this.mTopOffsetOfFab, this.right + this.mRightOffsetOfFab, this.bottom + this.mBottomOffsetOfFab);
            if (z) {
                this.mHintView.postInvalidate();
                return;
            }
            this.currentActivity.addContentView(this.mHintView, this.mHintViewParams);
            this.mParentViewOfHintView = (ViewGroup) this.mHintView.getParent();
        }
    }

    private void hiddenHintView() {
        View view;
        ViewGroup viewGroup = this.mParentViewOfHintView;
        if (viewGroup != null && (view = this.mHintView) != null) {
            viewGroup.removeView(view);
        }
    }

    public void hidden() {
        ViewGroup viewGroup = this.parentViewOfFloatingView;
        if (viewGroup != null) {
            viewGroup.removeView(this.floatingActionButton);
            this.parentViewOfFloatingView = null;
            this.floatingViewExist = false;
        }
        hiddenHintView();
    }

    public void hiddenSubMenu() {
        LinearLayout linearLayout;
        ViewGroup viewGroup = this.parentViewOfSubMenuLayoutRoot;
        if (viewGroup != null && (linearLayout = this.subMenuLayoutRoot) != null) {
            viewGroup.removeView(linearLayout);
            this.parentViewOfSubMenuLayoutRoot = null;
            this.subMenuExist = false;
            this.subMenuLayout = null;
        }
    }

    private class MenuItem implements Comparable<MenuItem> {
        private int count;
        private Drawable icon;

        /* renamed from: l */
        private FloatingViewMenuItemListener f48487l;
        private int orderWeight = 50;
        private String text;

        public MenuItem() {
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public void setIcon(Drawable drawable) {
            this.icon = drawable;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public FloatingViewMenuItemListener getL() {
            return this.f48487l;
        }

        public void setL(FloatingViewMenuItemListener floatingViewMenuItemListener) {
            this.f48487l = floatingViewMenuItemListener;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public void setOrderWeight(int i) {
            this.orderWeight = i;
        }

        public int getOrderWeight() {
            return this.orderWeight;
        }

        public int compareTo(MenuItem menuItem) {
            if (getOrderWeight() > menuItem.getOrderWeight()) {
                return -1;
            }
            return getOrderWeight() < menuItem.getOrderWeight() ? 1 : 0;
        }
    }

    public void setViewLocation(int i, int i2) {
        this.left = i;
        this.top = i2;
        this.params.setMargins(i, i2, this.right, this.bottom);
    }

    public void setCurrentActivity(Activity activity) {
        this.currentActivity = activity;
    }

    public Activity getCurrentActivity() {
        return this.currentActivity;
    }

    public boolean isShowFloaingActionButtion() {
        return getMenuItemCount() != 0;
    }

    public void addExceptActivity(String str) {
        if (this.exceptActivities == null) {
            this.exceptActivities = new HashSet();
        }
        this.exceptActivities.add(str);
    }

    public boolean isExceptActivity(Activity activity) {
        Set<String> set = this.exceptActivities;
        if (!(set == null || activity == null)) {
            for (String contains : set) {
                if (activity.getClass().getName().contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }
}
