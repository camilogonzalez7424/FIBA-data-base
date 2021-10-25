package model;

public enum DataStructure {
    LINEAL("Lineal Array"), ABB("Binary Search Tree"), AVL("AVL Tree"), RB("Red Black Tree"); 

    private String route;

    private DataStructure(String route){
        this.route = route;
    }

    //Getters and Setters
    
    public String getDataStructure() {
        return route;
    }

}
