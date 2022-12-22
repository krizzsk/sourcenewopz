package com.didi.component.splitfare.view.impl.onservice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.loading.XPanelLoadingWrapper;
import com.didi.component.common.view.PositionSensitiveView;
import com.didi.component.splitfare.presenter.impl.SplitFareOnServicePresenter;
import com.didi.component.splitfare.view.ISplitFareOnServiceView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SplitFareOnServiceView extends XPanelLoadingWrapper implements PositionSensitiveView, ISplitFareOnServiceView {

    /* renamed from: a */
    private View f16013a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SplitFareOnServicePresenter f16014b;

    /* renamed from: c */
    private SplitFareAdapter f16015c;

    /* renamed from: d */
    private RecyclerView f16016d;

    /* renamed from: e */
    private View f16017e;

    /* renamed from: f */
    private View f16018f;

    /* renamed from: g */
    private int f16019g = -1;

    /* renamed from: h */
    private ViewGroup f16020h;

    public SplitFareOnServiceView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comp_sf_onservice, viewGroup, false);
        this.f16013a = inflate;
        this.f16017e = inflate.findViewById(R.id.tv_tip);
        this.f16018f = this.f16013a.findViewById(R.id.tv_stop);
        this.f16016d = (RecyclerView) this.f16013a.findViewById(R.id.sf_list);
        this.f16020h = (ViewGroup) this.f16013a.findViewById(R.id.box_triangle);
        this.f16015c = new SplitFareAdapter(CarOrderHelper.getOrder() != null && CarOrderHelper.getOrder().isSplitFareOwner());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewGroup.getContext());
        linearLayoutManager.setOrientation(0);
        this.f16016d.setLayoutManager(linearLayoutManager);
        this.f16016d.setAdapter(this.f16015c);
        this.f16018f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SplitFareOnServiceView.this.f16014b.onStopSplitFare();
            }
        });
    }

    public View getView() {
        return this.f16013a;
    }

    public void setPresenter(SplitFareOnServicePresenter splitFareOnServicePresenter) {
        this.f16014b = splitFareOnServicePresenter;
        this.f16015c.setPresenter(splitFareOnServicePresenter);
    }

    public void show(CarOrder carOrder) {
        if (carOrder == null || !carOrder.isSplitFareOrder()) {
            hide();
            return;
        }
        ArrayList arrayList = new ArrayList(carOrder.splitFareInfo.split_user_list);
        int i = 0;
        this.f16013a.setVisibility(0);
        if (carOrder.isSplitFareOwner()) {
            this.f16017e.setVisibility(8);
            this.f16018f.setVisibility(8);
        } else {
            this.f16017e.setVisibility(8);
            this.f16018f.setVisibility(8);
        }
        SplitFareAdapter splitFareAdapter = this.f16015c;
        int width = this.f16016d.getWidth();
        if (carOrder.carInfo != null) {
            i = carOrder.carInfo.passengerCount;
        }
        splitFareAdapter.update(arrayList, width, i);
    }

    /* renamed from: a */
    private void m11771a(List<DTSDKSplitFareInfo.SplitUser> list) {
        DTSDKSplitFareInfo.SplitUser splitUser = new DTSDKSplitFareInfo.SplitUser();
        splitUser._extType = SplitFareAdapter.EXT_TYPE_ACTION;
        splitUser.nick = ResourcesHelper.getString(this.f16013a.getContext(), R.string.g_splitfare_list_add_btn);
        splitUser.name = splitUser.nick;
        list.add(splitUser);
    }

    public void hide() {
        this.f16013a.setVisibility(8);
    }

    public void loading(boolean z) {
        if (z) {
            showMaskLayerLoading();
        } else {
            hideLoading();
        }
    }

    public void setPositionOfParentComponent(int i) {
        if (CarOrderHelper.getOrder() == null || !CarOrderHelper.getOrder().isSplitFareOwner()) {
            this.f16020h.setVisibility(8);
        } else if (this.f16019g != i) {
            this.f16019g = i;
            int childCount = this.f16020h.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                this.f16020h.getChildAt(i2).setVisibility(i2 == 0 ? 0 : 4);
                i2++;
            }
        }
    }

    public int getPositionOfParentComponent() {
        return this.f16019g;
    }
}
