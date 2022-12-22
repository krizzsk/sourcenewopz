package com.didi.soda.customer.foundation.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.Fly;
import com.didi.app.nova.skeleton.image.ImageDownloadListener;
import com.didi.app.nova.skeleton.image.ImageRequestListener;
import com.didi.app.nova.skeleton.image.SKDrawableTypeRequest;
import com.didi.app.nova.skeleton.image.SKRequestManager;
import com.didi.soda.customer.foundation.imageloader.ImageResourceReadyListener;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import java.io.File;

public final class FlyImageLoader {
    public static final DiskCacheStrategy ALL = DiskCacheStrategy.ALL;
    public static final DiskCacheStrategy AUTOMATIC = DiskCacheStrategy.AUTOMATIC;
    public static final DiskCacheStrategy DATA = DiskCacheStrategy.DATA;
    public static final DiskCacheStrategy NONE = DiskCacheStrategy.NONE;
    public static final DiskCacheStrategy RESOURCE = DiskCacheStrategy.RESOURCE;

    /* renamed from: a */
    private static final String f41239a = "FlyImageLoader";

    private FlyImageLoader() {
    }

    public static ImageRequestWrapper loadImage4x3(ScopeContext scopeContext, String str) {
        return m29205a(Fly.with(scopeContext), FitType.FIT_4_3, str);
    }

    public static ImageRequestWrapper loadImage4x3(Context context, String str) {
        return m29205a(Fly.with(context), FitType.FIT_4_3, str);
    }

    public static ImageRequestWrapper loadImage1x1(ScopeContext scopeContext, String str) {
        return m29205a(Fly.with(scopeContext), FitType.FIT_1_1, str);
    }

    public static ImageRequestWrapper loadImage1x1(Context context, String str) {
        return m29205a(Fly.with(context), FitType.FIT_1_1, str);
    }

    public static ImageRequestWrapper loadImageUnspecified(ScopeContext scopeContext, String str) {
        return m29205a(Fly.with(scopeContext), FitType.FIT_None, str);
    }

    public static ImageRequestWrapper loadImageUnspecified(Context context, String str) {
        return m29205a(Fly.with(context), FitType.FIT_None, str);
    }

    /* renamed from: a */
    private static ImageRequestWrapper m29205a(SKRequestManager sKRequestManager, FitType fitType, String str) {
        SKDrawableTypeRequest<Drawable> load = sKRequestManager.load(fitType, str);
        ImageRequestWrapper imageRequestWrapper = new ImageRequestWrapper(load);
        if (NetWorkUtils.isHttpUrl(str)) {
            load.fitCenter();
        }
        return imageRequestWrapper;
    }

    public static ImageRequestWrapper loadImageDownLoadOnly(ScopeContext scopeContext, FitType fitType, String str) {
        SKDrawableTypeRequest<File> load = Fly.with(scopeContext).downloadOnly().load(fitType, str);
        ImageRequestWrapper imageRequestWrapper = new ImageRequestWrapper(load);
        if (NetWorkUtils.isHttpUrl(str)) {
            load.fitCenter();
        }
        return imageRequestWrapper;
    }

    public static ImageRequestWrapper loadImageDownLoadOnly(Context context, FitType fitType, String str) {
        SKDrawableTypeRequest<File> load = Fly.with(context).downloadOnly().load(fitType, str);
        ImageRequestWrapper imageRequestWrapper = new ImageRequestWrapper(load);
        if (NetWorkUtils.isHttpUrl(str)) {
            load.fitCenter();
        }
        return imageRequestWrapper;
    }

    public static class ImageRequestWrapper {
        private SKDrawableTypeRequest mImageRequest;

        public ImageRequestWrapper(SKDrawableTypeRequest sKDrawableTypeRequest) {
            this.mImageRequest = sKDrawableTypeRequest;
        }

        private ImageRequestWrapper() {
            throw new IllegalStateException("use ImageRequestWrapper(ImageRequest imageRequest) instead");
        }

        public ImageRequestWrapper centerCrop() {
            this.mImageRequest.centerCrop();
            return this;
        }

        public ImageRequestWrapper dontAnimate() {
            this.mImageRequest.transition(GenericTransitionOptions.withNoTransition());
            return this;
        }

