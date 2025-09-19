import java.io.IOException;
import java.nio.file.*;

public class FileManager {

    public void FindFiles() {
        if(Filepaths.splashExists()) {
            System.out.println(Filepaths.GROSSTORIO_SPLASH_SCREEN_PATH);
        }
        else 
        {
            System.out.println("No 'splash.png' found when searching for /splash/splash.png");
        }
    }


    //rename default then move and name the custom what the default use to be
    public void ReplaceSplash() {
        Path customSplash = Filepaths.GROSSTORIO_SPLASH_SCREEN_PATH;
        Path customSplashCopy = Filepaths.GROSSTORIO_SPLASH_SCREEN_PATH.getParent().resolve("splash-screen-image.png");
        Path defaultSplash = Filepaths.FACTORIO_SPLASH_SCREEN_PATH;
        Path defaultSplashCopy   = Filepaths.FACTORIO_SPLASH_SCREEN_PATH.getParent().resolve("splash-screen-image-default-copy.png");

        try {
            Files.copy(customSplash, customSplashCopy, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(defaultSplash, defaultSplashCopy, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Made a copy of " + customSplash + "and made a backup of " + defaultSplash);
            System.out.println();

            Files.createDirectories(defaultSplash.getParent());
            Files.move(customSplashCopy, defaultSplash, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Replaced original splash with " + customSplashCopy);
            System.out.println();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}