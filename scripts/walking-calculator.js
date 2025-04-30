document.addEventListener('DOMContentLoaded', function () {
    const calculateBtn = document.getElementById('calculate');
    const weightInput = document.getElementById('weight');
    const distanceInput = document.getElementById('distance');
    const paceSelect = document.getElementById('pace');
    const terrainSelect = document.getElementById('terrain');
    const resultDiv = document.getElementById('result');

    calculateBtn.addEventListener('click', calculateCalories);

    function calculateCalories() {
        const weight = parseFloat(weightInput.value);
        const distance = parseFloat(distanceInput.value);
        const pace = paceSelect.value;
        const terrain = parseFloat(terrainSelect.value);

        if (isNaN(weight) || isNaN(distance) || weight <= 0 || distance <= 0) {
            alert('Пожалуйста, введите корректные значения веса и дистанции.');
            return;
        }

        // Коэффициент темпа (ккал/кг/км)
        let paceCoefficient;

        switch (pace) {
            case '2': // Медленный (3 км/ч)
                paceCoefficient = 0.6;
                break;
            case '3.5': // Средний (5 км/ч)
                paceCoefficient = 0.8;
                break;
            case '5': // Быстрый (7 км/ч)
                paceCoefficient = 1.0;
                break;
            case '7': // Очень быстрый (9 км/ч)
                paceCoefficient = 1.2;
                break;
            default:
                paceCoefficient = 0.8;
        }

        // Формула: вес × дистанция × коэффициент темпа × коэффициент местности
        const calories = weight * distance * paceCoefficient * terrain;
        const roundedCalories = Math.round(calories);

        resultDiv.innerHTML = `
            <p>При ходьбе вы сожжёте примерно: <strong>${roundedCalories} ккал</strong></p>
            <p class="tip">Это приблизительная оценка. Фактический расход зависит от метаболизма, возраста и других факторов.</p>
        `;
    }
});