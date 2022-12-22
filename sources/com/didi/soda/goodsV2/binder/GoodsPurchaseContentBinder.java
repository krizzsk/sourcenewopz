package com.didi.soda.goodsV2.binder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.goodsV2.model.GoodsPurchaseContentRvModel;
import com.taxis99.R;

public class GoodsPurchaseContentBinder extends ItemBinder<GoodsPurchaseContentRvModel, ViewHolder> {
    public void bind(ViewHolder viewHolder, GoodsPurchaseContentRvModel goodsPurchaseContentRvModel) {
        viewHolder.mContentTitle.setText(goodsPurchaseContentRvModel.mContentName);
        if (goodsPurchaseContentRvModel.mIsObliged) {
            if (goodsPurchaseContentRvModel.mIsSatisfied) {
                viewHolder.mContentIsCompleted.setVisibility(0);
                viewHolder.mObligedText.setVisibility(4);
            } else {
                viewHolder.mContentIsCompleted.setVisibility(4);
                viewHolder.mObligedText.setVisibility(0);
            }
            viewHolder.mRemindContainer.setVisibility(0);
        } else {
            viewHolder.mObligedText.setVisibility(8);
            viewHolder.mContentIsCompleted.setVisibility(8);
            viewHolder.mRemindContainer.setVisibility(8);
        }
        if (!TextUtils.isEmpty(goodsPurchaseContentRvModel.mNumRestrictionTip)) {
            viewHolder.mContentNumRestriction.setVisibility(0);
            viewHolder.mContentNumRestriction.setText(goodsPurchaseContentRvModel.mNumRestrictionTip);
        } else {
            viewHolder.mContentNumRestriction.setVisibility(8);
        }
        m29910a(viewHolder, goodsPurchaseContentRvModel);
    }

