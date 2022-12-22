package com.didi.dimina.container.p106ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.p106ui.dialog.ImagePreviewDialog;
import com.didi.dimina.container.service.ImageLoaderService;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.didi.dimina.container.ui.dialog.ImagePreviewDialog */
public class ImagePreviewDialog extends Dialog {
    public static final int REQUEST_CODE_SETTING = 1;

    /* renamed from: a */
    private ViewPager f17566a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f17567b;

    /* renamed from: c */
    private final DMMina f17568c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f17569d;

    public ImagePreviewDialog(DMMina dMMina, Context context) {
        super(context);
        this.f17568c = dMMina;
        setOwnerActivity((Activity) context);
        this.f17569d = context;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dimina_activity_image_preview);
        this.f17566a = (ViewPager) findViewById(R.id.vp);
        this.f17567b = (TextView) findViewById(R.id.tv_top);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    public void initView(final ArrayList<String> arrayList, String str, boolean z) {
        int i;
        if (!CollectionsUtil.isEmpty((Collection) arrayList)) {
            int i2 = 0;
            while (true) {
                if (i2 < arrayList.size()) {
                    if (arrayList.get(i2) != null && arrayList.get(i2).equals(str)) {
                        i = i2 + 1;
                        break;
                    }
                    i2++;
                } else {
                    i = 1;
                    break;
                }
            }
            TextView textView = this.f17567b;
            textView.setText(i + "/" + arrayList.size());
            this.f17566a.setAdapter(new ViewPagerAdapter(this.f17568c, getOwnerActivity(), arrayList, z));
            this.f17566a.setCurrentItem(i - 1);
            this.f17566a.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    TextView a = ImagePreviewDialog.this.f17567b;
                    a.setText((i + 1) + "/" + arrayList.size());
                }
            });
        }
    }

    /* renamed from: com.didi.dimina.container.ui.dialog.ImagePreviewDialog$ViewPagerAdapter */
    class ViewPagerAdapter extends PagerAdapter {
        Activity activity;
        Dialog dialog;
        ArrayList<String> imageUrls = new ArrayList<>();
        DMMina mDMMina;
        boolean showMenu;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public ViewPagerAdapter(DMMina dMMina, Activity activity2, ArrayList<String> arrayList, boolean z) {
            this.mDMMina = dMMina;
            this.activity = activity2;
            this.imageUrls = arrayList;
            this.showMenu = z;
        }

        public int getCount() {
            return this.imageUrls.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View inflate = View.inflate(this.activity, R.layout.dimina_view_image_preview, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv);
            final String str = this.imageUrls.get(i);
            if (URLUtil.isNetworkUrl(str)) {
                Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadInto(this.activity, str, 0, imageView);
            } else {
                Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadInto(this.activity, new File(str), imageView);
            }
            if (this.showMenu) {
                imageView.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        ViewPagerAdapter.this.show(str);
                        return false;
                    }
                });
            }
            viewGroup.addView(inflate);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ImagePreviewDialog.this.dismiss();
                }
            });
            return inflate;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            ((ViewPager) viewGroup).removeView((View) obj);
        }

        public void save(String str) {
            File absoluteFile = ImagePreviewDialog.this.f17569d.getExternalCacheDir().getAbsoluteFile();
            if (!absoluteFile.exists()) {
                absoluteFile.mkdir();
            }
            ImageLoaderService imageLoaderService = Dimina.getConfig().getAdapterConfig().getImageLoaderService();
            if (URLUtil.isNetworkUrl(str)) {
                imageLoaderService.load((Context) this.activity, str, (ImageLoaderService.FinishBitmapListener) new ImageLoaderService.FinishBitmapListener(absoluteFile) {
                    public final /* synthetic */ File f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onBitmapFinish(Bitmap bitmap) {
                        ImagePreviewDialog.ViewPagerAdapter.this.lambda$save$0$ImagePreviewDialog$ViewPagerAdapter(this.f$1, bitmap);
                    }
                });
            } else {
                imageLoaderService.load((Context) this.activity, new File(str), (ImageLoaderService.FinishBitmapListener) new ImageLoaderService.FinishBitmapListener(absoluteFile) {
                    public final /* synthetic */ File f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onBitmapFinish(Bitmap bitmap) {
                        ImagePreviewDialog.ViewPagerAdapter.this.lambda$save$1$ImagePreviewDialog$ViewPagerAdapter(this.f$1, bitmap);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0051 */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005e A[SYNTHETIC, Splitter:B:15:0x005e] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[SYNTHETIC, Splitter:B:20:0x0069] */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* renamed from: saveBitmapToFile */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void lambda$save$1$ImagePreviewDialog$ViewPagerAdapter(android.graphics.Bitmap r5, java.io.File r6) {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                long r1 = java.lang.System.currentTimeMillis()
                r0.append(r1)
                java.lang.String r1 = ".jpg"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.io.File r1 = new java.io.File
                r1.<init>(r6, r0)
                r6 = 0
                r0 = 0
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0051 }
                r2.<init>(r1)     // Catch:{ Exception -> 0x0051 }
                android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                r3 = 100
                r5.compress(r0, r3, r2)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                r2.flush()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                com.didi.dimina.container.ui.dialog.SingleMediaScanner r5 = new com.didi.dimina.container.ui.dialog.SingleMediaScanner     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                android.app.Activity r0 = r4.activity     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                com.didi.dimina.container.ui.dialog.ImagePreviewDialog$ViewPagerAdapter$3 r3 = new com.didi.dimina.container.ui.dialog.ImagePreviewDialog$ViewPagerAdapter$3     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                r3.<init>()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                r5.<init>(r0, r1, r3)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                android.app.Activity r5 = r4.activity     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                java.lang.String r0 = "保存成功"
                android.widget.Toast r5 = android.widget.Toast.makeText(r5, r0, r6)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                com.didi.sdk.apm.SystemUtils.showToast(r5)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
                r2.close()     // Catch:{ IOException -> 0x0062 }
                goto L_0x0066
            L_0x004a:
                r5 = move-exception
                r0 = r2
                goto L_0x0067
            L_0x004d:
                r0 = r2
                goto L_0x0051
            L_0x004f:
                r5 = move-exception
                goto L_0x0067
            L_0x0051:
                android.app.Activity r5 = r4.activity     // Catch:{ all -> 0x004f }
                java.lang.String r1 = "保存失败"
                android.widget.Toast r5 = android.widget.Toast.makeText(r5, r1, r6)     // Catch:{ all -> 0x004f }
                com.didi.sdk.apm.SystemUtils.showToast(r5)     // Catch:{ all -> 0x004f }
                if (r0 == 0) goto L_0x0066
                r0.close()     // Catch:{ IOException -> 0x0062 }
                goto L_0x0066
            L_0x0062:
                r5 = move-exception
                r5.printStackTrace()
            L_0x0066:
                return
            L_0x0067:
                if (r0 == 0) goto L_0x0071
                r0.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r6 = move-exception
                r6.printStackTrace()
            L_0x0071:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.dialog.ImagePreviewDialog.ViewPagerAdapter.lambda$save$1$ImagePreviewDialog$ViewPagerAdapter(android.graphics.Bitmap, java.io.File):void");
        }

        public void show(final String str) {
            this.dialog = new Dialog(this.activity, R.style.Dialog);
            View inflate = LayoutInflater.from(this.activity).inflate(R.layout.dimina_dialog_image_preview, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tv_save)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (ViewPagerAdapter.this.dialog != null && ViewPagerAdapter.this.dialog.isShowing()) {
                        ViewPagerAdapter.this.dialog.dismiss();
                    }
                    ViewPagerAdapter.this.save(str);
                }
            });
            ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (ViewPagerAdapter.this.dialog != null && ViewPagerAdapter.this.dialog.isShowing()) {
                        ViewPagerAdapter.this.dialog.dismiss();
                    }
                }
            });
            this.dialog.setContentView(inflate);
            Window window = this.dialog.getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
            if (!this.dialog.isShowing()) {
                SystemUtils.showDialog(this.dialog);
            }
        }
    }
}
