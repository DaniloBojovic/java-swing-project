package crtanje;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.ValueOutputStream;

import geometrija.Crtez;
import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Oblik;
import geometrija.Pravougaonik;
import geometrija.Tacka;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;

public class Glavni extends JFrame {

	private JPanel contentPane;
	public Crtez pnlCrtez;
	public JRadioButton rbtnTacka;
	public JRadioButton rbtnLinija;
	private JPanel panel;
	public JRadioButton rbtnKrug;
	public JRadioButton rbtnKvadrat;
	public JRadioButton rbtnPravougaonik;
	private ButtonGroup btnGrupa;
	public JRadioButton rbtnSelektuj;
	public JButton btnObrisi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Glavni frame = new Glavni();
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
	public Glavni() {
		setTitle("I7 33-2016 Bojovi\u0107 Danilo                                                            Crtanje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setResizable(false);
		setBounds(100,100,800,500);
		//setBounds(100, 100, 550, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		MLzaCrtez ml = new MLzaCrtez(this);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(263, 34, 455, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		pnlCrtez = new Crtez();
		pnlCrtez.setBounds(0, 0, 455, 360);
		panel.add(pnlCrtez);
		pnlCrtez.setForeground(Color.BLACK);
		pnlCrtez.setBackground(Color.WHITE); 
		pnlCrtez.addMouseListener(ml);
		pnlCrtez.setBackground(Color.WHITE);
		pnlCrtez.setLayout(null);
		
		btnGrupa = new ButtonGroup();
		
		rbtnTacka = new JRadioButton("Tacka");
		rbtnTacka.setFont(new Font("Verdana", Font.PLAIN, 11));
		rbtnTacka.setBounds(20, 270, 109, 23);
		contentPane.add(rbtnTacka);
		btnGrupa.add(rbtnTacka);
		
		rbtnLinija = new JRadioButton("Linija");
		rbtnLinija.setFont(new Font("Verdana", Font.PLAIN, 11));
		rbtnLinija.setBounds(20, 290, 109, 23);
		contentPane.add(rbtnLinija);
		btnGrupa.add(rbtnLinija);
		
		rbtnKrug = new JRadioButton("Krug");
		rbtnKrug.setFont(new Font("Verdana", Font.PLAIN, 11));
		rbtnKrug.setBounds(20, 310, 109, 23);
		contentPane.add(rbtnKrug);
		btnGrupa.add(rbtnKrug);
		
		rbtnKvadrat = new JRadioButton("Kvadrat");
		rbtnKvadrat.setFont(new Font("Verdana", Font.PLAIN, 11));
		rbtnKvadrat.setBounds(20, 330, 109, 23);
		contentPane.add(rbtnKvadrat);
		btnGrupa.add(rbtnKvadrat);
		
		rbtnPravougaonik = new JRadioButton("Pravougaonik");
		rbtnPravougaonik.setFont(new Font("Verdana", Font.PLAIN, 11));
		rbtnPravougaonik.setBounds(20, 350, 109, 23);
		contentPane.add(rbtnPravougaonik);
		btnGrupa.add(rbtnPravougaonik);
		
		JLabel lblOdaberiObl = new JLabel("Crtanje oblika:");
		lblOdaberiObl.setFont(new Font("Verdana", Font.BOLD, 11));
		lblOdaberiObl.setBounds(20, 240, 100, 20);
		contentPane.add(lblOdaberiObl);
		
		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				int y;
				int x2;
				int y2;
				int x3;
				Color jedan;
				Color boja1;
				Color boja2;
				int r;
				Oblik o = pnlCrtez.getSelektovaniOblik(); //o.isSelektovan()==true 
				if(o != null && o.isSelektovan()){
					if(o instanceof Tacka){
						x = ((Tacka) o).getX();
						y = ((Tacka) o).getY();
						DijalogTacka dt = new DijalogTacka();
						dt.setTitle("Tacka");
						dt.txtX.setText(String.valueOf(x));
						dt.txtY.setText(String.valueOf(y));
						dt.setVisible(true);
						try{
							((Tacka) o).setX(Integer.parseInt(dt.txtX.getText()));
							((Tacka) o).setY(Integer.parseInt(dt.txtY.getText()));
							pnlCrtez.repaint();
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi");
						}
						
					} //TACKA
					if(o instanceof Linija){
						x = ((Linija) o).gettPocetna().getX();
						y = ((Linija) o).gettPocetna().getY();
						x2 = ((Linija) o).gettKrajnja().getX();
						y2 = ((Linija) o).gettKrajnja().getY();
						boja1 = o.getBojaIv();
						DijalogLinija dl = new DijalogLinija();
						dl.setTitle("Linija");
						dl.txtPocX.setText(String.valueOf(x));
						dl.txtPocY.setText(String.valueOf(y));
						dl.txtKrajX.setText(String.valueOf(x2));
						dl.txtKrajY.setText(String.valueOf(y2));
						dl.setBojaLinije(boja1);
						dl.setVisible(true);
						try{
							((Linija) o).gettPocetna().setX(Integer.parseInt(dl.txtPocX.getText()));
							((Linija) o).gettPocetna().setY(Integer.parseInt(dl.txtPocY.getText()));
							((Linija) o).gettKrajnja().setX(Integer.parseInt(dl.txtKrajX.getText()));
							((Linija) o).gettKrajnja().setY(Integer.parseInt(dl.txtKrajY.getText()));
							o.setBojaIv(dl.getBojaIv());
							pnlCrtez.repaint();
						}catch (NumberFormatException ex) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi");
						}
					}
					if(o instanceof Krug){
						x = ((Krug) o).getCentar().getX();
						y = ((Krug) o).getCentar().getY();
						r = ((Krug) o).getR();
						boja1 = o.getBojaIv();
						boja2 = ((Krug) o).getBojaUn();
						//boja2 = o.getBojaUn();
						DijalogKrug2 dkr = new DijalogKrug2();
						dkr.setTitle("Krug");
						dkr.txtX.setText(String.valueOf(x));
						dkr.txtY.setText(String.valueOf(y));
						dkr.txtPoluprecnik.setText(String.valueOf(r));
						dkr.setBojaIv(boja1);
						dkr.setBojaUn(boja2);
						dkr.setVisible(true);
						try{
							((Krug) o).getCentar().setX(Integer.parseInt(dkr.txtX.getText()));
							((Krug) o).getCentar().setY(Integer.parseInt(dkr.txtY.getText()));
							((Krug) o).setR(Integer.parseInt(dkr.txtPoluprecnik.getText()));
							o.setBojaIv(dkr.getBojaIv());
							((Krug) o).setBojaUn(dkr.getBojaUn());
							//o.setBojaUn(dkr.bojaUn);
							pnlCrtez.repaint();
						}catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi", "Greska", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					if(o instanceof Pravougaonik){
						x = ((Pravougaonik) o).getGoreLevo().getX();
						y = ((Pravougaonik) o).getGoreLevo().getY();
						x2 = ((Pravougaonik) o).getDuzinaStranice();
						x3 = ((Pravougaonik) o).getVisina();
						boja1 = o.getBojaIv();
						boja2 = ((Pravougaonik) o).getBojaUn();
						DijalogPravougaonik2 dp = new DijalogPravougaonik2();
						dp.setTitle("Pravougaonik");
						dp.txtX.setText(String.valueOf(x));
						dp.txtY.setText(String.valueOf(y));
						dp.txtDuzinaStr.setText(String.valueOf(x2));
						dp.txtSirinaStr.setText(String.valueOf(x3));
						dp.setBojaIv(boja1);
						dp.setBojaUn(boja2);
						dp.setVisible(true);
						try {
							((Pravougaonik) o).getGoreLevo().setX(Integer.parseInt(dp.txtX.getText()));
							((Pravougaonik) o).getGoreLevo().setY(Integer.parseInt(dp.txtY.getText()));
							((Pravougaonik) o).setDuzinaStranice(Integer.parseInt(dp.txtDuzinaStr.getText()));
							((Pravougaonik) o).setVisina(Integer.parseInt(dp.txtSirinaStr.getText()));
							o.setBojaIv(dp.getBojaIv());
							((Pravougaonik) o).setBojaUn(dp.getBojaUn());
							pnlCrtez.repaint();
						} catch (Exception ex) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi");
						}
					}
					if((o instanceof Kvadrat) && !(o instanceof Pravougaonik)){
						x = ((Kvadrat) o).getGoreLevo().getX();
						y = ((Kvadrat) o).getGoreLevo().getY();
						x2 = ((Kvadrat) o).getDuzinaStranice();
						boja1 = o.getBojaIv();
						boja2 = ((Kvadrat) o).getBojaUn();
						//boja2 = o.getBojaUn();
						DijalogKvadrat2 dkv = new DijalogKvadrat2();
						dkv.setTitle("Kvadrat");
						dkv.txtX.setText(String.valueOf(x));
						dkv.txtY.setText(String.valueOf(y));
						dkv.txtDuzinaStr.setText(String.valueOf(x2));
						dkv.setBojaIv(boja1);
						dkv.setBojaUn(boja2);
						dkv.setVisible(true);
						try{
							((Kvadrat) o).getGoreLevo().setX(Integer.parseInt(dkv.txtX.getText()));
							((Kvadrat) o).getGoreLevo().setY(Integer.parseInt(dkv.txtY.getText()));
							((Kvadrat) o).setDuzinaStranice(Integer.parseInt(dkv.txtDuzinaStr.getText()));
							o.setBojaIv(dkv.getBojaIv());
							((Kvadrat) o).setBojaUn(dkv.getBojaUn());
							//o.setBojaUn(dkv.bojaUn);
							pnlCrtez.repaint();
						}catch (NumberFormatException ex) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi");
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "Nije selektovan nijedan oblik za modifikaciju","Info poruka", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnModifikuj.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifikuj.setBounds(20, 40, 160, 40);
		contentPane.add(btnModifikuj);
		
		btnObrisi = new JButton("Obri\u0161i");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(pnlCrtez.getSelektovaniOblik() != null){
				Oblik o = pnlCrtez.getSelektovaniOblik();
				if(o != null && o.isSelektovan()){
					int odgovor = JOptionPane.YES_NO_OPTION;
					String[] opcije = new String[2];
					opcije[0] = "Da";
					opcije[1] = "Ne";
					odgovor = JOptionPane.showOptionDialog(getContentPane(),"Da li ste sigurni da želite da obrišete?","Potvrda", 0,
							JOptionPane.INFORMATION_MESSAGE,null,opcije,null);
					if(odgovor == 0){
					pnlCrtez.obrisiOblik(pnlCrtez.getSelektovaniOblik());
					}
				}
				else{
					JOptionPane.showMessageDialog(getParent(), "Nije selektovan nijedan oblik za brisanje", "Info poruka", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnObrisi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnObrisi.setBounds(20, 100, 160, 40);
		contentPane.add(btnObrisi);
		
		rbtnSelektuj = new JRadioButton("Selektuj ");
		rbtnSelektuj.setFont(new Font("Verdana", Font.PLAIN, 11));
		rbtnSelektuj.setBounds(19, 200, 109, 23);
		contentPane.add(rbtnSelektuj);
		btnGrupa.add(rbtnSelektuj);
		
		JLabel lblSelektovanje = new JLabel("Selektovanje oblika:");
		lblSelektovanje.setFont(new Font("Verdana", Font.BOLD, 11));
		lblSelektovanje.setBounds(18, 170, 140, 20);
		contentPane.add(lblSelektovanje);
	}
}
