package global.didi.pay.model;

public enum LoadingState {
    TYPE_LOADING(1),
    TYPE_REFRESHING(2),
    TYPE_PAYING(3),
    TYPE_WAITING(4),
    TYPE_SUCCESS5(5),
    TYPE_PIX(6);
    
    public int type;

    private LoadingState(int i) {
        this.type = i;
    }
}
