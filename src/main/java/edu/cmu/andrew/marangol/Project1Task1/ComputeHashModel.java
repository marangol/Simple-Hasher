package edu.cmu.andrew.marangol.Project1Task1;

/*
 * @author Martin Arango (marangol)
 *
 * This file is the Model component of the MVC
 * It computes the hash of the input string using the hash algorithm selected in the view.
 * /Project1Task1-1.0-SNAPSHOT
 */

import jakarta.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ComputeHashModel {
    private String inputStr;
    private String hashAlgorithm;
    private String hashHex;
    private String hashBase64;
    private byte[] digest;

    /**
     * Computes hash with input string (inputStr) and hash algorithm (hashAlgorithm) from the view.
     * These parameters must be set on the model first before executing this method.
     */
    public void computeHash() {
        try {
            // Access MessageDigest class for selected hash algorithm
            MessageDigest md = MessageDigest.getInstance(this.hashAlgorithm);
            // Add input bytes to MessageDigest object
            md.update(this.inputStr.getBytes());
            // Compute digest and store in byte type attribute
            this.digest = md.digest();
            // Convert digest in bytes to hexadecimal string
            this.hashHex = DatatypeConverter.printHexBinary(this.digest);
            // Convert digest in bytes to base64 string
            this.hashBase64 = DatatypeConverter.printBase64Binary(this.digest);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Selected hash algorithm not available" + e);
        }
    }

    /*
     * Getters and setters for the model's attributes.
     */
    public String getInputStr() {
        return inputStr;
    }

    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    public String getHashHex() {
        return hashHex;
    }

    public String getHashBase64() {
        return hashBase64;
    }

    public byte[] getDigest() {
        return digest;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }
}
