package com.didi.component.rideoption.newui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.rideoption.AbsRideOptionPresenter;
import com.didi.component.rideoption.IRideOptionView;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;
import java.util.List;

public class RideOptionNewUIView implements IRideOptionView {

    /* renamed from: a */
    private Context f15305a;

    /* renamed from: b */
    private BusinessContext f15306b;

    /* renamed from: c */
    private View f15307c;

    /* renamed from: d */
    private TextView f15308d;

    /* renamed from: e */
    private ImageView f15309e = ((ImageView) this.f15307c.findViewById(R.id.iv_ride_option));
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f15310f;

    /* renamed from: g */
    private View f15311g;

    /* renamed from: h */
    private RideOptionSelectView f15312h;

    /* renamed from: i */
    private LEGOBaseDrawerModel f15313i;

    /* renamed from: j */
    private LEGODrawer f15314j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IRideOptionView.OnConfirmListener f15315k;

    public void setPresenter(AbsRideOptionPresenter absRideOptionPresenter) {
    }

    public RideOptionNewUIView(ComponentParams componentParams, ViewGroup viewGroup) {
        BusinessContext businessContext = componentParams.bizCtx;
        this.f15306b = businessContext;
        Context context = businessContext.getContext();
        this.f15305a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_ride_option_new_ui_layout, viewGroup, false);
        this.f15307c = inflate;
        this.f15308d = (TextView) inflate.findViewById(R.id.message);
        this.f15307c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (RideOptionNewUIView.this.f15310f != null) {
                    RideOptionNewUIView.this.f15310f.onClick(view);
                }
            }
        });
        View inflate2 = LayoutInflater.from(this.f15305a).inflate(R.layout.global_ride_option_new_ui_dialog_layout, (ViewGroup) null);
        this.f15311g = inflate2;
        this.f15312h = (RideOptionSelectView) inflate2.findViewById(R.id.popup_select_recycler_view);
        this.f15313i = new LEGODrawerModel1("", new LEGOBtnTextAndCallback(ResourcesHelper.getString(this.f15305a, R.string.car_me_known), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (RideOptionNewUIView.this.f15315k != null) {
                    RideOptionNewUIView.this.f15315k.onConfirm(view);
                }
            }
        })).setIsShowCloseImg(true).setExtendedView(this.f15311g).setClickOutsideCanCancel(false);
    }

    public void setSelectListData(List<PopupSelectModel> list) {
        if (list != null && list.size() != 0) {
            this.f15312h.setItems(list);
        }
    }

    public void setContentLable(String str) {
        this.f15308d.setText(str);
        this.f15312h.setTitle(str);
    }

    public void showSelectMore(int i) {
        if (this.f15313i != null && this.f15305a != null) {
            if (this.f15311g.getParent() != null) {
                ((ViewGroup) this.f15311g.getParent()).removeView(this.f15311g);
            }
            this.f15314j = LEGOUICreator.showDrawerTemplate(this.f15305a, this.f15313i);
            if (i >= 0) {
                this.f15312h.setSelectedPosition(i);
            }
        }
    }

    public void closeSelectMore() {
        LEGODrawer lEGODrawer = this.f15314j;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f15314j.dismiss();
        }
    }

    public void setClickable(boolean z) {
        getView().setClickable(z);
        if (z) {
            this.f15308d.setTextColor(this.f15305a.getResources().getColor(R.color.g_color_000));
        } else {
            this.f15308d.setTextColor(this.f15305a.getResources().getColor(R.color.g_color_D9D9D9));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f15310f = onClickListener;
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f15312h.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
    }

    public View getView() {
        return this.f15307c;
    }

    public void setOnConfirmListener(IRideOptionView.OnConfirmListener onConfirmListener) {
        this.f15315k = onConfirmListener;
    }

    public void setSelectedPosition(int i) {
        if (i >= 0) {
            this.f15312h.setSelectedPosition(i);
        }
    }

    public void setDialogTitle(String str) {
        this.f15312h.setTitle(str);
    }

    public void setNewContent(GlobalRichInfo globalRichInfo) {
        globalRichInfo.bindTextView(this.f15308d);
    }

    public void setOptionIcon(String str) {
        ((RequestBuilder) Glide.with(this.f15305a).load(str).placeholder((int) R.drawable.global_rideoption_service_icon_accessible_car)).into(this.f15309e);
    }
}
