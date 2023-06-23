import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class AdapterPlayer {
    private Player player;
    private FileInputStream fis;

    public AdapterPlayer() {
        player = null;
        fis = null;
    }

    public void play(String filePath) {
        try {
            fis = new FileInputStream(filePath);
            player = new Player(fis);
            player.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void stop() {
        if (player != null) {
            player.close();
        }
    }
}
