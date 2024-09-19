// app.js

// Funció per carregar els partits
function carregarPartits() {
    axios.get('http://localhost:8080/api/partidos')
        .then(function (response) {
            const partidos = response.data;
            let partidosHtml = '';

            partidos.forEach(partido => {
                partidosHtml += `
                    <div class="card mt-3">
                        <div class="card-body">
                            <h5 class="card-title">Partit: ${partido.id}</h5>
                            <p class="card-text">Data: ${partido.fecha}</p>
                            <p class="card-text">Lloc: ${partido.lugar}</p>
                            <button class="btn btn-success" onclick="registrarJugador(${partido.id})">Registrar-se</button>
                        </div>
                    </div>`;
            });

            document.getElementById('partidos-list').innerHTML = partidosHtml;
        })
        .catch(function (error) {
            console.log(error);
        });
}

// Funció per registrar un jugador en un partit
function registrarJugador(partidoId) {
    axios.post(`http://localhost:8080/api/partidos/${partidoId}/inscripcion`)
        .then(function (response) {
            alert('T\'has registrat correctament!');
            carregarPartits(); // Actualitzar la llista de partits
        })
        .catch(function (error) {
            console.log(error);
            alert('Hi ha hagut un error en registrar-se.');
        });
}

// Carregar partits quan la pàgina es carregui
document.addEventListener('DOMContentLoaded', carregarPartits);
