package com.didi.beatles.p099im.views.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.views.dialog.IMAlertDialogFragment;
import com.didi.beatles.p099im.views.richtextview.IMRichTextView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.dialog.IMAlertController */
public class IMAlertController {

    /* renamed from: a */
    private View f10165a;

    /* renamed from: b */
    private ImageView f10166b;

    /* renamed from: c */
    private IMRichTextView f10167c;

    /* renamed from: d */
    private IMRichTextView f10168d;

    /* renamed from: e */
    private Button f10169e;

    /* renamed from: f */
    private Button f10170f;

    /* renamed from: g */
    private Button f10171g;

    /* renamed from: h */
    private FrameLayout f10172h;

    /* renamed from: i */
    private LinearLayout f10173i;

    /* renamed from: j */
    private CheckBox f10174j;

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertController$IconType */
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
        HONGBAO
    }

    public IMAlertController(LayoutInflater layoutInflater) {
        this.f10165a = layoutInflater.inflate(R.layout.im_view_alert_dialog, (ViewGroup) null);
        m6928a();
    }

    public View getLayout() {
        return this.f10165a;
    }

    public void setTitle(CharSequence charSequence) {
        this.f10167c.setVisibility(0);
        if (charSequence.length() > 12) {
            this.f10167c.setText(charSequence.subSequence(0, 12));
            this.f10167c.append("...");
            return;
        }
        this.f10167c.setText(charSequence);
    }

    public void setMessage(CharSequence charSequence) {
        this.f10168d.setVisibility(0);
        this.f10168d.setText(charSequence);
    }

    public void setContentView(View view) {
        this.f10172h.removeAllViews();
        this.f10172h.addView(view);
        this.f10172h.setVisibility(0);
    }

    public void setIcon(Drawable drawable) {
        this.f10166b.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.f10166b.setImageResource(i);
    }

    public void setCheckBoxStatus(boolean z, final IMAlertDialogFragment.RemindCheckboxListener remindCheckboxListener) {
        this.f10173i.setVisibility(z ? 0 : 8);
        this.f10174j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                remindCheckboxListener.onStateChanged(z);
            }
        });
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertController$2 */
    static /* synthetic */ class C43282 {

        /* renamed from: $SwitchMap$com$didi$beatles$im$views$dialog$IMAlertController$IconType */
        static final /* synthetic */ int[] f10175x9da8ba80;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.beatles.im.views.dialog.IMAlertController$IconType[] r0 = com.didi.beatles.p099im.views.dialog.IMAlertController.IconType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10175x9da8ba80 = r0
                com.didi.beatles.im.views.dialog.IMAlertController$IconType r1 = com.didi.beatles.p099im.views.dialog.IMAlertController.IconType.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10175x9da8ba80     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.beatles.im.views.dialog.IMAlertController$IconType r1 = com.didi.beatles.p099im.views.dialog.IMAlertController.IconType.ADDRESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.dialog.IMAlertController.C43282.<clinit>():void");
        }
    }

    public void setIcon(IconType iconType) {
        int i = C43282.f10175x9da8ba80[iconType.ordinal()];
        int i2 = R.drawable.im_common_dialog_icon_info;
        if (i != 1 && i == 2) {
            i2 = R.drawable.im_common_dialog_icon_address;
        }
        setIcon(i2);
    }

    public void setIconVisible(boolean z) {
        this.f10166b.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    private void m6928a() {
        this.f10169e = (Button) this.f10165a.findViewById(R.id.button_positive);
        this.f10170f = (Button) this.f10165a.findViewById(R.id.button_negative);
        this.f10171g = (Button) this.f10165a.findViewById(R.id.button_neutral);
        this.f10166b = (ImageView) this.f10165a.findViewById(R.id.image_icon);
        this.f10167c = (IMRichTextView) this.f10165a.findViewById(R.id.text_title);
        this.f10168d = (IMRichTextView) this.f10165a.findViewById(R.id.text_message);
        this.f10172h = (FrameLayout) this.f10165a.findViewById(R.id.content_view);
        this.f10173i = (LinearLayout) this.f10165a.findViewById(R.id.checkbox_layout);
        this.f10174j = (CheckBox) this.f10165a.findViewById(R.id.checkbox);
        this.f10169e.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
    }

    public void setButton(int i, CharSequence charSequence, View.OnClickListener onClickListener) {
        if (i == -3) {
            this.f10171g.setVisibility(0);
            this.f10171g.setText(charSequence);
            this.f10171g.setOnClickListener(onClickListener);
        } else if (i == -2) {
            this.f10170f.setVisibility(0);
            this.f10170f.setText(charSequence);
            this.f10170f.setOnClickListener(onClickListener);
        } else if (i == -1) {
            this.f10169e.setVisibility(0);
            this.f10169e.setText(charSequence);
            this.f10169e.setOnClickListener(onClickListener);
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertController$AlertParams */
    public static class AlertParams {
        public boolean mCancelable;
        public boolean mCheckboxIsShow;
        public IMAlertDialogFragment.RemindCheckboxListener mCheckboxListener;
        public View mContentView;
        public final Context mContext;
        public Drawable mIcon;
        public int mIconId = 0;
        public IconType mIconType;
        public final LayoutInflater mInflater;
        public boolean mIsIconVisible = true;
        public CharSequence mMessage;
        public IMAlertDialogFragment.ListenerAdapter mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public IMAlertDialogFragment.ListenerAdapter mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public IMAlertDialogFragment.OnCancelListener mOnCancelListener;
        public IMAlertDialogFragment.OnDismissListener mOnDismissListener;
        public IMAlertDialogFragment.ListenerAdapter mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;

        public AlertParams(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void apply(IMAlertDialogFragment iMAlertDialogFragment, IMAlertController iMAlertController) {
            IMAlertDialogFragment.RemindCheckboxListener remindCheckboxListener;
            CharSequence charSequence = this.mTitle;
            if (charSequence != null) {
                iMAlertController.setTitle(charSequence);
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                iMAlertController.setMessage(charSequence2);
            }
            View view = this.mContentView;
            if (view != null) {
                iMAlertController.setContentView(view);
            }
            Drawable drawable = this.mIcon;
            if (drawable != null) {
                iMAlertController.setIcon(drawable);
            }
            int i = this.mIconId;
            if (i > 0) {
                iMAlertController.setIcon(i);
            }
            IconType iconType = this.mIconType;
            if (iconType != null) {
                iMAlertController.setIcon(iconType);
            }
            iMAlertController.setIconVisible(this.mIsIconVisible);
            boolean z = this.mCheckboxIsShow;
            if (z && (remindCheckboxListener = this.mCheckboxListener) != null) {
                iMAlertController.setCheckBoxStatus(z, remindCheckboxListener);
            }
            if (this.mPositiveButtonText != null) {
                IMAlertDialogFragment.ListenerAdapter listenerAdapter = this.mPositiveButtonListener;
                if (listenerAdapter != null) {
                    listenerAdapter.attachAlertDialogFragment(iMAlertDialogFragment);
                }
                iMAlertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener);
            }
            if (this.mNegativeButtonText != null) {
                IMAlertDialogFragment.ListenerAdapter listenerAdapter2 = this.mNegativeButtonListener;
                if (listenerAdapter2 != null) {
                    listenerAdapter2.attachAlertDialogFragment(iMAlertDialogFragment);
                }
                iMAlertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener);
            }
            if (this.mNeutralButtonText != null) {
                IMAlertDialogFragment.ListenerAdapter listenerAdapter3 = this.mNeutralButtonListener;
                if (listenerAdapter3 != null) {
                    listenerAdapter3.attachAlertDialogFragment(iMAlertDialogFragment);
                }
                iMAlertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener);
            }
        }
    }
}
