package global.didi.pay.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.didi.passenger.C10448R;
import com.didi.unifiedPay.component.widget.loading.CircularProgressDrawable;
import com.taxis99.R;

public class GlobalPayLoadingDialog extends ProgressBar {
    Drawable indeterminateDrawable;

    public GlobalPayLoadingDialog(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalPayLoadingDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cpbStyle);
    }

    public GlobalPayLoadingDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            setIndeterminateDrawable(new CircularProgressDrawable.Builder(context, true).build());
            return;
        }
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CircularProgressBar, i, 0);
        int color = obtainStyledAttributes.getColor(2, resources.getColor(R.color.oc_color_ff5e1f));
        float dimension = obtainStyledAttributes.getDimension(7, resources.getDimension(R.dimen.cpb_default_stroke_width));
        float f = obtainStyledAttributes.getFloat(8, Float.parseFloat(resources.getString(R.string.cpb_default_sweep_speed)));
        float f2 = obtainStyledAttributes.getFloat(6, Float.parseFloat(resources.getString(R.string.cpb_default_rotation_speed)));
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        int color2 = obtainStyledAttributes.getColor(1, resources.getColor(R.color.white));
        int integer = obtainStyledAttributes.getInteger(5, resources.getInteger(R.integer.cpb_default_min_sweep_angle));
        int integer2 = obtainStyledAttributes.getInteger(4, resources.getInteger(R.integer.cpb_default_max_sweep_angle));
        obtainStyledAttributes.recycle();
        int[] intArray = resourceId != 0 ? resources.getIntArray(resourceId) : null;
        CircularProgressDrawable.Builder backGroundColor = new CircularProgressDrawable.Builder(context).sweepSpeed(f).rotationSpeed(f2).strokeWidth(dimension).minSweepAngle(integer).maxSweepAngle(integer2).backGroundColor(color2);
        if (intArray == null || intArray.length <= 0) {
            backGroundColor.color(color);
        } else {
            backGroundColor.colors(intArray);
        }
        CircularProgressDrawable build = backGroundColor.build();
        this.indeterminateDrawable = build;
        setIndeterminateDrawable(build);
        setIndeterminate(true);
    }

    public void changeToSuccess() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.dialog_icon_success);
        if (checkIndeterminateDrawable() != null) {
            checkIndeterminateDrawable().changeToSuccess(decodeResource);
        }
    }

    public void changeToLoading() {
        if (checkIndeterminateDrawable() != null) {
            checkIndeterminateDrawable().changeToLoading();
        }
    }

    private CircularProgressDrawable checkIndeterminateDrawable() {
        Drawable indeterminateDrawable2 = getIndeterminateDrawable();
        if (indeterminateDrawable2 == null || !(indeterminateDrawable2 instanceof CircularProgressDrawable)) {
            return null;
        }
        return (CircularProgressDrawable) indeterminateDrawable2;
    }

    public void progressiveStop() {
        if (checkIndeterminateDrawable() != null) {
            checkIndeterminateDrawable().progressiveStop();
        }
    }

    public void progressiveStop(CircularProgressDrawable.OnEndListener onEndListener) {
        if (checkIndeterminateDrawable() != null) {
            checkIndeterminateDrawable().progressiveStop(onEndListener);
        }
    }
}
