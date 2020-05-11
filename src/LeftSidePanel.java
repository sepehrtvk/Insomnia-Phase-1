import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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

        requestsTree = new JTree();
        requestsTree.setBounds(1, 87, 253, 491);
        requestsTree.setPreferredSize(new Dimension(100, 500));
        requestsTree.setBackground(Color.DARK_GRAY);
        requestsTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Requests") {
            {
                DefaultMutableTreeNode node1, node2;

                node1 = new DefaultMutableTreeNode();
                node1.add(new DefaultMutableTreeNode());
                node1.add(new DefaultMutableTreeNode());
                add(node1);

                node2 = new DefaultMutableTreeNode();
                node2.add(new DefaultMutableTreeNode());
                add(node2);
            }
        }));

        add(requestsTree);

        newRequestBtn = new JButton("✚");
        newRequestBtn.setBounds(214, 55, 39, 29);
        newRequestBtn.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 15));
        add(newRequestBtn);

    }

    public JTextField getFilterTextField() {
        return filterTextField;
    }

    public JTree getRequestsTree() {
        return requestsTree;
    }

    public JButton getNewRequestBtn() {
        return newRequestBtn;
    }


}
