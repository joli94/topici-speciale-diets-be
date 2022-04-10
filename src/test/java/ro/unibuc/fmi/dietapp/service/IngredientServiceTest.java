package ro.unibuc.fmi.dietapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.unibuc.fmi.dietapp.model.Ingredient;
import ro.unibuc.fmi.dietapp.repository.IngredientRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class IngredientServiceTest {
    @Mock
    private IngredientRepository repository;

    @Mock
    private FoodIngredientsService foodIngredientsService;

    @InjectMocks
    private IngredientService service;

    private Ingredient expected;

    @BeforeEach
    void setUp() {
    }
}