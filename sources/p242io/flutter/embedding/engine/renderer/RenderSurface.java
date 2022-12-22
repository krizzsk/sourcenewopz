package p242io.flutter.embedding.engine.renderer;

/* renamed from: io.flutter.embedding.engine.renderer.RenderSurface */
public interface RenderSurface {
    void attachToRenderer(FlutterRenderer flutterRenderer);

    void detachFromRenderer();

    FlutterRenderer getAttachedRenderer();

    void pause();
}
