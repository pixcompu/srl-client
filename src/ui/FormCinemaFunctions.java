package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import logic.CinemaFunction;
import logic.CinemaManager;
import logic.Movie;
import logic.Room;

/**
 *
 * @author PIX
 */
public class FormCinemaFunctions extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Functions
     */
    public FormCinemaFunctions() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.funtionListArea.setBackground(Color.BLUE.darker().darker().darker());

        CinemaManager cinemaManager = getDummyCinemaManager();
        Iterator<CinemaFunction> functions = cinemaManager.getAll();
        showFunctions(functions);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollingArea = new javax.swing.JScrollPane();
        funtionListArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout funtionListAreaLayout = new javax.swing.GroupLayout(funtionListArea);
        funtionListArea.setLayout(funtionListAreaLayout);
        funtionListAreaLayout.setHorizontalGroup(
            funtionListAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        funtionListAreaLayout.setVerticalGroup(
            funtionListAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        scrollingArea.setViewportView(funtionListArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollingArea, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollingArea, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FormCinemaFunctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCinemaFunctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCinemaFunctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCinemaFunctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCinemaFunctions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel funtionListArea;
    private javax.swing.JScrollPane scrollingArea;
    // End of variables declaration//GEN-END:variables

    private void showFunctions(Iterator<CinemaFunction> functions) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (screenSize.width / 100) * 80;
        int heigth = (screenSize.width / 100) * 15;

        Dimension functionPanelDimension = new Dimension(width, heigth);

        BoxLayout layout = new BoxLayout(this.funtionListArea, BoxLayout.Y_AXIS);
        this.funtionListArea.setLayout(layout);

        JLabel windowTitle = new JLabel("Funciones en Cartelera");
        windowTitle.setFont(new Font("Impact", Font.PLAIN, 70));
        windowTitle.setAlignmentX(CENTER_ALIGNMENT);
        windowTitle.setForeground(Color.YELLOW);
        this.funtionListArea.add(windowTitle);
        this.funtionListArea.add(Box.createVerticalStrut(10));

        while (functions.hasNext()) {

            CinemaFunction current = functions.next();

            JPanel functionPanel = new JPanel();
            setSize(functionPanel, functionPanelDimension);
            functionPanel.setBackground(Color.WHITE);
            functionPanel.setLayout(new BoxLayout(functionPanel, BoxLayout.X_AXIS));
            functionPanel.setBorder(new LineBorder(Color.YELLOW));

            //Poster of each.
            JLabel functionPoster = new JLabel();
            Dimension posterDimension = new Dimension(180, heigth);
            ImageIcon poster = new ImageIcon(getClass().getResource("/ui/resources/deadpoolIcon.jpg"));
            Image scaledImage = poster.getImage().getScaledInstance(180, heigth, Image.SCALE_DEFAULT);
            functionPoster.setIcon(new ImageIcon(scaledImage));
            setSize(functionPoster, posterDimension);

            //Information
            JPanel functionControls = new JPanel();
            Dimension controlsDimension = new Dimension(functionPanelDimension.width - 180, heigth);
            setSize(functionControls, controlsDimension);
            functionControls.setBackground(Color.BLACK);
            functionControls.setLayout(new BoxLayout(functionControls, BoxLayout.Y_AXIS));

            //Movie Title
            JPanel panelTitle = new JPanel();
            panelTitle.setBackground(Color.RED.darker().darker());
            panelTitle.setForeground(Color.WHITE);
            JLabel movieTitle = new JLabel(current.getMovie().getMovieName());
            movieTitle.setForeground(Color.WHITE);
            movieTitle.setFont(new Font("Century Gothic", Font.PLAIN, 40));
            panelTitle.add(movieTitle);
            functionControls.add(panelTitle);

            //Movie Description
            JPanel panelDescription = new JPanel();
            panelDescription.setBackground(Color.RED.darker().darker().darker());
            JLabel movieDescription = new JLabel("\"" + current.getMovie().getMovieDescription() + "\"");
            movieDescription.setForeground(Color.WHITE);
            panelDescription.add(movieDescription);
            functionControls.add(panelDescription);

            //Movie Schedule
            JPanel panelSchedule = new JPanel();
            panelSchedule.setBackground(Color.RED.darker().darker().darker().darker());
            JLabel movieSchedule = new JLabel(current.getSchedule());
            movieSchedule.setForeground(Color.WHITE);
            panelSchedule.add(movieSchedule);
            functionControls.add(panelSchedule);

            //Button
            JPanel panelAction = new JPanel();
            panelAction.setLayout(new BoxLayout(panelAction, BoxLayout.X_AXIS));
            panelAction.setBackground(Color.BLACK);
            JButton btn = new JButton("Comprar boletos");
            btn.setActionCommand(current.getMovie().getMovieID());
            btn.addActionListener(this);
            panelAction.add(Box.createHorizontalGlue());
            btn.setMargin(new Insets(5, 5, 5, 5));
            panelAction.setBorder(new EmptyBorder(new Insets(10, 0, 10, 10)));
            panelAction.add(btn);
            functionControls.add(panelAction);

            functionPanel.add(functionPoster);
            functionPanel.add(functionControls);
            this.funtionListArea.add(functionPanel);
            this.funtionListArea.add(Box.createVerticalStrut(20));
        }
    }

    private void setSize(Component component, Dimension dimension) {
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setSize(dimension);
        component.setMaximumSize(dimension);
    }

    private static CinemaManager getDummyCinemaManager() {
        CinemaManager manager = CinemaManager.getInstance();

        Movie avengers = new Movie("0", "Avengers The Movie", "A film about hulk and shit");
        Room roomOne = new Room(5, 10);

        CinemaFunction avengersFunction = new CinemaFunction(roomOne, avengers, "4:00PM - 6:00PM");

        Movie zootopia = new Movie("1", "Zootopia", "The sloth is awesome");
        Room roomTwo = new Room(5, 10);

        CinemaFunction zootopiaFunction = new CinemaFunction(roomTwo, zootopia, "4:00PM - 6:00PM");

        Movie deadpool = new Movie("2", "Deadpool", "Fucking deadpool");
        Room roomThree = new Room(5, 10);

        CinemaFunction deadpoolFunction = new CinemaFunction(roomThree, deadpool, "4:00PM - 6:00PM");

        Movie reenevant = new Movie("3", "The Reenevant", "Leo won a Oscar");
        Room roomFour = new Room(5, 10);
        CinemaFunction reenevantFunction = new CinemaFunction(roomFour, reenevant, "4:00PM - 6:00PM");

        manager.add(avengersFunction);
        manager.add(zootopiaFunction);
        manager.add(deadpoolFunction);
        manager.add(reenevantFunction);

        changeSeatStates(avengers.getMovieID(), roomOne, 13);
        changeSeatStates(zootopia.getMovieID(), roomTwo, 10);
        changeSeatStates(deadpool.getMovieID(), roomThree, 20);
        changeSeatStates(reenevant.getMovieID(), roomFour, 40);
        
        return manager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogSeats dialogSeats = new DialogSeats(this, true, e.getActionCommand());
        dialogSeats.setVisible(true);
    }

    private static void changeSeatStates(String itemID, Room room, int seatsNumber) {
        Random randomGen = new Random();
        for (int i = 0; i <= seatsNumber; i++) {
            int state = randomGen.nextInt(4);
            int row = randomGen.nextInt(room.getRows());
            int column = randomGen.nextInt(room.getColumns());
            CinemaManager.getInstance().changeSeatState(itemID, row, column, state);
        }
    }
}