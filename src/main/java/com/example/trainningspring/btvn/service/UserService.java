package com.example.trainningspring.btvn.service;

import com.example.trainningspring.btvn.model.dto.user.UserCreateRequest;
import com.example.trainningspring.btvn.model.entity.User;
import com.example.trainningspring.btvn.repository.UserRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAllUser(){
        return userRepository.findAllUser();
    }
    public User findById(Integer id){
        return userRepository.findById(id);
    }

    public User findUser(String username, String password){

        return userRepository.findUser(username, password);
    }
    public User insertNewUser(String username, String password){
        return userRepository.insertNewUser(username,password);
    }
    public int createUser(UserCreateRequest userCreateRequest){
        return userRepository.saveUser(User.builder()
                .username(userCreateRequest.getUsername())
                .password(userCreateRequest.getPassword())
                .build());
    }

    public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }


    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

}
