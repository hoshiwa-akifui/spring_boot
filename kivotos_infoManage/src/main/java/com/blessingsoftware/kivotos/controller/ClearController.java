package com.blessingsoftware.kivotos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ClearController {

    @PostMapping("clearMsg")
    public void clearMsg(HttpSession session) {
        session.removeAttribute("msg");
    }
}
