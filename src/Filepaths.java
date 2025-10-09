import java.nio.file.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Filepaths {

    public static void SetupFilepaths() {

            
        try {
            List<String> path = Files.readAllLines(Config.PATHS_TXT);

            // for (String elem : path) {
            //     System.out.println(elem);
            // }


            if(path.isEmpty()) {

                JFileChooser chooser = new JFileChooser();

                chooser.setDialogTitle("Select the Factorio Directory Location");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                
                chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                int result = chooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    Factorio.setFactorioPath(Paths.get(chooser.getSelectedFile().getAbsolutePath()));


                    System.out.println("Factorio directory is at: " + Factorio.FACTORIO_PATH);
                } else {
                    System.out.println("Selection canceled");
                }
            }
            else {
                Factorio.setFactorioPath(Paths.get(path.getFirst()));
                //System.out.println(Paths.get(path.getFirst()));
            }
        } catch (IOException ex) {}
    }


    public static class Config {
            public static final Path MODS_TXT = Paths.get(System.getProperty("user.dir")).getParent().resolve("config").resolve("Mods.txt");
            public static final Path PATHS_TXT = Paths.get(System.getProperty("user.dir")).getParent().resolve("config").resolve("Paths.txt");
    }

    public static class Grosstorio {

        public static Path getSplashPath() {
            return Paths.get(System.getProperty("user.dir"))
                        .getParent()
                        .resolve("graphics")
                        .resolve("splash")
                        .resolve("splash.png");
        }

        public static Path getModsPath() {
            return Paths.get(System.getProperty("user.dir"))
                        .getParent()
                        .resolve("mods");
        }
    }

    public static class Factorio {
        private static Path FACTORIO_PATH;

        public static void setFactorioPath(Path path) {
            FACTORIO_PATH = path;
            try {
                Files.write(Config.PATHS_TXT, FACTORIO_PATH.toString().getBytes());
            } catch (IOException ex) {
            }
        }

        public static Path getFactorioPath() {
            return FACTORIO_PATH;
        }

        public static File getFactorioBinary() {
            File binary = getFactorioPath().resolve("bin")
                                            .resolve("x64")
                                            .resolve("factorio")
                                            .toFile();

            return binary;

        }

        public static Path getSplashScreenPath() {
            return FACTORIO_PATH.resolve("data")
                                .resolve("core")
                                .resolve("graphics")
                                .resolve("splash-screen-image.png");
        }

        public static Path getSplashScreenBackupPath() {
            return FACTORIO_PATH.resolve("data")
                                .resolve("core")
                                .resolve("graphics")
                                .resolve("splash-screen-image-default-backup.png");
        }

        public static Path getModsPath() {
            return FACTORIO_PATH.resolve("mods"); //GODDAMMIT WHY
        }
    }

}   