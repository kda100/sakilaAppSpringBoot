package CucumberTests.StepDefs;

import com.Sakila.api.Sakilaapp.Category.Category;
import com.Sakila.api.Sakilaapp.Film.*;
import com.Sakila.api.Sakilaapp.Helpers.ModelMapperHelper;
import com.Sakila.api.Sakilaapp.Language.Language;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetFilmPageStepDefs {
    @MockBean
    private FilmRepository filmRepository;

    FilmService filmService;
    Long categoryId;
    int offset;
    int pageSize;

    private List<Film> filmsData;

    private Page<FilmDTO> page;

    FilmController filmController;

    public GetFilmPageStepDefs() {
        this.filmRepository = mock(FilmRepository.class);
        filmService = new FilmService(filmRepository, new ModelMapperHelper(new ModelMapper()));
        filmController = new FilmController(filmService);
    }
    @Given("Film data exists in a database")
    public void film_data_exists_in_a_database() {

        Category category1 = new Category("Horror");
        Category category2 = new Category("Comedy");

        final List<Film> films = new ArrayList<Film>();

        for(Long i=0l; i<10; i++) {
            final List<Category> categories = new ArrayList<Category>();
            if(i % 2 == 0) {
                categories.add(category1);
            } else {
                categories.add(category2);
            }
            final Film film = new Film(i, "Titanic", "A boat crashed", 2000, new Language("English"),10,10.99,
                    "15",
                    125, 100, categories);
            films.add(film);
        }
        filmsData = films;
    }
    @Given("There are no film filters enabled")
    public void there_are_no_film_filters_enabled() {
        categoryId = -1l;
    }
    @Given("the film page offset is small enough")
    public void the_film_page_offset_is_small_enough() {
        offset = 0;
    }
    @Given("The film page size is large enough")
    public void the_film_page_size_is_large_enough() {
        pageSize = 25;
    }
    @When("I make a request to fetch the film data")
    public void i_make_a_request_to_fetch_the_film_data() {
        when(filmRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                "id")))).thenReturn(new PageImpl<>(filmsData));
        page = filmController.getAllFilms(categoryId, "id", offset,pageSize);
    }
    @Then("A page of FilmDTO data is returned")
    public void a_page_of_film_dto_data_is_returned() {
        List<FilmDTO> filmDTOS = page.toList();
        assertEquals(filmsData.size(), filmDTOS.size());
        for(int i = 0; i < filmsData.size(); i++) {
            assertEquals(filmsData.get(i).getId(), filmDTOS.get(i).getId());
        }
    }
}
