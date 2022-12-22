package com.didiglobal.comp.carmodellist.optionarea.rideoption;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didiglobal.comp.carmodellist.BaseVH;
import com.didiglobal.comp.carmodellist.optionarea.rideoption.IAnycarRideOptionView;
import com.taxis99.R;
import java.util.List;

public class RideOptionVH extends BaseVH<AnyCarEstimateItemModel> implements IAnycarRideOptionView {

    /* renamed from: a */
    private Context f49838a;

    /* renamed from: b */
    private TextView f49839b;

    /* renamed from: c */
    private ImageView f49840c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View.OnClickListener f49841d;

    /* renamed from: e */
    private View f49842e;

    /* renamed from: f */
    private RideOptionSelectView f49843f;

    /* renamed from: g */
    private LEGOBaseDrawerModel f49844g;

    /* renamed from: h */
    private LEGODrawer f49845h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IAnycarRideOptionView.OnConfirmListener f49846i;

    /* renamed from: j */
    private AnycarRideOptionPresenter f49847j;

    public RideOptionVH(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.car_model_ride_option_layout, viewGroup, false));
        this.f49838a = viewGroup.getContext();
        m35935a();
    }

    /* renamed from: a */
    private void m35935a() {
        this.f49839b = (TextView) this.itemView.findViewById(R.id.message);
        this.f49840c = (ImageView) this.itemView.findViewById(R.id.iv_ride_option);
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (RideOptionVH.this.f49841d != null) {
                    RideOptionVH.this.f49841d.onClick(view);
                }
            }
        });
        View inflate = LayoutInflater.from(this.f49838a).inflate(R.layout.car_model_ride_option_dialog_layout, (ViewGroup) null);
        this.f49842e = inflate;
        this.f49843f = (RideOptionSelectView) inflate.findViewById(R.id.popup_select_recycler_view);
        this.f49844g = new LEGODrawerModel1("", new LEGOBtnTextAndCallback(ResourcesHelper.getString(this.f49838a, R.string.car_me_known), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (RideOptionVH.this.f49846i != null) {
                    RideOptionVH.this.f49846i.onConfirm(view);
                }
            }
        })).setIsShowCloseImg(true).setExtendedView(this.f49842e).setClickOutsideCanCancel(false);
        this.f49847j = new AnycarRideOptionPresenter(this);
    }

    public void setSelectListData(List<PopupSelectModel> list) {
        if (list != null && list.size() != 0) {
            this.f49843f.setItems(list);
        }
    }

    public void showSelectMore(int i) {
        if (this.f49844g != null && this.f49838a != null) {
            if (this.f49842e.getParent() != null) {
                ((ViewGroup) this.f49842e.getParent()).removeView(this.f49842e);
            }
            this.f49845h = LEGOUICreator.showDrawerTemplate(this.f49838a, this.f49844g);
            if (i >= 0) {
                this.f49843f.setSelectedPosition(i);
            }
        }
    }

    public void closeSelectMore() {
        LEGODrawer lEGODrawer = this.f49845h;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f49845h.dismiss();
        }
    }

    public void setClickable(boolean z) {
        this.itemView.setClickable(z);
        if (z) {
            this.f49839b.setTextColor(this.f49838a.getResources().getColor(R.color.g_color_000));
        } else {
            this.f49839b.setTextColor(Color.parseColor("#D9D9D9"));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f49841d = onClickListener;
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f49843f.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
    }

    public void setOnConfirmListener(IAnycarRideOptionView.OnConfirmListener onConfirmListener) {
        this.f49846i = onConfirmListener;
    }

    public void setSelectedPosition(int i) {
        if (i >= 0) {
            this.f49843f.setSelectedPosition(i);
        }
    }

    public void setDialogTitle(String str) {
        this.f49843f.setTitle(str);
    }

    public void setNewContent(GlobalRichInfo globalRichInfo) {
        globalRichInfo.bindTextView(this.f49839b);
    }

    public void setOptionIcon(String str) {
        ((RequestBuilder) Glide.with(this.f49838a).load(str).placeholder((int) R.drawable.global_rideoption_service_icon_accessible_car)).into(this.f49840c);
    }

    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f49847j.bindData(anyCarEstimateItemModel);
    }
}
