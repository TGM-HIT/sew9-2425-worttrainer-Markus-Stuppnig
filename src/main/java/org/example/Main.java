package org.example;

import org.example.gui.JOptionView;
import org.example.model.Rechtschreibtrainer;
import org.example.model.Wortpaar;
import org.example.persistence.SerializableSaver;
import org.example.persistence.StatisticSaver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        Wortpaar wortpaar1 = new Wortpaar("https://biberberti.com/wp-content/uploads/2021/08/04-px-alter-Baum.jpg", "Baum");
        Wortpaar wortpaar2 = new Wortpaar("https://www.schluesseldienst-muenchen.de/wp-content/uploads/2024/03/Tuer.webp", "Tür");
        Wortpaar wortpaar3 = new Wortpaar("https://static.spektrum.de/fm/912/f2000x857/iStock-832833550.jpg", "Mond");
        Wortpaar wortpaar4 = new Wortpaar("https://www.futura-sciences.com/de/wp-content/uploads/2021/10/definition-von-feuer.jpg", "Feuer");
        Wortpaar wortpaar5 = new Wortpaar("https://www.tierschutzbund.de/fileadmin/_processed_/7/c/csm_schwarzer_Hund_auf_Wiese_c_xkunclova-Shutterstock_01_f2d4be8ef4.jpg", "Hund");
        Wortpaar wortpaar6 = new Wortpaar("https://images.pexels.com/photos/56832/road-asphalt-space-sky-56832.jpeg?cs=srgb&dl=pexels-pixabay-56832.jpg&fm=jpg", "Straße");
        Wortpaar wortpaar7 = new Wortpaar("https://www.mayspies.at/out/pictures/master/product/3/buetten-papiere-handgerissen-buettenraender-hadernhaltig-210-x-297-mm-A4_B1031770005.jpg", "Papier");
        Wortpaar wortpaar8 = new Wortpaar("https://images.twinkl.co.uk/tw1n/image/private/t_630/u/ux/pc_ver_1.png", "Maus");
        Wortpaar wortpaar9 = new Wortpaar("https://image.geo.de/30085442/t/Op/v3/w1440/r1.3333/-/wolke-herz-gross-jpg--41028-.jpg", "Wolke");
        Wortpaar wortpaar10 = new Wortpaar("https://www.allnatura.at/bild/configurator/data/product/33/_cache/_lg/1_600__2_600_611__3_621__4_621_618.webp", "Tisch");

        SerializableSaver saver = new SerializableSaver();
        Rechtschreibtrainer rechtschreibtrainer = StatisticSaver.loadModel(saver);

        if(rechtschreibtrainer == null) {
            System.out.println("is nul");
            rechtschreibtrainer = new Rechtschreibtrainer();

            rechtschreibtrainer.addWortpaar(wortpaar1);
            rechtschreibtrainer.addWortpaar(wortpaar2);
            rechtschreibtrainer.addWortpaar(wortpaar3);
            rechtschreibtrainer.addWortpaar(wortpaar4);
            rechtschreibtrainer.addWortpaar(wortpaar5);
            rechtschreibtrainer.addWortpaar(wortpaar6);
            rechtschreibtrainer.addWortpaar(wortpaar7);
            rechtschreibtrainer.addWortpaar(wortpaar8);
            rechtschreibtrainer.addWortpaar(wortpaar9);
            rechtschreibtrainer.addWortpaar(wortpaar10);
        }

        JOptionView view = new JOptionView();

        boolean vorherigerVersuchExistent = false;
        boolean vorherigerVersuchErgebnis = false;

        while(true) {
            rechtschreibtrainer.waehleRandomWortpaar();

            Image image;
            try {
                System.out.println(rechtschreibtrainer.getBildURL());
                image = ImageIO.read(new URL(rechtschreibtrainer.getBildURL()));
                image = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Icon icon = new ImageIcon(image);

            Object input = view.nextWort(icon, (vorherigerVersuchExistent ? (vorherigerVersuchErgebnis ? "RICHTIG! " : "FALSCH! ") : "") + "Bisher Richtig: " + rechtschreibtrainer.getRichtig() + "/" + rechtschreibtrainer.getInsgesamt() + ". Wie schreibt man das?");

            if(input == null || ((String) input).equals("")) break;

            if(((String) input).equals(rechtschreibtrainer.getWort())) {
                rechtschreibtrainer.setRichtig(rechtschreibtrainer.getRichtig() + 1);
                vorherigerVersuchErgebnis = true;
            }else {
                vorherigerVersuchErgebnis = false;
            }
            rechtschreibtrainer.setInsgesamt(rechtschreibtrainer.getInsgesamt() + 1);

            vorherigerVersuchExistent = true;
        }

        boolean saveModel = view.showSaveModelDialogue();
        if(saveModel) {
            StatisticSaver.saveModel(saver, rechtschreibtrainer);
        }
    }
}