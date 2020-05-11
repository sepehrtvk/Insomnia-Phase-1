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
    public void initLightMode() {
        insomniaMenuBar.getLight().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftSidePanel.getFilterTextField().setBackground(Color.pink);
                leftSidePanel.setBackground(Color.cyan);
                rightSidePanel.setBackground(Color.cyan);
                rightSidePanel.getHeaderInRightSide().setBackground(Color.cyan);
                rightSidePanel.getMessageBody().setBackground(Color.cyan);
                rightSidePanel.getRightSideTabbedPane().setBackground(Color.cyan);
                rightSidePanel.getStatusPanel().setBackground(Color.PINK);
                rightSidePanel.getNameRightSideText().setBackground(Color.PINK);
                rightSidePanel.getValueRightSideText().setBackground(Color.PINK);
                centerSidePanel.getUrlPanel().setBackground(Color.pink);
                centerSidePanel.setBackground(Color.cyan);
                leftSidePanel.getRequestsTree().setBackground(Color.cyan);
                centerSidePanel.getAuthPanel().setBackground(Color.cyan);
                centerSidePanel.getDocsPanel().setBackground(Color.cyan);
                centerSidePanel.getHeaderPanel().setBackground(Color.cyan);
                centerSidePanel.getTabbedPane().setBackground(Color.cyan);
                centerSidePanel.getBodyPanel().setBackground(Color.cyan);
                centerSidePanel.getQueryPanel().setBackground(Color.cyan);
                centerSidePanel.getHeaderText().setBackground(Color.pink);
                centerSidePanel.getNameText().setBackground(Color.pink);
                centerSidePanel.getNewValueText().setBackground(Color.pink);
                centerSidePanel.getValueText().setBackground(Color.pink);
                centerSidePanel.getUrlPreview().setBackground(Color.PINK);

            }
        });

    }
    public void initSystemTray() {
        insomniaMenuBar.getApplicationSubMenu2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (insomniaMenuBar.getHideCheckBox().isSelected()) {

                    if (!hideInSystemTray) {
                        setState(JFrame.ICONIFIED);

                        final PopupMenu popup = new PopupMenu();
                        Image icon2 = Toolkit.getDefaultToolkit().getImage("insomniaicon.png");
                        final TrayIcon trayIcon = new TrayIcon(icon2, "Insomnia", popup);

                        final SystemTray tray = SystemTray.getSystemTray();

                        MenuItem aboutItem = new MenuItem("About");
                        aboutItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ImageIcon icon = new ImageIcon("insomniaicon.png");
                                JOptionPane.showMessageDialog(null, "Developer : \n  Name : Sepehr Tavakoli\n  Email : Sepehrtvk@aut.ac.ir   \n  Student Number : 9831111", "About", JOptionPane.INFORMATION_MESSAGE, icon);
                            }
                        });
                        MenuItem exitItem = new MenuItem("Exit");
                        exitItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });
                        MenuItem showItem = new MenuItem("Show");
                        showItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                setExtendedState(JFrame.NORMAL);
                            }
                        });
                        popup.add(aboutItem);
                        popup.addSeparator();
                        popup.add(showItem);
                        popup.addSeparator();
                        popup.add(exitItem);

                        trayIcon.setPopupMenu(popup);

                        try {
                            tray.add(trayIcon);
                        } catch (AWTException err) {
                            System.out.println("TrayIcon could not be added.");
                        }
                        hideInSystemTray = true;
                    } else setState(JFrame.ICONIFIED);

                } else System.exit(0);
            }
        });
    }
    public void initFullScreenMode() {
        insomniaMenuBar.gettFullScreen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tFullScreenCounter++;
                if (tFullScreenCounter % 2 != 0) setExtendedState(JFrame.NORMAL);
                else setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

    }

}
