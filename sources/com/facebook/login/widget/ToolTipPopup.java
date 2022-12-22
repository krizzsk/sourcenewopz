package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000;
    private final WeakReference<View> mAnchorViewRef;
    private final Context mContext;
    private long mNuxDisplayTime = 6000;
    private PopupContentView mPopupContent;
    private PopupWindow mPopupWindow;
    private final ViewTreeObserver.OnScrollChangedListener mScrollListener = new ViewTreeObserver.OnScrollChangedListener() {
        public void onScrollChanged() {
            if (ToolTipPopup.access$000(ToolTipPopup.this).get() != null && ToolTipPopup.access$100(ToolTipPopup.this) != null && ToolTipPopup.access$100(ToolTipPopup.this).isShowing()) {
                if (ToolTipPopup.access$100(ToolTipPopup.this).isAboveAnchor()) {
                    ToolTipPopup.access$200(ToolTipPopup.this).showBottomArrow();
                } else {
                    ToolTipPopup.access$200(ToolTipPopup.this).showTopArrow();
                }
            }
        }
    };
    private Style mStyle = Style.BLUE;
    private final String mText;

    public enum Style {
        BLUE,
        BLACK
    }

    static /* synthetic */ WeakReference access$000(ToolTipPopup toolTipPopup) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return toolTipPopup.mAnchorViewRef;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ PopupWindow access$100(ToolTipPopup toolTipPopup) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return toolTipPopup.mPopupWindow;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static /* synthetic */ PopupContentView access$200(ToolTipPopup toolTipPopup) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return toolTipPopup.mPopupContent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public ToolTipPopup(String str, View view) {
        this.mText = str;
        this.mAnchorViewRef = new WeakReference<>(view);
        this.mContext = view.getContext();
    }

    public void setStyle(Style style) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.mStyle = style;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void show() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.mAnchorViewRef.get() != null) {
                    PopupContentView popupContentView = new PopupContentView(this.mContext);
                    this.mPopupContent = popupContentView;
                    ((TextView) popupContentView.findViewById(R.id.com_facebook_tooltip_bubble_view_text_body)).setText(this.mText);
                    if (this.mStyle == Style.BLUE) {
                        this.mPopupContent.bodyFrame.setBackgroundResource(R.drawable.com_facebook_tooltip_blue_background);
                        this.mPopupContent.bottomArrow.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                        this.mPopupContent.topArrow.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                        this.mPopupContent.xOut.setImageResource(R.drawable.com_facebook_tooltip_blue_xout);
                    } else {
                        this.mPopupContent.bodyFrame.setBackgroundResource(R.drawable.com_facebook_tooltip_black_background);
                        this.mPopupContent.bottomArrow.setImageResource(R.drawable.com_facebook_tooltip_black_bottomnub);
                        this.mPopupContent.topArrow.setImageResource(R.drawable.com_facebook_tooltip_black_topnub);
                        this.mPopupContent.xOut.setImageResource(R.drawable.com_facebook_tooltip_black_xout);
                    }
                    View decorView = ((Activity) this.mContext).getWindow().getDecorView();
                    int width = decorView.getWidth();
                    int height = decorView.getHeight();
                    registerObserver();
                    this.mPopupContent.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
                    PopupWindow popupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
                    this.mPopupWindow = popupWindow;
                    popupWindow.showAsDropDown((View) this.mAnchorViewRef.get());
                    updateArrows();
                    if (this.mNuxDisplayTime > 0) {
                        this.mPopupContent.postDelayed(new Runnable() {
                            public void run() {
                                if (!CrashShieldHandler.isObjectCrashing(this)) {
                                    try {
                                        ToolTipPopup.this.dismiss();
                                    } catch (Throwable th) {
                                        CrashShieldHandler.handleThrowable(th, this);
                                    }
                                }
                            }
                        }, this.mNuxDisplayTime);
                    }
                    this.mPopupWindow.setTouchable(true);
                    this.mPopupContent.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                try {
                                    ToolTipPopup.this.dismiss();
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void setNuxDisplayTime(long j) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.mNuxDisplayTime = j;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void updateArrows() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
                    if (this.mPopupWindow.isAboveAnchor()) {
                        this.mPopupContent.showBottomArrow();
                    } else {
                        this.mPopupContent.showTopArrow();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void dismiss() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                unregisterObserver();
                if (this.mPopupWindow != null) {
                    this.mPopupWindow.dismiss();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void registerObserver() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                unregisterObserver();
                if (this.mAnchorViewRef.get() != null) {
                    ((View) this.mAnchorViewRef.get()).getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void unregisterObserver() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.mAnchorViewRef.get() != null) {
                    ((View) this.mAnchorViewRef.get()).getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private class PopupContentView extends FrameLayout {
        /* access modifiers changed from: private */
        public View bodyFrame;
        /* access modifiers changed from: private */
        public ImageView bottomArrow;
        /* access modifiers changed from: private */
        public ImageView topArrow;
        /* access modifiers changed from: private */
        public ImageView xOut;

        public PopupContentView(Context context) {
            super(context);
            init();
        }

        private void init() {
            LayoutInflater.from(getContext()).inflate(R.layout.com_facebook_tooltip_bubble, this);
            this.topArrow = (ImageView) findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer);
            this.bottomArrow = (ImageView) findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer);
            this.bodyFrame = findViewById(R.id.com_facebook_body_frame);
            this.xOut = (ImageView) findViewById(R.id.com_facebook_button_xout);
        }

        public void showTopArrow() {
            this.topArrow.setVisibility(0);
            this.bottomArrow.setVisibility(4);
        }

        public void showBottomArrow() {
            this.topArrow.setVisibility(4);
            this.bottomArrow.setVisibility(0);
        }
    }
}
