document.addEventListener('DOMContentLoaded', function () {
    const typeFilter = document.getElementById('type-filter');
    const levelFilter = document.getElementById('level-filter');
    const workoutCards = document.querySelectorAll('.workout-card');

    function filterWorkouts() {
        const selectedType = typeFilter.value;
        const selectedLevel = levelFilter.value;

        workoutCards.forEach(card => {
            const cardType = card.getAttribute('data-type');
            const cardLevel = card.getAttribute('data-level');

            const typeMatch = selectedType === 'all' || cardType === selectedType;
            const levelMatch = selectedLevel === 'all' || cardLevel === selectedLevel;

            if (typeMatch && levelMatch) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    }

    typeFilter.addEventListener('change', filterWorkouts);
    levelFilter.addEventListener('change', filterWorkouts);
});