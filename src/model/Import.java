package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Import implements Serializable {

    private static final long serialVersionUID = 4777743;

    private App app;
    private listener listener;

    public Import(App app) {
        this.app = app;
    }

    public void importPlayer(String path, ArrayList<Player> list) throws IOException, FileNotFoundException {

        listener.onInit();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();

        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(";");
            
            Player temp = new Player(parts[0], Integer.parseInt(parts[1]), parts[2], Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                    Integer.parseInt(parts[7]));

            // Añadir atributos a los arboles
            list.add(temp);

            app.getPointsABB().insert(temp.getPoints(), temp);
            //app.getPointsRB().insert(temp.getPoints(), temp);

            app.getAssistsABB().insert(temp.getAssists(), temp);
            app.getAssistsAVL().add(temp.getAssists(), temp);

            app.getReboundsABB().insert(temp.getRebounds(), temp);
            app.getReboundsAVL().add(temp.getRebounds(), temp);

            app.getStealsABB().insert(temp.getSteals(), temp);
            app.getStealsAVL().add(temp.getSteals(), temp);

            line = br.readLine();
        }

        br.close();
        System.out.println("-------------------------Termino");
        //Platform.runLater(()->{
        listener.onLoad();
        //});
        
    }

    public interface listener {
        public void onLoad();
        public void onInit();
    }

    public listener getListener() {
        return listener;
    }

    public void setListener(listener listener) {
        this.listener = listener;
    }

    
}
