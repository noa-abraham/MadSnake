package juegoViborita;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sonidos {

    private Map<String, byte[]> sonidos;
    private Map<String, Clip> clips;

    public Sonidos() {
        this.sonidos = new HashMap<String, byte[]>();
        clips = new HashMap<>();
    }

    public void agregarSonido(String nombre, String archivo) {
    	try {
    		byte[] fileContent = Files.readAllBytes(Paths.get(Sonidos.class.getClassLoader().getResource(archivo).toURI()));
            sonidos.put(nombre, fileContent);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public void repetirSonido(String sonido) {
        tocarSonido(sonido, true);
    }

    public void tocarSonido(String sonido) {
        tocarSonido(sonido, false);
    }

    private void tocarSonido(String sonido, boolean repetir) {
        try {
        	if(!clips.containsKey(sonido)) {
        		byte[] sonidoEnBytes = sonidos.get(sonido);
                InputStream myInputStream = new ByteArrayInputStream(sonidoEnBytes);
                AudioInputStream ais = AudioSystem.getAudioInputStream(myInputStream);
                DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.open(ais);
                if (repetir) {
                	clip.loop(Clip.LOOP_CONTINUOUSLY);
                	clips.put(sonido, clip);
                } else {
                    clip.start();
                }
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    //Para sonido y lo elimina del mapa
    public void pararSonido(String sonido) {
        try {
        	Clip clip = clips.get(sonido);
        	clip.stop();
        	clips.remove(sonido);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}