package com.didi.component.common.pininput;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.widget.pin.PinInputLayout;
import com.didi.component.core.PresenterGroup;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class PinInputFragment extends AbsNormalFragment implements View.OnClickListener, IPinInputView, PinInputLayout.OnStateChangedListener {

    /* renamed from: a */
    private PinInputPresenter f11660a;

    /* renamed from: b */
    private CommonTitleBar f11661b;

    /* renamed from: c */
    private ViewGroup f11662c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PinInputLayout f11663d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f11664e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f11665f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f11666g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f11667h;

    /* renamed from: i */
    private Handler f11668i = new Handler(Looper.getMainLooper());

    /* renamed from: j */
    private ProgressDialogFragment f11669j;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1030;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        PinInputPresenter pinInputPresenter = new PinInputPresenter(getContext(), getArguments());
        this.f11660a = pinInputPresenter;
        return pinInputPresenter;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.global_pin_input_fragment, viewGroup, false);
        this.f11662c = viewGroup2;
        m7887a(viewGroup2);
        return this.f11662c;
    }

    /* renamed from: a */
    private void m7887a(ViewGroup viewGroup) {
        m7890b(viewGroup);
        PinInputLayout pinInputLayout = (PinInputLayout) viewGroup.findViewById(R.id.oc_pin_input_layout);
        this.f11663d = pinInputLayout;
        pinInputLayout.setOnStateChangedListener(this);
        this.f11664e = (TextView) viewGroup.findViewById(R.id.oc_tips_title);
        this.f11665f = (TextView) viewGroup.findViewById(R.id.oc_tips_content);
        TextView textView = (TextView) viewGroup.findViewById(R.id.oc_confirm_btn);
        this.f11666g = textView;
        textView.setOnClickListener(this);
        showPinInputView();
    }

    /* renamed from: b */
    private void m7890b(ViewGroup viewGroup) {
        CommonTitleBar commonTitleBar = (CommonTitleBar) viewGroup.findViewById(R.id.oc_title_bar);
        this.f11661b = commonTitleBar;
        commonTitleBar.setTitleBarLineVisible(8);
        this.f11661b.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PinInputFragment.this.finishWithResultCancel();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.f11660a = null;
        this.f11662c = null;
        this.f11661b = null;
    }

    public void setTitle(String str) {
        this.f11661b.setTitle(str);
    }

    public void showUploadingDialog() {
        this.f11668i.post(new Runnable() {
            public void run() {
                PinInputFragment.this.displayProgressDialog((String) null);
            }
        });
    }

    public void dismissUploadingDialog() {
        this.f11668i.post(new Runnable() {
            public void run() {
                PinInputFragment.this.dismissProgressDialog();
            }
        });
    }

    public void showUploadFailedToast() {
        this.f11668i.post(new Runnable() {
            public void run() {
                ToastHelper.showShortInfo(PinInputFragment.this.getContext(), PinInputFragment.this.getContext().getResources().getString(R.string.global_pin_input_create_failed_toast));
            }
        });
    }

    public View getFallbackView() {
        return this.f11661b;
    }

    public void displayProgressDialog(String str) {
        showMaskLayerLoading();
    }

    public void dismissProgressDialog() {
        hideLoading();
    }

    public void showPinCreatedView() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                boolean unused = PinInputFragment.this.f11667h = true;
                PinInputFragment.this.f11663d.setEditable(false);
                PinInputFragment.this.f11664e.setText(R.string.global_pin_input_finish_tips_title);
                PinInputFragment.this.f11665f.setText(R.string.global_pin_input_finish_tips_content);
                PinInputFragment.this.f11666g.setText(R.string.global_pin_input_finish_confirm);
                PinInputFragment.this.f11666g.setEnabled(true);
            }
        });
    }

    public void showPinInputView() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                boolean unused = PinInputFragment.this.f11667h = false;
                PinInputFragment.this.f11663d.setEditable(true);
                PinInputFragment.this.f11664e.setText(R.string.global_pin_input_create_tips_title);
                PinInputFragment.this.f11665f.setText(R.string.global_pin_input_create_tips_content);
                PinInputFragment.this.f11666g.setText(R.string.global_pin_input_create_btn);
                PinInputFragment.this.f11666g.setEnabled(PinInputFragment.this.f11663d.isCompleted());
            }
        });
    }

    public void finishWithResultOk() {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public void finishWithResultCancel() {
        getActivity().setResult(0);
        getActivity().finish();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view != this.f11666g) {
            return;
        }
        if (this.f11667h) {
            finishWithResultOk();
            return;
        }
        this.f11660a.createPin(this.f11663d.getPin());
    }

    public void onStateChanged(PinInputLayout.State state) {
        if (state.equals(PinInputLayout.State.COMPLETE)) {
            this.f11666g.setEnabled(true);
        } else if (state.equals(PinInputLayout.State.INCOMPLETE)) {
            this.f11666g.setEnabled(false);
        }
    }
}
