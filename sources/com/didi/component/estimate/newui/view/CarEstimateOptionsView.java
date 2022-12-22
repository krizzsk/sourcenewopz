package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.estimate.newui.view.EstimateOptionAdapter;
import com.didi.component.estimate.newui.view.viewholder.ItemClickListener;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.Collection;

public class CarEstimateOptionsView extends FrameLayout {

    /* renamed from: a */
    private View f13039a;

    /* renamed from: b */
    private Context f13040b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView f13041c;

    /* renamed from: d */
    private EstimateOptionAdapter f13042d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ItemClickListener f13043e;

    public CarEstimateOptionsView(Context context) {
        super(context);
        this.f13040b = context;
        initView();
    }

    public CarEstimateOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13040b = context;
        initView();
    }

    public CarEstimateOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13040b = context;
        initView();
    }

    public void initView() {
        View inflate = LayoutInflater.from(this.f13040b).inflate(R.layout.car_estimate_options_layout, this, true);
        this.f13039a = inflate;
        this.f13041c = (RecyclerView) inflate.findViewById(R.id.new_estimate_data_list);
        this.f13042d = new EstimateOptionAdapter(this.f13040b, new EstimateOptionAdapter.EstimateOptionsCallback() {
            public void twoPriceItemClick(EstimateItemModel estimateItemModel, int i, boolean z) {
                if (CarEstimateOptionsView.this.f13043e == null) {
                    return;
                }
                if (z) {
                    CarEstimateOptionsView.this.f13043e.itemClick(estimateItemModel, i, true);
                } else {
                    CarEstimateOptionsView.this.f13043e.itemClick(estimateItemModel, i, false);
                }
            }

            public void optionsListGone() {
                CarEstimateOptionsView.this.f13041c.setVisibility(8);
            }
        });
    }

    public void setPresenter(AbsEstimatePresenter absEstimatePresenter) {
        this.f13042d.setPresenter(absEstimatePresenter);
    }

    public boolean setData(EstimateItemModel estimateItemModel) {
        if (CollectionUtils.isEmpty((Collection) estimateItemModel.carOperation)) {
            this.f13041c.setVisibility(8);
            return false;
        }
        this.f13041c.setVisibility(0);
        this.f13041c.setAdapter((RecyclerView.Adapter) null);
        this.f13041c.setLayoutManager((RecyclerView.LayoutManager) null);
        this.f13042d.onDestroy();
        this.f13041c.setAdapter(this.f13042d);
        this.f13041c.setLayoutManager(new GridLayoutManager(this.f13040b, estimateItemModel.carOperation.size(), 1, false));
        this.f13042d.setData(estimateItemModel.carOperation, estimateItemModel);
        this.f13042d.notifyDataSetChanged();
        return true;
    }

    public void setEstimateItemClick(ItemClickListener itemClickListener) {
        this.f13043e = itemClickListener;
    }
}
