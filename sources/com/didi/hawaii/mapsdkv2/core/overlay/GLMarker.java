package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import com.didi.hawaii.mapsdkv2.common.Tranform2Piex20Utils;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.MapCanvas;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GLViewDebug.ExportClass(name = "Marker")
public class GLMarker extends GLPrimaryShape {
    private static final String TAG = "GLMarker";
    @GLViewDebug.ExportField(name = "anchor_x")
    protected float anchorX;
    @GLViewDebug.ExportField(name = "anchor_y")
    protected float anchorY;
    @GLViewDebug.ExportField(name = "angle")
    protected float angle;
    protected long bubbleId;
    @GLViewDebug.ExportField(name = "center")
    protected final GLView.LatLngSafe center;
    protected int fixPosX;
    protected int fixPosY;
    protected LatLngBounds groundBounds;
    protected boolean is2DGround = false;
    protected boolean isAvoidAnno;
    protected boolean isClockwise;
    protected boolean isFastLoad;
    protected boolean isFixPosition;
    protected boolean isFlat;
    protected boolean isOrthographicProject;
    private OnVisibleChangeListener listener;
    protected final RectF mScreenBound = new RectF();
    protected final float[] mScreenBoundCache = new float[4];
    @GLViewDebug.ExportField(name = "offset_x")
    protected float offsetX;
    @GLViewDebug.ExportField(name = "offset_y")
    protected float offsetY;
    private boolean realVisible = true;
    @GLViewDebug.ExportField(name = "scale_x")
    protected float scaleX;
    @GLViewDebug.ExportField(name = "scale_y")
    protected float scaleY;
    @GLViewDebug.ExportField(name = "texture")
    protected Texture texture;

    public interface OnVisibleChangeListener {
        void onVisibleChange(boolean z, long j);
    }

    public GLMarker(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.realVisible = option.isVisible();
        this.center = new GLView.LatLngSafe();
        update(option);
    }

