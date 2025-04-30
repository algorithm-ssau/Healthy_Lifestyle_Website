
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE `health_lifestyle`.`user_workout_templates`;
TRUNCATE TABLE `health_lifestyle`.`user_meal_templates`;
TRUNCATE TABLE `health_lifestyle`.`physical_activity`;
TRUNCATE TABLE `health_lifestyle`.`water_intake`;
TRUNCATE TABLE `health_lifestyle`.`health_calculators`;
TRUNCATE TABLE `health_lifestyle`.`food_diary`;
TRUNCATE TABLE `health_lifestyle`.`workout_templates`;
TRUNCATE TABLE `health_lifestyle`.`meal_templates`;
TRUNCATE TABLE `health_lifestyle`.`client`;

SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO `health_lifestyle`.`client` (`username`, `email`, `password`, `date_of_birth`, `gender`, `height_cm`, `weight_kg`, `progress_data`, `profile_photo`) VALUES
('user1', 'user1@example.com', 'pass1234', '1990-01-01', 'male', 180, 75, '{"weight_progress": [75,74,73]}', NULL),
('user2', 'user2@example.com', 'pass1234', '1985-05-20', 'female', 165, 60, '{"weight_progress": [60,59,58]}', NULL),
('user3', 'user3@example.com', 'pass1234', '1992-07-15', 'male', 175, 68, NULL, NULL),
('user4', 'user4@example.com', 'pass1234', '1988-12-10', 'female', 170, 65, NULL, NULL),
('user5', 'user5@example.com', 'pass1234', '1995-03-05', 'male', 182, 80, NULL, NULL),
('user6', 'user6@example.com', 'pass1234', '1991-11-11', 'female', 160, 55, NULL, NULL),
('user7', 'user7@example.com', 'pass1234', '1987-06-25', 'male', 178, 72, NULL, NULL),
('user8', 'user8@example.com', 'pass1234', '1993-09-30', 'female', 168, 62, NULL, NULL),
('user9', 'user9@example.com', 'pass1234', '1994-04-17', 'male', 185, 85, NULL, NULL),
('user10', 'user10@example.com', 'pass1234', '1989-08-08', 'female', 162, 58, NULL, NULL);

INSERT INTO `health_lifestyle`.`food_diary` 
(`client_id`, `date`, `meal_time`, `food_items`, `total_calories`, `created_at`) VALUES
(1, '2025-04-20', 'breakfast', '[{"name":"Овсянка","amount":"100г"},{"name":"Яблоко","amount":"1шт"}]', 350, '2025-04-20 08:00:00'),
(2, '2025-04-20', 'lunch', '[{"name":"Курица","amount":"150г"},{"name":"Рис","amount":"200г"}]', 600, '2025-04-20 13:00:00'),
(3, '2025-04-21', 'dinner', '[{"name":"Рыба","amount":"200г"},{"name":"Овощи","amount":"150г"}]', 500, '2025-04-21 19:30:00'),
(4, '2025-04-21', 'snack', '[{"name":"Йогурт","amount":"150г"}]', 120, '2025-04-21 16:00:00'),
(5, '2025-04-22', 'breakfast', '[{"name":"Тост","amount":"2шт"},{"name":"Авокадо","amount":"50г"}]', 400, '2025-04-22 08:15:00'),
(6, '2025-04-22', 'lunch', '[{"name":"Салат","amount":"200г"}]', 250, '2025-04-22 12:45:00'),
(7, '2025-04-23', 'dinner', '[{"name":"Стейк","amount":"250г"},{"name":"Картофель","amount":"150г"}]', 700, '2025-04-23 19:00:00'),
(8, '2025-04-23', 'snack', '[{"name":"Орехи","amount":"30г"}]', 180, '2025-04-23 16:30:00'),
(9, '2025-04-24', 'breakfast', '[{"name":"Блины","amount":"3шт"},{"name":"Мёд","amount":"20г"}]', 450, '2025-04-24 08:00:00'),
(10, '2025-04-24', 'lunch', '[{"name":"Паста","amount":"200г"},{"name":"Соус","amount":"50г"}]', 550, '2025-04-24 13:00:00');


INSERT INTO `health_lifestyle`.`health_calculators` (`client_id`, `calculator_type`, `input_data`, `result_data`) VALUES
(1, 'bmi', '{"weight":75,"height":180}', '{"bmi":23.15}'),
(2, 'calories', '{"age":40,"weight":60,"height":165,"activity_level":"moderate"}', '{"calories":1800}'),
(3, 'water', '{"weight":68}', '{"water_liters":2.5}'),
(4, 'sleep', '{"hours":7}', '{"quality":"good"}'),
(5, 'calories_burned', '{"activity":"running","duration":30}', '{"calories_burned":300}'),
(6, 'bmi', '{"weight":55,"height":160}', '{"bmi":21.48}'),
(7, 'calories', '{"age":35,"weight":72,"height":178,"activity_level":"high"}', '{"calories":2200}'),
(8, 'water', '{"weight":62}', '{"water_liters":2.3}'),
(9, 'sleep', '{"hours":6}', '{"quality":"average"}'),
(10,'calories_burned', '{"activity":"cycling","duration":45}', '{"calories_burned":400}');


