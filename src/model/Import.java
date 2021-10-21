package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Import {

    public Import() {

    }

    public void importPlayer(String path) throws IOException, FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(";");

            Player temp = new Player(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                    Integer.parseInt(parts[7]),Integer.parseInt(parts[8]));

            // Añadir atributos a los arboles

            line = br.readLine();
        }

        br.close();
    }

    public void importSelected(String path, ArrayList<Long> indexes) throws IOException, FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(";");
            boolean needed = false;
            
            for (Long index : indexes) {
                if(index == Integer.parseInt(parts[0])){
                    needed = true;
                } else {
                    needed = false;
                }
            }
            if(needed){
                Player temp = new Player(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                    Integer.parseInt(parts[7]), Integer.parseInt(parts[8]));

            // Añadir al resultado del query
            }

            line = br.readLine();
        }

        br.close();
    }

}
