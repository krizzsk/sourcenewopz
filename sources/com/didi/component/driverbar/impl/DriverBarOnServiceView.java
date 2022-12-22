package com.didi.component.driverbar.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.driverbar.AvatarEnlargePopup;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.driverbar.model.DriverPersonData;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import kotlin.Pair;

public class DriverBarOnServiceView extends DriverBarFieldBase {

    /* renamed from: a */
    private ImageView f12970a = ((ImageView) findView(R.id.driver_card_person_image));

    /* renamed from: b */
    private TextView f12971b = ((TextView) findView(R.id.driver_card_person_name));

    /* renamed from: c */
    private View f12972c = findView(R.id.driver_card_person_info_ll);

    /* renamed from: d */
    private ImageView f12973d = ((ImageView) findView(R.id.driver_card_star_img));

    /* renamed from: e */
    private TextView f12974e = ((TextView) findView(R.id.dot_text1));

    /* renamed from: f */
    private TextView f12975f = ((TextView) findView(R.id.driver_card_trip_num));

    /* renamed from: g */
    private TextView f12976g = ((TextView) findView(R.id.driver_card_star_text));

    public DriverBarOnServiceView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void inflateView(Context context, ViewGroup viewGroup) {
        this.mContainerView = ViewEx.inflateViewAsync(context, (int) R.layout.driver_bar_v2_on_service_view, viewGroup, false);
    }

    public void setData(final DriverBarV2Model driverBarV2Model) {
        super.setData(driverBarV2Model);
        if (driverBarV2Model != null && driverBarV2Model.farModel != null && driverBarV2Model.farModel.personData != null) {
            DriverPersonData driverPersonData = driverBarV2Model.farModel.personData;
            if (!Utils.isDestroy(this.mContext)) {
                ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverPersonData.avatar).placeholder((int) R.drawable.driver_card_default_avatar_v2)).into(this.f12970a);
            }
            if (driverPersonData.nameInfo == null || TextUtils.isEmpty(driverPersonData.nameInfo.getContent())) {
                this.f12971b.setVisibility(8);
            } else {
                this.f12971b.setVisibility(0);
                driverPersonData.nameInfo.bindTextView(this.f12971b);
            }
            if (driverPersonData.score == null || TextUtils.isEmpty(driverPersonData.score.getContent())) {
                this.f12976g.setVisibility(8);
                this.f12973d.setVisibility(8);
            } else {
                this.f12976g.setVisibility(0);
                this.f12973d.setVisibility(0);
                driverPersonData.score.bindTextView(this.f12976g);
            }
            if (driverPersonData.orderCount == null || TextUtils.isEmpty(driverPersonData.orderCount.getContent())) {
                this.f12975f.setVisibility(8);
            } else {
                if (this.f12976g.getVisibility() == 0) {
                    this.f12974e.setVisibility(0);
                } else {
                    this.f12974e.setVisibility(8);
                }
                this.f12975f.setVisibility(0);
                driverPersonData.orderCount.bindTextView(this.f12975f);
            }
            this.f12972c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DriverBarOnServiceView.this.dispatchDriverClicked((Pair<String, String>) null);
                }
            });
            this.f12970a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_driverhead_ck");
                    new AvatarEnlargePopup(DriverBarOnServiceView.this.mContext, LayoutInflater.from(DriverBarOnServiceView.this.mContext).inflate(R.layout.driver_avatar_enlarge_popup, (ViewGroup) null), -1, -1, driverBarV2Model.farModel.personData.avatar).show();
                }
            });
        }
    }
}
