import java.io.File;

public class FileSearcher {
    public static void search(File file, String keyword) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                search(f, keyword);
            }
        } else {
            if (file.getName().contains(keyword)) {
                System.out.println("Found: " + file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File root = new File(".");
        search(root, "java");
    }
}
