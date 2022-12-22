package com.didi.hawaii.p118ar.view;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.p118ar.core.ThemeManager;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.GuideView */
public class GuideView {

    /* renamed from: a */
    PopupWindow f23406a;

    /* renamed from: b */
    Context f23407b;

    /* renamed from: c */
    OnGuideViewDissMissListener f23408c;

    /* renamed from: d */
    ViewGroup f23409d;

    /* renamed from: e */
    ImageView f23410e;

    /* renamed from: f */
    ImageView f23411f;

    /* renamed from: g */
    Button f23412g;

    /* renamed from: h */
    ObjectAnimator f23413h;

    /* renamed from: i */
    int[] f23414i = new int[2];

    /* renamed from: j */
    int[] f23415j = new int[2];
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Dialog f23416k;

    /* renamed from: com.didi.hawaii.ar.view.GuideView$OnGuideViewDissMissListener */
    public interface OnGuideViewDissMissListener {
        void onDisMiss();
    }

    public GuideView(Context context, ViewGroup viewGroup) {
        this.f23407b = context;
        this.f23409d = viewGroup;
    }

    public GuideView builder() {
        View inflate = LayoutInflater.from(this.f23407b).inflate(R.layout.view_guide, (ViewGroup) null);
        this.f23411f = (ImageView) inflate.findViewById(R.id.phone_bg);
        this.f23412g = (Button) inflate.findViewById(R.id.guide_cancle);
        Dialog dialog = this.f23416k;
        if (dialog != null && dialog.isShowing()) {
            this.f23416k.dismiss();
        }
        if (this.f23416k == null) {
            this.f23416k = new Dialog(this.f23407b, R.style.AlertDialogStyle);
        }
        this.f23416k.setContentView(inflate);
        this.f23416k.setCancelable(false);
        Button button = this.f23412g;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GuideView.this.f23416k.dismiss();
                    if (GuideView.this.f23408c != null) {
                        GuideView.this.f23408c.onDisMiss();
                    }
                }
            });
        }
        m16736a(inflate);
        return this;
    }

    /* renamed from: a */
    private void m16736a(View view) {
        ThemeManager.getInstance().changeViewTheme((TextView) view.findViewById(R.id.guide_title_tv), R.id.guide_title_tv);
        ThemeManager.getInstance().changeViewTheme((TextView) view.findViewById(R.id.guide_2_tv), R.id.guide_2_tv);
    }

    public GuideView setCanclebleOutside(boolean z) {
        PopupWindow popupWindow = this.f23406a;
        if (popupWindow != null) {
            popupWindow.setOutsideTouchable(z);
        }
        return this;
    }

    public GuideView setDisMissListener(OnGuideViewDissMissListener onGuideViewDissMissListener) {
        this.f23408c = onGuideViewDissMissListener;
        return this;
    }

    public void show() {
        Dialog dialog = this.f23416k;
        if (dialog != null) {
            SystemUtils.showDialog(dialog);
        }
    }
}
