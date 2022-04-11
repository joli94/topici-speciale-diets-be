package ro.unibuc.fmi.dietapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.unibuc.fmi.dietapp.model.Diet;
import ro.unibuc.fmi.dietapp.model.DietGoal;
import ro.unibuc.fmi.dietapp.model.DietType;
import ro.unibuc.fmi.dietapp.model.Ingredient;
import ro.unibuc.fmi.dietapp.repository.DietRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DietServiceTest {
    @Mock
    private DietRepository repository;

    @InjectMocks
    private DietService service;

    private Diet expected;

    @BeforeEach
    void setUp() {
        expected = Diet.builder()
                .id(1L)
                .name("Dieta fulger")
                .maximumCalories(1500L)
                .price(250L)
                .dietGoal(DietGoal.builder().id(1L).name("slabire").build())
                .dietType(DietType.builder().id(1L).name("proteic").build())
                .build();
    }

    @Test
    @DisplayName("Find all diets - happy flow")
    public void test_findAllDiets_happyFlow() {
        List<Diet> expectedList = new ArrayList<>();
        expectedList.add(expected);

        when(repository.findAll()).thenReturn(expectedList);

        List<Diet> result = service.findAll();

        assertEquals(expectedList.size(), result.size());
        assertEquals(expected.getId(), result.stream().findFirst().get().getId());
        assertEquals(expected.getName(), result.stream().findFirst().get().getName());
        assertEquals(expected.getMaximumCalories(), result.stream().findFirst().get().getMaximumCalories());
        assertEquals(expected.getPrice(), result.stream().findFirst().get().getPrice());
        assertEquals(expected.getDietGoal(), result.stream().findFirst().get().getDietGoal());
        assertEquals(expected.getDietType(), result.stream().findFirst().get().getDietType());

        verify(repository).findAll();
    }
}