package ro.unibuc.fmi.dietapp.service;

import org.springframework.stereotype.Service;
import ro.unibuc.fmi.dietapp.model.Ingredient;
import ro.unibuc.fmi.dietapp.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final FoodIngredientsService foodIngredientsService;

    public IngredientService(IngredientRepository ingredientRepository, FoodIngredientsService foodIngredientsService) {
        this.ingredientRepository = ingredientRepository;
        this.foodIngredientsService = foodIngredientsService;
    }

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }
}
