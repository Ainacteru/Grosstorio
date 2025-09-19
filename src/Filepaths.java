import java.nio.file.*;

public class Filepaths {

    public static final Path GROSSTORIO_SPLASH_SCREEN_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("graphics").resolve("splash").resolve("splash.png");

    public static String FACTORIO_SPLASH_SCREEN_PATH = "/data/core/graphics/splash-screen-image.png";

    public static boolean splashExists() {
        return Files.exists(GROSSTORIO_SPLASH_SCREEN_PATH);
    }

}