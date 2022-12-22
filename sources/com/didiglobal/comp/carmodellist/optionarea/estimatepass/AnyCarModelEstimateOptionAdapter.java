package com.didiglobal.comp.carmodellist.optionarea.estimatepass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationModel;
import com.didiglobal.comp.carmodellist.BaseVH;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.didiglobal.comp.carmodellist.optionarea.carpool.CarpoolVH;
import com.didiglobal.comp.carmodellist.optionarea.xml.XMLVH;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AnyCarModelEstimateOptionAdapter extends RecyclerView.Adapter<BaseVH<AnyCarEstimateItemModel>> {
    public static final int VIEW_TYPE_CARPOOL = 0;
    public static final int VIEW_TYPE_COMPANY = 3;
    public static final int VIEW_TYPE_DISPATCH_FEE = 1;
    public static final int VIEW_TYPE_MEMBER_POINT = 4;
    public static final int VIEW_TYPE_OPTIONS = 2;
    public static final int VIEW_TYPE_PASS = 5;
    public static final int VIEW_TYPE_XML = 6;

    /* renamed from: a */
    private List<CarOperationModel> f49813a;

    /* renamed from: b */
    private final Context f49814b;

    /* renamed from: c */
    private AnyCarEstimateItemModel f49815c;

    /* renamed from: d */
    private AnyCarSelectListener f49816d;

    public AnyCarModelEstimateOptionAdapter(Context context) {
        this.f49814b = context;
    }

    public BaseVH<AnyCarEstimateItemModel> onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new CarpoolVH(viewGroup, this.f49816d);
        }
        if (i == 5) {
            return new AnyCarEstimatePassVH(viewGroup);
        }
        if (i != 6) {
            return new BaseVH<AnyCarEstimateItemModel>(new FrameLayout(this.f49814b)) {
                public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                }
            };
        }
        return new XMLVH(viewGroup);
    }

    public void onBindViewHolder(BaseVH<AnyCarEstimateItemModel> baseVH, int i) {
        CarOperationModel carOperationModel;
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            baseVH.bindData(this.f49815c);
        } else if (itemViewType == 5) {
            baseVH.bindData(this.f49815c);
        } else if (itemViewType == 6 && (carOperationModel = this.f49813a.get(i)) != null && carOperationModel.xmlData != null) {
            try {
                final GGKData gGKData = new GGKData();
                final View view = baseVH.itemView;
                gGKData.parse(new JSONObject(carOperationModel.xmlData.toString()));
                gGKData.setCDNCallback(new GGKData.CDNCallback() {
                    public void onCDNCached() {
                        AnyCarModelEstimateOptionAdapter.this.m35924a(gGKData, view);
                    }
                });
                m35924a(gGKData, view);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35924a(GGKData gGKData, View view) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.f49814b, gGKData);
        if ((view instanceof ViewGroup) && createTemplateView != null && createTemplateView.getView() != null) {
            ((ViewGroup) view).addView(createTemplateView.getView());
        }
    }

    public int getItemViewType(int i) {
        try {
            return Integer.parseInt(this.f49813a.get(i).operationType);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getItemCount() {
        List<CarOperationModel> list = this.f49813a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(AnyCarEstimateItemModel anyCarEstimateItemModel, AnyCarSelectListener anyCarSelectListener) {
        this.f49816d = anyCarSelectListener;
        this.f49815c = anyCarEstimateItemModel;
        if (anyCarEstimateItemModel != null) {
            this.f49813a = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation;
        }
    }
}
