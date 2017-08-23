package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Krug;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtPoluprecnik;
	private Krug krug;
	private Color bojaIvice = Color.BLACK;
	private Color bojaUnutra = Color.WHITE;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKrug dialog = new DijalogKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogKrug() {
		setModal(true);
		setTitle("Krug");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPoluprecnik = new JLabel("Unesite polupre\u010Dnik kruga:");
			lblPoluprecnik.setBounds(30, 25, 160, 20);
			contentPanel.add(lblPoluprecnik);
		}
		
		txtPoluprecnik = new JTextField();
		txtPoluprecnik.setBounds(210, 25, 100, 20);
		contentPanel.add(txtPoluprecnik);
		txtPoluprecnik.setColumns(10);
		
		JLabel lblBojaIvice = new JLabel("Izaberite boju ivice:");
		lblBojaIvice.setBounds(30, 70, 130, 25);
		contentPanel.add(lblBojaIvice);
		
		JButton btnBojaIvice = new JButton("Prika\u017Ei boje");
		btnBojaIvice.setForeground(Color.WHITE);
		btnBojaIvice.setBackground(Color.DARK_GRAY);		
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser izaberiBoje = new JColorChooser();
				bojaIvice = JColorChooser.showDialog(null, "Izaberite boju ivice", getBackground());
			}
		});
		btnBojaIvice.setBounds(210, 71, 100, 23);
		contentPanel.add(btnBojaIvice);
		
		JLabel lblBojaUn = new JLabel("Izaberite boju unutra\u0161njosti:");
		lblBojaUn.setBounds(30, 110, 160, 14);
		contentPanel.add(lblBojaUn);
		
		JButton btnBojaUnutra = new JButton("Prika\u017Ei boje");
		btnBojaUnutra.setBackground(Color.DARK_GRAY);
		btnBojaUnutra.setForeground(Color.WHITE);
		btnBojaUnutra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnBojaUnutra.setBackground(JColorChooser.showDialog(null, 
					//	"Izaberite boju unutrasnjosti", btnBojaUnutra.getBackground()));
				bojaUnutra = JColorChooser.showDialog(null,"Izaberite boju unutrasnjosti", getBackground());
			}
		});
		btnBojaUnutra.setBounds(210, 106, 100, 23);
		contentPanel.add(btnBojaUnutra);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
						krug = new Krug();
						krug.setR(Integer.parseInt(txtPoluprecnik.getText()));
						//krug.crtajSe(g);
						krug.setBojaIv(bojaIvice);
						krug.setBojaUn(bojaUnutra);
						//dispose();
						setVisible(false);
						}catch (NumberFormatException ex) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi");
							txtPoluprecnik.setText("");
							txtPoluprecnik.requestFocus();
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
	public Krug getKrug(){
		return krug;
	}
}
