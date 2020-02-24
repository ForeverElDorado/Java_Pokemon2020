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
import javax.imageio.ImageIO;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 1;

    Statement estado;
    Connection conexion;
    //Declaramos para guardar el Hashmap y todo el contenido de la base de datos de golpe
    HashMap<String, Pokemon> listaPokemon = new HashMap();
    ////////////////
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
            resultadoConsulta = estado.executeQuery("Select * from pokemon");
            while (resultadoConsulta.next()) {
                Pokemon p = new Pokemon();
                p.nombre = resultadoConsulta.getString("nombre");
                p.especie = resultadoConsulta.getString("especie");
                p.movimiento1 = resultadoConsulta.getString("movimiento1");
                p.peso = resultadoConsulta.getString("peso");
                p.movimiento2 = resultadoConsulta.getString("movimiento2");
                p.movimiento3 = resultadoConsulta.getString("movimiento3");
                p.movimiento4 = resultadoConsulta.getString("movimiento4");
                p.descripcion = resultadoConsulta.getString("descripcion");
                p.tipo1 = resultadoConsulta.getString("tipo1");
                p.tipo2 = resultadoConsulta.getString("tipo2");
                p.altura = resultadoConsulta.getString("altura");
                p.habilidad = resultadoConsulta.getString("habilidad");
                p.habitad = resultadoConsulta.getString("habitat");

                listaPokemon.put(resultadoConsulta.getString("id"), p);
                listaPokemon.put(resultadoConsulta.getString("tipo1"), p);
            }
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
        jLabel3 = new javax.swing.JLabel();
        DescripcionPokemon = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        HabitadPokemon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EspeciePokemon = new javax.swing.JLabel();
        PesoPokemon = new javax.swing.JLabel();
        HabilidadPokemon = new javax.swing.JLabel();
        Ataque3 = new javax.swing.JLabel();
        Ataque4 = new javax.swing.JLabel();
        NombrePokemon = new javax.swing.JLabel();
        AlturaPokemon = new javax.swing.JLabel();
        Ataque2 = new javax.swing.JLabel();
        Ataque1 = new javax.swing.JLabel();
        der = new javax.swing.JButton();
        izq = new javax.swing.JButton();
        TipoPokemon = new javax.swing.JLabel();
        Tipo2Pokemon = new javax.swing.JLabel();
        pokedex = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        getContentPane().add(imagenPokemon);
        imagenPokemon.setBounds(70, 200, 230, 140);

        jLabel3.setBackground(new java.awt.Color(102, 153, 255));
        jLabel3.setText("m");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(510, 360, 20, 20);

        DescripcionPokemon.setBackground(new java.awt.Color(0, 0, 0));
        DescripcionPokemon.setFont(new java.awt.Font("Vollkorn Bold", 0, 11)); // NOI18N
        DescripcionPokemon.setForeground(new java.awt.Color(255, 255, 255));
        DescripcionPokemon.setOpaque(true);
        getContentPane().add(DescripcionPokemon);
        DescripcionPokemon.setBounds(440, 390, 270, 150);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("4º");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(570, 260, 20, 40);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("3º");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(570, 220, 20, 40);

        jLabel9.setBackground(new java.awt.Color(102, 153, 255));
        jLabel9.setText("Hab");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(550, 320, 30, 30);

        jLabel8.setBackground(new java.awt.Color(102, 153, 255));
        jLabel8.setText("Especie");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(550, 360, 60, 20);

        jLabel10.setBackground(new java.awt.Color(102, 153, 255));
        jLabel10.setText("Kg");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(510, 320, 30, 30);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("2º");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(450, 260, 20, 40);

        HabitadPokemon.setBackground(new java.awt.Color(0, 204, 51));
        HabitadPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HabitadPokemon.setOpaque(true);
        getContentPane().add(HabitadPokemon);
        HabitadPokemon.setBounds(200, 120, 130, 30);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1º");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(450, 220, 20, 40);

        EspeciePokemon.setBackground(new java.awt.Color(102, 153, 255));
        EspeciePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EspeciePokemon.setOpaque(true);
        getContentPane().add(EspeciePokemon);
        EspeciePokemon.setBounds(600, 350, 80, 30);

        PesoPokemon.setBackground(new java.awt.Color(255, 255, 0));
        PesoPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(PesoPokemon);
        PesoPokemon.setBounds(450, 320, 50, 30);

        HabilidadPokemon.setBackground(new java.awt.Color(102, 153, 255));
        HabilidadPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HabilidadPokemon.setOpaque(true);
        getContentPane().add(HabilidadPokemon);
        HabilidadPokemon.setBounds(600, 320, 80, 30);

        Ataque3.setBackground(new java.awt.Color(0, 0, 0));
        Ataque3.setForeground(new java.awt.Color(255, 255, 255));
        Ataque3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Ataque3);
        Ataque3.setBounds(590, 220, 100, 40);

        Ataque4.setBackground(new java.awt.Color(0, 0, 0));
        Ataque4.setForeground(new java.awt.Color(255, 255, 255));
        Ataque4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Ataque4);
        Ataque4.setBounds(590, 260, 100, 40);

        NombrePokemon.setBackground(new java.awt.Color(0, 153, 0));
        NombrePokemon.setForeground(new java.awt.Color(255, 255, 255));
        NombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NombrePokemon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NombrePokemon.setOpaque(true);
        getContentPane().add(NombrePokemon);
        NombrePokemon.setBounds(80, 470, 140, 70);

        AlturaPokemon.setBackground(new java.awt.Color(255, 255, 0));
        AlturaPokemon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(AlturaPokemon);
        AlturaPokemon.setBounds(460, 360, 50, 20);

        Ataque2.setBackground(new java.awt.Color(0, 0, 0));
        Ataque2.setForeground(new java.awt.Color(255, 255, 255));
        Ataque2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Ataque2);
        Ataque2.setBounds(470, 260, 90, 40);

        Ataque1.setBackground(new java.awt.Color(0, 0, 0));
        Ataque1.setForeground(new java.awt.Color(255, 255, 255));
        Ataque1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Ataque1);
        Ataque1.setBounds(470, 220, 90, 40);

        der.setBackground(new java.awt.Color(0, 0, 0));
        der.setForeground(new java.awt.Color(255, 0, 0));
        der.setText(">");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });
        getContentPane().add(der);
        der.setBounds(170, 370, 40, 20);

        izq.setBackground(new java.awt.Color(255, 0, 0));
        izq.setText("<");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        getContentPane().add(izq);
        izq.setBounds(120, 370, 40, 20);

        TipoPokemon.setBackground(new java.awt.Color(0, 0, 0));
        TipoPokemon.setForeground(new java.awt.Color(255, 255, 255));
        TipoPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TipoPokemon.setOpaque(true);
        getContentPane().add(TipoPokemon);
        TipoPokemon.setBounds(170, 420, 70, 30);

        Tipo2Pokemon.setBackground(new java.awt.Color(0, 0, 0));
        Tipo2Pokemon.setForeground(new java.awt.Color(255, 255, 255));
        Tipo2Pokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tipo2Pokemon.setOpaque(true);
        getContentPane().add(Tipo2Pokemon);
        Tipo2Pokemon.setBounds(90, 420, 70, 30);

        pokedex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex_1.png"))); // NOI18N
        getContentPane().add(pokedex);
        pokedex.setBounds(0, 0, 810, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        // TODO add your handling code here:

        contador--;
        if (contador <= 0) {
            contador = 0;
        }
        dibujaElPokemonQueEstaEnLaPosicion(contador);//porque en el png los pokemon empiezan en el 0
        Pokemon p = listaPokemon.get(String.valueOf(contador + 1));
        if (p != null) {
            NombrePokemon.setText(p.nombre);
            TipoPokemon.setText(p.tipo1);
            Tipo2Pokemon.setText(p.tipo2);
            PesoPokemon.setText(p.peso);
            AlturaPokemon.setText(p.altura);
            Ataque1.setText(p.movimiento1);
            Ataque2.setText(p.movimiento2);
            Ataque3.setText(p.movimiento3);
            Ataque4.setText(p.movimiento4);
            DescripcionPokemon.setText(p.descripcion);
            EspeciePokemon.setText(p.especie);
            HabitadPokemon.setText(p.habitad);
            HabilidadPokemon.setText(p.habilidad);
            sonidoPasar s = new sonidoPasar();
            s.start();
        } else {
            NombrePokemon.setText("NO HAY DATOS");
        }

    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        // TODO add your handling code here:

        contador++;
        if (contador >= 150) {
            contador = 150;
        }
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        Pokemon p = listaPokemon.get(String.valueOf(contador + 1));
        if (p != null) {
            NombrePokemon.setText(p.nombre);
            TipoPokemon.setText(p.tipo1);
            Tipo2Pokemon.setText(p.tipo2);
            PesoPokemon.setText(p.peso);
            AlturaPokemon.setText(p.altura);
            Ataque1.setText(p.movimiento1);
            Ataque2.setText(p.movimiento2);
            Ataque3.setText(p.movimiento3);
            Ataque4.setText(p.movimiento4);
            DescripcionPokemon.setText(p.descripcion);
            EspeciePokemon.setText(p.especie);
            HabitadPokemon.setText(p.habitad);
            HabilidadPokemon.setText(p.habilidad);
            sonidoPasar s = new sonidoPasar();
            s.start();
        } else {
            NombrePokemon.setText("NO HAY DATOS");
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
    private javax.swing.JLabel Ataque1;
    private javax.swing.JLabel Ataque2;
    private javax.swing.JLabel Ataque3;
    private javax.swing.JLabel Ataque4;
    private javax.swing.JLabel DescripcionPokemon;
    private javax.swing.JLabel EspeciePokemon;
    private javax.swing.JLabel HabilidadPokemon;
    private javax.swing.JLabel HabitadPokemon;
    private javax.swing.JLabel NombrePokemon;
    private javax.swing.JLabel PesoPokemon;
    private javax.swing.JLabel Tipo2Pokemon;
    private javax.swing.JLabel TipoPokemon;
    private javax.swing.JButton der;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel pokedex;
    // End of variables declaration//GEN-END:variables
}
