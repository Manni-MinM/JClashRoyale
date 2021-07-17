package JClashRoyale.Model;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;
import javax.sound.sampled.LineEvent.Type;


public class SoundSystem {
    static SimpleAudioPlayer maintheme;
    private static AudioInputStream audioStream;

    public static void mouseClickSFX() {
        if (!App.sfx)
            return;
        try {
            InputStream audioSrc = SoundSystem.class.getResourceAsStream("/JClashRoyale/assets/sfx/click.wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            SimpleAudioPlayer simpleAudioPlayer = new SimpleAudioPlayer(audioStream);
            simpleAudioPlayer.start();
        } catch (UnsupportedAudioFileException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cardSwapSFX() {
        if (!App.sfx)
            return;
        try {
            InputStream audioSrc = SoundSystem.class.getResourceAsStream("/JClashRoyale/assets/sfx/card_swap.wav");
            assert audioSrc != null;
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            SimpleAudioPlayer simpleAudioPlayer = new SimpleAudioPlayer(audioStream);
            simpleAudioPlayer.start();
        } catch (UnsupportedAudioFileException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mainMenuTheme() {
        if (!App.sfx)
            return;
        try {
            InputStream audioSrc = SoundSystem.class.getResourceAsStream("/JClashRoyale/assets/sfx/menu_theme.wav");
            assert audioSrc != null;
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            maintheme = new SimpleAudioPlayer(audioStream);
            maintheme.start();
        } catch (UnsupportedAudioFileException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateMusic() {
        if (!App.music)
            maintheme.interrupt();
        else mainMenuTheme();
    }


    /**
     * This class allows to play a *.wav sound in a thread. You just have to give it
     * an {@link AudioInputStream} and then start the thread. It will play the
     * sound, and the thread will be stopped at the end of the sound.
     * <p>
     * Using a particular thread allows to do some other job while playing the
     * sound.
     *
     * @author Amir Iravanimanesh & Manni Moghimi
     */
    static class SimpleAudioPlayer extends Thread {

        /**
         * The {@link AudioInputStream} linked to the sound to play
         */
        private final AudioInputStream audioInputStream;

        /**
         * A custom listener in order to be notified at the end of the audio file
         * playing
         */
        private final AudioListener listener = new AudioListener();


        /**
         * Constructor. You can create an {@link AudioInputStream} with: {@link
         *
         * @param audioInputStream The {@link AudioInputStream} linked to the sound to play. You            can create an {@link AudioInputStream} using the            {@link AudioSystem} object.
         * @link AudioSystem#getAudioInputStream(java.io.File)}* ,
         * {@link AudioSystem#getAudioInputStream(java.io.InputStream)},
         * {@link AudioSystem#getAudioInputStream(java.net.URL)}
         */
        public SimpleAudioPlayer(AudioInputStream audioInputStream) {
            super();
            this.audioInputStream = audioInputStream;
        }

        /**
         * This method allows to actually play the sound provided from the
         * {@link #audioInputStream}
         *
         * @throws LineUnavailableException if the {@link Clip} object can't be created
         * @throws IOException              if the audio file can't be find
         */
        protected void play() throws LineUnavailableException, IOException, InterruptedException {
            Clip clip = AudioSystem.getClip();

            handleClip(clip);
        }

        private void handleClip(Clip clip) throws LineUnavailableException, IOException {
            try (clip) {
                clip.addLineListener(listener);
                clip.open(audioInputStream);
                clip.start();
                if (audioInputStream.equals(audioStream))
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                listener.waitUntilDone();
            } catch (InterruptedException e) {
                if (App.music) {
                    System.out.println("KIR");
                    handleClip(clip);
                } else clip.stop();

            }
            audioInputStream.close();
        }

        /**
         * This method allows to play the sound while running the Thread
         */
        @Override
        public void run() {
            try {
                this.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * This Listener allows to notify when the play of the sound is ended
         */
        class AudioListener implements LineListener {
            private boolean done = false;

            /**
             * This method allows to be notified for each event while playing a
             * sound
             */
            @Override
            public synchronized void update(LineEvent event) {
                Type eventType = event.getType();
                if (eventType == Type.STOP || eventType == Type.CLOSE) {
                    done = true;
                    notifyAll();
                }
            }

            /**
             * This method allows to wait until a sound is completly played
             *
             * @throws InterruptedException as we work with thread, this exception can occur
             */
            public synchronized void waitUntilDone() throws InterruptedException {
                while (!done) {
                    wait();
                }
            }
        }

    }
}



