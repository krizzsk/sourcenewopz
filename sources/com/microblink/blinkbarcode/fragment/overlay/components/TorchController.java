package com.microblink.blinkbarcode.fragment.overlay.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.microblink.blinkbarcode.fragment.overlay.verification.OverlayTorchStateListener;
import com.microblink.blinkbarcode.hardware.SuccessCallback;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;

/* compiled from: line */
public class TorchController {
    private RecognizerRunnerView IlIllIlIIl;
    /* access modifiers changed from: private */
    public boolean IllIIIIllI;
    /* access modifiers changed from: private */
    public Drawable IllIIIllII;
    /* access modifiers changed from: private */
    public OverlayTorchStateListener lIlIIIIlIl;
    /* access modifiers changed from: private */
    public Drawable llIIIlllll;
    /* access modifiers changed from: private */
    public ImageView llIIlIlIIl;

    public void onTorchSupportStatusAvailable() {
        RecognizerRunnerView recognizerRunnerView = this.IlIllIlIIl;
        if (recognizerRunnerView != null) {
            boolean z = this.IllIIIIllI;
            this.IllIIIIllI = false;
            boolean isCameraTorchSupported = recognizerRunnerView.isCameraTorchSupported();
            ImageView imageView = this.llIIlIlIIl;
            if (imageView != null) {
                if (isCameraTorchSupported) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
            if (isCameraTorchSupported) {
                ImageView imageView2 = this.llIIlIlIIl;
                if (imageView2 != null) {
                    imageView2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            TorchController torchController = TorchController.this;
                            torchController.updateTorchState(!torchController.IllIIIIllI);
                        }
                    });
                }
                llIIlIlIIl();
            }
            OverlayTorchStateListener overlayTorchStateListener = this.lIlIIIIlIl;
            if (overlayTorchStateListener != null) {
                overlayTorchStateListener.onTorchStateInitialised(isCameraTorchSupported);
                if (z) {
                    this.lIlIIIIlIl.onTorchStateChanged(this.IllIIIIllI);
                }
            }
        }
    }

    public void setTorchStateListener(OverlayTorchStateListener overlayTorchStateListener) {
        this.lIlIIIIlIl = overlayTorchStateListener;
    }

    public void setup(RecognizerRunnerView recognizerRunnerView) {
        setup((ImageView) null, recognizerRunnerView);
    }

    public void toggleTorchState() {
        updateTorchState(!this.IllIIIIllI);
    }

    public void updateTorchState(final boolean z) {
        RecognizerRunnerView recognizerRunnerView = this.IlIllIlIIl;
        if (recognizerRunnerView != null) {
            recognizerRunnerView.setTorchState(z, new SuccessCallback() {
                public void onOperationDone(boolean z) {
                    Log.m40227d(this, "Setting torch to {}. Success: {}", Boolean.valueOf(z), Boolean.valueOf(z));
                    if (z) {
                        boolean unused = TorchController.this.IllIIIIllI = z;
                        TorchController.this.llIIlIlIIl();
                        if (TorchController.this.lIlIIIIlIl != null) {
                            TorchController.this.lIlIIIIlIl.onTorchStateChanged(TorchController.this.IllIIIIllI);
                        }
                    }
                }
            });
        }
    }

    public void setup(ImageView imageView, RecognizerRunnerView recognizerRunnerView) {
        if (imageView == null) {
            setup((ImageView) null, recognizerRunnerView, (Drawable) null, (Drawable) null);
            return;
        }
        Context context = imageView.getContext();
        setup(imageView, recognizerRunnerView, ContextCompat.getDrawable(context, R.drawable.mb_ic_flash_off_24dp), ContextCompat.getDrawable(context, R.drawable.mb_ic_flash_on_24dp));
    }

    /* access modifiers changed from: private */
    public void llIIlIlIIl() {
        ImageView imageView = this.llIIlIlIIl;
        if (imageView != null) {
            imageView.post(new Runnable() {
                public void run() {
                    if (TorchController.this.IllIIIIllI) {
                        TorchController.this.llIIlIlIIl.setImageDrawable(TorchController.this.llIIIlllll);
                    } else {
                        TorchController.this.llIIlIlIIl.setImageDrawable(TorchController.this.IllIIIllII);
                    }
                    TorchController.this.llIIlIlIIl.requestLayout();
                }
            });
        }
    }

    public void setup(ImageView imageView, RecognizerRunnerView recognizerRunnerView, Drawable drawable, Drawable drawable2) {
        if (recognizerRunnerView != null) {
            this.llIIlIlIIl = imageView;
            this.IlIllIlIIl = recognizerRunnerView;
            this.IllIIIllII = drawable;
            this.llIIIlllll = drawable2;
            boolean isCameraTorchSupported = recognizerRunnerView.isCameraTorchSupported();
            ImageView imageView2 = this.llIIlIlIIl;
            if (imageView2 != null) {
                if (isCameraTorchSupported) {
                    imageView2.setVisibility(0);
                } else {
                    imageView2.setVisibility(8);
                }
            }
            if (isCameraTorchSupported) {
                ImageView imageView3 = this.llIIlIlIIl;
                if (imageView3 != null) {
                    imageView3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            TorchController torchController = TorchController.this;
                            torchController.updateTorchState(!torchController.IllIIIIllI);
                        }
                    });
                }
            } else {
                this.IllIIIIllI = false;
            }
            llIIlIlIIl();
        }
    }
}
