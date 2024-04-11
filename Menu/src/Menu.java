import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.io.IOException;


public class Menu extends JFrame {

    private JButton botaoAp = new JButton("Aposta 0 - 100");
    private JButton botaoAp2 = new JButton("Aposta A - Z");
    private JButton botaoAp3 = new JButton("Aposta Número");
    private JButton botaoEn = new JButton("Desistir");
    private JPanel painel = new JPanel();

    public Menu() {
        setTitle("CASA DE APOSTAS");
        setSize(300, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(new Color(34, 45, 52));
        configBotoes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon imagem = new ImageIcon("Apostinha.PNG");
        JLabel labelImagem = new JLabel(imagem);
        getContentPane().add(labelImagem, BorderLayout.BEFORE_FIRST_LINE);
        setVisible(true);
    }

    private void configBotoes() {
        painel.add(botaoAp);
        painel.add(botaoAp2);
        painel.add(botaoAp3);
        painel.add(botaoEn);
        botaoAp.setPreferredSize(new Dimension(150, 50));
        botaoAp.setBackground(Color.LIGHT_GRAY);
        botaoAp2.setBackground(Color.LIGHT_GRAY);
        botaoAp3.setBackground(Color.LIGHT_GRAY);
        botaoEn.setBackground(Color.LIGHT_GRAY);
        botaoAp2.setPreferredSize(new Dimension(150, 50));
        botaoAp3.setPreferredSize(new Dimension(150, 50));
        botaoEn.setPreferredSize(new Dimension(150, 50));

        getContentPane().add(painel);
        botaoAp.setToolTipText("Aposta 0 - 100");
        botaoAp2.setToolTipText("Aposta A - Z");
        botaoAp3.setToolTipText("Aposta Impar ou Par");
        botaoEn.setToolTipText("Desistir");


        botaoAp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoAp(e);
            }
        });
        botaoAp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoAp2(e);
            }
        });
        botaoAp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoAp3(e);
            }
        });
        botaoEn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoEn(e);
            }
        });

    } private void botaoAp3(ActionEvent e) {
        ImageIcon icon = new ImageIcon("par.png");


        Object numeroApostado = JOptionPane.showInputDialog(
                null, "Digite o seu número", "Aposta Número",
                JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        JOptionPane.showMessageDialog(null,"Número Apostado: " + numeroApostado);

        int numero = Integer.parseInt(numeroApostado.toString());

        if (numero % 2 == 0){
            JOptionPane.showMessageDialog(null, "O apostador ganhou 500R$");
        }else {
            JOptionPane.showMessageDialog(null, "Perdeu Otário!");
        }
    }
    private void botaoEn(ActionEvent e) {
        ImageIcon icon = new ImageIcon("risada.png");
        Object Desistencia = JOptionPane.showInputDialog(
                null, "Deseja Desistir? Digite Apostar caso contrário", "Desistencia",
                JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        JOptionPane.showMessageDialog(null,"Resposta: " + Desistencia);
       if(Desistencia != null){
           String resposta = Desistencia.toString();
           if(resposta.equals("Sim")){
               System.exit(0);
           } else if (resposta.equals("Apostar")) {

           } else {
               JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
           }
       } else {
           JOptionPane.showMessageDialog(null, "Você fechou a conversa sem digitar a sua escolha", "Informação", JOptionPane.INFORMATION_MESSAGE);
       }
       }





    public static void main(String[] args) {
        new Menu();

    }

    private void botaoAp(ActionEvent e) {
        ImageIcon icon = new ImageIcon("cassino.PNG");
        Object numeroApostado = JOptionPane.showInputDialog(null,"Digite o seu número de 0 a 100",
                "Aposta 1",JOptionPane.INFORMATION_MESSAGE,
                icon, null,"");

        JOptionPane.showMessageDialog(null,"Número Apostado: " + numeroApostado);
        int numero = Integer.parseInt(numeroApostado.toString());
        if(numero < 0 || numero >100 ) {
            JOptionPane.showMessageDialog(null,"Valor Inválido");
        } else {
            double numeroAleatorio = Math.random() * 101;
            int oi = (int)numeroAleatorio;
            JOptionPane.showMessageDialog(null,"Número sorteado: " + oi);
            if( numeroAleatorio == oi){
                JOptionPane.showMessageDialog(null,"O apostador ganhou 1000R$");
            } if( numeroAleatorio != oi){
                JOptionPane.showMessageDialog(null,"Perdeu seu Trouxa!");
            }
        }

    }
    private void botaoAp2(ActionEvent e) {
        JTextField inserirTexto = new JTextField(1);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Digite uma letra de A até Z: "));
        panel.add(inserirTexto);
        ImageIcon icon = new ImageIcon("roleta.PNG");
        int letraApostada = JOptionPane.showConfirmDialog(null, panel, "Aposta 2", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        if (letraApostada == JOptionPane.OK_OPTION) {
            try {
                String texto = inserirTexto.getText();

                if (texto.length() == 1 && Character.isLetter(texto.charAt(0))) {
                    char letra = Character.toUpperCase(texto.charAt(0));
                    if (letra >= 'A' && letra <= 'Z') {
                        JOptionPane.showMessageDialog(null, "Sua letra é: " + letra);
                        Random random = new Random();
                        char letraAleatoria = (char) (random.nextInt(26) + 'A');
                        JOptionPane.showMessageDialog(null, "letra sorteada: " + letraAleatoria);
                        if (letra == letraAleatoria) {
                            JOptionPane.showMessageDialog(null, "o apostador ganhou 500 R$");

                        } else if (letra != letraAleatoria) {
                            JOptionPane.showMessageDialog(null, "Não foi dessa vez, OTÁRIO!!!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aposta inválida.");

                }


            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a aposta: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }




}
    }