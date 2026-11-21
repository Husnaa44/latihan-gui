import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// interface
interface Aksi {
    void daftar();
    void reset();
}

// abstract class
abstract class Data extends JFrame {
    abstract void tampilkanData();
}

class Pendaftaran extends Data implements Aksi {

    JTextField nama = new JTextField();
    JTextField alamat = new JTextField();

    JRadioButton laki = new JRadioButton("Laki-laki");
    JRadioButton perempuan = new JRadioButton("Perempuan");

    ButtonGroup grup = new ButtonGroup();

    Pendaftaran() {

        setTitle("Formulir Pendaftaran");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // BorderLayout
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        // GridLayout
        JPanel isi = new JPanel(new GridLayout(0, 1, 5, 5));

        isi.add(new JLabel("FORMULIR PENDAFTARAN"));
        isi.add(new JLabel("Nama"));
        isi.add(nama);

        isi.add(new JLabel("Alamat"));
        isi.add(alamat);

        isi.add(new JLabel("Jenis Kelamin"));

        grup.add(laki);
        grup.add(perempuan);

        isi.add(laki);
        isi.add(perempuan);

        JButton tombolDaftar = new JButton("Daftar");
        JButton tombolReset = new JButton("Reset");

        // FlowLayout
        JPanel tombol = new JPanel(new FlowLayout());

        tombol.add(tombolDaftar);
        tombol.add(tombolReset);

        panel.add(isi, BorderLayout.CENTER);
        panel.add(tombol, BorderLayout.SOUTH);

        // Event Listener
        tombolDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daftar();
            }
        });

        tombolReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        add(panel);
        setVisible(true);
    }

    @Override
    public void daftar() {

        if (nama.getText().isEmpty() ||
            alamat.getText().isEmpty() ||
            (!laki.isSelected() && !perempuan.isSelected())) {

            JOptionPane.showMessageDialog(this, "Data belum lengkap!");

        } else {
            tampilkanData();
        }
    }

    @Override
    public void tampilkanData() {

        String jk = "Laki-laki";

        if (perempuan.isSelected()) {
            jk = "Perempuan";
        }

        JOptionPane.showMessageDialog(this,
            "Pendaftaran Berhasil!\n" +
            "Nama: " + nama.getText() +
            "\nAlamat: " + alamat.getText() +
            "\nJenis Kelamin: " + jk);
    }

    @Override
    public void reset() {

        nama.setText("");
        alamat.setText("");
        grup.clearSelection();
    }
}

public class Main {
    public static void main(String[] args) {
        new Pendaftaran();
    }
}
