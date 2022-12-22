package com.didi.dimina.container.p106ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.util.ColorUtil;
import com.didi.dimina.container.util.LogUtil;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.dialog.BaseModal */
public class BaseModal extends Dialog {

    /* renamed from: a */
    private View f17541a;

    /* renamed from: b */
    private TextView f17542b;

    /* renamed from: c */
    private RelativeLayout f17543c;

    /* renamed from: d */
    private EditText f17544d;

    /* renamed from: e */
    private ImageView f17545e;

    /* renamed from: f */
    private LinearLayout f17546f;

    /* renamed from: g */
    private FrameLayout f17547g;

    /* renamed from: h */
    private View f17548h;

    /* renamed from: i */
    private ImageView f17549i;

    /* renamed from: j */
    private boolean f17550j;

    /* renamed from: k */
    private boolean f17551k;

    /* renamed from: l */
    private boolean f17552l;
    protected Button mBtnCancel;
    protected Button mBtnSubmit;
    protected View mDivideLine;
    protected View mImgIcon;

    public BaseModal(Context context) {
        this(context, 0);
    }

    public BaseModal(Context context, int i) {
        super(context, i);
        this.f17550j = false;
        m13058a();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = getWindowWidth();
        getWindow().setAttributes(attributes);
    }

    public int getWindowWidth() {
        DisplayMetrics displayMetrics;
        if (getContext() == null || (displayMetrics = getContext().getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    /* renamed from: a */
    private void m13058a() {
        super.setContentView(R.layout.dimina_common_modal);
        View findViewById = findViewById(R.id.layout_title);
        this.f17541a = findViewById;
        findViewById.setVisibility(8);
        this.f17542b = (TextView) findViewById(R.id.title_tv);
        View findViewById2 = findViewById(R.id.ivIcon);
        this.mImgIcon = findViewById2;
        findViewById2.setVisibility(8);
        this.f17545e = (ImageView) findViewById(R.id.ivIconTitle);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.iconTitleLayout);
        this.f17547g = frameLayout;
        frameLayout.setVisibility(8);
        this.f17548h = findViewById(R.id.iconTitlebg);
        this.f17546f = (LinearLayout) findViewById(R.id.msg_layout);
        this.f17543c = (RelativeLayout) findViewById(R.id.layout_content);
        this.f17544d = (EditText) findViewById(R.id.content_et);
        this.mDivideLine = findViewById(R.id.item_btn_sep);
        this.f17549i = (ImageView) findViewById(R.id.imgTitleBg);
        this.mBtnSubmit = (Button) findViewById(R.id.submit_btn);
        this.mBtnCancel = (Button) findViewById(R.id.cancel_btn);
        reset();
    }

    public void reset() {
        this.f17542b.setText("");
        this.f17541a.setVisibility(8);
        this.mBtnSubmit.setText(R.string.dimina_base_modal_confirm);
        this.mBtnCancel.setText(R.string.dimina_base_modal_cancel);
        this.mBtnCancel.setVisibility(8);
        this.mDivideLine.setVisibility(8);
        this.f17544d.setVisibility(8);
        this.f17544d.setHint("");
        this.f17544d.setText("");
        this.f17551k = false;
        this.f17552l = false;
        this.f17544d.setFocusableInTouchMode(true);
        this.f17544d.setFocusable(true);
        this.f17544d.setBackground(getContext().getResources().getDrawable(R.drawable.dimina_common_modal_edit_background));
        this.f17543c.removeAllViews();
    }

    public void setDialogTitle(int i) {
        setDialogTitle(getContext().getString(i));
    }

    public void setDialogTitle(String str) {
        this.f17541a.setVisibility(0);
        this.f17542b.setText(str);
    }

    public void setTitleSize(int i, float f) {
        this.f17542b.setTextSize(i, f);
    }

    public void setPositiveButtonText(String str) {
        this.mBtnSubmit.setText(str);
        this.mBtnSubmit.setVisibility(0);
    }

    public void setPositiveButtonTextColor(String str) {
        this.mBtnSubmit.setTextColor(ColorUtil.parseColor(ColorUtil.convert3To6(str), "#87CEEB"));
    }

    public void setPositiveButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mBtnSubmit.setOnClickListener(onClickListener);
        } else {
            this.mBtnSubmit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BaseModal.this.dismiss();
                }
            });
        }
    }

    public void setNegativeButton(String str) {
        this.mBtnCancel.setText(str);
        if (this.f17550j) {
            this.mBtnCancel.setVisibility(0);
            this.mDivideLine.setVisibility(0);
        }
    }

    public void setNegativeButtonTextColor(String str) {
        this.mBtnCancel.setTextColor(ColorUtil.parseColor(ColorUtil.convert3To6(str), "#333333"));
    }

    public void setNegativeButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mBtnCancel.setOnClickListener(onClickListener);
        } else {
            this.mBtnCancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BaseModal.this.dismiss();
                }
            });
        }
    }

    public void setView(View view) {
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) view.getParent()).removeAllViews();
        }
        this.f17543c.addView(view, new RelativeLayout.LayoutParams(-1, -2));
    }

    public void setView(int i) {
        setView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    public void setContent(String str) {
        this.f17551k = true;
        this.f17544d.setVisibility(0);
        this.f17544d.setText(str);
    }

    public void setPlaceholderText(String str) {
        this.f17544d.setHint(str);
    }

    public void setModalEditable(boolean z) {
        this.f17552l = z;
    }

    public void show() {
        Context context = getContext();
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                LogUtil.m13409e("show dialog bug activity int wrong , activity is finishing ");
                return;
            } else if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                LogUtil.m13409e("show dialog bug activity int wrong , activity is isDestroyed ");
                return;
            }
        } else if (context instanceof ContextThemeWrapper) {
            Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                Activity activity2 = (Activity) baseContext;
                if (activity2.isFinishing()) {
                    LogUtil.m13409e("show dialog bug activity int wrong , baseActivity is finishing ");
                    return;
                } else if (Build.VERSION.SDK_INT >= 17 && activity2.isDestroyed()) {
                    LogUtil.m13409e("show dialog bug activity int wrong , baseActivity is isDestroyed ");
                    return;
                }
            }
        } else {
            LogUtil.m13409e("context is not a Activity or a ContextThemeWrapper");
            return;
        }
        m13059b();
        super.show();
    }

    /* renamed from: b */
    private void m13059b() {
        if (this.f17551k && !this.f17552l) {
            this.f17544d.setBackground((Drawable) null);
            this.f17544d.setFocusableInTouchMode(false);
            this.f17544d.setFocusable(false);
            this.f17544d.setGravity(17);
        } else if (!this.f17552l) {
            this.f17544d.setVisibility(8);
        } else if (!this.f17551k) {
            this.f17544d.setVisibility(0);
        }
    }

    public String getContent() {
        return this.f17552l ? this.f17544d.getText().toString() : "";
    }

    public void setTitleTVMarginTop(int i) {
        if (this.f17543c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17543c.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, i, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            this.f17543c.requestLayout();
        }
    }

    public void showDialog(boolean z) {
        try {
            setCancelable(z);
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FrameLayout getmIconTitleLayout() {
        return this.f17547g;
    }

    public LinearLayout getmMsgLayout() {
        return this.f17546f;
    }

    public ImageView getmImgTitleBg() {
        return this.f17549i;
    }

    public void setShowCancel(boolean z) {
        this.f17550j = z;
        int i = 0;
        this.mBtnCancel.setVisibility(z ? 0 : 8);
        View view = this.mDivideLine;
        if (!this.f17550j) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public boolean isShowCancel() {
        return this.f17550j;
    }
}
