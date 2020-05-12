import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JPanel docsPanel;
    private JPanel urlPanel;
    private JComboBox methodsComboBox;
    private JTextField urlText;
    private JButton sendBtn;
    private JButton saveBtn;
    private JPanel queryPanel;
    private JPanel bodyPanel;
    private LeftSidePanel leftSidePanel;
    private int i = 2;


    public CenterSidePanel() {
        leftSidePanel = new LeftSidePanel();
        setBorder(new LineBorder(Color.BLACK));
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout(0, 0));

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setBackground(Color.GRAY);
        add(tabbedPane, BorderLayout.CENTER);

        bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("      Body      ", bodyPanel);
        tabbedPane.setBackgroundAt(0, Color.GRAY);
        bodyPanel.setLayout(new BorderLayout());

        bodyTypeComboBox = new JComboBox(new String[]{"Form Data", "JSON", "Binary Data"});
        bodyTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((bodyTypeComboBox.getSelectedItem()).equals("Binary Data")) {
                    JFileChooser jFileChooser = new JFileChooser();
                    jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    jFileChooser.showOpenDialog(new JFrame());
                }
            }
        });

        bodyPanel.add(bodyTypeComboBox, BorderLayout.NORTH);

        initAuthTab();
        initQueryTab();
        initHeaderTab();
        initUrlPanel();
        initDocsTab();
    }

    public void initQueryTab() {
        queryPanel = new JPanel();
        queryPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("      Query       ", queryPanel);


        GridBagLayout gbl_queryPanel = new GridBagLayout();
        queryPanel.setLayout(gbl_queryPanel);

        final GridBagConstraints gbc = new GridBagConstraints();

        urlPreview = new JTextField(15);
        urlPreview.setEditable(false);
        urlPreview.setBorder(new TitledBorder("URL Preview"));
        urlPreview.setBackground(Color.GRAY);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 0;
        queryPanel.add(urlPreview, gbc);

        copyUrl = new JButton("Copy");
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 5;
        gbc.gridy = 0;
        queryPanel.add(copyUrl, gbc);


        lineLabel = new JLabel("𝌆");
        lineLabel.setFont(new Font("SansSerif", Font.PLAIN, 21));

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        queryPanel.add(lineLabel, gbc);

        nameText = new JTextField(15);
        nameText.setBackground(Color.GRAY);
        nameText.setText("New Name");
        nameText.addMouseListener(new MouseActionQuery());

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 1;
        queryPanel.add(nameText, gbc);

        newValueText = new JTextField(15);
        newValueText.setBackground(Color.GRAY);
        newValueText.setText("New Value");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 3;
        gbc.gridy = 1;
        queryPanel.add(newValueText, gbc);

        activeHeaderCheckBox = new JCheckBox("");

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 4;
        gbc.gridy = 1;

        queryPanel.add(activeHeaderCheckBox, gbc);

        deleteHeaderBtn = new JButton("☓");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 5;
        gbc.gridy = 1;

        queryPanel.add(deleteHeaderBtn, gbc);


    }


    public void initHeaderTab() {

        headerPanel = new JPanel();
        headerPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("    Header    ", headerPanel);

        GridBagLayout gbl_headerPanel = new GridBagLayout();
        headerPanel.setLayout(gbl_headerPanel);
        final GridBagConstraints gbc = new GridBagConstraints();


        lineLabel2 = new JLabel("𝌆");
        lineLabel2.setFont(new Font("SansSerif", Font.PLAIN, 21));

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        headerPanel.add(lineLabel2, gbc);

        headerText = new JTextField(15);
        headerText.setBackground(Color.GRAY);
        headerText.setText("Header");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 1;
        headerPanel.add(headerText, gbc);


        valueText = new JTextField(15);
        valueText.setBackground(Color.GRAY);
        valueText.setText("Value");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 3;
        gbc.gridy = 1;
        headerPanel.add(valueText, gbc);

        activeHeaderCheckBox2 = new JCheckBox("");

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 4;
        gbc.gridy = 1;

        headerPanel.add(activeHeaderCheckBox2, gbc);

        deleteHeaderBtn2 = new JButton("☓");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 5;
        gbc.gridy = 1;

        headerPanel.add(deleteHeaderBtn2, gbc);
        headerText.addMouseListener(new MouseActionHeader());
    }

    public void initUrlPanel() {
        urlPanel = new JPanel();
        urlPanel.setBackground(Color.gray);
        urlPanel.setPreferredSize(new Dimension(10, 51));

        final GridBagConstraints gbc = new GridBagConstraints();


        GridBagLayout gblUrlPanel = new GridBagLayout();
        gblUrlPanel.columnWidths = new int[]{0, 50, 250, 50, 0};
        gblUrlPanel.rowHeights = new int[]{51, 0};
        gblUrlPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gblUrlPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};

        urlPanel.setLayout(gblUrlPanel);
        add(urlPanel, BorderLayout.NORTH);

        methodsComboBox = new JComboBox(new String[]{"GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD"});
        methodsComboBox.setMinimumSize(new Dimension(60, 25));
        methodsComboBox.setPreferredSize(new Dimension(80, 51));


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        methodsComboBox.setBackground(Color.WHITE);
        urlPanel.add(methodsComboBox, gbc);

        urlText = new JTextField();
        urlText.setPreferredSize(new Dimension(300, 51));
        urlText.setText("                                    URL");

        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        urlPanel.add(urlText, gbc);

        sendBtn = new JButton("SEND");
        sendBtn.setPreferredSize(new Dimension(80, 27));
        sendBtn.setBackground(Color.WHITE);

        saveBtn = new JButton("SAVE");
        saveBtn.setPreferredSize(new Dimension(80, 27));
        saveBtn.setBackground(Color.WHITE);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFrame jFrame = new JFrame("Choose group");
                jFrame.setBounds(350, 200, 300, 200);
                jFrame.setMinimumSize(new Dimension(300, 200));
                jFrame.setLayout(new BorderLayout());
                jFrame.add(leftSidePanel.getRequestsTree(), BorderLayout.CENTER);
                final JTextField jTextField = new JTextField("New Group");
                final JButton jButton = new JButton("Add");
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        final String name = jTextField.getText();
                        DefaultTreeModel model = (DefaultTreeModel) leftSidePanel.getRequestsTree().getModel();
                        DefaultMutableTreeNode root = (DefaultMutableTreeNode) leftSidePanel.getRequestsTree().getModel().getRoot();
                        DefaultMutableTreeNode child = new DefaultMutableTreeNode(name);
                        model.insertNodeInto(child, root, root.getChildCount());
                        leftSidePanel.getRequestsTree().scrollPathToVisible(new TreePath(child.getPath()));
                    }
                });
                jFrame.add(jTextField, BorderLayout.NORTH);
                jFrame.add(jButton, BorderLayout.SOUTH);

                jFrame.setVisible(true);
            }
        });

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 3;
        gbc.gridy = 0;

        urlPanel.add(sendBtn, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.gridx = 3;
        gbc.gridy = 0;

        urlPanel.add(saveBtn, gbc);

    }

    public void initAuthTab() {
        authPanel = new JPanel();
        authPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("      Auth      ", authPanel);

    }

    public void initDocsTab() {
        docsPanel = new JPanel();
        docsPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("      Docs      ", docsPanel);

    }

    private class MouseActionHeader extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            while (i < 15) {
                final GridBagConstraints gbc = new GridBagConstraints();
                final JLabel lineLabel_2 = new JLabel("𝌆");
                lineLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 21));
                gbc.anchor = GridBagConstraints.NORTHWEST;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 1;
                gbc.gridy = i;
                headerPanel.add(lineLabel_2, gbc);

                final JTextField headerText_2 = new JTextField(10);
                headerText_2.setBackground(nameText.getBackground());
                headerText_2.setText("Header");
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 2;
                gbc.gridy = i;
                headerPanel.add(headerText_2, gbc);

                final JTextField valueText_2 = new JTextField(10);
                valueText_2.setBackground(nameText.getBackground());
                valueText_2.setText("Value");

                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 3;
                gbc.gridy = i;
                headerPanel.add(valueText_2, gbc);

                final JCheckBox activeHeaderCheckBox_2 = new JCheckBox("");

                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 4;
                gbc.gridy = i;
                headerPanel.add(activeHeaderCheckBox_2, gbc);

                final JButton deleteHeaderBtn_2 = new JButton("☓");
                deleteHeaderBtn_2.setBackground(nameText.getBackground());


                deleteHeaderBtn_2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        headerPanel.remove(headerText_2);
                        headerPanel.remove(valueText_2);
                        headerPanel.remove(activeHeaderCheckBox_2);
                        headerPanel.remove(deleteHeaderBtn_2);
                        headerPanel.remove(lineLabel_2);
                        revalidate();
                        repaint();

                    }
                });

                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 5;
                gbc.gridy = i;
                headerPanel.add(deleteHeaderBtn_2, gbc);
                headerText_2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        revalidate();
                        repaint();

                        //k++;
                    }
                });

                i++;
                break;
            }
        }

    }

    private class MouseActionQuery extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            while (i < 15) {
                final GridBagConstraints gbc = new GridBagConstraints();
                final JLabel lineLabel_2 = new JLabel("𝌆");
                lineLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 21));
                gbc.anchor = GridBagConstraints.NORTHWEST;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 1;
                gbc.gridy = i;
                queryPanel.add(lineLabel_2, gbc);

                final JTextField headerText_2 = new JTextField(10);
                headerText_2.setBackground(newValueText.getBackground());
                headerText_2.setText("Header");
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 2;
                gbc.gridy = i;
                queryPanel.add(headerText_2, gbc);

                final JTextField valueText_2 = new JTextField(10);
                valueText_2.setBackground(newValueText.getBackground());
                valueText_2.setText("Value");

                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 3;
                gbc.gridy = i;
                queryPanel.add(valueText_2, gbc);

                final JCheckBox activeHeaderCheckBox_2 = new JCheckBox("");

                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 4;
                gbc.gridy = i;
                queryPanel.add(activeHeaderCheckBox_2, gbc);

                final JButton deleteHeaderBtn_2 = new JButton("☓");
                deleteHeaderBtn_2.setBackground(newValueText.getBackground());


                deleteHeaderBtn_2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        queryPanel.remove(headerText_2);
                        queryPanel.remove(valueText_2);
                        queryPanel.remove(activeHeaderCheckBox_2);
                        queryPanel.remove(deleteHeaderBtn_2);
                        queryPanel.remove(lineLabel_2);
                        revalidate();
                        repaint();

                    }
                });

                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(0, 0, 5, 5);
                gbc.gridx = 5;
                gbc.gridy = i;
                queryPanel.add(deleteHeaderBtn_2, gbc);

                headerText_2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        revalidate();
                        repaint();
                    }
                });
                i++;
                break;
            }
        }

    }


    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JPanel getAuthPanel() {
        return authPanel;
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public JPanel getDocsPanel() {
        return docsPanel;
    }

    public JPanel getUrlPanel() {
        return urlPanel;
    }

    public JPanel getQueryPanel() {
        return queryPanel;
    }

    public JPanel getBodyPanel() {
        return bodyPanel;
    }

    public JTextField getUrlPreview() {
        return urlPreview;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getNewValueText() {
        return newValueText;
    }

    public JTextField getHeaderText() {
        return headerText;
    }

    public JTextField getValueText() {
        return valueText;
    }

}
