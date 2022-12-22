package com.didi.safety.god.p144ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safety.god.util.FragmentUtils;
import com.taxis99.R;

/* renamed from: com.didi.safety.god.ui.ZoomInImageFragment */
public class ZoomInImageFragment extends Fragment {

    /* renamed from: a */
    private Bitmap f34806a;

    public static ZoomInImageFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("img", str);
        ZoomInImageFragment zoomInImageFragment = new ZoomInImageFragment();
        zoomInImageFragment.setArguments(bundle);
        return zoomInImageFragment;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f34806a = bitmap;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_zoom_in_image_layout, viewGroup, false);
        Bundle arguments = getArguments();
        ImageView imageView = (ImageView) inflate.findViewById(R.id.preview_image);
        if (this.f34806a == null) {
            this.f34806a = BitmapFactory.decodeFile(arguments.getString("img"));
        }
        imageView.setImageBitmap(this.f34806a);
        inflate.findViewById(R.id.close_icon).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FragmentUtils.closeFragment(ZoomInImageFragment.this);
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
