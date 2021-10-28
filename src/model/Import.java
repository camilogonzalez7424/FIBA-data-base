package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Import {

    public Import() {

    }

    public void importPlayer(String path, ArrayList<Player> list) throws IOException, FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(";");

            Player temp = new Player(parts[0], parts[1], Integer.parseInt(parts[2]),
                    Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
                    Integer.parseInt(parts[6]),Integer.parseInt(parts[7]));

            // Añadir atributos a los arboles
            list.add(temp);
            line = br.readLine();
        }

        br.close();
    }

}
