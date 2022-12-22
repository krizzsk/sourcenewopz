package com.didi.beatles.p099im.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.views.bottombar.IMBottomSkinManager;
import com.didi.beatles.p099im.views.bottombar.IMConversationBottomBar;
import com.didi.beatles.p099im.views.bottombar.IMSkinTextView;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.utils.IMEmotionInputDetector */
public class IMEmotionInputDetector {

    /* renamed from: b */
    private static final String f9753b = IMEmotionInputDetector.class.getSimpleName();

    /* renamed from: c */
    private static final String f9754c = "com.dss886.emotioninputdetector";

    /* renamed from: d */
    private static final String f9755d = "soft_input_height";
    public static int keyboardHeight = 0;

    /* renamed from: a */
    IMConversationBottomBar f9756a;

    /* renamed from: e */
    private Activity f9757e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public InputMethodManager f9758f;

    /* renamed from: g */
    private SharedPreferences f9759g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f9760h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public EditText f9761i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f9762j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IMSkinTextView f9763k;

    /* renamed from: l */
    private List<OnHideSoftInputListener> f9764l = new ArrayList();

    /* renamed from: com.didi.beatles.im.utils.IMEmotionInputDetector$OnHideSoftInputListener */
    public interface OnHideSoftInputListener {
        void onHideSoft(IMEmotionInputDetector iMEmotionInputDetector);
    }

    private IMEmotionInputDetector() {
    }

    public static IMEmotionInputDetector with(Activity activity) {
        IMEmotionInputDetector iMEmotionInputDetector = new IMEmotionInputDetector();
        iMEmotionInputDetector.f9757e = activity;
        iMEmotionInputDetector.f9758f = (InputMethodManager) activity.getSystemService("input_method");
        iMEmotionInputDetector.f9759g = SystemUtils.getSharedPreferences(activity, f9754c, 0);
        keyboardHeight = iMEmotionInputDetector.getKeyboardHeight();
        return iMEmotionInputDetector;
    }

    public void addListener(OnHideSoftInputListener onHideSoftInputListener) {
        this.f9764l.add(onHideSoftInputListener);
    }

    public void removeListener(OnHideSoftInputListener onHideSoftInputListener) {
        this.f9764l.remove(onHideSoftInputListener);
    }

    public IMEmotionInputDetector bindToContent(View view) {
        this.f9762j = view;
        return this;
    }

