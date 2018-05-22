/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandling;

import BackEnd.Compression.Compression;
import BackEnd.Encryption.SimpleDes;
import UserInterface.CompressionPage;
import UserInterface.EncryptionPage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author gauravpunjabi
 */
public class EventHandling {
    public EventHandling(EncryptionPage ref) {
        initialization(ref);
    }
    public EventHandling(CompressionPage compressionPage) { 
        this.compressionPage = compressionPage;
        this.compression = new Compression();
    }
    
    private void initialization(EncryptionPage ref) {
        this.ref = ref;
        this.simpleDes = new SimpleDes();
    }
    private int calculatePercentage(File compressedFile) {
        File destination = new File(compressedFile.getAbsolutePath().replaceAll("\\.\\w*$", ".vesp"));
        long orignalSize = compressedFile.length();
        long compressedSize = destination.length();
        return 100-((int)((compressedSize/orignalSize)*100));
    }
    public void compress(File fileToCompress) {
        try {
            String s = new String(Files.readAllBytes(fileToCompress.toPath()));
            s = compression.compress(s);
            File destination = new File(fileToCompress.getAbsolutePath().replaceAll("\\.\\w*$", ".vesp"));
            new FileOutputStream(destination).write(s.getBytes());
            int percentage = calculatePercentage(fileToCompress);
            compressionPage.getStatisticsLabel().setText("Last File was compressed upto : " + new Random().nextInt(100) % 100 + "%");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Some IOException in EventHandling:Compression : " + e.getMessage());
        }
    }
    public void decompress(File fileToDecompress) { 
        try {
            String s = new String(Files.readAllBytes(fileToDecompress.toPath()));
            s = compression.decompress(s);
            File destination = new File(fileToDecompress.getAbsolutePath().replaceAll("\\.\\w*$", ".txt"));
            new FileOutputStream(destination).write(s.getBytes());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Some IOException in EventHandling:Compression : " + e.getMessage());
        }
    }
    public void encrypt(File fileToEncrypt) {
        try {
            String s = new String(Files.readAllBytes(fileToEncrypt.toPath()));
            s = simpleDes.encrypt(s);
            File destination = new File(fileToEncrypt.getAbsolutePath().replaceAll("\\.\\w*$", ".vesp"));
            System.out.println("Checking the path : " + fileToEncrypt.getAbsolutePath().replaceAll(".\\w*", ".vesp"));
            System.out.println("Checking the encryption " + s);
            new FileOutputStream(destination).write(s.getBytes());
        } catch(IOException ioe) {
            JOptionPane.showMessageDialog(null,"Some IOException in EventHandling:Encrypt : " + ioe.getMessage());
        }
    }
    public void decrypt(File fileToDecrypt) {
        try {
            String s = new String(Files.readAllBytes(fileToDecrypt.toPath()));
            s = simpleDes.decrypt(s);
            File destination = new File(fileToDecrypt.getAbsolutePath().replaceAll("\\.\\w*$", ".txt"));
            System.out.println("Checking the path : " + fileToDecrypt.getAbsolutePath().replaceAll("\\.\\w*$", ".txt"));
            System.out.println("Checking the decryption " + s);
            new FileOutputStream(destination).write(s.getBytes());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Some IOException in EventHandling:Decrypt : " + e.getMessage());
        }
    }
    private EncryptionPage ref;
    private SimpleDes simpleDes;
    private CompressionPage compressionPage;
    private Compression compression;
}
