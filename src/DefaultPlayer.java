public class DefaultPlayer implements IPlayer {
    private AdapterPlayer adapterPlayer;

    public DefaultPlayer() {
        adapterPlayer = new AdapterPlayer();
    }

    @Override
    public void play(String filePath) {
        adapterPlayer.play(filePath);
    }

    @Override
    public void stop() {
        adapterPlayer.stop();
    }
}
