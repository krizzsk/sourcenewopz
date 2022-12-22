package com.didi.soda.customer.biz.popdialog.natived.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import butterknife.BindView;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.ImageDownloadListener;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.foundation.imageloader.ClipBottomTransformation;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;
import java.io.File;

public class PromoCodePopDialogView extends Contract.AbsPopDialogView {

    /* renamed from: a */
    private static final String f40515a = "PromoCodePopDialogView";

    /* renamed from: b */
    private AnimatorSet f40516b = new AnimatorSet();
    @BindView(17862)
    ConstraintLayout mExchangingParent;
    @BindView(17974)
    Group mGroupExchangeResult;
    @BindView(17975)
    Group mGroupExchanging;
    @BindView(18027)
    Group mGroupPromoCode;
    @BindView(17995)
    LottieLoadingView mLoading;
    @BindView(18434)
    ImageView mMessageBack;
    @BindView(19031)
    TextView mMessageExchanging;
    @BindView(18436)
    ImageView mMessageFront;
    @BindView(18433)
    ImageView mMessagePage;
    @BindView(17863)
    ConstraintLayout mMessageParent;
    @BindView(19030)
    TextView mMessageResultBtn;
    @BindView(19035)
    TextView mMessageTitle;
    @BindView(18457)
    ImageView mPopClose;
    @BindView(18652)
    RelativeLayout mPopContent;
    @BindView(18458)
    ImageView mPopImage;
    @BindView(19032)
    TextView mPromoCode;
    @BindView(17876)
    ConstraintLayout mPromocodeParent;
    @BindView(19033)
    TextView mResultContent;
    @BindView(18437)
    ImageView mResultIcon;
    @BindView(19034)
    TextView mResultTitle;
    @BindView(18558)
    View mRootView;

