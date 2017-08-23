package crtanje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogKvadrat1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzinaStranice;
	private Kvadrat kvadrat;
	private Color bojaIvice = Color.BLACK;
	private Color bojaUnutra = Color.WHITE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKvadrat1 dialog = new DijalogKvadrat1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogKvadrat1() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Kvadrat");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDuzinaStranice = new JLabel("Unesite du\u017Einu stranice:");
		lblDuzinaStranice.setBounds(30, 25, 150, 20);
		contentPanel.add(lblDuzinaStranice);
		
		txtDuzinaStranice = new JTextField();
		txtDuzinaStranice.setBounds(210, 25, 100, 20);
		contentPanel.add(txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);
		
		JLabel lblBojaIvice = new JLabel("Izaberite boju ivice:");
		lblBojaIvice.setBounds(30, 70, 130, 25);
		contentPanel.add(lblBojaIvice);
		
		JButton btnPrikaziBojuIvice = new JButton("Prika\u017Ei boje");
		btnPrikaziBojuIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaIvice = JColorChooser.showDialog(null, "Izaberite boju ivice", getBackground());
			}
		});
		btnPrikaziBojuIvice.setForeground(Color.WHITE);
		btnPrikaziBojuIvice.setBackground(Color.DARK_GRAY);
		btnPrikaziBojuIvice.setBounds(210, 71, 100, 23);
		contentPanel.add(btnPrikaziBojuIvice);
		
		JLabel lblIzaberiBojuUnutra = new JLabel("Izaberite boju unutra\u0161njosti:");
		lblIzaberiBojuUnutra.setBounds(30, 110, 160, 25);
		contentPanel.add(lblIzaberiBojuUnutra);
		
		JButton btnPrikaziBojeUnutra = new JButton("Prika\u017Ei boje");
		btnPrikaziBojeUnutra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaUnutra = JColorChooser.showDialog(null, "Izaberite boju unutrašnjosti", getBackground());
			}
		});
		btnPrikaziBojeUnutra.setBackground(Color.DARK_GRAY);
		btnPrikaziBojeUnutra.setForeground(Color.WHITE);
		btnPrikaziBojeUnutra.setBounds(210, 111, 100, 23);
		contentPanel.add(btnPrikaziBojeUnutra);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
						kvadrat = new Kvadrat();
						kvadrat.setDuzinaStranice(Integer.parseInt(txtDuzinaStranice.getText()));
						kvadrat.setBojaIv(bojaIvice);
						kvadrat.setBojaUn(bojaUnutra);
						setVisible(false);
						}catch (NumberFormatException ex) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi");
							txtDuzinaStranice.requestFocus();
							txtDuzinaStranice.setText("");
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
	public Kvadrat getKvadrat(){
		return kvadrat;
	}
}
