import java.io.IOException;
import java.nio.file.*;

public class Filepaths {

    public static final Path GROSSTORIO_SPLASH_SCREEN_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("graphics").resolve("splash").resolve("splash.png");

    public static String FACTORIO_PATH = "/Factorio";

    // home/Gary/Applications/Games/Factorio/data/core/graphics/splash-screen-image.png 
    // my file location
    public static final Path FACTORIO_SPLASH_SCREEN_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("factorio").resolve("data").resolve("core").resolve("graphics").resolve("splash-screen-image.png");
    // Paths.get(FACTORIO_PATH).resolve("data").resolve("core").resolve("graphics").resolve("splash-screen-image.png");

    public static final Path FACTORIO_SPLASH_SCREEN_PATH_COPY = Paths.get(System.getProperty("user.dir")).getParent().resolve("factorio").resolve("data").resolve("core").resolve("graphics").resolve("splash-screen-image-default-copy.png");


    //mods
    public static final Path FACTORIO_MODS_PATH = Paths.get(System.getProperty("user.dir")).getParent().resolve("mods").resolve("Grosstorio.zip");

    public static Path[] FACTORIO_MODS;
    
    public static void start() {
        Path mods = Paths.get(System.getProperty("user.dir")).getParent().resolve("mods");

    

        //for(int i = 0; i < 10; i++) {
            System.out.println(mods);
        //}
    }


    public static boolean splashExists() {
        return Files.exists(GROSSTORIO_SPLASH_SCREEN_PATH);
    }

}