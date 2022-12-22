package com.didi.component.pagedata.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.pagedata.AbsPageDataPresenter;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import java.util.List;

public class TripPageDataPresenter extends AbsPageDataPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<AnyCarEstimateItemModel> f14855a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AnyCarEstimateItemModel f14856b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<AnyCarGroup> f14857c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f14858d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f14859e;

    public TripPageDataPresenter(Context context) {
        super(context);
        PageCompDataTransfer.getInstance().setTripListener(new TripListener() {
            public void setSelectedAnyCarItem(List<AnyCarEstimateItemModel> list) {
                List unused = TripPageDataPresenter.this.f14855a = list;
            }

            public List<AnyCarEstimateItemModel> getSelectedAnyCarItems() {
                return TripPageDataPresenter.this.f14855a;
            }

            public void setSelectedSingleAnyCarItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                AnyCarEstimateItemModel unused = TripPageDataPresenter.this.f14856b = anyCarEstimateItemModel;
            }

            public AnyCarEstimateItemModel getSelectedSingleAnyCarItem() {
                return TripPageDataPresenter.this.f14856b;
            }

            public List<AnyCarGroup> getGroups() {
                return TripPageDataPresenter.this.f14857c;
            }

            public void setGroups(List<AnyCarGroup> list) {
                List unused = TripPageDataPresenter.this.f14857c = list;
            }

            public void setIsAnyCar(boolean z) {
                boolean unused = TripPageDataPresenter.this.f14859e = z;
            }

            public boolean getIsAnyCar() {
                return TripPageDataPresenter.this.f14859e;
            }

            public void setPreference(int i) {
                int unused = TripPageDataPresenter.this.f14858d = i;
            }

            public int getPreference() {
                return TripPageDataPresenter.this.f14858d;
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
        PageCompDataTransfer.getInstance().setTripListener((TripListener) null);
    }
}
