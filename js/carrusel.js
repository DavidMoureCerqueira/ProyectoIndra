let indice = 0;
const carrusel = document.getElementById('carrusel');
const total = carrusel.children.length;
const contenedor = document.querySelector('.carrusel-container');

function moverCarrusel(direccion) {
  const ancho = contenedor.clientWidth;
  indice = (indice + direccion + total) % total;
  carrusel.style.transform = `translateX(-${indice * ancho}px)`;
}

// Avance automático cada 4 segundos
setInterval(() => {
  moverCarrusel(1);
}, 4000);

