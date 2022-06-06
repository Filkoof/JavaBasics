import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JButton actionButton;
    private JTextField firstNameText;
    private JTextField patronymicText;
    private JTextField surnameText;
    private JLabel surnameLabel;
    private JLabel firstNameLabel;
    private JLabel patronymicLabel;
    private JLabel fullNameLabel;
    private JTextField fullNameText;
    String fullName = "";
    private final String collapse = "Collapse";
    private final String expand = "Expand";

    public MainForm() {
        actionButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {

                String lastName = surnameText.getText();
                String firstName = firstNameText.getText();
                String secondName = patronymicText.getText();

                if (actionButton.getText().equals(collapse) &&
                        (!surnameText.getText().isEmpty() && !firstNameText.getText().isEmpty())){

                    fullName = lastName + " " + firstName + " " + secondName;

                    surnameText.setVisible(false);
                    surnameLabel.setVisible(false);

                    firstNameText.setVisible(false);
                    firstNameLabel.setVisible(false);

                    patronymicText.setVisible(false);
                    patronymicLabel.setVisible(false);

                    fullNameLabel.setVisible(true);
                    fullNameText.setVisible(true);

                    fullNameText.setText(fullName);

                    actionButton.setText(expand);
                } else if (actionButton.getText().equals(expand)
                        && (fullNameText.getText().split(" ").length >= 2)) {
                    fullName = fullNameText.getText();
                    String[] fragments = fullName.split(" ");

                    surnameText.setVisible(true);
                    surnameLabel.setVisible(true);

                    firstNameText.setVisible(true);
                    firstNameLabel.setVisible(true);

                    patronymicText.setVisible(true);
                    patronymicLabel.setVisible(true);

                    fullNameLabel.setVisible(false);
                    fullNameText.setVisible(false);

                    surnameText.setText(fragments[0]);
                    firstNameText.setText(fragments[1]);
                    if (fragments.length > 2) {
                        patronymicText.setText(fragments[2]);
                    } else {
                        patronymicText.setText("");
                    }

                    actionButton.setText(collapse);
                } else {
                    JOptionPane.showMessageDialog(null,"Заполните поля",
                            "Ошибка ввода",
                            JOptionPane.WARNING_MESSAGE );
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
