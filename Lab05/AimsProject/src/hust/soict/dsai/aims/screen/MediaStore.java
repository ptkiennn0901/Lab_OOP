package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;

public class MediaStore extends JPanel{
	private Media media;
	
	public MediaStore(Media media, Cart cart) {
		
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					cart.addMedia(media);
					showAddDialog(media);
				} catch (LimitExceededException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
            }
        });
        container.add(addToCartButton);
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
            container.add(playButton);

            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
						showPlayDialog();
					} catch (PlayerException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
                }
            });
			
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	private void showPlayDialog() throws PlayerException{
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Playing Media");
        playDialog.setSize(500, 500);
        playDialog.setLayout(new FlowLayout());
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        if (media instanceof DigitalVideoDisc) {
        	DigitalVideoDisc dvd = (DigitalVideoDisc) media;
        	if (dvd.getLength() > 0){
        		JLabel message = new JLabel("<html>Playing DVD: " + dvd.getTitle() +  "<br>DVD length: " + dvd.getLength() + "<html>");
        		playDialog.add(message);
        	}else{
        		throw new PlayerException("ERROR: DVD length is non-positive");
        	}
        }else {
        	CompactDisc cd = (CompactDisc) media;
        	if (cd.getLength() > 0) {
        		String messageString = "";
        		for (Track track: cd.getTracks()) {
        			if (track.getLength() > 0) {
        				messageString += "<br>Playing track" + track.getTitle() + "<br>Track length: " + track.getLength();
        			}else {
        				throw new PlayerException("ERROR: Track length is non-positive");
        			}
        		}
        		JLabel message = new JLabel("<html>" + messageString +"<html>");
        		playDialog.add(message);
        	}else {
        		throw new PlayerException("ERROR: CD length is non-positive");
        	}
        }

        playDialog.setLocationRelativeTo(this); // Center the dialog relative to the panel
        playDialog.setVisible(true);
    }
	
	private void showAddDialog(Media media) {
		JDialog addDialog = new JDialog();
	    addDialog.setTitle("Message");
	    addDialog.setSize(400, 150);
	    addDialog.setLayout(new BorderLayout());
	    addDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	    JLabel message = new JLabel(media.getTitle() + " has been added to the cart.", JLabel.CENTER);
	    addDialog.add(message, BorderLayout.CENTER);

	    JButton closeButton = new JButton("OK");
	    closeButton.addActionListener(e -> addDialog.dispose());  
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(closeButton);
	    addDialog.add(buttonPanel, BorderLayout.SOUTH); 

	    addDialog.setVisible(true);
	}
}
