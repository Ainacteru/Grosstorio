public class Main {

    FileManager fileManager;

    public Main() {
        fileManager = new FileManager();
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.Run();
    }

    private void Run() {
        fileManager.ReplaceSplash(Filepaths.GROSSTORIO_SPLASH_SCREEN_PATH, Filepaths.FACTORIO_SPLASH_SCREEN_PATH);
    }

}