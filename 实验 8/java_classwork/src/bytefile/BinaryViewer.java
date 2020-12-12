package bytefile;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryViewer extends JFrame {
    private File openedFile = null;
    private JTextArea textArea;
    private JFileChooser chooser;
    private JButton fileOpenBtn;
    JScrollPane scrollPane;

    public BinaryViewer() {
        this.setTitle("二进制文件查看器");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        fileOpenBtn = new JButton("打开文件");
        fileOpenBtn.addActionListener(e -> openFile());
        chooser = new JFileChooser(".");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        textArea = new JTextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 15));
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(BorderLayout.CENTER, scrollPane);
        this.add(BorderLayout.SOUTH, fileOpenBtn);

        this.pack();
        this.setSize(800, 600);
        Point location = this.getLocation();
        this.setLocation(location.x - getWidth() / 2, location.y - getHeight() / 2);
    }

    private void openFile() {
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            openedFile = chooser.getSelectedFile();
            transFileToHex();
        }
    }

    private String getASCII(List<Byte> data) {
        StringBuilder builder = new StringBuilder();
        for (byte bt : data) {
            char value = (char) bt;
            //制表符、非ASCII字符用‘。’代替
            if (value > 0x80 || Character.isISOControl(value))
                builder.append(".");
            else
                builder.append(value);
        }
        return builder.toString();
    }

    private byte[] readFileByte() throws IOException {
        if (openedFile != null) {
            byte[] bytes = null;
            try (InputStream bis = new BufferedInputStream(new FileInputStream(openedFile))) {
                bytes = new byte[bis.available()];
                bis.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bytes;
        }
        return null;
    }

    private void transFileToHex() {
        try {
            textArea.setText("");
            textArea.append("file name: " + openedFile.getName());
            int hexIndex = 0x00;
            byte[] fileBytes = readFileByte();
            List<Byte> asciiOfLine = new ArrayList<>();
            for (byte bt : fileBytes) {
                if (hexIndex % 0x10 == 0) {
                    textArea.append("  " + getASCII(asciiOfLine));
                    textArea.append(String.format("\n%08x", hexIndex));
                    asciiOfLine.clear();
                }
                if (hexIndex % 0x08 == 0) {
                    textArea.append(" ");
                }
                hexIndex++;
                asciiOfLine.add(bt);
                textArea.append(String.format(" %02x", bt).toUpperCase());
            }

            //Add To Multiply Of 16
            for (int i = fileBytes.length; i % 16 != 0; i++) {
                if (hexIndex % 0x08 == 0) {
                    textArea.append(" ");
                }
                hexIndex++;
                textArea.append(String.format(" %02x", 0x20));
            }
            if(!asciiOfLine.isEmpty()) {
                textArea.append("  " + getASCII(asciiOfLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BinaryViewer();
    }
}
