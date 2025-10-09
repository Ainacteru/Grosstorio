
public class Main {

    FileManager fileManager;

    public Main() {
        fileManager = new FileManager();
    }

    public static void main(String[] args) {
        Filepaths.SetupFilepaths();
        
        Main program = new Main();
        program.CloseGrosstorio();
        program.Run();
    }

    private void Run() {
        fileManager.ReplaceSplash(Filepaths.Grosstorio.getSplashPath(), Filepaths.Factorio.getSplashScreenPath());
        System.out.println("Added splash screen");

        fileManager.AddMod(Filepaths.Grosstorio.getModsPath());
        System.out.println("Added all mods");
        System.out.println();

        System.out.println("Starting game...");

        // try {
        //     //Thread.sleep(10000);
        // } catch (InterruptedException ex) {
        // }

        fileManager.RunGame();

    }

    public void CloseGrosstorio() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println();
            System.out.println("App is closing. Cleaning up...");
            System.out.println();
            
            fileManager.RevertToDefaultSplash();
            System.out.println();
            fileManager.RemoveGrosstorioMods();
        }));
    }

}