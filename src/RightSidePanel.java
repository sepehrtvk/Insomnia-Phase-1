import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
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

        dataTimeStatus = new JLabel(" 6.64 S");
        dataTimeStatus.setBounds(252, 10, 59, 31);
        dataTimeStatus.setBackground(Color.LIGHT_GRAY);
        dataTimeStatus.setOpaque(true);
        dataTimeStatus.setForeground(Color.DARK_GRAY);
        dataTimeStatus.setBorder(new MatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        statusPanel.add(dataTimeStatus);

        dataNumberStatus = new JLabel("200 OK");
        dataNumberStatus.setBounds(45, 10, 59, 31);
        dataNumberStatus.setPreferredSize(new Dimension(40, 20));
        dataNumberStatus.setOpaque(true);
        dataNumberStatus.setForeground(Color.WHITE);
        dataNumberStatus.setBackground(Color.ORANGE);
        dataNumberStatus.setBorder(new MatteBorder(5, 5, 5, 5, Color.ORANGE));
        statusPanel.add(dataNumberStatus);

        dataSizeStatus = new JLabel("13.1 KB");
        dataSizeStatus.setBounds(150, 10, 59, 31);
        dataSizeStatus.setOpaque(true);
        dataSizeStatus.setForeground(Color.DARK_GRAY);
        dataSizeStatus.setBorder(new MatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        dataSizeStatus.setBackground(Color.LIGHT_GRAY);
        statusPanel.add(dataSizeStatus);

    }
}
