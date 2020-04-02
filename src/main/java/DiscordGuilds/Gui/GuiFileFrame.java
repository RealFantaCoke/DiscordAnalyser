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

        knopf.addActionListener(e -> {
            frame.setVisible(false);
            Core.loadPackage(fileChooser.getSelectedFile());
            FensterJFrame fenster = new FensterJFrame();
            fenster.setVisible(true);
        });

        fileChooser.setBounds(10,100,170,20);
        fileChooser.setVisible(false);
        frame.setVisible(true);
        label.show();
        label.setBounds(10,25,100,20);
        frame.setBounds(600,600,210,170);
        knopf.setBounds(10,45,100,20);
        knopf.setVisible(true);
        frame.add(knopf);
        frame.add(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
