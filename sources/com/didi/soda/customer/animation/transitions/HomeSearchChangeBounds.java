package com.didi.soda.customer.animation.transitions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;

public class HomeSearchChangeBounds extends Transition {

    /* renamed from: a */
    private static final String f40297a = "android:changeBounds:windowX";

    /* renamed from: b */
    private static final String f40298b = "android:changeBounds:windowY";

    /* renamed from: c */
    private static final Property<CustomerImageView, PointF> f40299c = new Property<CustomerImageView, PointF>(PointF.class, "boundsOrigin") {
        public void set(CustomerImageView customerImageView, PointF pointF) {
            customerImageView.layout(Math.round(pointF.x), Math.round(pointF.y), Math.round(pointF.x) + customerImageView.getWidth(), Math.round(pointF.y) + customerImageView.getHeight());
        }

        public PointF get(CustomerImageView customerImageView) {
            return new PointF((float) customerImageView.getLeft(), (float) customerImageView.getTop());
        }
    };

    /* renamed from: d */
    private int[] f40300d = new int[2];

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        final View view = transitionValues2.view;
        viewGroup.getLocationInWindow(this.f40300d);
        int intValue = transitionValues.values.get(f40297a) != null ? ((Integer) transitionValues.values.get(f40297a)).intValue() - this.f40300d[0] : 0;
        int intValue2 = transitionValues.values.get(f40298b) != null ? ((Integer) transitionValues.values.get(f40298b)).intValue() - this.f40300d[0] : 0;
        int intValue3 = transitionValues2.values.get(f40297a) != null ? ((Integer) transitionValues2.values.get(f40297a)).intValue() - this.f40300d[0] : 0;
        int intValue4 = transitionValues2.values.get(f40298b) != null ? ((Integer) transitionValues2.values.get(f40298b)).intValue() - this.f40300d[0] : 0;
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        int width = transitionValues.view.getWidth();
        int height = transitionValues.view.getHeight();
        int width2 = transitionValues2.view.getWidth();
        CustomerImageView customerImageView = new CustomerImageView(view.getContext(), transitionValues2.view);
        customerImageView.layout(intValue, intValue2, intValue + width, height + intValue2);
        viewGroup.getOverlay().add(customerImageView);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(customerImageView, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(f40299c, (TypeConverter) null, getPathMotion().getPath((float) intValue, (float) intValue2, (float) intValue3, (float) intValue4))});
        final ViewGroup viewGroup2 = viewGroup;
        final CustomerImageView customerImageView2 = customerImageView;
        final TransitionValues transitionValues3 = transitionValues;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup2.getOverlay().remove(customerImageView2);
                view.setAlpha(1.0f);
                transitionValues3.view.setAlpha(1.0f);
            }

            public void onAnimationStart(Animator animator) {
                view.setAlpha(0.0f);
                transitionValues3.view.setAlpha(0.0f);
            }
        });
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(width, width2, customerImageView) {
            public final /* synthetic */ int f$0;
            public final /* synthetic */ int f$1;
            public final /* synthetic */ View f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$2.layout(this.f$2.getLeft(), this.f$2.getTop(), this.f$2.getLeft() + ((int) (((float) this.f$0) - (((float) (this.f$0 - this.f$1)) * valueAnimator.getAnimatedFraction()))), this.f$2.getBottom());
            }
        });
        return ofPropertyValuesHolder;
    }

    public void captureStartValues(TransitionValues transitionValues) {
        m28571a(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        m28571a(transitionValues);
    }

    /* renamed from: a */
    private void m28571a(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.view.getLocationInWindow(this.f40300d);
            transitionValues.values.put(f40297a, Integer.valueOf(this.f40300d[0]));
            transitionValues.values.put(f40298b, Integer.valueOf(this.f40300d[1]));
        }
    }

    private static class CustomerImageView extends CustomerAppCompatImageView {
        public CustomerImageView(Context context, View view) {
            super(context);
            setImageDrawable(createBitMapDrawable(view));
            setScaleType(ImageView.ScaleType.FIT_XY);
            layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }

        private BitmapDrawable createBitMapDrawable(View view) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            view.draw(canvas);
            return bitmapDrawable;
        }
    }
}
