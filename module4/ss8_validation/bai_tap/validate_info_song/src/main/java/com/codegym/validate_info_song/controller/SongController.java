package com.codegym.validate_info_song.controller;


import com.codegym.validate_info_song.model.Song;
import com.codegym.validate_info_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public ModelAndView listSong() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("songs", songService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song", new Song());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Song().validate(song, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "New song has been created successfully.");
            return "redirect:/song";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Song> song = songService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("song", song.get());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Song().validate(song, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/edit";
        } else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "The song has been updated successfully.");
            return "redirect:/song";
        }
    }


}
