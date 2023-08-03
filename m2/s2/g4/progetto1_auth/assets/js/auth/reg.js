document.getElementById('registrationForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const utente = {};
    formData.forEach((value, key) => {
        utente[key] = value;
    });

    fetch('http://localhost:8080/api/register', { 
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(utente)
    })
    .then(response => {
        if (response.ok) {
            alert('Registrazione avvenuta con successo.');
            window.location.href = '/login.html'; // Reindirizza alla pagina di login dopo la registrazione
        } else {
            alert('Errore durante la registrazione.');
        }
    })
    .catch(error => {
        alert('Si è verificato un errore. Riprova più tardi.');
    });
});