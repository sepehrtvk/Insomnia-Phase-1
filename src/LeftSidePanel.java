import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class LeftSidePanel extends JPanel {

    private JTextField filterTextField;
    private JButton insomniaBtn;
    private JTree requestsTree;
    private JButton newRequestBtn;

    public LeftSidePanel() {
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        setBorder(new LineBorder(Color.BLACK));


        insomniaBtn = new JButton("  Insomnia                              >   ");
        insomniaBtn.setBounds(0, 0, 253, 45);
        add(insomniaBtn);
        insomniaBtn.setForeground(Color.WHITE);
        insomniaBtn.setFont(new Font("STIXNonUnicode", Font.PLAIN, 16));
        insomniaBtn.setBackground(Color.MAGENTA);

        filterTextField = new JTextField();
        filterTextField.setBounds(10, 51, 201, 33);
        filterTextField.setOpaque(true);
        filterTextField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        filterTextField.setText("Filter");
        filterTextField.setBackground(Color.GRAY);
        filterTextField.setColumns(10);
        add(filterTextField);






    }
}
