import java.io.IOException;
import java.nio.file.*;

public class FileManager {

    public void ReplaceSplash(Path newSplash, Path SplashToReplace) {
        Path _newSplash = newSplash;
        Path _newSplashCopy = newSplash.getParent().resolve("splash-screen-image.png"); // default name of factorio splash screen

        Path _splashToReplace = SplashToReplace;
        Path _splashToReplace_copy = SplashToReplace.getParent().resolve("splash-screen-image-default-copy.png");

        try {
            Files.copy(_newSplash, _newSplashCopy, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(_splashToReplace, _splashToReplace_copy, StandardCopyOption.REPLACE_EXISTING);

            System.out.println();
            System.out.println("Made a copy of " + _newSplash + "and made a backup of " + _splashToReplace);

            Files.createDirectories(_splashToReplace.getParent());
            Files.move(_newSplashCopy, _splashToReplace, StandardCopyOption.REPLACE_EXISTING);

            System.out.println();
            System.out.println("Replaced original splash with " + _newSplashCopy);

        } catch (IOException ex) {
        }
    }

    public void AddMod(Path mods, Path FACTORIO_PATH) {
        Path _modsToTransfer = mods;
        Path destination = FACTORIO_PATH;

        try {
            Files.write(Filepaths.MODS_TXT, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {}
        //clear then write

        try {
            DirectoryStream<Path> _mods = Files.newDirectoryStream(_modsToTransfer, "*.zip");
            for (Path mod : _mods) {
                //System.out.println("Found: " + mod.getFileName());

                Files.write(Filepaths.MODS_TXT, (mod.getFileName().toString() + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                System.out.println("Added " + mod.getFileName() + " to " + Filepaths.MODS_TXT.toAbsolutePath());
            }

        } catch (IOException ex) {}

    }

    //replace the splash screen, then delete it -- i could also just mv it to rename it and replace it but i'll do this for simplicity
    public void RevertToDefaultSplash() {
        ReplaceSplash(Filepaths.Factorio.FACTORIO_SPLASH_SCREEN_PATH_BACKUP, Filepaths.Factorio.FACTORIO_SPLASH_SCREEN_PATH);

        try {
            Files.delete(Filepaths.Factorio.FACTORIO_SPLASH_SCREEN_PATH_BACKUP);

            System.out.println();
            System.out.println("DELETED " + Filepaths.Factorio.FACTORIO_SPLASH_SCREEN_PATH_BACKUP);
            
        } catch (IOException ex) {
        }
    }
}