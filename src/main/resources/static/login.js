    const form = document.getElementById("loginForm");
    form.addEventListener("submit", async (e) => {
      e.preventDefault();

      const username = document.getElementById("username").value;
      const password = document.getElementById("password").value;

      const respuesta = await fetch("/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
      });

      if (respuesta.ok) {
        const data = await respuesta.json();
        localStorage.setItem("token", data.token);
        window.location.href = "/bienvenida.html"; // redirige a otra página
      } else {
        document.getElementById("mensaje").innerText = "Credenciales incorrectas";
      }
    });