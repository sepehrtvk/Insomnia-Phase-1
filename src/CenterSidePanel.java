import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CenterSidePanel extends JPanel {

    private JTabbedPane tabbedPane;
    private final JComboBox bodyTypeComboBox;
    private JPanel authPanel;
    private JTextField urlPreview;
    private JLabel lineLabel;
    private JTextField nameText;
    private JTextField newValueText;
    private JCheckBox activeHeaderCheckBox;
    private JButton deleteHeaderBtn;
    private JButton newRequestBtn2;
    private JPanel headerPanel;
    private JLabel lineLabel2;
    private JButton copyUrl;
    private JTextField headerText;
    private JTextField valueText;
    private JCheckBox activeHeaderCheckBox2;
    private JButton deleteHeaderBtn2;
    private JButton newRequestBtn3;
    private JPanel docsPanel;
    private JPanel urlPanel;
    private JComboBox methodsComboBox;
    private JTextField urlText;
    private JButton sendBtn;
    private JButton saveBtn;
    private JPanel queryPanel;
    private JPanel bodyPanel;

    public CenterSidePanel() {
        setBorder(new LineBorder(Color.BLACK));
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout(0, 0));

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setBackground(Color.GRAY);
        add(tabbedPane, BorderLayout.CENTER);

    }
}
