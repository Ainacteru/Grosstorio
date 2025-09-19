import java.nio.file.*;

public class Filepaths {

    public static final Path GROSSTORIO_SPLASH_SCREEN_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("graphics").resolve("splash").resolve("splash.png");

    public static String FACTORIO_PATH = "/Factorio";

    // home/Gary/Applications/Games/Factorio/data/core/graphics/splash-screen-image.png 
    // my file location
    public static Path FACTORIO_SPLASH_SCREEN_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("factorio").resolve("data").resolve("core").resolve("graphics").resolve("splash-screen-image.png");
    // Paths.get(FACTORIO_PATH).resolve("data").resolve("core").resolve("graphics").resolve("splash-screen-image.png");

    public static boolean splashExists() {
        return Files.exists(GROSSTORIO_SPLASH_SCREEN_PATH);
    }

}