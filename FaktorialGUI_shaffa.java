package faktorialgui_shaffa;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FaktorialGUI_shaffa {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TugasAlprok::new);
    }
}

class TugasAlprok extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton hitungButton;
    private JLabel hasilLabel;

    public TugasAlprok() {
        setTitle("Faktorial");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(230, 230, 255));

        inputField = new JTextField(10);
        hitungButton = new JButton("Hitung");
        hasilLabel = new JLabel("Hasil:");

        hitungButton.addActionListener(this);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(200, 200, 255));
        inputPanel.add(new JLabel("Masukkan bilangan: "));
        inputPanel.add(inputField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(200, 200, 255));
        buttonPanel.add(hitungButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(hasilLabel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hitungButton) {
            try {
                int bilangan = Integer.parseInt(inputField.getText());

                if (bilangan < 0) {
                    JOptionPane.showMessageDialog(this, "Masukkan bilangan positif!");
                    return;
                }

                long hasil = hitungFaktorial(bilangan);
                hasilLabel.setText("Hasil: " + hasil);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan bilangan bulat yang valid!");
            }
        }
    }

    private long hitungFaktorial(int n) {
        long faktorial = 1;
        for (int i = 2; i <= n; i++) {
            faktorial *= i;
        }
        return faktorial;
    }
}