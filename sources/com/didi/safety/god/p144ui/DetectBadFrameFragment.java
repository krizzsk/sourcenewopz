package com.didi.safety.god.p144ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safety.god.util.FragmentUtils;
import com.taxis99.R;

/* renamed from: com.didi.safety.god.ui.DetectBadFrameFragment */
public class DetectBadFrameFragment extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Runnable f34696a;

    public static DetectBadFrameFragment newInstance(String str) {
        return newInstance(str, "");
    }

    public static DetectBadFrameFragment newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("msg", str);
        bundle.putString("iknowText", str2);
        DetectBadFrameFragment detectBadFrameFragment = new DetectBadFrameFragment();
        detectBadFrameFragment.setArguments(bundle);
        return detectBadFrameFragment;
    }

    public void setRunnable(Runnable runnable) {
        this.f34696a = runnable;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_detection_error_layout, viewGroup, false);
        Bundle arguments = getArguments();
        arguments.getString("msg");
        ((TextView) inflate.findViewById(R.id.detection_error_msg)).setText(arguments.getString("msg"));
        ((TextView) inflate.findViewById(R.id.iknow_btn)).setText(arguments.getString("iknowText"));
        inflate.findViewById(R.id.iknow_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FragmentUtils.closeFragment(DetectBadFrameFragment.this);
                if (DetectBadFrameFragment.this.f34696a != null) {
                    DetectBadFrameFragment.this.f34696a.run();
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
}
