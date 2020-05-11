import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RightSidePanel extends JPanel {

    private JPanel statusPanel;
    private JLabel dataTimeStatus;
    private JLabel dataNumberStatus;
    private JLabel dataSizeStatus;
    private JTabbedPane rightSideTabbedPane;
    private JPanel messageBody;
    private JComboBox headerRightComboBox;
    private JPanel headerInRightSide;
    private JTextField valueRightSideText;
    private JTextField nameRightSideText;
    private JButton copyToClipboardBtn;

    public RightSidePanel() {
        setBorder(new LineBorder(Color.BLACK));
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout(0, 0));


        statusPanel = new JPanel();
        statusPanel.setBorder(new LineBorder(Color.BLACK, 1, true));
        statusPanel.setBackground(Color.gray);
        statusPanel.setLayout(null);
        statusPanel.setPreferredSize(new Dimension(100, 51));
        statusPanel.setMinimumSize(new Dimension(100, 100));
        add(statusPanel, BorderLayout.NORTH);

    }
}
