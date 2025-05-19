package com.example.healthlifestyle.models;/*package com.example.healthlifestyle.models;

import java.util.List;
import java.util.Map;

public class MealConstants {
    public static final Map<String, List<String>> BREAKFASTS = Map.of(
            "none", List.of("Омлет с овощами и тостами", "Гречневая каша с молоком", "Творог с фруктами"),
            "vegetarian", List.of("Тофу-скрэмбл с авокадо", "Овсянка с орехами и медом", "Смузи из фруктов и йогурта"),
            "vegan", List.of("Чиа-пудинг с ягодами", "Тосты с авокадо", "Овсянка на растительном молоке"),
            "gluten-free", List.of("Яичница с овощами", "Гречневая каша с фруктами", "Творог с орехами"),
            "lactose-free", List.of("Омлет с овощами", "Каша на воде с сухофруктами", "Безлактозный йогурт с ягодами")
    );

    public static final Map<String, List<String>> LUNCHES = Map.of(
            "none", List.of("Куриная грудка с гречкой", "Рыба с овощами", "Стейк с картофелем"),
            "vegetarian", List.of("Чечевичный суп", "Фалафель с хумусом", "Овощное рагу с тофу"),
            "vegan", List.of("Суп из чечевицы", "Бургеры из нута", "Карри из овощей и тофу"),
            "gluten-free", List.of("Куриное филе с рисом", "Рыба с картофелем", "Салат с киноа"),
            "lactose-free", List.of("Суп с курицей и овощами", "Лосось с брокколи", "Говядина с тыквой")
    );

    public static final Map<String, List<String>> DINNERS = Map.of(
            "none", List.of("Творог с зеленью", "Рыба на пару с брокколи", "Куриное филе с салатом"),
            "vegetarian", List.of("Овощная запеканка", "Салат с киноа", "Тыквенный суп-пюре"),
            "vegan", List.of("Салат из нута", "Овощное рагу", "Тофу с овощами"),
            "gluten-free", List.of("Яйца пашот с авокадо", "Рыба с овощами", "Курица с салатом"),
            "lactose-free", List.of("Омлет с овощами", "Рыба с рисом", "Куриное филе с овощами")
    );

    public static final Map<String, List<String>> DRINKS = Map.of(
            "none", List.of("Чай", "Кофе", "Компот", "Сок"),
            "vegetarian", List.of("Чай", "Кофе", "Свежевыжатый сок"),
            "vegan", List.of("Чай", "Кофе с соевым молоком", "Смузи"),
            "gluten-free", List.of("Чай", "Кофе", "Морс"),
            "lactose-free", List.of("Чай", "Кофе с миндальным молоком", "Компот")
    );
}*/
import java.util.*;

public class MealConstants {
    // Карта с базовыми значениями КБЖУ для каждого блюда (белки, углеводы, жиры, калории)
    public static final Map<String, Map<String, int[]>> MEAL_NUTRITION;

