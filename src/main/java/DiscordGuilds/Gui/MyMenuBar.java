package DiscordGuilds.Gui;

import DiscordGuilds.Core;
import DiscordGuilds.Utils.DiscordUtils.DiscordUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenuItem load,save;
        JMenuItem search;
        search = new JMenuItem("Search");
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        editMenu.add(search);
        fileMenu.add(load);
        //fileMenu.add(save);

        this.add(fileMenu);
        this.add(editMenu);
        search.addActionListener(e -> {
            JButton searchButton = new JButton("Search");
            JTextField searchInput = new JTextField();
            JFrame searchFrame = new JFrame("Search");
            searchFrame.setLayout(new BorderLayout(5,5));
            searchButton.setSize(50,20);
            searchInput.setSize(500,20);
            searchFrame.add(searchButton, BorderLayout.EAST);
            searchFrame.add(searchInput,BorderLayout.CENTER);
            searchFrame.setVisible(true);
            searchFrame.setSize(600,200);
            searchButton.addActionListener(e1 ->{
                String searchText = searchInput.getText();
                Core.gui.Discord_Guilds.setText(DiscordUtil.printOutSearchResults(searchText));
            });
        });
        load.addActionListener(e ->{
            JFileChooser chooser = new JFileChooser();
            File file;
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = chooser.showOpenDialog(null);
            if(option == JFileChooser.APPROVE_OPTION){
                file = chooser.getSelectedFile();
                Core.unLoadCurrentPackage();
                Core.loadPackage(file);
                Core.gui.panelLeft.remove(Core.gui.dataTree);
                Core.gui.addTree();
                Core.gui.panelLeft.add(Core.gui.dataTree, BorderLayout.CENTER);
                JOptionPane.showMessageDialog(null,"Successfully loaded new Package!");
            }else{
                JOptionPane.showMessageDialog(null,"Could not open selected file. Idk why lool");
            }
        });
    }
}
