package collections.ABB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ABBTest {

    private ABB<String,String> ABBTree;

    private void setUpScenary1() {
        ABBTree = new ABB<>();

    }

    private void setUpScenary2() {
        ABBTree.insert("1", "305");
        ABBTree.insert("2", "35");
        ABBTree.insert("3", "23");
    }

    @Test
    public void testInsert() {
        setUpScenary1();
        ABBTree.insert("4", "5");
        ABBTree.insert("5", "4");
        ABBTree.insert("6", "8");

        assertEquals("[5]",ABBTree.search("4").toString());




    }

    @Test
    public void testSearch() {
        setUpScenary1();
        setUpScenary2();

        assertEquals("[23]", ABBTree.search("3").toString());
        assertEquals("[]",ABBTree.search("8").toString()); //Vacio

    }
/*
    @Test
    public void testRemove() {
        setUpScenary1();
        setUpScenary1();




    }*/



}
