package stud.kea.lbh.goatsite.IntegrationTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import stud.kea.lbh.goatsite.model.Goat;
import stud.kea.lbh.goatsite.repository.GoatRepository;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GoatRepositoryIntegrationTests {

    @Autowired
    GoatRepository goatRepository;

    @Test
    public void canGetAllGoats(){
        Iterable<Goat> goats = goatRepository.findAll();
    }

    @Test
    public void canCreateAndGetGoat(){
        //create a goat
        Goat goat = new Goat();
        goat.setName("Oliver");
        goat.setDob(new Date());

        //Insert into H2 DB
        goatRepository.save(goat);

        //get goat by name
        // Goat found = goatRepository.findByName("Oliver");

        //assert that we found the goat by its name
        // assertThat(found.getName()).isEqualTo(found.getName());
    }
}
