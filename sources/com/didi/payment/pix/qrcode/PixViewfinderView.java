package com.didi.payment.pix.qrcode;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.WindowManager;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.ViewfinderView;

class PixViewfinderView extends ViewfinderView {
    public PixViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.finderWidth = ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getWidth();
        this.finderHeight = this.finderWidth;
    }

    public void setCameraPreview(CameraPreview cameraPreview) {
        super.setCameraPreview(cameraPreview);
    }

    public void onDraw(Canvas canvas) {
        this.outerRoundCorner = null;
        this.mask = null;
        super.onDraw(canvas);
    }
}
