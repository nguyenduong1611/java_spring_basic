package com.example.trainningspring.btvn.controller;

import com.example.trainningspring.btvn.model.dto.user.khaibao.KhaiBaoCreateRequest;
import com.example.trainningspring.btvn.model.entity.KhaiBao;
import com.example.trainningspring.btvn.model.entity.User;
import com.example.trainningspring.btvn.repository.database.KhaiBaoDB;
import com.example.trainningspring.btvn.repository.database.UserDB;
import com.example.trainningspring.btvn.service.KhaiBaoService;
import com.example.trainningspring.btvn.service.UserService;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    UserDB userDB;

    @Autowired
    KhaiBaoDB khaiBaoDB;

    @Autowired
    KhaiBaoService khaiBaoService;

    public static int id;
    public static int id_signup;
    public static String sdt;
//    public static String thongtin;
    private static final String QR_CODE_IMAGE_PATH = "src/main/resources/static/QRCode.png";

    @GetMapping("")
    public String viewHomePage() {
        return "login";
    }

    @GetMapping("/menuhomepage")
    public String viewMenuHomePage(Model model) {

        List<KhaiBao> lstkhaibaoBT = khaiBaoService.findBySDT(sdt);
        System.out.println(lstkhaibaoBT);
        model.addAttribute("lstkhaibao", lstkhaibaoBT);
        return "Menu";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "Signup";
    }
    @GetMapping("/dangky")
    public String DangKy(Model model) {
        model.addAttribute("user", new User());
        return "Signup";
    }

    @GetMapping("/login")
    public String backToLogin(Model model) {
        return "Login";
    }
    @GetMapping("/logout")
    public String logOut(Model model) {
        return "Login";
    }

    @PostMapping("/process_register")
    public String processRegistration(
            User user,
            Model model) {
        userDB.save(user);
//        model.addAttribute("khaibao", new KhaiBao());
        id_signup = user.getId();
        System.out.println(id_signup);
        return "Menu";
    }

    @PostMapping("/process_login")
    public String processLogin(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            Model model
    ) throws Exception{
        User user = userService.findUser(username, password);
        if (user != null) {
            sdt = user.getUsername();
//            System.out.println(sdt);
            String thongtin = "Họ và tên:" + user.getHoten()
                    + "\n địa chỉ:" + user.getDiachi()
                    + "\n Căn cước công dân:" + user.getCccd();
//            userService.generateQRCodeImage(thongtin, 350, 350, QR_CODE_IMAGE_PATH);
            System.out.println(thongtin);
            System.out.println(user.getHoten());
            model.addAttribute("helloname", "Xin chào"+user.getHoten());
            return "redirect:menuhomepage";
        } else {
            model.addAttribute("thongbao", "Sai tên đăng nhập hoặc mật khẩu");
            return "Login";
        }
    }

    @PostMapping("/khaibaoyte")
    public String khaibaoyte(
            Model model,
            @RequestParam(value = "sdt", required = false) String sdt,
            @RequestParam(value = "dichuyen", required = false) String dichuyen,
            @RequestParam(value = "trieuchung", required = false) String trieuchung,
            @RequestParam(value = "nghinhiem", required = false) String nghinhiem,
            @RequestParam(value = "nuocbenh", required = false) String nuocbenh,
            @RequestParam(value = "bieuhien", required = false) String bieuhien
    )  {

        KhaiBao kb = new KhaiBao();
        kb.setDichuyen(dichuyen);
        kb.setTrieuchung(trieuchung);
        kb.setNghinhiem(nghinhiem);
        kb.setNuocbenh(nuocbenh);
        kb.setBieuhien(bieuhien);
        kb.setSdt(sdt);

        khaiBaoService.save(kb);
        model.addAttribute("image","QRCode.png");
//        return "redirect:menuhomepage";
        return"QRLayout";
    }

    @GetMapping("qr")
    public String ShowPageQR(Model model){
        model.addAttribute("image","QRCode.png");
        return "QRLayout";
    }
    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(UserService.getQRCodeImage(codeText, width, height));
    }
}
//



