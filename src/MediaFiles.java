import java.io.File;

public class MediaFiles {
    public static File[] getMedia() {
        // Thêm mã để lấy và trả về danh sách tệp nhạc từ một thư mục nhất định
        // Ví dụ:
        File folder = new File("C:\\Users\\admin\\Music");
        return folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3"));
    }
}
