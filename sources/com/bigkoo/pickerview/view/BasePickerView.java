package com.bigkoo.pickerview.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.OnDismissListener;
import com.bigkoo.pickerview.utils.PickerViewAnimateUtil;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class BasePickerView {

    /* renamed from: a */
    private Context f2090a;
    protected int animGravity = 80;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f2091b;

    /* renamed from: c */
    private ViewGroup f2092c;
    protected View clickView;
    protected ViewGroup contentContainer;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnDismissListener f2093d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f2094e;

    /* renamed from: f */
    private Animation f2095f;

    /* renamed from: g */
    private Animation f2096g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f2097h;

    /* renamed from: i */
    private Dialog f2098i;

    /* renamed from: j */
    private boolean f2099j = true;

    /* renamed from: k */
    private View.OnKeyListener f2100k = new View.OnKeyListener() {
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0 || !BasePickerView.this.isShowing()) {
                return false;
            }
            BasePickerView.this.dismiss();
            return true;
        }
    };

    /* renamed from: l */
    private final View.OnTouchListener f2101l = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BasePickerView.this.dismiss();
            return false;
        }
    };
    protected PickerOptions mPickerOptions;

    /* access modifiers changed from: protected */
    public void initEvents() {
    }

    public boolean isDialog() {
        return false;
    }

    public BasePickerView(Context context) {
        this.f2090a = context;
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f2090a);
        if (isDialog()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f2092c = viewGroup;
            viewGroup.setBackgroundColor(0);
            this.contentContainer = (ViewGroup) this.f2092c.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.contentContainer.setLayoutParams(layoutParams);
            createDialog();
            this.f2092c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BasePickerView.this.dismiss();
                }
            });
        } else {
            if (this.mPickerOptions.decorView == null) {
                this.mPickerOptions.decorView = (ViewGroup) ((Activity) this.f2090a).getWindow().getDecorView();
            }
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.mPickerOptions.decorView, false);
            this.f2091b = viewGroup2;
            viewGroup2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.mPickerOptions.outSideColor != -1) {
                this.f2091b.setBackgroundColor(this.mPickerOptions.outSideColor);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f2091b.findViewById(R.id.content_container);
            this.contentContainer = viewGroup3;
            viewGroup3.setLayoutParams(layoutParams);
        }
        setKeyBackCancelable(true);
    }

    /* access modifiers changed from: protected */
    public void initAnim() {
        this.f2096g = m1718a();
        this.f2095f = m1721b();
    }

    public void show(View view, boolean z) {
        this.clickView = view;
        this.f2099j = z;
        show();
    }

    public void show(boolean z) {
        show((View) null, z);
    }

    public void show(View view) {
        this.clickView = view;
        show();
    }

    public void show() {
        if (isDialog()) {
            m1724c();
        } else if (!isShowing()) {
            this.f2097h = true;
            m1719a((View) this.f2091b);
            this.f2091b.requestFocus();
        }
    }

    /* renamed from: a */
    private void m1719a(View view) {
        this.mPickerOptions.decorView.addView(view);
        if (this.f2099j) {
            this.contentContainer.startAnimation(this.f2096g);
        }
    }

    public boolean isShowing() {
        if (isDialog()) {
            return false;
        }
        if (this.f2091b.getParent() != null || this.f2097h) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        if (isDialog()) {
            m1725d();
        } else if (!this.f2094e) {
            if (this.f2099j) {
                this.f2095f.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        BasePickerView.this.dismissImmediately();
                    }
                });
                this.contentContainer.startAnimation(this.f2095f);
            } else {
                dismissImmediately();
            }
            this.f2094e = true;
        }
    }

    public void dismissImmediately() {
        this.mPickerOptions.decorView.post(new Runnable() {
            public void run() {
                BasePickerView.this.mPickerOptions.decorView.removeView(BasePickerView.this.f2091b);
                boolean unused = BasePickerView.this.f2097h = false;
                boolean unused2 = BasePickerView.this.f2094e = false;
                if (BasePickerView.this.f2093d != null) {
                    BasePickerView.this.f2093d.onDismiss(BasePickerView.this);
                }
            }
        });
    }

    /* renamed from: a */
    private Animation m1718a() {
        return AnimationUtils.loadAnimation(this.f2090a, PickerViewAnimateUtil.getAnimationResource(this.animGravity, true));
    }

    /* renamed from: b */
    private Animation m1721b() {
        return AnimationUtils.loadAnimation(this.f2090a, PickerViewAnimateUtil.getAnimationResource(this.animGravity, false));
    }

    public BasePickerView setOnDismissListener(OnDismissListener onDismissListener) {
        this.f2093d = onDismissListener;
        return this;
    }

    public void setKeyBackCancelable(boolean z) {
        ViewGroup viewGroup;
        if (isDialog()) {
            viewGroup = this.f2092c;
        } else {
            viewGroup = this.f2091b;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.f2100k);
        } else {
            viewGroup.setOnKeyListener((View.OnKeyListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public BasePickerView setOutSideCancelable(boolean z) {
        ViewGroup viewGroup = this.f2091b;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.f2101l);
            } else {
                findViewById.setOnTouchListener((View.OnTouchListener) null);
            }
        }
        return this;
    }

    public void setDialogOutSideCancelable() {
        Dialog dialog = this.f2098i;
        if (dialog != null) {
            dialog.setCancelable(this.mPickerOptions.cancelable);
        }
    }

    public View findViewById(int i) {
        return this.contentContainer.findViewById(i);
    }

    public void createDialog() {
        if (this.f2092c != null) {
            Dialog dialog = new Dialog(this.f2090a, R.style.custom_dialog2);
            this.f2098i = dialog;
            dialog.setCancelable(this.mPickerOptions.cancelable);
            this.f2098i.setContentView(this.f2092c);
            Window window = this.f2098i.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.f2098i.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (BasePickerView.this.f2093d != null) {
                        BasePickerView.this.f2093d.onDismiss(BasePickerView.this);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    private void m1724c() {
        Dialog dialog = this.f2098i;
        if (dialog != null) {
            SystemUtils.showDialog(dialog);
        }
    }

    /* renamed from: d */
    private void m1725d() {
        Dialog dialog = this.f2098i;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public ViewGroup getDialogContainerLayout() {
        return this.contentContainer;
    }

    public Dialog getDialog() {
        return this.f2098i;
    }
}
