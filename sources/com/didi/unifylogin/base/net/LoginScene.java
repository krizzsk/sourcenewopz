package com.didi.unifylogin.base.net;

public enum LoginScene {
    SCENE_DELETE_ACCOUNT(-10000),
    SCENE_UNDEFINED(-1),
    SCENE_LOGIN(0),
    SCENE_CODE_LOGIN(1),
    SCENE_PWD_LOGIN(2),
    SCENE_THIRD_LOGIN(3),
    SCENE_FORGETPWD(4),
    SCENE_RESET_PWD(5),
    SCENE_SET_PHONE(6),
    SCENE_RETRIEVE(7),
    SCENE_CANCEL(8),
    SCENE_LOGINOUT(9),
    SCENE_RESET_EMAIL(10),
    SCENE_CHANGE_PHONE_WITH_CODE(12),
    SCENE_FACE_LOGIN(13),
    SCENE_CHANGE_PHONE_BY_ID(14);
    
    private int sceneNum;

    private LoginScene(int i) {
        this.sceneNum = i;
    }

    public int getSceneNum() {
        return this.sceneNum;
    }
}
