package DiscordGuilds.Gui;

import DiscordGuilds.Groups.DiscordGroup;
import DiscordGuilds.Groups.DiscordGroupManager;
import DiscordGuilds.Guilds.DiscordGuild;
import DiscordGuilds.Guilds.DiscordGuildManager;
import DiscordGuilds.Utils.DiscordUtils.DiscordUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FensterJFrame extends JFrame {
    private DiscordGuild derGuildIDfinder;
    JTextField Messages;
    String searchInputAsString;
    JTextArea Discord_Guilds;
    JButton buttonSearch;
    JButton buttonClear;
    String containsmsg;
    JTextField searchinput;
    JTree dataTree;
    JFileChooser fileChooser = new JFileChooser();


    public FensterJFrame() {
        this.getContentPane().setLayout(new GridLayout());
        this.initWindow();
    }

    protected void initWindow() {
        setSize( 600, 600);
        //derGuildIDfinder = DiscordGuildManager.getGuildById("216832222689230849");
        searchinput = new JTextField();
        // Messages = new JTextField(derGuildIDfinder.getGuildName());
        Discord_Guilds = new JTextArea(containsmsg);
        Discord_Guilds.setBounds(500, 100, 900, 500);
        buttonSearch = new JButton("Search");
        buttonClear = new JButton("Clear Searchresults");
        //this.setBackground(new Color(44, 44, 44, 246));
        searchinput.setBackground(new Color(44, 44, 44, 246));
        Discord_Guilds.setBackground(new Color(44, 44, 44, 246));
        searchinput.setForeground(Color.WHITE);
        Discord_Guilds.setForeground(Color.WHITE);

        addTree();
        dataTree.setBackground(new Color(44, 44, 44, 246));
        dataTree.setForeground(Color.WHITE);
        /*
         *  listeners
         */
        buttonClear.addActionListener(e -> {
            Discord_Guilds.setText("");
            searchinput.setText("");
        });
        buttonSearch.addActionListener(e -> {
            String si = searchinput.getText();
            Discord_Guilds.setText(DiscordUtil.printOutSearchResults(si));
        });
        //Messages.setBounds(100, 10, 400, 20);
        searchinput.setSize( 400, 20);
        buttonClear.setSize( 300, 20);
        buttonSearch.setSize(300, 20);
        //this.getContentPane().add(Messages);
        this.getContentPane().add(Discord_Guilds);
        this.getContentPane().add(buttonSearch);
        this.getContentPane().add(searchinput);
        this.getContentPane().add(buttonClear);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void addTree(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Package");
        DefaultMutableTreeNode guilds = new DefaultMutableTreeNode("Guilds");
        for(DiscordGuild g : DiscordGuildManager.guilds){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(g.guildName);
            guilds.add(node);
        }
        root.add(guilds);
        DefaultMutableTreeNode groups = new DefaultMutableTreeNode("Guilds");
        for(DiscordGroup g : DiscordGroupManager.groups){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(g.getId());
            groups.add(node);
        }
        root.add(groups);
        dataTree = new JTree(root);
        dataTree.setBounds(10,10, 500,500);
        dataTree.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        JScrollBar scrollbar = new JScrollBar();
        scrollbar.setVisible(true);
        dataTree.add(scrollbar);
        this.add(dataTree);

    }
}