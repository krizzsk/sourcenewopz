package com.didi.app.nova.skeleton.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.didi.app.nova.skeleton.image.glide.FitUri;
import com.didi.app.nova.skeleton.image.performance.ImagePerformance;
import java.io.File;

public class SKDrawableTypeRequest<TranscodeType> {

    /* renamed from: a */
    private RequestBuilder<TranscodeType> f8453a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageRequestListener<TranscodeType> f8454b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImagePerformance f8455c;

    /* renamed from: a */
    private <T> T m5664a(Class<T> cls) {
        return null;
    }

    public SKDrawableTypeRequest(RequestBuilder<TranscodeType> requestBuilder) {
        ImagePerformance imagePerformance = new ImagePerformance();
        this.f8455c = imagePerformance;
        this.f8453a = requestBuilder;
        imagePerformance.startTime = System.currentTimeMillis();
        ((RequestBuilder) this.f8453a.diskCacheStrategy(DiskCacheStrategy.ALL)).listener(new RequestListener<TranscodeType>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<TranscodeType> target, boolean z) {
                if (SKDrawableTypeRequest.this.f8454b != null) {
                    return SKDrawableTypeRequest.this.f8454b.onException(glideException, z);
                }
                return false;
            }

            public boolean onResourceReady(TranscodeType transcodetype, Object obj, Target<TranscodeType> target, DataSource dataSource, boolean z) {
                boolean z2 = dataSource == DataSource.MEMORY_CACHE;
                SKDrawableTypeRequest.this.f8455c.endTime = System.currentTimeMillis();
                SKDrawableTypeRequest.this.f8455c.totalTime = SKDrawableTypeRequest.this.f8455c.endTime - SKDrawableTypeRequest.this.f8455c.startTime;
                SKDrawableTypeRequest.this.f8455c.isFromMemoryCache = z2;
                Fly.m5644a(SKDrawableTypeRequest.this.f8455c);
                if (SKDrawableTypeRequest.this.f8454b != null) {
                    return SKDrawableTypeRequest.this.f8454b.onResourceReady(transcodetype, z2, z);
                }
                return false;
            }
        });
    }

    public SKDrawableTypeRequest<TranscodeType> load(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f8453a.load((String) m5664a(String.class));
            mo40938a("network", "");
        } else {
            this.f8453a.load(str);
            mo40938a("network", str);
        }
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> load(Uri uri) {
        if (uri == null) {
            this.f8453a.load((Uri) m5664a(Uri.class));
            mo40938a("network", "");
        } else {
            this.f8453a.load(uri);
            mo40938a("network", uri.toString());
        }
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> load(File file) {
        if (file == null) {
            this.f8453a.load((File) m5664a(File.class));
            mo40938a("file", "");
        } else {
            this.f8453a.load(file);
            mo40938a("file", file.getPath());
        }
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> load(Integer num) {
        this.f8453a.load(num);
        mo40938a("resource", String.valueOf(num));
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> load(FitType fitType, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f8453a.load(m5664a(FitUri.class));
            mo40938a("network", "");
        } else {
            this.f8453a.load((Object) new FitUri(fitType, Uri.parse(str)));
            mo40938a("network", str);
        }
        return this;
    }

    public FutureTarget<TranscodeType> submit() {
        return this.f8453a.submit();
    }

    public FutureTarget<TranscodeType> submit(int i, int i2) {
        return this.f8453a.submit(i, i2);
    }

    /* renamed from: com.didi.app.nova.skeleton.image.SKDrawableTypeRequest$2 */
    static /* synthetic */ class C37382 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$app$nova$skeleton$image$Priority;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.app.nova.skeleton.image.Priority[] r0 = com.didi.app.nova.skeleton.image.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$app$nova$skeleton$image$Priority = r0
                com.didi.app.nova.skeleton.image.Priority r1 = com.didi.app.nova.skeleton.image.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$image$Priority     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.app.nova.skeleton.image.Priority r1 = com.didi.app.nova.skeleton.image.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$image$Priority     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.app.nova.skeleton.image.Priority r1 = com.didi.app.nova.skeleton.image.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$image$Priority     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.app.nova.skeleton.image.Priority r1 = com.didi.app.nova.skeleton.image.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.skeleton.image.SKDrawableTypeRequest.C37382.<clinit>():void");
        }
    }

    public SKDrawableTypeRequest<TranscodeType> priority(Priority priority) {
        int i = C37382.$SwitchMap$com$didi$app$nova$skeleton$image$Priority[priority.ordinal()];
        if (i == 1) {
            this.f8453a.priority(Priority.IMMEDIATE);
        } else if (i == 2) {
            this.f8453a.priority(Priority.HIGH);
        } else if (i == 3) {
            this.f8453a.priority(Priority.NORMAL);
        } else if (i == 4) {
            this.f8453a.priority(Priority.LOW);
        }
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> skipMemory(boolean z) {
        this.f8453a.skipMemoryCache(z);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        this.f8453a.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> fitCenter() {
        this.f8453a.fitCenter();
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> centerCrop() {
        this.f8453a.centerCrop();
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.f8453a.transition(transitionOptions);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> placeholder(int i) {
        this.f8453a.placeholder(i);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> placeholder(Drawable drawable) {
        this.f8453a.placeholder(drawable);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> fallback(Drawable drawable) {
        this.f8453a.fallback(drawable);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> fallback(int i) {
        this.f8453a.fallback(i);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> error(int i) {
        this.f8453a.error(i);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> error(Drawable drawable) {
        this.f8453a.error(drawable);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> override(int i, int i2) {
        this.f8453a.override(i, i2);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> transform(BitmapTransformation... bitmapTransformationArr) {
        this.f8453a.transform((Transformation<Bitmap>[]) bitmapTransformationArr);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> listener(ImageRequestListener imageRequestListener) {
        if (imageRequestListener != null) {
            this.f8454b = imageRequestListener;
        }
        return this;
    }

    public void into(ImageView imageView) {
        this.f8453a.into(imageView);
    }

    public void into(Target<TranscodeType> target) {
        this.f8453a.into(target);
    }

    public FutureTarget<TranscodeType> into(int i, int i2) {
        return this.f8453a.into(i, i2);
    }

    public void preload() {
        this.f8453a.preload();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40938a(String str, String str2) {
        this.f8455c.type = str;
        this.f8455c.url = str2;
    }
}
