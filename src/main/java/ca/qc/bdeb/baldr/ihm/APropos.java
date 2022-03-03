/*
 * APropos.java
 *
 * Created on 31 mars 2007, 17:15
 *$Id: APropos.java 240 2007-08-02 20:17:58Z zeta $
 */
package ca.qc.bdeb.baldr.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Frame with greetings when starting
 *
 * @author Baldr Team
 */
public class APropos extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form APropos
     */
    private Timer t, scroll;
    private String[] about;
    private int pos, count;
    private ResourceBundle messages;
    private int scrollTime;

    public APropos(WindowBaldr win) {
        messages = win.getMessages();
        initComponents();
        initialiserImages();
        about = labelText.getText().split("<br>");
        labelText.setText("");

        setAlwaysOnTop(true);
        setTitle("A propos");

        setLocationRelativeTo(win);
        this.setVisible((true));

        t = new Timer(5000, this);
        t.start();

        scrollTime = 800;
        scroll = new Timer(scrollTime, this);
        scroll.setInitialDelay(0);

        startAbout();
    }

    public void updateStringAbout() {
        about = labelText.getText().split("<br>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        labelTitre = new javax.swing.JLabel();
        labelText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelTitre.setText(messages.getString("About_Title")); // NOI18N

        labelText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelText.setText(messages.getString("About_Text"));
        labelText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelImage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .add(labelText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(labelTitre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(labelImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 350, Short.MAX_VALUE)
                .add(labelTitre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelText.getAccessibleContext().setAccessibleName("");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void initialiserImages() {
        URL urlButton = getClass().getResource("/Images/baldr.png");
        labelImage.setIcon(new javax.swing.ImageIcon(urlButton));
    }

    public void startAbout() {
        pos = count = 0;
        scroll.restart();
    }

    private void scroll() {
        StringBuffer buf = new StringBuffer();

        if (t.isRunning()) {
            scroll.stop();
        }

        if (pos >= about.length) {
            pos = count = 0;
        }

        for (int i = pos; i < (pos + 5); i++) {
            if (i < about.length) {
                buf.append("<br>" + about[i]);
            }
        }
        labelText.setText("<html><center>" + buf + "</center></html>");
        if (count > 2) {
            pos += 1;
        }

        count += 1;
    }
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        fprop();
    }//GEN-LAST:event_formKeyPressed

    private void fprop() {
        t.stop();
        scroll.stop();
        setVisible(false);
        this.dispose();
    }

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        fprop();
    }//GEN-LAST:event_formFocusLost

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        fprop();
    }//GEN-LAST:event_formMouseClicked

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
    }//GEN-LAST:event_jPanel1FocusGained

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        // TODO add your handling code here:
        // TODO add your handling code here:
        int notches = evt.getWheelRotation();
        if (notches < 0) {
        } else {
            //scroll vers le bas 
            scroll();
        }
    }//GEN-LAST:event_formMouseWheelMoved
    /**
     * Action Listener
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == t) {
            fprop();
        }
        if (e.getSource() == scroll) {
            scroll();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelText;
    private javax.swing.JLabel labelTitre;
    // End of variables declaration//GEN-END:variables

    public JLabel getLabelText() {
        return labelText;
    }

    public JLabel getLabelTitre() {
        return labelTitre;
    }
}