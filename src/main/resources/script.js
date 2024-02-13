function loadGetMsg() {
            let nameVar = document.getElementById("name").value;
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function() {
                try {
                    const response = JSON.parse(this.responseText);
                    const table = createTable(response);
                    document.getElementById("getrespmsg").innerHTML = table;
                } catch (error) {
                    document.getElementById("getrespmsg").innerHTML = this.responseText;
                }
            };
            xhttp.open("GET", "/Film?title=" + nameVar);
            xhttp.send();
        }

        function createTable(data) {
            let tableHTML = '<table>';
            for (const key in data) {
                if (data.hasOwnProperty(key)) {
                    if (key === 'Poster' && typeof data[key] === 'string') {
                        // Si la llave es 'Poster' y el valor es una cadena, crea una etiqueta de imagen
                        tableHTML += `<tr><th>${key}</th><td><img src='${data[key]}' alt='Poster' style='max-width:100%;'></td></tr>`;
                    } else if (Array.isArray(data[key])) {
                        // Handle arrays (e.g., Ratings)
                        tableHTML += `<tr><th>${key}</th><td>${createTable(data[key])}</td></tr>`;
                    } else if (typeof data[key] === 'object') {
                        // Handle nested objects
                        tableHTML += `<tr><th>${key}</th><td>${createTable(data[key])}</td></tr>`;
                    } else {
                        // Handle regular key-value pairs
                        tableHTML += `<tr><th>${key}</th><td>${data[key]}</td></tr>`;
                    }
                }
            }
            tableHTML += '</table>';
            return tableHTML;
        }