package com.didi.soda.customer.biz.popdialog.natived.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.image.ImageRequestListener;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.biz.popdialog.natived.PopCouponDataHelper;
import com.didi.soda.customer.biz.popdialog.natived.binder.NAPopCouponBinder;
import com.didi.soda.customer.biz.popdialog.natived.model.NAPopCouponRvModel;
import com.didi.soda.customer.foundation.imageloader.ClipBottomTransformation;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.CouponEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CouponPopDialogView extends Contract.AbsPopDialogView {

    /* renamed from: a */
    private static final String f40504a = "CouponPopDialogView";

    /* renamed from: b */
    private NovaRecyclerAdapter f40505b;

    /* renamed from: c */
    private ChildDataListManager<RecyclerModel> f40506c;

    /* renamed from: d */
    private NAPopCouponBinder f40507d;
    @BindView(17852)
    ConstraintLayout mCouponContent;
    @BindView(18520)
    LinearLayout mCouponParent;
    @BindView(19088)
    RFMainButton mPopBtn;
    @BindView(18457)
    ImageView mPopClose;
    @BindView(18458)
    ImageView mPopImage;
    @BindView(18583)
    NovaRecyclerView mPopListView;
    @BindView(18558)
    View mRootView;

    public void updatePopDialog(final NAPopDialogEntity nAPopDialogEntity) {
        LogUtil.m29104i(f40504a, "updatePopDialog");
        if (getContext() != null) {
            this.mRootView.setVisibility(4);
            FlyImageLoader.ImageRequestWrapper diskCacheStrategy = FlyImageLoader.loadImageUnspecified(getScopeContext(), nAPopDialogEntity.info.skinUrl).diskCacheStrategy(FlyImageLoader.DATA);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.customer_662px);
            if (DisplayUtils.getScreenWidth(getContext()) - dimensionPixelOffset < DisplayUtils.dip2px(getContext(), 32.0f) * 2) {
                dimensionPixelOffset = DisplayUtils.getScreenWidth(getContext()) - (DisplayUtils.dip2px(getContext(), 32.0f) * 2);
            }
            if (m28742a()) {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.customer_580px);
                this.mCouponParent.setPadding(0, getResources().getDimensionPixelOffset(R.dimen.customer_192px), 0, 0);
            } else {
                this.mCouponParent.setPadding(0, getResources().getDimensionPixelOffset(R.dimen.customer_228px), 0, 0);
            }
            this.mCouponContent.getLayoutParams().width = dimensionPixelOffset;
            m28741a(nAPopDialogEntity);
            diskCacheStrategy.transform(new ClipBottomTransformation(getContext(), dimensionPixelOffset, m28744c(nAPopDialogEntity), DisplayUtils.dip2px(getContext(), 5.0f))).dontAnimate().listener(new ImageRequestListener() {
                public boolean onException(Exception exc, boolean z) {
                    String str;
                    if (exc != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(exc.getMessage());
                        sb.append(",getCause = ");
                        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "null");
                        str = sb.toString();
                        LogUtil.m29104i(CouponPopDialogView.f40504a, "down load image fail = " + str);
                    } else {
                        str = "";
                    }
                    ((Contract.AbsPopDialogPresenter) CouponPopDialogView.this.getPresenter()).onDownloadPicFail(str);
                    CouponPopDialogView.this.mRootView.setVisibility(8);
                    return false;
                }

                public boolean onResourceReady(Object obj, boolean z, boolean z2) {
                    LogUtil.m29104i(CouponPopDialogView.f40504a, "download onSuccess");
                    ((Contract.AbsPopDialogPresenter) CouponPopDialogView.this.getPresenter()).onDownloadPicSucess();
                    CouponPopDialogView.this.m28743b(nAPopDialogEntity);
                    ((Contract.AbsPopDialogPresenter) CouponPopDialogView.this.getPresenter()).onPopDialogShow();
                    return false;
                }
            }).into(this.mPopImage);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View getContentView() {
        return this.mCouponContent;
    }

    public View getClosedView() {
        return this.mPopClose;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mPopClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsPopDialogPresenter) CouponPopDialogView.this.getPresenter()).onCloseBtnClick();
            }
        });
        this.mPopImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsPopDialogPresenter) CouponPopDialogView.this.getPresenter()).onImageClick();
            }
        });
        this.mPopBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsPopDialogPresenter) CouponPopDialogView.this.getPresenter()).onBtnClick();
            }
        });
        this.f40505b = new NovaRecyclerAdapter();
        this.mPopListView.setLayoutManager(new NovaLinearLayoutManager(getContext()));
        this.mPopListView.setAdapter(this.f40505b);
        NAPopCouponBinder nAPopCouponBinder = new NAPopCouponBinder(new Contract.NaPopBinderActionListener() {
            public void onOperationClickAction(String str, int i) {
                ((Contract.AbsPopDialogPresenter) CouponPopDialogView.this.getPresenter()).onOperationClick(str, i);
            }

            public void onBindAction(String str, int i, String str2, int i2) {
                ((Contract.AbsPopDialogPresenter) CouponPopDialogView.this.getPresenter()).onBindAction(str, i, str2, i2);
            }
        });
        this.f40507d = nAPopCouponBinder;
        this.f40505b.registerBinder(nAPopCouponBinder);
        ChildDataListManager<RecyclerModel> childDataListManager = new ChildDataListManager<>(this.f40505b);
        this.f40506c = childDataListManager;
        this.f40505b.addDataManager(childDataListManager);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_dialog_coupon_pop, viewGroup, true);
    }

    /* renamed from: a */
    private void m28741a(NAPopDialogEntity nAPopDialogEntity) {
        if (nAPopDialogEntity != null && nAPopDialogEntity.info != null) {
            this.mPopListView.setVisibility(4);
            this.mPopBtn.setVisibility(4);
            if (TextUtils.isEmpty(nAPopDialogEntity.info.btnText)) {
                this.mPopBtn.setVisibility(8);
            } else {
                this.mPopBtn.setVisibility(4);
            }
            this.f40507d.setCouponStyle(nAPopDialogEntity.info.couponStyle);
            if (!CollectionsUtil.isEmpty(nAPopDialogEntity.info.couponList)) {
                if (nAPopDialogEntity.info.couponList.size() >= 3) {
                    ViewGroup.LayoutParams layoutParams = this.mPopListView.getLayoutParams();
                    layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.customer_568px);
                    this.mPopListView.setLayoutParams(layoutParams);
                }
                this.f40506c.addAll(m28739a(nAPopDialogEntity.info.couponList));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28743b(NAPopDialogEntity nAPopDialogEntity) {
        if (nAPopDialogEntity != null && nAPopDialogEntity.info != null) {
            this.mPopListView.setVisibility(0);
            if (TextUtils.isEmpty(nAPopDialogEntity.info.btnText)) {
                this.mPopBtn.setVisibility(8);
            } else {
                this.mPopBtn.setVisibility(0);
                this.mPopBtn.setText(nAPopDialogEntity.info.btnText);
            }
            this.mRootView.setBackgroundColor(getResources().getColor(R.color.rf_color_gery_12_0_7F000000));
            this.mRootView.setClickable(true);
            this.mPopClose.setVisibility(0);
            showPopDialog(nAPopDialogEntity);
        }
    }

    /* renamed from: a */
    private List<NAPopCouponRvModel> m28739a(List<CouponEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                CouponEntity couponEntity = list.get(i);
                if (couponEntity != null) {
                    arrayList.add(PopCouponDataHelper.parseNAPopCouponRvModel(couponEntity));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private int m28744c(NAPopDialogEntity nAPopDialogEntity) {
        if (m28742a() || nAPopDialogEntity == null || nAPopDialogEntity.info == null || CollectionsUtil.isEmpty(nAPopDialogEntity.info.couponList)) {
            return getResources().getDimensionPixelOffset(R.dimen.customer_880px);
        }
        int size = nAPopDialogEntity.info.couponList.size();
        if (size == 1) {
            return m28745d(nAPopDialogEntity);
        }
        if (size == 2) {
            return m28746e(nAPopDialogEntity);
        }
        return m28747f(nAPopDialogEntity);
    }

    /* renamed from: a */
    private boolean m28742a() {
        return DisplayUtils.getScreenWidth(getContext()) <= DisplayUtils.dip2px(getContext(), 320.0f);
    }

    /* renamed from: d */
    private int m28745d(NAPopDialogEntity nAPopDialogEntity) {
        if (TextUtils.isEmpty(nAPopDialogEntity.info.btnText)) {
            return getResources().getDimensionPixelOffset(R.dimen.customer_432px);
        }
        return getResources().getDimensionPixelOffset(R.dimen.customer_524px);
    }

    /* renamed from: e */
    private int m28746e(NAPopDialogEntity nAPopDialogEntity) {
        if (TextUtils.isEmpty(nAPopDialogEntity.info.btnText)) {
            return getResources().getDimensionPixelOffset(R.dimen.customer_628px);
        }
        return getResources().getDimensionPixelOffset(R.dimen.customer_720px);
    }

    /* renamed from: f */
    private int m28747f(NAPopDialogEntity nAPopDialogEntity) {
        if (TextUtils.isEmpty(nAPopDialogEntity.info.btnText)) {
            return getResources().getDimensionPixelOffset(R.dimen.customer_824px);
        }
        return getResources().getDimensionPixelOffset(R.dimen.customer_916px);
    }
}
