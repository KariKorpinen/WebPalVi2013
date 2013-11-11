/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.library.service.LibraryService;
/**
 *
 * @author kkkorpin
 */
@Controller
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "libraries", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("libraries", libraryService.list());
        return "libraries";
    }

    @RequestMapping(value = "libraries", method = RequestMethod.POST)
    public String add(@RequestParam String name, @RequestParam Integer lengthInMinutes) {
        libraryService.add(name, lengthInMinutes);
        return "redirect:/app/libraries";
    }

    @RequestMapping(value = "libraries/{libraryId}/delete", method = RequestMethod.POST)
    public String add(@PathVariable(value = "libraryId") Long libraryId) {
        libraryService.remove(libraryId);
        return "redirect:/app/libraries";
    }
}
    

