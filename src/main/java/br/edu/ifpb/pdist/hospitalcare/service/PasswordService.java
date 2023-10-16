package br.edu.ifpb.pdist.hospitalcare.service;

import org.springframework.security.crypto.bcrypt.BCrypt;

public abstract class PasswordService {
    
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            return true;
        else
            return false;
    }
}
