package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.CinemaFunction;
import remote.IRemoteMovie;
import remote.RemoteConection;
import ui.util.Notifier;
import ui.util.ThemeValues;

/**
 *
 * @author PIX
 */
public class FormCinemaFunctions extends javax.swing.JFrame {

    private ArrayList<CinemaFunction> functionList;
    private final ThemeValues theme = ThemeValues.getInstance();

    public FormCinemaFunctions() {
        initComponents();
        configureWindow();
        addHeader("Funciones en Cartelera");
        try {
            functionList = getFunctionList();
            showFunctions(functionList.iterator());
        } catch (Exception e) {
            Notifier.showMesage("No se pudo obtener la lista de funciones");
        }
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel funtionListArea;
    private javax.swing.JScrollPane scrollingArea;
    // End of variables declaration//GEN-END:variables

    private void showFunctions(Iterator<CinemaFunction> functions) {

        FunctionCardBuilder cardBuilder = null;

        while (functions.hasNext()) {
            CinemaFunction current = functions.next();
            cardBuilder = new FunctionCardBuilder(this, current);
            cardBuilder.build();
            append(cardBuilder.getCard());
        }
    }

    private ArrayList<CinemaFunction> getFunctionList() throws Exception {
        RemoteConection remoteConection = RemoteConection.getInstance();
        IRemoteMovie remoteMovie = remoteConection.getRemoteObject();
        return remoteMovie.findAll();
    }

    private void configureWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.funtionListArea.setBackground(theme.getBackgroundColor());
    }

    private void addHeader(String viewTitle) {
        BoxLayout layout = new BoxLayout(funtionListArea, BoxLayout.Y_AXIS);
        this.funtionListArea.setLayout(layout);

        JLabel windowTitle = new JLabel(viewTitle);
        windowTitle.setFont(theme.getHeaderFont(70));
        windowTitle.setAlignmentX(CENTER_ALIGNMENT);
        windowTitle.setForeground(theme.getWindowTitleColor());
        this.funtionListArea.add(windowTitle);
        this.funtionListArea.add(Box.createVerticalStrut(10));
    }

    private void append(JPanel card) {
        this.funtionListArea.add(card);
        this.funtionListArea.add(Box.createVerticalStrut(20));
    }

}
