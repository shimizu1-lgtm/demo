package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository repository;

    // 一覧画面の表示
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", repository.findAll());
        return "index";
    }

    // 新規商品の登録
    @PostMapping("/add")
    public String add(@RequestParam String name, @RequestParam int stock) {
        Item item = new Item();
        item.setName(name);
        item.setStock(stock);
        repository.save(item);
        return "redirect:/";
    }

    // 入庫（+1）
    @PostMapping("/in/{id}")
    public String stockIn(@PathVariable Long id) {
        Item item = repository.findById(id).orElseThrow();
        item.setStock(item.getStock() + 1);
        repository.save(item);
        return "redirect:/";
    }

    // 出庫（-1）
    @PostMapping("/out/{id}")
    public String stockOut(@PathVariable Long id) {
        Item item = repository.findById(id).orElseThrow();
        if (item.getStock() > 0) {
            item.setStock(item.getStock() - 1);
            repository.save(item);
        }
        return "redirect:/";
    }

    // 削除
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}