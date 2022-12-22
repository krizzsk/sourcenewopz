package com.didiglobal.comp.carmodellist.optionarea.estimatepass;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.taxis99.R;
import java.util.Collection;

public class AnyCarModelEstimateOptionsView extends FrameLayout {

    /* renamed from: a */
    private Context f49817a;

    /* renamed from: b */
    private RecyclerView f49818b;

    /* renamed from: c */
    private AnyCarModelEstimateOptionAdapter f49819c;

    /* renamed from: d */
    private ItemClickListener f49820d;

    public interface ItemClickListener {
        void itemClick(AnyCarEstimateItemModel anyCarEstimateItemModel, int i, boolean z);
    }

    public AnyCarModelEstimateOptionsView(Context context) {
        super(context);
        this.f49817a = context;
        initView();
    }

    public AnyCarModelEstimateOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49817a = context;
        initView();
    }

    public AnyCarModelEstimateOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49817a = context;
        initView();
    }

    public void initView() {
        LayoutInflater.from(this.f49817a).inflate(R.layout.car_model_estimate_options_layout, this);
        this.f49818b = (RecyclerView) findViewById(R.id.new_estimate_data_list);
        this.f49819c = new AnyCarModelEstimateOptionAdapter(this.f49817a);
    }

    public void setData(AnyCarEstimateItemModel anyCarEstimateItemModel, AnyCarSelectListener anyCarSelectListener) {
        if (!CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation)) {
            this.f49818b.setAdapter(this.f49819c);
            this.f49818b.setLayoutManager(new GridLayoutManager(this.f49817a, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation.size()));
            this.f49819c.setData(anyCarEstimateItemModel, anyCarSelectListener);
            this.f49819c.notifyDataSetChanged();
        }
    }

    public void setEstimateItemClick(ItemClickListener itemClickListener) {
        this.f49820d = itemClickListener;
    }
}
