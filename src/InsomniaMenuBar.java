import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class InsomniaMenuBar extends JMenuBar {

    private JMenu menuApplication, applicationSubMenu1, theme, menuView, menuHelp;
    private final JCheckBox hideCheckBox;
    private JMenuItem dark, light, applicationSubMenu2, tFullScreen, tSideBar, about, help;

    public InsomniaMenuBar() {

        menuApplication = new JMenu("Application");
        menuApplication.setMnemonic(KeyEvent.VK_A);
        applicationSubMenu1 = new JMenu("Options");
        applicationSubMenu1.add(new JCheckBox("Follow Redirect "));


        hideCheckBox = new JCheckBox("Hide ");
        applicationSubMenu1.add(hideCheckBox);

        theme = new JMenu("Theme");
        dark = new JMenuItem("Dark mode", KeyEvent.VK_D);
        light = new JMenuItem("Light mode", KeyEvent.VK_L);
        KeyStroke darkModeKey = KeyStroke.getKeyStroke("control D");
        KeyStroke lightModeKey = KeyStroke.getKeyStroke("control L");
        dark.setAccelerator(darkModeKey);
        light.setAccelerator(lightModeKey);
        theme.add(dark);
        theme.add(light);

        applicationSubMenu1.add(theme);
        applicationSubMenu2 = new JMenuItem("Exit", KeyEvent.VK_E);
        KeyStroke exitKey = KeyStroke.getKeyStroke("control E");
        applicationSubMenu2.setAccelerator(exitKey);
        menuApplication.add(applicationSubMenu1);
        menuApplication.add(applicationSubMenu2);

        menuView = new JMenu("View");
        menuView.setMnemonic(KeyEvent.VK_V);
        tFullScreen = new JMenuItem("Toggle Full Screen", KeyEvent.VK_F);
        KeyStroke fullScreenKey = KeyStroke.getKeyStroke("control F");
        tFullScreen.setAccelerator(fullScreenKey);
        tSideBar = new JMenuItem("Toggle Sidebar", KeyEvent.VK_S);
        KeyStroke sideBarKey = KeyStroke.getKeyStroke("control S");
        tSideBar.setAccelerator(sideBarKey);
        menuView.add(tFullScreen);
        menuView.add(tSideBar);

        menuHelp = new JMenu("Help");
        about = new JMenuItem("About", KeyEvent.VK_A);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("insomniaicon.png");
                JOptionPane.showMessageDialog(null, "Developer : \n  Name : Sepehr Tavakoli\n  Email : Sepehrtvk@aut.ac.ir   \n  Student Number : 9831111","About",JOptionPane.INFORMATION_MESSAGE,icon);
            }
        });
        help = new JMenuItem("Help", KeyEvent.VK_H);
        menuHelp.setMnemonic(KeyEvent.VK_H);
        KeyStroke helpKey = KeyStroke.getKeyStroke("control H");
        KeyStroke aboutKey = KeyStroke.getKeyStroke("control A");
        help.setAccelerator(helpKey);
        about.setAccelerator(aboutKey);

        menuHelp.add(about);
        menuHelp.add(help);


        add(menuApplication);
        add(menuView);
        add(menuHelp);


    }

    public JMenuItem gettFullScreen() {
        return tFullScreen;
    }

    public JMenuItem gettSideBar() {
        return tSideBar;
    }

    public JMenuItem getApplicationSubMenu2() {
        return applicationSubMenu2;
    }

    public JCheckBox getHideCheckBox() {
        return hideCheckBox;
    }

    public JMenuItem getDark() {
        return dark;
    }

    public JMenuItem getLight() {
        return light;
    }
}
