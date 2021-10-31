package routes;

public enum Routes{

    SEARCH_VIEW("../ui/searchView.fxml"), RESULT_VIEW("../ui/resultView.fxml"), ADD_VIEW("../ui/addView.fxml"), 
    STYLE("../ui/assets/style/style.css"), LOADING("../ui/loading.fxml"),; 

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