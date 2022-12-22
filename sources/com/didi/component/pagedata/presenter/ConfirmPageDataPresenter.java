package com.didi.component.pagedata.presenter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.AnycarItemStatusListener;
import com.didi.component.business.data.form.listener.ConfirmAddressListener;
import com.didi.component.business.data.form.listener.ConfirmGetListener;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.data.form.listener.observer.CustomObserver;
import com.didi.component.pagedata.AbsPageDataPresenter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarResponse;
import com.didi.travel.psnger.model.response.estimate.CarInfoModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ConfirmPageDataPresenter extends AbsPageDataPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AnyCarResponse f14840a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<AnyCarEstimateItemModel> f14841b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<AnyCarEstimateItemModel> f14842c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f14843d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AnyCarEstimateItemModel f14844e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AnyCarPayModel f14845f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<CustomObserver> f14846g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<ConfirmAddressListener> f14847h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AnycarItemStatusListener f14848i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f14849j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AnyCarEstimateItemModel f14850k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<AnyCarGroup> f14851l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f14852m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Rect f14853n;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Rect f14854p;

    public ConfirmPageDataPresenter(Context context) {
        super(context);
        PageCompDataTransfer.getInstance().setConfirmListener(new ConfirmListener() {
            public void setSelectedAnyCarItem(List<AnyCarEstimateItemModel> list) {
                List unused = ConfirmPageDataPresenter.this.f14842c = list;
                if (!CollectionUtil.isEmpty((Collection<?>) ConfirmPageDataPresenter.this.f14842c)) {
                    Logger b = ConfirmPageDataPresenter.this.mLogger;
                    b.debug("lxsanycar" + ConfirmPageDataPresenter.this.f14842c.toString() + "======" + ConfirmPageDataPresenter.this.f14842c.size(), new Object[0]);
                    for (AnyCarEstimateItemModel anyCarEstimateItemModel : ConfirmPageDataPresenter.this.f14842c) {
                        if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo != null) {
                            Logger c = ConfirmPageDataPresenter.this.mLogger;
                            c.debug("lxsanycar" + anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo.carName, new Object[0]);
                        }
                    }
                }
            }

            public List<AnyCarEstimateItemModel> getSelectedAnyCarItems() {
                return ConfirmPageDataPresenter.this.f14842c;
            }

            public void setPreference(int i) {
                int unused = ConfirmPageDataPresenter.this.f14852m = i;
            }

            public int getPreference() {
                return ConfirmPageDataPresenter.this.f14852m;
            }

            public void setAnyCarResponse(AnyCarResponse anyCarResponse) {
                AnyCarResponse unused = ConfirmPageDataPresenter.this.f14840a = anyCarResponse;
            }

            public AnyCarResponse getAnyCarResponse() {
                return ConfirmPageDataPresenter.this.f14840a;
            }

            public void setAllCarItems(List<AnyCarEstimateItemModel> list) {
                ConfirmPageDataPresenter.this.f14841b.clear();
                ConfirmPageDataPresenter.this.f14841b.addAll(list);
            }

            public List<AnyCarEstimateItemModel> getAllCarItems() {
                return ConfirmPageDataPresenter.this.f14841b;
            }

            public void setIsAnyCar(boolean z) {
                boolean unused = ConfirmPageDataPresenter.this.f14843d = z;
            }

            public boolean getIsAnyCar() {
                return ConfirmPageDataPresenter.this.f14843d;
            }

            public void setSelectedSingleAnyCarItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                AnyCarEstimateItemModel unused = ConfirmPageDataPresenter.this.f14844e = anyCarEstimateItemModel;
                if (ConfirmPageDataPresenter.this.f14844e != null && ConfirmPageDataPresenter.this.f14844e.mAnyCarEstimateNetItem.carInfo != null) {
                    Logger i = ConfirmPageDataPresenter.this.mLogger;
                    i.debug("lxsanycar" + ConfirmPageDataPresenter.this.f14844e.mAnyCarEstimateNetItem.carInfo.carName + "-------" + ConfirmPageDataPresenter.this.f14844e.toString(), new Object[0]);
                }
            }

            public AnyCarEstimateItemModel getSelectedSingleAnyCarItem() {
                return ConfirmPageDataPresenter.this.f14844e;
            }

            public void setAnycarPayModel(AnyCarPayModel anyCarPayModel) {
                AnyCarPayModel unused = ConfirmPageDataPresenter.this.f14845f = anyCarPayModel;
            }

            public AnyCarPayModel getAnycarPayModel() {
                return ConfirmPageDataPresenter.this.f14845f;
            }

            @Deprecated
            public void update(int i) {
                if (ConfirmPageDataPresenter.this.f14846g != null) {
                    for (CustomObserver update : ConfirmPageDataPresenter.this.f14846g) {
                        update.update(i);
                    }
                }
            }

            public List<CustomObserver> getCustomObservers() {
                return ConfirmPageDataPresenter.this.f14846g;
            }

            public void addCustomObserver(CustomObserver customObserver) {
                if (ConfirmPageDataPresenter.this.f14846g == null) {
                    List unused = ConfirmPageDataPresenter.this.f14846g = new ArrayList();
                }
                ConfirmPageDataPresenter.this.f14846g.add(customObserver);
            }

            public void updateAlpha(float f) {
                if (ConfirmPageDataPresenter.this.f14847h != null) {
                    for (ConfirmAddressListener updateAlpha : ConfirmPageDataPresenter.this.f14847h) {
                        updateAlpha.updateAlpha(f);
                    }
                }
            }

            public List<ConfirmAddressListener> getConfirmAddressObservers() {
                return ConfirmPageDataPresenter.this.f14847h;
            }

            public void addConfirmAddressObserver(ConfirmAddressListener confirmAddressListener) {
                if (ConfirmPageDataPresenter.this.f14847h == null) {
                    List unused = ConfirmPageDataPresenter.this.f14847h = new ArrayList();
                }
                ConfirmPageDataPresenter.this.f14847h.add(confirmAddressListener);
            }

            public void setItemStatusLisener(AnycarItemStatusListener anycarItemStatusListener) {
                AnycarItemStatusListener unused = ConfirmPageDataPresenter.this.f14848i = anycarItemStatusListener;
            }

            public AnycarItemStatusListener getItemStatusListener() {
                return ConfirmPageDataPresenter.this.f14848i;
            }

            public int getCurrentPage() {
                return ConfirmPageDataPresenter.this.f14849j;
            }

            public void setCurrentPage(int i) {
                int unused = ConfirmPageDataPresenter.this.f14849j = i;
            }

            public void setHitPreOrderItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                AnyCarEstimateItemModel unused = ConfirmPageDataPresenter.this.f14850k = anyCarEstimateItemModel;
            }

            public boolean isConfirmAddressPage() {
                return ConfirmPageDataPresenter.this.f14849j == 3;
            }

            public AnyCarEstimateItemModel getHitPreOrderItem() {
                return ConfirmPageDataPresenter.this.f14850k;
            }

            public AnyCarEstimateItemModel getFirstSelectedItem() {
                if (ConfirmPageDataPresenter.this.f14844e != null) {
                    return ConfirmPageDataPresenter.this.f14844e;
                }
                if (!CollectionUtil.isEmpty((Collection<?>) ConfirmPageDataPresenter.this.f14842c)) {
                    return (AnyCarEstimateItemModel) ConfirmPageDataPresenter.this.f14842c.get(0);
                }
                return null;
            }

            public List<AnyCarGroup> getGroups() {
                return ConfirmPageDataPresenter.this.f14851l;
            }

            public void setGroups(List<AnyCarGroup> list) {
                List unused = ConfirmPageDataPresenter.this.f14851l = list;
            }

            public Rect getPreferenceRect() {
                return ConfirmPageDataPresenter.this.f14853n;
            }

            public void setPreferenceRect(Rect rect) {
                Rect unused = ConfirmPageDataPresenter.this.f14853n = rect;
            }

            public Rect getAnycarEstimtePanleRect() {
                return ConfirmPageDataPresenter.this.f14854p;
            }

            public void setAnycarEstimteRect(Rect rect) {
                Rect unused = ConfirmPageDataPresenter.this.f14854p = rect;
            }
        });
        PageCompDataTransfer.getInstance().setConfirmGetListener(new ConfirmGetListener() {
            public String getTraceId() {
                return (ConfirmPageDataPresenter.this.f14840a == null || ConfirmPageDataPresenter.this.f14840a.globalConfig == null) ? "" : ConfirmPageDataPresenter.this.f14840a.globalConfig.globalEstimateTraceId;
            }

            public String getBtnSubText() {
                boolean z;
                List<AnyCarEstimateItemModel> a = ConfirmPageDataPresenter.this.f14842c;
                ArrayList arrayList = new ArrayList();
                ArrayList<CarInfoModel.AnyCarOrderPrice> arrayList2 = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                if (!CollectionUtil.isEmpty((Collection<?>) a)) {
                    for (AnyCarEstimateItemModel anyCarEstimateItemModel : a) {
                        if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo.orderPrice == null)) {
                            if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo.orderPrice.priceLevel < 0.0d) {
                                arrayList2.add(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo.orderPrice);
                            } else {
                                arrayList.add(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carInfo.orderPrice);
                            }
                        }
                    }
                    if (!CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                        if (arrayList.size() == 1) {
                            sb = new StringBuilder(((CarInfoModel.AnyCarOrderPrice) arrayList.get(0)).priceText);
                        } else {
                            Collections.sort(arrayList, new Comparator<CarInfoModel.AnyCarOrderPrice>() {
                                public int compare(CarInfoModel.AnyCarOrderPrice anyCarOrderPrice, CarInfoModel.AnyCarOrderPrice anyCarOrderPrice2) {
                                    return Double.compare(anyCarOrderPrice.priceLevel, anyCarOrderPrice2.priceLevel);
                                }
                            });
                            if (Double.compare(((CarInfoModel.AnyCarOrderPrice) arrayList.get(0)).priceLevel, ((CarInfoModel.AnyCarOrderPrice) arrayList.get(arrayList.size() - 1)).priceLevel) == 0) {
                                sb = new StringBuilder(((CarInfoModel.AnyCarOrderPrice) arrayList.get(0)).priceText);
                            } else {
                                sb = new StringBuilder(((CarInfoModel.AnyCarOrderPrice) arrayList.get(0)).priceText);
                                sb.append("~");
                                sb.append(((CarInfoModel.AnyCarOrderPrice) arrayList.get(arrayList.size() - 1)).priceText);
                            }
                        }
                    }
                    if (!CollectionUtil.isEmpty((Collection<?>) arrayList2)) {
                        if (arrayList2.size() != 1) {
                            ArrayList<CarInfoModel.AnyCarOrderPrice> arrayList3 = new ArrayList<>();
                            for (CarInfoModel.AnyCarOrderPrice anyCarOrderPrice : arrayList2) {
                                Iterator it = arrayList3.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (Double.compare(((CarInfoModel.AnyCarOrderPrice) it.next()).priceLevel, anyCarOrderPrice.priceLevel) == 0) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                    arrayList3.add(anyCarOrderPrice);
                                }
                            }
                            if (arrayList3.size() == 1) {
                                sb.append(((CarInfoModel.AnyCarOrderPrice) arrayList3.get(0)).priceText);
                            } else {
                                Collections.sort(arrayList3, new Comparator<CarInfoModel.AnyCarOrderPrice>() {
                                    public int compare(CarInfoModel.AnyCarOrderPrice anyCarOrderPrice, CarInfoModel.AnyCarOrderPrice anyCarOrderPrice2) {
                                        return Double.compare(anyCarOrderPrice.priceLevel, anyCarOrderPrice2.priceLevel);
                                    }
                                });
                                for (CarInfoModel.AnyCarOrderPrice anyCarOrderPrice2 : arrayList3) {
                                    sb.append("+");
                                    sb.append(anyCarOrderPrice2.priceText);
                                }
                            }
                        } else if (sb.toString().length() == 0) {
                            sb.append(((CarInfoModel.AnyCarOrderPrice) arrayList2.get(0)).priceText);
                        } else {
                            sb.append("+");
                            sb.append(((CarInfoModel.AnyCarOrderPrice) arrayList2.get(0)).priceText);
                        }
                    }
                }
                Logger s = ConfirmPageDataPresenter.this.mLogger;
                s.debug("lxsanycar btn" + sb.toString(), new Object[0]);
                return sb.toString();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        PageCompDataTransfer.getInstance().setConfirmListener((ConfirmListener) null);
        PageCompDataTransfer.getInstance().setConfirmGetListener((ConfirmGetListener) null);
    }
}