INSERT INTO `health_lifestyle`.`meal_templates` (`meal_type`, `calories`, `diet_type`, `ingredients`) VALUES
('breakfast', 350, 'standard', '[{"name": "Овсянка", "amount": "100г"}, {"name": "Яблоко", "amount": "1шт"}]'),
('lunch', 600, 'standard', '[{"name": "Курица", "amount": "150г"}, {"name": "Рис", "amount": "200г"}]'),
('dinner', 500, 'vegetarian', '[{"name": "Рыба", "amount": "200г"}, {"name": "Овощи", "amount": "150г"}]'),
('snack', 120, 'vegan', '[{"name": "Йогурт соевый", "amount": "150г"}]'),
('breakfast', 400, 'keto', '[{"name": "Тост", "amount": "2шт"}, {"name": "Авокадо", "amount": "50г"}]'),
('lunch', 250, 'vegetarian', '[{"name": "Салат", "amount": "200г"}]'),
('dinner', 700, 'standard', '[{"name": "Стейк", "amount": "250г"}, {"name": "Картофель", "amount": "150г"}]'),
('snack', 180, 'keto', '[{"name": "Орехи", "amount": "30г"}]'),
('breakfast', 450, 'standard', '[{"name": "Блины", "amount": "3шт"}, {"name": "Мёд", "amount": "20г"}]'),
('lunch', 550, 'vegetarian', '[{"name": "Паста", "amount": "200г"}, {"name": "Соус", "amount": "50г"}]');


INSERT INTO `health_lifestyle`.`physical_activity` (`client_id`, `activity_type`, `duration_minutes`, `calories_burned`, `activity_date`) VALUES
(1, 'Бег', 30, 300, '2025-04-20'),
(2, 'Йога', 45, 150, '2025-04-20'),
(3, 'Плавание', 60, 500, '2025-04-21'),
(4, 'Велоспорт', 40, 400, '2025-04-21'),
(5, 'Силовые тренировки', 50, 450, '2025-04-22'),
(6, 'Прогулка', 60, 200, '2025-04-22'),
(7, 'Танцы', 30, 250, '2025-04-23'),
(8, 'Пилатес', 45, 180, '2025-04-23'),
(9, 'Бокс', 30, 350, '2025-04-24'),
(10,'Фитнес', 60, 400, '2025-04-24');


INSERT INTO `health_lifestyle`.`user_meal_templates` (`client_id`, `meal_templates_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);


INSERT INTO `health_lifestyle`.`workout_templates` (`goal`, `level`, `equipment`, `name`, `exercises`, `duration_minutes`) VALUES
('weight_loss', 'beginner', 'none', 'Программа для начинающих', '[{"name": "Приседания", "sets": 3, "reps": 12}, {"name": "Отжимания", "sets": 3, "reps": 10}]', 45),
('weight_gain', 'intermediate', 'dumbbells', 'Набор массы', '[{"name": "Жим гантелей", "sets": 4, "reps": 8}, {"name": "Тяга гантелей", "sets": 4, "reps": 10}]', 60),
('improved_endurance', 'advanced', 'full_gym', 'Выносливость', '[{"name": "Бег на дорожке", "sets": 1, "reps": 30}]', 30),
('increased_strength_and_power', 'beginner', 'pull_up_bar', 'Сила и мощь', '[{"name": "Подтягивания", "sets": 3, "reps": 8}]', 40),
('development_of _lexibility_and_mobility', 'intermediate', 'none', 'Гибкость', '[{"name": "Растяжка", "sets": 1, "reps": 20}]', 30),
('improvement_of_health', 'advanced', 'none', 'Общее здоровье', '[{"name": "Йога", "sets": 1, "reps": 60}]', 60),
('weight_loss', 'intermediate', 'dumbbells', 'Сжигание жира', '[{"name": "Махи гантелями", "sets": 3, "reps": 15}]', 45),
('weight_gain', 'advanced', 'full_gym', 'Масса PRO', '[{"name": "Жим лежа", "sets": 4, "reps": 6}]', 60),
('improved_endurance', 'beginner', 'none', 'Кардио для новичков', '[{"name": "Бег", "sets": 1, "reps": 20}]', 20),
('increased_strength_and_power', 'intermediate', 'pull_up_bar', 'Сила PRO', '[{"name": "Подтягивания", "sets": 4, "reps": 10}]', 50);


INSERT INTO `health_lifestyle`.`user_workout_templates` (`workout_templates_id`, `client_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);


INSERT INTO `health_lifestyle`.`water_intake` (`client_id`, `date`, `amount_ml`) VALUES
(1, '2025-04-20', 2000),
(2, '2025-04-20', 1800),
(3, '2025-04-21', 2200),
(4, '2025-04-21', 2100),
(5, '2025-04-22', 1900),
(6, '2025-04-22', 2000),
(7, '2025-04-23', 2300),
(8, '2025-04-23', 1800),
(9, '2025-04-24', 2100),
(10,'2025-04-24', 2000);