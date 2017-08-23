package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogKvadrat2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtDuzinaStr;
	public String x;
	public String y;
	public String duzina;
	private Color bojaIv = Color.BLACK;
	private Color bojaUn = Color.WHITE;
	private JButton btnIzaberiBojuIv;
	private JButton btnIzaberiBojuUn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKvadrat2 dialog = new DijalogKvadrat2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogKvadrat2() {
		setModal(true);
		setTitle("Kvadrat");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblX = new JLabel("X koordinata ta\u010Dke gore levo:");
			lblX.setBounds(44, 25, 150, 14);
			contentPanel.add(lblX);
		}
		{
			txtX = new JTextField();
			txtX.setBounds(200, 22, 100, 20);
			contentPanel.add(txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblX = new JLabel("Y koordinata ta\u010Dke gore levo:");
			lblX.setBounds(44, 50, 150, 14);
			contentPanel.add(lblX);
		}
		{
			txtY = new JTextField();
			txtY.setBounds(200, 47, 100, 20);
			contentPanel.add(txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblDuzinaStr = new JLabel("Du\u017Eina stranice:");
			lblDuzinaStr.setBounds(44, 75, 150, 14);
			contentPanel.add(lblDuzinaStr);
		}
		{
			txtDuzinaStr = new JTextField();
			txtDuzinaStr.setBounds(200, 72, 100, 20);
			contentPanel.add(txtDuzinaStr);
			txtDuzinaStr.setColumns(10);
		}
		{
			JLabel lblBojaIv = new JLabel("Boja ivice:");
			lblBojaIv.setBounds(44, 110, 150, 14);
			contentPanel.add(lblBojaIv);
		}
		{
			btnIzaberiBojuIv = new JButton("Prika\u017Ei boje");
			btnIzaberiBojuIv.setForeground(Color.WHITE);
			btnIzaberiBojuIv.setBackground(Color.DARK_GRAY);
			btnIzaberiBojuIv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bojaIv = JColorChooser.showDialog(null, "Boja ivice", getBackground());
				}
			});
			btnIzaberiBojuIv.setBounds(200, 106, 100, 23);
			contentPanel.add(btnIzaberiBojuIv);
		}
		{
			JLabel lblBojaUn = new JLabel("Boja unutra\u0161njosti:");
			lblBojaUn.setBounds(44, 140, 150, 14);
			contentPanel.add(lblBojaUn);
		}
		{
			btnIzaberiBojuUn = new JButton("Prika\u017Ei boje");
			btnIzaberiBojuUn.setBackground(Color.DARK_GRAY);
			btnIzaberiBojuUn.setForeground(Color.WHITE);
			btnIzaberiBojuUn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bojaUn = JColorChooser.showDialog(null, "Boja unutrašnjosti", getBackground());
				}
			});
			btnIzaberiBojuUn.setBounds(200, 136, 100, 23);
			contentPanel.add(btnIzaberiBojuUn);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						x = txtX.getText();
						y = txtY.getText();
						duzina = txtDuzinaStr.getText();
						setVisible(false);
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
	public Color getBojaIv(){
		return bojaIv;
	}
	public void setBojaIv(Color bojaIv){
		btnIzaberiBojuIv.setBackground(bojaIv);
		this.bojaIv = bojaIv;
	}
	public Color getBojaUn(){
		return bojaUn;
	}
	public void setBojaUn(Color bojaUn){
		btnIzaberiBojuUn.setBackground(bojaUn);
		this.bojaUn = bojaUn;
	}
}
