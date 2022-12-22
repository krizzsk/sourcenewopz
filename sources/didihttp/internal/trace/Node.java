package didihttp.internal.trace;

import didihttp.Interceptor;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public List<Node> children = new ArrayList();
    public long cost;
    public long endTime;
    public Node parent;
    public long startTime;
    public Interceptor value;
}
