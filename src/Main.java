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

        Filepaths.start();
        
        // System.out.println("replacing original splash with custom one");

        // fileManager.ReplaceSplash(Filepaths.GROSSTORIO_SPLASH_SCREEN_PATH, Filepaths.FACTORIO_SPLASH_SCREEN_PATH);

        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException ex) {
        // }

        // System.out.println("replacing custom splash with original one");

        // fileManager.RevertToDefaultSplash();

    }

}