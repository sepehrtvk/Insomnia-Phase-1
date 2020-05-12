import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * the RightSidePanel class that extends JPanel , prepares right panel for the header and message body.
 *
 * @author sepehr tavakoli
 * @version 1.0
 * @since 2020.05.01
 */

public class RightSidePanel extends JPanel {

    //status panel for details.
    private JPanel statusPanel;

    //data time status.
    private JLabel dataTimeStatus;

    //data number status.
    private JLabel dataNumberStatus;

    //data size status.
    private JLabel dataSizeStatus;

    //right side tabs.
    private JTabbedPane rightSideTabbedPane;

    //message body panel.
    private JPanel messageBody;

    //header mode combobox.
    private JComboBox headerRightComboBox;

    //header panel.
    private JPanel headerInRightSide;

    //value textfield.
    private JTextField valueRightSideText;

    //name textfield.
    private JTextField nameRightSideText;

    //copy button.
    private JButton copyToClipboardBtn;

    /**
     * this constructor makes the right side panel with 2 main parts.
     */
    public RightSidePanel() {

        //make right panel.
        setBorder(new LineBorder(Color.BLACK));
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout(0, 0));

        //set status panel.
        statusPanel = new JPanel();
        statusPanel.setBorder(new LineBorder(Color.BLACK, 1, true));
        statusPanel.setBackground(Color.gray);
        statusPanel.setLayout(null);
        statusPanel.setPreferredSize(new Dimension(100, 51));
        statusPanel.setMinimumSize(new Dimension(100, 100));
        add(statusPanel, BorderLayout.NORTH);

        //add data time status.
        dataTimeStatus = new JLabel(" 6.64 S");
        dataTimeStatus.setBounds(252, 10, 59, 31);
        dataTimeStatus.setBackground(Color.LIGHT_GRAY);
        dataTimeStatus.setOpaque(true);
        dataTimeStatus.setForeground(Color.DARK_GRAY);
        dataTimeStatus.setBorder(new MatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        statusPanel.add(dataTimeStatus);

        //add data number status.
        dataNumberStatus = new JLabel("200 OK");
        dataNumberStatus.setBounds(45, 10, 59, 31);
        dataNumberStatus.setPreferredSize(new Dimension(40, 20));
        dataNumberStatus.setOpaque(true);
        dataNumberStatus.setForeground(Color.WHITE);
        dataNumberStatus.setBackground(Color.ORANGE);
        dataNumberStatus.setBorder(new MatteBorder(5, 5, 5, 5, Color.ORANGE));
        statusPanel.add(dataNumberStatus);

        //add data size status.
        dataSizeStatus = new JLabel("13.1 KB");
        dataSizeStatus.setBounds(150, 10, 59, 31);
        dataSizeStatus.setOpaque(true);
        dataSizeStatus.setForeground(Color.DARK_GRAY);
        dataSizeStatus.setBorder(new MatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        dataSizeStatus.setBackground(Color.LIGHT_GRAY);
        statusPanel.add(dataSizeStatus);

        //init right table parts.
        initRightSideTabs();

    }

    /**
     * this initRightSideTabs method makes all the tabs in the right panel with their panels.
     */
    public void initRightSideTabs() {

        rightSideTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        rightSideTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        rightSideTabbedPane.setBackground(Color.DARK_GRAY);
        rightSideTabbedPane.setOpaque(true);
        add(rightSideTabbedPane, BorderLayout.CENTER);

        messageBody = new JPanel();
        messageBody.setBackground(Color.DARK_GRAY);
        messageBody.setLayout(new BorderLayout(0, 0));
        rightSideTabbedPane.addTab("      Message body      ", null, messageBody, null);

        headerRightComboBox = new JComboBox(new String[]{"Raw", "Preview", "JSON"});
        rightSideTabbedPane.setBackgroundAt(0, Color.GRAY);
        messageBody.add(headerRightComboBox, BorderLayout.NORTH);

        headerInRightSide = new JPanel();
        headerInRightSide.setBackground(Color.DARK_GRAY);
        headerInRightSide.setLayout(new FlowLayout());
        rightSideTabbedPane.addTab("            Header            ", headerInRightSide);

        valueRightSideText = new JTextField();
        valueRightSideText.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Value", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
        valueRightSideText.setEditable(false);
        valueRightSideText.setBackground(Color.LIGHT_GRAY);
        valueRightSideText.setBounds(171, 28, 134, 40);
        valueRightSideText.setColumns(13);
        headerInRightSide.add(valueRightSideText);

        nameRightSideText = new JTextField();
        nameRightSideText.setEditable(false);
        nameRightSideText.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Name", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
        nameRightSideText.setBackground(Color.LIGHT_GRAY);
        nameRightSideText.setBounds(16, 28, 160, 50);
        nameRightSideText.setColumns(13);
        headerInRightSide.add(nameRightSideText);

        copyToClipboardBtn = new JButton("Copy To Clipboard");
        copyToClipboardBtn.setBackground(Color.LIGHT_GRAY);
        copyToClipboardBtn.setFont(new Font("Papyrus", Font.PLAIN, 12));
        copyToClipboardBtn.setBounds(159, 157, 160, 40);
        headerInRightSide.add(copyToClipboardBtn);

    }

    /**
     * get the message body panel.
     *
     * @return message body panel.
     */
    public JPanel getMessageBody() {
        return messageBody;
    }

    /**
     * get the header panel.
     *
     * @return header panel.
     */
    public JPanel getHeaderInRightSide() {
        return headerInRightSide;
    }

    /**
     * get the right tabs.
     *
     * @return right tabs.
     */

    public JTabbedPane getRightSideTabbedPane() {
        return rightSideTabbedPane;
    }

    /**
     * get the status panel.
     *
     * @return status panel.
     */

    public JPanel getStatusPanel() {
        return statusPanel;
    }

    /**
     * get the value textfield.
     *
     * @return value textfield.
     */

    public JTextField getValueRightSideText() {
        return valueRightSideText;
    }

    /**
     * get the name textfield.
     *
     * @return name textfield.
     */

    public JTextField getNameRightSideText() {
        return nameRightSideText;
    }

}
