package mvc;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class View extends JFrame implements ModelEventSink {

    private static final long serialVersionUID = 7239814764257393927L;
    private JPanel contentPane;
    private JTextField numberField;
    private JTextField nameField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    View frame = new View();
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
    public View() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);

	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);

	JMenu mnFile = new JMenu("File");
	menuBar.add(mnFile);

	JMenuItem mntmNew = new JMenuItem("New");
	mnFile.add(mntmNew);

	JMenuItem mntmExit = new JMenuItem("Exit");
	mnFile.add(mntmExit);

	JMenu mnHelp = new JMenu("Help");
	menuBar.add(mnHelp);

	JMenuItem mntmAbout = new JMenuItem("About");
	mnHelp.add(mntmAbout);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[][162.00][][98.00,grow]",
		"[][][][][][]"));

	JLabel lblNumber = new JLabel("Number");
	contentPane.add(lblNumber, "cell 0 0,aligny center");

	numberField = new JTextField();
	contentPane.add(numberField, "cell 1 0,growx,aligny center");
	numberField.setColumns(10);

	JLabel lblName = new JLabel("Name");
	contentPane.add(lblName, "cell 0 1,aligny center");

	nameField = new JTextField();
	contentPane.add(nameField, "cell 1 1,growx");
	nameField.setColumns(10);

	JButton btnCancel = new JButton("Cancel");
	contentPane.add(btnCancel, "flowx,cell 1 3");

	JButton btnOk = new JButton("OK");
	contentPane.add(btnOk, "cell 1 3");
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
	
    }

}
