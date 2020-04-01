package DiscordGuilds.Gui;

import DiscordGuilds.Guilds.DiscordGuild;
import DiscordGuilds.Guilds.DiscordGuildManager;
import DiscordGuilds.Utils.DiscordUtils.DiscordUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class FensterJFrame extends JFrame implements ActionListener {
    private DiscordGuild derGuildIDfinder;
    JTextField Messages;
    JTextArea Discord_Guilds;
    JButton button;
    String containsmsg;
    JTextField searchinput;
    JFileChooser fileChooser = new JFileChooser();


    public FensterJFrame() {
        this.getContentPane().setLayout(null);

        this.initWindow();
    }

    protected void initWindow() {
        setBounds(600,600,600,600);
        derGuildIDfinder = DiscordGuildManager.getGuildById("216832222689230849");
        searchinput = new JTextField();
        Messages = new JTextField(derGuildIDfinder.getGuildName());
        Discord_Guilds = new JTextArea(containsmsg);
        Discord_Guilds.setBounds(300, 100, 400, 500);
        button = new JButton("Search");
        button.addActionListener(this);
        Messages.setBounds(100, 10, 400, 20);
        searchinput.setBounds(100, 300, 400, 20);
        button.setBounds(100, 500, 300, 20);
        this.getContentPane().add(Messages);
        this.getContentPane().add(Discord_Guilds);
        this.getContentPane().add(button);
        this.getContentPane().add(searchinput);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Discord_Guilds.setText(DiscordUtil.printOutSearchResults(searchinput.getText()).equals("") ? "Nothing found" : DiscordUtil.printOutSearchResults(searchinput.getText()));


    }

}