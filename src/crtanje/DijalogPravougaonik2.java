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

public class DijalogPravougaonik2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtX;
	protected JTextField txtY;
	protected JTextField txtDuzinaStr;
	protected JTextField txtSirinaStr;
	public String x;
	protected String y;
	protected String duzina;
	protected String visina;
	private Color bojaIv = Color.BLACK;
	private Color bojaUn = Color.WHITE;
	private JButton btnBojeUn;
	private JButton btnBojaIv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogPravougaonik2 dialog = new DijalogPravougaonik2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogPravougaonik2() {
		setTitle("Pravougaonik");
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblX = new JLabel("X koordinata ta\u010Dke gore levo:");
		lblX.setBounds(46, 25, 150, 14);
		contentPanel.add(lblX);
		
		txtX = new JTextField();
		txtX.setBounds(196, 22, 100, 20);
		contentPanel.add(txtX);
		txtX.setColumns(10);
		
		JLabel lblY = new JLabel("Y koordinata ta\u010Dke gore levo:");
		lblY.setBounds(46, 50, 150, 14);
		contentPanel.add(lblY);
		
		txtY = new JTextField();
		txtY.setBounds(196, 47, 100, 20);
		contentPanel.add(txtY);
		txtY.setColumns(10);
		
		JLabel lblDuzinaStr = new JLabel("Du\u017Eina stranice:");
		lblDuzinaStr.setBounds(46, 75, 140, 14);
		contentPanel.add(lblDuzinaStr);
		
		txtDuzinaStr = new JTextField();
		txtDuzinaStr.setBounds(196, 72, 100, 20);
		contentPanel.add(txtDuzinaStr);
		txtDuzinaStr.setColumns(10);
		
		JLabel lblSirina = new JLabel("\u0160irina stranice:");
		lblSirina.setBounds(46, 101, 140, 14);
		contentPanel.add(lblSirina);
		
		txtSirinaStr = new JTextField();
		txtSirinaStr.setBounds(196, 98, 100, 20);
		contentPanel.add(txtSirinaStr);
		txtSirinaStr.setColumns(10);
		
		JLabel lblBojaIv = new JLabel("Boja ivice:");
		lblBojaIv.setBounds(46, 140, 140, 14);
		contentPanel.add(lblBojaIv);
		
		btnBojaIv = new JButton("Prika\u017Ei boje");
		btnBojaIv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaIv = JColorChooser.showDialog(null, "Boja ivice", getBackground());
			}
		});
		btnBojaIv.setBounds(196, 136, 100, 23);
		contentPanel.add(btnBojaIv);
		
		JLabel lblBojaUn = new JLabel("Boja unutra\u0161njosti:");
		lblBojaUn.setBounds(46, 170, 140, 14);
		contentPanel.add(lblBojaUn);
		
		btnBojeUn = new JButton("Prika\u017Ei boje");
		btnBojeUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaUn = JColorChooser.showDialog(null, "Boja unutrašnjosti", getBackground());
			}
		});
		btnBojeUn.setBounds(196, 166, 100, 23);
		contentPanel.add(btnBojeUn);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						x = txtX.getText();
						y = txtY.getText();
						duzina = txtDuzinaStr.getText();
						visina = txtSirinaStr.getText();
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
		btnBojaIv.setBackground(bojaIv);
		this.bojaIv = bojaIv;
	}
	public Color getBojaUn(){
		return bojaUn;
	}
	public void setBojaUn(Color bojaUn){
		btnBojeUn.setBackground(bojaUn);
		this.bojaUn = bojaUn;
	}
}
