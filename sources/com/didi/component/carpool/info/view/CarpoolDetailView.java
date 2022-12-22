package com.didi.component.carpool.info.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.business.util.UiUtils;
import com.didi.component.carpool.info.model.CarPoolCardInfo;
import com.didi.component.carpool.info.model.CarpoolInfoItem;
import com.didi.component.carpool.info.model.TravelInfoMsg;
import com.didi.component.carpool.info.model.WaitLinePointData;
import com.didi.component.carpool.info.presenter.AbsCarpoolInfoPresenter;
import com.didi.component.common.util.CollectionUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarpoolDetailView implements ICarpoolInfoView {

    /* renamed from: a */
    private static final int f11432a = 9;

    /* renamed from: b */
    private final Context f11433b;

    /* renamed from: c */
    private View f11434c;

    /* renamed from: d */
    private CarpoolDetailViewCanvas f11435d;

    /* renamed from: e */
    private LinearLayout f11436e = ((LinearLayout) this.f11434c.findViewById(R.id.global_carpool_detail_list));

    /* renamed from: f */
    private ViewGroup f11437f = ((ViewGroup) this.f11434c.findViewById(R.id.global_carpool_detail_fee_layout));

    /* renamed from: g */
    private TextView f11438g = ((TextView) this.f11434c.findViewById(R.id.global_carpool_detail_fee));

    /* renamed from: h */
    private TextView f11439h = ((TextView) this.f11434c.findViewById(R.id.global_carpool_detail_payment));

    /* renamed from: i */
    private TextView f11440i = ((TextView) this.f11434c.findViewById(R.id.global_carpool_detail_price_desc));

    /* renamed from: j */
    private LEGORichInfo f11441j;

    /* renamed from: k */
    private boolean f11442k;

    public void setPresenter(AbsCarpoolInfoPresenter absCarpoolInfoPresenter) {
    }

    public CarpoolDetailView(Context context, int i) {
        this.f11433b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_carpool_detail_layout, (ViewGroup) null);
        this.f11434c = inflate;
        this.f11435d = (CarpoolDetailViewCanvas) inflate.findViewById(R.id.global_carpool_detail_canvas);
    }

    public View getView() {
        return this.f11434c;
    }

    public void setTravelDetailData(List<CarpoolInfoItem> list, int i) {
        this.f11436e.removeAllViews();
        LayoutInflater from = LayoutInflater.from(this.f11433b);
        for (int i2 = 0; i2 < list.size(); i2++) {
            LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.global_carpool_detail_item, this.f11436e, false);
            new CarpoolItemViewHolder(linearLayout, i).setData(list.get(i2), i2);
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = UiUtils.dip2px(this.f11433b, 9.0f);
            this.f11436e.addView(linearLayout);
        }
        this.f11435d.setTravelDetailData(list, i);
        this.f11435d.postInvalidate();
    }

    public void setRealtimeFee(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            this.f11437f.setVisibility(0);
            this.f11438g.setText(str);
            this.f11439h.setText(str2);
            this.f11442k = true;
            m7749a();
            return;
        }
        this.f11437f.setVisibility(8);
        this.f11442k = false;
    }

    public void setData(CarPoolCardInfo carPoolCardInfo) {
        if (carPoolCardInfo != null) {
            ArrayList arrayList = new ArrayList();
            if (!CollectionUtils.isEmpty((Collection) carPoolCardInfo.waitPoints)) {
                for (int i = 0; i < carPoolCardInfo.waitPoints.size(); i++) {
                    WaitLinePointData waitLinePointData = carPoolCardInfo.waitPoints.get(i);
                    CarpoolInfoItem carpoolInfoItem = new CarpoolInfoItem();
                    carpoolInfoItem.status = waitLinePointData.staus;
                    carpoolInfoItem.viewType = waitLinePointData.type;
                    carpoolInfoItem.title = waitLinePointData.title;
                    carpoolInfoItem.subTitle = waitLinePointData.content;
                    carpoolInfoItem.showDotLine = waitLinePointData.showDotLine;
                    arrayList.add(carpoolInfoItem);
                }
                setTravelDetailData(arrayList, carPoolCardInfo.guideType);
            }
            if (!CollectionUtils.isEmpty((Collection) carPoolCardInfo.travelInfoMsgList)) {
                ArrayList arrayList2 = new ArrayList();
                for (TravelInfoMsg next : carPoolCardInfo.travelInfoMsgList) {
                    if (next != null) {
                        CarpoolInfoItem carpoolInfoItem2 = new CarpoolInfoItem();
                        carpoolInfoItem2.viewType = next.type;
                        carpoolInfoItem2.status = next.status;
                        carpoolInfoItem2.title = next.title;
                        carpoolInfoItem2.subTitle = next.content;
                        carpoolInfoItem2.showDotLine = next.showDotLine;
                        arrayList2.add(carpoolInfoItem2);
                    }
                }
                setTravelDetailData(arrayList2, carPoolCardInfo.guideType);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11436e.getLayoutParams();
            if (carPoolCardInfo.guideType > 0) {
                layoutParams.leftMargin = UiUtils.dip2px(this.f11433b, 40.0f);
            } else {
                layoutParams.leftMargin = UiUtils.dip2px(this.f11433b, 15.0f);
            }
            this.f11441j = carPoolCardInfo.noticeInfo;
            m7749a();
        }
    }

    /* renamed from: a */
    private void m7749a() {
        if (!this.f11442k || this.f11441j == null) {
            this.f11440i.setVisibility(8);
            return;
        }
        this.f11440i.setVisibility(0);
        this.f11441j.bindTextView(this.f11440i);
        this.f11441j.setOnClickListener(new LEGORichInfo.RichInfoClickListener() {
            public void onClick(String str) {
                DRouter.build(str).start();
            }
        });
    }
}
