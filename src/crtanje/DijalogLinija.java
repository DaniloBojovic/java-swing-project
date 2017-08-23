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

public class DijalogLinija extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtPocX;
	public JTextField txtPocY;
	public JTextField txtKrajX;
	public JTextField txtKrajY;
	public String xPoc;
	public String yPoc;
	public String xKraj;
	public String yKraj;
	private Color bojaIv;
	private JButton btnPrikaziBoje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogLinija dialog = new DijalogLinija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogLinija() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPocX = new JLabel("X koordinata po\u010Detne ta\u010Dke:");
			lblPocX.setBounds(40, 30, 140, 14);
			contentPanel.add(lblPocX);
		}
		{
			JLabel lblPocY = new JLabel("Y koordinata po\u010Detne ta\u010Dke:");
			lblPocY.setBounds(40, 60, 140, 14);
			contentPanel.add(lblPocY);
		}
		{
			JLabel lblKrajX = new JLabel("X koordinata krajnje ta\u010Dke:");
			lblKrajX.setBounds(40, 90, 140, 14);
			contentPanel.add(lblKrajX);
		}
		{
			JLabel lblKrajY = new JLabel("Y koordinata krajnje ta\u010Dke:");
			lblKrajY.setBounds(40, 120, 140, 14);
			contentPanel.add(lblKrajY);
		}
		{
			txtPocX = new JTextField();
			txtPocX.setBounds(190, 25, 100, 20);
			contentPanel.add(txtPocX);
			txtPocX.setColumns(10);
		}
		{
			txtPocY = new JTextField();
			txtPocY.setBounds(190, 55, 100, 20);
			contentPanel.add(txtPocY);
			txtPocY.setColumns(10);
		}
		{
			txtKrajX = new JTextField();
			txtKrajX.setBounds(190, 85, 100, 20);
			contentPanel.add(txtKrajX);
			txtKrajX.setColumns(10);
		}
		{
			txtKrajY = new JTextField();
			txtKrajY.setBounds(190, 115, 100, 20);
			contentPanel.add(txtKrajY);
			txtKrajY.setColumns(10);
		}
		
		JLabel lblBojaIv = new JLabel("Boja linije:");
		lblBojaIv.setBounds(40, 162, 100, 14);
		contentPanel.add(lblBojaIv);
		
		btnPrikaziBoje = new JButton("Prika\u017Ei boje");
		btnPrikaziBoje.setForeground(Color.WHITE);
		btnPrikaziBoje.setBackground(Color.DARK_GRAY);
		btnPrikaziBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaIv = JColorChooser.showDialog(null, "Izaberi boju", getBackground());
			}
		});
		btnPrikaziBoje.setBounds(190, 158, 100, 23);
		contentPanel.add(btnPrikaziBoje);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						xPoc = txtPocX.getText();
						yPoc = txtPocY.getText();
						xKraj = txtPocX.getText();
						yKraj = txtKrajY.getText();
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnPonisti.setActionCommand("Cancel");
				buttonPane.add(btnPonisti);
			}
		}
	}
	public void setBojaLinije(Color bojaIv){
		btnPrikaziBoje.setBackground(bojaIv);
		this.bojaIv = bojaIv;
	}
	public Color getBojaIv(){
		return bojaIv;
	}
}
