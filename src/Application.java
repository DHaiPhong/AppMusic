public class Application {
    private static Application app = null;
    private DefaultPlayer player;

    private Application() {
        player = new DefaultPlayer();
    }

    public static Application getInstance() {
        if (app == null) {
            app = new Application();
        }
        return app;
    }

    public void play(String filePath) {
        player.play(filePath);
    }

    public void stop() {
        player.stop();
    }

    public void start() {
        // Thêm mã để bắt đầu ứng dụng, ví dụ khởi chạy giao diện người dùng
    }
}
