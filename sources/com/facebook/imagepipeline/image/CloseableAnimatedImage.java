package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import javax.annotation.Nullable;

public class CloseableAnimatedImage extends CloseableImage {
    private AnimatedImageResult mImageResult;

    public boolean isStateful() {
        return true;
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this.mImageResult = animatedImageResult;
    }

    public synchronized int getWidth() {
        return isClosed() ? 0 : this.mImageResult.getImage().getWidth();
    }

    public synchronized int getHeight() {
        return isClosed() ? 0 : this.mImageResult.getImage().getHeight();
    }

    public void close() {
        synchronized (this) {
            if (this.mImageResult != null) {
                AnimatedImageResult animatedImageResult = this.mImageResult;
                this.mImageResult = null;
                animatedImageResult.dispose();
            }
        }
    }

    public synchronized boolean isClosed() {
        return this.mImageResult == null;
    }

    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.mImageResult.getImage().getSizeInBytes();
    }

    public synchronized AnimatedImageResult getImageResult() {
        return this.mImageResult;
    }

    @Nullable
    public synchronized AnimatedImage getImage() {
        return isClosed() ? null : this.mImageResult.getImage();
    }
}
