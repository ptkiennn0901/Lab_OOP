import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want me to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        
//        int optional = JOptionPane.showOptionDialog(null,
//                "Do you want me to change to the first class ticket?",   // Message
//                "Choose an option",          // Title
//                JOptionPane.YES_NO_OPTION,   // Option type
//                JOptionPane.QUESTION_MESSAGE, // Message type
//                null,                        // Icon (can be null)
//                new String[]{"I do", "I don't"},   // Custom options
//                "Yes");                      // Default option
//
//        if (optional == JOptionPane.YES_OPTION) {
//            System.out.println("You chose Yes");
//        } else {
//            System.out.println("You chose No");
//        }
        
        System.exit(0);
    }
}
