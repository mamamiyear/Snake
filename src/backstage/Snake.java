package backstage;

import gui.EngineNode;

import java.util.LinkedList;

/**
 * @author mamamiyear
 *         on 16-1-4.
 */
public class Snake extends LinkedList<EngineNode> {

    EngineNode head = new EngineNode();

    public Snake() {

        this.offer(head);
        this.offer(new EngineNode());
        this.offer(new EngineNode());

    }

}
