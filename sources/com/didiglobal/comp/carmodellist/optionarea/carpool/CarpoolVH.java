package com.didiglobal.comp.carmodellist.optionarea.carpool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.common.base.ComponentType;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationDataModel;
import com.didiglobal.comp.carmodellist.BaseVH;
import com.didiglobal.comp.carmodellist.button.AnyCarRadioButton;
import com.didiglobal.comp.carmodellist.button.AnyCarRadioButtonModel;
import com.didiglobal.comp.carmodellist.button.AnyCarRadioButtonView;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class CarpoolVH extends BaseVH<AnyCarEstimateItemModel> {

    /* renamed from: a */
    private TextView f49797a;

    /* renamed from: b */
    private AnyCarRadioButton f49798b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AnyCarEstimateItemModel f49799c;

    /* renamed from: d */
    private CarOperationDataModel f49800d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AnyCarSelectListener f49801e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f49802f;

    public CarpoolVH(ViewGroup viewGroup, AnyCarSelectListener anyCarSelectListener) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anycar_carpool_layout, viewGroup, false));
        this.f49801e = anyCarSelectListener;
        m35916a();
    }

    /* renamed from: a */
    private void m35916a() {
        this.f49797a = (TextView) this.itemView.findViewById(R.id.anycar_carpool_tv);
        AnyCarRadioButton anyCarRadioButton = (AnyCarRadioButton) this.itemView.findViewById(R.id.anycar_carpool_select);
        this.f49798b = anyCarRadioButton;
        anyCarRadioButton.setOnCheckedChangeListener(new AnyCarRadioButton.OnCheckedChangeListener() {
            public void onCheckedChanged(AnyCarRadioButton anyCarRadioButton, AnyCarRadioButtonView anyCarRadioButtonView, int i) {
                if (CarpoolVH.this.f49802f) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(ComponentType.SEAT_COUNT, Integer.valueOf(i + 1));
                    AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneChangeSeat, hashMap);
                    CarpoolVH.this.f49799c.anycarCarpool.mSelectedIndex = i;
                    CarpoolVH.this.f49801e.carpoolSeatSelected(CarpoolVH.this.f49799c);
                    return;
                }
                boolean unused = CarpoolVH.this.f49802f = true;
            }
        });
    }

    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.anycarCarpool != null) {
            this.f49799c = anyCarEstimateItemModel;
            CarOperationDataModel carOperationDataModel = anyCarEstimateItemModel.anycarCarpool.operationData;
            this.f49800d = carOperationDataModel;
            if (carOperationDataModel != null && !CollectionUtil.isEmpty((Collection<?>) carOperationDataModel.anycarCarpoolSeatList)) {
                for (int i = 0; i < this.f49800d.anycarCarpoolSeatList.size(); i++) {
                    CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat = this.f49800d.anycarCarpoolSeatList.get(i);
                    if (i == anyCarEstimateItemModel.anycarCarpool.mSelectedIndex) {
                        anycarCarpoolSeat.selected = 1;
                    } else {
                        anycarCarpoolSeat.selected = 0;
                    }
                }
                this.f49802f = false;
                if (this.f49800d.operationTextV2 != null) {
                    this.f49800d.operationTextV2.bindTextView(this.f49797a);
                }
                List<CarOperationDataModel.AnycarCarpoolSeat> list = this.f49800d.anycarCarpoolSeatList;
                if (list != null && list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat2 = list.get(i2);
                        if (anycarCarpoolSeat2 != null) {
                            AnyCarRadioButtonModel.ViewModel viewModel = new AnyCarRadioButtonModel.ViewModel();
                            viewModel.f49785id = i2;
                            viewModel.isChecked = anycarCarpoolSeat2.selected != 0;
                            AnyCarRadioButtonModel.TextModel textModel = new AnyCarRadioButtonModel.TextModel();
                            textModel.text = String.valueOf(anycarCarpoolSeat2.count);
                            textModel.textColor = "#000000";
                            viewModel.titleChecked = textModel;
                            AnyCarRadioButtonModel.TextModel textModel2 = new AnyCarRadioButtonModel.TextModel();
                            textModel2.text = String.valueOf(anycarCarpoolSeat2.count);
                            textModel2.textColor = "#9E9E9E";
                            viewModel.titleUnChecked = textModel2;
                            viewModel.iconChecked = this.itemView.getResources().getDrawable(R.drawable.any_car_icon_people_1);
                            viewModel.iconUnChecked = this.itemView.getResources().getDrawable(R.drawable.any_car_icon_people_2);
                            viewModel.bgChecked = this.itemView.getResources().getDrawable(R.drawable.lego_radio_btn_selected_bg);
                            viewModel.bgUnChecked = this.itemView.getResources().getDrawable(17170445);
                            arrayList.add(viewModel);
                        }
                    }
                    this.f49798b.setRadioViewList(buildViewList(this.itemView.getContext(), arrayList));
                }
            }
        }
    }

    public List<AnyCarRadioButtonView> buildViewList(Context context, List<AnyCarRadioButtonModel.ViewModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                CarpoolRadioBtnViewImpl carpoolRadioBtnViewImpl = new CarpoolRadioBtnViewImpl(context);
                carpoolRadioBtnViewImpl.setData(list.get(i));
                arrayList.add(carpoolRadioBtnViewImpl);
            }
        }
        return arrayList;
    }
}
