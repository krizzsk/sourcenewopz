package com.jumio.commons.camera;

import com.jumio.commons.PersistWith;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0002\u001a\u00020\u0000J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0017\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, mo175978d2 = {"Lcom/jumio/commons/camera/PreviewProperties;", "Ljava/io/Serializable;", "copy", "", "toString", "Lcom/jumio/commons/camera/Size;", "scaledPreview", "Lcom/jumio/commons/camera/Size;", "surface", "preview", "camera", "", "frontFacing", "Z", "", "orientation", "I", "sensorRotation", "isPortrait", "previewFormat", "", "getScaleFactor", "()F", "scaleFactor", "<init>", "()V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("PreviewProperties")
/* compiled from: PreviewProperties.kt */
public final class PreviewProperties implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Size camera = new Size(0, 0);
    public boolean frontFacing;
    public boolean isPortrait;
    public int orientation;
    public Size preview = new Size(0, 0);
    public int previewFormat = 17;
    public Size scaledPreview = new Size(0, 0);
    public int sensorRotation;
    public Size surface = new Size(0, 0);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo175978d2 = {"Lcom/jumio/commons/camera/PreviewProperties$Companion;", "", "", "serialVersionUID", "J", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: PreviewProperties.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final PreviewProperties copy() {
        PreviewProperties previewProperties = new PreviewProperties();
        Size copy = this.scaledPreview.copy();
        Intrinsics.checkNotNullExpressionValue(copy, "scaledPreview.copy()");
        previewProperties.scaledPreview = copy;
        Size copy2 = this.surface.copy();
        Intrinsics.checkNotNullExpressionValue(copy2, "surface.copy()");
        previewProperties.surface = copy2;
        Size copy3 = this.preview.copy();
        Intrinsics.checkNotNullExpressionValue(copy3, "preview.copy()");
        previewProperties.preview = copy3;
        Size copy4 = this.camera.copy();
        Intrinsics.checkNotNullExpressionValue(copy4, "camera.copy()");
        previewProperties.camera = copy4;
        previewProperties.frontFacing = this.frontFacing;
        previewProperties.orientation = this.orientation;
        previewProperties.sensorRotation = this.sensorRotation;
        previewProperties.isPortrait = this.isPortrait;
        previewProperties.previewFormat = this.previewFormat;
        return previewProperties;
    }

    public final float getScaleFactor() {
        return ((float) this.scaledPreview.width) / ((float) this.preview.width);
    }

    public String toString() {
        return StringsKt.trimMargin$default("\n\t\t\t| scaledPreview: (" + this.scaledPreview.width + ',' + this.scaledPreview.height + ")\n\t\t\t| surface: (" + this.surface.width + ',' + this.surface.height + ")\n\t\t\t| preview: (" + this.preview.width + ',' + this.preview.height + ")\n\t\t\t| camera: (" + this.camera.width + ',' + this.camera.height + ")\n\t\t\t| frontFacing: " + this.frontFacing + "\n\t\t\t| orientation: " + this.orientation + "\n\t\t\t| sensorRotation: " + this.sensorRotation + "\n\t\t\t| isPortrait: " + this.isPortrait + "\n\t\t\t| previewFormat: " + this.previewFormat + "\n\t\t", (String) null, 1, (Object) null);
    }
}
