package ro.unibuc.fmi.dietapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.unibuc.fmi.dietapp.mapper.*;

@Configuration
public class ProjectConfig {
    @Bean
    public DietGoalMapper diet_goalMapper() {
        return new DietGoalMapperImpl();
    }

    @Bean
    public DietPlanMapper diet_planMapper() {
        return new DietPlanMapperImpl();
    }

    @Bean
    public DietTypeMapper diet_typeMapper() {
        return new DietTypeMapperImpl();
    }

    @Bean
    public DietMapper dietMapper() {
        return new DietMapperImpl();
    }

    @Bean
    public FoodCategoryMapper foodCategoryMapper() {
        return  new FoodCategoryMapperImpl();
    }

    @Bean
    public FoodMapper foodMapper() {
        return new FoodMapperImpl();
    }
}
