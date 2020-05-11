import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsomniaGUI extends JFrame {

    private int tFullScreenCounter = 1;
    private int tSideBarCounter = 1;
    private final InsomniaMenuBar insomniaMenuBar;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints gbc;
    private final leftSidePanel leftSidePanel;
    private centerSidePanel centerSidePanel;
    private rightSidePanel rightSidePanel;
    private boolean hideInSytemTray = false;

    public InsomniaGUI() {
        setPreferredSize(new Dimension(1100, 600));
        setMinimumSize(new Dimension(1100, 600));
        setTitle("Insomnia-My Request\n");
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image icon = Toolkit.getDefaultToolkit().getImage("insomniaicon.png");
        setIconImage(icon);


        gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{255, 555, 380, 0};
        gridBagLayout.rowHeights = new int[]{600, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        gbc = new GridBagConstraints();

        leftSidePanel = new leftSidePanel();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(leftSidePanel, gbc);

        centerSidePanel = new centerSidePanel();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(centerSidePanel, gbc);

        rightSidePanel = new rightSidePanel();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(rightSidePanel, gbc);


        insomniaMenuBar = new InsomniaMenuBar();
        initFullScreenMode();
        initSideBar();
        initSystemTray();
        initDarkMode();
        initLightMode();

        setJMenuBar(insomniaMenuBar);

        setVisible(true);

    }
    public void initDarkMode() {
        insomniaMenuBar.getDark().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftSidePanel.getFilterTextField().setBackground(Color.gray);
                leftSidePanel.setBackground(Color.darkGray);
                rightSidePanel.setBackground(Color.darkGray);
                rightSidePanel.getHeaderInRightSide().setBackground(Color.darkGray);
                rightSidePanel.getMessageBody().setBackground(Color.darkGray);
                centerSidePanel.getUrlPanel().setBackground(Color.gray);
                rightSidePanel.getRightSideTabbedPane().setBackground(Color.darkGray);
                rightSidePanel.getStatusPanel().setBackground(Color.gray);
                rightSidePanel.getNameRightSideText().setBackground(Color.gray);
                rightSidePanel.getValueRightSideText().setBackground(Color.gray);
                centerSidePanel.setBackground(Color.darkGray);
                leftSidePanel.getRequestsTree().setBackground(Color.darkGray);
                centerSidePanel.getAuthPanel().setBackground(Color.darkGray);
                centerSidePanel.getDocsPanel().setBackground(Color.darkGray);
                centerSidePanel.getHeaderPanel().setBackground(Color.darkGray);
                centerSidePanel.getTabbedPane().setBackground(Color.darkGray);
                centerSidePanel.getBodyPanel().setBackground(Color.darkGray);
                centerSidePanel.getQueryPanel().setBackground(Color.darkGray);
                centerSidePanel.getHeaderText().setBackground(Color.gray);
                centerSidePanel.getNameText().setBackground(Color.gray);
                centerSidePanel.getNewValueText().setBackground(Color.gray);
                centerSidePanel.getValueText().setBackground(Color.gray);
                centerSidePanel.getUrlPreview().setBackground(Color.gray);

            }
        });

    }

}
