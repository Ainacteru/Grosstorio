import java.io.IOException;
import java.nio.file.*;
import java.util.List;


public class FileManager {

    public void ReplaceSplash(Path newSplash, Path SplashToReplace) {
        Path backup = SplashToReplace.getParent().resolve("splash-screen-image-default-backup.png");
        System.out.println(backup);

        try {
            // Backup original splash before replacing
            if (!Files.exists(backup)) {
                Files.copy(SplashToReplace, backup, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Backup created: " + backup);
            }

            // Replace the splash
            Files.copy(newSplash, SplashToReplace, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Replaced splash with: " + newSplash);

        } catch (IOException ex) {
        }
    }

    public void AddMod(Path mods) {
        Path _modsToTransfer = mods;

        try {
            Files.write(Filepaths.Config.MODS_TXT, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {}
        //clear then write

        try {
            DirectoryStream<Path> _mods = Files.newDirectoryStream(_modsToTransfer, "*.zip");

            long count = Files.list(_modsToTransfer).filter(p -> p.toString().endsWith(".zip")).count();
            System.out.println();
            System.out.println("Found " + count + " mods to add");

            for (Path mod : _mods) {

                //System.out.println("Found: " + mod.getFileName());
                Files.write(Filepaths.Config.MODS_TXT, (mod.getFileName().toString() + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                System.out.println("Added " + mod.getFileName() + " to " + Filepaths.Config.MODS_TXT.toAbsolutePath());

                Files.copy(mod, Filepaths.Factorio.getModsPath().resolve(mod.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                //Files.move(modToMove, mod, options)
                //Files.c
            }

        } catch (IOException ex) {}

    }

    public void RemoveGrosstorioMods() {
        try {
            Path mods = Filepaths.Config.MODS_TXT;
            
            List<String> txt = Files.readAllLines(mods);

            for (String line : txt) {
                //System.out.println(line);
                Path mod = Filepaths.Factorio.getModsPath().resolve(line);

                System.out.println("found mod to delete: " + mod);

                Files.delete(mod);

            }      
            } catch (IOException ex) {
        }


    }

    public void RevertToDefaultSplash() {
        Path backup = Filepaths.Factorio.getSplashScreenBackupPath();

        ReplaceSplash(backup, Filepaths.Factorio.getSplashScreenPath());

        try {
            Files.delete(backup);
            System.out.println("Deleted backup: " + backup);
        } catch (IOException ex) {
            System.out.println("Could not delete backup (already removed?): " + ex.getMessage());
        }
    }


    public void RunGame() {
        try {
            ProcessBuilder pb = new ProcessBuilder(Filepaths.Factorio.getFactorioBinary().getAbsolutePath());
            pb.directory(Filepaths.Factorio.getFactorioPath().toFile());
            
            Process gameProcess = pb.start();
            System.out.println("Factorio started.");

            int exitCode = gameProcess.waitFor();
            System.out.println("Factorio closed with exit code: " + exitCode);

        } catch (IOException | InterruptedException ex) {
        }
    }


}