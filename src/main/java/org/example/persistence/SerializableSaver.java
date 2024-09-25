package org.example.persistence;

import org.example.model.Rechtschreibtrainer;

import java.io.*;

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
            Rechtschreibtrainer person = (Rechtschreibtrainer) in.readObject();
            return person;
        } catch (IOException | ClassNotFoundException e) {
        }finally {
            return null;
        }
    }
}
