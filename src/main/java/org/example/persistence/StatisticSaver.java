package org.example.persistence;
import org.example.model.Rechtschreibtrainer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StatisticSaver {

    public static void saveModel(Rechtschreibtrainer rechtschreibtrainer) {
        try (FileOutputStream fileOut = new FileOutputStream("rechtschreibtrainer.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(rechtschreibtrainer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
