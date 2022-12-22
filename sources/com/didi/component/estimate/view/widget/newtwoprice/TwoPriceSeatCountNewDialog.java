package com.didi.component.estimate.view.widget.newtwoprice;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.estimate.presenter.EstimatePresenter;
import com.didi.component.estimate.view.widget.newtwoprice.TwoPriceSeatCountAdapter;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.popup.PopupSelectRecyclerView;
import com.didi.travel.psnger.model.response.estimate.CarBreakSeatModel;
import com.didi.travel.psnger.model.response.estimate.CarSeatChoiceModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.List;

public class TwoPriceSeatCountNewDialog extends SimplePopupBase {

    /* renamed from: a */
    private BusinessContext f13283a;

    /* renamed from: b */
    private int f13284b;

    /* renamed from: c */
    private TextView f13285c;

    /* renamed from: d */
    private TextView f13286d;

    /* renamed from: e */
    private ImageView f13287e;

    /* renamed from: f */
    private PopupSelectRecyclerView f13288f;

    /* renamed from: g */
    private TextView f13289g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TwoPriceSeatCountAdapter f13290h;

    /* renamed from: i */
    private CarBreakSeatModel f13291i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f13292j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public EstimatePresenter f13293k;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_two_price_dialog_new_ui_layout;
    }

    public static TwoPriceSeatCountNewDialog newInstance(int i) {
        TwoPriceSeatCountNewDialog twoPriceSeatCountNewDialog = new TwoPriceSeatCountNewDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("default_people", i);
        twoPriceSeatCountNewDialog.setArguments(bundle);
        return twoPriceSeatCountNewDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13284b = arguments.getInt("default_people", 0);
        } else {
            this.f13284b = 1;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f13285c = (TextView) this.mRootView.findViewById(R.id.global_seat_count_title);
        this.f13286d = (TextView) this.mRootView.findViewById(R.id.global_seat_count_subtitle);
        this.f13287e = (ImageView) this.mRootView.findViewById(R.id.global_seat_count_close_btn);
        this.f13288f = (PopupSelectRecyclerView) this.mRootView.findViewById(R.id.global_seat_count_recycler_view);
        this.f13289g = (TextView) this.mRootView.findViewById(R.id.global_seat_count_confirm_btn);
        m9052a();
        m9054b();
    }

    /* renamed from: a */
    private void m9052a() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.carBreakModel != null && newEstimateItem.carBreakModel.carBreakSeat != null) {
            CarBreakSeatModel carBreakSeatModel = newEstimateItem.carBreakModel.carBreakSeat;
            this.f13291i = carBreakSeatModel;
            if (!TextUtils.isEmpty(carBreakSeatModel.seatBreakTitle)) {
                this.f13285c.setText(this.f13291i.seatBreakTitle);
            }
            if (!TextUtils.isEmpty(this.f13291i.seatBreakContent)) {
                this.f13286d.setText(this.f13291i.seatBreakContent);
            }
            this.f13288f.setLayoutManager(new LinearLayoutManager(getContext()));
            TwoPriceSeatCountAdapter twoPriceSeatCountAdapter = new TwoPriceSeatCountAdapter(getContext());
            this.f13290h = twoPriceSeatCountAdapter;
            this.f13288f.setAdapter(twoPriceSeatCountAdapter);
            if (this.f13291i.seatBreakChoice != null && this.f13291i.seatBreakChoice.size() > 0) {
                this.f13290h.updateData(this.f13291i.seatBreakChoice);
            }
            int i = this.f13284b;
            if (i > 0) {
                this.f13290h.setSelectedPos(i - 1);
            }
        }
    }

    /* renamed from: b */
    private void m9054b() {
        this.f13290h.setOnSeatItemClickListener(new TwoPriceSeatCountAdapter.OnSeatItemClickListener() {
            public void onItemClick(int i) {
                int unused = TwoPriceSeatCountNewDialog.this.f13292j = i;
                TwoPriceSeatCountNewDialog.this.f13290h.setSelectedPos(i);
            }
        });
        this.f13289g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CarSeatChoiceModel carSeatChoiceModel;
                AutoTrackHelper.trackViewOnClick(view);
                if (!Utils.isFastDoubleClick()) {
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    List<CarSeatChoiceModel> data = TwoPriceSeatCountNewDialog.this.f13290h.getData();
                    if (!(data == null || data.size() <= 0 || newEstimateItem == null || (carSeatChoiceModel = data.get(TwoPriceSeatCountNewDialog.this.f13292j)) == null || carSeatChoiceModel.getselectValue() == null)) {
                        newEstimateItem.feeNumber = carSeatChoiceModel.getselectValue().seatPoolEstimatePrice;
                        newEstimateItem.estimateId = carSeatChoiceModel.getselectValue().seatPoolEstimateId;
                        FormStore.getInstance().setCurrentComboType(carSeatChoiceModel.getselectValue().comboType);
                        newEstimateItem.setSelectedValueParams(carSeatChoiceModel.getselectValue(), carSeatChoiceModel.selectValueObject);
                        newEstimateItem.setSelectPos(TwoPriceSeatCountNewDialog.this.f13292j);
                        FormStore.getInstance().setCarpoolOrderScene(carSeatChoiceModel.getselectValue().carpoolOrderScene);
                    }
                    TwoPriceSeatCountNewDialog.this.f13293k.onTwoPriceConfirmClick();
                }
            }
        });
        this.f13287e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TwoPriceSeatCountNewDialog.this.dismissDialog();
            }
        });
    }

    public void dismissDialog() {
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f13283a = businessContext;
    }

    public void setPresenter(EstimatePresenter estimatePresenter) {
        this.f13293k = estimatePresenter;
    }

    public int getSelectedSeatCount() {
        return this.f13292j + 1;
    }
}
