package com.didi.component.estimate.newui.view.one;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.estimate.newui.view.viewholder.ItemClickListener;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class NewEstimateChooseOneCarView extends FrameLayout {

    /* renamed from: a */
    private Context f13141a;

    /* renamed from: b */
    private View f13142b;

    /* renamed from: c */
    private RecyclerView f13143c;

    /* renamed from: d */
    private OneVerticalAdapter f13144d;

    /* renamed from: e */
    private List<EstimateItemModel> f13145e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SelectItemListener f13146f;

    /* renamed from: g */
    private ItemClickListener f13147g;

    /* renamed from: h */
    private int f13148h;

    /* renamed from: i */
    private View f13149i;

    public interface SelectItemListener {
        void selectItem(EstimateItemModel estimateItemModel, boolean z);
    }

    public NewEstimateChooseOneCarView(Context context) {
        super(context);
        this.f13141a = context;
        initView();
    }

    public NewEstimateChooseOneCarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13141a = context;
        initView();
    }

    public NewEstimateChooseOneCarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13141a = context;
        initView();
    }

    public void initView() {
        View inflate = LayoutInflater.from(this.f13141a).inflate(R.layout.estimate_one_car_view_layout, this, true);
        this.f13142b = inflate;
        this.f13143c = (RecyclerView) inflate.findViewById(R.id.one_car_estimate_list);
        C54831 r0 = new ItemClickListener() {
            public void itemClick(EstimateItemModel estimateItemModel, int i, boolean z) {
                if (NewEstimateChooseOneCarView.this.f13146f != null) {
                    NewEstimateChooseOneCarView.this.f13146f.selectItem(estimateItemModel, z);
                }
            }
        };
        this.f13147g = r0;
        OneVerticalAdapter oneVerticalAdapter = new OneVerticalAdapter(this.f13141a, r0);
        this.f13144d = oneVerticalAdapter;
        this.f13143c.setAdapter(oneVerticalAdapter);
        this.f13143c.setLayoutManager(new LinearLayoutManager(this.f13141a, 1, false));
        this.f13149i = this.f13142b.findViewById(R.id.one_car_loading);
    }

    public void setData(EstimateItemModel estimateItemModel, AbsEstimatePresenter absEstimatePresenter) {
        this.f13145e.clear();
        this.f13148h = estimateItemModel.viewType;
        estimateItemModel.viewType = 3;
        this.f13145e.add(estimateItemModel);
        this.f13144d.setPresenter(absEstimatePresenter);
        this.f13144d.setData(this.f13145e);
        this.f13144d.notifyDataSetChanged();
    }

    public void leave() {
        List<EstimateItemModel> list = this.f13145e;
        if (list != null && list.size() > 0) {
            this.f13145e.get(0).viewType = this.f13148h;
        }
    }

    public void updateItems() {
        this.f13144d.notifyDataSetChanged();
    }

    public void setSelectItemListener(SelectItemListener selectItemListener) {
        this.f13146f = selectItemListener;
    }

    public void showLoading() {
        View view = this.f13149i;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void hideLoading() {
        View view = this.f13149i;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