    public Class<GoodsPurchaseContentRvModel> bindDataType() {
        return GoodsPurchaseContentRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_goods_purchase_content_v2, viewGroup, false));
    }

    /* renamed from: a */
    private void m29910a(ViewHolder viewHolder, GoodsPurchaseContentRvModel goodsPurchaseContentRvModel) {
        if (goodsPurchaseContentRvModel.mGoodsContentAnimation != GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_NONE) {
            if (goodsPurchaseContentRvModel.mGoodsContentAnimation == GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_REMIND) {
                m29912b(viewHolder, goodsPurchaseContentRvModel.mHasSelectedItems);
            } else if (goodsPurchaseContentRvModel.mGoodsContentAnimation == GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_SATISFIED) {
                m29913c(viewHolder, true);
            } else if (goodsPurchaseContentRvModel.mGoodsContentAnimation == GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_UNSATISFIED) {
                m29913c(viewHolder, false);
            } else if (goodsPurchaseContentRvModel.mGoodsContentAnimation == GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_ITEM_SELECTED) {
                viewHolder.mObligedText.setBackgroundResource(R.drawable.customer_shape_bg_content_obliged_v2);
            } else if (goodsPurchaseContentRvModel.mGoodsContentAnimation == GoodsPurchaseContentRvModel.GoodsContentAnimation.ANIMATION_CHANGE_RED) {
                m29911a(viewHolder, goodsPurchaseContentRvModel.mHasSelectedItems);
            }
            goodsPurchaseContentRvModel.resetAnimationState();
        }
    }

    /* renamed from: a */
    private void m29911a(ViewHolder viewHolder, boolean z) {
        TextView textView = viewHolder.mObligedText;
        TextView textView2 = viewHolder.mContentNumRestriction;
        boolean z2 = true;
        boolean z3 = textView != null && textView.getVisibility() == 0 && !z;
        if (textView2 == null || textView2.getVisibility() != 0 || z3) {
            z2 = false;
        }
        if (z3) {
            textView.setBackgroundResource(R.drawable.customer_shape_bg_content_obliged_remind_v2);
            textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.rf_color_v2_grey1_3_a60));
        }
        if (z2) {
            textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.rf_color_alert_red_100_FF4E45));
            textView.setBackgroundResource(R.drawable.customer_shape_bg_content_obliged_v2);
        }
    }

    /* renamed from: b */
    private void m29912b(ViewHolder viewHolder, boolean z) {
        TextView textView = viewHolder.mObligedText;
        TextView textView2 = viewHolder.mContentNumRestriction;
        boolean z2 = textView != null && textView.getVisibility() == 0 && !z;
        boolean z3 = textView2 != null && textView2.getVisibility() == 0 && !z2;
        if (z2 || z3) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 1.2f});
            final boolean z4 = z2;
            final TextView textView3 = textView;
            final boolean z5 = z3;
            final TextView textView4 = textView2;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (z4) {
                        textView3.setScaleX(floatValue);
                        textView3.setScaleY(floatValue);
                    }
                    if (z5) {
                        textView4.setScaleX(floatValue);
                        textView4.setScaleY(floatValue);
                    }
                }
            });
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.2f, 1.0f});
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (z4) {
                        textView3.setScaleX(floatValue);
                        textView3.setScaleY(floatValue);
                    }
                    if (z5) {
                        textView4.setScaleX(floatValue);
                        textView4.setScaleY(floatValue);
                    }
                }
            });
            ofFloat.setDuration(150);
            ofFloat2.setDuration(200);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat2).after(300).after(ofFloat);
            if (z3) {
                textView2.setPivotX(0.0f);
                textView2.setScaleY(0.0f);
            }
            final boolean z6 = z2;
            final TextView textView5 = textView;
            final TextView textView6 = textView2;
            final boolean z7 = z3;
            animatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (z6) {
                        textView5.setBackgroundResource(R.drawable.customer_shape_bg_content_obliged_remind_v2);
                        TextView textView = textView6;
                        textView.setTextColor(textView.getContext().getResources().getColor(R.color.rf_color_v2_grey1_3_a60));
                    }
                    if (z7) {
                        TextView textView2 = textView6;
                        textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.rf_color_alert_red_100_FF4E45));
                        textView5.setBackgroundResource(R.drawable.customer_shape_bg_content_obliged_v2);
                    }
                }

                public void onAnimationStart(Animator animator) {
                    if (z6) {
                        textView5.setBackgroundResource(R.drawable.customer_shape_bg_content_obliged_remind_v2);
                    }
                    if (z7) {
                        TextView textView = textView6;
                        textView.setTextColor(textView.getContext().getResources().getColor(R.color.rf_color_alert_red_100_FF4E45));
                    }
                }
            });
            animatorSet.setInterpolator(CustomerInterpolator.newInstance());
            animatorSet.start();
        }
    }

    /* renamed from: c */
    private void m29913c(ViewHolder viewHolder, boolean z) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        final TextView textView = viewHolder.mObligedText;
        final TextView textView2 = viewHolder.mContentIsCompleted;
        if (textView != null && textView2 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            if (z) {
                viewHolder.mContentNumRestriction.setTextColor(viewHolder.mContentNumRestriction.getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
                objectAnimator2 = ObjectAnimator.ofFloat(textView2, View.ALPHA, new float[]{0.0f, 1.0f});
                objectAnimator = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{1.0f, 0.0f});
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        textView2.setVisibility(0);
                        textView2.setAlpha(0.0f);
                    }

                    public void onAnimationEnd(Animator animator) {
                        textView.setVisibility(4);
                        textView.setAlpha(1.0f);
                    }
                });
                animatorSet.play(objectAnimator2).after(objectAnimator);
            } else {
                objectAnimator2 = ObjectAnimator.ofFloat(textView2, View.ALPHA, new float[]{1.0f, 0.0f});
                objectAnimator = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{0.0f, 1.0f});
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        textView.setVisibility(0);
                        textView.setAlpha(0.0f);
                    }

                    public void onAnimationEnd(Animator animator) {
                        textView2.setVisibility(4);
                        textView2.setAlpha(1.0f);
                        textView.setBackgroundResource(R.drawable.customer_shape_bg_content_obliged_v2);
                    }
                });
                animatorSet.play(objectAnimator2).before(objectAnimator);
            }
            objectAnimator2.setDuration(100);
            objectAnimator.setDuration(100);
            animatorSet.setInterpolator(CustomerInterpolator.newInstance());
            animatorSet.start();
        }
    }

    static class ViewHolder extends ItemViewHolder<GoodsPurchaseContentRvModel> {
        TextView mContentIsCompleted;
        TextView mContentNumRestriction;
        TextView mContentTitle;
        TextView mObligedText;
        FrameLayout mRemindContainer;

        ViewHolder(View view) {
            super(view);
            this.mContentTitle = (TextView) view.findViewById(R.id.customer_tv_content_title);
            this.mContentNumRestriction = (TextView) view.findViewById(R.id.customer_tv_content_num_restriction);
            this.mObligedText = (TextView) view.findViewById(R.id.customer_tv_content_is_obliged);
            this.mContentIsCompleted = (TextView) view.findViewById(R.id.customer_tv_content_is_completed);
            this.mRemindContainer = (FrameLayout) view.findViewById(R.id.customer_fl_remind_container);
        }
    }
}
