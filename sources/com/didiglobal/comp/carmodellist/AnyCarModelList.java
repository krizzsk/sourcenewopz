package com.didiglobal.comp.carmodellist;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.data.form.FormStore;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.AnyCarCarpoolOperation;
import com.didi.travel.psnger.model.response.estimate.CarOperationModel;
import com.didi.travel.psnger.model.response.estimate.CarSeatChoiceModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.didiglobal.travel.util.CollectionUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AnyCarModelList {
    public static final int SELECT_DEFAULT = 1;

    /* renamed from: a */
    private Context f49752a;
    public List<String> allCarString = new ArrayList();

    /* renamed from: b */
    private RecyclerView f49753b;

    /* renamed from: c */
    private AnyCarRVAdapter f49754c;

    /* renamed from: d */
    private List<AnyCarEstimateItemModel> f49755d = new ArrayList();

    /* renamed from: e */
    private AnyCarSelectListener f49756e;

    /* renamed from: f */
    private final Logger f49757f = LoggerFactory.getLogger("CarModelList");

    /* renamed from: g */
    private boolean f49758g;

    /* renamed from: h */
    private boolean f49759h = true;

    public AnyCarModelList(Context context, ViewGroup viewGroup) {
        m35889a(context, viewGroup);
    }

    public AnyCarModelList(Context context, ViewGroup viewGroup, AnyCarSelectListener anyCarSelectListener) {
        m35889a(context, viewGroup);
        this.f49756e = anyCarSelectListener;
        this.f49754c.setSelectListener(anyCarSelectListener);
    }

    /* renamed from: a */
    private void m35889a(Context context, ViewGroup viewGroup) {
        this.f49752a = context;
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.anycar_model_list_container_layout, viewGroup, false);
        this.f49753b = recyclerView;
        recyclerView.setClipChildren(false);
        this.f49754c = new AnyCarRVAdapter(this.f49752a);
        this.f49753b.setLayoutManager(new LinearLayoutManager(this.f49752a));
        this.f49753b.setAdapter(this.f49754c);
    }

    public RecyclerView getRootView() {
        return this.f49753b;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f49753b.setNestedScrollingEnabled(z);
    }

    public void setInitParam(List<AnyCarEstimateItemModel> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f49755d.clear();
            this.f49755d.addAll(list);
            this.f49758g = true;
        }
    }

    public void setData(List<AnyCarGroup> list) {
        AnyCarSelectListener anyCarSelectListener;
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (AnyCarGroup next : list) {
                if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.group)) {
                    for (AnyCarEstimateNetModel next2 : next.group) {
                        if (next2 != null) {
                            AnyCarEstimateItemModel anyCarEstimateItemModel = new AnyCarEstimateItemModel();
                            anyCarEstimateItemModel.mAnyCarEstimateNetItem = next2;
                            if (next2.carConfig != null && 1 == next2.carConfig.selectDefault) {
                                anyCarEstimateItemModel.isSelected = true;
                            }
                            if (!this.f49759h || this.f49758g) {
                                AnyCarEstimateItemModel findEstimateModel = findEstimateModel(next2);
                                if (findEstimateModel != null) {
                                    setEstimateOperation(anyCarEstimateItemModel, findEstimateModel);
                                    if (findEstimateModel.getSelectedValueParams() != null && findEstimateModel.getSelectPos() >= 0) {
                                        m35890a(anyCarEstimateItemModel, findEstimateModel.getSelectPos());
                                    }
                                } else {
                                    setEstimateOperation(anyCarEstimateItemModel, (AnyCarEstimateItemModel) null);
                                }
                            } else {
                                setEstimateOperation(anyCarEstimateItemModel, (AnyCarEstimateItemModel) null);
                            }
                            setEstimateItem(anyCarEstimateItemModel);
                            z = m35891a(z, anyCarEstimateItemModel);
                            arrayList.add(anyCarEstimateItemModel);
                            if (!(next2.carConfig == null || !next2.carConfig.isDefaultSelect() || (anyCarSelectListener = this.f49756e) == null)) {
                                anyCarSelectListener.defaultSelectedItem(anyCarEstimateItemModel);
                            }
                        }
                    }
                }
            }
            this.f49755d.clear();
            this.f49755d = arrayList;
            AnyCarSelectListener anyCarSelectListener2 = this.f49756e;
            if (anyCarSelectListener2 != null) {
                anyCarSelectListener2.setAllItems(arrayList);
            }
            this.f49754c.setData(this.f49755d);
            this.f49759h = false;
            this.f49758g = false;
            FormStore.getInstance().setInfoList(this.allCarString.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setEstimateItem(com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            r8.feeDisplay = r0
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            if (r1 == 0) goto L_0x01e6
            com.didi.travel.psnger.model.response.estimate.SelectedValueParams r1 = r8.getSelectedValueParams()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x008c
            java.lang.String r4 = r1.seatPoolEstimateId
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x001e
            java.lang.String r4 = r1.seatPoolEstimateId
            r8.estimateId = r4
        L_0x001e:
            int r4 = r1.seatPoolCountType
            r8.countPriceType = r4
            float r4 = r1.seatPoolEstimatePrice
            r8.feeNumber = r4
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r4 = r4.carInfo
            if (r4 == 0) goto L_0x0120
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r4 = r4.carInfo
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel> r4 = r4.carPriceInfo
            boolean r4 = com.didiglobal.travel.util.CollectionUtils.isNotEmpty((java.util.Collection<?>) r4)
            if (r4 == 0) goto L_0x0120
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r4 = r4.carInfo
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel> r4 = r4.carPriceInfo
            java.lang.Object r4 = r4.get(r3)
            com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel r4 = (com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel) r4
            java.lang.String r5 = r4.priceSymbol
            int r4 = r4.priceSymbolPosition
            float r1 = r1.seatPoolEstimatePrice
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x0082
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0082
            if (r4 != r2) goto L_0x006f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r5)
            java.lang.String r1 = r2.toString()
            r8.feeDisplay = r1
            goto L_0x0120
        L_0x006f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r8.feeDisplay = r1
            goto L_0x0120
        L_0x0082:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0120
            r8.feeDisplay = r1
            goto L_0x0120
        L_0x008c:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            java.lang.String r1 = r1.estimateId
            r8.estimateId = r1
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            int r1 = r1.countPriceType
            r8.countPriceType = r1
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r1 = r1.carInfo
            if (r1 == 0) goto L_0x00fe
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r1 = r1.carInfo
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel> r1 = r1.carPriceInfo
            boolean r1 = com.didiglobal.travel.util.CollectionUtils.isNotEmpty((java.util.Collection<?>) r1)
            if (r1 == 0) goto L_0x00fe
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r1 = r1.carInfo
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel> r1 = r1.carPriceInfo
            java.lang.Object r1 = r1.get(r3)
            com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel r1 = (com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel) r1
            java.lang.String r4 = r1.priceSymbol
            int r5 = r1.priceSymbolPosition
            com.didi.travel.psnger.model.response.GlobalRichInfo r1 = r1.carPrice
            java.lang.String r1 = r1.getContent()
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x00f6
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x00f6
            if (r5 != r2) goto L_0x00e4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            r8.feeDisplay = r1
            goto L_0x00fe
        L_0x00e4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r8.feeDisplay = r1
            goto L_0x00fe
        L_0x00f6:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x00fe
            r8.feeDisplay = r1
        L_0x00fe:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r1 = r1.extraData
            if (r1 == 0) goto L_0x0120
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r1 = r1.extraData
            com.didi.travel.psnger.model.response.estimate.OrderParams r1 = r1.getOrderParams()
            if (r1 == 0) goto L_0x0120
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r1 = r1.extraData
            com.didi.travel.psnger.model.response.estimate.OrderParams r1 = r1.getOrderParams()
            float r1 = r1.feeAmount
            r8.feeNumber = r1
        L_0x0120:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r1 = r1.extraData
            if (r1 == 0) goto L_0x01e6
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r1 = r1.extraData
            com.didi.travel.psnger.model.response.estimate.CarExtraLogModel r1 = r1.getExtraLog()
            if (r1 == 0) goto L_0x01e6
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r1 = r1.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r1 = r1.extraData
            com.didi.travel.psnger.model.response.estimate.CarExtraLogModel r1 = r1.getExtraLog()
            java.lang.String r2 = r1.eta
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x015c
            com.didi.component.business.data.form.FormStore r2 = com.didi.component.business.data.form.FormStore.getInstance()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r4 = r1.eta     // Catch:{ Exception -> 0x0154 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0154 }
            r2.setEta(r4)     // Catch:{ Exception -> 0x0154 }
            goto L_0x0163
        L_0x0154:
            com.didi.component.business.data.form.FormStore r2 = com.didi.component.business.data.form.FormStore.getInstance()
            r2.setEta(r3)
            goto L_0x0163
        L_0x015c:
            com.didi.component.business.data.form.FormStore r2 = com.didi.component.business.data.form.FormStore.getInstance()
            r2.setEta(r3)
        L_0x0163:
            java.lang.String r2 = r1.originFee
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 0
            if (r2 != 0) goto L_0x0173
            java.lang.String r1 = r1.originFee     // Catch:{ Exception -> 0x0173 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ Exception -> 0x0173 }
            goto L_0x0174
        L_0x0173:
            r1 = 0
        L_0x0174:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r4 = r4.carConfig
            int r4 = r4.carLevel
            r2.append(r4)
            com.didi.component.business.data.form.FormStore r4 = com.didi.component.business.data.form.FormStore.getInstance()
            int r4 = r4.getEta()
            java.lang.String r5 = ":"
            if (r4 != 0) goto L_0x0195
            r2.append(r5)
            r2.append(r0)
            goto L_0x01a3
        L_0x0195:
            r2.append(r5)
            com.didi.component.business.data.form.FormStore r4 = com.didi.component.business.data.form.FormStore.getInstance()
            int r4 = r4.getEta()
            r2.append(r4)
        L_0x01a3:
            float r4 = r8.feeNumber
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x01b0
            r2.append(r5)
            r2.append(r0)
            goto L_0x01b8
        L_0x01b0:
            r2.append(r5)
            float r4 = r8.feeNumber
            r2.append(r4)
        L_0x01b8:
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x01c3
            r2.append(r5)
            r2.append(r0)
            goto L_0x01c9
        L_0x01c3:
            r2.append(r5)
            r2.append(r1)
        L_0x01c9:
            r2.append(r5)
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r8.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            java.util.List<java.lang.String> r0 = r0.guideType
            r2.append(r0)
            r2.append(r5)
            boolean r8 = r8.isSelected
            r2.append(r8)
            java.util.List<java.lang.String> r8 = r7.allCarString
            java.lang.String r0 = r2.toString()
            r8.add(r0)
        L_0x01e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.comp.carmodellist.AnyCarModelList.setEstimateItem(com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel):void");
    }

    /* renamed from: a */
    private void m35890a(AnyCarEstimateItemModel anyCarEstimateItemModel, int i) {
        CarSeatChoiceModel carSeatChoiceModel;
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakSeat != null && CollectionUtils.isNotEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakSeat.seatBreakChoice) && (carSeatChoiceModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakSeat.seatBreakChoice.get(i)) != null && carSeatChoiceModel.getselectValue() != null) {
            anyCarEstimateItemModel.setSelectedValueParams(carSeatChoiceModel.getselectValue(), carSeatChoiceModel.selectValueObject);
            anyCarEstimateItemModel.setSelectPos(i);
            FormStore.getInstance().setCurrentComboType(carSeatChoiceModel.getselectValue().comboType);
            FormStore.getInstance().setCarpoolOrderScene(carSeatChoiceModel.getselectValue().carpoolOrderScene);
        }
    }

    /* renamed from: a */
    private boolean m35891a(boolean z, AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (z || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carGroupArea != 2) {
            return z;
        }
        anyCarEstimateItemModel.mIsFirstSingle = true;
        return true;
    }

    public AnyCarEstimateItemModel findEstimateModel(AnyCarEstimateNetModel anyCarEstimateNetModel) {
        Iterator<AnyCarEstimateItemModel> it = this.f49755d.iterator();
        while (it.hasNext()) {
            AnyCarEstimateItemModel next = it.next();
            if (next != null && next.mAnyCarEstimateNetItem.carConfig != null && anyCarEstimateNetModel != null && anyCarEstimateNetModel.carConfig != null && anyCarEstimateNetModel.carConfig.uniqueId != null && anyCarEstimateNetModel.carConfig.uniqueId.equals(next.mAnyCarEstimateNetItem.carConfig.uniqueId)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public void setEstimateOperation(AnyCarEstimateItemModel anyCarEstimateItemModel, AnyCarEstimateItemModel anyCarEstimateItemModel2) {
        if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation.size() > 0) {
            for (CarOperationModel next : anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation) {
                if ((next.xmlData == null || !"6".equals(next.operationType)) && (next.operationData == null || next.operationType == null || ((next.operationData.operationText == null || TextUtils.isEmpty(next.operationData.operationText.getContent())) && (next.operationData.operationTextV2 == null || TextUtils.isEmpty(next.operationData.operationTextV2.getContent()))))) {
                    anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation.remove(next);
                } else {
                    String str = next.operationType;
                    char c = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != 48) {
                        if (hashCode == 53 && str.equals("5")) {
                            c = 1;
                        }
                    } else if (str.equals("0")) {
                        c = 0;
                    }
                    if (c == 0) {
                        if (anyCarEstimateItemModel2 == null || anyCarEstimateItemModel2.anycarCarpool == null || next.carOperationCache != 1) {
                            anyCarEstimateItemModel.anycarCarpool = new AnyCarCarpoolOperation();
                        } else {
                            anyCarEstimateItemModel.anycarCarpool = anyCarEstimateItemModel2.anycarCarpool;
                        }
                        anyCarEstimateItemModel.anycarCarpool.operationData = next.operationData;
                    } else if (c == 1) {
                        if (anyCarEstimateItemModel2 == null || anyCarEstimateItemModel2.estimatePass == null || next.carOperationCache != 1) {
                            anyCarEstimateItemModel.estimatePass = new NewEstimateChoosedOpration();
                        } else {
                            anyCarEstimateItemModel.estimatePass = anyCarEstimateItemModel2.estimatePass;
                        }
                        anyCarEstimateItemModel.estimatePass.operationData = next.operationData;
                    }
                }
            }
        }
    }
}
