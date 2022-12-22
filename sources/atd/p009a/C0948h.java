package atd.p009a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import atd.p009a.C0951i;
import atd.p015d.C0985g;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: atd.a.h */
public final class C0948h extends C0937a {

    /* renamed from: d */
    public static final C0948h f166d = new C0948h();

    /* renamed from: e */
    private static final Executor f167e = Executors.newFixedThreadPool(2);

    /* renamed from: atd.a.h$a */
    class C0949a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Uri f168a;

        /* renamed from: b */
        final /* synthetic */ WeakReference f169b;

        /* renamed from: atd.a.h$a$a */
        class C0950a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageView f171a;

            /* renamed from: b */
            final /* synthetic */ Bitmap f172b;

            C0950a(C0949a aVar, ImageView imageView, Bitmap bitmap) {
                this.f171a = imageView;
                this.f172b = bitmap;
            }

            public void run() {
                this.f171a.setImageBitmap(this.f172b);
            }
        }

        C0949a(Uri uri, WeakReference weakReference) {
            this.f168a = uri;
            this.f169b = weakReference;
        }

        public void run() {
            try {
                byte[] a = C0948h.this.mo13551a(new C0951i.C0952a().mo13577a(this.f168a.toString()).mo13581b().mo13580a()).mo13582a();
                ImageView imageView = (ImageView) this.f169b.get();
                if (imageView != null && imageView.getTag().equals(this.f168a)) {
                    imageView.post(new C0950a(this, imageView, BitmapFactory.decodeByteArray(a, 0, a.length)));
                }
            } catch (IOException unused) {
            }
        }
    }

    private C0948h() {
    }

    /* renamed from: a */
    public void mo13569a(ImageView imageView, C0985g gVar) {
        if (imageView != null && gVar != null) {
            int i = Resources.getSystem().getDisplayMetrics().densityDpi;
            if (i > 320) {
                m132a(imageView, gVar.mo13651a(), gVar.mo13652b(), gVar.mo13653c());
            } else if (i > 240) {
                m132a(imageView, gVar.mo13652b(), gVar.mo13653c(), gVar.mo13651a());
            } else {
                m132a(imageView, gVar.mo13653c(), gVar.mo13652b(), gVar.mo13651a());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo13552b() {
        return C0937a.f154c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo13550a() {
        return C0937a.f153b;
    }

    /* renamed from: a */
    private void m132a(ImageView imageView, Uri... uriArr) {
        for (Uri uri : uriArr) {
            if (uri != null) {
                m133a((WeakReference<ImageView>) new WeakReference(imageView), uri);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m133a(WeakReference<ImageView> weakReference, Uri uri) {
        try {
            ((ImageView) weakReference.get()).setTag(uri);
            f167e.execute(new C0949a(uri, weakReference));
        } catch (NullPointerException unused) {
        }
    }
}
