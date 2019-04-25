
package cluedo.view.board;

import cluedo.logic.cards.Card;
import cluedo.logic.controller.GameController;
import cluedo.logic.player.Player;
import cluedo.tools.languagestring.LanguageStrings;
import cluedo.view.AbstractBaseWindow;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *This class is responsible for showing the suspected cards when the computer player
 * suspects a triumvirate of cards.
 */
public class AiSuspectCardWindow extends JFrame {

private final GameController gameController;
private final Card murderCard;
private final Card murderWeaponCard;
private final Card murderRoomCard;
private boolean canShow;
private Map<javax.swing.JButton, Card> cardButtonMap;
    public AiSuspectCardWindow(GameController gameController, Card murderCard, Card murderWeaponCard, Card murderRoomCard) {
        this.gameController=gameController;
        this.murderCard=murderCard;
        this.murderWeaponCard=murderWeaponCard;
        this.murderRoomCard=murderRoomCard;
        cardButtonMap=new HashMap<>();
        canShow=false;
        initComponents();
        cardButtonMap.put(jbMurderCard, this.murderCard);
        cardButtonMap.put(jbMurderWeaponCard, this.murderWeaponCard);
        cardButtonMap.put(jbMurderRoomCard, this.murderRoomCard);
        jbNothing.setEnabled(canShow);
    }
private void customizeMurderButton(javax.swing.JButton button){
    button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setSize(217, 242);
            Player humanPlayer=gameController.getHumanPlayer();
            if(humanPlayer.ownsSuspectCardAccordingToTitle(button.getText())){
                canShow=true;
                button.setBackground(new Color(102,255,102));
                button.addActionListener((ActionEvent evt) -> showingThisCardAsProof(evt));
            }else{
                button.setBackground(new Color(255,0,0));
            }
}
private void showingThisCardAsProof(ActionEvent evt){
    javax.swing.JButton button=(javax.swing.JButton) evt.getSource();
    int answer=AbstractBaseWindow.showConfirmation(LanguageStrings.getString("Suspect.SureToShowThisCard")+button.getText()+"?", null);
    if(answer==JOptionPane.YES_OPTION){
        gameController.fireRemoveAiSuspectCardWindow();
        this.dispose();
       Card provedCard= cardButtonMap.get(button);
       gameController.showCardForAi(provedCard);
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

        jpBase = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jbMurderCard = new javax.swing.JButton(murderCard.getNameForUI(), new ImageIcon(getClass().getResource(murderCard.getImageName())));
        jbMurderWeaponCard = new javax.swing.JButton(murderWeaponCard.getNameForUI(), new ImageIcon(getClass().getResource(murderWeaponCard.getImageName())));
        jbMurderRoomCard = new javax.swing.JButton(murderRoomCard.getNameForUI(), new ImageIcon(getClass().getResource(murderRoomCard.getImageName())));
        jbNothing = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(LanguageStrings.getString("Suspect.Evidence"));

        jpBase.setBackground(new Color(0, 0, 0));

        jlTitle.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlTitle.setForeground(new Color(180, 0, 0));
        jlTitle.setText("<html>"+gameController.getActualPlayer().toString()+LanguageStrings.getString("Actions.ChooseCardToProve")+"</html>");

        customizeMurderButton(jbMurderCard);

        customizeMurderButton(jbMurderWeaponCard);

        customizeMurderButton(jbMurderRoomCard);

        jbNothing.setBackground(new Color(255, 30, 21));
        jbNothing.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jbNothing.setText(LanguageStrings.getString("Suspect.Nothing"));
        jbNothing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbNothingActionPerformed();
            }
        });

        javax.swing.GroupLayout jpBaseLayout = new javax.swing.GroupLayout(jpBase);
        jpBase.setLayout(jpBaseLayout);
        jpBaseLayout.setHorizontalGroup(
            jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jbMurderCard, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jbMurderWeaponCard, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jbMurderRoomCard, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBaseLayout.createSequentialGroup()
                        .addComponent(jlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBaseLayout.createSequentialGroup()
                        .addComponent(jbNothing)
                        .addGap(322, 322, 322))))
        );
        jpBaseLayout.setVerticalGroup(
            jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbMurderWeaponCard, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jbMurderRoomCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbMurderCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jbNothing)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNothingActionPerformed() {//GEN-FIRST:event_jbNothingActionPerformed
        gameController.showCardForAi(null);
        gameController.fireRemoveAiSuspectCardWindow();
        this.dispose();
    }//GEN-LAST:event_jbNothingActionPerformed

public void resetStrings(){
    jbNothing.setText(LanguageStrings.getString("Suspect.Nothing"));
    jlTitle.setText(LanguageStrings.getString("Actions.ChooseCardToProve"));
    jbMurderCard.setText(murderCard.getNameForUI());
    jbMurderWeaponCard.setText(murderWeaponCard.getNameForUI());
    jbMurderRoomCard.setText(murderRoomCard.getNameForUI());
    setTitle(LanguageStrings.getString("Suspect.Evidence"));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbMurderCard;
    private javax.swing.JButton jbMurderRoomCard;
    private javax.swing.JButton jbMurderWeaponCard;
    private javax.swing.JButton jbNothing;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpBase;
    // End of variables declaration//GEN-END:variables
}
