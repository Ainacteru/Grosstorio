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

    public void ReplaceSplash(Path newSplash, Path SplashToReplace) {
        Path _newSplash = newSplash;
        Path _newSplashCopy = newSplash.getParent().resolve("splash-screen-image.png"); // default name of factorio splash screen

        Path _splashToReplace = SplashToReplace;
        Path _splashToReplace_copy = SplashToReplace.getParent().resolve("splash-screen-image-default-copy.png");

        try {
            Files.copy(_newSplash, _newSplashCopy, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(_splashToReplace, _splashToReplace_copy, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Made a copy of " + _newSplash + "and made a backup of " + _splashToReplace);
            System.out.println();

            Files.createDirectories(_splashToReplace.getParent());
            Files.move(_newSplashCopy, _splashToReplace, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Replaced original splash with " + _newSplashCopy);
            System.out.println();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}