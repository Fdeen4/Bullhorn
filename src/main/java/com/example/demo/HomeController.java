package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class HomeController {

    @Autowired
    RecipientRepository recipient;

    @Autowired
    MessageRepository messages;

    @RequestMapping("/")
    public String index(Model model)
    {

        model.addAttribute("messages",messages.findAll());
        model.addAttribute("recipient",recipient.findAll());
        return "message_board";
    }

    @RequestMapping("/addlist")
    public String addMessage(Model model)
    {
        model.addAttribute("aMessage", new Message());
        model.addAttribute("recipient",recipient.findAll());
        return "recipients";
    }

    @RequestMapping("/savecolor")
    public String saveMessage(@ModelAttribute("aMessage")Message message, Model model)
    {
        messages.save(message);
        return "redirect:/";
    }

    @PostConstruct
    public void fillTables()
    {
        Recipients p = new Recipients();
        p.setMyName("John Smith");
        recipient.save(p);

        p = new Recipients();
        p.setMyName("Owen Richards");
        recipient.save(p);

        p= new Recipients();
        p.setMyName("Ama Baidoo");
        recipient.save(p);
    }
}