public class Main {

    public static void main(String[] args) {
        Main program = new Main();
        program.Run();
    }

    private void Run() {
        if(Filepaths.GROSSTORIO_SPLASH_SCREEN_PATH != null) {
            System.out.println(Filepaths.GROSSTORIO_SPLASH_SCREEN_PATH);
        }
        else 
        {
            System.out.println("No 'splash.png' found when searching for /splash/splash.png");
        }
    }

}