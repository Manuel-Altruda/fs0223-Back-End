document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const credentials = {};
    formData.forEach((value, key) => {
        credentials[key] = value;
    });

    fetch('http://localhost:8080/api/login', { 
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
    })
    .then(response => {
        if (response.ok) {
            response.json().then(data => {
                // Salva il token JWT ricevuto nella sessione o nei cookie e reindirizza all'area riservata
                alert('Login avvenuto con successo.');
                window.location.href = '/dashboard.html';
            });
        } else {
            alert('Credenziali non valide. Riprova.');
        }
    })
    .catch(error => {
        alert('Si è verificato un errore. Riprova più tardi.');
    });
});