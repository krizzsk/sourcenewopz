package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.hawaii.utils.DisplayUtils;

class BlockBubbleDrawer$1 extends AppCompatImageView {
    final Path path = new Path();
    final float radius = ((float) DisplayUtils.dip2px(getContext(), 4.0f));
    final /* synthetic */ C9320a this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockBubbleDrawer$1(C9320a aVar, Context context) {
        super(context);
        this.this$0 = aVar;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        this.path.reset();
        if (Build.VERSION.SDK_INT >= 21) {
            float f = this.radius;
            this.path.addRoundRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), f, f, Path.Direction.CW);
        } else {
            this.path.addRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), Path.Direction.CW);
        }
        canvas.clipPath(this.path);
        super.draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.save();
        this.path.reset();
        if (Build.VERSION.SDK_INT >= 21) {
            float f = this.radius;
            this.path.addRoundRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getMeasuredWidth() - getPaddingRight()), (float) (getMeasuredHeight() - getPaddingBottom()), f, f, Path.Direction.CW);
        } else {
            this.path.addRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getMeasuredWidth() - getPaddingRight()), (float) (getMeasuredHeight() - getPaddingBottom()), Path.Direction.CW);
        }
        canvas.clipPath(this.path);
        super.onDraw(canvas);
        canvas.restore();
    }
}
