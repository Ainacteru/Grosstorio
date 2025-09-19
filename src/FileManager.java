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

    public void ReplaceSplash() {
        
    }
}