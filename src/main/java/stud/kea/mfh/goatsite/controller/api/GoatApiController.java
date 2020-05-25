package stud.kea.mfh.goatsite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.kea.lbh.goatsite.model.Gender;
import stud.kea.lbh.goatsite.model.Goat;
import stud.kea.lbh.goatsite.repository.GoatRepository;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class GoatApiController {

    @Autowired
    private GoatRepository goatRepository;
    
    @GetMapping("/goats")
    public Iterable<Goat> viewGoatList(){
        return goatRepository.findAll();
    }

    @PostMapping("/goats")
    public Goat createGoat(@Valid @RequestBody Goat goat){
        return goatRepository.save(goat);
    }

    @GetMapping("goats/findIdByUsername")
    public long findIdByUserName(String userName) {
        return goatRepository.findGoatByUsername(userName).getId();
    }

    @GetMapping("goats/findPasswordByUsername")
    public String getPasswordByUsername(String username) {
        return goatRepository.findGoatByUsername(username).getPassword();
    }

    @GetMapping("goats/findbygender")
    public Iterable<Goat> getGoatByGender(@RequestParam(value = "gender") Gender gender){
        return goatRepository.findByGender(gender);
    }

    @GetMapping("/goats/{id}")
    public Goat findGoat(@PathVariable long id){
        /*
        Optional goatOrNull = goatRepository.findById(id);
        if(goatOrNull.isPresent()){
            return goatOrNull.get();
        }
        return "404 - goat not found";
        */

        return goatRepository.findById(id).orElse(null);
    }

    // todo jeg vil gerne sende en ? til alle med id under ?
    @GetMapping("/goats/oldtimers")
    public Iterable<Goat> getOldTimers(){
        return goatRepository.findTheOldTimers();
    }
    @PostMapping(value = "/createnewprofile")
    public String createGoatProfile(@ModelAttribute Goat goat){
        System.out.println("TEst");
        goatRepository.save(goat);

        System.out.println(goat.getName());
        return "redirect:/";
    }
/*
    @PostMapping("/updateprofile")
    public Goat updateGoat(@Valid @RequestBody Goat goat){
        return goatRepository.save(goat);
    }
*/







}
