package DiscordGuilds.Gui;

import DiscordGuilds.Core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class GuiFileFrame extends JFrame {
    @Override
    protected void frameInit() {
        super.frameInit();
        JLabel label = new JLabel();
        JButton knopf = new JButton("load package");
        JFrame frame = new JFrame("select your data package");
        JFileChooser fileChooser = new JFileChooser();


        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            label.setText("Folder Selected: " + file.getName());
        }else{
            label.setText("Open command canceled");
        }
        knopf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            Core.loadPackage(fileChooser.getSelectedFile());
            FensterJFrame fenster = new FensterJFrame();
            fenster.initWindow();
            fenster.setVisible(true);
            }
        });
        fileChooser.setBounds(10,100,170,20);
        fileChooser.setVisible(false);
        frame.setVisible(true);
        label.show();
        frame.setBounds(600,600,600,600);
        knopf.setBounds(100,300,100,100);
        knopf.setVisible(true);
        frame.add(knopf);
        frame.add(label);
        frame.add(fileChooser);


    }
}
