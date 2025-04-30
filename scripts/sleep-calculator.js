document.addEventListener('DOMContentLoaded', function () {
    const calculateBtn = document.getElementById('calculate');
    const ageSelect = document.getElementById('age');
    const activitySelect = document.getElementById('activity');
    const stressSelect = document.getElementById('stress');
    const resultDiv = document.getElementById('result');

    calculateBtn.addEventListener('click', calculateSleep);

    function calculateSleep() {
        const ageGroup = ageSelect.value;
        const activity = parseFloat(activitySelect.value);
        const stress = parseFloat(stressSelect.value);

        // Базовые рекомендации по возрасту
        let baseSleep, minSleep, maxSleep;
        switch (ageGroup) {
            case '14-17':
                minSleep = 8;
                maxSleep = 10;
                break;
            case '18-25':
            case '26-64':
                minSleep = 7;
                maxSleep = 9;
                break;
            case '65+':
                minSleep = 7;
                maxSleep = 8;
                break;
        }

        // Корректировка на активность и стресс
        const recommendedMin = minSleep + activity + stress;
        const recommendedMax = maxSleep + activity + stress;

        resultDiv.innerHTML = `
            <p>Рекомендуемая норма сна для вашей возрастной группы: <strong>${minSleep}-${maxSleep} часов</strong></p>
            <p>С учетом вашего образа жизни рекомендуется: <strong>${recommendedMin.toFixed(1)}-${recommendedMax.toFixed(1)} часов</strong></p>
            <p class="tip">Попробуйте ложиться спать и просыпаться в одно и то же время каждый день для лучшего качества сна.</p>
        `;
    }
});