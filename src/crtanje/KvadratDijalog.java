package crtanje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KvadratDijalog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtDuzinaStranice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KvadratDijalog dialog = new KvadratDijalog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KvadratDijalog() {
		setModal(true);
		setTitle("Kvadrat");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblX = new JLabel("X koordinata ta\u010Dke gore levo");
		lblX.setBounds(30, 30, 140, 20);
		contentPanel.add(lblX);
		
		txtX = new JTextField();
		txtX.setBounds(200, 30, 100, 20);
		contentPanel.add(txtX);
		txtX.setColumns(10);
		
		JLabel lblY = new JLabel("Y koordinata ta\u010Dke gore levo");
		lblY.setBounds(30, 70, 140, 20);
		contentPanel.add(lblY);
		
		txtY = new JTextField();
		txtY.setBounds(200, 70, 100, 20);
		contentPanel.add(txtY);
		txtY.setColumns(10);
		
		JLabel lblDuzinaStranice = new JLabel("Du\u017Eina stranice");
		lblDuzinaStranice.setBounds(30, 110, 140, 20);
		contentPanel.add(lblDuzinaStranice);
		
		txtDuzinaStranice = new JTextField();
		txtDuzinaStranice.setBounds(200, 110, 100, 20);
		contentPanel.add(txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);
		
		JLabel lblBojaIvice = new JLabel("Boja ivice:");
		lblBojaIvice.setBounds(206, 197, 60, 20);
		contentPanel.add(lblBojaIvice);
		
		JPanel pnlBojaIvice = new JPanel();
		pnlBojaIvice.setBackground(Color.WHITE);
		pnlBojaIvice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlBojaIvice.setBackground(JColorChooser.showDialog(null, "Izaberite boju ivice", pnlBojaIvice.getBackground()));
			}
		});
		pnlBojaIvice.setBounds(265, 180, 50, 40);
		contentPanel.add(pnlBojaIvice);
		
		JLabel lblBojaUnutranjosti = new JLabel("Boja unutra\u0161njosti:");
		lblBojaUnutranjosti.setBounds(27, 197, 110, 20);
		contentPanel.add(lblBojaUnutranjosti);
		
		JPanel pnlBojaUnutra = new JPanel();
		pnlBojaUnutra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlBojaUnutra.setBackground(JColorChooser.showDialog(null, "Izaberite boju unutrašnjosti", pnlBojaUnutra.getBackground()));
			}
		});
		pnlBojaUnutra.setBackground(Color.WHITE);
		pnlBojaUnutra.setBounds(135, 180, 50, 40);
		contentPanel.add(pnlBojaUnutra);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnPonisti = new JButton("Poni\u0161ti");
				btnPonisti.setActionCommand("Cancel");
				buttonPane.add(btnPonisti);
			}
		}
	}
}
