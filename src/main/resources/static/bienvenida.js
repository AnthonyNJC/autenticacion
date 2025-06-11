    const token = localStorage.getItem("token");

    if (!token) {
      alert("No tienes acceso");
      window.location.href = "/index.html";
    }

    function cerrarSesion() {
      localStorage.removeItem("token");
      window.location.href = "/index.html";
    }
