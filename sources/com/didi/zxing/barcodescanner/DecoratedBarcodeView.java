package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.MultiFormatReader;
import com.didi.dqr.ResultPoint;
import com.didi.passenger.C10448R;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.didi.zxing.barcodescanner.camera.CameraManager;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.didi.zxing.client.DecodeFormatManager;
import com.didi.zxing.client.DecodeHintManager;
import com.didi.zxing.client.Intents;
import com.taxis99.R;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DecoratedBarcodeView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public BarcodeView f45277a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewfinderView f45278b;

    /* renamed from: c */
    private TextView f45279c;

    /* renamed from: d */
    private boolean f45280d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TorchListener f45281e;

    /* renamed from: f */
    private boolean f45282f;

    public interface TorchListener {
        void onTorchOff();

        void onTorchOn();
    }

    private class WrappedCallback implements BarcodeCallback {
        private BarcodeCallback delegate;

        public WrappedCallback(BarcodeCallback barcodeCallback) {
            this.delegate = barcodeCallback;
        }

        public void barcodeResult(BarcodeResult barcodeResult) {
            this.delegate.barcodeResult(barcodeResult);
        }

        public void possibleResultPoints(List<ResultPoint> list) {
            for (ResultPoint addPossibleResultPoint : list) {
                DecoratedBarcodeView.this.f45278b.addPossibleResultPoint(addPossibleResultPoint);
            }
            this.delegate.possibleResultPoints(list);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        m32517a();
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32518a(attributeSet);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32518a(attributeSet);
    }

    /* renamed from: a */
    private void m32518a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.zxing_view);
        if (obtainStyledAttributes.getInteger(1, 2) == 2) {
            this.f45280d = true;
        } else {
            this.f45280d = false;
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, R.layout.zxing_default_barcode_scanner);
        obtainStyledAttributes.recycle();
        inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R.id.zxing_barcode_surface);
        this.f45277a = barcodeView;
        if (barcodeView != null) {
            barcodeView.initializeAttributes(attributeSet);
            ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
            this.f45278b = viewfinderView;
            if (viewfinderView != null) {
                viewfinderView.setCameraPreview(this.f45277a);
                this.f45279c = (TextView) findViewById(R.id.zxing_status_view);
                DecodeConfig config = DecodeConfigUtil.getConfig();
                if (config != null && config.cropRect()) {
                    this.f45278b.setOnPreviewGet(new ViewfinderView.OnPreviewGet() {
                        public void onPreviewGet(Rect rect) {
                            if (DecoratedBarcodeView.this.f45278b != null && DecoratedBarcodeView.this.f45278b.getVisibility() == 0 && DecoratedBarcodeView.this.f45277a != null) {
                                DecoratedBarcodeView.this.f45277a.setCropRect(rect);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("There is no a ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        throw new IllegalArgumentException("There is no a BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
    }

    /* renamed from: a */
    private void m32517a() {
        m32518a((AttributeSet) null);
    }

    public void initializeFromIntent(Intent intent) {
        int intExtra;
        Set<BarcodeFormat> parseDecodeFormats = DecodeFormatManager.parseDecodeFormats(intent);
        Map<DecodeHintType, Object> parseDecodeHints = DecodeHintManager.parseDecodeHints(intent);
        CameraSettings cameraSettings = new CameraSettings();
        if (intent.hasExtra(Intents.Scan.CAMERA_ID) && (intExtra = intent.getIntExtra(Intents.Scan.CAMERA_ID, -1)) >= 0) {
            cameraSettings.setRequestedCameraId(intExtra);
        }
        String stringExtra = intent.getStringExtra(Intents.Scan.PROMPT_MESSAGE);
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        boolean booleanExtra = intent.getBooleanExtra(Intents.Scan.INVERTED_SCAN, false);
        String stringExtra2 = intent.getStringExtra(Intents.Scan.CHARACTER_SET);
        new MultiFormatReader().setHints(parseDecodeHints);
        this.f45277a.setCameraSettings(cameraSettings);
        this.f45277a.setDecoderFactory(new DefaultDecoderFactory(parseDecodeFormats, parseDecodeHints, stringExtra2, booleanExtra));
    }

    public void setStatusText(String str) {
        TextView textView = this.f45279c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void addStateListener(CameraPreview.StateListener stateListener) {
        this.f45277a.addStateListener(stateListener);
    }

    public void pause() {
        this.f45277a.pause();
    }

    public void pauseAndHoldCamera() {
        BarcodeView barcodeView = this.f45277a;
        if (barcodeView != null) {
            barcodeView.pauseAndHoldCamera();
        }
    }

    public void destroy() {
        this.f45277a.destroy();
    }

    public void pauseAndWait() {
        this.f45277a.pauseAndWait();
    }

    public void resume() {
        this.f45277a.resume();
        if (this.f45277a.getCameraInstance() != null) {
            this.f45277a.getCameraInstance().setTorchListener(new CameraManager.TorchListener() {
                public void onTorchOn() {
                    DecoratedBarcodeView.this.post(new Runnable() {
                        public void run() {
                            if (DecoratedBarcodeView.this.f45281e != null) {
                                DecoratedBarcodeView.this.f45281e.onTorchOn();
                            }
                        }
                    });
                }

                public void onTorchOff() {
                    DecoratedBarcodeView.this.post(new Runnable() {
                        public void run() {
                            if (DecoratedBarcodeView.this.f45281e != null) {
                                DecoratedBarcodeView.this.f45281e.onTorchOff();
                            }
                        }
                    });
                }
            });
        }
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R.id.zxing_barcode_surface);
    }

    public ViewfinderView getViewFinder() {
        return this.f45278b;
    }

    public TextView getStatusView() {
        return this.f45279c;
    }

    public void decodeSingle(BarcodeCallback barcodeCallback) {
        this.f45277a.decodeSingle(m32515a(barcodeCallback));
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.f45277a.decodeContinuous(m32515a(barcodeCallback));
    }

    /* renamed from: a */
    private BarcodeCallback m32515a(BarcodeCallback barcodeCallback) {
        return this.f45280d ? new WrappedCallback(barcodeCallback) : barcodeCallback;
    }

    public void setTorchOn() {
        this.f45277a.setTorch(true);
    }

    public void setTorchOff() {
        this.f45277a.setTorch(false);
        this.f45282f = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            setTorchOn();
            return true;
        } else if (i == 25) {
            setTorchOff();
            return true;
        } else if (i == 27 || i == 80) {
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public void setTorchListener(TorchListener torchListener) {
        this.f45281e = torchListener;
    }

    public void setProductId(String str) {
        BarcodeView barcodeView = this.f45277a;
        if (barcodeView != null) {
            barcodeView.setProductId(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo113584a(boolean z) {
        if (!this.f45282f) {
            this.f45277a.setTorch(z);
        }
    }
}
