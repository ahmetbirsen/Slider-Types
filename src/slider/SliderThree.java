package slider;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class SliderThree extends JFrame {
	
	static int counter = 0;
	static int prog_counter = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SliderThree frame = new SliderThree();
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
	public SliderThree() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(104, 21, 200, 300);
		contentPane.add(label);
		
		JButton btnPrev = new JButton("Previous");
		
		btnPrev.setBounds(50, 347, 89, 23);
		contentPane.add(btnPrev);
		
		JButton btnNext = new JButton("Next");
		
		btnNext.setBounds(274, 347, 89, 23);
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
		
		
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(40);
		progressBar.setBounds(50, 381, 313, 14);
		contentPane.add(progressBar);
		
		label.setIcon(new ImageIcon(images.get(counter)));
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				
				if(counter >= images.size()) {
				
					counter = 0;
					prog_counter=20;
					label.setIcon(new ImageIcon(images.get(counter)));
					
				}
				else {
					label.setIcon(new ImageIcon(images.get(counter)));
					prog_counter +=20;
				}
				counter ++;
				progressBar.setValue(prog_counter);
			}
		};
		
		timer.schedule(task, 0 , 2000);
		
		
		
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				timer.cancel();
				
				if(counter==0) {
					
					label.setIcon(new ImageIcon(images.get(images.size()-1)));
					
					counter = images.size()-1;
				}
				
				else{
					
					label.setIcon(new ImageIcon(images.get(counter-1)));
					counter--;
					
				}
				
				progressBar.setValue(progressBar.getValue()-20);
				
			
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				timer.cancel();
				progressBar.setValue(progressBar.getValue()+20);
				
				if(counter == images.size()-1) {
					
					label.setIcon(new ImageIcon(images.get(0)));
					counter=0;
				}
				
				else {
					
					label.setIcon(new ImageIcon(images.get(counter+1)));
					counter++;
				}
			}
		});
	}
}
