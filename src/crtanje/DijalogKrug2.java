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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogKrug2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtPoluprecnik;
	public String x;
	public String y;
	public String r;
	private Color bojaIv = Color.BLACK;
	private Color bojaUn = Color.WHITE;
	private JButton btnIzaberiBojuIv;
	private JButton btnIzaberiBojuUn;
	private JButton btnPotvrdi;
	private JButton btnPoništi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKrug2 dialog = new DijalogKrug2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogKrug2() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setTitle("Krug");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblX = new JLabel("X koordinata:");
			lblX.setBounds(40, 30, 120, 14);
			contentPanel.add(lblX);
		}
		{
			JLabel lblY = new JLabel("Y koordinata:");
			lblY.setBounds(40, 60, 120, 14);
			contentPanel.add(lblY);
		}
		{
			JLabel lblPoluprecnik = new JLabel("Polupre\u010Dnik:");
			lblPoluprecnik.setBounds(40, 90, 120, 14);
			contentPanel.add(lblPoluprecnik);
		}
		{
			txtX = new JTextField();
			txtX.setBounds(160, 26, 100, 20);
			contentPanel.add(txtX);
			txtX.setColumns(10);
		}
		{
			txtY = new JTextField();
			txtY.setText("");
			txtY.setBounds(160, 56, 100, 20);
			contentPanel.add(txtY);
			txtY.setColumns(10);
		}
		{
			txtPoluprecnik = new JTextField();
			txtPoluprecnik.setText("");
			txtPoluprecnik.setBounds(160, 87, 100, 20);
			contentPanel.add(txtPoluprecnik);
			txtPoluprecnik.setColumns(10);
		}
		{
			JLabel lblBojaIv = new JLabel("Boja ivice:");
			lblBojaIv.setBounds(40, 136, 120, 14);
			contentPanel.add(lblBojaIv);
		}
		{
			btnIzaberiBojuIv = new JButton("Prika\u017Ei boje");
			btnIzaberiBojuIv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bojaIv = JColorChooser.showDialog(null, "Boja ivice", getBackground());
				}
			});
			btnIzaberiBojuIv.setBounds(160, 132, 100, 23);
			contentPanel.add(btnIzaberiBojuIv);
		}
		{
			JLabel lblBojaUn = new JLabel("Boja unutra\u0161njosti:");
			lblBojaUn.setBounds(40, 170, 120, 14);
			contentPanel.add(lblBojaUn);
		}
		{
			btnIzaberiBojuUn = new JButton("Prika\u017Ei boje");
			btnIzaberiBojuUn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bojaUn = JColorChooser.showDialog(null, "Boja unutrašnjosti", getBackground());
				}
			});
			btnIzaberiBojuUn.setBounds(160, 166, 100, 23);
			contentPanel.add(btnIzaberiBojuUn);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						x = txtX.getText();
						y = txtY.getText();
						r = txtPoluprecnik.getText();
						setVisible(false);
					}
				});
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				btnPoništi = new JButton("Poni\u0161ti");
				btnPoništi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnPoništi.setActionCommand("Cancel");
				buttonPane.add(btnPoništi);
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
