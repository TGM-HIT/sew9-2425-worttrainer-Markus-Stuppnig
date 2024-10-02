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
        System.out.println("Loading rechtschreibtrainer");
        try (FileInputStream fileIn = new FileInputStream("rechtschreibtrainer.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            System.out.println("Loaded rechtschreibtrainer");
            Rechtschreibtrainer trainer = (Rechtschreibtrainer) in.readObject();
            System.out.println(trainer.getInsgesamt());
            return trainer;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
