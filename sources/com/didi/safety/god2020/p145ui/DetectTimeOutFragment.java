package com.didi.safety.god2020.p145ui;

import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.util.FragmentUtils;
import com.taxis99.R;
import java.util.HashMap;

/* renamed from: com.didi.safety.god2020.ui.DetectTimeOutFragment */
public class DetectTimeOutFragment extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Runnable f34904a;

    public static DetectTimeOutFragment newInstance(String str) {
        return newInstance(str, "");
    }

    public static DetectTimeOutFragment newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("msg", str);
        bundle.putString("url", str2);
        DetectTimeOutFragment detectTimeOutFragment = new DetectTimeOutFragment();
        detectTimeOutFragment.setArguments(bundle);
        return detectTimeOutFragment;
    }

    public void setRunnable(Runnable runnable) {
        this.f34904a = runnable;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_detect_timeout_layout, viewGroup, false);
        Bundle arguments = getArguments();
        String string = arguments.getString("msg");
        arguments.getString("url");
        ((TextView) inflate.findViewById(R.id.fail_msg)).setText(Html.fromHtml(string));
        inflate.findViewById(R.id.recapture_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FragmentUtils.closeFragment(DetectTimeOutFragment.this);
                if (DetectTimeOutFragment.this.f34904a != null) {
                    DetectTimeOutFragment.this.f34904a.run();
                }
            }
        });
        inflate.requestFocus();
        inflate.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
        return inflate;
    }

    /* renamed from: a */
    private void m24647a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "APPEAL");
        hashMap.put("code", Integer.valueOf(i));
        SafetyTraceEventHandler.trace(hashMap);
    }
}
