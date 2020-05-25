package stud.kea.mfh.goatsite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import stud.kea.lbh.goatsite.model.Like;
import stud.kea.lbh.goatsite.repository.LikeRepository;

import javax.validation.Valid;

@RestController
public class LikeApiController {

    @Autowired
    private LikeRepository likesRepository;

    // todo lav et match
    @PostMapping("api/goats/likes")
    public Like makeLiker(@Valid @RequestBody Like likes){
        return likesRepository.save(likes);
    }

}
