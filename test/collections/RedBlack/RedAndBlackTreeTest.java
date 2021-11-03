package collections.RedBlack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedAndBlackTreeTest {

    private RedAndBlackTree<Integer, String> treeRB;

    private void setup1() {
        treeRB = new RedAndBlackTree<>();
    }

    @Test
    public void testInsert() {
        setup1();
        treeRB.insert(10, "1");
        treeRB.insert(12, "2");
        treeRB.insert(15, "3");
        treeRB.insert(5, "4");
        treeRB.insert(6, "5");

        assertEquals("[1]",treeRB.search(10).toString());
        assertEquals("[2]",treeRB.search(12).toString());
        assertEquals("[3]",treeRB.search(15).toString());
        assertEquals("[4]",treeRB.search(5).toString());
        assertEquals("[5]",treeRB.search(6).toString());


    }

    @Test
    public void testSearch() {
        setup1();
        treeRB.insert(12, "2");
        treeRB.insert(5, "7");
        treeRB.insert(6, "9");
        treeRB.insert(77, "4");

        assertEquals("[2]", treeRB.search(12).toString());
        assertEquals("[9]", treeRB.search(6).toString());
    }

    @Test
    public void testRemove(){
        setup1();
        treeRB.insert(12, "2");
        treeRB.insert(5, "7");

        treeRB.delete(5);

        assertEquals("[]",treeRB.search(5).toString());

    }


}
