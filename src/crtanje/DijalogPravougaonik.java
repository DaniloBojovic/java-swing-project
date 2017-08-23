package crtanje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Pravougaonik;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogPravougaonik extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSirinaStranice;
	private JTextField txtDuzinaStranice;
	private Pravougaonik pravougaonik;
	private Color bojaIvice = Color.BLACK;
	private Color bojaUnutra = Color.WHITE;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogPravougaonik dialog = new DijalogPravougaonik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogPravougaonik() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Pravougaonik");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSirina = new JLabel("Unesite \u0161irinu stranice:");
			lblSirina.setBounds(30, 25, 150, 20);
			contentPanel.add(lblSirina);
		}
		{
			JLabel lblVisina = new JLabel("Unesite du\u017Einu stranice:");
			lblVisina.setBounds(30, 55, 150, 20);
			contentPanel.add(lblVisina);
		}
		{
			txtSirinaStranice = new JTextField();
			txtSirinaStranice.setBounds(210, 25, 100, 20);
			contentPanel.add(txtSirinaStranice);
			txtSirinaStranice.setColumns(10);
		}
		{
			txtDuzinaStranice = new JTextField();
			txtDuzinaStranice.setBounds(210, 56, 100, 20);
			contentPanel.add(txtDuzinaStranice);
			txtDuzinaStranice.setColumns(10);
		}
		{
			JLabel lblBojaIvice = new JLabel("Izaberite boju ivice:");
			lblBojaIvice.setBounds(30, 90, 130, 25);
			contentPanel.add(lblBojaIvice);
		}
		{
			JButton btnPrikaziBojuIv = new JButton("Prika\u017Ei boje");
			btnPrikaziBojuIv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bojaIvice = JColorChooser.showDialog(null, "Izaberite boju ivice", getBackground());
				}
			});
			btnPrikaziBojuIv.setForeground(Color.WHITE);
			btnPrikaziBojuIv.setBackground(Color.DARK_GRAY);
			btnPrikaziBojuIv.setBounds(210, 91, 100, 23);
			contentPanel.add(btnPrikaziBojuIv);
		}
		{
			JLabel lblPrikaziBojuUn = new JLabel("Izaberite boju unutra\u0161njosti:");
			lblPrikaziBojuUn.setBounds(30, 130, 160, 25);
			contentPanel.add(lblPrikaziBojuUn);
		}
		{
			JButton btnPrikaziBojeU = new JButton("Prika\u017Ei boje");
			btnPrikaziBojeU.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bojaUnutra = JColorChooser.showDialog(null, "Izaberite boju unutrašnjosti", bojaUnutra);
				}
			});
			btnPrikaziBojeU.setForeground(Color.WHITE);
			btnPrikaziBojeU.setBackground(Color.DARK_GRAY);
			btnPrikaziBojeU.setBounds(210, 131, 100, 23);
			contentPanel.add(btnPrikaziBojeU);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
						pravougaonik = new Pravougaonik();
						pravougaonik.setDuzinaStranice(Integer.parseInt(txtDuzinaStranice.getText()));
						pravougaonik.setVisina(Integer.parseInt(txtSirinaStranice.getText()));
						pravougaonik.setBojaIv(bojaIvice);
						pravougaonik.setBojaUn(bojaUnutra);
						setVisible(false);
						}catch (NumberFormatException ex) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi");
							txtSirinaStranice.requestFocus();
							txtDuzinaStranice.setText("");
							txtSirinaStranice.setText("");
						}
					}
				});
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnPonisti = new JButton("Poni\u0161ti");
				btnPonisti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnPonisti.setActionCommand("Cancel");
				buttonPane.add(btnPonisti);
			}
		}
	}
	public Pravougaonik getPravougaonik(){
		return pravougaonik;
	}
}
