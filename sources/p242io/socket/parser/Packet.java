package p242io.socket.parser;

/* renamed from: io.socket.parser.Packet */
public class Packet<T> {
    public int attachments;
    public T data;

    /* renamed from: id */
    public int f59554id = -1;
    public String nsp;
    public String query;
    public int type = -1;

    public Packet() {
    }

    public Packet(int i) {
        this.type = i;
    }

    public Packet(int i, T t) {
        this.type = i;
        this.data = t;
    }
}
