package mvc;
import java.awt.Color;

public interface AppFactory {
    public Model makeModel();
    public View  makeView(Model model);

    //Settings for the application's frame
    public int    getFrameSize(int i);
    public int    getButtonGridSize(int i);
    public int    getButtonGap(int i);
    public Color  getBackgroundColor(int i);
    public String getTitle();
    
    //Returns array of strings as names for your menu bar buttons
    public String[] getFileTitles();
    public String[] getEditTitles();
    public String[] getHelpTitles();
    
    //In subclass, if type of command is not recognized, return null
    public Command makeNewCommand(Model model, String type);

    //In subclass, set the Help and About messages.
    public String[] getHelp();
    public String   getAbout();

}
