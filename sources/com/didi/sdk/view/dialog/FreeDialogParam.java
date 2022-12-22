package com.didi.sdk.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FreeDialogParam {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FreeDialog f37968a;

    /* renamed from: b */
    private Setting f37969b;

    /* renamed from: c */
    private ViewGroup f37970c;

    /* renamed from: d */
    private FrameLayout f37971d;

    /* renamed from: e */
    private View f37972e;

    /* renamed from: f */
    private ImageView f37973f;

    /* renamed from: g */
    private TextView f37974g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f37975h;

    /* renamed from: i */
    private View f37976i;

    /* renamed from: j */
    private LinearLayout f37977j;

    /* renamed from: k */
    private boolean f37978k;

    public enum IconType {
        INFO,
        HEART,
        ADDRESS,
        MICRO,
        GPS,
        RIGHT,
        FACE,
        RED,
        PAY,
        GUIDE,
        TIME,
        COUPON,
        CRASH,
        PINK,
        DYNAPRIC,
        HUAWEI,
        CHANNEL,
        COOLPAD,
        WIFI,
        HUAWEI_RONGYAO,
        BAIDU,
        YINGYONGBAO,
        JINLI_YIYONGHUI,
        MEIZU,
        ANZHI,
        SAMSUNG,
        SAMSUNG_S6,
        TIANYU,
        TUXING,
        WANDOUJIA,
        TXSHOUJIGUANJIA,
        SMARTISAN,
        LENOVO,
        HONGBAO,
        WHITECORRECT
    }

    public interface OnClickListener {
        void onClick(FreeDialog freeDialog, View view);
    }

    public interface OnCloseListener {
        void onDismiss(FreeDialog freeDialog);
    }

    public enum Orientation {
        AUTO,
        VERTICAL,
        HORIZONTAL
    }

    FreeDialogParam(Setting setting, FreeDialog freeDialog) {
        this.f37969b = setting;
        this.f37968a = freeDialog;
        m26879c();
    }

    /* renamed from: c */
    private void m26879c() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f37969b.mContext).inflate(R.layout.layout_common_free_dialog, (ViewGroup) null);
        this.f37970c = viewGroup;
        this.f37971d = (FrameLayout) viewGroup.findViewById(R.id.fl_custom_root);
        this.f37973f = (ImageView) this.f37970c.findViewById(R.id.image_icon);
        View findViewById = this.f37970c.findViewById(R.id.image_close);
        this.f37972e = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FreeDialogParam.this.f37968a.dismiss();
            }
        });
        this.f37974g = (TextView) this.f37970c.findViewById(R.id.text_title);
        this.f37975h = (TextView) this.f37970c.findViewById(R.id.text_message);
        this.f37976i = this.f37970c.findViewById(R.id.line_divider_content);
        this.f37977j = (LinearLayout) this.f37970c.findViewById(R.id.ll_btn_area_horizontal);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97497a() {
        int i;
        if (!this.f37978k) {
            this.f37978k = true;
            Dialog dialog = this.f37968a.getDialog();
            if (!(dialog == null || dialog.getWindow() == null)) {
                android.view.Window window = dialog.getWindow();
                int i2 = this.f37969b.mWindow.width;
                if (i2 == 0) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    this.f37968a.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    i2 = (int) (((double) displayMetrics.widthPixels) * 0.712d);
                }
                window.setLayout(i2, -2);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = this.f37969b.mWindow.dimAmount >= 0.0f ? this.f37969b.mWindow.dimAmount : 0.4f;
                attributes.flags |= 2;
                attributes.windowAnimations = this.f37969b.mWindow.windowAnimations >= 0 ? this.f37969b.mWindow.windowAnimations : R.style.common_dialog_anim_style;
                window.setAttributes(attributes);
                window.setGravity(this.f37969b.mWindow.gravity);
                window.setBackgroundDrawable(this.f37969b.mWindow.drawable != null ? this.f37969b.mWindow.drawable : new ColorDrawable(0));
            }
            if (this.f37969b.mBackgroundColor != 0) {
                this.f37970c.setBackgroundColor(this.f37969b.mBackgroundColor);
            } else if (this.f37969b.mBackgroundDrawable != null) {
                this.f37970c.setBackgroundDrawable(this.f37969b.mBackgroundDrawable);
            }
            int i3 = 8;
            this.f37972e.setVisibility(this.f37969b.mCloseVisible ? 0 : 8);
            this.f37968a.setCancelable(this.f37969b.mCancelable);
            Orientation orientation = Orientation.HORIZONTAL;
            int i4 = Integer.MAX_VALUE;
            android.view.Window window2 = this.f37968a.getDialog().getWindow();
            if (this.f37969b.mOrientation == Orientation.AUTO && !this.f37969b.mButtons.isEmpty() && window2 != null) {
                i4 = window2.getAttributes().width / this.f37969b.mButtons.size();
            }
            for (Button next : this.f37969b.mButtons) {
                View inflate = LayoutInflater.from(this.f37969b.mContext).inflate(R.layout.btn_common_free_dialog, this.f37977j, false);
                android.widget.Button button = (android.widget.Button) inflate.findViewById(R.id.button);
                button.setText(next.text);
                if (next.backgroundColor != 0) {
                    button.setBackgroundColor(next.backgroundColor);
                } else if (next.backgroundDrawable != null) {
                    button.setBackgroundDrawable(next.backgroundDrawable);
                }
                if (next.textSize != 0) {
                    button.setTextSize((float) next.textSize);
                }
                if (next.isDefault) {
                    if (this.f37969b.mDefaultButtonColor != 0) {
                        i = this.f37969b.mDefaultButtonColor;
                    } else {
                        i = ContextCompat.getColor(this.f37969b.mContext, R.color.common_dialog_recommend_option_txt_color);
                    }
                    button.setTextColor(i);
                }
                if (next.textColor != 0) {
                    button.setTextColor(next.textColor);
                }
                button.setOnClickListener(new OnClickerListenerAdapter(this.f37968a, button, next.clickListener));
                this.f37977j.addView(inflate);
                if (button.getPaint().measureText(next.text.toString()) > ((float) i4)) {
                    orientation = Orientation.VERTICAL;
                }
            }
            for (int i5 = 0; i5 < this.f37977j.getChildCount(); i5++) {
                View childAt = this.f37977j.getChildAt(i5);
                if (orientation == Orientation.VERTICAL) {
                    childAt.findViewById(R.id.btn_line_bottom).setVisibility(0);
                } else {
                    childAt.findViewById(R.id.btn_line_right).setVisibility(0);
                }
            }
            this.f37977j.setOrientation(orientation == Orientation.VERTICAL ? 1 : 0);
            View view = this.f37976i;
            if (orientation != Orientation.VERTICAL) {
                i3 = 0;
            }
            view.setVisibility(i3);
            if (this.f37969b.mCustomContentView != null) {
                this.f37971d.addView(this.f37969b.mCustomContentView);
                this.f37971d.setVisibility(0);
                return;
            }
            if (this.f37969b.mIcon != null) {
                this.f37973f.setImageDrawable(this.f37969b.mIcon);
                this.f37973f.setVisibility(0);
            } else if (this.f37969b.mIconType != null) {
                this.f37973f.setImageResource(getIcon(this.f37969b.mIconType));
                this.f37973f.setVisibility(0);
            }
            if (!TextUtils.isEmpty(this.f37969b.mTitle)) {
                this.f37974g.setVisibility(0);
                this.f37974g.setText(this.f37969b.mTitle);
                if (this.f37969b.mTitleMultiLine == 0) {
                    this.f37974g.setSingleLine(true);
                    this.f37974g.setMaxLines(1);
                } else {
                    this.f37974g.setSingleLine(false);
                    this.f37974g.setMaxLines(this.f37969b.mTitleMultiLine);
                }
                if (this.f37969b.mTitleSize != 0) {
                    this.f37974g.setTextSize((float) this.f37969b.mTitleSize);
                }
                if (this.f37969b.mTitleColor != 0) {
                    this.f37974g.setTextColor(this.f37969b.mTitleColor);
                }
            }
            if (!TextUtils.isEmpty(this.f37969b.mMessage)) {
                this.f37975h.setVisibility(0);
                this.f37975h.setText(this.f37969b.mMessage);
                if (this.f37969b.mMessageSize != 0) {
                    this.f37975h.setTextSize((float) this.f37969b.mMessageSize);
                }
                if (this.f37969b.mMessageColor != 0) {
                    this.f37975h.setTextColor(this.f37969b.mMessageColor);
                }
                if (this.f37969b.mMessageGravity != -1) {
                    this.f37975h.setGravity(this.f37969b.mMessageGravity);
                    return;
                }
                final float measureText = this.f37975h.getPaint().measureText(this.f37969b.mMessage.toString());
                this.f37975h.post(new Runnable() {
                    public void run() {
                        if (measureText > ((float) FreeDialogParam.this.f37975h.getWidth())) {
                            FreeDialogParam.this.f37975h.setGravity(GravityCompat.START);
                        }
                    }
                });
            }
        }
    }

    static class Setting {
        int mBackgroundColor;
        Drawable mBackgroundDrawable;
        List<Button> mButtons = new ArrayList();
        boolean mCancelable = true;
        boolean mCloseVisible = true;
        Context mContext;
        View mCustomContentView;
        int mDefaultButtonColor;
        boolean mDiverContentLineVisible = true;
        Drawable mIcon;
        IconType mIconType;
        CharSequence mMessage;
        int mMessageColor;
        int mMessageGravity = -1;
        int mMessageSize;
        OnCloseListener mOnCloseListener;
        Orientation mOrientation = Orientation.AUTO;
        CharSequence mTitle;
        int mTitleColor;
        int mTitleMultiLine;
        int mTitleSize;
        Window mWindow = new Window();

        Setting() {
        }
    }

    public static class Button {
        /* access modifiers changed from: private */
        public int backgroundColor;
        /* access modifiers changed from: private */
        public Drawable backgroundDrawable;
        /* access modifiers changed from: private */
        public OnClickListener clickListener;
        /* access modifiers changed from: private */
        public boolean isDefault;
        /* access modifiers changed from: private */
        public CharSequence text;
        /* access modifiers changed from: private */
        public int textColor;
        /* access modifiers changed from: private */
        public int textSize;

        private Button() {
        }

        public static class Builder {
            private Button mButton;

            public Builder(CharSequence charSequence) {
                Button button = new Button();
                this.mButton = button;
                CharSequence unused = button.text = charSequence;
            }

            public Builder setBackgroundColor(int i) {
                int unused = this.mButton.backgroundColor = i;
                return this;
            }

            public Builder setBackgroundDrawable(Drawable drawable) {
                Drawable unused = this.mButton.backgroundDrawable = drawable;
                return this;
            }

            public Builder setTextColor(int i) {
                int unused = this.mButton.textColor = i;
                return this;
            }

            public Builder setTextSize(int i) {
                int unused = this.mButton.textSize = i;
                return this;
            }

            public Builder setDefault() {
                boolean unused = this.mButton.isDefault = true;
                return this;
            }

            public Builder setClickListener(OnClickListener onClickListener) {
                OnClickListener unused = this.mButton.clickListener = onClickListener;
                return this;
            }

            public Button build() {
                return this.mButton;
            }
        }
    }

    public static class Window {
        float dimAmount;
        Drawable drawable;
        int gravity;
        int height;
        int width;
        int windowAnimations;

        private Window() {
            this.dimAmount = -1.0f;
            this.gravity = 17;
            this.windowAnimations = -1;
        }

        public static class Builder {
            Window mWindow = new Window();

            public Builder setWidth(int i) {
                this.mWindow.width = i;
                return this;
            }

            public Builder setDimAmount(float f) {
                this.mWindow.dimAmount = f;
                return this;
            }

            public Builder setGravity(int i) {
                this.mWindow.gravity = i;
                return this;
            }

            public Builder setBackgroundDrawable(Drawable drawable) {
                this.mWindow.drawable = drawable;
                return this;
            }

            public Builder setWindowAnimations(int i) {
                this.mWindow.windowAnimations = i;
                return this;
            }

            public Window build() {
                return this.mWindow;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo97498b() {
        return this.f37970c;
    }

    private static class OnClickerListenerAdapter implements View.OnClickListener {
        FreeDialog mDialog;
        OnClickListener mOnClickListener;
        View mView;

        OnClickerListenerAdapter(FreeDialog freeDialog, View view, OnClickListener onClickListener) {
            this.mDialog = freeDialog;
            this.mView = view;
            this.mOnClickListener = onClickListener;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this.mDialog, this.mView);
            }
        }
    }

    /* renamed from: com.didi.sdk.view.dialog.FreeDialogParam$3 */
    static /* synthetic */ class C132263 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType;

        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|(3:65|66|68)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|68) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0150 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x015c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0174 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0180 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.view.dialog.FreeDialogParam$IconType[] r0 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType = r0
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.HEART     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.ADDRESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.MICRO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.GPS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.PAY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.GUIDE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.TIME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.COUPON     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.CRASH     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.CHANNEL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.COOLPAD     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.WIFI     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.PINK     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.HUAWEI     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.HUAWEI_RONGYAO     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.BAIDU     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.RIGHT     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.YINGYONGBAO     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.JINLI_YIYONGHUI     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.MEIZU     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.ANZHI     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.SAMSUNG     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.TIANYU     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x012c }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.TUXING     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.WANDOUJIA     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.TXSHOUJIGUANJIA     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.SMARTISAN     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x015c }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.LENOVO     // Catch:{ NoSuchFieldError -> 0x015c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0168 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.HONGBAO     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0174 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.SAMSUNG_S6     // Catch:{ NoSuchFieldError -> 0x0174 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0174 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0174 }
            L_0x0174:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x0180 }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.DYNAPRIC     // Catch:{ NoSuchFieldError -> 0x0180 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0180 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0180 }
            L_0x0180:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType     // Catch:{ NoSuchFieldError -> 0x018c }
                com.didi.sdk.view.dialog.FreeDialogParam$IconType r1 = com.didi.sdk.view.dialog.FreeDialogParam.IconType.WHITECORRECT     // Catch:{ NoSuchFieldError -> 0x018c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018c }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x018c }
            L_0x018c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.view.dialog.FreeDialogParam.C132263.<clinit>():void");
        }
    }

    public int getIcon(IconType iconType) {
        switch (C132263.$SwitchMap$com$didi$sdk$view$dialog$FreeDialogParam$IconType[iconType.ordinal()]) {
            case 2:
                return R.drawable.common_dialog_icon_heart;
            case 3:
                return R.drawable.common_dialog_icon_address;
            case 4:
                return R.drawable.common_dialog_icon_micro_error;
            case 5:
                return R.drawable.common_dialog_icon_gps_error;
            case 6:
                return R.drawable.common_dialog_icon_pay;
            case 7:
                return R.drawable.common_dialog_cancel_guide_icon;
            case 8:
                return R.drawable.dialog_icn_time;
            case 9:
            case 14:
                return R.drawable.dialog_ad_pic_ticket;
            case 10:
                return R.drawable.common_dialog_icon_crash;
            case 11:
            case 12:
                return R.drawable.common_dialog_icon_channel;
            case 13:
                return R.drawable.common_dialog_icon_wifi;
            case 15:
                return R.drawable.common_dialog_icon_huawei;
            case 16:
                return R.drawable.common_dialog_icon_rongyao;
            case 17:
                return R.drawable.common_dialog_icon_baidu;
            case 18:
                return R.drawable.dialog_icon_correct;
            case 19:
                return R.drawable.common_dialog_icon_yingyongbao;
            case 20:
                return R.drawable.common_dialog_icon_jinli;
            case 21:
                return R.drawable.common_dialog_icon_meizu;
            case 22:
                return R.drawable.common_dialog_icon_anzhi;
            case 23:
                return R.drawable.common_dialog_icon_samsung;
            case 24:
                return R.drawable.common_dialog_icon_tianyu;
            case 25:
                return R.drawable.common_dialog_icon_tuxing;
            case 26:
                return R.drawable.common_dialog_icon_wandoujia;
            case 27:
                return R.drawable.common_dialog_icon_txshoujiguanjia;
            case 28:
                return R.drawable.common_dialog_icon_smartisan;
            case 29:
                return R.drawable.common_dialog_icon_lenovo;
            case 30:
                return R.drawable.common_dialog_icon_hongbao;
            case 31:
                return R.drawable.common_dialog_icon_samsung_s6;
            case 32:
                return R.drawable.common_dialog_icon_price_rising;
            case 33:
                return R.drawable.common_dialog_icon_white_correct;
            default:
                return R.drawable.common_dialog_icon_info;
        }
    }
}
