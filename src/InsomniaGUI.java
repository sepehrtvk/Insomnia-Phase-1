import javax.swing.*;
import java.awt.*;

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
//        initFullScreenMode();
//        initSideBar();
//        initSystemTray();
//        initDarkMode();
//        initLightMode();

        setJMenuBar(insomniaMenuBar);

        setVisible(true);

    }
}