    /* access modifiers changed from: protected */
    public void update(Option option) {
        this.center.set(option.longitude, option.latitude);
        this.texture = option.texture;
        this.anchorX = option.anchorX;
        this.anchorY = option.anchorY;
        this.scaleX = option.scaleX;
        this.scaleY = option.scaleY;
        this.offsetX = option.offsetX;
        this.offsetY = option.offsetY;
        this.angle = option.angle;
        this.isClockwise = option.isClockwise;
        this.isFlat = option.isFlat;
        this.isFixPosition = option.isFixPosition;
        this.isFastLoad = option.isFastLoad;
        this.isAvoidAnno = option.isAvoidAnno;
        this.isOrthographicProject = option.isOrthographicProject;
        this.is2DGround = option.is2DGround;
        this.groundBounds = option.groundBounds;
        this.bubbleId = option.bubbleId;
        super.setClickable(option.clickable);
    }

    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            final Option option2 = (Option) option;
            update(option2);
            set(new RenderTask() {
                public void run() {
                    if (GLMarker.this.bubbleId <= 0) {
                        GLMarker.this.mMapCanvas.updateMarker(GLMarker.this.mDisplayId, option2.longitude, option2.latitude, option2.texture != null ? option2.texture.getBitmapKey() : "", option2.anchorX, option2.anchorY, option2.scaleX, option2.scaleY, option2.offsetX, option2.offsetY, option2.fixPosX, option2.fixPosY, option2.angle, option2.isClockwise, option2.isFlat, option2.isFixPosition, option2.isFastLoad, option2.isAvoidAnno, option2.isOrthographicProject, GLMarker.calculateTrueZIndex(GLMarker.this.mLayer, option2.getzIndex()), option2.getAlpha(), option2.is2DGround, option2.groundBounds, option2.clickable);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        if (this.bubbleId > 0) {
            this.mMapCanvas.setBubbleVisible(this.bubbleId, z);
        } else {
            this.mMapCanvas.setMarkerVisible(this.mDisplayId, z);
        }
    }

    public void onSetAlpha(float f) {
        if (this.bubbleId <= 0) {
            this.mMapCanvas.setMarkerAlpha(this.mDisplayId, f);
        }
    }

    public void setAngle(final float f) {
        if (this.isClockwise) {
            f = 360.0f - f;
        }
        if (this.angle != f) {
            this.angle = f;
            set(new RenderTask() {
                public void run() {
                    if (GLMarker.this.bubbleId <= 0) {
                        GLMarker.this.mMapCanvas.setMarkerRotateAngle(GLMarker.this.mDisplayId, f);
                    }
                }
            });
        }
    }

    public void setOnVisibleChangeListener(OnVisibleChangeListener onVisibleChangeListener) {
        this.listener = onVisibleChangeListener;
    }

    public float getAngle() {
        return this.angle;
    }

    public void setScale(final PointF pointF) {
        if (this.scaleY != pointF.y || this.scaleX != pointF.x) {
            this.scaleX = pointF.x;
            this.scaleY = pointF.y;
            set(new RenderTask() {
                public void run() {
                    if (GLMarker.this.bubbleId <= 0) {
                        GLMarker.this.mMapCanvas.setMarkerScale(GLMarker.this.mDisplayId, pointF.x, pointF.y);
                    }
                }
            });
        }
    }

    public void setOffset(final PointF pointF) {
        if (this.offsetX != pointF.x || this.offsetY != pointF.y) {
            set(new RenderTask() {
                public void run() {
                    GLMarker.this.mMapCanvas.setMarkerOffset(GLMarker.this.mDisplayId, pointF.x, pointF.y);
                }
            });
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        set(new RenderTask() {
            public void run() {
                if (GLMarker.this.bubbleId <= 0) {
                    GLMarker.this.mMapCanvas.updateMarker(GLMarker.this.mDisplayId, GLMarker.this.center.getLongitude(), GLMarker.this.center.getLatitude(), GLMarker.this.texture != null ? GLMarker.this.texture.getBitmapKey() : "", GLMarker.this.anchorX, GLMarker.this.anchorY, GLMarker.this.scaleX, GLMarker.this.scaleY, GLMarker.this.offsetX, GLMarker.this.offsetY, GLMarker.this.fixPosX, GLMarker.this.fixPosY, GLMarker.this.angle, GLMarker.this.isClockwise, GLMarker.this.isFlat, GLMarker.this.isFixPosition, GLMarker.this.isFastLoad, GLMarker.this.isAvoidAnno, GLMarker.this.isOrthographicProject, GLMarker.calculateTrueZIndex(GLMarker.this.mLayer, GLMarker.this.zIndex), GLMarker.this.alpha, GLMarker.this.is2DGround, GLMarker.this.groundBounds, GLMarker.this.isClickable());
                }
            }
        });
    }

    public void setPosition(final LatLng latLng) {
        if (latLng != null && !this.center.equalLatLng(latLng)) {
            this.center.set(latLng);
            set(new RenderTask() {
                public void run() {
                    if (GLMarker.this.bubbleId > 0) {
                        GLMarker.this.mMapCanvas.setBubblePosition(GLMarker.this.bubbleId, latLng);
                    } else {
                        GLMarker.this.mMapCanvas.setMarkerPosition(GLMarker.this.mDisplayId, latLng);
                    }
                }
            });
        }
    }

    public void setFixEnable(boolean z) {
        if (this.isFixPosition != z) {
            this.isFixPosition = z;
        }
    }

    public void setFixPosition(final int i, final int i2) {
        if (this.isFixPosition) {
            if (this.fixPosX != i || this.fixPosY != i2) {
                this.fixPosX = i;
                this.fixPosY = i2;
                set(new RenderTask() {
                    public void run() {
                        if (GLMarker.this.bubbleId <= 0) {
                            GLMarker.this.mMapCanvas.updateMarker(GLMarker.this.mDisplayId, GLMarker.this.center.getLongitude(), GLMarker.this.center.getLatitude(), GLMarker.this.texture != null ? GLMarker.this.texture.getBitmapKey() : "", GLMarker.this.anchorX, GLMarker.this.anchorY, GLMarker.this.scaleX, GLMarker.this.scaleY, GLMarker.this.offsetX, GLMarker.this.offsetY, i, i2, GLMarker.this.angle, GLMarker.this.isClockwise, GLMarker.this.isFlat, GLMarker.this.isFixPosition, GLMarker.this.isFastLoad, GLMarker.this.isAvoidAnno, GLMarker.this.isOrthographicProject, GLMarker.calculateTrueZIndex(GLMarker.this.mLayer, GLMarker.this.zIndex), GLMarker.this.alpha, GLMarker.this.is2DGround, GLMarker.this.groundBounds, GLMarker.this.isClickable());
                        }
                    }
                });
            }
        }
    }

    public void setScreenPosition(final Point point) {
        if (point != null) {
            set(new RenderTask() {
                public void run() {
                    LatLng markerScreenPosition;
                    if (GLMarker.this.bubbleId <= 0 && (markerScreenPosition = GLMarker.this.mMapCanvas.setMarkerScreenPosition(GLMarker.this.mDisplayId, point)) != null) {
                        GLMarker.this.center.set(markerScreenPosition);
                    }
                }
            });
        }
    }

    public LatLng getPosition() {
        return this.center.copyLatLng();
    }

    public float getAnchorX() {
        return this.anchorX;
    }

    public float getAnchorY() {
        return this.anchorY;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public boolean isClockwise() {
        return this.isClockwise;
    }

    public boolean isFlat() {
        return this.isFlat;
    }

    public boolean isFixPosition() {
        return this.isFixPosition;
    }

    public boolean isFastLoad() {
        return this.isFastLoad;
    }

    public boolean isAvoidAnno() {
        return this.isAvoidAnno;
    }

    public boolean isOrthographicProject() {
        return this.isOrthographicProject;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public void setAnchor(final float f, final float f2) {
        if (this.anchorX != f || this.anchorY != f2) {
            this.anchorX = f;
            this.anchorY = f2;
            Texture texture2 = this.texture;
            final String bitmapKey = texture2 != null ? texture2.getBitmapKey() : "";
            set(new RenderTask() {
                public void run() {
                    if (GLMarker.this.bubbleId <= 0) {
                        GLMarker.this.mMapCanvas.setMarkerIconAndAnchor(GLMarker.this.mDisplayId, bitmapKey, f, f2);
                    }
                }
            });
        }
    }

    public void setTexture(Texture texture2) {
        this.texture = texture2;
        final String bitmapKey = texture2 != null ? texture2.getBitmapKey() : "";
        set(new RenderTask() {
            public void run() {
                if (GLMarker.this.bubbleId <= 0) {
                    GLMarker.this.mMapCanvas.setMarkerIconAndAnchor(GLMarker.this.mDisplayId, bitmapKey, GLMarker.this.anchorX, GLMarker.this.anchorY);
                }
            }
        });
    }

    public void setGroundIcon(LatLngBounds latLngBounds, final Texture texture2) {
        this.is2DGround = true;
        this.groundBounds = latLngBounds;
        this.texture = texture2;
        set(new RenderTask() {
            public void run() {
                if (GLMarker.this.bubbleId <= 0) {
                    MapCanvas access$5600 = GLMarker.this.mMapCanvas;
                    int access$5100 = GLMarker.this.mDisplayId;
                    double longitude = GLMarker.this.center.getLongitude();
                    double latitude = GLMarker.this.center.getLatitude();
                    Texture texture = texture2;
                    access$5600.updateMarker(access$5100, longitude, latitude, texture != null ? texture.getBitmapKey() : "", GLMarker.this.anchorX, GLMarker.this.anchorY, GLMarker.this.scaleX, GLMarker.this.scaleY, GLMarker.this.offsetX, GLMarker.this.offsetY, GLMarker.this.fixPosX, GLMarker.this.fixPosY, GLMarker.this.angle, GLMarker.this.isClockwise, GLMarker.this.isFlat, GLMarker.this.isFixPosition, GLMarker.this.isFastLoad, GLMarker.this.isAvoidAnno, GLMarker.this.isOrthographicProject, GLMarker.calculateTrueZIndex(GLMarker.this.mLayer, GLMarker.this.zIndex), GLMarker.this.alpha, GLMarker.this.is2DGround, GLMarker.this.groundBounds, GLMarker.this.isClickable());
                }
            }
        });
    }

    public int getAnchorYHeight(boolean z) {
        float f;
        float f2;
        Texture texture2 = this.texture;
        if (texture2 == null) {
            return 0;
        }
        int rowCount = texture2.getRowCount();
        if (!z) {
            f = (float) rowCount;
            f2 = this.anchorY;
        } else {
            f = (float) rowCount;
            f2 = 1.0f - this.anchorY;
        }
        return (int) (f * f2);
    }

    public boolean isAdded() {
        return super.isAdded();
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        long j = this.bubbleId;
        if (j > 0) {
            this.mBubbleId = (int) j;
            return;
        }
        MapCanvas mapCanvas = this.mMapCanvas;
        double longitude = this.center.getLongitude();
        double latitude = this.center.getLatitude();
        Texture texture2 = this.texture;
        this.mDisplayId = mapCanvas.addMarker(longitude, latitude, texture2 != null ? texture2.getBitmapKey() : "", this.anchorX, this.anchorY, this.scaleX, this.scaleY, this.offsetX, this.offsetY, this.fixPosX, this.fixPosY, this.angle, this.isClockwise, this.isFlat, false, this.isFastLoad, this.isAvoidAnno, this.isOrthographicProject, calculateTrueZIndex(this.mLayer, this.zIndex), this.alpha, this.visible, this.is2DGround, this.groundBounds, isClickable());
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removeMarker(i);
    }

    public void setScreenBoundUpdateRealTime(boolean z) {
        attachToFrame(z);
    }

    public LatLngBounds getGeoBound() {
        float[] screenLocationUnsafe = this.mMapCanvas.toScreenLocationUnsafe(getPosition());
        DoublePoint doublePoint = new DoublePoint((double) screenLocationUnsafe[0], (double) screenLocationUnsafe[1]);
        DoublePoint doublePoint2 = new DoublePoint();
        DoublePoint doublePoint3 = new DoublePoint();
        LatLng latLng = new LatLng(getPosition());
        LatLng latLng2 = new LatLng(getPosition());
        Texture texture2 = this.texture;
        if (texture2 == null) {
            return new LatLngBounds(latLng, latLng2);
        }
        Bitmap bitmap = texture2.getBitmap();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        doublePoint2.f24753x = doublePoint.f24753x;
        doublePoint3.f24753x = doublePoint.f24753x + ((double) width);
        doublePoint2.f24754y = doublePoint.f24754y;
        doublePoint3.f24754y = doublePoint.f24754y + ((double) height);
        int anchorY2 = (int) (getAnchorY() * ((float) height));
        double anchorX2 = (double) ((int) (getAnchorX() * ((float) width)));
        doublePoint2.f24753x -= anchorX2;
        doublePoint3.f24753x -= anchorX2;
        double d = (double) anchorY2;
        doublePoint2.f24754y -= d;
        doublePoint3.f24754y -= d;
        float offsetX2 = getOffsetX();
        float offsetY2 = getOffsetY();
        double d2 = (double) offsetX2;
        doublePoint2.f24753x += d2;
        doublePoint3.f24753x += d2;
        double d3 = (double) offsetY2;
        doublePoint2.f24754y += d3;
        doublePoint3.f24754y += d3;
        return new LatLngBounds(this.mMapCanvas.fromScreenLocationUnsafe((float) doublePoint2.f24753x, (float) doublePoint2.f24754y), this.mMapCanvas.fromScreenLocationUnsafe((float) doublePoint3.f24753x, (float) doublePoint3.f24754y));
    }

    public RectF getPiexBound(float f) {
        DoublePoint latlng2PixelStandardScaleLevel = Tranform2Piex20Utils.latlng2PixelStandardScaleLevel(getPosition(), (DoublePoint) null);
        Bitmap bitmap = this.texture.getBitmap();
        RectF rectF = new RectF();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = ((float) latlng2PixelStandardScaleLevel.f24753x) * f;
        float f3 = ((float) latlng2PixelStandardScaleLevel.f24754y) * f;
        rectF.left = f2;
        float f4 = (float) width;
        rectF.right = f2 + f4;
        float f5 = (float) height;
        rectF.top = f3 - f5;
        rectF.bottom = f3;
        float f6 = (float) ((int) (this.anchorX * f4));
        rectF.left -= f6;
        rectF.right -= f6;
        float f7 = (float) ((int) (this.anchorY * f5));
        rectF.top += f7;
        rectF.bottom += f7;
        float offsetX2 = getOffsetX();
        float offsetY2 = getOffsetY();
        rectF.left += offsetX2;
        rectF.right += offsetX2;
        rectF.top -= offsetY2;
        rectF.bottom -= offsetY2;
        return rectF;
    }

    public RectF getScreenBound() {
        RectF rectF;
        if (isAddToFrameCallback()) {
            synchronized (this.mScreenBound) {
                rectF = this.mScreenBound;
            }
            return rectF;
        }
        Future future = get(new Callable<RectF>() {
            public RectF call() {
                if (GLMarker.this.bubbleId > 0) {
                    return null;
                }
                GLMarker.this.mMapCanvas.calculateMarkerScreenBound(GLMarker.this.mDisplayId, GLMarker.this.mScreenBoundCache);
                return new RectF(GLMarker.this.mScreenBoundCache[0], GLMarker.this.mScreenBoundCache[1], GLMarker.this.mScreenBoundCache[2], GLMarker.this.mScreenBoundCache[3]);
            }
        });
        if (future == null) {
            return null;
        }
        try {
            RectF rectF2 = (RectF) future.get(800, TimeUnit.MILLISECONDS);
            synchronized (this.mScreenBound) {
                this.mScreenBound.set(rectF2);
            }
            return rectF2;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void onFrameFinish(boolean z) {
        if (this.bubbleId <= 0) {
            this.mMapCanvas.calculateMarkerScreenBound(this.mDisplayId, this.mScreenBoundCache);
            synchronized (this.mScreenBound) {
                this.mScreenBound.set(this.mScreenBoundCache[0], this.mScreenBoundCache[1], this.mScreenBoundCache[2], this.mScreenBoundCache[3]);
            }
        } else if (this.listener != null) {
            boolean bubbleRealVisible = this.mMapCanvas.getBubbleRealVisible(this.bubbleId);
            if (this.realVisible != bubbleRealVisible) {
                this.listener.onVisibleChange(bubbleRealVisible, this.bubbleId);
            }
            this.realVisible = bubbleRealVisible;
        }
    }

    public static class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public float anchorX = 0.5f;
        /* access modifiers changed from: private */
        public float anchorY = 0.5f;
        /* access modifiers changed from: private */
        public float angle;
        /* access modifiers changed from: private */
        public long bubbleId;
        /* access modifiers changed from: private */
        public boolean clickable = true;
        /* access modifiers changed from: private */
        public int fixPosX = 0;
        /* access modifiers changed from: private */
        public int fixPosY = 0;
        /* access modifiers changed from: private */
        public LatLngBounds groundBounds;
        /* access modifiers changed from: private */
        public boolean is2DGround = false;
        /* access modifiers changed from: private */
        public boolean isAvoidAnno;
        /* access modifiers changed from: private */
        public boolean isClockwise;
        /* access modifiers changed from: private */
        public boolean isFastLoad = true;
        /* access modifiers changed from: private */
        public boolean isFixPosition;
        /* access modifiers changed from: private */
        public boolean isFlat;
        /* access modifiers changed from: private */
        public boolean isOrthographicProject = false;
        protected double latitude;
        protected double longitude;
        /* access modifiers changed from: private */
        public float offsetX = 0.0f;
        /* access modifiers changed from: private */
        public float offsetY = 0.0f;
        /* access modifiers changed from: private */
        public float scaleX = 1.0f;
        /* access modifiers changed from: private */
        public float scaleY = 1.0f;
        /* access modifiers changed from: private */
        public Texture texture;

        public void setIs2DGround(boolean z) {
            this.is2DGround = z;
        }

        public void setGroundBounds(LatLngBounds latLngBounds) {
            this.groundBounds = latLngBounds;
        }

        public void setPosition(double d, double d2) {
            this.longitude = d;
            this.latitude = d2;
        }

        public void setTexture(Texture texture2) {
            this.texture = texture2;
        }

        public void setAnchor(float f, float f2) {
            this.anchorX = f;
            this.anchorY = f2;
        }

        public void setScale(float f, float f2) {
            this.scaleX = f;
            this.scaleY = f2;
        }

        public void setOffset(float f, float f2) {
            this.offsetX = f;
            this.offsetY = f2;
        }

        public void setAngle(float f) {
            this.angle = f;
        }

        public void setClockwise(boolean z) {
            this.isClockwise = z;
        }

        public void setFlat(boolean z) {
            this.isFlat = z;
        }

        public void setFixPosition(boolean z) {
            this.isFixPosition = z;
        }

        public void setFastLoad(boolean z) {
            this.isFastLoad = z;
        }

        public void setAvoidAnno(boolean z) {
            this.isAvoidAnno = z;
        }

        public void setOrthographicProject(boolean z) {
            this.isOrthographicProject = z;
        }

        public void setBubbleId(long j) {
            this.bubbleId = j;
        }

        public void setClickable(boolean z) {
            this.clickable = z;
        }
    }
}
