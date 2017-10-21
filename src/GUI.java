import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GUI() {
        this.buildGUI();
    }

    private void buildGUI() {//Builds each component of the GUI
        this.createWindow();
        this.createMenuBar();
    }

    private void createWindow() {//Creates the JFrame window

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//clicking the x closes the window
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width, screenSize.height);
        this.setVisible(true);
        this.pack();
        this.setSize(screenSize.width / 2, screenSize.height / 2);//resize

        this.setLocationRelativeTo(null);//center on screen
        this.setResizable(false);
        this.setTitle("JAD Compression");//window title

    }

    private void createMenuBar() {//Creates the menu bar of the JFrame window

        //menuBar
        JMenuBar menuBar = new JMenuBar();

        //mnFile
        JMenu mnFile = new JMenu("File");

        //mntmImport
        JMenuItem mntmImport = new JMenuItem("Import...");

        //Add all components
        mnFile.add(mntmImport);
        menuBar.add(mnFile);

        //Set this menu bar in the current frame
        this.setJMenuBar(menuBar);
    }
}
