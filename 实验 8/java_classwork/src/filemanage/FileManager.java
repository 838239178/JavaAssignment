package filemanage;

import Imultitree.IMultiTreeNode;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;

public class FileManager extends JFrame {
    private File rootFile;
    private JFileChooser fileChooser;
    private JLabel pathName;
    private JTextArea fileMsg;
    private JButton open;

    private final Map<File, Integer> dirNum;
    private final Map<File, Integer> fileNum;

    public FileManager() {
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        rootFile = null;
        fileNum = new HashMap<>();
        dirNum = new HashMap<>();

        Font font = new Font("黑体", Font.PLAIN, 18);
        JPanel msgPanel = new JPanel(new BorderLayout(5, 5));
        JScrollPane scrollPane = new JScrollPane(msgPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        fileMsg = new JTextArea();
        fileChooser = new JFileChooser(new File("."));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        pathName = new JLabel(".");
        open = new JButton("选择路径");

        JScrollBar bar = scrollPane.getVerticalScrollBar();
        bar.setUnitIncrement(45);

        pathName.setFont(font);
        fileMsg.setFont(new Font("consolas", Font.PLAIN, 12));
        fileMsg.setEditable(false);

        msgPanel.add(BorderLayout.NORTH, pathName);
        msgPanel.add(BorderLayout.CENTER, fileMsg);

        open.addActionListener(e -> openFile());

        this.add(BorderLayout.CENTER, scrollPane);
        this.add(BorderLayout.SOUTH, open);

        this.pack();
        this.setSize(500, 600);
    }


    private void openFile() {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileMsg.setText("");
            rootFile = fileChooser.getSelectedFile();
            pathName.setText(rootFile.getAbsolutePath());
            showFileMsg(getFileTreeBFS(rootFile), 0);
        }
    }

    public void showFileMsg(IMultiTreeNode<File> node, int blankNum) {
        for (int i = 0; i < blankNum; i++) {
            fileMsg.append("    ");
        }
        fileMsg.append(node.get().getName());
        if(node.get().isDirectory()){
            File obj = node.get();
            fileMsg.append("(d=" + dirNum.get(obj) + ",f=" + fileNum.get(obj) + ")");
        }
        fileMsg.append("\n");
        Iterator<IMultiTreeNode> it = node.getChildrenIterator();
        while (it.hasNext()) {
            showFileMsg(it.next(), blankNum + 1);
        }
    }

    public IMultiTreeNode<File> getFileTreeBFS(File rootFile) {
        IMultiTreeNode<File> root = new IMultiTreeNode<>(rootFile);
        Queue<IMultiTreeNode<File>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            IMultiTreeNode<File> node = queue.poll();
            File file = node.get();
            int dCnt = 0;
            int fCnt = 0;

            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    IMultiTreeNode c = node.addChild(f);
                    queue.add(c);
                    if (f.isDirectory()) {
                        dCnt++;
                    } else {
                        fCnt++;
                    }
                }
            }

            dirNum.put(file, dCnt);
            fileNum.put(file, fCnt);
        }

        return root;
    }

    public static void main(String[] args) {
        new FileManager();
    }

}