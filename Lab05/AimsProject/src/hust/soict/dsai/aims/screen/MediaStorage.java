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
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class MediaStorage extends JPanel{
	private Media media;
	
	public MediaStorage(Media media, Store store) {
		
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to store");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store.addMedia(media);
                showAddDialog(media);
                System.out.println("Total number of medias in store: " + store.getItemsInStore().size());
            }
        });
        container.add(addToCartButton);
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	private void showAddDialog(Media media) {
	    JDialog addDialog = new JDialog();
	    addDialog.setTitle("Message");
	    addDialog.setSize(400, 150);
	    addDialog.setLayout(new BorderLayout());
	    addDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	    JLabel message = new JLabel(media.getTitle() + " has been added to the store.", JLabel.CENTER);
	    addDialog.add(message, BorderLayout.CENTER);

	    JButton closeButton = new JButton("OK");
	    closeButton.addActionListener(e -> addDialog.dispose());  
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(closeButton);
	    addDialog.add(buttonPanel, BorderLayout.SOUTH); 

	    addDialog.setVisible(true);
	}
}
