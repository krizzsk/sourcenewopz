package com.didi.travel.p171v2.session;

import android.util.SparseArray;

/* renamed from: com.didi.travel.v2.session.SceneContainer */
public class SceneContainer {
    public static final int SCENE_CODE_FUNCTION_TRUE = 1;
    public static final int SCENE_CODE_INVALID = -1;
    public static final int SCENE_CODE_POLL_INNER_APP_BACKGROUND = 101;
    public static final int SCENE_CODE_POLL_TIME_OUT = 102;
    public static final String SCENE_DESC_FUNCTION_TRUE = "";
    public static final String SCENE_DESC_INVALID = "";
    public static final String SCENE_DESC_POLL_INNER_APP_BACKGROUND = "";
    public static final String SCENE_DESC_POLL_TIME_OUT = "";

    /* renamed from: a */
    private static final String f44318a = SceneContainer.class.getSimpleName();

    /* renamed from: b */
    private static final SceneContainer f44319b = new SceneContainer();

    /* renamed from: c */
    private final SparseArray<Scene> f44320c = new SparseArray<>();

    public static SceneContainer getInstance() {
        return f44319b;
    }

    protected SceneContainer() {
        init();
    }

    public void init() {
        register(-1, "");
        register(1, "");
    }

    /* access modifiers changed from: protected */
    public void register(int i, String str) {
        Scene scene = this.f44320c.get(i);
        if (scene == null) {
            this.f44320c.put(i, new Scene(i, str));
            return;
        }
        throw new IllegalStateException(f44318a + ".register:duplicate code register, origin = " + scene + ", code = " + i + ", desc = " + str);
    }

    public Scene getScene(int i) {
        return this.f44320c.get(i);
    }
}
