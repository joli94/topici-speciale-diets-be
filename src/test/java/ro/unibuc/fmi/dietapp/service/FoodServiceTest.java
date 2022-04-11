package ro.unibuc.fmi.dietapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.unibuc.fmi.dietapp.exception.EntityNotFoundException;
import ro.unibuc.fmi.dietapp.model.Food;
import ro.unibuc.fmi.dietapp.model.FoodCategory;
import ro.unibuc.fmi.dietapp.model.Ingredient;
import ro.unibuc.fmi.dietapp.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {
    @Mock
    private FoodRepository repository;

    @Mock
    private DietPlanService dietPlanService;

    @InjectMocks
    private FoodService service;

    private Food expected;

    @BeforeEach
    void setUp() {
        expected = Food.builder()
                .id(1L)
                .name("pastrav la gratar")
                .calories(150L)
                .foodCategory(FoodCategory.builder().id(1L).name("lunch").build())
                .build();
    }

    @Test
    @DisplayName("Find all foods - happy flow")
    public void test_findAllFoods_happyFlow() {
        List<Food> foodList = new ArrayList<>();
        foodList.add(expected);

        when(repository.findAll()).thenReturn(foodList);

        List<Food> result = service.findAll();

        assertEquals(foodList.size(), result.size());
        assertEquals(expected.getId(), result.stream().findFirst().get().getId());
        assertEquals(expected.getName(), result.stream().findFirst().get().getName());
        assertEquals(expected.getCalories(), result.stream().findFirst().get().getCalories());
        assertEquals(expected.getFoodCategory(), result.stream().findFirst().get().getFoodCategory());

        verify(repository).findAll();
    }

    @Test
    @DisplayName("Find a food by id - happy flow")
    public void test_findFoodById_happyFlow() {
        Long id = expected.getId();

        when(repository.findById(id)).thenReturn(Optional.of(expected));

        Food result = service.findById(id);

        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getName(), result.getName());
        assertEquals(expected.getCalories(), result.getCalories());
        assertEquals(expected.getFoodCategory(), result.getFoodCategory());

        verify(repository).findById(id);
    }


}