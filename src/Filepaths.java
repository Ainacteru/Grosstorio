import java.io.IOException;
import java.nio.file.*;

public class Filepaths {


    public static String FACTORIO_PATH = "/Factorio";

    // home/user/Applications/Games/Factorio/data/core/graphics/splash-screen-image.png 
    // my file location
    // Paths.get(FACTORIO_PATH).resolve("data").resolve("core").resolve("graphics").resolve("splash-screen-image.png");

    public static final Path MODS_TXT = Paths.get(System.getProperty("user.dir")).getParent().resolve("mods").resolve("mods.txt");

    public static class Grosstorio {

        public static final Path GROSSTORIO_SPLASH_SCREEN_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("graphics").resolve("splash").resolve("splash.png");

        public static final Path GROSSTORIO_MODS_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("mods");

    }

    public static class Factorio {
        
        public static final Path FACTORIO_SPLASH_SCREEN_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("factorio").resolve("data").resolve("core").resolve("graphics").resolve("splash-screen-image.png");

        public static final Path FACTORIO_SPLASH_SCREEN_PATH_BACKUP = Paths.get(System.getProperty("user.dir")).getParent().resolve("factorio").resolve("data").resolve("core").resolve("graphics").resolve("splash-screen-image-default-backup.png");

        public static final Path FACTORIO_MODS_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("factorio").resolve("mods");


    }
}   