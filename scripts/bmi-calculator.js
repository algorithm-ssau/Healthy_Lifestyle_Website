document.addEventListener('DOMContentLoaded', function () {
    const calculateBtn = document.getElementById('calculate');
    const heightInput = document.getElementById('height');
    const weightInput = document.getElementById('weight');
    const resultDiv = document.getElementById('result');
    const interpretationDiv = document.getElementById('interpretation');

    calculateBtn.addEventListener('click', calculateBMI);

    function calculateBMI() {
        const height = parseFloat(heightInput.value);
        const weight = parseFloat(weightInput.value);

        if (isNaN(height) || isNaN(weight) || height <= 0 || weight <= 0) {
            resultDiv.textContent = 'Пожалуйста, введите корректные значения роста и веса.';
            interpretationDiv.textContent = '';
            return;
        }

        // Формула ИМТ: вес (кг) / (рост (м))^2
        const heightInMeters = height / 100;
        const bmi = weight / (heightInMeters * heightInMeters);
        const roundedBMI = bmi.toFixed(1);

        resultDiv.textContent = `Ваш ИМТ: ${roundedBMI}`;

        // Интерпретация результата
        let interpretation = '';
        if (bmi < 18.5) {
            interpretation = 'Недостаточный вес. Рекомендуется проконсультироваться с врачом.';
        } else if (bmi >= 18.5 && bmi < 25) {
            interpretation = 'Нормальный вес. Продолжайте поддерживать здоровый образ жизни!';
        } else if (bmi >= 25 && bmi < 30) {
            interpretation = 'Избыточный вес. Рекомендуется увеличить физическую активность и пересмотреть питание.';
        } else {
            interpretation = 'Ожирение. Настоятельно рекомендуется проконсультироваться с врачом и диетологом.';
        }

        interpretationDiv.textContent = interpretation;
    }
});