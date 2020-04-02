package DiscordGuilds.Gui;

import DiscordGuilds.Channels.DiscordGuildChannel;
import DiscordGuilds.DirectMessages.DiscordDirectConversation;
import DiscordGuilds.DirectMessages.DiscordDirectConversationManager;
import DiscordGuilds.Groups.DiscordGroup;
import DiscordGuilds.Groups.DiscordGroupManager;
import DiscordGuilds.Guilds.DiscordGuild;
import DiscordGuilds.Guilds.DiscordGuildManager;
import DiscordGuilds.Utils.DiscordUtils.DiscordMessage;
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
    MyMenuBar toolbar;
    JFileChooser fileChooser = new JFileChooser();
    BorderLayout layout;

    public FensterJFrame() {

        this.initWindow();
    }

    protected void initWindow() {

        /*
         * Initializing components
         */
        toolbar = new MyMenuBar();
        layout = new BorderLayout();
        searchinput = new JTextField();
        Discord_Guilds = new JTextArea(DiscordUtil.printOutSearchResults("o"));
        buttonSearch = new JButton("Search");
        buttonClear = new JButton("Clear Searchresults");
        //addTree();

        /*
         * Setting Colors
         */
        searchinput.setBackground(new Color(44, 44, 44, 246));
        Discord_Guilds.setBackground(new Color(44, 44, 44, 246));
        searchinput.setForeground(Color.WHITE);
        Discord_Guilds.setForeground(Color.WHITE);



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

        /*
         * setting the size of the components
         */
        layout.setVgap(40);
        Discord_Guilds.setSize( 900, 500);
        searchinput.setSize( 400, 20);
        buttonClear.setSize( 300, 20);
        buttonSearch.setSize(300, 20);
        setSize( 600, 600);
        setJMenuBar(toolbar);

        /*
         * Tree
         */


        /*
         * Adding components to the Pane
         */
        addTree();

        JPanel panelLeft = new JPanel(new BorderLayout(0,0));
        JPanel panelRight = new JPanel(new BorderLayout(5,5));
        panelLeft.add(new JLabel("File Tree", SwingConstants.CENTER), BorderLayout.NORTH);
        panelLeft.setBackground(new Color(44, 44, 44, 246));
        panelLeft.setForeground(Color.WHITE);
        panelLeft.add(dataTree,BorderLayout.CENTER);
        
        panelRight.add(Discord_Guilds,BorderLayout.CENTER);
        panelRight.setForeground(Color.WHITE);
        panelRight.setBackground(new Color(44, 44, 44, 246));
        this.getContentPane().add(panelLeft,BorderLayout.WEST);
        this.getContentPane().add(panelRight,BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void addTree(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Package");

        DefaultMutableTreeNode guilds = new DefaultMutableTreeNode("Guilds");
        for(DiscordGuild g : DiscordGuildManager.guilds){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(g.guildName);
            for(DiscordGuildChannel ch : g.getChannels()){
                DefaultMutableTreeNode channelNode = new DefaultMutableTreeNode(ch.channelName);
                for(DiscordMessage msg : ch.getMessages()){
                    DefaultMutableTreeNode msgNode = new DefaultMutableTreeNode(msg.messageId);
                    channelNode.add(msgNode);
                }
                node.add(channelNode);
            }

            guilds.add(node);
        }
        root.add(guilds);
        DefaultMutableTreeNode groups = new DefaultMutableTreeNode("Groups");
        for(DiscordGroup g : DiscordGroupManager.groups){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(g.getId());
            for(DiscordMessage msg : g.getMessages()){
                DefaultMutableTreeNode msgNode = new DefaultMutableTreeNode(msg.messageId);
                node.add(msgNode);
            }
            groups.add(node);
        }
        root.add(groups);
        DefaultMutableTreeNode DMs = new DefaultMutableTreeNode("DirectMessages");
        for(DiscordDirectConversation g : DiscordDirectConversationManager.directConversations){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(g.getId());
            for(DiscordMessage msg : g.getMessages()){
                DefaultMutableTreeNode msgNode = new DefaultMutableTreeNode(msg.messageId);
                node.add(msgNode);
            }
            DMs.add(node);
        }
        root.add(DMs);

        dataTree = new JTree(root);
        dataTree.setSize( 500,500);
        dataTree.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        dataTree.setBackground(new Color(44, 44, 44, 246));
        dataTree.setFont(new Font("Verdana",Font.PLAIN,12));
        dataTree.setForeground(new Color(44, 44, 44, 246));
        dataTree.addTreeSelectionListener(e ->{
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
            DiscordMessage msg = DiscordUtil.getMessageById((String)selectedNode.getUserObject());
            if(msg == null)
                Discord_Guilds.setText("Waiting for input...");
            else
                Discord_Guilds.setText(msg.messageContent);
        });
    }
}