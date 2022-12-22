package com.didi.component.groupform.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.groupform.presenter.AbsGroupFormPresenter;
import com.didi.component.groupform.view.adapter.FormViewOptionAdapter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel3;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.model.response.estimate.CarFareConfirmBreak;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.FormOperationModels;
import com.didichuxing.omega.sdk.Omega;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GroupFormViewNewUI implements IViewContainer, IGroupFormView {

    /* renamed from: a */
    private View f14059a;

    /* renamed from: b */
    private TextView f14060b;

    /* renamed from: c */
    private AbsGroupFormPresenter f14061c;

    /* renamed from: d */
    private RecyclerView f14062d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f14063e;

    /* renamed from: f */
    private GridLayoutManager f14064f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FormViewOptionAdapter f14065g;

    /* renamed from: h */
    private Drawable f14066h;

    /* renamed from: i */
    private LEGODrawer f14067i;

    /* renamed from: j */
    private ConstraintLayout f14068j;

    /* renamed from: k */
    private List<Integer> f14069k;

    /* renamed from: l */
    private FrameLayout f14070l;

    /* renamed from: m */
    private IComponent f14071m;

    /* renamed from: n */
    private boolean f14072n;

    /* renamed from: o */
    private boolean f14073o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final Logger f14074p = LoggerFactory.getLogger(getClass());

    public void setupPointText(String str, boolean z, boolean z2) {
    }

    public void updateText() {
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f14061c.setComponentCreator(iComponentCreator);
    }

    public GroupFormViewNewUI(Context context, ViewGroup viewGroup) {
        this.f14063e = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.f14065g = new FormViewOptionAdapter();
        View inflate = from.inflate(R.layout.global_group_form_new_ui_layout, viewGroup, false);
        this.f14059a = inflate;
        this.f14060b = (TextView) inflate.findViewById(R.id.form_btn);
        this.f14068j = (ConstraintLayout) this.f14059a.findViewById(R.id.global_form_layout);
        this.f14070l = (FrameLayout) this.f14059a.findViewById(R.id.payway_container);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.confirmText)) {
            this.f14060b.setText(R.string.global_confirm_btn_new);
        } else {
            this.f14060b.setText(newEstimateItem.carConfig.confirmText);
        }
        Drawable drawable = DidiThemeManager.getIns().getResPicker(context).getDrawable(R.attr.global_overall_main_button_selector);
        this.f14066h = drawable;
        this.f14060b.setBackground(drawable);
        try {
            this.f14060b.setTextColor(ContextCompat.getColorStateList(context, DidiThemeManager.getIns().getResPicker(context).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
        } catch (Resources.NotFoundException e) {
            Omega.trackError("comp-group-form", e);
        }
        this.f14062d = (RecyclerView) this.f14059a.findViewById(R.id.global_form_option_container);
        ViewGroup.LayoutParams layoutParams = this.f14068j.getLayoutParams();
        this.f14068j.setBackgroundResource(R.drawable.form_bg);
        layoutParams.height = UiUtils.dip2px(this.f14063e, 169.0f);
        FormStore.getInstance().setmGroupFormViewChanged(true);
        this.f14062d.setLayoutParams((ConstraintLayout.LayoutParams) this.f14062d.getLayoutParams());
        this.f14068j.setLayoutParams(layoutParams);
        this.f14062d.setAdapter(this.f14065g);
        this.f14060b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (!Utils.isFastDoubleClick()) {
                    GroupFormViewNewUI.this.f14074p.debug("FastDoubleClickTest click ", new Object[0]);
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    if (newEstimateItem != null && newEstimateItem.carConfig != null) {
                        if (newEstimateItem.carConfig.carAvailable != 0) {
                            if (GroupFormViewNewUI.this.estimateNoPriceIntercept()) {
                                GroupFormViewNewUI.this.noPriceSendOrderDialog(FormStore.getInstance().getNewEstimateItem().carBreakModel.carFareConfirm);
                            } else {
                                GroupFormViewNewUI.this.onConfirmClick();
                            }
                        } else if (!TextUtils.isEmpty(newEstimateItem.carConfig.unvailableToastText)) {
                            LEGOToastHelper.showToast(GroupFormViewNewUI.this.f14063e, newEstimateItem.carConfig.unvailableToastText);
                        } else {
                            LEGOToastHelper.showToast(GroupFormViewNewUI.this.f14063e, GroupFormViewNewUI.this.f14063e.getString(R.string.GRider_page_Model_current_HCmg));
                        }
                    }
                }
            }
        });
    }

    public void onConfirmClick() {
        if (FormStore.getInstance().isTwoPriceBiz()) {
            FormStore.getInstance().setTwoPriceSeatConfirm(false);
        }
        FormStore.getInstance().setFlexOfferPrice(false);
        this.f14061c.onConfirmPriceIntercept();
    }

    public boolean estimateNoPriceIntercept() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.carBreakModel != null && newEstimateItem.carBreakModel.carFareConfirm != null && !TextUtils.isEmpty(newEstimateItem.carBreakModel.carFareConfirm.fareTitle) && !TextUtils.isEmpty(newEstimateItem.carBreakModel.carFareConfirm.confirmText) && !TextUtils.isEmpty(newEstimateItem.carBreakModel.carFareConfirm.cancelText)) {
            return true;
        }
        return false;
    }

    public void noPriceSendOrderDialog(final CarFareConfirmBreak carFareConfirmBreak) {
        LEGOBaseDrawerModel lEGOBaseDrawerModel;
        noPriceDialogDismiss();
        if (TextUtils.isEmpty(carFareConfirmBreak.linkText) || TextUtils.isEmpty(carFareConfirmBreak.link)) {
            lEGOBaseDrawerModel = new LEGODrawerModel1(carFareConfirmBreak.fareTitle, new LEGOBtnTextAndCallback(carFareConfirmBreak.confirmText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (GroupFormViewNewUI.this.estimateNoPriceIntercept()) {
                        GroupFormViewNewUI.this.onConfirmClick();
                    }
                    GroupFormViewNewUI.this.noPriceDialogDismiss();
                }
            }));
        } else {
            lEGOBaseDrawerModel = new LEGODrawerModel3(carFareConfirmBreak.fareTitle, carFareConfirmBreak.linkText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    Intent intent = new Intent(GroupFormViewNewUI.this.f14063e, GlobalWebActivity.class);
                    intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(carFareConfirmBreak.link));
                    GroupFormViewNewUI.this.f14063e.startActivity(intent);
                }
            }, new LEGOBtnTextAndCallback(carFareConfirmBreak.confirmText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (GroupFormViewNewUI.this.estimateNoPriceIntercept()) {
                        GroupFormViewNewUI.this.onConfirmClick();
                    }
                    GroupFormViewNewUI.this.noPriceDialogDismiss();
                }
            }));
        }
        lEGOBaseDrawerModel.addMinorBtn(new LEGOBtnTextAndCallback(carFareConfirmBreak.cancelText, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GroupFormViewNewUI.this.noPriceDialogDismiss();
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        }));
        if (!TextUtils.isEmpty(carFareConfirmBreak.farText)) {
            lEGOBaseDrawerModel.setSubTitle(carFareConfirmBreak.farText);
        }
        lEGOBaseDrawerModel.setClickOutsideCanCancel(false);
        lEGOBaseDrawerModel.setIsShowCloseImg(true);
        lEGOBaseDrawerModel.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GroupFormViewNewUI.this.noPriceDialogDismiss();
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        });
        LEGODrawer showDrawerTemplate = LEGOUICreator.showDrawerTemplate(this.f14063e, lEGOBaseDrawerModel);
        this.f14067i = showDrawerTemplate;
        showDrawerTemplate.show();
    }

    public void noPriceDialogDismiss() {
        LEGODrawer lEGODrawer = this.f14067i;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f14067i.dismiss();
        }
    }

    public void setPresenter(AbsGroupFormPresenter absGroupFormPresenter) {
        this.f14065g.setPresenter(absGroupFormPresenter);
        this.f14061c = absGroupFormPresenter;
    }

    public View getView() {
        return this.f14059a;
    }

    public void setEnabled(boolean z) {
        this.f14060b.setEnabled(z);
    }

    public void setButtonText(CharSequence charSequence) {
        this.f14060b.setText(charSequence);
    }

    public void setButtonBg(Drawable drawable) {
        if (drawable != null) {
            this.f14060b.setBackground(drawable);
        } else {
            this.f14060b.setBackground(this.f14066h);
        }
    }

    public void setOptionViews(List<Integer> list) {
        LEGODrawer lEGODrawer = this.f14067i;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_BOTTOM_FORM_HINTED);
        }
        if (list != null) {
            List<Integer> list2 = this.f14069k;
            if (list2 == null) {
                this.f14069k = new ArrayList();
            } else {
                list2.clear();
            }
            if (!this.f14072n) {
                this.f14071m = this.f14061c.inflateComponent(ComponentType.PAYWAY, this.f14070l);
                this.f14072n = true;
            }
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.showDataPick()) {
                this.f14069k.add(2);
            }
            FormStore.getInstance().setHasSubstituteCall(false);
            if (newEstimateItem != null && newEstimateItem.mFormOperationModel != null && !CollectionUtils.isEmpty((Collection) newEstimateItem.mFormOperationModel.items)) {
                Iterator<FormOperationModels> it = newEstimateItem.mFormOperationModel.items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FormOperationModels next = it.next();
                    if (next.mFormOperationType == 1) {
                        this.f14069k.add(7);
                        if (!GlobalSPUtil.isShowPaywayGuide(this.f14063e)) {
                            this.f14061c.showNoviceGuidance(next.mEducationPopupCount);
                        }
                        FormStore.getInstance().setHasSubstituteCall(true);
                        m9807a();
                    }
                }
            }
            this.f14065g.setModelList(this.f14069k);
            ConstraintLayout.LayoutParams layoutParams = null;
            if (this.f14060b.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                layoutParams = (ConstraintLayout.LayoutParams) this.f14060b.getLayoutParams();
            }
            if (this.f14065g.getModelListSize() == 0) {
                layoutParams.width = -1;
                layoutParams.setMarginStart(UiUtils.dip2px(this.f14063e, 10.0f));
            } else {
                layoutParams.width = -2;
                layoutParams.setMarginStart(UiUtils.dip2px(this.f14063e, 0.0f));
            }
            if (this.f14064f == null) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f14063e, 6);
                this.f14064f = gridLayoutManager;
                gridLayoutManager.setAutoMeasureEnabled(true);
                this.f14064f.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    public int getSpanSize(int i) {
                        int modelListSize = GroupFormViewNewUI.this.f14065g.getModelListSize();
                        int i2 = modelListSize % (6 / FormViewOptionAdapter.RECYCLER_VIEW_SINGLE_COL_SPANS);
                        if (i < modelListSize - i2 || i2 <= 0) {
                            return FormViewOptionAdapter.RECYCLER_VIEW_SINGLE_COL_SPANS;
                        }
                        return 6 / i2;
                    }
                });
                this.f14062d.setLayoutManager(this.f14064f);
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    GroupFormViewNewUI.this.f14065g.notifyDataSetChanged();
                }
            });
        }
    }

    /* renamed from: a */
    private void m9807a() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f14062d.getLayoutParams();
        layoutParams.setMarginEnd(UIUtils.dip2pxInt(this.f14063e, 30.0f));
        this.f14062d.setLayoutParams(layoutParams);
    }

    public void onDestroy() {
        FormViewOptionAdapter formViewOptionAdapter = this.f14065g;
        if (formViewOptionAdapter != null) {
            formViewOptionAdapter.onDestroy();
        }
    }

    public void setMaxColCount(int i) {
        FormViewOptionAdapter.RECYCLER_VIEW_SINGLE_COL_SPANS = 6 / i;
    }

    public void setVisible(boolean z) {
        this.f14059a.setVisibility(z ? 0 : 8);
    }
}