    public IMEmotionInputDetector bindToEditText(EditText editText) {
        this.f9761i = editText;
        editText.requestFocus();
        this.f9761i.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    IMEmotionInputDetector.this.f9763k.showCommonSkin();
                }
                if (motionEvent.getAction() != 1 || !IMEmotionInputDetector.this.f9760h.isShown()) {
                    return false;
                }
                IMEmotionInputDetector.this.m6608b();
                IMEmotionInputDetector.this.m6604a(true);
                IMEmotionInputDetector.this.f9761i.postDelayed(new Runnable() {
                    public void run() {
                        IMEmotionInputDetector.this.m6611d();
                    }
                }, 200);
                return false;
            }
        });
        return this;
    }

    public IMEmotionInputDetector bindToCommonButton(View view) {
        this.f9763k = (IMSkinTextView) view;
        return this;
    }

    public boolean isTagExpandShow(String str) {
        return this.f9760h.isShown() && str.equals(this.f9760h.getTag());
    }

    public void changeExpandView(String str, boolean z) {
        if (str.equals(this.f9760h.getTag()) || !this.f9760h.isShown()) {
            m6602a((View) this.f9763k);
        }
        this.f9760h.setTag(str);
        IMSkinTextView iMSkinTextView = this.f9763k;
        if (iMSkinTextView == null) {
            return;
        }
        if (!z) {
            iMSkinTextView.showCommonSkin();
        } else if (this.f9760h.isShown()) {
            this.f9763k.showCustomSkin(IMBottomSkinManager.KEY_BOARD);
        } else {
            this.f9763k.showCommonSkin();
        }
    }

    /* renamed from: a */
    private void m6602a(View view) {
        if (this.f9760h.isShown()) {
            m6608b();
            m6604a(true);
            m6611d();
        } else {
            if (isSoftInputShown()) {
                m6608b();
                m6601a();
                m6611d();
            } else {
                m6601a();
            }
            IMConversationBottomBar iMConversationBottomBar = this.f9756a;
            if (!(iMConversationBottomBar == null || iMConversationBottomBar.getBottomBarListener() == null)) {
                this.f9756a.getBottomBarListener().onEditFocus();
            }
        }
        view.postDelayed(new Runnable() {
            public void run() {
                IMEmotionInputDetector.this.f9756a.setModeKeyboard(true);
            }
        }, 10);
    }

    public IMEmotionInputDetector setEmotionView(View view) {
        this.f9760h = view;
        if (getKeyboardHeight() != 0) {
            ViewGroup.LayoutParams layoutParams = this.f9760h.getLayoutParams();
            layoutParams.height = getKeyboardHeight();
            this.f9760h.setLayoutParams(layoutParams);
        }
        return this;
    }

    public IMEmotionInputDetector bindToBottom(IMConversationBottomBar iMConversationBottomBar) {
        this.f9756a = iMConversationBottomBar;
        return this;
    }

    public IMEmotionInputDetector build() {
        this.f9757e.getWindow().setSoftInputMode(19);
        hideSoftInput();
        return this;
    }

    public boolean interceptBackPress() {
        m6609c();
        if (!this.f9760h.isShown()) {
            return false;
        }
        m6604a(false);
        return true;
    }

    /* renamed from: a */
    private void m6601a() {
        int i = this.f9759g.getInt(f9755d, IMViewUtil.dp2px(this.f9757e, (float) IMViewUtil.getDefaultKeyBoardHeight()));
        hideSoftInput();
        this.f9760h.getLayoutParams().height = i;
        this.f9760h.setVisibility(0);
        IMSkinTextView iMSkinTextView = this.f9763k;
        if (iMSkinTextView != null) {
            iMSkinTextView.showCustomSkin(IMBottomSkinManager.KEY_BOARD);
        }
    }

    public int getKeyboardHeight() {
        SharedPreferences sharedPreferences = this.f9759g;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(f9755d, IMViewUtil.dp2px(this.f9757e, (float) IMViewUtil.getDefaultKeyBoardHeight()));
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6604a(boolean z) {
        if (this.f9760h.isShown()) {
            IMSkinTextView iMSkinTextView = this.f9763k;
            if (iMSkinTextView != null) {
                iMSkinTextView.showCommonSkin();
            }
            this.f9760h.setVisibility(8);
            if (z) {
                showSoftInput();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6608b() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9762j.getLayoutParams();
        layoutParams.height = this.f9762j.getHeight();
        layoutParams.weight = 0.0f;
    }

    /* renamed from: c */
    private void m6609c() {
        ((LinearLayout.LayoutParams) this.f9762j.getLayoutParams()).weight = 1.0f;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6611d() {
        this.f9761i.postDelayed(new Runnable() {
            public void run() {
                ((LinearLayout.LayoutParams) IMEmotionInputDetector.this.f9762j.getLayoutParams()).weight = 1.0f;
            }
        }, 200);
    }

    public void showSoftInput() {
        this.f9761i.requestFocus();
        this.f9761i.postDelayed(new Runnable() {
            public void run() {
                IMEmotionInputDetector.this.f9758f.showSoftInput(IMEmotionInputDetector.this.f9761i, 0);
            }
        }, 50);
        this.f9761i.postDelayed(new Runnable() {
            public void run() {
                int unused = IMEmotionInputDetector.this.m6606b(true);
            }
        }, 500);
    }

    public void hideSoftInput() {
        try {
            this.f9758f.hideSoftInputFromWindow(this.f9761i.getWindowToken(), 0);
        } catch (RuntimeException e) {
            IMTraceError.trackError("IMEmotionInputDetector#InputManager", e);
        }
        for (OnHideSoftInputListener onHideSoft : new ArrayList(this.f9764l)) {
            onHideSoft.onHideSoft(this);
        }
    }

    public boolean isSoftInputShown() {
        return m6606b(true) > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m6606b(boolean z) {
        Rect rect = new Rect();
        try {
            this.f9757e.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int a = (m6599a(this.f9757e) - rect.bottom) - IMNavigationBarUtil.getNavigationBarHeight(this.f9757e);
            if (a < 0) {
                IMLog.m6637w("IMEmotionInputDetector", "Warning: value of softInputHeight is below zero!");
            }
            if (a <= IMViewUtil.dp2px(this.f9757e, 100.0f)) {
                return 0;
            }
            if (z) {
                this.f9759g.edit().putInt(f9755d, a).apply();
                keyboardHeight = a;
            }
            return a;
        } catch (NullPointerException unused) {
            IMLog.m6632e("im_sdk", "getSupportSoftInputHeight failed because nullPointer!");
            return 0;
        }
    }

    /* renamed from: a */
    private int m6599a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            try {
                activity.getWindowManager().getDefaultDisplay().getRealSize(point);
                return point.y;
            } catch (NoSuchMethodError unused) {
                return 0;
            }
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
    }
}
