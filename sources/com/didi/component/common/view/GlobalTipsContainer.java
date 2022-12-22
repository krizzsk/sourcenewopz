package com.didi.component.common.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.sdk.view.tips.TipsContainer;
import com.didi.sdk.view.tips.TipsView;
import java.util.Iterator;
import java.util.LinkedList;

public class GlobalTipsContainer extends TipsContainer {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f11830a;

    /* renamed from: b */
    private AnchorMoveMonitor f11831b;

    public GlobalTipsContainer(Activity activity) {
        super(activity);
        this.f11830a = activity;
    }

    public void showWithLocationBinded(TipsView tipsView, View view, int i, int i2, int i3, int i4) {
        GLog.m7965d("hzd", "showWithLocationBinded");
        show(tipsView, view, i, i2, i3, i4, false);
        TipsView tipsView2 = tipsView;
        View view2 = view;
        int i5 = i2;
        m8014a(view, tipsView, i2);
    }

    public void showWithLocationBinded(String str, View view, int i, int i2, int i3, int i4) {
        UserGuideTipsView userGuideTipsView = new UserGuideTipsView(this.f11830a);
        userGuideTipsView.setMoreLineTips(str);
        userGuideTipsView.setId(view.hashCode());
        userGuideTipsView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalTipsContainer.this.clearAllTips();
            }
        });
        show(userGuideTipsView, view, i, i2, i3, i4, false);
        m8014a(view, userGuideTipsView, i2);
    }

    public void showWithLocationBinded(String str, View view, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        UserGuideTipsView userGuideTipsView = new UserGuideTipsView(this.f11830a);
        String str2 = str;
        userGuideTipsView.setMoreLineTips(str);
        userGuideTipsView.setId(view.hashCode());
        final View.OnClickListener onClickListener2 = onClickListener;
        userGuideTipsView.setCloseListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        show(userGuideTipsView, view, i, i2, i3, i4, false);
        View view2 = view;
        int i5 = i2;
        m8014a(view, userGuideTipsView, i2);
    }

    public void showWithLocationBinded(int i, String str, View view, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        GlobalTipsView globalTipsView = new GlobalTipsView(this.f11830a);
        String str2 = str;
        globalTipsView.setMoreLineTips(str);
        globalTipsView.setId(view.hashCode());
        globalTipsView.setShowGuideIcon(true);
        int i6 = i;
        globalTipsView.setIcon(i);
        final View.OnClickListener onClickListener3 = onClickListener;
        globalTipsView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener3;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        final View.OnClickListener onClickListener4 = onClickListener2;
        globalTipsView.setCloseListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener4;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        show(globalTipsView, view, i2, i3, i4, i5, false);
        View view2 = view;
        int i7 = i3;
        m8014a(view, globalTipsView, i3);
    }

    public void showWithLocationBindedForLeftAlign(String str, View view, int i, int i2, int i3, int i4) {
        LeftAlignCompatibleTipsView leftAlignCompatibleTipsView = new LeftAlignCompatibleTipsView(this.f11830a, view, i3);
        leftAlignCompatibleTipsView.setMoreLineTips(str);
        leftAlignCompatibleTipsView.setId(view.hashCode());
        leftAlignCompatibleTipsView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalTipsContainer.this.clearAllTips();
            }
        });
        show(leftAlignCompatibleTipsView, view, i, i2, i3, i4, false);
        m8014a(view, leftAlignCompatibleTipsView, i2);
    }

    public void clearAllTips() {
        super.clearAllTips();
        AnchorMoveMonitor anchorMoveMonitor = this.f11831b;
        if (anchorMoveMonitor != null) {
            anchorMoveMonitor.clear();
        }
    }

    /* renamed from: a */
    private void m8014a(View view, TipsView tipsView, int i) {
        if (this.f11831b == null) {
            this.f11831b = new AnchorMoveMonitor();
        }
        this.f11831b.startMonitor(view, tipsView, i);
    }

    public class LeftAlignCompatibleTipsView extends TipsView {
        int[] mAnchorLoc;
        boolean mHasResetPosition;
        int mOldHeight;
        int mOldWidth;
        int mPx;
        int mWindowWidth;

        public LeftAlignCompatibleTipsView(Context context, View view, int i) {
            super(context);
            int[] iArr = new int[2];
            this.mAnchorLoc = iArr;
            view.getLocationInWindow(iArr);
            this.mWindowWidth = UiUtils.getWindowWidth(GlobalTipsContainer.this.f11830a);
            this.mPx = i;
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            if (!this.mHasResetPosition) {
                int i5 = i3 - i;
                int[] iArr = this.mAnchorLoc;
                if (i5 > iArr[0] && i3 > iArr[0] + this.mPx) {
                    this.mHasResetPosition = true;
                    post(new Runnable() {
                        public void run() {
                            LeftAlignCompatibleTipsView leftAlignCompatibleTipsView = LeftAlignCompatibleTipsView.this;
                            leftAlignCompatibleTipsView.mOldWidth = leftAlignCompatibleTipsView.getMeasuredWidth();
                            LeftAlignCompatibleTipsView leftAlignCompatibleTipsView2 = LeftAlignCompatibleTipsView.this;
                            leftAlignCompatibleTipsView2.mOldHeight = leftAlignCompatibleTipsView2.getMeasuredHeight();
                            ViewGroup.LayoutParams layoutParams = LeftAlignCompatibleTipsView.this.getLayoutParams();
                            layoutParams.width = LeftAlignCompatibleTipsView.this.mAnchorLoc[0];
                            LeftAlignCompatibleTipsView.this.setLayoutParams(layoutParams);
                        }
                    });
                    return;
                }
            }
            if (this.mHasResetPosition && this.mOldHeight > 0 && this.mOldWidth > 0) {
                offsetLeftAndRight((this.mAnchorLoc[0] + this.mPx) - getMeasuredWidth());
                offsetTopAndBottom(this.mOldHeight - getMeasuredHeight());
                this.mHasResetPosition = false;
            }
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public class AnchorMoveMonitor implements ViewTreeObserver.OnPreDrawListener {
        private LinkedList<MoveMonitorHolder> mHolders = new LinkedList<>();

        AnchorMoveMonitor() {
            if (GlobalTipsContainer.this.getViewTreeObserver() != null) {
                GlobalTipsContainer.this.getViewTreeObserver().addOnPreDrawListener(this);
            }
            GlobalTipsContainer.this.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(GlobalTipsContainer.this) {
                public void onViewAttachedToWindow(View view) {
                    GLog.m7965d("hzd", "AnchorMoveMonitor, onViewAttachedToWindow");
                    if (GlobalTipsContainer.this.getViewTreeObserver() != null) {
                        GlobalTipsContainer.this.getViewTreeObserver().addOnPreDrawListener(AnchorMoveMonitor.this);
                    }
                }

                public void onViewDetachedFromWindow(View view) {
                    GLog.m7965d("hzd", "AnchorMoveMonitor, onViewDetachedFromWindow");
                    if (GlobalTipsContainer.this.getViewTreeObserver() != null) {
                        GlobalTipsContainer.this.getViewTreeObserver().removeOnPreDrawListener(AnchorMoveMonitor.this);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void startMonitor(View view, TipsView tipsView, int i) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            MoveMonitorHolder moveMonitorHolder = new MoveMonitorHolder();
            View unused = moveMonitorHolder.mAnchor = view;
            TipsView unused2 = moveMonitorHolder.mTipsView = tipsView;
            int[] unused3 = moveMonitorHolder.mLoc = iArr;
            int unused4 = moveMonitorHolder.mHorPos = i;
            this.mHolders.add(moveMonitorHolder);
        }

        public boolean onPreDraw() {
            Iterator it = this.mHolders.iterator();
            while (it.hasNext()) {
                MoveMonitorHolder moveMonitorHolder = (MoveMonitorHolder) it.next();
                int[] iArr = new int[2];
                moveMonitorHolder.mAnchor.getLocationInWindow(iArr);
                int i = iArr[0] - moveMonitorHolder.mLoc[0];
                int i2 = iArr[1] - moveMonitorHolder.mLoc[1];
                if (i != 0) {
                    moveMonitorHolder.mTipsView.offsetLeftAndRight(i);
                }
                if (i2 != 0) {
                    moveMonitorHolder.mTipsView.offsetTopAndBottom(i2);
                }
                int[] unused = moveMonitorHolder.mLoc = iArr;
            }
            return true;
        }

        public void clear() {
            GLog.m7965d("hzd", "@clear, removeOnPreDrawListener...");
            LinkedList<MoveMonitorHolder> linkedList = this.mHolders;
            if (linkedList != null) {
                linkedList.clear();
            }
            if (GlobalTipsContainer.this.getViewTreeObserver() != null) {
                GlobalTipsContainer.this.getViewTreeObserver().removeOnPreDrawListener(this);
            }
        }

        class MoveMonitorHolder {
            /* access modifiers changed from: private */
            public View mAnchor;
            /* access modifiers changed from: private */
            public int mHorPos;
            /* access modifiers changed from: private */
            public int[] mLoc;
            /* access modifiers changed from: private */
            public TipsView mTipsView;

            MoveMonitorHolder() {
            }
        }
    }
}
