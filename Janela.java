package src;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Janela extends JFrame {

	public int jogadas=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 477, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel mensagem_jogadas = new JLabel("Jogadas:"+jogadas);
		mensagem_jogadas.setBounds(345, 150, 83, 14);
		panel.add(mensagem_jogadas);
		
		//canhoes amarelos
		JLabel canhao_amarelo[] = new JLabel[4];
		for(int i=0;i<4;i++) {
			JLabel canhao = new JLabel();			
			canhao.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/canhao_amarelo.png")));
			canhao.setBounds(0, 50*i+50, 50, 50);
			canhao_amarelo[i]=canhao;
			panel.add(canhao_amarelo[i]);
		}
		
		//canhoes azuis
		JLabel canhao_azul[] = new JLabel[4];
		for(int i=0;i<4;i++) {
			JLabel canhao = new JLabel();			
			canhao.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/canhao_azul.png")));
			canhao.setBounds(50*i+55, 250, 50, 50);
			canhao_azul[i]=canhao;
			panel.add(canhao_azul[i]);
		}
		
		//canhoes verdes
		JLabel canhao_verde[] = new JLabel[4];
		for(int i=0;i<4;i++) {
			JLabel canhao = new JLabel();			
			canhao.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/canhao_verde.png")));
			canhao.setBounds(255, 50*i+50, 50, 50);
			canhao_verde[i]=canhao;
			panel.add(canhao_verde[i]);
		}
		
		//canhoes vermelhos
		JLabel canhao_vermelhos[] = new JLabel[4];
		for(int i=0;i<4;i++) {
			JLabel canhao = new JLabel();			
			canhao.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/canhao_vermelho.png")));
			canhao.setBounds(50*i+55, 0, 50, 50);
			canhao_vermelhos[i]=canhao;
			panel.add(canhao_vermelhos[i]);
		}
		
		//casas amarelas
		JLabel casas_amarelas[][] = new JLabel[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				JLabel casa = new JLabel();
				casa.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/amarelo.png")));
				casa.setBounds(j*50+50, i*50+50, 50, 50);
				casas_amarelas[i][j]=casa;
				casas_amarelas[i][j].setVisible(false);
				panel.add(casas_amarelas[i][j]);
			}
		}
		
		//casas verdes
		JLabel casas_verdes[][] = new JLabel[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				JLabel casa = new JLabel();
				casa.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/verde.png")));
				casa.setBounds(j*50+50, i*50+50, 50, 50);
				casas_verdes[i][j]=casa;
				casas_verdes[i][j].setVisible(false);
				panel.add(casas_verdes[i][j]);
			}
		}
		//casas azuis
		JLabel casas_azuis[][] = new JLabel[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				JLabel casa = new JLabel();
				casa.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/azul.png")));
				casa.setBounds(j*50+50, i*50+50, 50, 50);
				casas_azuis[i][j]=casa;
				casas_azuis[i][j].setVisible(false);
				panel.add(casas_azuis[i][j]);
			}
		}
				
		//casas vermelhas
		JLabel casas_vermelhas[][] = new JLabel[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				JLabel casa = new JLabel();
				casa.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/vermelho.png")));
				casa.setBounds(j*50+50, i*50+50, 50, 50);
				casas_vermelhas[i][j]=casa;
				casas_vermelhas[i][j].setVisible(false);
				panel.add(casas_vermelhas[i][j]);
			}
		}
		
		//casas iniciais
		JLabel casas_iniciais[][] = new JLabel[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				JLabel casa = new JLabel();
				casa.setIcon(new ImageIcon(Janela.class.getResource("/Imagens/inicial.png")));
				casa.setBounds(j*50+50, i*50+50, 50, 50);
				casas_iniciais[i][j]=casa;
				casas_iniciais[i][j].setVisible(true);
				panel.add(casas_iniciais[i][j]);
			}
		}

		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				int x=e.getX()/50;
				int y=e.getY()/50;
				
				//pintar linha de amarelo
				if(x==0 && y>0 && y<5) {
					for(int i=0;i<4;i++) {				
						casas_amarelas[y-1][i].setVisible(true);
						casas_verdes[y-1][i].setVisible(false);
						casas_vermelhas[y-1][i].setVisible(false);
						casas_azuis[y-1][i].setVisible(false);
						casas_iniciais[y-1][i].setVisible(false);					
					}
					jogadas++;
					mensagem_jogadas.setText("Jogadas:"+jogadas);
				}
				
				//pintar linha de azul
				if(y==5 && x>0 && x<5) {
					for(int i=0;i<4;i++) {
						casas_azuis[i][x-1].setVisible(true);
						casas_amarelas[i][x-1].setVisible(false);
						casas_verdes[i][x-1].setVisible(false);
						casas_vermelhas[i][x-1].setVisible(false);						
						casas_iniciais[i][x-1].setVisible(false);
					}
					jogadas++;
					mensagem_jogadas.setText("Jogadas:"+jogadas);
				}
				
				//pintar linha de verde
				if(x==5 && y>0 && y<5) {
					for(int i=0;i<4;i++) {		
						casas_verdes[y-1][i].setVisible(true);
						casas_amarelas[y-1][i].setVisible(false);						
						casas_vermelhas[y-1][i].setVisible(false);
						casas_azuis[y-1][i].setVisible(false);
						casas_iniciais[y-1][i].setVisible(false);
					}
					jogadas++;
					mensagem_jogadas.setText("Jogadas:"+jogadas);
				}
				
				//pintar linha de vermelho
				if(y==0 && x>0 && x<5) {
					for(int i=0;i<4;i++) {
						casas_vermelhas[i][x-1].setVisible(true);
						casas_azuis[i][x-1].setVisible(false);
						casas_amarelas[i][x-1].setVisible(false);
						casas_verdes[i][x-1].setVisible(false);												
						casas_iniciais[i][x-1].setVisible(false);
					}
					jogadas++;
					mensagem_jogadas.setText("Jogadas:"+jogadas);
				}
			}
			
		});
		
		
	}
}
