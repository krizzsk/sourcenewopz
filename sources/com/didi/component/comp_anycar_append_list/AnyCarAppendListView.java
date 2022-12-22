package com.didi.component.comp_anycar_append_list;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.comp_anycar_append_list.AnyCarAppendData;
import com.didi.component.core.IView;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.button.LEGOLoadingButton;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didiglobal.comp.carmodellist.AnyCarModelList;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.taxis99.R;
import java.util.List;

public class AnyCarAppendListView implements IAnyCarAppendListView, IView<AnyCarAppendListPresenter>, IViewContainer {

    /* renamed from: a */
    private Context f12095a;

    /* renamed from: b */
    private View f12096b;

    /* renamed from: c */
    private TextView f12097c;

    /* renamed from: d */
    private ViewGroup f12098d;

    /* renamed from: e */
    private ViewGroup f12099e;

    /* renamed from: f */
    private ImageView f12100f;

    /* renamed from: g */
    private TextView f12101g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LEGOLoadingButton f12102h;

    /* renamed from: i */
    private AnyCarModelList f12103i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AnyCarAppendListPresenter f12104j;

    /* renamed from: k */
    private String f12105k = "";

    /* renamed from: l */
    private String f12106l = "";

    /* renamed from: m */
    private String f12107m = "{{category_num}}";

    /* renamed from: n */
    private AnyCarSelectListener f12108n = new AnyCarSelectListener() {
        public void openDetail(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        }

        public void setAllItems(List<AnyCarEstimateItemModel> list) {
        }

        public void singleSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        }

        public void defaultSelectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
            if (AnyCarAppendListView.this.f12104j != null) {
                AnyCarAppendListView.this.f12104j.defaultSelectedItem(anyCarEstimateItemModel);
            }
        }

        public void selectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
            if (AnyCarAppendListView.this.f12104j != null) {
                AnyCarAppendListView.this.f12104j.selectedItem(anyCarEstimateItemModel);
            }
        }

        public void unSelectItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
            if (AnyCarAppendListView.this.f12104j != null) {
                AnyCarAppendListView.this.f12104j.unSelectItem(anyCarEstimateItemModel);
            }
        }

        public void carpoolSeatSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
            if (AnyCarAppendListView.this.f12104j != null) {
                AnyCarAppendListView.this.f12104j.carpoolSeatSelected(anyCarEstimateItemModel);
                BaseEventPublisher.getPublisher().publish("event_show_loading_on_titlebar_in_home");
            }
        }
    };

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
    }

    public AnyCarAppendListView(Context context, ViewGroup viewGroup) {
        this.f12095a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.any_car_append_list_container_layout, viewGroup, false);
        this.f12096b = inflate;
        this.f12097c = (TextView) inflate.findViewById(R.id.any_car_append_list_title);
        this.f12098d = (ViewGroup) this.f12096b.findViewById(R.id.any_car_append_model_list);
        this.f12099e = (ViewGroup) this.f12096b.findViewById(R.id.any_car_append_message_layout);
        this.f12101g = (TextView) this.f12096b.findViewById(R.id.any_car_append_message_text);
        this.f12100f = (ImageView) this.f12096b.findViewById(R.id.any_car_append_message_icon);
        LEGOLoadingButton lEGOLoadingButton = (LEGOLoadingButton) this.f12096b.findViewById(R.id.any_car_append_submit_btn_view);
        this.f12102h = lEGOLoadingButton;
        lEGOLoadingButton.setButtonClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (AnyCarAppendListView.this.f12104j != null) {
                    BaseEventPublisher.getPublisher().publish("event_show_loading_on_titlebar_in_home");
                    AnyCarAppendListView.this.f12102h.setClickable(false);
                    AnyCarAppendListView.this.f12102h.setLoading(true);
                    AnyCarAppendListView.this.f12104j.submitCarModelAppend();
                }
            }
        });
        this.f12102h.setButtonEnable(false);
        this.f12102h.setButtonClickable(false);
        AnyCarModelList anyCarModelList = new AnyCarModelList(context, viewGroup, this.f12108n);
        this.f12103i = anyCarModelList;
        anyCarModelList.setNestedScrollingEnabled(false);
        this.f12098d.addView(this.f12103i.getRootView());
    }

    public View getView() {
        return this.f12096b;
    }

    public void setPresenter(AnyCarAppendListPresenter anyCarAppendListPresenter) {
        this.f12104j = anyCarAppendListPresenter;
    }

    public void setTitle(LEGORichInfo lEGORichInfo) {
        if (lEGORichInfo != null) {
            lEGORichInfo.bindTextView(this.f12097c);
        }
    }

    public void setData(List<AnyCarGroup> list) {
        this.f12103i.setData(list);
    }

    public void setSubmitBtn(AnyCarAppendData.BtnInfo btnInfo) {
        SpannableString parseRichInfo;
        if (btnInfo != null && btnInfo.stateEnable != null && btnInfo.stateDisable != null && (parseRichInfo = btnInfo.stateEnable.parseRichInfo(getView().getContext())) != null) {
            this.f12105k = parseRichInfo.toString();
            SpannableString parseRichInfo2 = btnInfo.stateDisable.parseRichInfo(getView().getContext());
            if (parseRichInfo2 != null) {
                this.f12106l = parseRichInfo2.toString();
                refreshBtnContent();
            }
        }
    }

    public void refreshBtnContent() {
        AnyCarAppendListPresenter anyCarAppendListPresenter = this.f12104j;
        if (anyCarAppendListPresenter == null || anyCarAppendListPresenter.getSelectedAnyCarItems().size() == 0) {
            this.f12102h.setButtonText(this.f12106l);
            this.f12102h.setButtonEnable(false);
            this.f12102h.setButtonClickable(false);
            return;
        }
        this.f12102h.setButtonText(this.f12105k.replace(this.f12107m, String.valueOf(this.f12104j.getSelectedAnyCarItems().size())));
        this.f12102h.setButtonEnable(true);
        this.f12102h.setButtonClickable(true);
    }

    public void updateMsgTips(CarMessageModel carMessageModel) {
        if (carMessageModel == null) {
            this.f12099e.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12102h.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.f12096b.getContext(), 15.0f);
            this.f12102h.setLayoutParams(layoutParams);
            return;
        }
        this.f12099e.setVisibility(0);
        if (!TextUtils.isEmpty(carMessageModel.messageIcon)) {
            this.f12100f.setVisibility(0);
            Context context = this.f12095a;
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(this.f12095a).load(carMessageModel.messageIcon).into(this.f12100f);
            }
        } else {
            this.f12100f.setVisibility(8);
        }
        if (!(carMessageModel == null || carMessageModel.msg == null || TextUtils.isEmpty(carMessageModel.msg.getContent()))) {
            carMessageModel.msg.bindTextView(this.f12101g);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f12102h.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.f12102h.setLayoutParams(layoutParams2);
    }

    public void updateBtnLoading(Boolean bool) {
        this.f12102h.setLoading(bool.booleanValue());
    }
}
