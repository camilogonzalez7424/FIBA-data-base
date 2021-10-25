package model;

import java.util.ArrayList;

public class Query {
    
    

    public interface queryListener {
        public void onResult(ArrayList<Player> result);
    }
}
