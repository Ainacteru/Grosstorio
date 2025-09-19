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
        fileManager.FindFiles();
    }

}