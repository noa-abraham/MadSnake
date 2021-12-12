package juegoViborita;

import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonidos {

    private Clip clip;

    public Sonidos(String s) {

        try {
            AudioInputStream Audio = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));
            AudioFormat baseFormat = Audio.getFormat();
            AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(),
                    16, baseFormat.getChannels(),baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
            AudioInputStream DAudio = AudioSystem.getAudioInputStream(decodeFormat, Audio);
            clip = AudioSystem.getClip();
            clip.open(DAudio);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}