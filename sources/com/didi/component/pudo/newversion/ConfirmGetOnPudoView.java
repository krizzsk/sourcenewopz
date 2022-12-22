package com.didi.component.pudo.newversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.pudo.AbsPudoPresenter;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;

public class ConfirmGetOnPudoView extends AbsPudoView {

    /* renamed from: a */
    private Context f15243a;

    /* renamed from: b */
    private AbsPudoPresenter f15244b;

    /* renamed from: c */
    private View f15245c;

    /* renamed from: d */
    private FrameLayout f15246d;

    public ConfirmGetOnPudoView(Context context, ViewGroup viewGroup) {
        this.f15243a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_confirm_pudo_layout_new_ui, viewGroup, false);
        this.f15245c = inflate;
        this.f15246d = (FrameLayout) inflate.findViewById(R.id.fence_card_container);
    }

    public View getView() {
        return this.f15245c;
    }

    public void setPresenter(AbsPudoPresenter absPudoPresenter) {
        this.f15244b = absPudoPresenter;
    }

    public void setFenceCardView(View view) {
        if (this.f15246d != null && view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f15246d.removeAllViews();
            this.f15246d.addView(view);
            DIDIFontUtils.Companion.updateViewGroupTypeface(view);
        }
    }
}
