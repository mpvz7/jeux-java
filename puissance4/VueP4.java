import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueP4 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField chJaune;
	private JTextField chRouge;
	private JTextField chNul;
	private JPanel pPionsEtGrille;
	private PionP4[] tabPionP4;
	private CaseP4[][] tabGrilleP4;
	
	public VueP4(){
		this.chJaune = new JTextField("0");
		this.chRouge = new JTextField("0");
		this.chNul = new JTextField("0");
		
		this.setLayout(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setLayout(new GridLayout(1,2));
		
		JPanel score = new JPanel();
		score.setLayout(new GridLayout(3,2));
		score.add(new JLabel("parties jaunes"));
		this.chJaune.setEnabled(false);
		score.add(this.chJaune);
		score.add(new JLabel("parties rouge"));
		this.chRouge.setEnabled(false);
		score.add(this.chRouge);
		score.add(new JLabel("parties vides"));
		this.chNul.setEnabled(false);
		score.add(this.chNul);	
		
		nord.add(score);
		
		JButton rejouer = new JButton("Rejouer");
		nord.add(rejouer);
		
		this.add(nord, BorderLayout.NORTH);
		
		this.pPionsEtGrille = new JPanel();
		this.pPionsEtGrille.setLayout(new GridLayout(7,7));
		
		this.tabPionP4 = new PionP4[7];
		for(int i=0; i< this.tabPionP4.length; i++) {
			this.tabPionP4[i] = new PionP4(i);
			this.tabPionP4[i].setIcon(new ImageIcon("./src/images/pionRouge.jpg"));
			this.pPionsEtGrille.add(this.tabPionP4[i]);
		}
		
		this.tabGrilleP4 = new CaseP4[6][7];
		
		for(int i=0; i<this.tabGrilleP4.length; i++) {
			for(int j=0; j<this.tabGrilleP4[i].length; j++) {
				this.tabGrilleP4[i][j]=new CaseP4(i,j);
				this.tabGrilleP4[i][j].setIcon(new ImageIcon("./src/images/caseVide.jpg"));
				this.pPionsEtGrille.add(this.tabGrilleP4[i][j]);
			}
		}
		this.add(this.pPionsEtGrille, BorderLayout.CENTER);
	}
	
	public void incrementerJaune() {
		int score = Integer.parseInt(this.chJaune.getText());
		score++;
		this.chJaune.setText(Integer.toString(score));
	}
	
	public void incrementerRouge() {
		int score = Integer.parseInt(this.chRouge.getText());
		score++;
		this.chRouge.setText(Integer.toString(score));
	}
	
	public void incrementerVide() {
		int score = Integer.parseInt(this.chNul.getText());
		score++;
		this.chNul.setText(Integer.toString(score));
	}
	
	public void setCouleurPion(CouleurP4 c) {
		for(int i = 0; i<this.tabPionP4.length; i++) {
			if( c == CouleurP4.JAUNE) {
				this.tabPionP4[i].setIcon(new ImageIcon("./src/images/pionJaune.jpg"));
			}else if (c == CouleurP4.ROUGE) {
				this.tabPionP4[i].setIcon(new ImageIcon("./src/images/pionRouge.jpg"));
			}else {
				this.tabPionP4[i].setIcon(new ImageIcon("./src/images/pionVide.jpg"));
			}
		}
	}
	
	public void setImageCase(CouleurP4 c, int i, int j) {
		if( c == CouleurP4.JAUNE) {
			this.tabGrilleP4[i][j].setIcon(new ImageIcon("./src/images/caseJaune.jpg"));
		}else if (c == CouleurP4.ROUGE) {
			this.tabGrilleP4[i][j].setIcon(new ImageIcon("./src/images/caseRouge.jpg"));
		}else {
			this.tabGrilleP4[i][j].setIcon(new ImageIcon("./src/images/caseVide.jpg"));
		}
	}
	
	public int getColonneJouer(JButton b) {
		int colonne = 0;
		for(int i=0; i<this.tabPionP4.length; i++)
			if(b == this.tabPionP4[i])
				colonne = i;
		return colonne;
	}
}
