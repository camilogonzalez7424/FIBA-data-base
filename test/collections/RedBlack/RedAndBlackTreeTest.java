package collections.RedBlack;

public class RedAndBlackTreeTest {

    private RedAndBlackTree<Integer, Integer> treeRB;

    private void setup1() {
        treeRB = new RedAndBlackTree<>();
    }
/*
    @Test
    public void testInsert() {
        setup1();
        assertEquals(0,treeRB.size());
        treeRB.insert(10, 1);
        treeRB.insert(12, 2);
        treeRB.insert(15, 3);
        treeRB.insert(5, 4);
        treeRB.insert(6, 5);

        assertEquals(1,treeRB.searchValue(10));
        assertEquals(2,treeRB.searchValue(12));
        assertEquals(3,treeRB.searchValue(15));
        assertEquals(4,treeRB.searchValue(5));
        assertEquals(5,treeRB.searchValue(6));
        assertNull(treeRB.searchValue(21));

    }

    @Test
    public void testSearch() {
        setup1();
        treeRB.insert(12, 2);
        treeRB.insert(5, 7);
        treeRB.insert(6, 9);
        treeRB.insert(77, 4);

        assertEquals(2, treeRB.searchValue(12));
        assertEquals(9, treeRB.searchValue(6));
        assertNull(treeRB.searchValue(21));
    }*/
}
