package com.didi.dimina.container.p106ui.pickerview.view;

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
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.p106ui.pickerview.configure.PickerOptions;
import com.didi.dimina.container.p106ui.pickerview.listener.OnDismissListener;
import com.didi.dimina.container.p106ui.pickerview.utils.PickerViewAnimateUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.pickerview.view.BasePickerView */
public class BasePickerView {

    /* renamed from: a */
    private final Context f17599a;
    protected int animGravity = 80;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f17600b;

    /* renamed from: c */
    private ViewGroup f17601c;
    protected View clickView;
    protected ViewGroup contentContainer;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnDismissListener f17602d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f17603e;

    /* renamed from: f */
    private Animation f17604f;

    /* renamed from: g */
    private Animation f17605g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f17606h;

    /* renamed from: i */
    private Dialog f17607i;

    /* renamed from: j */
    private boolean f17608j = true;

    /* renamed from: k */
    private final View.OnKeyListener f17609k = new View.OnKeyListener() {
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0 || !BasePickerView.this.isShowing()) {
                return false;
            }
            BasePickerView.this.dismiss();
            return true;
        }
    };

    /* renamed from: l */
    private final View.OnTouchListener f17610l = new View.OnTouchListener() {
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
        this.f17599a = context;
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f17599a);
        if (isDialog()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.dimina_layout_basepickerview, (ViewGroup) null, false);
            this.f17601c = viewGroup;
            viewGroup.setBackgroundColor(0);
            this.contentContainer = (ViewGroup) this.f17601c.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.contentContainer.setLayoutParams(layoutParams);
            createDialog();
            this.f17601c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BasePickerView.this.dismiss();
                }
            });
        } else {
            if (this.mPickerOptions.decorView == null) {
                this.mPickerOptions.decorView = (ViewGroup) ((Activity) this.f17599a).getWindow().getDecorView();
            }
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(R.layout.dimina_layout_basepickerview, this.mPickerOptions.decorView, false);
            this.f17600b = viewGroup2;
            viewGroup2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.mPickerOptions.outSideColor != -1) {
                this.f17600b.setBackgroundColor(this.mPickerOptions.outSideColor);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f17600b.findViewById(R.id.content_container);
            this.contentContainer = viewGroup3;
            viewGroup3.setLayoutParams(layoutParams);
        }
        setKeyBackCancelable(true);
    }

    /* access modifiers changed from: protected */
    public void initAnim() {
        this.f17605g = m13096a();
        this.f17604f = m13099b();
    }

    public void show(View view, boolean z) {
        this.clickView = view;
        this.f17608j = z;
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
            m13102c();
        } else if (!isShowing()) {
            this.f17606h = true;
            m13097a((View) this.f17600b);
            this.f17600b.requestFocus();
        }
    }

    /* renamed from: a */
    private void m13097a(View view) {
        this.mPickerOptions.decorView.addView(view);
        if (this.f17608j) {
            this.contentContainer.startAnimation(this.f17605g);
        }
    }

    public boolean isShowing() {
        if (isDialog()) {
            return false;
        }
        if (this.f17600b.getParent() != null || this.f17606h) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        if (isDialog()) {
            m13103d();
        } else if (!this.f17603e) {
            if (this.f17608j) {
                this.f17604f.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        BasePickerView.this.dismissImmediately();
                    }
                });
                this.contentContainer.startAnimation(this.f17604f);
            } else {
                dismissImmediately();
            }
            this.f17603e = true;
        }
    }

    public void dismissImmediately() {
        this.mPickerOptions.decorView.post(new Runnable() {
            public void run() {
                BasePickerView.this.mPickerOptions.decorView.removeView(BasePickerView.this.f17600b);
                boolean unused = BasePickerView.this.f17606h = false;
                boolean unused2 = BasePickerView.this.f17603e = false;
                if (BasePickerView.this.f17602d != null) {
                    BasePickerView.this.f17602d.onDismiss(BasePickerView.this);
                }
            }
        });
    }

    /* renamed from: a */
    private Animation m13096a() {
        return AnimationUtils.loadAnimation(this.f17599a, PickerViewAnimateUtil.getAnimationResource(this.animGravity, true));
    }

    /* renamed from: b */
    private Animation m13099b() {
        return AnimationUtils.loadAnimation(this.f17599a, PickerViewAnimateUtil.getAnimationResource(this.animGravity, false));
    }

    public BasePickerView setOnDismissListener(OnDismissListener onDismissListener) {
        this.f17602d = onDismissListener;
        return this;
    }

    public void setKeyBackCancelable(boolean z) {
        ViewGroup viewGroup;
        if (isDialog()) {
            viewGroup = this.f17601c;
        } else {
            viewGroup = this.f17600b;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.f17609k);
        } else {
            viewGroup.setOnKeyListener((View.OnKeyListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public BasePickerView setOutSideCancelable(boolean z) {
        ViewGroup viewGroup = this.f17600b;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.f17610l);
            } else {
                findViewById.setOnTouchListener((View.OnTouchListener) null);
            }
        }
        return this;
    }

    public void setDialogOutSideCancelable() {
        Dialog dialog = this.f17607i;
        if (dialog != null) {
            dialog.setCancelable(this.mPickerOptions.cancelable);
        }
    }

    public View findViewById(int i) {
        return this.contentContainer.findViewById(i);
    }

    public void createDialog() {
        if (this.f17601c != null) {
            Dialog dialog = new Dialog(this.f17599a, R.style.dimina_pickview_custom_dialog);
            this.f17607i = dialog;
            dialog.setCancelable(this.mPickerOptions.cancelable);
            this.f17607i.setContentView(this.f17601c);
            Window window = this.f17607i.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.dimina_picker_view_scale_anim);
                window.setGravity(17);
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
            }
            this.f17607i.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (BasePickerView.this.f17602d != null) {
                        BasePickerView.this.f17602d.onDismiss(BasePickerView.this);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    private void m13102c() {
        if (this.f17607i != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            getDialogContainerLayout().setLayoutParams(layoutParams);
            Window window = this.f17607i.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.dimina_picker_view_slide_anim);
                window.setGravity(80);
                window.setDimAmount(0.3f);
            }
            SystemUtils.showDialog(this.f17607i);
        }
    }

    /* renamed from: d */
    private void m13103d() {
        Dialog dialog = this.f17607i;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public ViewGroup getDialogContainerLayout() {
        return this.contentContainer;
    }

    public Dialog getDialog() {
        return this.f17607i;
    }
}
