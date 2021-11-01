package collections.AVL;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeNodeTest {

    private AVLTreeNode<Integer,Integer> treeAVL;

    private void setup1() {
        treeAVL = new AVLTreeNode<Integer, Integer>(10, 100, null);
    }

    @Test
    public void testAdd() {
        setup1();
        treeAVL.add(3, 4);
        assertEquals(3,treeAVL.getLeft().getKey());

        treeAVL.add(15, 10);
        assertEquals(15,treeAVL.getRight().getKey());

        assertEquals(2,treeAVL.getHeight());

        treeAVL.add(17, 2);
        treeAVL.add(22,22);
        assertEquals(4,treeAVL.getHeight());
    }

    @Test
    public void testRemove() {
        setup1();

        treeAVL.add(8, 22);
        treeAVL.add(15, 33);

        assertEquals(15,treeAVL.getRight().getKey());
        treeAVL.remove(15);

        assertNull(treeAVL.getRight());
        assertEquals(0,treeAVL.getRightHeight());

        treeAVL.remove(8);
        assertEquals(1,treeAVL.getHeight());
        assertNull(treeAVL.getLeft());
    }

    @Test
    public void testSearch() {
        setup1();
        treeAVL.add(22, 20);
        treeAVL.add(32, 9);
        treeAVL.add(199, 81);

        assertNull(treeAVL.search(100));
        assertEquals(81,treeAVL.search(199).getValue());
    }


    @Test
    public void testLeftRotate() {
        setup1();
        treeAVL.add(14, 2);
        treeAVL.add(15, 3);
        treeAVL.add(16, 4);

        treeAVL.getRight().leftRotate();
        assertEquals(15,treeAVL.getRight().getKey());
        assertEquals(2,treeAVL.getRight().getHeight());
        assertEquals(1,treeAVL.search(14).getHeight());

    }

    @Test
    public void testRightRotate() {
        setup1();
        treeAVL.add(11, null);
        treeAVL.add(10, null);
        treeAVL.add(9, null);

        treeAVL.getLeft().rightRotate();
        assertEquals(9,treeAVL.getLeft().getKey());
        assertEquals(2,treeAVL.getLeft().getHeight());
        assertEquals(2,treeAVL.search(9).getHeight());

    }

    @Test
    public void testBalance() {
        setup1();
        treeAVL.add(12, null);
        treeAVL.add(10, null);
        treeAVL.add(8, null);
        treeAVL.add(5, null);

        assertFalse(treeAVL.getLeft().isBalanced());

        treeAVL.getLeft().balance();
        assertTrue(treeAVL.getLeft().isBalanced());

    }
}