    public void updatePopDialog(final NAPopDialogEntity nAPopDialogEntity) {
        LogUtil.m29104i(f40515a, "updatePopDialog");
        FlyImageLoader.loadImageDownLoadOnly(getScopeContext(), FitType.FIT_None, nAPopDialogEntity.info.imgUrl).transform(new ClipBottomTransformation(getContext(), getResources().getDimensionPixelOffset(R.dimen.customer_580px), getResources().getDimensionPixelOffset(R.dimen.customer_774px), DisplayUtils.dip2px(getContext(), 5.0f))).downloadOnly(new ImageDownloadListener() {
            public void onFailure(Exception exc) {
                String str;
                if (exc != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(exc.getMessage());
                    sb.append(",getCause = ");
                    sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "null");
                    str = sb.toString();
                    LogUtil.m29104i(PromoCodePopDialogView.f40515a, "down load image fail = " + str);
                } else {
                    str = "";
                }
                ((Contract.AbsPopDialogPresenter) PromoCodePopDialogView.this.getPresenter()).onDownloadPicFail(str);
            }

            public void onSuccess(File file) {
                Bitmap convertFileToBitmap = BitmapUtil.convertFileToBitmap(file);
                if (convertFileToBitmap == null) {
                    LogUtil.m29104i(PromoCodePopDialogView.f40515a, "convert file to bitmap fail");
                    ((Contract.AbsPopDialogPresenter) PromoCodePopDialogView.this.getPresenter()).onDownloadPicFail("convert file to bitmap fail");
                    return;
                }
                PromoCodePopDialogView.this.showPopDialog(nAPopDialogEntity);
                LogUtil.m29104i(PromoCodePopDialogView.f40515a, "download onSuccess");
                ((Contract.AbsPopDialogPresenter) PromoCodePopDialogView.this.getPresenter()).onDownloadPicSucess();
                PromoCodePopDialogView.this.mPopImage.setImageBitmap(convertFileToBitmap);
                ((Contract.AbsPopDialogPresenter) PromoCodePopDialogView.this.getPresenter()).onPopDialogShow();
            }
        });
    }

    public void goExchange(final NAPopDialogEntity nAPopDialogEntity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mPopImage, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 0.2f) {
                    PromoCodePopDialogView.this.mPromocodeParent.setVisibility(0);
                    if (!TextUtils.isEmpty(nAPopDialogEntity.info.promoCode)) {
                        PromoCodePopDialogView.this.mPromoCode.setText(nAPopDialogEntity.info.promoCode);
                    }
                    PromoCodePopDialogView.this.mMessageExchanging.setText(PromoCodePopDialogView.this.getResources().getString(R.string.customer_pop_exchanging));
                    PromoCodePopDialogView.this.mMessageTitle.setText(PromoCodePopDialogView.this.getResources().getString(R.string.customer_pop_exchange_coupon));
                }
                if (floatValue <= 0.0f) {
                    PromoCodePopDialogView.this.mPopImage.setVisibility(4);
                }
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mMessageFront, View.TRANSLATION_Y, new float[]{500.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mMessageBack, View.TRANSLATION_Y, new float[]{500.0f, 0.0f});
        ofFloat2.setStartDelay(200);
        ofFloat2.setDuration(300);
        ofFloat3.setStartDelay(200);
        ofFloat3.setDuration(300);
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PromoCodePopDialogView.this.mExchangingParent.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(PromoCodePopDialogView.this.mExchangingParent, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat.setDuration(200);
                ofFloat.start();
            }
        });
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mMessageBack, View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mMessageFront, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat4.setDuration(300);
        ofFloat4.setStartDelay(200);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mMessageParent, View.TRANSLATION_Y, new float[]{400.0f, 0.0f});
        ofFloat6.setDuration(300);
        ofFloat6.setStartDelay(350);
        ofFloat6.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PromoCodePopDialogView.this.mMessageParent.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.mMessageParent, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat7.setDuration(300);
        ofFloat7.setStartDelay(350);
        this.f40516b.play(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat);
        this.f40516b.start();
    }

    public void exchangeResult(final int i, final String str) {
        AnimatorSet animatorSet = this.f40516b;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f40516b.end();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mMessageFront, View.TRANSLATION_Y, new float[]{0.0f, 100.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mMessageBack, View.TRANSLATION_Y, new float[]{0.0f, 100.0f, 0.0f});
        ofFloat.setDuration(500);
        ofFloat2.setDuration(500);
        final ViewGroup.LayoutParams layoutParams = this.mPromocodeParent.getLayoutParams();
        final int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.customer_490px);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                layoutParams.height = (int) (((float) dimensionPixelOffset) + (floatValue * 2.0f));
                PromoCodePopDialogView.this.mPromocodeParent.setLayoutParams(layoutParams);
            }
        });
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mExchangingParent, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat3.setDuration(250);
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PromoCodePopDialogView.this.mGroupPromoCode.setVisibility(8);
                PromoCodePopDialogView.this.mGroupExchanging.setVisibility(8);
                PromoCodePopDialogView.this.mGroupExchangeResult.setVisibility(0);
                if (i == 0) {
                    PromoCodePopDialogView.this.mMessageResultBtn.setText(PromoCodePopDialogView.this.getResources().getString(R.string.customer_pop_exchange_success_btn));
                    PromoCodePopDialogView.this.mResultIcon.setBackground(PromoCodePopDialogView.this.getDrawable(R.drawable.customer_message_tip_succes));
                    PromoCodePopDialogView.this.mResultTitle.setText(PromoCodePopDialogView.this.getResources().getString(R.string.customer_pop_exchange_coupon_success_title));
                    PromoCodePopDialogView.this.mMessagePage.setBackground(PromoCodePopDialogView.this.getResources().getDrawable(R.drawable.customer_message_success));
                } else {
                    PromoCodePopDialogView.this.mResultIcon.setBackground(PromoCodePopDialogView.this.getDrawable(R.drawable.customer_message_tip_fail));
                    PromoCodePopDialogView.this.mResultTitle.setText(PromoCodePopDialogView.this.getResources().getString(R.string.customer_pop_exchange_coupon_fail_title));
                    PromoCodePopDialogView.this.mMessagePage.setBackground(PromoCodePopDialogView.this.getResources().getDrawable(R.drawable.customer_message_normal));
                    if (i == -1) {
                        PromoCodePopDialogView.this.mMessageResultBtn.setText(PromoCodePopDialogView.this.getResources().getString(R.string.customer_try_again));
                    } else {
                        PromoCodePopDialogView.this.mMessageResultBtn.setText(PromoCodePopDialogView.this.getResources().getString(R.string.customer_i_know));
                    }
                }
                PromoCodePopDialogView.this.mResultContent.setText(str);
                PromoCodePopDialogView.this.mMessageResultBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ((Contract.AbsPopDialogPresenter) PromoCodePopDialogView.this.getPresenter()).onBtnClick();
                    }
                });
            }
        });
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mMessageParent, View.TRANSLATION_Y, new float[]{0.0f, 650.0f, 0.0f});
        ofFloat4.setDuration(500);
        animatorSet2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PromoCodePopDialogView.this.mMessageResultBtn.setVisibility(0);
                ObjectAnimator.ofFloat(PromoCodePopDialogView.this.mMessageResultBtn, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(300);
            }
        });
        animatorSet2.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet2.start();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View getContentView() {
        return this.mPopContent;
    }

    public View getClosedView() {
        return this.mPopClose;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mPopClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsPopDialogPresenter) PromoCodePopDialogView.this.getPresenter()).onCloseBtnClick();
            }
        });
        this.mPopImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsPopDialogPresenter) PromoCodePopDialogView.this.getPresenter()).onImageClick();
            }
        });
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mMessageTitle, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPromoCode, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mResultTitle, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mMessageResultBtn, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mMessageExchanging, IToolsService.FontType.MEDIUM);
        this.mMessageResultBtn.setTextColor(SkinUtil.getUponBrandPrimaryTextColor());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_dialog_promo_code_pop, viewGroup, true);
    }
}
