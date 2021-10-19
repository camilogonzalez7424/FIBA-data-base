package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Import {

    public Import() {

    }

    public void importClients(String path) throws IOException, FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        line = br.readLine();

        while (line != null) {
            String[] parts = line.split(";");

            // Añadir atributos a los arboles

            line = br.readLine();
        }

        br.close();
    }

}
