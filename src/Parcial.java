import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Parcial extends JFrame {
    private JTextField textProducto;
    private JTextField textPrecio;
    private JTextField textCantidad;
    private JButton buttonGuardar;
    private JTextArea textArea1;
    private JPanel panelParcial;
    private JButton totalDePrecioButton;
    private JTextField Totaltxt;

    String texto = "";
    String cadena = "";
    int totalcompra =0;

    public Parcial() {
        setContentPane(panelParcial);
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total =0;
                int cantidad1 = Integer.parseInt(textCantidad.getText());
                int precio1 = Integer.parseInt(textPrecio.getText());


                if(textCantidad.getText() != " "&& textPrecio.getText() !=" "){
                    total = precio1 *cantidad1;
                }
                totalcompra+= total;
                Totaltxt.setText(String.valueOf(totalcompra));







                if(e.getSource() == buttonGuardar){

                    texto += textProducto.getText() + "\t" + textPrecio.getText() + "\t" + textCantidad.getText() +
                    "\t" + total + "\n";

                    textArea1.setText(texto);
                    textProducto.setText("");
                    textPrecio.setText("");
                    textCantidad.setText("");





                }

            }
        });

        totalDePrecioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File fileToSave = chooser.getSelectedFile();
                        FileWriter fwriter = new FileWriter(fileToSave);
                        PrintWriter pwriter = new PrintWriter(fwriter);
                        pwriter.print(textArea1.getText());
                        pwriter.print(Totaltxt.getText());
                        fwriter.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "Error: " + ex.getMessage());
                    }
                }

            }
        });
    }
}
