package com.didi.global.qrscan;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.qrscan.inter.QRCodeProcess;
import com.didi.global.widget.QRCodeInputLayout;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class QRCodeInputFragment extends C8796a implements QRCodeInputLayout.OnStateChangedListener {

    /* renamed from: b */
    private CommonTitleBar f22905b;

    /* renamed from: c */
    private TextView f22906c;

    /* renamed from: d */
    private RelativeLayout f22907d;

    /* renamed from: e */
    private QRCodeInputLayout f22908e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public QRScanFragment f22909f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OpenLightManager f22910g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextureView f22911h;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67435a(boolean z) {
    }

    public /* bridge */ /* synthetic */ void setProcess(QRCodeProcess qRCodeProcess) {
        super.setProcess(qRCodeProcess);
    }

    public void setParent(QRScanFragment qRScanFragment) {
        this.f22909f = qRScanFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f22930a != null) {
            if (this.f22930a.autoTorchEnabled()) {
                this.f22910g = new OpenLightManager();
            }
            this.f22930a.onEnterInputCode();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.global_qr_code_input_fragment_new, viewGroup, false);
        this.f22907d = relativeLayout;
        m16473a((ViewGroup) relativeLayout);
        TextureView textureView = new TextureView(getContext());
        this.f22911h = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QRCodeInputFragment.this.f22910g != null) {
                    QRCodeInputFragment.this.f22910g.start(QRCodeInputFragment.this.getContext(), QRCodeInputFragment.this.f22911h);
                }
            }
        });
        ((FrameLayout) this.f22907d.findViewById(R.id.frame)).addView(this.f22911h);
        return this.f22907d;
    }

    /* renamed from: a */
    private void m16473a(ViewGroup viewGroup) {
        m16475b(viewGroup);
        QRCodeInputLayout qRCodeInputLayout = (QRCodeInputLayout) viewGroup.findViewById(R.id.oc_pin_input_layout);
        this.f22908e = qRCodeInputLayout;
        qRCodeInputLayout.setOnStateChangedListener(this);
        TextView textView = (TextView) this.f22907d.findViewById(R.id.oc_tips_content);
        if (this.f22930a != null) {
            textView.setText(this.f22930a.getPinCodeTipText());
            this.f22908e.initView(this.f22930a.getPinCodeInputCount());
        }
    }

    /* renamed from: b */
    private void m16475b(ViewGroup viewGroup) {
        CommonTitleBar commonTitleBar = (CommonTitleBar) viewGroup.findViewById(R.id.oc_title_bar);
        this.f22905b = commonTitleBar;
        commonTitleBar.setTitleBarLineVisible(8);
        this.f22905b.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                QRCodeInputFragment.this.f22909f.mo67450b();
                if (QRCodeInputFragment.this.f22930a != null) {
                    QRCodeInputFragment.this.f22930a.onLeaveInputCode();
                }
            }
        });
        TextView textView = (TextView) this.f22907d.findViewById(R.id.oc_tips_title);
        this.f22906c = textView;
        textView.setText(Html.fromHtml(getString(R.string.global_openride_pin_input_title)));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f22907d = null;
        this.f22905b = null;
    }

    public void setTitle(String str) {
        this.f22905b.setTitle(str);
    }

    public void clear() {
        this.f22908e.clearPin();
    }

    public View getTitleBar() {
        return this.f22905b;
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        hideSoftKeyboard();
        OpenLightManager openLightManager = this.f22910g;
        if (openLightManager != null) {
            openLightManager.stop();
        }
    }

    public void hideSoftKeyboard() {
        this.f22908e.hideSoftKeyboard();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67434a() {
        QRCodeInputLayout qRCodeInputLayout = this.f22908e;
        if (qRCodeInputLayout != null) {
            qRCodeInputLayout.clearPin();
        }
    }

    public void onStateChanged(QRCodeInputLayout.State state) {
        if (state.equals(QRCodeInputLayout.State.COMPLETE)) {
            hideSoftKeyboard();
            if (this.f22930a != null) {
                this.f22930a.onInputCode(this.f22908e.getPin());
            }
        }
    }
}
