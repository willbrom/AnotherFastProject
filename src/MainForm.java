import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {

    private JPanel mainPanel;
    private JButton buttonSelectFile;
    private JLabel labelSelectedFilePath;
    private JButton buttonShowGraph;
    private String filePath;
    private static JFrame frame;

    public MainForm() {
        buttonSelectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "txt files", "txt");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    filePath = chooser.getSelectedFile().getAbsolutePath();
                    labelSelectedFilePath.setText(filePath);
                }
            }
        });
        buttonShowGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filePath != null) {
                    new ReadFile().showGraph(filePath);
                } else {
                    JOptionPane.showMessageDialog(frame,"Please select a benchmark file");
                }
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame();
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 150);
        frame.setVisible(true);
    }
}
