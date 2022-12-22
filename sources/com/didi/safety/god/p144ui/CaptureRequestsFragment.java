package com.didi.safety.god.p144ui;

import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.raven.config.RavenKey;
import com.didi.safety.god.util.FragmentUtils;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.taxis99.R;

/* renamed from: com.didi.safety.god.ui.CaptureRequestsFragment */
public class CaptureRequestsFragment extends Fragment {

    /* renamed from: a */
    private IDetectionAct f34695a;

    public static CaptureRequestsFragment newInstance(String str, String str2, String str3, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("img", str);
        bundle.putString("title", str2);
        bundle.putString(RavenKey.QUERY, str3);
        bundle.putInt("gif", i);
        CaptureRequestsFragment captureRequestsFragment = new CaptureRequestsFragment();
        captureRequestsFragment.setArguments(bundle);
        return captureRequestsFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_capture_requests_layout, viewGroup, false);
        Bundle arguments = getArguments();
        ImageView imageView = (ImageView) inflate.findViewById(R.id.card_preview);
        String string = arguments.getString("img");
        int i = arguments.getInt("gif");
        if (i == 0) {
            DiSafetyImageLoader.with(getActivity()).load(string).into(imageView);
        } else {
            DiSafetyImageLoader.with(getActivity()).load(i).into(imageView);
        }
        ((TextView) inflate.findViewById(R.id.card_preview_title)).setText(arguments.getString("title"));
        ((TextView) inflate.findViewById(R.id.card_preview_requests)).setText(Html.fromHtml(arguments.getString(RavenKey.QUERY)));
        inflate.findViewById(R.id.close_icon).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FragmentUtils.closeFragment(CaptureRequestsFragment.this);
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

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof IDetectionAct) {
            IDetectionAct iDetectionAct = (IDetectionAct) activity;
            this.f34695a = iDetectionAct;
            iDetectionAct.pauseDetect();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        IDetectionAct iDetectionAct = this.f34695a;
        if (iDetectionAct != null) {
            iDetectionAct.resumeDetect();
        }
    }
}
