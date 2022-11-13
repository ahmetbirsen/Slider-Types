package slider;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SliderTwo extends JFrame {

	private JPanel contentPane;
	
	static int counter = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SliderTwo frame = new SliderTwo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public SliderTwo() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(61, 36, 200, 300);
		contentPane.add(label);
		
		JButton btnPrev = new JButton("Previous");
		
		btnPrev.setBounds(61, 360, 89, 23);
		contentPane.add(btnPrev);
		
		JButton btnNext = new JButton("Next");
		
		btnNext.setBounds(172, 360, 89, 23);
		contentPane.add(btnNext);
		
		File imageFile1 = new File("./pic/1.jpg");
		Image image1 = ImageIO.read(imageFile1);
		
		File imageFile2 = new File("./pic/2.jpg");
		Image image2 = ImageIO.read(imageFile2);
		
		File imageFile3 = new File("./pic/3.jpg");
		Image image3 = ImageIO.read(imageFile3);
		
		File imageFile4 = new File("./pic/4.jpg");
		Image image4 = ImageIO.read(imageFile4);
		
		File imageFile5 = new File("./pic/5.jpg");
		Image image5 = ImageIO.read(imageFile5);
		
		ArrayList<Image> images = new ArrayList<Image>();
		
		images.add(image1);
		images.add(image2);
		images.add(image3);
		images.add(image4);
		images.add(image5);
		
		label.setIcon(new ImageIcon(images.get(counter)));
		//counter = 3;
		
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(counter==0) {
					
				}
				
				else{
					
					label.setIcon(new ImageIcon(images.get(counter-1)));
					counter--;
					
				}
				
			}
		});
		
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(counter == images.size()-1) {
					
				}
				
				else {
					
					label.setIcon(new ImageIcon(images.get(counter+1)));
					counter++;
				}
			}
		});
	}
}
