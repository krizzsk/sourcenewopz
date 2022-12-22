package com.didi.component.groupform.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.core.IComponent;
import com.didi.component.groupform.presenter.AbsGroupFormPresenter;
import com.didi.drouter.api.DRouter;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.FormOperationModels;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FormViewOptionAdapter extends RecyclerView.Adapter {
    public static int RECYCLER_VIEW_SINGLE_COL_SPANS = 2;
    public static final int RECYCLER_VIEW_SPAN_COUNT = 6;
    public static final int VIEW_TYPE_COMPANY = 6;
    public static final int VIEW_TYPE_DISPATCH_FEE = 5;
    public static final int VIEW_TYPE_OPTIONS = 3;
    public static final int VIEW_TYPE_PAYWAY = 1;
    public static final int VIEW_TYPE_SEAT_COUNT = 4;
    public static final int VIEW_TYPE_SUBSTITUTE_CALL = 7;
    public static final int VIEW_TYPE_TIME_PICKER = 2;

    /* renamed from: a */
    private AbsGroupFormPresenter f14075a;

    /* renamed from: b */
    private List<Integer> f14076b = new ArrayList();

    /* renamed from: c */
    private HashMap<Integer, IComponent> f14077c = new HashMap<>();

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            IComponent inflateComponent = this.f14075a.inflateComponent(ComponentType.TIME_PICKER, viewGroup);
            this.f14077c.put(Integer.valueOf(i), inflateComponent);
            if (inflateComponent != null) {
                return new TimePickerViewHolder(inflateComponent.getView().getView());
            }
            return null;
        } else if (i != 7) {
            return null;
        } else {
            IComponent inflateComponent2 = this.f14075a.inflateComponent(ComponentType.FORM_COMMON_ITEM, viewGroup);
            this.f14077c.put(Integer.valueOf(i), inflateComponent2);
            View view = inflateComponent2.getView().getView();
            view.setOnClickListener(new OnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    if (newEstimateItem != null && newEstimateItem.mFormOperationModel != null && !CollectionUtils.isEmpty((Collection) newEstimateItem.mFormOperationModel.items)) {
                        for (FormOperationModels next : newEstimateItem.mFormOperationModel.items) {
                            if (next.mFormOperationType == 1) {
                                DRouter.build(next.mScheme).start();
                            }
                        }
                    }
                }
            });
            return new SubstituteCallViewHolder(view);
        }
    }

    public int getItemCount() {
        return this.f14076b.size();
    }

    public int getItemViewType(int i) {
        return this.f14076b.get(i).intValue();
    }

    public void setPresenter(AbsGroupFormPresenter absGroupFormPresenter) {
        this.f14075a = absGroupFormPresenter;
    }

    public void setModelList(List<Integer> list) {
        this.f14076b = list;
    }

    public int getModelListSize() {
        List<Integer> list = this.f14076b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.f14075a != null) {
            for (IComponent removeComponent : this.f14077c.values()) {
                this.f14075a.removeComponent(removeComponent);
            }
        }
    }
}
