package com.didi.soda.address.component.feed.binder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.view.View;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.soda.address.component.feed.binder.AddressAnimUtil;
import com.didi.soda.address.component.feed.binder.DeliveryAddressBinder;
import com.didi.soda.address.manager.AddressMessageRepo;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.AppConfigUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.repo.RepoFactory;

public final class AddressAnimUtil {

    /* renamed from: a */
    private static final String f38673a = "DeliveryAddressBinder";

    public interface Callback {
        void onSaveState(int i);
    }

    private AddressAnimUtil() {
    }

    public static void showEditGuideAnim(View view, View view2) {
        if (!AppConfigUtil.isGuideAnimShowed() && !((AddressMessageRepo) RepoFactory.getRepo(AddressMessageRepo.class)).isAddressGuideAnimStart()) {
            ((AddressMessageRepo) RepoFactory.getRepo(AddressMessageRepo.class)).setAddressGuideAnimMessage(AddressMessageRepo.AddressAnimStatus.ANIM_START);
            UiHandlerUtil.post(new Runnable(view) {
                public final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AddressAnimUtil.m27396a(View.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m27396a(View view, final View view2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, view.getWidth(), 0});
        ofInt.setDuration(1200);
        Path path = new Path();
        path.cubicTo(0.0625f, 0.025f, 0.0625f, 0.25f, 0.25f, 0.5f);
        path.lineTo(0.75f, 0.5f);
        path.cubicTo(0.8125f, 0.525f, 0.8125f, 0.75f, 1.0f, 1.0f);
        ofInt.setInterpolator(PathInterpolatorCompat.create(path));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                View.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ((AddressMessageRepo) RepoFactory.getRepo(AddressMessageRepo.class)).setAddressGuideAnimMessage(AddressMessageRepo.AddressAnimStatus.ANIM_END);
            }
        });
        ofInt.start();
    }

    public static ValueAnimator getRecoverAnimator(View view, int i, final int i2, int i3, final Callback callback) {
        int scrollX = view.getScrollX();
        int i4 = i2 == 1 ? i3 : 0;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{scrollX, i4});
        if (i3 == 0) {
            ofInt.setDuration(0);
        } else {
            ofInt.setDuration((long) ((Math.abs(i4 - scrollX) * i) / i3));
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(callback, i2) {
            public final /* synthetic */ AddressAnimUtil.Callback f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AddressAnimUtil.m27397a(View.this, this.f$1, this.f$2, valueAnimator);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            boolean mIsCancel;

            public void onAnimationCancel(Animator animator) {
                this.mIsCancel = true;
            }

            public void onAnimationEnd(Animator animator) {
                Callback callback;
                LogUtil.m29100d(AddressAnimUtil.f38673a, "onAnimationEnd" + this.mIsCancel);
                if (!this.mIsCancel && (callback = Callback.this) != null) {
                    callback.onSaveState(i2);
                }
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m27397a(View view, Callback callback, int i, ValueAnimator valueAnimator) {
        if (!view.isShown()) {
            LogUtil.m29100d(f38673a, "UpdateAnim" + view.isShown());
            if (callback != null) {
                callback.onSaveState(i);
            }
        }
        view.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }

    public static void resetMoveStatus(DeliveryAddressBinder.ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel) {
        LogUtil.m29100d(f38673a, "resetMoveStatus " + ((DeliveryAddressRvModel) viewHolder.getItem()).mDragStatus);
        viewHolder.cancelAnimation();
        int i = ((DeliveryAddressRvModel) viewHolder.getItem()).mDragStatus;
        if (i == 0) {
            viewHolder.itemView.scrollTo(0, 0);
        } else if (i == 1) {
            viewHolder.itemView.scrollTo(viewHolder.getMaxMoveX(), 0);
            m27398a(deliveryAddressRvModel);
        }
    }

    /* renamed from: a */
    private static void m27398a(DeliveryAddressRvModel deliveryAddressRvModel) {
        if (AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            if (deliveryAddressRvModel.isEditable()) {
                AddressOmegaHelper.trackAddressEditSw(deliveryAddressRvModel.mAddress.poi.poiId, deliveryAddressRvModel.mAddress.aid, deliveryAddressRvModel.addressType);
            }
            if (deliveryAddressRvModel.isDeletable()) {
                AddressOmegaHelper.trackAddressDeleteSw(deliveryAddressRvModel.mAddress.poi.poiId, deliveryAddressRvModel.mAddress.aid, deliveryAddressRvModel.addressType);
            }
        }
    }
}
