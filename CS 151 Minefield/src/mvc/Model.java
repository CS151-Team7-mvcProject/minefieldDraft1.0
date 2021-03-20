package mvc;

public abstract class Model extends Bean {
    private String fileName = null;
    private boolean unsavedChanges = false;

    // Sets flag to true, fires property changed event
    public void changed() {
        unsavedChanges = true;
        firePropertyChange(fileName, false, true);
    }

    // Helper methods
    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }
}
