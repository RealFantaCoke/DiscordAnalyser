package DiscordGuilds.Gui;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu menu = new JMenu("file");
        JMenuItem load,save;
        load = new JMenuItem("load");
        save = new JMenuItem("Save");
        menu.add(load);
        menu.add(save);
        this.add(menu);

        load.addActionListener(e ->{
            JFileChooser chooser = new JFileChooser();
        });
    }
}