        public ImageRequestWrapper animate(ViewPropertyTransition.Animator animator) {
            this.mImageRequest.transition(GenericTransitionOptions.with(animator));
            return this;
        }

        public ImageRequestWrapper animate(int i) {
            this.mImageRequest.transition(GenericTransitionOptions.with(i));
            return this;
        }

        public ImageRequestWrapper diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
            this.mImageRequest.diskCacheStrategy(diskCacheStrategy);
            return this;
        }

        public ImageRequestWrapper error(int i) {
            this.mImageRequest.error(i);
            return this;
        }

        public ImageRequestWrapper error(Drawable drawable) {
            this.mImageRequest.error(drawable);
            return this;
        }

        public ImageRequestWrapper fitCenter() {
            this.mImageRequest.fitCenter();
            return this;
        }

        public void into(ImageView imageView) {
            try {
                this.mImageRequest.into(imageView);
            } catch (IllegalArgumentException e) {
                LogUtil.m29102e(FlyImageLoader.f41239a, "into error: " + e);
            }
        }

        public void into(Target target) {
            try {
                this.mImageRequest.into(target);
            } catch (IllegalArgumentException e) {
                LogUtil.m29102e(FlyImageLoader.f41239a, "into error: " + e);
            }
        }

        public void intoDrawableImageView(Context context, ImageView imageView, final ImageResourceReadyListener imageResourceReadyListener) {
            if (imageView == null) {
                imageView = new ImageView(context);
            }
            this.mImageRequest.into(new DrawableImageViewTarget(imageView) {
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    super.onResourceReady(drawable, transition);
                    ImageResourceReadyListener imageResourceReadyListener = imageResourceReadyListener;
                    if (imageResourceReadyListener != null) {
                        imageResourceReadyListener.onResourceReady(drawable);
                    }
                }
            });
        }

        public ImageRequestWrapper listener(ImageRequestListener imageRequestListener) {
            if (imageRequestListener != null) {
                this.mImageRequest.listener(imageRequestListener);
            }
            return this;
        }

        public void downloadOnly(final ImageDownloadListener imageDownloadListener) {
            if (imageDownloadListener != null) {
                this.mImageRequest.listener(new ImageRequestListener<File>() {
                    public boolean onException(Exception exc, boolean z) {
                        UIHandler.post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: INVOKE  
                              (wrap: com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$gCKs4mbV7duYN8kEBpgOK9tMEbc : 0x0004: CONSTRUCTOR  (r0v0 com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$gCKs4mbV7duYN8kEBpgOK9tMEbc) = 
                              (wrap: com.didi.app.nova.skeleton.image.ImageDownloadListener : 0x0000: IGET  (r3v1 com.didi.app.nova.skeleton.image.ImageDownloadListener) = 
                              (r1v0 'this' com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper$2 A[THIS])
                             com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.2.val$imageLoaderListener com.didi.app.nova.skeleton.image.ImageDownloadListener)
                              (r2v0 'exc' java.lang.Exception)
                             call: com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$gCKs4mbV7duYN8kEBpgOK9tMEbc.<init>(com.didi.app.nova.skeleton.image.ImageDownloadListener, java.lang.Exception):void type: CONSTRUCTOR)
                             com.didichuxing.dfbasesdk.utils.UIHandler.post(java.lang.Runnable):void type: STATIC in method: com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.2.onException(java.lang.Exception, boolean):boolean, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONSTRUCTOR  (r0v0 com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$gCKs4mbV7duYN8kEBpgOK9tMEbc) = 
                              (wrap: com.didi.app.nova.skeleton.image.ImageDownloadListener : 0x0000: IGET  (r3v1 com.didi.app.nova.skeleton.image.ImageDownloadListener) = 
                              (r1v0 'this' com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper$2 A[THIS])
                             com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.2.val$imageLoaderListener com.didi.app.nova.skeleton.image.ImageDownloadListener)
                              (r2v0 'exc' java.lang.Exception)
                             call: com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$gCKs4mbV7duYN8kEBpgOK9tMEbc.<init>(com.didi.app.nova.skeleton.image.ImageDownloadListener, java.lang.Exception):void type: CONSTRUCTOR in method: com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.2.onException(java.lang.Exception, boolean):boolean, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	... 87 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$gCKs4mbV7duYN8kEBpgOK9tMEbc, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	... 93 more
                            */
                        /*
                            this = this;
                            com.didi.app.nova.skeleton.image.ImageDownloadListener r3 = r3
                            com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$gCKs4mbV7duYN8kEBpgOK9tMEbc r0 = new com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$gCKs4mbV7duYN8kEBpgOK9tMEbc
                            r0.<init>(r3, r2)
                            com.didichuxing.dfbasesdk.utils.UIHandler.post(r0)
                            r2 = 0
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.C137712.onException(java.lang.Exception, boolean):boolean");
                    }

                    public boolean onResourceReady(File file, boolean z, boolean z2) {
                        UIHandler.post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: INVOKE  
                              (wrap: com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$Pz2ruvy90f4bSX3Q9nPqMkWn514 : 0x0004: CONSTRUCTOR  (r3v1 com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$Pz2ruvy90f4bSX3Q9nPqMkWn514) = 
                              (wrap: com.didi.app.nova.skeleton.image.ImageDownloadListener : 0x0000: IGET  (r2v1 com.didi.app.nova.skeleton.image.ImageDownloadListener) = 
                              (r0v0 'this' com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper$2 A[THIS])
                             com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.2.val$imageLoaderListener com.didi.app.nova.skeleton.image.ImageDownloadListener)
                              (r1v0 'file' java.io.File)
                             call: com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$Pz2ruvy90f4bSX3Q9nPqMkWn514.<init>(com.didi.app.nova.skeleton.image.ImageDownloadListener, java.io.File):void type: CONSTRUCTOR)
                             com.didichuxing.dfbasesdk.utils.UIHandler.post(java.lang.Runnable):void type: STATIC in method: com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.2.onResourceReady(java.io.File, boolean, boolean):boolean, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONSTRUCTOR  (r3v1 com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$Pz2ruvy90f4bSX3Q9nPqMkWn514) = 
                              (wrap: com.didi.app.nova.skeleton.image.ImageDownloadListener : 0x0000: IGET  (r2v1 com.didi.app.nova.skeleton.image.ImageDownloadListener) = 
                              (r0v0 'this' com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper$2 A[THIS])
                             com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.2.val$imageLoaderListener com.didi.app.nova.skeleton.image.ImageDownloadListener)
                              (r1v0 'file' java.io.File)
                             call: com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$Pz2ruvy90f4bSX3Q9nPqMkWn514.<init>(com.didi.app.nova.skeleton.image.ImageDownloadListener, java.io.File):void type: CONSTRUCTOR in method: com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.2.onResourceReady(java.io.File, boolean, boolean):boolean, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	... 87 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$Pz2ruvy90f4bSX3Q9nPqMkWn514, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	... 93 more
                            */
                        /*
                            this = this;
                            com.didi.app.nova.skeleton.image.ImageDownloadListener r2 = r3
                            com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$Pz2ruvy90f4bSX3Q9nPqMkWn514 r3 = new com.didi.soda.customer.foundation.util.-$$Lambda$FlyImageLoader$ImageRequestWrapper$2$Pz2ruvy90f4bSX3Q9nPqMkWn514
                            r3.<init>(r2, r1)
                            com.didichuxing.dfbasesdk.utils.UIHandler.post(r3)
                            r1 = 0
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.util.FlyImageLoader.ImageRequestWrapper.C137712.onResourceReady(java.io.File, boolean, boolean):boolean");
                    }
                }).submit();
            } else {
                this.mImageRequest.submit();
            }
        }

        public ImageRequestWrapper override(int i, int i2) {
            this.mImageRequest.override(i, i2);
            return this;
        }

        public ImageRequestWrapper placeholder(int i) {
            this.mImageRequest.placeholder(i);
            return this;
        }

        public ImageRequestWrapper placeholder(Drawable drawable) {
            this.mImageRequest.placeholder(drawable);
            return this;
        }

        public ImageRequestWrapper skipMemoryCache(boolean z) {
            this.mImageRequest.skipMemory(z);
            return this;
        }

        public ImageRequestWrapper transform(BitmapTransformation... bitmapTransformationArr) {
            this.mImageRequest.transform(bitmapTransformationArr);
            return this;
        }
    }
}
