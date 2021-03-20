package mvc;


import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements PropertyChangeListener {

    protected Model model;

    public View(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public void update(Model m) {
        this.model.removePropertyChangeListener(this);
        this.model = m;
        this.model.initSupport(); // this calls the bean's initSupport method
        this.model.addPropertyChangeListener(this);
        repaint();
    }


    // Tells you model has been modify
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
