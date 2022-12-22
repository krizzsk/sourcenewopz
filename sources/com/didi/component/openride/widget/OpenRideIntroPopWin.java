package com.didi.component.openride.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.taxis99.R;

public class OpenRideIntroPopWin implements View.OnClickListener {
    public static final int OPEN_RIDE_BIND_CARD_GUIDE_POP = 2;
    public static final int OPEN_RIDE_FIRST_GUIDE_POP = 1;

    /* renamed from: a */
    private Context f14753a;

    /* renamed from: b */
    private View f14754b;

    /* renamed from: c */
    private View f14755c;

    /* renamed from: d */
    private PopupWindow f14756d;

    /* renamed from: e */
    private ImageView f14757e;

    /* renamed from: f */
    private TextView f14758f;

    /* renamed from: g */
    private TextView f14759g;

    /* renamed from: h */
    private TextView f14760h;

    /* renamed from: i */
    private TextView f14761i;

    /* renamed from: j */
    private TextView f14762j;

    /* renamed from: k */
    private int f14763k;

    /* renamed from: l */
    private OnBtnClickListener f14764l;

    public interface OnBtnClickListener {
        void btnClick();

        void closeBtnClick();
    }

    public OpenRideIntroPopWin(Context context, View view, int i) {
        this.f14753a = context;
        this.f14754b = view;
        this.f14763k = i;
        m10546a();
    }

    /* renamed from: a */
    private void m10546a() {
        GlobalOmegaUtils.trackEvent(this.f14763k == 1 ? "Pas_99GO_guide_sw" : "Pas_99GO_bindingcard_sw");
        View inflate = LayoutInflater.from(this.f14753a).inflate(R.layout.global_open_ride_intro_pop, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.g_open_ride_intro_pop_close);
        this.f14757e = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.g_open_ride_intro_pop_title);
        this.f14758f = textView;
        textView.setText(String.format(this.f14753a.getResources().getString(R.string.global_open_ride_pop_title), new Object[]{FormStore.getInstance().getOpenRideBrand()}));
        TextView textView2 = (TextView) inflate.findViewById(R.id.g_open_ride_intro_pop_step_1);
        this.f14759g = textView2;
        textView2.setText(R.string.global_open_ride_pop_step1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.g_open_ride_intro_pop_step_2);
        this.f14760h = textView3;
        textView3.setText(R.string.global_open_ride_pop_step2);
        TextView textView4 = (TextView) inflate.findViewById(R.id.g_open_ride_intro_pop_step_3);
        this.f14761i = textView4;
        textView4.setText(R.string.global_open_ride_pop_step3);
        TextView textView5 = (TextView) inflate.findViewById(R.id.g_open_ride_intro_pop_tv);
        this.f14762j = textView5;
        textView5.setText(this.f14763k == 1 ? R.string.global_open_ride_guide_btn : R.string.global_bind_card_guide_btn);
        View findViewById = inflate.findViewById(R.id.g_open_ride_intro_pop_btn);
        this.f14755c = findViewById;
        findViewById.setOnClickListener(this);
        this.f14756d = new PopupWindow(inflate, -1, -1);
    }

    public void show() {
        PopupWindow popupWindow = this.f14756d;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.f14754b, 17, 0, 0);
        }
    }

    public void setOnClickListener(OnBtnClickListener onBtnClickListener) {
        this.f14764l = onBtnClickListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.g_open_ride_intro_pop_close) {
            this.f14756d.dismiss();
            OnBtnClickListener onBtnClickListener = this.f14764l;
            if (onBtnClickListener != null) {
                onBtnClickListener.closeBtnClick();
            }
        } else if (id == R.id.g_open_ride_intro_pop_btn) {
            this.f14756d.dismiss();
            OnBtnClickListener onBtnClickListener2 = this.f14764l;
            if (onBtnClickListener2 != null) {
                onBtnClickListener2.btnClick();
            }
        }
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.f14756d;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
