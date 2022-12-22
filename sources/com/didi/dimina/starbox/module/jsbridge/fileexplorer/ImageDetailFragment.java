package com.didi.dimina.starbox.module.jsbridge.fileexplorer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.didi.dimina.starbox.p107ui.base.BaseFragment;
import com.taxis99.R;
import java.io.File;
import java.lang.ref.WeakReference;

public class ImageDetailFragment extends BaseFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f18062a;

    /* renamed from: b */
    private File f18063b;

    /* access modifiers changed from: protected */
    public int onRequestLayout() {
        return R.layout.dimina_starbox_fragment_image_detail;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f18062a = (ImageView) findViewById(R.id.image);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f18063b = (File) arguments.getSerializable(BundleKey.FILE_KEY);
        }
        m13493a(this.f18063b);
    }

    /* renamed from: a */
    private void m13493a(File file) {
        if (file != null) {
            new ImageReadTask(this).execute(new File[]{file});
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f18062a.setImageBitmap((Bitmap) null);
    }

    private static class ImageReadTask extends AsyncTask<File, Void, Bitmap> {
        private final WeakReference<ImageDetailFragment> mReference;

        public ImageReadTask(ImageDetailFragment imageDetailFragment) {
            this.mReference = new WeakReference<>(imageDetailFragment);
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(File... fileArr) {
            return decodeSampledBitmapFromFilePath(fileArr[0].getPath(), 1080, 1920);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (this.mReference.get() != null) {
                ((ImageDetailFragment) this.mReference.get()).f18062a.setImageBitmap(bitmap);
            }
        }

        public static Bitmap decodeSampledBitmapFromFilePath(String str, int i, int i2) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, i, i2);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }

        public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 > i2 || i4 > i) {
                return Math.min(Math.round(((float) i3) / ((float) i2)), Math.round(((float) i4) / ((float) i)));
            }
            return 1;
        }
    }
}
