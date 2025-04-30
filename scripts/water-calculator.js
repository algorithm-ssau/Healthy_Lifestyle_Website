document.addEventListener('DOMContentLoaded', function () {
    const calculateBtn = document.getElementById('calculate');
    const weightInput = document.getElementById('weight');
    const activitySelect = document.getElementById('activity');
    const climateSelect = document.getElementById('climate');
    const resultDiv = document.getElementById('result');

    calculateBtn.addEventListener('click', calculateWater);

    function calculateWater() {
        const weight = parseFloat(weightInput.value);
        const activity = parseFloat(activitySelect.value);
        const climate = parseFloat(climateSelect.value);

        if (isNaN(weight) || weight <= 0) {
            alert('Пожалуйста, введите корректный вес.');
            return;
        }

        // Формула: вес * коэффициент активности * коэффициент климата
        const waterAmount = weight * activity * climate;
        const roundedAmount = Math.round(waterAmount);

        resultDiv.innerHTML = `
            <p>Ваша рекомендуемая норма воды: <strong>${roundedAmount} мл</strong> в день</p>
            <p>Это примерно <strong>${Math.round(roundedAmount / 250)} стаканов</strong> (по 250 мл)</p>
            <p class="tip">Помните, что около 20% воды мы получаем из пищи, поэтому можно выпивать на 20% меньше.</p>
        `;
    }
});