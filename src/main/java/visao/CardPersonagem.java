/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import modelo.personagem.Personagem;
import modelo.personagem.TipoPersonagem;
import controle.Controle;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class CardPersonagem extends JFrame {

    public CardPersonagem(Personagem p) {
        setResizable(false);
        javax.swing.JLabel EnLabel;
        javax.swing.JLabel classe;
        javax.swing.JLabel en;
        javax.swing.JButton especActivate;
        javax.swing.JLabel foto;
        javax.swing.JLabel hp;
        javax.swing.JLabel hpLabel;
        javax.swing.JButton okButton;
        javax.swing.JPanel quadro;
        javax.swing.JPanel rodape;
        javax.swing.JPanel todo;
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        java.awt.GridBagConstraints gridBagConstraints;
        todo = new javax.swing.JPanel();
        quadro = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();
        rodape = new javax.swing.JPanel();
        classe = new javax.swing.JLabel();
        hpLabel = new javax.swing.JLabel();
        EnLabel = new javax.swing.JLabel();
        en = new javax.swing.JLabel();
        hp = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        especActivate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        todo.setBackground(new java.awt.Color(51, 51, 51));
        todo.setForeground(new java.awt.Color(51, 51, 51));
        todo.setLayout(new java.awt.GridBagLayout());

        quadro.setBorder(new javax.swing.border.MatteBorder(null));

        foto.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(quadro);
        quadro.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 330;
        gridBagConstraints.ipady = 289;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        switch (p.getTipoPersonagem()) {
            case ARQUEIRO:
                foto.setIcon(new ImageIcon(getClass().getResource("/Archer.jpg")));
                break;
            case GUERREIRO:
                foto.setIcon(new ImageIcon(getClass().getResource("/Guerreiro.jpg")));
                break;
            case ASSASSINO:
                foto.setIcon(new ImageIcon(getClass().getResource("/Assassino.jpg")));
                break;
            case BARDO:
                foto.setIcon(new ImageIcon(getClass().getResource("/Bardo.jpg")));
                break;
            default:
                foto.setIcon(new ImageIcon(getClass().getResource("/Clerigo.jpg")));
                break;
        }
        quadro.add(foto, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 27, 0, 0);
        todo.add(quadro, gridBagConstraints);

        rodape.setBackground(new java.awt.Color(0, 51, 102));
        rodape.setLayout(new java.awt.GridBagLayout());

        classe.setBackground(new java.awt.Color(255, 255, 255));
        classe.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        classe.setForeground(new java.awt.Color(255, 255, 255));
        classe.setText(p.getTipoPersonagem().toString());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 50, 0, 0);
        rodape.add(classe, gridBagConstraints);

        hpLabel.setBackground(new java.awt.Color(255, 255, 255));
        hpLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        hpLabel.setForeground(new java.awt.Color(255, 255, 255));
        hpLabel.setText("HP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 24, 0, 0);
        rodape.add(hpLabel, gridBagConstraints);

        EnLabel.setBackground(new java.awt.Color(255, 255, 255));
        EnLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        EnLabel.setForeground(new java.awt.Color(255, 255, 255));
        EnLabel.setText("Energia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 24, 0, 0);
        rodape.add(EnLabel, gridBagConstraints);

        en.setBackground(new java.awt.Color(255, 255, 255));
        en.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        en.setForeground(new java.awt.Color(255, 255, 255));
        en.setText("" + p.getEnergia());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 11, 0, 20);
        rodape.add(en, gridBagConstraints);

        hp.setBackground(new java.awt.Color(255, 255, 255));
        hp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        hp.setForeground(new java.awt.Color(255, 255, 255));
        hp.setText("" + p.getHP());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 11, 0, 0);
        rodape.add(hp, gridBagConstraints);

        okButton.setBackground(new java.awt.Color(153, 0, 0));
        okButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        okButton.setForeground(new java.awt.Color(0, 0, 204));
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 32, 14, 0);
        rodape.add(okButton, gridBagConstraints);

        especActivate.setBackground(new java.awt.Color(153, 0, 0));
        especActivate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        especActivate.setForeground(new java.awt.Color(0, 0, 204));
        especActivate.setText("ESPECIAL!");
        especActivate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        especActivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                especActivateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 24, 14, 0);
        rodape.add(especActivate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        todo.add(rodape, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(todo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(todo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        // </editor-fold>
    }

    private void especActivateActionPerformed(java.awt.event.ActionEvent evt) {
        Controle.getObject().doSpecialMove();
        Personagem perso = Controle.getObject().getJogadorDaVez().getCelulaSelecionada().getPersonagem();
        if (perso.getEnergia() < perso.getTipoPersonagem().getMinimoEspecial()) {
            JOptionPane.showMessageDialog(null, "Energia insuficiente", "oops", JOptionPane.PLAIN_MESSAGE);
        }
        if (perso.getAtacou()) {
            JOptionPane.showMessageDialog(null, "Personagem já atacou neste turno", "oops", JOptionPane.PLAIN_MESSAGE);
        } if(perso.getEnergia() >= perso.getTipoPersonagem().getMinimoEspecial() && !perso.getAtacou()){
            dispose();
        }
        // TODO add your handling code here:
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        // TODO add your handling code here:
    }

}
