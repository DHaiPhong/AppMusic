import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.start(); // Khởi chạy ứng dụng

        // Lấy danh sách các tệp nhạc
        File[] mediaFiles = MediaFiles.getMedia();

        // Kiểm tra xem có tệp nhạc nào không
        if (mediaFiles.length > 0) {
            // Hiển thị danh sách các tệp nhạc
            System.out.println("Select the media file you want to play:");
            for (int i = 0; i < mediaFiles.length; i++) {
                System.out.println((i + 1) + ". " + mediaFiles[i].getName());
            }
            System.out.println("------");
            System.out.println("0. Stop");

            // Nhận lựa chọn của người dùng
            Scanner scanner = new Scanner(System.in);
            int userChoice = -1;

            Thread playerThread = null;

            while (userChoice != 0) {
                System.out.print("Enter your choice: ");
                userChoice = scanner.nextInt();

                if (userChoice >= 1 && userChoice <= mediaFiles.length) {
                    // Dừng bài hát hiện đang chơi
                    if (playerThread != null && playerThread.isAlive()) {
                        app.stop();
                        playerThread.interrupt();
                    }

                    // Phát bài hát được chọn bởi người dùng
                    String selectedSongPath = mediaFiles[userChoice - 1].getPath();
                    String selectedSongName = mediaFiles[userChoice - 1].getName();

                    System.out.println("Now is playing '" + selectedSongName + "'"); // Thêm dòng thông báo

                    playerThread = new Thread(() -> {
                        app.play(selectedSongPath);
                    });
                    playerThread.start();
                } else if (userChoice != 0) {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

            // Dừng bài hát hiện đang chơi
            if (playerThread != null && playerThread.isAlive()) {
                app.stop();
                playerThread.interrupt();
            }

            scanner.close();
        } else {
            System.out.println("No media files found.");
        }
    }
}
