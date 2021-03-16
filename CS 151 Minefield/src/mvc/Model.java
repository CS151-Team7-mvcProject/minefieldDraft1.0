package mvc;

public class Model extends Bean {
	
	private static final long serialVersionUID = 1L;
	
	
    //When set to True: model has unsaved changes
    // 			  False: there are no unsaved changes
    private boolean unsavedChanges;
    private String fileName;

    
    //Model constructor
    public Model() {
        fileName = null;
        unsavedChanges = true;
    }

    
    // Sets flag to true, fires property changed event
    // This does the work to change the model
    public void changed() {
        unsavedChanges = true;
        firePropertyChange(null, null, null);
    }

    
    // Helper methods
    public void    setUnsavedChanges(boolean bool) {
    	unsavedChanges = bool;
    }
    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }
    
    public void   setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }

}
