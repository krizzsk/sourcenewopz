package p242io.flutter.plugin.mouse;

import android.view.PointerIcon;
import java.util.HashMap;
import p242io.flutter.embedding.engine.systemchannels.MouseCursorChannel;

/* renamed from: io.flutter.plugin.mouse.MouseCursorPlugin */
public class MouseCursorPlugin {

    /* renamed from: c */
    private static HashMap<String, Integer> f57844c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final MouseCursorViewDelegate f57845a;

    /* renamed from: b */
    private final MouseCursorChannel f57846b;

    /* renamed from: io.flutter.plugin.mouse.MouseCursorPlugin$MouseCursorViewDelegate */
    public interface MouseCursorViewDelegate {
        PointerIcon getSystemPointerIcon(int i);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public MouseCursorPlugin(MouseCursorViewDelegate mouseCursorViewDelegate, MouseCursorChannel mouseCursorChannel) {
        this.f57845a = mouseCursorViewDelegate;
        this.f57846b = mouseCursorChannel;
        mouseCursorChannel.setMethodHandler(new MouseCursorChannel.MouseCursorMethodHandler() {
            public void activateSystemCursor(String str) {
                MouseCursorPlugin.this.f57845a.setPointerIcon(MouseCursorPlugin.this.m41584a(str));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PointerIcon m41584a(String str) {
        if (f57844c == null) {
            f57844c = new HashMap<String, Integer>() {
                private static final long serialVersionUID = 1;

                {
                    put("alias", 1010);
                    put("allScroll", 1013);
                    put("basic", 1000);
                    put("cell", 1006);
                    put("click", 1002);
                    put("contextMenu", 1001);
                    put("copy", 1011);
                    put("forbidden", 1012);
                    put("grab", 1020);
                    put("grabbing", 1021);
                    put("help", 1003);
                    put("move", 1013);
                    put("none", 0);
                    put("noDrop", 1012);
                    put("precise", 1007);
                    put("text", 1008);
                    put("resizeColumn", 1014);
                    put("resizeDown", 1015);
                    put("resizeUpLeft", 1016);
                    put("resizeDownRight", 1017);
                    put("resizeLeft", 1014);
                    put("resizeLeftRight", 1014);
                    put("resizeRight", 1014);
                    put("resizeRow", 1015);
                    put("resizeUp", 1015);
                    put("resizeUpDown", 1015);
                    put("resizeUpLeft", 1017);
                    put("resizeUpRight", 1016);
                    put("resizeUpLeftDownRight", 1017);
                    put("resizeUpRightDownLeft", 1016);
                    put("verticalText", 1009);
                    put("wait", 1004);
                    put("zoomIn", 1018);
                    put("zoomOut", 1019);
                }
            };
        }
        return this.f57845a.getSystemPointerIcon(f57844c.getOrDefault(str, 1000).intValue());
    }

    public void destroy() {
        this.f57846b.setMethodHandler((MouseCursorChannel.MouseCursorMethodHandler) null);
    }
}
