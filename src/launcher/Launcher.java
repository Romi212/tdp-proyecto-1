package launcher;
import entities.Student;
import gui.SimplePresentationScreen;
public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student Romi = new Student(134237,"Garcia","Romina","romina.garcia.pistonesi@gmail.com","https://github.com/Romi212","/images/aiba.png");
                SimplePresentationScreen app = new SimplePresentationScreen(Romi);
            }
        });
    }
}