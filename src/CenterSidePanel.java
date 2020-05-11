import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("      Body      ", bodyPanel);
        tabbedPane.setBackgroundAt(0, Color.GRAY);
        bodyPanel.setLayout(new BorderLayout());

        bodyTypeComboBox = new JComboBox(new String[]{"Form Data", "JSON", "Binary Data"});
        bodyTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((bodyTypeComboBox.getSelectedItem()).equals("Binary Data")){
                    JFileChooser jFileChooser = new JFileChooser();
                    jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    jFileChooser.showOpenDialog(new JFrame());
                }
            }
        });
        bodyPanel.add(bodyTypeComboBox, BorderLayout.NORTH);

        authPanel = new JPanel();
        authPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("      Auth      ", authPanel);

        initQueryTab();
        initHeaderTab();

    }
    public void initQueryTab(){
        queryPanel = new JPanel();
        queryPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("      Query       ", queryPanel);


        GridBagLayout gbl_queryPanel = new GridBagLayout();
        gbl_queryPanel.columnWidths = new int[]{18, 0, 160, 163, 0, 18, 41, 0};
        gbl_queryPanel.rowHeights = new int[]{37, 40, 40, 0};
        gbl_queryPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_queryPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
        queryPanel.add(urlPreview,gbc);

        copyUrl = new JButton("Copy");
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 5;
        gbc.gridy = 0;
        queryPanel.add(copyUrl,gbc);


        lineLabel = new JLabel("𝌆");
        lineLabel.setFont(new Font("SansSerif", Font.PLAIN, 21));

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        queryPanel.add(lineLabel, gbc);

        nameText = new JTextField();
        nameText.setBackground(Color.GRAY);
        nameText.setText("New Name");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 1;
        queryPanel.add(nameText, gbc);

        newValueText = new JTextField(10);
        newValueText.setBackground(Color.GRAY);
        newValueText.setText("New Value");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,0,5,5);
        gbc.gridx = 3;
        gbc.gridy = 1;
        queryPanel.add(newValueText, gbc);

        activeHeaderCheckBox = new JCheckBox("");

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,0,5,5);
        gbc.gridx = 4;
        gbc.gridy = 1;

        queryPanel.add(activeHeaderCheckBox,gbc);

        deleteHeaderBtn = new JButton("☓");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,0,5,5);
        gbc.gridx = 5;
        gbc.gridy = 1;

        queryPanel.add(deleteHeaderBtn, gbc);
        newRequestBtn2 = new JButton("✚ New");
        newRequestBtn2.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 15));

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridx = 2;
        gbc.gridy = 2;

        queryPanel.add(newRequestBtn2, gbc);



    }

    public void initHeaderTab(){

        headerPanel = new JPanel();
        headerPanel.setBackground(Color.DARK_GRAY);
        tabbedPane.addTab("    Header    ", headerPanel);

        GridBagLayout gbl_headerPanel = new GridBagLayout();
        gbl_headerPanel.columnWidths = new int[]{18, 0, 160, 163, 0, 18, 41, 0};
        gbl_headerPanel.rowHeights = new int[]{37, 40, 40, 0};
        gbl_headerPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_headerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        headerPanel.setLayout(gbl_headerPanel);
        final GridBagConstraints gbc = new GridBagConstraints();


        lineLabel2 = new JLabel("𝌆");
        lineLabel2.setFont(new Font("SansSerif", Font.PLAIN, 21));

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        headerPanel.add(lineLabel2, gbc);

        headerText = new JTextField();
        headerText.setBackground(Color.GRAY);
        headerText.setText("Header");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 1;
        headerPanel.add(headerText, gbc);


        valueText = new JTextField(10);
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


        newRequestBtn3 = new JButton("✚ New");
        newRequestBtn3.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 15));

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridx = 2;
        gbc.gridy = 2;

        headerPanel.add(newRequestBtn3, gbc);

    }
}
