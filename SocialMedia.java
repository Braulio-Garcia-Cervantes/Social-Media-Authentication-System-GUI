import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SocialMedia implements ActionListener
{
    private static int strength;
    private static JLabel username; 
    private static JTextField userinput; 
    private static JLabel password;
    private static JPasswordField passinput;
    private static JButton button;
    private static JButton button2;
    private static String un;
    private static String pw;
    private static ActionListener bl; 
    private static ActionListener bl2;
    private static int attempts = 0;
    
    public static void main (String[] args)
    {
        buttonlisteners();
        
        JOptionPane.showMessageDialog(null, "Welcome to OurSocialMediaPlatform!" + "\n" + "Create an account.");
         un = JOptionPane.showInputDialog(null, "Create a username. (This is how you'll be seen to others)");
        JOptionPane.showMessageDialog(null, "Hi, " + un + "!");
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your age?"));
            if(age < 18)
            {
                JOptionPane.showMessageDialog(null, "You are not old enough to use OurSocialMediaPlatform!");
                System.exit(0);
            }
         pw = JOptionPane.showInputDialog(null, "Create a Password." + "\n" + "Password must contain:" + "\n" + "At least 7 characters" + "\n" + "An uppercase" + "\n" + "A lowercase" + "\n" + "A number");   
        validPassword(pw);
        passwordStrength(pw);
            if(strength > 3)
            {
                JOptionPane.showMessageDialog(null, "Password Strength: Strong");
            }
            else if(strength >= 3 && strength <= 4)
            {
                JOptionPane.showMessageDialog(null, "Password Strength: Medium");
            }
            else if(strength >= 1 && strength <= 2)
            {
                JOptionPane.showMessageDialog(null, "Password Strength: Weak");
            }
        
        
        JFrame frame = new JFrame();
         JPanel panel = new JPanel(); 
         
         panel.setLayout(null);
         
             frame.setSize(500,500);
             frame.setTitle("OurSocialMedia");
             frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
             frame.setResizable(false);
             frame.add(panel);
         
         
         username = new JLabel("User");
             username.setBounds(10,20,80,25);
             panel.add(username);
         
         
         userinput = new JTextField(20);
             userinput.setBounds(100,20,165,25);
             panel.add(userinput);
         
         
         password = new JLabel("Password");
             password.setBounds(10,50,80,25);
             panel.add(password);
         
         passinput = new JPasswordField(20);
             passinput.setBounds(100,50,165,25);
             panel.add(passinput);
         
         
         button = new JButton("Login");
            button.setBounds(10,80,80,25);
            button.addActionListener(bl);
            panel.add(button);
            
            
        button2 = new JButton("Forgot Password?");
            button2.setBounds(10,120,120,50);
            button2.addActionListener(bl2);
            panel.add(button2);
          
            
        
          
            
            
         frame.setVisible(true);
         
        
    }
       public static void buttonlisteners()
    {
        bl = new ActionListener()
       {
            @Override
            public void actionPerformed (ActionEvent event)
            {
                String userinput = username.getText();
                String pass = passinput.getText();
                
                    if(userinput.equals(un) && pass.equals(pw))
                    {
                        JOptionPane.showMessageDialog(null, "Welcome " + un);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Access Denied.");
                    }
                    attempts++;
                    if(attempts >= 3)
                    {
                        JOptionPane.showMessageDialog(null, "You've been locked out for 20 minutes.");
                    }
            }
        };
        
        
        
         bl2 = new ActionListener()
         {
              @Override
              public void actionPerformed (ActionEvent event)
              {
                    String email = JOptionPane.showInputDialog(null, "Enter your email for password recovery.");
                        
                       while(email.equals(""))
                       {
                            email = JOptionPane.showInputDialog(null, "Enter vaild email.");
                        }
                
                JOptionPane.showMessageDialog(null, "Email has been sent!" + "\n" + "If email is not received within 2 minutes, click - Forgot Password - again.");
                
                
                }
            };
    }
    public void actionPerformed (ActionEvent event)
    {
        String user = userinput.getText();
        String pass = passinput.getText();
        
            if(user.equals(un) && pass.equals(pw))
            {
               JOptionPane.showMessageDialog(null, "Login Successful."); 
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Access Denied."); 
            }
        attempts++; 
            if(attempts >= 3)
            {
                JOptionPane.showMessageDialog(null, "You've been locked out for 20 minutes."); 
            }
    }
    
    public static boolean validPassword(String password)
    {
        if(password.length() >= 8)
        {
            if(checkPassword(password))
            {
                JOptionPane.showMessageDialog(null, "Valid Password");
                return true; 
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Invalid Password");
                JOptionPane.showInputDialog(null, "Create a Password.");
                return false;
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Invalid Password, must contain at least 8 characters!");
            JOptionPane.showInputDialog(null, "Create a Password.");
            return false; 
        }
    }
    public static boolean checkPassword(String password)
    {
        boolean hasNum = false; boolean hasCap = false; boolean hasLow = false; char c; 
             
            for(int i = 0; i < password.length(); i++)
            {
                c = password.charAt(i); 
                
                    if(Character.isDigit(c))
                    {
                        hasNum = true; 
                    }
                    else if(Character.isUpperCase(c))
                    {
                        hasCap = true; 
                    }
                    else if(Character.isLowerCase(c))
                    {
                        hasLow = true;
                    }
                    
                    if(hasNum && hasCap && hasLow)
                    {
                        return true; 
                    }
                   
                    
                    
            }
            return false; 
    }
    public static int passwordStrength(String password)
    {
        strength = 0;
        int length = password.length();
        
            if(length >= 7 && length <= 10)
            {
                strength += 1; 
            }
            else if(length >= 11 && length <= 13)
            {
                strength += 2;
            }
            else if(length > 13)
            {
                strength += 3; 
            }
            
            if(password.matches("(?=.*[a-z]).*"))
            {
                strength += 1;
            }
            else if(password.matches("(?=.*[A-Z]).*"))
            {
                strength += 1;
            }
            else if(password.matches("(?=.*[!@#$%^&*]).*"))
            {
                strength += 1;
            }
            
            return strength;
    }
}