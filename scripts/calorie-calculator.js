document.addEventListener('DOMContentLoaded', function () {
    const calculateBtn = document.getElementById('calculate');
    const genderSelect = document.getElementById('gender');
    const ageInput = document.getElementById('age');
    const heightInput = document.getElementById('height');
    const weightInput = document.getElementById('weight');
    const activitySelect = document.getElementById('activity');
    const goalSelect = document.getElementById('goal');
    const bmrSpan = document.getElementById('bmr');
    const tdeeSpan = document.getElementById('tdee');
    const recommendedSpan = document.getElementById('recommended');

    calculateBtn.addEventListener('click', calculateCalories);

    function calculateCalories() {
        const gender = genderSelect.value;
        const age = parseFloat(ageInput.value);
        const height = parseFloat(heightInput.value);
        const weight = parseFloat(weightInput.value);
        const activity = parseFloat(activitySelect.value);
        const goal = goalSelect.value;

        if (isNaN(age) || isNaN(height) || isNaN(weight) || age <= 0 || height <= 0 || weight <= 0) {
            alert('Пожалуйста, введите корректные данные.');
            return;
        }

        // Формула Миффлина-Сан Жеора
        let bmr;
        if (gender === 'male') {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }

        const tdee = bmr * activity;

        let recommended;
        switch (goal) {
            case 'lose':
                recommended = tdee - 500;
                break;
            case 'gain':
                recommended = tdee + 500;
                break;
            default:
                recommended = tdee;
        }

        bmrSpan.textContent = Math.round(bmr) + ' ккал/день';
        tdeeSpan.textContent = Math.round(tdee) + ' ккал/день';

        if (goal === 'lose') {
            recommendedSpan.textContent = Math.round(recommended) + ' ккал/день (для похудения)';
        } else if (goal === 'gain') {
            recommendedSpan.textContent = Math.round(recommended) + ' ккал/день (для набора массы)';
        } else {
            recommendedSpan.textContent = Math.round(recommended) + ' ккал/день (для поддержания веса)';
        }
    }
});