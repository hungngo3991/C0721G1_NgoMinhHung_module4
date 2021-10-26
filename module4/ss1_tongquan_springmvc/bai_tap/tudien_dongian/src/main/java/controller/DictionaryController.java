package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String translate(Model model) {
        return "/dictionary";
    }

    @PostMapping("/dictionary")
    public String translate(@RequestParam(name = "inputWord") String word, Model model) {

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Music", "Âm nhạc");
        dictionary.put("Technology", "Công nghệ");
        dictionary.put("Movie", "Phim ảnh");
        String result = dictionary.get(word);

        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Not found!");
        }
        return "/dictionary";
    }
}
