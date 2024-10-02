package org.example.model;

import java.io.Serializable;
import java.net.URL;

/**
 * @author Markus Stuppnig
 * @version 2024-10-02
 * Ein Wortpaar bestehend aus einem Wort und einer URL zu einem Bild welches dieses Wort repräsentiert
 */
public class Wortpaar implements Serializable {

    private String url;
    private String wort;

    public Wortpaar(String url, String wort) {
        setUrl(url);
        setWort(wort);
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        if(url == null) {
            throw new IllegalArgumentException("url is null");
        }
        try {
            new URL(url).toURI();
            this.url = url;
        } catch (Exception e) {
            throw new IllegalArgumentException("url '" + url + "' is not a valid URL");
        }
    }

    public String getWort() {
        return wort;
    }
    public void setWort(String wort) {
        if(wort == null) {
            throw new IllegalArgumentException("wort must not be null");
        }
        this.wort = wort;
    }
}
