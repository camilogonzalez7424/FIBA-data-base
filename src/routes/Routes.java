package routes;

public enum Routes{

    MAIN_VIEW("../ui/assets/main.fxml");

    private String route;

    private Routes(String route){
        this.route = route;
    }

    //Getters and Setters
    
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

}