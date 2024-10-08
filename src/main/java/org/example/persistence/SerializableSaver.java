package org.example.persistence;

import org.example.model.Rechtschreibtrainer;

import java.io.*;

/**
 * @author Markus Stuppnig
 * @version 2024-10-02
 * Diese Klasse implementiert die Speicherstrategie Methoden "saveModel" und "loadModel" mit dem Serializable approach.
 */
public class SerializableSaver implements Speicherstrategie {
    @Override
    public void saveModel(Rechtschreibtrainer rechtschreibtrainer) {
        try (FileOutputStream fileOut = new FileOutputStream("rechtschreibtrainer.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(rechtschreibtrainer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Rechtschreibtrainer loadModel() {
        try (FileInputStream fileIn = new FileInputStream("rechtschreibtrainer.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Rechtschreibtrainer trainer = (Rechtschreibtrainer) in.readObject();
            return trainer;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
