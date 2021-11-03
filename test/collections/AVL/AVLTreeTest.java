package collections.AVL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTest {
    private AVLTree<Integer,Integer> treeAVL;

    private void setUpScenery1() {
        treeAVL = new AVLTree<>();
    }

    private void setUpScenery2() {
        treeAVL.add(10, null);
        treeAVL.add(5, null);
        treeAVL.add(6, null);
        treeAVL.add(3, null);
        treeAVL.add(4, null);
        treeAVL.add(7, null);
        treeAVL.add(15, 7);
        treeAVL.add(12, null);
        treeAVL.add(17, null);
        treeAVL.add(16, null);
    }


    @Test
    public void testAdd() {
        setUpScenery1();
        treeAVL.add(10, 20);
        assertEquals(1,treeAVL.size());
        treeAVL.add(11, 20);
        treeAVL.add(12, 20);
        treeAVL.add(13, 20);

        assertTrue(treeAVL.getRoot().isBalanced());
        assertEquals(4,treeAVL.size());
        assertEquals(3,treeAVL.getRoot().getHeight());
        assertEquals(10,treeAVL.getRoot().getLeft().getKey());
    }




    @Test
    public void testRemove() {
        setUpScenery1();
        setUpScenery2();

        assertEquals(10,treeAVL.size());
        assertEquals(7,treeAVL.find(15));

        treeAVL.remove(15);
        assertNull(treeAVL.find(15));
    }


    @Test
    void testSearch() {
        setUpScenery1();
        setUpScenery2();

        assertEquals(7,treeAVL.find(15));
        assertNull(treeAVL.find(32));
    }

    @Test
    public void testIsEmpty() {
        setUpScenery1();
        assertTrue(treeAVL.isEmpty());
        treeAVL.add(2, 404);
        assertFalse(treeAVL.isEmpty());
    }

    @Test
    public void testKeyExists() {
        setUpScenery1();
        treeAVL.add(2, 404);
        treeAVL.add(3, 202);
        assertFalse(treeAVL.keyExists(6));
        assertTrue(treeAVL.keyExists(2));
    }
}
