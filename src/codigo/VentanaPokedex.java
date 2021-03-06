/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import java.sql.Statement;
import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 0;

    Statement estado;
    Connection conexion;
    ResultSet resultadoConsulta;

    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0,
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);
    }

    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        Color bgColor = Color.BLACK;
        UIDefaults defaults = new UIDefaults();
        defaults.put("TextPane.background", new ColorUIResource(bgColor));
        defaults.put("TextPane[Enabled].backgroundPainter", bgColor);
        descripcionPokemon.putClientProperty("Nimbus.Overrides", defaults);
        descripcionPokemon.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        descripcionPokemon.setBackground(bgColor);
        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }

        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();

        dibujaElPokemonQueEstaEnLaPosicion(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/pokedex",
                            "root",
                            "");
            estado = conexion.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sonidoDeFondo s = new sonidoDeFondo();
        s.start();
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion) {
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel 
                0, // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna * 96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila * 96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna * 96 + 96, //posicion final X
                fila * 96 + 96, //posicion final Y
                null //si no lo pones no va
        );
        repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenPokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        EspeciePokemon = new javax.swing.JLabel();
        HabilidadPokemon = new javax.swing.JLabel();
        Mov4 = new javax.swing.JLabel();
        Mov3 = new javax.swing.JLabel();
        Mov2 = new javax.swing.JLabel();
        Mov1 = new javax.swing.JLabel();
        NombrePokemon = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TipoPokemon = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Tipo2Pokemon = new javax.swing.JLabel();
        AlturaPokemon = new javax.swing.JLabel();
        PesoPokemon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionPokemon = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        HabitatPokemon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        getContentPane().add(imagenPokemon);
        imagenPokemon.setBounds(70, 164, 250, 170);

        izq.setText("<==");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        getContentPane().add(izq);
        izq.setBounds(110, 400, 57, 23);

        der.setText("==>");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });
        getContentPane().add(der);
        der.setBounds(180, 400, 57, 23);

        EspeciePokemon.setBackground(new java.awt.Color(0, 153, 204));
        EspeciePokemon.setForeground(new java.awt.Color(255, 255, 255));
        EspeciePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EspeciePokemon.setOpaque(true);
        getContentPane().add(EspeciePokemon);
        EspeciePokemon.setBounds(610, 330, 90, 20);

        HabilidadPokemon.setBackground(new java.awt.Color(0, 153, 204));
        HabilidadPokemon.setForeground(new java.awt.Color(255, 255, 255));
        HabilidadPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HabilidadPokemon.setOpaque(true);
        getContentPane().add(HabilidadPokemon);
        HabilidadPokemon.setBounds(610, 300, 90, 20);

        Mov4.setBackground(new java.awt.Color(0, 0, 0));
        Mov4.setForeground(new java.awt.Color(255, 255, 255));
        Mov4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Mov4);
        Mov4.setBounds(610, 220, 80, 30);

        Mov3.setBackground(new java.awt.Color(0, 0, 0));
        Mov3.setForeground(new java.awt.Color(255, 255, 255));
        Mov3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Mov3);
        Mov3.setBounds(610, 180, 80, 30);

        Mov2.setBackground(new java.awt.Color(0, 0, 0));
        Mov2.setForeground(new java.awt.Color(255, 255, 255));
        Mov2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Mov2);
        Mov2.setBounds(470, 220, 110, 30);

        Mov1.setBackground(new java.awt.Color(0, 0, 0));
        Mov1.setForeground(new java.awt.Color(255, 255, 255));
        Mov1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Mov1);
        Mov1.setBounds(470, 180, 110, 30);

        NombrePokemon.setBackground(new java.awt.Color(51, 204, 0));
        NombrePokemon.setForeground(new java.awt.Color(255, 255, 255));
        NombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NombrePokemon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NombrePokemon.setOpaque(true);
        getContentPane().add(NombrePokemon);
        NombrePokemon.setBounds(94, 450, 130, 70);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("4º");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(590, 230, 20, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("3º");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(590, 190, 20, 20);

        TipoPokemon.setBackground(new java.awt.Color(0, 0, 0));
        TipoPokemon.setForeground(new java.awt.Color(255, 255, 255));
        TipoPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TipoPokemon.setOpaque(true);
        getContentPane().add(TipoPokemon);
        TipoPokemon.setBounds(230, 340, 80, 40);

        jLabel9.setText("Especie");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(560, 330, 100, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("2º");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(460, 230, 20, 20);

        Tipo2Pokemon.setBackground(new java.awt.Color(0, 0, 0));
        Tipo2Pokemon.setForeground(new java.awt.Color(255, 255, 255));
        Tipo2Pokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tipo2Pokemon.setOpaque(true);
        getContentPane().add(Tipo2Pokemon);
        Tipo2Pokemon.setBounds(130, 340, 90, 40);

        AlturaPokemon.setBackground(new java.awt.Color(0, 0, 0));
        AlturaPokemon.setForeground(new java.awt.Color(255, 255, 255));
        AlturaPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(AlturaPokemon);
        AlturaPokemon.setBounds(510, 330, 40, 30);

        PesoPokemon.setBackground(new java.awt.Color(0, 0, 0));
        PesoPokemon.setForeground(new java.awt.Color(255, 255, 255));
        PesoPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(PesoPokemon);
        PesoPokemon.setBounds(510, 290, 40, 30);

        descripcionPokemon.setBackground(new java.awt.Color(0, 0, 0));
        descripcionPokemon.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(descripcionPokemon);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(440, 370, 280, 150);

        jLabel8.setText("Hab");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(570, 300, 70, 20);

        HabitatPokemon.setBackground(new java.awt.Color(51, 153, 0));
        HabitatPokemon.setForeground(new java.awt.Color(255, 255, 255));
        HabitatPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HabitatPokemon.setOpaque(true);
        getContentPane().add(HabitatPokemon);
        HabitatPokemon.setBounds(220, 90, 100, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("1º");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(460, 190, 20, 20);

        jLabel2.setText("Kg");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(470, 300, 40, 14);

        jLabel3.setText("Metros");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(470, 340, 90, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex_1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, -30, 880, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        // TODO add your handling code here:
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
            if (resultadoConsulta.last()) {

                NombrePokemon.setText(resultadoConsulta.getString(2));
                AlturaPokemon.setText(resultadoConsulta.getString(3));
                PesoPokemon.setText(resultadoConsulta.getString(4));
                EspeciePokemon.setText(resultadoConsulta.getString(5));
                HabitatPokemon.setText(resultadoConsulta.getString(6));
                TipoPokemon.setText(resultadoConsulta.getString(7));
                Tipo2Pokemon.setText(resultadoConsulta.getString(8));
                HabilidadPokemon.setText(resultadoConsulta.getString(9));
                Mov1.setText(resultadoConsulta.getString(10));
                Mov2.setText(resultadoConsulta.getString(11));
                Mov3.setText(resultadoConsulta.getString(12));
                Mov4.setText(resultadoConsulta.getString(13));
                descripcionPokemon.setText(resultadoConsulta.getString(16));
                sonidoPasar s = new sonidoPasar();
                s.start();

            } else {
                NombrePokemon.setText("Este pokemon no figura en la pokedex");
                TipoPokemon.setText("Este pokemon no figura en la pokedex");
                Tipo2Pokemon.setText("Este pokemon no figura en la pokedex");
                PesoPokemon.setText("Este pokemon no figura en la pokedex");
                AlturaPokemon.setText("Este pokemon no figura en la pokedex");
            }
        } catch (SQLException ex) {
        }
        contador--;
        if (contador <= 0) {
            contador = 0;

        }

    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        // TODO add your handling code here:
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
            if (resultadoConsulta.next()) {
                /*
                Nombre
                Tipo 1
                Tipo 2
                Peso
                Altura
                 */
                NombrePokemon.setText(resultadoConsulta.getString(2));
                AlturaPokemon.setText(resultadoConsulta.getString(3));
                PesoPokemon.setText(resultadoConsulta.getString(4));
                EspeciePokemon.setText(resultadoConsulta.getString(5));
                HabitatPokemon.setText(resultadoConsulta.getString(6));
                TipoPokemon.setText(resultadoConsulta.getString(7));
                Tipo2Pokemon.setText(resultadoConsulta.getString(8));
                HabilidadPokemon.setText(resultadoConsulta.getString(9));
                Mov1.setText(resultadoConsulta.getString(10));
                Mov2.setText(resultadoConsulta.getString(11));
                Mov3.setText(resultadoConsulta.getString(12));
                Mov4.setText(resultadoConsulta.getString(13));
                descripcionPokemon.setText(resultadoConsulta.getString(16));
                sonidoPasar s = new sonidoPasar();
                s.start();
            } else {
                NombrePokemon.setText("Este pokemon no figura en la pokedex");
                TipoPokemon.setText("Este pokemon no figura en la pokedex");
                Tipo2Pokemon.setText("Este pokemon no figura en la pokedex");
                PesoPokemon.setText("Este pokemon no figura en la pokedex");
                AlturaPokemon.setText("Este pokemon no figura en la pokedex");
            }
        } catch (SQLException ex) {
        }
        contador++;
        if (contador >= 150) {
            contador = 150;

        }

    }//GEN-LAST:event_derActionPerformed
    public class sonidoPasar extends Thread {//Creamos un hilo para que  												

        public void run() {                     //reproduzca el sonido a la vez
            pokedexSonidos s = new pokedexSonidos(); //que sigue el juego
            s.ReproducirSonido(s.getClass().getResource("/sonidos/sonidoPasar.wav").getFile(), 3000);
        }
    }

    public class sonidoDeFondo extends Thread {//Creamos un hilo para que  												

        public void run() {                     //reproduzca el sonido a la vez
            pokedexSonidos s = new pokedexSonidos(); //que sigue el juego
            s.ReproducirSonido(s.getClass().getResource("/sonidos/bso.wav").getFile(), 100000);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlturaPokemon;
    private javax.swing.JLabel EspeciePokemon;
    private javax.swing.JLabel HabilidadPokemon;
    private javax.swing.JLabel HabitatPokemon;
    private javax.swing.JLabel Mov1;
    private javax.swing.JLabel Mov2;
    private javax.swing.JLabel Mov3;
    private javax.swing.JLabel Mov4;
    private javax.swing.JLabel NombrePokemon;
    private javax.swing.JLabel PesoPokemon;
    private javax.swing.JLabel Tipo2Pokemon;
    private javax.swing.JLabel TipoPokemon;
    private javax.swing.JButton der;
    private javax.swing.JTextPane descripcionPokemon;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
