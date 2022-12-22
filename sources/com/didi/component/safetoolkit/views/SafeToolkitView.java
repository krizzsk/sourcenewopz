package com.didi.component.safetoolkit.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.SafeToolkitVisibilityEvent;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.model.SafeToolkitBean;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.ISafeToolkitView;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.utils.SafetoolkitOmegaUtils;
import com.didi.component.safetoolkit.views.bubbles.BubbleView;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.view.LazyInflateView;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;

public class SafeToolkitView extends LazyInflateView implements ISafeToolkitView {
    public static final int EXPAND_ANIMATION_DURATION_MILLS = 1000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f15436a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f15437b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f15438c;

    /* renamed from: d */
    private FrameLayout f15439d;

    /* renamed from: e */
    private ImageView f15440e;

    /* renamed from: f */
    private ImageView f15441f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f15442g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f15443h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AbsSafeToolkitPresenter f15444i;

    /* renamed from: j */
    private BubbleView f15445j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ViewGroup f15446k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f15447l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ValueAnimator f15448m;

    /* renamed from: n */
    private View.OnClickListener f15449n = null;

    /* renamed from: o */
    private int f15450o = 100;

    /* renamed from: p */
    private View.OnClickListener f15451p = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SafeToolkitView.this.f15444i.onActionClick();
        }
    };

    public SafeToolkitView(Context context) {
        super(context, (ViewGroup) null, R.layout.sf_safe_toolkit_entrance);
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        this.f15437b = view;
        this.f15438c = (ImageView) view.findViewById(R.id.sf_safe_toolkit_entrance);
        this.f15439d = (FrameLayout) this.f15437b.findViewById(R.id.sf_safe_toolkit_breath_container);
        this.f15440e = (ImageView) this.f15437b.findViewById(R.id.sf_safe_toolkit_breath_inner_view);
        this.f15441f = (ImageView) this.f15437b.findViewById(R.id.sf_safe_toolkit_breath_outer_view);
        if (GlobalApolloUtil.isRiderSafetyToolkitIcon()) {
            this.f15438c.setImageDrawable(getContext().getResources().getDrawable(R.drawable.safe_toolkit_icon_new_selector));
        } else {
            this.f15438c.setImageDrawable(getContext().getResources().getDrawable(R.drawable.safe_toolkit_icon_selector));
        }
        View.OnClickListener onClickListener = this.f15449n;
        if (onClickListener != null) {
            this.f15438c.setOnClickListener(onClickListener);
        }
        this.f15445j = (BubbleView) this.f15437b.findViewById(R.id.sf_safe_toolkit_bubble);
        ViewGroup viewGroup = (ViewGroup) this.f15437b.findViewById(R.id.sf_safe_toolkit_welcome_bubble_container);
        this.f15446k = viewGroup;
        this.f15442g = (TextView) viewGroup.findViewById(R.id.sf_safe_toolkit_welcome_bubble_msg);
        this.f15443h = (ImageView) this.f15446k.findViewById(R.id.sf_safe_toolkit_welcome_bubble_more);
        int i = this.f15450o;
        if (i < 0) {
            this.f15437b.setTranslationY((float) i);
        }
    }

    public View getView() {
        return getRealView();
    }

    public void setPresenter(AbsSafeToolkitPresenter absSafeToolkitPresenter) {
        this.f15444i = absSafeToolkitPresenter;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f15438c;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        } else {
            this.f15449n = onClickListener;
        }
    }

    public void setVisibility(final boolean z) {
        int i = 0;
        if (z || this.isInflated) {
            super.inflate();
            if (!z) {
                i = 4;
            }
            if (i != this.f15437b.getVisibility()) {
                this.f15437b.setVisibility(i);
                this.f15437b.postDelayed(new Runnable() {
                    public void run() {
                        int measuredHeight = (int) (((float) SafeToolkitView.this.getView().getMeasuredHeight()) - TypedValue.applyDimension(1, 2.0f, SafeToolkitView.this.getView().getResources().getDisplayMetrics()));
                        if (measuredHeight < 0) {
                            measuredHeight = 0;
                        }
                        if (z) {
                            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, new SafeToolkitVisibilityEvent(measuredHeight, true));
                        } else {
                            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, new SafeToolkitVisibilityEvent(measuredHeight, false));
                        }
                        Logger c = SafeToolkitView.this.f15436a;
                        c.info("SafeToolkitView#setVisibility#postDelayed : isVisible : " + z + " , isInflated : " + SafeToolkitView.this.isInflated + " , height : " + measuredHeight, new Object[0]);
                    }
                }, 300);
                return;
            }
            return;
        }
        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, new SafeToolkitVisibilityEvent(0, false));
        Logger logger = this.f15436a;
        logger.info("SafeToolkitView#setVisibility: isVisible : " + z + " , isInflated : " + this.isInflated + " , height : 0", new Object[0]);
    }

    public boolean isVisibility() {
        View view = this.f15437b;
        return view != null && view.getVisibility() == 0;
    }

    public void setTranslationY(int i) {
        if (this.isInflated) {
            getView().setTranslationY((float) i);
        } else {
            this.f15450o = i;
        }
    }

    public void setSafeToolkitStatusAndShow(final SafeToolkitBean.SafeToolkitData safeToolkitData) {
        if (!isVisibility() || this.f15445j == null) {
            return;
        }
        if (safeToolkitData == null || safeToolkitData.show == 0) {
            dismissBubble((Runnable) null);
        } else if (safeToolkitData.state == 7 || !isWelcomeShown()) {
            int i = safeToolkitData.state;
            final String str = safeToolkitData.content;
            int parseColor = Color.parseColor("#FFFF7F41");
            int parseColor2 = Color.parseColor("#FF333333");
            int dimension = (int) getView().getResources().getDimension(R.dimen.normal_bubble_text_max_width);
            m11116a();
            int windowWidth = UiUtils.getWindowWidth((Activity) this.mContext);
            switch (i) {
                case 1:
                    int parseColor3 = Color.parseColor("#FFFF525D");
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_bubble_allert_gif);
                    this.f15445j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor3);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 2:
                    int parseColor4 = Color.parseColor("#FFD0021B");
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_bubble_field);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor4);
                    this.f15445j.setOnClickListener(this.f15451p);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 3:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_bubble_loading_gif);
                    this.f15445j.setMsg(dimension, str, parseColor2);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 4:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_bubble_succ);
                    this.f15445j.setMsg(dimension, str, parseColor2);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 5:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_bubble_location_icon);
                    this.f15445j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.setAction(this.f15451p);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 6:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_bubble_people);
                    this.f15445j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.setAction(this.f15451p);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 7:
                    if (!isBubbleShown()) {
                        m11122a(str, 12);
                        m11123a(str, (Runnable) null);
                        break;
                    } else {
                        dismissBubble(new Runnable() {
                            public void run() {
                                SafeToolkitView.this.m11122a(str, 12);
                                SafeToolkitView.this.m11123a(str, (Runnable) null);
                            }
                        });
                        break;
                    }
                case 8:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_bubble_edit);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor);
                    this.f15445j.setAction(this.f15451p);
                    CarOrder order = CarOrderHelper.getOrder();
                    if (order != null && !TextUtils.isEmpty(order.oid) && !TextUtils.isEmpty(str)) {
                        this.f15445j.showBubble((Runnable) null);
                        break;
                    }
                case 9:
                    int dimension2 = (int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width);
                    if (TripRecordingManager.Companion.getInstance().isRecording()) {
                        this.f15445j.setIconResources(R.drawable.sf_toolkit_dialog_record_audio_open_icon);
                        safeToolkitData.content = this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_trip_audio_recording);
                    } else {
                        this.f15445j.setIconResources(R.drawable.sf_toolkit_dialog_record_audio_close_icon);
                        this.f15445j.setMsg(dimension2, str, parseColor2);
                    }
                    this.f15445j.setActionVisible(false);
                    this.f15445j.setOnClickListener(this.f15451p);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 10:
                    this.f15445j.setIconResources(R.drawable.sf_toolkit_dialog_record_audio_open_icon);
                    this.f15445j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor2);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.setOnClickListener(this.f15451p);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 11:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_monitor_start);
                    this.f15445j.setMsg((int) (((double) windowWidth) * 0.3d), str, parseColor2);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 12:
                    ViewGroup.LayoutParams layoutParams = this.f15439d.getLayoutParams();
                    layoutParams.width = UiUtils.dip2px(getContext(), 63.0f);
                    layoutParams.height = UiUtils.dip2px(getContext(), 63.0f);
                    this.f15439d.setLayoutParams(layoutParams);
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_monitor_warning);
                    this.f15445j.setMsg((int) (((double) windowWidth) * 0.35d), str, -1);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.isMonitorWarningStyle(true);
                    BreathViewHelper.startBreath(this.f15440e, this.f15441f);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 13:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_monitor_pre);
                    this.f15445j.setMsg((int) (((double) windowWidth) * 0.4d), str, parseColor);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.setAction(this.f15451p);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 14:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_monitor_start);
                    this.f15445j.setMsg((int) (((double) windowWidth) * 0.3d), str, parseColor2);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.showBubble((Runnable) null);
                    break;
                case 15:
                    this.f15445j.setIconResources(R.drawable.sf_safe_toolkit_monitor_pre);
                    this.f15445j.setMsg((int) (((double) windowWidth) * 0.3d), str, parseColor2);
                    this.f15445j.setActionVisible(false);
                    this.f15445j.showBubble((Runnable) null);
                    break;
            }
            SafetoolkitOmegaUtils.sendBubbleShow(i);
        } else {
            dismissWelcome(new Runnable() {
                public void run() {
                    SafeToolkitView.this.setSafeToolkitStatusAndShow(safeToolkitData);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11122a(final String str, final int i) {
        if (this.f15442g.getLayout() == null) {
            this.f15442g.post(new Runnable() {
                public void run() {
                    SafeToolkitView.this.m11122a(str, i);
                }
            });
            return;
        }
        this.f15442g.setTextSize(2, (float) i);
        this.f15442g.setText(str);
        if (m11124a(this.f15442g) && i >= 9) {
            m11122a(str, i - 1);
        }
    }

    /* renamed from: a */
    private boolean m11124a(TextView textView) {
        Layout layout = textView.getLayout();
        if (layout == null || layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11123a(String str, final Runnable runnable) {
        if (isVisibility() && !isBubbleShown()) {
            this.f15442g.post(new Runnable() {
                public void run() {
                    SafeToolkitView.this.f15442g.measure(0, 0);
                    int measuredWidth = SafeToolkitView.this.f15442g.getMeasuredWidth();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) SafeToolkitView.this.f15442g.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    SafeToolkitView.this.f15442g.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) SafeToolkitView.this.f15443h.getLayoutParams();
                    SafeToolkitView.this.m11117a(measuredWidth + layoutParams.leftMargin + layoutParams2.leftMargin + layoutParams2.width, runnable);
                }
            });
        }
    }

    public void dismissWelcome(Runnable runnable) {
        if (isVisibility() && isWelcomeShown()) {
            m11121a(runnable);
        }
    }

    public boolean isBubbleShown() {
        BubbleView bubbleView = this.f15445j;
        if (bubbleView != null) {
            return bubbleView.isBubbleShown();
        }
        return false;
    }

    public void dismissBubble(Runnable runnable) {
        BubbleView bubbleView = this.f15445j;
        if (bubbleView != null) {
            bubbleView.dismissBubble(runnable);
        }
    }

    public boolean isWelcomeShown() {
        return this.f15447l;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11117a(final int i, final Runnable runnable) {
        this.f15446k.setVisibility(0);
        this.f15446k.post(new Runnable() {
            public void run() {
                if (SafeToolkitView.this.f15448m == null) {
                    ValueAnimator unused = SafeToolkitView.this.f15448m = new ValueAnimator();
                    SafeToolkitView.this.f15448m.setDuration(1000);
                } else {
                    SafeToolkitView.this.f15448m.cancel();
                    SafeToolkitView.this.f15448m.removeAllUpdateListeners();
                    SafeToolkitView.this.f15448m.removeAllListeners();
                }
                SafeToolkitView.this.f15448m.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        SafeToolkitView.this.f15446k.setVisibility(0);
                        boolean unused = SafeToolkitView.this.f15447l = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                int measuredWidth = SafeToolkitView.this.f15438c.getMeasuredWidth();
                SafeToolkitView.this.f15448m.setIntValues(new int[]{measuredWidth, i + measuredWidth});
                SafeToolkitView.this.f15448m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SafeToolkitView.this.f15446k.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        SafeToolkitView.this.f15446k.setLayoutParams(layoutParams);
                        SafeToolkitView.this.f15446k.invalidate();
                    }
                });
                SafeToolkitView.this.f15448m.start();
            }
        });
    }

    /* renamed from: a */
    private void m11121a(final Runnable runnable) {
        this.f15446k.post(new Runnable() {
            public void run() {
                if (SafeToolkitView.this.f15448m == null) {
                    ValueAnimator unused = SafeToolkitView.this.f15448m = new ValueAnimator();
                    SafeToolkitView.this.f15448m.setDuration(500);
                } else {
                    SafeToolkitView.this.f15448m.cancel();
                    SafeToolkitView.this.f15448m.removeAllUpdateListeners();
                    SafeToolkitView.this.f15448m.removeAllListeners();
                }
                SafeToolkitView.this.f15448m.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        SafeToolkitView.this.f15446k.setVisibility(0);
                        boolean unused = SafeToolkitView.this.f15447l = false;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SafeToolkitView.this.f15446k.getLayoutParams();
                        layoutParams.width = SafeToolkitView.this.f15438c.getMeasuredWidth();
                        SafeToolkitView.this.f15446k.setLayoutParams(layoutParams);
                        SafeToolkitView.this.f15446k.setVisibility(4);
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                int measuredWidth = SafeToolkitView.this.f15438c.getMeasuredWidth();
                SafeToolkitView.this.f15448m.setIntValues(new int[]{SafeToolkitView.this.f15446k.getMeasuredWidth(), measuredWidth});
                SafeToolkitView.this.f15448m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SafeToolkitView.this.f15446k.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        SafeToolkitView.this.f15446k.setLayoutParams(layoutParams);
                        SafeToolkitView.this.f15446k.invalidate();
                    }
                });
                SafeToolkitView.this.f15448m.start();
            }
        });
    }

    public void resetBreathAnim() {
        m11116a();
    }

    public void setDismissedByAlpha(boolean z) {
        ObjectAnimator objectAnimator;
        View view = this.f15437b;
        if (view != null) {
            if (z) {
                objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SafeToolkitView.this.f15437b.setVisibility(4);
                    }
                });
            } else {
                objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f}).setDuration(300);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SafeToolkitView.this.f15437b.setVisibility(0);
                    }
                });
            }
            objectAnimator.start();
        }
    }

    /* renamed from: a */
    private void m11116a() {
        ViewGroup.LayoutParams layoutParams = this.f15439d.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f15439d.setLayoutParams(layoutParams);
        this.f15440e.clearAnimation();
        this.f15441f.clearAnimation();
        this.f15445j.isMonitorWarningStyle(false);
        this.f15440e.setVisibility(8);
        this.f15441f.setVisibility(8);
    }
}