    static {
        Map<String, Map<String, int[]>> nutritionMap = new HashMap<>();

        // Завтраки
        Map<String, int[]> breakfasts = new HashMap<>();
        breakfasts.put("Омлет с овощами и тостами", new int[]{25, 30, 15, 355});
        breakfasts.put("Гречневая каша с молоком", new int[]{15, 50, 10, 350});
        breakfasts.put("Творог с фруктами", new int[]{25, 20, 5, 230});
        breakfasts.put("Тофу-скрэмбл с авокадо", new int[]{20, 15, 25, 340});
        breakfasts.put("Овсянка с орехами и медом", new int[]{15, 60, 20, 450});
        breakfasts.put("Смузи из фруктов и йогурта", new int[]{10, 40, 5, 240});
        breakfasts.put("Чиа-пудинг с ягодами", new int[]{10, 30, 15, 280});
        breakfasts.put("Тосты с авокадо", new int[]{10, 35, 25, 380});
        breakfasts.put("Овсянка на растительном молоке", new int[]{12, 55, 15, 370});
        breakfasts.put("Яичница с овощами", new int[]{25, 10, 15, 280});
        breakfasts.put("Гречневая каша с фруктами", new int[]{15, 45, 10, 320});
        breakfasts.put("Творог с орехами", new int[]{30, 15, 20, 350});
        breakfasts.put("Омлет с овощами", new int[]{25, 15, 20, 320});
        breakfasts.put("Каша на воде с сухофруктами", new int[]{10, 50, 5, 280});
        breakfasts.put("Безлактозный йогурт с ягодами", new int[]{15, 25, 5, 200});
        nutritionMap.put("Завтрак", breakfasts);

        // Обеды
        Map<String, int[]> lunches = new HashMap<>();
        lunches.put("Куриная грудка с гречкой", new int[]{40, 50, 15, 520});
        lunches.put("Рыба с овощами", new int[]{35, 20, 20, 400});
        lunches.put("Стейк с картофелем", new int[]{45, 60, 30, 690});
        lunches.put("Чечевичный суп", new int[]{25, 40, 10, 370});
        lunches.put("Фалафель с хумусом", new int[]{20, 45, 25, 480});
        lunches.put("Овощное рагу с тофу", new int[]{25, 30, 15, 370});
        lunches.put("Суп из чечевицы", new int[]{25, 35, 10, 330});
        lunches.put("Бургеры из нута", new int[]{20, 40, 20, 420});
        lunches.put("Карри из овощей и тофу", new int[]{25, 35, 20, 400});
        lunches.put("Куриное филе с рисом", new int[]{40, 55, 15, 520});
        lunches.put("Рыба с картофелем", new int[]{35, 50, 20, 500});
        lunches.put("Салат с киноа", new int[]{25, 40, 15, 400});
        lunches.put("Суп с курицей и овощами", new int[]{35, 30, 15, 400});
        lunches.put("Лосось с брокколи", new int[]{40, 15, 30, 470});
        lunches.put("Говядина с тыквой", new int[]{45, 25, 25, 490});
        nutritionMap.put("Обед", lunches);

        // Ужины
        Map<String, int[]> dinners = new HashMap<>();
        dinners.put("Творог с зеленью", new int[]{30, 10, 10, 250});
        dinners.put("Рыба на пару с брокколи", new int[]{35, 15, 15, 320});
        dinners.put("Куриное филе с салатом", new int[]{40, 10, 15, 310});
        dinners.put("Овощная запеканка", new int[]{20, 30, 15, 320});
        dinners.put("Салат с киноа", new int[]{25, 35, 15, 380});
        dinners.put("Тыквенный суп-пюре", new int[]{15, 25, 10, 230});
        dinners.put("Салат из нута", new int[]{25, 30, 15, 350});
        dinners.put("Овощное рагу", new int[]{15, 30, 10, 250});
        dinners.put("Тофу с овощами", new int[]{25, 20, 15, 300});
        dinners.put("Яйца пашот с авокадо", new int[]{25, 15, 30, 380});
        dinners.put("Рыба с овощами", new int[]{35, 15, 20, 350});
        dinners.put("Курица с салатом", new int[]{40, 10, 15, 290});
        dinners.put("Омлет с овощами", new int[]{30, 15, 25, 370});
        dinners.put("Рыба с рисом", new int[]{35, 40, 20, 480});
        dinners.put("Куриное филе с овощами", new int[]{40, 15, 15, 320});
        nutritionMap.put("Ужин", dinners);

        MEAL_NUTRITION = Collections.unmodifiableMap(nutritionMap);
    }

    // Остальные константы остаются без изменений
    public static final Map<String, List<String>> BREAKFASTS = Map.of(
            "none", List.of("Омлет с овощами и тостами", "Гречневая каша с молоком", "Творог с фруктами"),
            "vegetarian", List.of("Тофу-скрэмбл с авокадо", "Овсянка с орехами и медом", "Смузи из фруктов и йогурта"),
            "vegan", List.of("Чиа-пудинг с ягодами", "Тосты с авокадо", "Овсянка на растительном молоке"),
            "gluten-free", List.of("Яичница с овощами", "Гречневая каша с фруктами", "Творог с орехами"),
            "lactose-free", List.of("Омлет с овощами", "Каша на воде с сухофруктами", "Безлактозный йогурт с ягодами")
    );

    public static final Map<String, List<String>> LUNCHES = Map.of(
            "none", List.of("Куриная грудка с гречкой", "Рыба с овощами", "Стейк с картофелем"),
            "vegetarian", List.of("Чечевичный суп", "Фалафель с хумусом", "Овощное рагу с тофу"),
            "vegan", List.of("Суп из чечевицы", "Бургеры из нута", "Карри из овоцев и тофу"),
            "gluten-free", List.of("Куриное филе с рисом", "Рыба с картофелем", "Салат с киноа"),
            "lactose-free", List.of("Суп с курицей и овощами", "Лосось с брокколи", "Говядина с тыквой")
    );

    public static final Map<String, List<String>> DINNERS = Map.of(
            "none", List.of("Творог с зеленью", "Рыба на пару с брокколи", "Куриное филе с салатом"),
            "vegetarian", List.of("Овощная запеканка", "Салат с киноа", "Тыквенный суп-пюре"),
            "vegan", List.of("Салат из нута", "Овощное рагу", "Тофу с овощами"),
            "gluten-free", List.of("Яйца пашот с авокадо", "Рыба с овощами", "Курица с салатом"),
            "lactose-free", List.of("Омлет с овощами", "Рыба с рисом", "Куриное филе с овощами")
    );

    public static final Map<String, List<String>> DRINKS = Map.of(
            "none", List.of("Чай", "Кофе", "Компот", "Сок"),
            "vegetarian", List.of("Чай", "Кофе", "Свежевыжатый сок"),
            "vegan", List.of("Чай", "Кофе с соевым молоком", "Смузи"),
            "gluten-free", List.of("Чай", "Кофе", "Морс"),
            "lactose-free", List.of("Чай", "Кофе с миндальным молоком", "Компот")
    );
}
