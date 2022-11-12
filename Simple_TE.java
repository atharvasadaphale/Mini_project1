import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.*;

public class Simple_TE implements ActionListener {
    JFrame frame;//creating JFrame
    JTextArea area;//creating area
    JMenuBar Menubar;
    Simple_TE(){//constructor for STE
        frame= new JFrame("Text Editor");//creating frame
        area=new JTextArea();//creating area
        frame.add(area);//adding text area to frame

        Menubar = new JMenuBar();
        JMenu file=new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");

        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem print = new JMenuItem("Print");
        JMenuItem newfile = new JMenuItem("New file");

        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        newfile.addActionListener(this);


        file.add(open);
        file.add(save);
        file.add(print);
        file.add(newfile);

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem close = new JMenuItem("Close");//ref string

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        close.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(close);


        Menubar.add(file);
        Menubar.add(edit);
        Menubar.add(view);


        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setJMenuBar(Menubar);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        Simple_TE obj = new Simple_TE();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String call=e.getActionCommand();

        //string should be as mentioned as string above not as name(((V.V.V.V.V.IMP)))

        if(call=="New file"){
            area.setText("");
        }
        else if(call=="Cut"){
            area.cut();
        }
        else if(call=="Copy"){
            area.copy();
        }
        else if(call=="Paste"){
            area.paste();
        }
        else if(call=="Close"){
            frame.setVisible(false);
        }
        else if(call=="Save"){
            JFileChooser filechooser = new JFileChooser("D:");
            int verdict=filechooser.showOpenDialog(null);
            if(verdict== filechooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(file, false));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.write(area.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if(call=="Open"){
            JFileChooser chooseropen = new JFileChooser("D:");
            int ans = chooseropen.showOpenDialog(null);
            if(ans==chooseropen.APPROVE_OPTION);{
                File file = new File(chooseropen.getSelectedFile().getAbsolutePath());
                try {
                    String s1="", s2="";
                    BufferedReader buffread = new BufferedReader(new FileReader(file));
                    s2= buffread.readLine();
                    while((s1=buffread.readLine())!=null) {
                        s2 += s1 + "\n";
                    }
                    area.setText(s2);
                }  catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if(call=="Print"){
            try {
                area.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
