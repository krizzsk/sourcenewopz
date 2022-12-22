package com.didi.safety.god.p144ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safety.god.event.RestartDetectionEvent;
import com.didi.safety.god.event.RestartFromBeginningEvent;
import com.didi.safety.god.util.FragmentUtils;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.taxis99.R;

/* renamed from: com.didi.safety.god.ui.DetectionErrorFragment */
public class DetectionErrorFragment extends Fragment {
    public static DetectionErrorFragment newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("msg", str);
        bundle.putString("iknowText", str2);
        DetectionErrorFragment detectionErrorFragment = new DetectionErrorFragment();
        detectionErrorFragment.setArguments(bundle);
        return detectionErrorFragment;
    }

    public static DetectionErrorFragment newInstanceForLocalPic(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("msg", str);
        bundle.putBoolean("localAlbum", true);
        bundle.putString("iknowText", str2);
        DetectionErrorFragment detectionErrorFragment = new DetectionErrorFragment();
        detectionErrorFragment.setArguments(bundle);
        return detectionErrorFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_detection_error_layout, viewGroup, false);
        Bundle arguments = getArguments();
        ((TextView) inflate.findViewById(R.id.detection_error_msg)).setText(arguments.getString("msg"));
        final boolean z = arguments.getBoolean("localAlbum");
        ((TextView) inflate.findViewById(R.id.iknow_btn)).setText(arguments.getString("iknowText"));
        inflate.findViewById(R.id.iknow_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FragmentUtils.closeFragment(DetectionErrorFragment.this);
                if (!z) {
                    BusUtils.post(new RestartDetectionEvent());
                } else {
                    BusUtils.post(new RestartFromBeginningEvent());
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
