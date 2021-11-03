package controller;


import model.MForm;
import model.Music;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IMusicService;
import service.MusicServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")


public class MusicController {

    private final IMusicService musicService = new MusicServiceImpl();

    @Value("${file_upload}")
    private String fileUpload;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Music> musicList = musicService.showList();
        modelAndView.addObject("musicList", musicList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicForm", new MForm());
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("musicForm", musicService.findById(id));
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("music", musicService.findById(id));
        return modelAndView;
    }


    @PostMapping("/save")
    public String save(@ModelAttribute MForm mForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = mForm.getFilePath();
        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        String[] array = fileName.split("\\.");
        if (array[1].equals("mp3") || array[1].equals("wav") || array[1].equals("mp4")) {
            try {
                FileCopyUtils.copy(mForm.getFilePath().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Music music = new Music(mForm.getName(), mForm.getArtist(), mForm.getTypeOfMusic(), fileName);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Create music successful!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Create music error!");
        }
        return "redirect:/music";
    }

    @PostMapping("/update")
    public String update(MForm mForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = mForm.getFilePath();
        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        String[] array = fileName.split("\\.");
        if (array[1].equals("mp3") || array[1].equals("wav") || array[1].equals("mp4")) {
            try {
                FileCopyUtils.copy(mForm.getFilePath().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Music music = new Music(mForm.getId(), mForm.getName(), mForm.getArtist(), mForm.getTypeOfMusic(), fileName);
            musicService.update(music);
            redirectAttributes.addFlashAttribute("message", "Update music successful");
        } else {
            redirectAttributes.addFlashAttribute("message", "Update music error");
        }
        return "redirect:/music";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirectAttributes) {
        musicService.delete(music.getId());
        redirectAttributes.addFlashAttribute("message", "Delete music successful");
        return "redirect:/music";
    }


}
